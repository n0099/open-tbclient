package com.baidu.swan.apps.api.module.network;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b anz() {
        String networkClass = SwanAppNetworkUtils.getNetworkClass();
        if (TextUtils.isEmpty(networkClass)) {
            networkClass = "unknown";
        } else if ("no".equals(networkClass)) {
            networkClass = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", networkClass);
            if (DEBUG) {
                Log.i("Api-Network", "getNetworkType:  " + jSONObject);
            }
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(202);
        }
    }

    public com.baidu.swan.apps.api.c.b lE(String str) {
        final e aMk = e.aMk();
        if (aMk == null) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Network", "swan app is null");
            }
            return new com.baidu.swan.apps.api.c.b(202, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-Network", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Network", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bo.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Network", "callback is null");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.api.module.network.a.1
            @Override // java.lang.Runnable
            public void run() {
                aMk.aMy().b(a.this.ani().ang(), optString);
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
