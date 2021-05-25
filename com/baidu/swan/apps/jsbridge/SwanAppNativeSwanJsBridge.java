package com.baidu.swan.apps.jsbridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import d.a.l0.a.d1.b.b;
import d.a.l0.a.h0.f.a;
import d.a.l0.a.k;
import d.a.l0.a.l0.d;
import d.a.l0.a.v2.j;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class SwanAppNativeSwanJsBridge {
    public static final boolean DEBUG = k.f43199a;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public a mJSContainer;

    public SwanAppNativeSwanJsBridge(a aVar) {
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        if (DEBUG) {
            return d.a.l0.a.u1.a.a.p() ? j.d(i2, false) : "";
        }
        String d2 = j.d(i2, false);
        if (TextUtils.isEmpty(d2)) {
            if (!DEBUG) {
                d.a.l0.a.v2.a.c(j.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i2), d2, Boolean.TRUE)));
            } else {
                j.g();
                throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i2), d2));
            }
        } else {
            d.a.l0.a.v2.a.d();
        }
        return d2;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return b.a(this.mJSContainer);
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        JSONObject jSONObject = new JSONObject();
        d.K0(jSONObject);
        d.a.l0.a.e0.d.h(TAG, "getNACanIUseMap - " + jSONObject.toString());
        return jSONObject.toString();
    }
}
