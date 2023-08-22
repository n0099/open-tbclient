package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.d32;
import com.baidu.tieba.ez1;
import com.baidu.tieba.r02;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public r02 requestApi;

    public SwanApiNetworkV8Module(@NonNull ez1 ez1Var) {
        this.requestApi = new r02(ez1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        d32 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
