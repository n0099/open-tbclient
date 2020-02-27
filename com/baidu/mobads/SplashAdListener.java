package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes10.dex */
public interface SplashAdListener {
    void onAdClick();

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdLoaded(HashMap hashMap);

    void onAdPresent();

    void onAdTypeReady(RsplashType rsplashType, int i);
}
