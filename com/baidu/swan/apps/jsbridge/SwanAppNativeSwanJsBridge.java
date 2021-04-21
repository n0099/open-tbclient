package com.baidu.swan.apps.jsbridge;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.b.h0.a.e0.k.a;
import d.b.h0.a.i2.i;
import d.b.h0.a.k;
import d.b.h0.a.x0.b.b;
@Keep
/* loaded from: classes2.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = k.f45772a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public a mJSContainer;

    public SwanAppNativeSwanJsBridge(a aVar) {
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? d.b.h0.a.m1.a.a.n() ? i.d(i, false) : "" : !i.h() ? "" : i.d(i, false);
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return b.a(this.mJSContainer);
    }
}
