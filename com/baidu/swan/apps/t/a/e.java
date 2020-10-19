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
    public CookieManager atx() {
        return com.baidu.swan.apps.t.a.asF().adP();
    }

    @Override // com.baidu.swan.a.a
    public String getUserAgent() {
        return SwanAppNetworkUtils.ayo();
    }

    @Override // com.baidu.swan.a.a
    public int getConnectionTimeout() {
        b.a atD = atD();
        if (atD != null) {
            return atD.deZ;
        }
        return -1;
    }

    @Override // com.baidu.swan.a.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public int atC() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public void a(String str, HttpRequestBuilder httpRequestBuilder) {
        if (com.baidu.swan.apps.i.c.lI(str)) {
            httpRequestBuilder.setHeader("x-u-id", com.baidu.swan.uuid.b.dO(AppRuntime.getAppContext()).getUUID());
            try {
                httpRequestBuilder.setHeader("x-c2-id", com.baidu.swan.apps.t.a.ask().bq(AppRuntime.getAppContext()));
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

    private b.a atD() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "swanapp is null");
                return null;
            }
            return null;
        }
        SwanAppConfigData aDj = aDb.aDj();
        if (aDj == null || aDj.dfj == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                return null;
            }
            return null;
        }
        return aDj.dfj;
    }
}
