package com.baidu.swan.apps.jsbridge;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.h0.a.e0.k.a;
import d.a.h0.a.i2.i;
import d.a.h0.a.k;
import d.a.h0.a.x0.b.b;
@Keep
/* loaded from: classes2.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = k.f43101a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public a mJSContainer;

    public SwanAppNativeSwanJsBridge(a aVar) {
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        return DEBUG ? d.a.h0.a.m1.a.a.n() ? i.d(i2, false) : "" : !i.h() ? "" : i.d(i2, false);
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return b.a(this.mJSContainer);
    }
}
