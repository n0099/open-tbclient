package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.ly1;
import com.baidu.tieba.mu1;
import com.baidu.tieba.zv1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public zv1 requestApi;

    public SwanApiNetworkV8Module(@NonNull mu1 mu1Var) {
        this.requestApi = new zv1(mu1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        ly1 U = this.requestApi.U(jsObject);
        if (U == null) {
            return "";
        }
        return U.a();
    }
}
