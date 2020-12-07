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
/* loaded from: classes25.dex */
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
    public CookieManager aAr() {
        return com.baidu.swan.apps.t.a.azz().akJ();
    }

    @Override // com.baidu.swan.a.a
    public String getUserAgent() {
        return SwanAppNetworkUtils.aFj();
    }

    @Override // com.baidu.swan.a.a
    public int aAw() {
        b.a aAy = aAy();
        if (aAy != null) {
            return aAy.dyO;
        }
        return -1;
    }

    @Override // com.baidu.swan.a.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public int aAx() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public void a(String str, HttpRequestBuilder httpRequestBuilder) {
        if (com.baidu.swan.apps.i.c.mR(str)) {
            httpRequestBuilder.setHeader("x-u-id", com.baidu.swan.uuid.b.et(AppRuntime.getAppContext()).getUUID());
            try {
                httpRequestBuilder.setHeader("x-c2-id", com.baidu.swan.apps.t.a.azf().bW(AppRuntime.getAppContext()));
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

    private b.a aAy() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "swanapp is null");
                return null;
            }
            return null;
        }
        SwanAppConfigData aKd = aJV.aKd();
        if (aKd == null || aKd.dyY == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                return null;
            }
            return null;
        }
        return aKd.dyY;
    }
}
