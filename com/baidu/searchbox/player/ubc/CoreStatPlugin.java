package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.ubc.Flow;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoreStatPlugin extends AbsPlugin {
    public static final String KEY_TYPE = "type";
    public static final String TAG = "CoreStatPlugin";
    public boolean mIsShowFirstFrame;
    public long mStartLoadingTime;
    public final UBCManager mUBCService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public BDVideoPlayerUbcContent mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    public final PlayerLoadingFlow mLoadingFlow = new PlayerLoadingFlow();

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private String getPlayerKey() {
        if (getBindPlayer() != null) {
            return getBindPlayer().getVideoUniqueKey();
        }
        return "";
    }

    private void onBufferEnd() {
        String str;
        if (System.currentTimeMillis() - this.mStartLoadingTime >= 300) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.mIsShowFirstFrame) {
                    str = "hasPlay";
                } else {
                    str = "prepare";
                }
                jSONObject.put("type", str);
                this.mLoadingFlow.uploadFlow(this.mUBCContent, null, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void onBufferStart() {
        this.mStartLoadingTime = System.currentTimeMillis();
        this.mLoadingFlow.createFlow();
    }

    public BDVideoPlayerUbcContent getUploadUBCContent() {
        return this.mUBCContent;
    }

    private void dispatchMonitorEvent(Flow flow, BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        if (flow != null && bDVideoPlayerUbcContent != null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ADD_PLAY_SPEED_RECORD);
            obtainEvent.putExtra(5, Long.valueOf(flow.getStartTime()));
            obtainEvent.putExtra(6, bDVideoPlayerUbcContent.getFrom());
            obtainEvent.putExtra(7, bDVideoPlayerUbcContent.getPage());
            sendEvent(obtainEvent);
        }
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
        if (!TextUtils.isEmpty(str)) {
            BdVideoLog.d("【Statistics】 onCarlton upload begin");
            try {
                JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    extStatisticsLogClone.putOpt(next, jSONObject.optString(next));
                }
                this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_CARLTON, BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
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

    public void onFirstFrameDisPlay(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        BdVideoLog.d("【Statistics】 onFirstFrameDisPlay upload begin");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", "first_frame");
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
            case -545382619:
                if (action.equals(StatisticsEvent.ACTION_BUFFER_START)) {
                    c = 5;
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
            case 1537938041:
                if (action.equals("statistics_player_carlton")) {
                    c = 1;
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
                return;
            case 3:
                this.mIsShowFirstFrame = false;
                this.mLoadingFlow.cancelFlow();
                PlayerSpeedTracker.cancelTrack(getPlayerKey());
                return;
            case 4:
                this.mIsShowFirstFrame = false;
                this.mLoadingFlow.cancelFlow();
                return;
            case 5:
                onBufferStart();
                return;
            case 6:
                onBufferEnd();
                return;
            case 7:
                this.mIsShowFirstFrame = false;
                PlayerSpeedTracker.endAfterInitToPlayPart(getPlayerKey());
                PlayerSpeedTracker.beginCallPlayerStart(getPlayerKey());
                return;
            case '\b':
                PlayerSpeedTracker.endPlayCore(getPlayerKey());
                this.mIsShowFirstFrame = true;
                String stringExtra2 = videoEvent.getStringExtra(2);
                onFirstFrameDisPlay(getUploadUBCContent());
                Flow flow = FlowInstanceManager.getFlow(getPlayerKey());
                setKernelExternalInfo(flow);
                dispatchMonitorEvent(flow, getUploadUBCContent());
                PlayerSpeedTracker.endTrack(getPlayerKey(), getUploadUBCContent(), stringExtra2, getMsgChannelCost(stringExtra2));
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
