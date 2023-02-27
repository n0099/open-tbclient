package com.baidu.searchbox.player.ubc;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public class SimpleUbcPlayerStatusFetcher implements IUbcPlayerStatusFetcher {
    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public int getCurrentPosition() {
        return 0;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public String getKernelLogId() {
        return "";
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public float getLaunchSpeedScore() {
        return 0.0f;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public int getPlayType() {
        return 0;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    @Nullable
    public String getPlayUrl() {
        return "";
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public String getSessionId() {
        return "";
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public float getStaticDeviceScore() {
        return 0.0f;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    @Nullable
    public String getTraceId() {
        return "";
    }
}
