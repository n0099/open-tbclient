package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ubc.Flow;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerEmptyFlow implements IUbcFlow {
    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void cancelFlow() {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void createFlow() {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void endSlot(String str) {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    @Nullable
    public Flow getFlow() {
        return null;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public String getFlowType() {
        return IUbcFlow.TYPE_EMPTY_FLOW;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void resetFlow() {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void startSlot(String str, JSONObject jSONObject) {
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void uploadFlow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
    }
}
