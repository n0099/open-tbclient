package com.baidu.mobads;
/* loaded from: classes3.dex */
public interface InterstitialAdListener {
    void onAdClick(InterstitialAd interstitialAd);

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();

    void onAdReady();
}
