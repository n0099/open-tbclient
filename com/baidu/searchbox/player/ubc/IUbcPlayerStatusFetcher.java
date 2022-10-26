package com.baidu.searchbox.player.ubc;
/* loaded from: classes2.dex */
public interface IUbcPlayerStatusFetcher {
    int getCurrentPosition();

    String getKernelLogId();

    float getLaunchSpeedScore();

    int getPlayType();

    String getPlayUrl();

    String getSessionId();

    float getStaticDeviceScore();

    String getTraceId();
}
