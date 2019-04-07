package com.baidu.swan.apps.network.c.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.swan.apps.setting.oauth.e;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void M(JSONObject jSONObject) {
        com.baidu.swan.apps.ae.b IV;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (IV = com.baidu.swan.apps.ae.b.IV()) != null) {
            IV.IZ().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void Fj() {
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

    public static void a(@NonNull final com.baidu.swan.apps.an.c.a<Map<String, e>> aVar) {
        com.baidu.swan.apps.network.c.a.Fd().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void Fh() {
                Map Fl = a.Fl();
                if (Fl.size() > 0) {
                    com.baidu.swan.apps.an.c.a.this.D(Fl);
                } else {
                    com.baidu.swan.apps.network.c.a.Fd().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void Fh() {
                            com.baidu.swan.apps.an.c.a.this.D(a.Fl());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.an.c.a<e> aVar) {
        com.baidu.swan.apps.network.c.a.Fd().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void Fh() {
                e eVar = (e) a.Fl().get(str);
                if (eVar != null) {
                    aVar.D(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.Fd().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void Fh() {
                            aVar.D(a.Fl().get(str));
                        }
                    });
                }
            }
        });
    }

    public static void Fk() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            com.baidu.swan.apps.network.c.a.Fd().a(new a());
            IV.IZ().putString("node_data_accredit_list", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Map<String, e> Fl() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV == null) {
            return arrayMap;
        }
        String string = IV.IZ().getString("node_data_accredit_list", "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject(IntentConfig.LIST);
            if (optJSONObject2 == null) {
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, e.h(next, optJSONObject));
                }
            }
            return arrayMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayMap;
        }
    }
}
