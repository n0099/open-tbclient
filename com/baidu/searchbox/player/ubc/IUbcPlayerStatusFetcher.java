package com.baidu.searchbox.player.ubc;

import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public interface IUbcPlayerStatusFetcher {
    int getCurrentPosition();

    float getLaunchSpeedScore();

    int getPlayType();

    float getStaticDeviceScore();

    void setKernelExternalInfo(@Nullable HashMap<String, String> hashMap);
}
