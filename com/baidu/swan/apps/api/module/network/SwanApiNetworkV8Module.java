package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.az1;
import com.baidu.tieba.m12;
import com.baidu.tieba.nx1;
@Keep
/* loaded from: classes3.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public az1 requestApi;

    public SwanApiNetworkV8Module(@NonNull nx1 nx1Var) {
        this.requestApi = new az1(nx1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        m12 T = this.requestApi.T(jsObject);
        if (T == null) {
            return "";
        }
        return T.a();
    }
}
