package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.tieba.j12;
import com.baidu.tieba.v32;
import com.baidu.tieba.wz1;
@Keep
/* loaded from: classes4.dex */
public class SwanApiNetworkV8Module {
    public static final String MODULE_NAME = "_naV8Network";
    public j12 requestApi;

    public SwanApiNetworkV8Module(@NonNull wz1 wz1Var) {
        this.requestApi = new j12(wz1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        v32 T2 = this.requestApi.T(jsObject);
        if (T2 == null) {
            return "";
        }
        return T2.a();
    }
}
