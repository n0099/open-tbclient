package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerSpeedDurationFlow implements IUbcFlow {
    public Flow mFlow;
    public final UBCManager mUBCService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void cancelFlow() {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void endSlot(String str) {
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
    public void createFlow() {
        this.mFlow = this.mUBCService.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SPEED_DURATION);
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    @Nullable
    public Flow getFlow() {
        return this.mFlow;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void uploadFlow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        try {
            String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject2);
            if (this.mFlow != null) {
                this.mUBCService.flowSetValue(this.mFlow, ubcContent);
                this.mUBCService.flowEnd(this.mFlow);
                this.mFlow = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
