package com.baidu.mobads.sdk.api;
/* loaded from: classes7.dex */
public interface SplashAdListener {
    void onADLoaded(RsplashType rsplashType, int i2);

    void onAdClick();

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();
}
