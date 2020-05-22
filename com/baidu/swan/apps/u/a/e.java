package com.baidu.swan.apps.u.a;

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
/* loaded from: classes11.dex */
public class e implements com.baidu.swan.c.a {
    @Override // com.baidu.swan.c.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.c.a
    public Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    @Override // com.baidu.swan.c.a
    public CookieManager aga() {
        return com.baidu.swan.apps.u.a.afo().SM();
    }

    @Override // com.baidu.swan.c.a
    public String getUserAgent() {
        return SwanAppNetworkUtils.akB();
    }

    @Override // com.baidu.swan.c.a
    public int getConnectionTimeout() {
        b.a agg = agg();
        if (agg != null) {
            return agg.cAo;
        }
        return -1;
    }

    @Override // com.baidu.swan.c.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // com.baidu.swan.c.a
    public int agf() {
        return 60000;
    }

    @Override // com.baidu.swan.c.a
    public void a(String str, HttpRequestBuilder httpRequestBuilder) {
        if (com.baidu.swan.apps.h.c.iK(str)) {
            httpRequestBuilder.setHeader("x-u-id", com.baidu.swan.uuid.b.dy(AppRuntime.getAppContext()).getUUID());
            try {
                httpRequestBuilder.setHeader("x-c2-id", com.baidu.swan.apps.u.a.aeW().bc(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    @Override // com.baidu.swan.c.a
    public List<Interceptor> networkInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.swan.apps.network.a.c());
        return arrayList;
    }

    private b.a agg() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "swanapp is null");
                return null;
            }
            return null;
        }
        SwanAppConfigData aoO = aoG.aoO();
        if (aoO == null || aoO.cAy == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                return null;
            }
            return null;
        }
        return aoO.cAy;
    }
}
