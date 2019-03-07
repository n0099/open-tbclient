package com.baidu.swan.apps.b.c;

import android.view.View;
import android.widget.AbsoluteLayout;
/* loaded from: classes2.dex */
public interface d extends com.baidu.swan.apps.core.container.a {
    boolean canGoBack();

    AbsoluteLayout getCurrentWebView();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    View wb();

    void z(int i, int i2);
}
