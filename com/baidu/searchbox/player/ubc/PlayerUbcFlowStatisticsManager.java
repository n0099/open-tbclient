package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerUbcFlowStatisticsManager {
    public boolean mIsShowFirstFrame;
    public long mStartLoadingTime;
    public final HashMap<String, IUbcFlow> mFlowFetchers = new HashMap<>();
    public BDVideoPlayerUbcContent mUbcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    public float currentSpeed = 1.0f;

    public void onPlayerPause() {
    }

    public void onPlayerResume() {
    }

    private void upSpeedDurationFlow() {
        if (this.currentSpeed != 1.0f) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", this.currentSpeed);
                getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).uploadFlow(this.mUbcContent, null, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onPlayerStart() {
        this.mIsShowFirstFrame = false;
    }

    public void removeFlow() {
        this.mFlowFetchers.clear();
    }

    public void addFlow(IUbcFlow iUbcFlow) {
        this.mFlowFetchers.put(iUbcFlow.getFlowType(), iUbcFlow);
    }

    @NonNull
    public IUbcFlow getFlow(String str) {
        IUbcFlow iUbcFlow = this.mFlowFetchers.get(str);
        if (iUbcFlow == null) {
            return new PlayerEmptyFlow();
        }
        return iUbcFlow;
    }

    public void onPlayerEnd(int i) {
        this.mIsShowFirstFrame = false;
        upSpeedDurationFlow();
    }

    public void onPlayerStop(int i) {
        this.mIsShowFirstFrame = false;
        upSpeedDurationFlow();
    }

    public void setVideoPlayerUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        this.mUbcContent = bDVideoPlayerUbcContent;
    }

    public void switchPlayerSpeed(float f) {
        upSpeedDurationFlow();
        if (f != 1.0f) {
            getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
        }
        this.currentSpeed = f;
    }

    public void goBackOrForeground(boolean z, int i) {
        if (z) {
            if (this.currentSpeed != 1.0f) {
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
            if (this.currentSpeed != 1.0f) {
                getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
            }
        }
    }
}
