package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PlayerSpeedDurationFlow implements IUbcFlow {
    public Flow mFlow;

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void cancelFlow() {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void createFlow() {
        this.mFlow = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SPEED_DURATION);
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void endSlot(String str) {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    @Nullable
    public Flow getFlow() {
        return this.mFlow;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public String getFlowType() {
        return IUbcFlow.TYPE_SPEED_DURATION_FLOW;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void resetFlow() {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void startSlot(String str, JSONObject jSONObject) {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void uploadFlow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        try {
            String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject2);
            if (this.mFlow != null) {
                this.mFlow.setValueWithDuration(ubcContent);
                this.mFlow.end();
                this.mFlow = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
