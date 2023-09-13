package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.h32;
import com.baidu.tieba.iz1;
import com.baidu.tieba.v02;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public v02 requestApi;

    public SwanApiNetworkV8Module(@NonNull iz1 iz1Var) {
        this.requestApi = new v02(iz1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        h32 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
