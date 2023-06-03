package com.baidu.searchbox.player.ubc;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.config.LoadingTimeConfig;
import com.baidu.searchbox.player.config.LoadingTimeConfigKt;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.DumediaUtils;
import com.baidu.searchbox.player.utils.ExtLogUtil;
import com.baidu.ubc.Flow;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CoreStatPlugin extends AbsPlugin {
    public static final String KEY_TYPE = "type";
    public static final String TAG = "CoreStatPlugin";
    public boolean mIsIgnoreScheme;
    public boolean mIsShowFirstFrame;
    public long mStartLoadingTime;
    public final UBCManager mUBCService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public BDVideoPlayerUbcContent mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    public final PlayerLoadingFlow mLoadingFlow = new PlayerLoadingFlow();
    public int mpdSelectType = 0;
    public int authSelectType = 0;
    public boolean isPlayFromLocalCache = false;
    public boolean isFirstCarlton = true;
    public boolean isFirstLoading = true;
    public boolean isVideoBuffering = false;
    public boolean isLoadingFlowCreate = false;
    public int loadingCount = 0;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public final Runnable loadingStartTask = new Runnable() { // from class: com.baidu.searchbox.player.ubc.CoreStatPlugin.1
        @Override // java.lang.Runnable
        public void run() {
            CoreStatPlugin.this.isLoadingFlowCreate = true;
            CoreStatPlugin.this.mLoadingFlow.createFlow();
            if (CoreStatPlugin.this.getBindPlayer() != null && CoreStatPlugin.this.getBindPlayer().getPlayerCallbackManager().getLoadingCallback() != null) {
                CoreStatPlugin.this.getBindPlayer().getPlayerCallbackManager().getLoadingCallback().onLoadingStart();
            }
        }
    };

    public boolean isUploadTailCarlton() {
        return false;
    }

    private void startLoadingMaybeDelayExecute(int i) {
        ExtLogUtil.logW(this, "startLoadingMaybeDelayExecute, delayTime = " + i);
        if (i < 0) {
            return;
        }
        this.handler.removeCallbacks(this.loadingStartTask);
        this.handler.postDelayed(this.loadingStartTask, i);
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        super.onVideoEventNotify(videoEvent);
        if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(videoEvent.getAction())) {
            this.loadingCount = 0;
        }
    }

    public void onPrebootStatUpload(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        BdVideoLog.d("【Statistics】 onPrebootStatUpload upload begin");
    }

    private void dispatchMonitorEvent(Flow flow, BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        if (flow != null && bDVideoPlayerUbcContent != null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ADD_PLAY_SPEED_RECORD);
            obtainEvent.putExtra(5, Long.valueOf(flow.getStartTime()));
            obtainEvent.putExtra(6, bDVideoPlayerUbcContent.getFrom());
            obtainEvent.putExtra(7, bDVideoPlayerUbcContent.getPage());
            obtainEvent.putExtra(17, bDVideoPlayerUbcContent.getSource());
            sendEvent(obtainEvent);
        }
    }

    private void endLoadingIfNeed() {
        if (getLoadingEnable()) {
            reportLoadingEnd();
        }
    }

    private String getEnv() {
        Activity activity;
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && (activity = bindPlayer.getActivity()) != null) {
            return bindPlayer.getPlayerStageType() + "." + activity.getClass().getSimpleName();
        }
        return null;
    }

    private boolean getLoadingEnable() {
        LoadingTimeConfig loadingTimeConfig = getLoadingTimeConfig();
        if (loadingTimeConfig == null) {
            return false;
        }
        return loadingTimeConfig.getEnable();
    }

    @Nullable
    private LoadingTimeConfig getLoadingTimeConfig() {
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer == null) {
            return null;
        }
        return LoadingTimeConfigKt.getLoadingTime(bindPlayer.getConfig());
    }

    private int getPlayingDelayTime() {
        LoadingTimeConfig loadingTimeConfig = getLoadingTimeConfig();
        if (loadingTimeConfig == null) {
            return -1;
        }
        return loadingTimeConfig.getDelayTimeByPlaying();
    }

    private int getStartDelayTime() {
        LoadingTimeConfig loadingTimeConfig = getLoadingTimeConfig();
        if (loadingTimeConfig == null) {
            return -1;
        }
        return loadingTimeConfig.getDelayTimeByStart();
    }

    private void onBufferEnd() {
        if (System.currentTimeMillis() - this.mStartLoadingTime >= 300) {
            reportLoadingEnd();
        }
    }

    private void onBufferStart() {
        this.mStartLoadingTime = System.currentTimeMillis();
        this.mLoadingFlow.createFlow();
    }

    private void startLoadIfNeed() {
        if (getLoadingEnable()) {
            startLoadingMaybeDelayExecute(getStartDelayTime());
        }
    }

    private void uploadCarltonStatIfNeed() {
        if (isUploadTailCarlton()) {
            if (this.isVideoBuffering) {
                onCarlton(getUploadUBCContent(), "");
            }
            if (this.isVideoBuffering || this.isLoadingFlowCreate) {
                if (getLoadingEnable()) {
                    reportLoadingEnd();
                } else {
                    onBufferEnd();
                }
            }
        }
    }

    public String getPlayerKey() {
        if (getBindPlayer() != null) {
            return getBindPlayer().getVideoUniqueKey();
        }
        return "";
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6, 4};
    }

    public BDVideoPlayerUbcContent getUploadUBCContent() {
        return this.mUBCContent;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.plugin.IPlugin
    public void onPluginRelease() {
        super.onPluginRelease();
        this.handler.removeCallbacksAndMessages(null);
    }

    private long getMsgChannelCost(@Nullable String str) {
        long parseLong;
        long j;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            parseLong = Long.parseLong(new JSONObject(str).optString("first_disp_notify_time"));
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("getMsgChannelCost时间：");
            sb.append(currentTimeMillis);
            sb.append("; firstDisplayNotifyTime = ");
            sb.append(parseLong);
            sb.append("; diff = ");
            j = currentTimeMillis - parseLong;
            sb.append(j);
            BdVideoLog.d(TAG, sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (parseLong <= 0) {
            return 0L;
        }
        return j;
    }

    private void onCarlton(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, String str) {
        String str2;
        BdVideoLog.d("【Statistics】 onCarlton upload begin");
        try {
            JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    extStatisticsLogClone.putOpt(next, jSONObject.optString(next));
                }
            }
            if (this.isFirstCarlton) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            extStatisticsLogClone.putOpt("isFirstStat", str2);
            this.isFirstCarlton = false;
            this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_CARLTON, BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onError(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, int i, String str) {
        BdVideoLog.d("【Statistics】 onError upload begin");
        try {
            JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
            extStatisticsLogClone.putOpt(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, Integer.valueOf(i));
            extStatisticsLogClone.putOpt("sub_errorNo", Integer.valueOf(i));
            extStatisticsLogClone.putOpt("errorInfo", str);
            this.mUBCService.onEvent("36", BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, (JSONObject) null));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void reportLoadingEnd() {
        String str;
        String str2;
        ExtLogUtil.logW(this, "reportLoadingEnd, mIsShowFirstFrame = " + this.mIsShowFirstFrame + ", isFirstLoading = " + this.isFirstLoading + ", isLoadingFlowCreate = " + this.isLoadingFlowCreate + ", loadCount = " + this.loadingCount);
        this.handler.removeCallbacks(this.loadingStartTask);
        if (!this.isLoadingFlowCreate) {
            return;
        }
        this.isLoadingFlowCreate = false;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.mIsShowFirstFrame) {
                str = "hasPlay";
            } else {
                str = "prepare";
            }
            jSONObject.put("type", str);
            JSONObject extStatisticsLogClone = this.mUBCContent.getExtStatisticsLogClone();
            if (this.isFirstLoading) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            extStatisticsLogClone.putOpt("isFirstStat", str2);
            extStatisticsLogClone.putOpt("reportedNum", Integer.valueOf(this.loadingCount));
            this.isFirstLoading = false;
            this.loadingCount++;
            this.mLoadingFlow.uploadFlow(this.mUBCContent, extStatisticsLogClone, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (getBindPlayer() != null && getBindPlayer().getPlayerCallbackManager().getLoadingCallback() != null) {
            getBindPlayer().getPlayerCallbackManager().getLoadingCallback().onLoadingEnd();
        }
    }

    private void updatePlayerServerMpd() {
        int i;
        JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
        String env = getEnv();
        try {
            if (!TextUtils.isEmpty(env)) {
                extStatisticsLog.put("env_tag", env);
            }
            if (!extStatisticsLog.has("player_server_mpd")) {
                extStatisticsLog.put("player_server_mpd", new JSONObject());
            }
            JSONObject optJSONObject = extStatisticsLog.optJSONObject("player_server_mpd");
            if (optJSONObject != null) {
                optJSONObject.put("type", this.mpdSelectType);
                optJSONObject.put("auth", this.authSelectType);
                if (this.mIsIgnoreScheme) {
                    i = 1;
                } else {
                    i = 0;
                }
                optJSONObject.put("ignoreScheme", i);
                extStatisticsLog.put("player_server_mpd", optJSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onFirstFrameDisPlay(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        String str;
        BdVideoLog.d("【Statistics】 onFirstFrameDisPlay upload begin");
        updatePlayerServerMpd();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", "first_frame");
            JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
            if (this.isPlayFromLocalCache) {
                str = "1";
            } else {
                str = "0";
            }
            extStatisticsLog.put("play_from_local", str);
            extStatisticsLog.putOpt("userTag", DumediaUtils.getUserTag());
            this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        super.onVideoEventNotify(videoEvent);
        String action = videoEvent.getAction();
        switch (action.hashCode()) {
            case -2127352417:
                if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1771982113:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -778203660:
                if (action.equals(StatisticsEvent.ACTION_ASYNC_REQUEST_CALLBACK)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -545382619:
                if (action.equals(StatisticsEvent.ACTION_BUFFER_START)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -525238599:
                if (action.equals(StatisticsEvent.ACTION_END_PREPARE_RESOURCE)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -192759714:
                if (action.equals(StatisticsEvent.ACTION_BUFFER_END)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -168110661:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_COMPLETE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 210672352:
                if (action.equals(StatisticsEvent.ACTION_AUTH_CALLBACK)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1399767189:
                if (action.equals(StatisticsEvent.ACTION_PLAY_FROM_LOCAL_CACHE)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 1537938041:
                if (action.equals("statistics_player_carlton")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1669151314:
                if (action.equals(StatisticsEvent.ACTION_START_PREPARE_RESOURCE)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 2082163910:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_ERROR)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2095136544:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_START)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2145795460:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.mUBCContent = (BDVideoPlayerUbcContent) videoEvent.getExtra(13);
                return;
            case 1:
                onCarlton(getUploadUBCContent(), videoEvent.getStringExtra(2));
                return;
            case 2:
                PlayerSpeedTracker.cancelTrack(getPlayerKey());
                String stringExtra = videoEvent.getStringExtra(2);
                onError(getUploadUBCContent(), videoEvent.getIntExtra(4), stringExtra);
                endLoadingIfNeed();
                return;
            case 3:
                this.mIsShowFirstFrame = false;
                this.isPlayFromLocalCache = false;
                uploadCarltonStatIfNeed();
                this.isFirstCarlton = true;
                this.isFirstLoading = true;
                this.isVideoBuffering = false;
                this.mLoadingFlow.cancelFlow();
                PlayerSpeedTracker.cancelTrack(getPlayerKey());
                return;
            case 4:
                this.mIsShowFirstFrame = false;
                this.mLoadingFlow.cancelFlow();
                return;
            case 5:
                this.isVideoBuffering = true;
                if (getLoadingEnable()) {
                    startLoadingMaybeDelayExecute(getPlayingDelayTime());
                    return;
                } else {
                    onBufferStart();
                    return;
                }
            case 6:
                this.isVideoBuffering = false;
                if (getLoadingEnable()) {
                    reportLoadingEnd();
                    return;
                } else {
                    onBufferEnd();
                    return;
                }
            case 7:
                this.mIsShowFirstFrame = false;
                PlayerSpeedTracker.endAfterInitToPlayPart(getPlayerKey());
                PlayerSpeedTracker.beginCallPlayerStart(getPlayerKey());
                startLoadIfNeed();
                return;
            case '\b':
                PlayerSpeedTracker.endPlayCore(getPlayerKey());
                this.mIsShowFirstFrame = true;
                String stringExtra2 = videoEvent.getStringExtra(2);
                onPrebootStatUpload(getUploadUBCContent());
                onFirstFrameDisPlay(getUploadUBCContent());
                Flow flow = FlowInstanceManager.getFlow(getPlayerKey());
                setKernelExternalInfo(flow);
                dispatchMonitorEvent(flow, getUploadUBCContent());
                endLoadingIfNeed();
                PlayerSpeedTracker.endTrack(getPlayerKey(), getUploadUBCContent(), stringExtra2, getMsgChannelCost(stringExtra2));
                return;
            case '\t':
                this.mIsIgnoreScheme = videoEvent.getBooleanExtra(15);
                this.mpdSelectType = videoEvent.getIntExtra(14);
                return;
            case '\n':
                this.authSelectType = videoEvent.getIntExtra(16);
                return;
            case 11:
                PlayerSpeedTracker.startPrepareResourcePart(getPlayerKey());
                return;
            case '\f':
                PlayerSpeedTracker.endPrepareResourcePart(getPlayerKey());
                return;
            case '\r':
                this.isPlayFromLocalCache = true;
                return;
            default:
                return;
        }
    }

    public void setKernelExternalInfo(@Nullable Flow flow) {
        if (flow != null && getBindPlayer() != null) {
            HashMap<String, Slot> slotMaps = flow.getSlotMaps();
            long startTime = flow.getStartTime();
            if (slotMaps != null && slotMaps.size() > 0) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, Slot> entry : slotMaps.entrySet()) {
                    String key = entry.getKey();
                    Slot value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        hashMap.put(key, String.valueOf(value.getEnd() - value.getStart()));
                    }
                }
                hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_FIRST_SCREEN));
                hashMap.put("click_time", String.valueOf(startTime));
                getBindPlayer().setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            }
        }
    }
}
