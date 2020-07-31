package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.pms.c.e;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.baidu.swan.apps.ag.a aVar);
    }

    public static void a(final a aVar) {
        com.baidu.swan.b.c.a.aKu().getRequest().url(e.processUrl(com.baidu.swan.apps.t.a.ahv().TI())).addUrlParam("appkey", d.arr().getAppId()).addUrlParam("swan_core_ver", com.baidu.swan.apps.swancore.b.a(f.akr().ajT(), d.arr().RU())).addUrlParam("swan_game_ver", com.baidu.swan.apps.swancore.b.hv(1)).addUrlParam("uid", com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj())).cookieManager(com.baidu.swan.config.c.ayS().aiv()).build().executeAsync(new ResponseCallback<com.baidu.swan.apps.ag.a>() { // from class: com.baidu.swan.apps.ag.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public com.baidu.swan.apps.ag.a parseResponse(Response response, int i) throws Exception {
                JSONObject optJSONObject;
                if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                    return null;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
                }
                return com.baidu.swan.apps.ag.a.aX(optJSONObject);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(com.baidu.swan.apps.ag.a aVar2, int i) {
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
