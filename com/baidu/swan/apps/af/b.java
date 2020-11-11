package com.baidu.swan.apps.af;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.pms.c.e;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.swan.apps.af.a aVar);
    }

    public static void a(final a aVar) {
        com.baidu.swan.a.c.a.baK().getRequest().url(e.processUrl(com.baidu.swan.apps.t.a.awM().ahy())).addUrlParam("appkey", d.aHq().getAppId()).addUrlParam("swan_core_ver", com.baidu.swan.apps.swancore.b.a(f.azO().azq(), d.aHq().afE())).addUrlParam("swan_game_ver", com.baidu.swan.apps.swancore.b.kF(1)).addUrlParam("uid", com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA())).cookieManager(com.baidu.swan.config.c.aOO().axR()).build().executeAsync(new ResponseCallback<com.baidu.swan.apps.af.a>() { // from class: com.baidu.swan.apps.af.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.swan.apps.af.a parseResponse(Response response, int i) throws Exception {
                JSONObject optJSONObject;
                if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                    return null;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
                }
                return com.baidu.swan.apps.af.a.bx(optJSONObject);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.swan.apps.af.a aVar2, int i) {
                if (a.this != null) {
                    if (aVar2 == null) {
                        a.this.a(null);
                    } else {
                        a.this.a(aVar2);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (a.this != null) {
                    a.this.a(null);
                }
            }
        });
    }
}
