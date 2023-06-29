package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.c42;
import com.baidu.tieba.d02;
import com.baidu.tieba.q12;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public q12 requestApi;

    public SwanApiNetworkV8Module(@NonNull d02 d02Var) {
        this.requestApi = new q12(d02Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        c42 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
