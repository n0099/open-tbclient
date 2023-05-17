package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerLoadingFlow implements IUbcFlow {
    public Flow mFlow;
    public final UBCManager mUBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void endSlot(String str) {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public String getFlowType() {
        return IUbcFlow.TYPE_LOADING_FLOW;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void startSlot(String str, JSONObject jSONObject) {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void cancelFlow() {
        Flow flow = this.mFlow;
        if (flow != null) {
            this.mUBCManager.flowCancel(flow);
            this.mFlow = null;
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void createFlow() {
        this.mFlow = this.mUBCManager.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_LOADING);
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    @Nullable
    public Flow getFlow() {
        return this.mFlow;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void resetFlow() {
        Flow flow = this.mFlow;
        if (flow != null) {
            this.mUBCManager.flowEnd(flow);
            this.mFlow = null;
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void uploadFlow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        try {
            String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent.getExtStatisticsLogClone(), bDVideoPlayerUbcContent, jSONObject2);
            if (this.mFlow != null) {
                this.mUBCManager.flowSetValueWithDuration(this.mFlow, ubcContent);
                resetFlow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
