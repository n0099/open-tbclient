package com.baidu.mobads;
/* loaded from: classes5.dex */
public interface SplashAdListener {
    void onADLoaded(RsplashType rsplashType, int i);

    void onAdClick();

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();
}
