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
/* loaded from: classes7.dex */
public class e implements com.baidu.swan.b.a {
    @Override // com.baidu.swan.b.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.b.a
    public Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    @Override // com.baidu.swan.b.a
    public CookieManager aiv() {
        return com.baidu.swan.apps.t.a.ahH().Us();
    }

    @Override // com.baidu.swan.b.a
    public String getUserAgent() {
        return SwanAppNetworkUtils.amX();
    }

    @Override // com.baidu.swan.b.a
    public int getConnectionTimeout() {
        b.a aiB = aiB();
        if (aiB != null) {
            return aiB.cHO;
        }
        return -1;
    }

    @Override // com.baidu.swan.b.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // com.baidu.swan.b.a
    public int aiA() {
        return 60000;
    }

    @Override // com.baidu.swan.b.a
    public void a(String str, HttpRequestBuilder httpRequestBuilder) {
        if (com.baidu.swan.apps.h.c.jc(str)) {
            httpRequestBuilder.setHeader("x-u-id", com.baidu.swan.uuid.b.dD(AppRuntime.getAppContext()).getUUID());
            try {
                httpRequestBuilder.setHeader("x-c2-id", com.baidu.swan.apps.t.a.aho().bf(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    @Override // com.baidu.swan.b.a
    public List<Interceptor> networkInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.apps.network.a.c());
        return arrayList;
    }

    private b.a aiB() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "swanapp is null");
                return null;
            }
            return null;
        }
        SwanAppConfigData arE = arw.arE();
        if (arE == null || arE.cHY == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                return null;
            }
            return null;
        }
        return arE.cHY;
    }
}
