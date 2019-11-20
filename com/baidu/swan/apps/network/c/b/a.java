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
/* loaded from: classes2.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String MY() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void ak(JSONObject jSONObject) {
        com.baidu.swan.apps.ae.b Ra;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (Ra = com.baidu.swan.apps.ae.b.Ra()) != null) {
            Ra.Rf().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void MZ() {
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

    public static void e(@NonNull final com.baidu.swan.apps.an.d.a<Map<String, e>> aVar) {
        com.baidu.swan.apps.network.c.a.MS().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void MW() {
                Map Nb = a.Nb();
                if (Nb.size() > 0) {
                    com.baidu.swan.apps.an.d.a.this.B(Nb);
                } else {
                    com.baidu.swan.apps.network.c.a.MS().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void MW() {
                            com.baidu.swan.apps.an.d.a.this.B(a.Nb());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.an.d.a<e> aVar) {
        com.baidu.swan.apps.network.c.a.MS().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void MW() {
                e eVar = (e) a.Nb().get(str);
                if (eVar != null) {
                    aVar.B(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.MS().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void MW() {
                            aVar.B(a.Nb().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static e gu(String str) {
        return Nb().get(str);
    }

    public static void Na() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            com.baidu.swan.apps.network.c.a.MS().a(new a());
            Ra.Rf().putString("node_data_accredit_list", "");
            com.baidu.swan.apps.network.c.a.MS().update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Map<String, e> Nb() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null) {
            return arrayMap;
        }
        String string = Ra.Rf().getString("node_data_accredit_list", "");
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
                    arrayMap.put(next, e.i(next, optJSONObject));
                }
            }
            return arrayMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayMap;
        }
    }
}
