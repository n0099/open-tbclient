package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kT(String str) {
        if (DEBUG) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bi = com.baidu.swan.apps.api.d.b.bi("Api-PullDownRefresh", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bi.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bi.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.f.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
                if (afe == null) {
                    com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "manager is null");
                    f.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else if (!(afe.aot() instanceof com.baidu.swan.apps.core.d.e)) {
                    com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "top fragment error");
                    f.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else {
                    com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) afe.aot();
                    if (eVar.ahR() == null) {
                        com.baidu.swan.apps.console.c.e("Api-PullDownRefresh", "view is null");
                        f.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                        return;
                    }
                    eVar.ahR().gl(false);
                    com.baidu.swan.apps.console.c.i("Api-PullDownRefresh", "refresh complete");
                    f.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
