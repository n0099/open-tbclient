package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.iy1;
import com.baidu.tieba.ju1;
import com.baidu.tieba.wv1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public wv1 requestApi;

    public SwanApiNetworkV8Module(@NonNull ju1 ju1Var) {
        this.requestApi = new wv1(ju1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        iy1 U = this.requestApi.U(jsObject);
        if (U == null) {
            return "";
        }
        return U.a();
    }
}
