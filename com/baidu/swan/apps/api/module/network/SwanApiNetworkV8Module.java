package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.ev1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.rt1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public ev1 requestApi;

    public SwanApiNetworkV8Module(@NonNull rt1 rt1Var) {
        this.requestApi = new ev1(rt1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        qx1 U = this.requestApi.U(jsObject);
        if (U == null) {
            return "";
        }
        return U.a();
    }
}
