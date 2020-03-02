package com.baidu.swan.games.q;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.games.bdtls.b.a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public <T> void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (DEBUG) {
            Log.d("requestWithUrlAndBody", "url:" + str + "\nbody:" + str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.swan.games.bdtls.c.alH().ou(str)) {
                a(str, str2, responseCallback);
                return;
            }
            HttpManager.getDefault(AppRuntime.getAppContext()).postStringRequest().url(str).cookieManager(com.baidu.swan.apps.w.a.Uu().Iu()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
        }
    }
}
