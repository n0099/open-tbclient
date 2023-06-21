package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.a02;
import com.baidu.tieba.n12;
import com.baidu.tieba.z32;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public n12 requestApi;

    public SwanApiNetworkV8Module(@NonNull a02 a02Var) {
        this.requestApi = new n12(a02Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        z32 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
