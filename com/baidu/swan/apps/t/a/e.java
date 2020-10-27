package com.baidu.swan.apps.t.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.config.b;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes10.dex */
public class e implements com.baidu.swan.a.a {
    @Override // com.baidu.swan.a.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.a.a
    public Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    @Override // com.baidu.swan.a.a
    public CookieManager avr() {
        return com.baidu.swan.apps.t.a.auz().afJ();
    }

    @Override // com.baidu.swan.a.a
    public String getUserAgent() {
        return SwanAppNetworkUtils.aAi();
    }

    @Override // com.baidu.swan.a.a
    public int getConnectionTimeout() {
        b.a avx = avx();
        if (avx != null) {
            return avx.dnz;
        }
        return -1;
    }

    @Override // com.baidu.swan.a.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public int avw() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public void a(String str, HttpRequestBuilder httpRequestBuilder) {
        if (com.baidu.swan.apps.i.c.mb(str)) {
            httpRequestBuilder.setHeader("x-u-id", com.baidu.swan.uuid.b.dO(AppRuntime.getAppContext()).getUUID());
            try {
                httpRequestBuilder.setHeader("x-c2-id", com.baidu.swan.apps.t.a.auf().bq(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    @Override // com.baidu.swan.a.a
    public List<Interceptor> networkInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.apps.network.a.c());
        return arrayList;
    }

    private b.a avx() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "swanapp is null");
                return null;
            }
            return null;
        }
        SwanAppConfigData aFd = aEV.aFd();
        if (aFd == null || aFd.dnJ == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                return null;
            }
            return null;
        }
        return aFd.dnJ;
    }
}
