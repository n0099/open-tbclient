package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.aq.aj;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hF(String str) {
        if (DEBUG) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-PullDownRefresh", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) aR.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.f.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
                if (RN == null) {
                    com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "manager is null");
                    f.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else if (!(RN.ZV() instanceof com.baidu.swan.apps.core.d.d)) {
                    com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "top fragment error");
                    f.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else {
                    com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) RN.ZV();
                    if (dVar.Ug() == null) {
                        com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "view is null");
                        f.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                        return;
                    }
                    dVar.Ug().eP(false);
                    com.baidu.swan.apps.console.c.i("Api-PullDownRefresh", "refresh complete");
                    f.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
