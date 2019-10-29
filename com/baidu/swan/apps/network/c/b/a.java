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
    public String MX() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aj(JSONObject jSONObject) {
        com.baidu.swan.apps.ae.b QZ;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (QZ = com.baidu.swan.apps.ae.b.QZ()) != null) {
            QZ.Rd().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void MY() {
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
        com.baidu.swan.apps.network.c.a.MR().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void MV() {
                Map Na = a.Na();
                if (Na.size() > 0) {
                    com.baidu.swan.apps.an.d.a.this.B(Na);
                } else {
                    com.baidu.swan.apps.network.c.a.MR().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void MV() {
                            com.baidu.swan.apps.an.d.a.this.B(a.Na());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.an.d.a<e> aVar) {
        com.baidu.swan.apps.network.c.a.MR().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void MV() {
                e eVar = (e) a.Na().get(str);
                if (eVar != null) {
                    aVar.B(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.MR().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void MV() {
                            aVar.B(a.Na().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static e gu(String str) {
        return Na().get(str);
    }

    public static void MZ() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            com.baidu.swan.apps.network.c.a.MR().a(new a());
            QZ.Rd().putString("node_data_accredit_list", "");
            com.baidu.swan.apps.network.c.a.MR().update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Map<String, e> Na() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null) {
            return arrayMap;
        }
        String string = QZ.Rd().getString("node_data_accredit_list", "");
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
