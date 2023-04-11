package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.ix1;
import com.baidu.tieba.uz1;
import com.baidu.tieba.vv1;
@Keep
/* loaded from: classes3.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public ix1 requestApi;

    public SwanApiNetworkV8Module(@NonNull vv1 vv1Var) {
        this.requestApi = new ix1(vv1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        uz1 T = this.requestApi.T(jsObject);
        if (T == null) {
            return "";
        }
        return T.a();
    }
}
