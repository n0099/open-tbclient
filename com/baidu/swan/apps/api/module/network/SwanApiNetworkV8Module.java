package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.hy1;
import com.baidu.tieba.iu1;
import com.baidu.tieba.vv1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public vv1 requestApi;

    public SwanApiNetworkV8Module(@NonNull iu1 iu1Var) {
        this.requestApi = new vv1(iu1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        hy1 U = this.requestApi.U(jsObject);
        if (U == null) {
            return "";
        }
        return U.a();
    }
}
