package com.baidu.mobads.sdk.api;
/* loaded from: classes3.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdPresent();

    void onLpClosed();
}
