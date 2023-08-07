package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.m02;
import com.baidu.tieba.y22;
import com.baidu.tieba.zy1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public m02 requestApi;

    public SwanApiNetworkV8Module(@NonNull zy1 zy1Var) {
        this.requestApi = new m02(zy1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        y22 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
