package com.baidu.swan.apps.adaptation.b;

import android.view.View;
import android.widget.AbsoluteLayout;
/* loaded from: classes9.dex */
public interface d extends com.baidu.swan.apps.core.container.a {
    boolean canGoBack();

    View covertToView();

    void destroy();

    int getContentHeight();

    AbsoluteLayout getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void webViewScrollTo(int i, int i2);
}
