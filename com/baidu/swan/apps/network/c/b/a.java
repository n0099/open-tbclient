package com.baidu.swan.apps.network.c.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.swan.apps.setting.oauth.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile ArrayMap<String, e> cvr;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aR(JSONObject jSONObject) {
        com.baidu.swan.apps.runtime.e apM;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (apM = com.baidu.swan.apps.runtime.e.apM()) != null) {
            apM.apY().putString("node_data_accredit_list", jSONObject.toString());
            resetCache();
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void alS() {
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onFiltered: ");
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void onFail() {
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onFail: ");
        }
    }

    public static void k(@NonNull final com.baidu.swan.apps.aq.e.b<Map<String, e>> bVar) {
        com.baidu.swan.apps.network.c.a.alJ().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void alN() {
                Map<String, e> alU = a.alU();
                if (alU.size() > 0) {
                    com.baidu.swan.apps.aq.e.b.this.H(alU);
                } else {
                    com.baidu.swan.apps.network.c.a.alJ().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void alN() {
                            com.baidu.swan.apps.aq.e.b.this.H(a.alU());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.aq.e.b<e> bVar) {
        com.baidu.swan.apps.network.c.a.alJ().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void alN() {
                e eVar = a.alU().get(str);
                if (eVar != null) {
                    bVar.H(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.alJ().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void alN() {
                            bVar.H(a.alU().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static e mq(String str) {
        return alU().get(str);
    }

    public static void alT() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null) {
            com.baidu.swan.apps.network.c.a.alJ().a(new a());
            apM.apY().putString("node_data_accredit_list", "");
            resetCache();
            com.baidu.swan.apps.network.c.a.alJ().update();
        }
    }

    private static void resetCache() {
        cvr = null;
    }

    @NonNull
    public static Map<String, e> alU() {
        JSONObject optJSONObject;
        ArrayMap<String, e> arrayMap;
        if (!com.baidu.swan.apps.performance.b.b.amR() || (arrayMap = cvr) == null) {
            ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
            if (apM == null) {
                return arrayMap2;
            }
            String string = apM.apY().getString("node_data_accredit_list", "");
            if (TextUtils.isEmpty(string)) {
                return arrayMap2;
            }
            try {
                JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
                if (optJSONObject2 == null) {
                    return arrayMap2;
                }
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                        arrayMap2.put(next, e.i(next, optJSONObject));
                    }
                }
                cvr = arrayMap2;
                return arrayMap2;
            } catch (JSONException e) {
                e.printStackTrace();
                return arrayMap2;
            }
        }
        return arrayMap;
    }
}
