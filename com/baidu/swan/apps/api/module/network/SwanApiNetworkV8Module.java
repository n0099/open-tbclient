package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.lx1;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yv1;
@Keep
/* loaded from: classes3.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public lx1 requestApi;

    public SwanApiNetworkV8Module(@NonNull yv1 yv1Var) {
        this.requestApi = new lx1(yv1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        xz1 T = this.requestApi.T(jsObject);
        if (T == null) {
            return "";
        }
        return T.a();
    }
}
