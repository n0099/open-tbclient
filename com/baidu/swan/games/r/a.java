package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.games.bdtls.b.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public <T> void c(String str, String str2, ResponseCallback<T> responseCallback) {
        if (DEBUG) {
            Log.d("requestWithUrlAndBody", "url:" + str + "\nbody:" + str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.swan.games.bdtls.c.aUj().isEnable() && com.baidu.swan.games.bdtls.c.aUj().wa(str)) {
                b(str, str2, responseCallback);
                return;
            }
            com.baidu.swan.a.c.a.bbY().postStringRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.axv().aiy()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
        }
    }
}
