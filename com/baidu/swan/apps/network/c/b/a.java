package com.baidu.swan.apps.network.c.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aG(JSONObject jSONObject) {
        e akN;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (akN = e.akN()) != null) {
            akN.akX().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aht() {
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

    public static void d(@NonNull final com.baidu.swan.apps.as.d.b<Map<String, com.baidu.swan.apps.setting.oauth.e>> bVar) {
        com.baidu.swan.apps.network.c.a.ahk().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aho() {
                Map<String, com.baidu.swan.apps.setting.oauth.e> ahv = a.ahv();
                if (ahv.size() > 0) {
                    com.baidu.swan.apps.as.d.b.this.E(ahv);
                } else {
                    com.baidu.swan.apps.network.c.a.ahk().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void aho() {
                            com.baidu.swan.apps.as.d.b.this.E(a.ahv());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e> bVar) {
        com.baidu.swan.apps.network.c.a.ahk().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aho() {
                com.baidu.swan.apps.setting.oauth.e eVar = a.ahv().get(str);
                if (eVar != null) {
                    bVar.E(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.ahk().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void aho() {
                            bVar.E(a.ahv().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static com.baidu.swan.apps.setting.oauth.e kU(String str) {
        return ahv().get(str);
    }

    public static void ahu() {
        e akN = e.akN();
        if (akN != null) {
            com.baidu.swan.apps.network.c.a.ahk().a(new a());
            akN.akX().putString("node_data_accredit_list", "");
            com.baidu.swan.apps.network.c.a.ahk().update();
        }
    }

    @NonNull
    public static Map<String, com.baidu.swan.apps.setting.oauth.e> ahv() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        e akN = e.akN();
        if (akN == null) {
            return arrayMap;
        }
        String string = akN.akX().getString("node_data_accredit_list", "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
            if (optJSONObject2 == null) {
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, com.baidu.swan.apps.setting.oauth.e.i(next, optJSONObject));
                }
            }
            return arrayMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayMap;
        }
    }
}
