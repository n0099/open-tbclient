package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.g32;
import com.baidu.tieba.hz1;
import com.baidu.tieba.u02;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public u02 requestApi;

    public SwanApiNetworkV8Module(@NonNull hz1 hz1Var) {
        this.requestApi = new u02(hz1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        g32 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
