package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public interface IUbcPlayerStatusFetcher {
    int getCurrentPosition();

    @Nullable
    String getKernelLogId();

    float getLaunchSpeedScore();

    @NonNull
    String getPlayErrorPart();

    int getPlayType();

    @Nullable
    String getPlayUrl();

    @Nullable
    String getSessionId();

    float getStaticDeviceScore();

    @Nullable
    String getTraceId();

    @NonNull
    String getVideoInfoEnterFlag();
}
