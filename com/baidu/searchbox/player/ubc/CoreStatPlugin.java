package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pyramid.runtime.service.ServiceManager;
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
/* loaded from: classes3.dex */
public class CoreStatPlugin extends AbsPlugin {
    public static final String KEY_TYPE = "type";
    public boolean mIsShowFirstFrame;
    public long mStartLoadingTime;
    public UBCManager mUBCService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public BDVideoPlayerUbcContent mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    public PlayerLoadingFlow mLoadingFlow = new PlayerLoadingFlow();

    private void dispatchMonitorEvent(Flow flow, BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        if (flow == null || bDVideoPlayerUbcContent == null) {
            return;
        }
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ADD_PLAY_SPEED_RECORD);
        obtainEvent.putExtra(5, Long.valueOf(flow.getStartTime()));
        obtainEvent.putExtra(6, bDVideoPlayerUbcContent.getFrom());
        obtainEvent.putExtra(7, bDVideoPlayerUbcContent.getPage());
        sendEvent(obtainEvent);
    }

    private String getPlayerKey() {
        return getBindPlayer() != null ? getBindPlayer().getVideoUniqueKey() : "";
    }

    private void onBufferEnd() {
        if (System.currentTimeMillis() - this.mStartLoadingTime >= 300) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", this.mIsShowFirstFrame ? "hasPlay" : "prepare");
                this.mLoadingFlow.uploadFlow(this.mUBCContent, null, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onBufferStart() {
        this.mStartLoadingTime = System.currentTimeMillis();
        this.mLoadingFlow.createFlow();
    }

    private void onCarlton(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void onError(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, int i, String str) {
        BdVideoLog.d("【Statistics】 onError upload begin");
        try {
            JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
            extStatisticsLogClone.putOpt("errorNo", Integer.valueOf(i));
            extStatisticsLogClone.putOpt("sub_errorNo", Integer.valueOf(i));
            extStatisticsLogClone.putOpt("errorInfo", str);
            this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, (JSONObject) null));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void setKernelExternalInfo(@Nullable Flow flow) {
        if (flow == null) {
            return;
        }
        HashMap<String, Slot> slotMaps = flow.getSlotMaps();
        long startTime = flow.getStartTime();
        if (slotMaps == null || slotMaps.size() <= 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, Slot> entry : slotMaps.entrySet()) {
            String key = entry.getKey();
            Slot value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                hashMap.put(key, String.valueOf(value.a() - value.c()));
            }
        }
        hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_FIRST_SCREEN));
        hashMap.put("click_time", String.valueOf(startTime));
        this.mUBCContent.getPlayerFetcher().setKernelExternalInfo(hashMap);
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    public void onFirstFrameDisPlay(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        BdVideoLog.d("【Statistics】 onFirstFrameDisPlay upload begin");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", "first_frame");
            this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        super.onVideoEventNotify(videoEvent);
        String action = videoEvent.getAction();
        switch (action.hashCode()) {
            case -1771982113:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -545382619:
                if (action.equals(StatisticsEvent.ACTION_BUFFER_START)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -192759714:
                if (action.equals(StatisticsEvent.ACTION_BUFFER_END)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -168110661:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_COMPLETE)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1537938041:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_CARLTON)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 2082163910:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_ERROR)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 2095136544:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_START)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 2145795460:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                onCarlton(this.mUBCContent, videoEvent.getStringExtra(2));
                return;
            case 1:
                PlayerSpeedTracker.cancelTrack(getPlayerKey());
                String stringExtra = videoEvent.getStringExtra(2);
                onError(this.mUBCContent, videoEvent.getIntExtra(4), stringExtra);
                return;
            case 2:
                this.mIsShowFirstFrame = false;
                this.mLoadingFlow.cancelFlow();
                PlayerSpeedTracker.cancelTrack(getPlayerKey());
                return;
            case 3:
                this.mIsShowFirstFrame = false;
                this.mLoadingFlow.cancelFlow();
                return;
            case 4:
                onBufferStart();
                return;
            case 5:
                onBufferEnd();
                return;
            case 6:
                this.mIsShowFirstFrame = false;
                PlayerSpeedTracker.endAfterInitToPlayPart(getPlayerKey());
                PlayerSpeedTracker.beginCallPlayerStart(getPlayerKey());
                return;
            case 7:
                PlayerSpeedTracker.endPlayCore(getPlayerKey());
                this.mIsShowFirstFrame = true;
                String stringExtra2 = videoEvent.getStringExtra(2);
                onFirstFrameDisPlay(this.mUBCContent);
                Flow flow = FlowInstanceManager.getFlow(getPlayerKey());
                setKernelExternalInfo(flow);
                dispatchMonitorEvent(flow, this.mUBCContent);
                PlayerSpeedTracker.endTrack(getPlayerKey(), this.mUBCContent, stringExtra2);
                return;
            default:
                return;
        }
    }
}
