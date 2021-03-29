package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PlayerUbcFlowStatisticsManager {
    public boolean mIsShowFirstFrame;
    public long mStartLoadingTime;
    public HashMap<String, IUbcFlow> mFlowFetchers = new HashMap<>();
    public BDVideoPlayerUbcContent mUbcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    private void upSpeedDurationFlow() {
        if (BDVideoPlayerUbcHelper.sPlayerCurrentSpreed != 1.0f) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", BDVideoPlayerUbcHelper.sPlayerCurrentSpreed);
                getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).uploadFlow(this.mUbcContent, null, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void addFlow(IUbcFlow iUbcFlow) {
        this.mFlowFetchers.put(iUbcFlow.getFlowType(), iUbcFlow);
    }

    @NonNull
    public IUbcFlow getFlow(String str) {
        IUbcFlow iUbcFlow = this.mFlowFetchers.get(str);
        return iUbcFlow == null ? new PlayerEmptyFlow() : iUbcFlow;
    }

    public void goBackOrForeground(boolean z, int i) {
        if (z) {
            if (BDVideoPlayerUbcHelper.sPlayerCurrentSpreed != 1.0f) {
                getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
                return;
            }
            return;
        }
        upSpeedDurationFlow();
    }

    public void onInfo(int i, int i2, Object obj) {
        if (i == 904 || i == 956) {
            this.mIsShowFirstFrame = true;
            if (BDVideoPlayerUbcHelper.sPlayerCurrentSpreed != 1.0f) {
                getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
            }
        }
    }

    public void onPlayerEnd(int i) {
        this.mIsShowFirstFrame = false;
        upSpeedDurationFlow();
    }

    public void onPlayerPause() {
    }

    public void onPlayerResume() {
    }

    public void onPlayerStart() {
        this.mIsShowFirstFrame = false;
    }

    public void onPlayerStop(int i) {
        this.mIsShowFirstFrame = false;
        upSpeedDurationFlow();
    }

    public void removeFlow() {
        this.mFlowFetchers.clear();
    }

    public void setVideoPlayerUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        this.mUbcContent = bDVideoPlayerUbcContent;
    }

    public void switchPlayerSpeed(float f2) {
        upSpeedDurationFlow();
        if (f2 != 1.0f) {
            getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
        }
    }
}
