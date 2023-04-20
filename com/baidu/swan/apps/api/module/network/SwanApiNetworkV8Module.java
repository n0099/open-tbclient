package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.jx1;
import com.baidu.tieba.vz1;
import com.baidu.tieba.wv1;
@Keep
/* loaded from: classes3.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public jx1 requestApi;

    public SwanApiNetworkV8Module(@NonNull wv1 wv1Var) {
        this.requestApi = new jx1(wv1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        vz1 T = this.requestApi.T(jsObject);
        if (T == null) {
            return "";
        }
        return T.a();
    }
}
