package com.baidu.swan.apps.b.c;

import android.view.View;
import android.widget.AbsoluteLayout;
/* loaded from: classes2.dex */
public interface d extends com.baidu.swan.apps.core.container.a {
    View Cq();

    void G(int i, int i2);

    boolean canGoBack();

    int getContentHeight();

    AbsoluteLayout getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();
}
