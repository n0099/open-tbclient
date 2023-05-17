package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.g12;
import com.baidu.tieba.hx1;
import com.baidu.tieba.uy1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public uy1 requestApi;

    public SwanApiNetworkV8Module(@NonNull hx1 hx1Var) {
        this.requestApi = new uy1(hx1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        g12 T = this.requestApi.T(jsObject);
        if (T == null) {
            return "";
        }
        return T.a();
    }
}
