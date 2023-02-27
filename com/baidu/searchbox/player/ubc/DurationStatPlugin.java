package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.ubc.Flow;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DurationStatPlugin extends AbsPlugin {
    public static final int DURATION_SLOT_DIFF_MIN = 500;
    public static final UBCManager UBC_MANAGER = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public Flow mFlow;
    public BDVideoPlayerUbcContent mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    public int durationSlotIndex = 1;

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private boolean isNeedFilter() {
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && !bindPlayer.isStop() && !bindPlayer.isComplete() && !bindPlayer.isIdle()) {
            return false;
        }
        return true;
    }

    private void startDurationSlot() {
        Flow flow = this.mFlow;
        if (flow == null) {
            return;
        }
        UBCManager uBCManager = UBC_MANAGER;
        uBCManager.flowStartSlot(flow, "PlayerDurationPause_P" + this.durationSlotIndex, null);
    }

    public void createFlow() {
        if (isNeedFilter()) {
            return;
        }
        this.mFlow = UBC_MANAGER.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_DURATION);
    }

    private void uploadDurationFlow(boolean z) {
        int i;
        uploadDurationSlot();
        try {
            JSONObject extStatisticsLogClone = this.mUBCContent.getExtStatisticsLogClone();
            extStatisticsLogClone.putOpt("image", this.mUBCContent.getPoster());
            int i2 = 0;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            extStatisticsLogClone.putOpt("closeReason", Integer.valueOf(i));
            if (getBindPlayer() != null) {
                i2 = getBindPlayer().getLoopCount();
            }
            extStatisticsLogClone.putOpt("cycleCount", Integer.valueOf(i2 + 1));
            extStatisticsLogClone.putOpt("clarity", this.mUBCContent.getClarityKey());
            extStatisticsLogClone.putOpt("selectedType", Integer.valueOf(this.mUBCContent.getSelectType()));
            String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, this.mUBCContent, (JSONObject) null);
            if (this.mFlow != null) {
                UBC_MANAGER.flowSetValueWithDuration(this.mFlow, ubcContent);
                UBC_MANAGER.flowEnd(this.mFlow);
                this.mFlow = null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.durationSlotIndex = 1;
    }

    private void uploadDurationSlot() {
        HashMap<String, Slot> slotMaps;
        Flow flow = this.mFlow;
        if (flow != null && (slotMaps = flow.getSlotMaps()) != null) {
            Slot slot = slotMaps.get("PlayerDurationPause_P" + this.durationSlotIndex);
            if (slot != null && slot.getStart() > 0 && System.currentTimeMillis() - slot.getStart() > 500) {
                UBCManager uBCManager = UBC_MANAGER;
                Flow flow2 = this.mFlow;
                uBCManager.flowEndSlot(flow2, "PlayerDurationPause_P" + this.durationSlotIndex);
                this.durationSlotIndex = this.durationSlotIndex + 1;
            }
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
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1385549725:
                if (action.equals(StatisticsEvent.ACTION_BACK_OR_FOREGROUND)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -168110661:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_COMPLETE)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 482780463:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_RESUME)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2091819188:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_PAUSE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2145795460:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c = 4;
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
                createFlow();
                return;
            case 2:
                uploadDurationSlot();
                return;
            case 3:
                startDurationSlot();
                return;
            case 4:
                uploadDurationFlow(true);
                return;
            case 5:
                uploadDurationFlow(false);
                return;
            case 6:
                if (videoEvent.getBooleanExtra(8)) {
                    createFlow();
                    return;
                } else {
                    uploadDurationFlow(false);
                    return;
                }
            default:
                return;
        }
    }
}
