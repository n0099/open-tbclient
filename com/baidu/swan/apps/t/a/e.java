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
    public CookieManager axR() {
        return com.baidu.swan.apps.t.a.awZ().aij();
    }

    @Override // com.baidu.swan.a.a
    public String getUserAgent() {
        return SwanAppNetworkUtils.aCI();
    }

    @Override // com.baidu.swan.a.a
    public int getConnectionTimeout() {
        b.a axX = axX();
        if (axX != null) {
            return axX.dtw;
        }
        return -1;
    }

    @Override // com.baidu.swan.a.a
    public int getReadTimeout() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public int axW() {
        return 60000;
    }

    @Override // com.baidu.swan.a.a
    public void a(String str, HttpRequestBuilder httpRequestBuilder) {
        if (com.baidu.swan.apps.i.c.mq(str)) {
            httpRequestBuilder.setHeader("x-u-id", com.baidu.swan.uuid.b.dO(AppRuntime.getAppContext()).getUUID());
            try {
                httpRequestBuilder.setHeader("x-c2-id", com.baidu.swan.apps.t.a.awF().bq(AppRuntime.getAppContext()));
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

    private b.a axX() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "swanapp is null");
                return null;
            }
            return null;
        }
        SwanAppConfigData aHD = aHv.aHD();
        if (aHD == null || aHD.dtG == null) {
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                return null;
            }
            return null;
        }
        return aHD.dtG;
    }
}
