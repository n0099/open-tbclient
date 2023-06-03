package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.m12;
import com.baidu.tieba.y32;
import com.baidu.tieba.zz1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public m12 requestApi;

    public SwanApiNetworkV8Module(@NonNull zz1 zz1Var) {
        this.requestApi = new m12(zz1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        y32 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
