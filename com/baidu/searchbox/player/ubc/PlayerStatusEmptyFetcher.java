package com.baidu.searchbox.player.ubc;

import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class PlayerStatusEmptyFetcher implements IUbcPlayerStatusFetcher {
    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public int getCurrentPosition() {
        return 0;
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
    public float getStaticDeviceScore() {
        return 0.0f;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
    public void setKernelExternalInfo(@Nullable HashMap<String, String> hashMap) {
    }
}
