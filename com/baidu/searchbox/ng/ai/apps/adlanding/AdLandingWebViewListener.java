package com.baidu.searchbox.ng.ai.apps.adlanding;

import com.baidu.browser.sailor.BdSailorWebView;
/* loaded from: classes2.dex */
public interface AdLandingWebViewListener {
    void goBack();

    void onPageStarted();

    void onReceivedTitle(String str);

    boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str);
}
