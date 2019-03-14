package com.baidu.swan.games.n;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected static final String bey = com.baidu.swan.apps.ae.b.Ji();

    public <T> void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (DEBUG) {
            Log.d("requestWithUrlAndBody", "url:" + str + "\nbody:" + str2);
        }
        if (!TextUtils.isEmpty(str)) {
            HttpManager.getDefault(AppRuntime.getAppContext()).postStringRequest().url(str).cookieManager(com.baidu.swan.apps.u.a.CV().Dt()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
        }
    }
}
