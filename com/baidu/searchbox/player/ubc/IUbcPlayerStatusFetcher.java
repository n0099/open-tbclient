package com.baidu.searchbox.player.ubc;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public interface IUbcPlayerStatusFetcher {
    int getCurrentPosition();

    @Nullable
    String getKernelLogId();

    float getLaunchSpeedScore();

    int getPlayType();

    @Nullable
    String getPlayUrl();

    @Nullable
    String getSessionId();

    float getStaticDeviceScore();

    @Nullable
    String getTraceId();
}
