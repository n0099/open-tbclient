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
/* loaded from: classes7.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile ArrayMap<String, e> cxs;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void u(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.runtime.e arv;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (arv = com.baidu.swan.apps.runtime.e.arv()) != null) {
            arv.arH().putString("node_data_accredit_list", jSONObject.toString());
            arv.arH().putString("cur_request_id", str);
            resetCache();
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void ani() {
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

    public static void l(@NonNull final com.baidu.swan.apps.aq.e.b<Map<String, e>> bVar) {
        com.baidu.swan.apps.network.c.a.amZ().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void and() {
                Map<String, e> ank = a.ank();
                if (ank.size() > 0) {
                    com.baidu.swan.apps.aq.e.b.this.H(ank);
                } else {
                    com.baidu.swan.apps.network.c.a.amZ().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void and() {
                            com.baidu.swan.apps.aq.e.b.this.H(a.ank());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.aq.e.b<e> bVar) {
        final String mP = com.baidu.swan.apps.network.c.c.b.ann().mP(str);
        com.baidu.swan.apps.network.c.a.amZ().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void and() {
                e eVar = a.ank().get(str);
                if (eVar != null) {
                    com.baidu.swan.apps.network.c.c.b.ann().mQ(mP);
                    bVar.H(eVar);
                    return;
                }
                com.baidu.swan.apps.network.c.a.amZ().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                    @Override // com.baidu.swan.apps.network.c.a.a
                    public void and() {
                        com.baidu.swan.apps.network.c.c.b.ann().mQ(mP);
                        bVar.H(a.ank().get(str));
                    }
                });
            }
        });
    }

    @Nullable
    public static e mO(String str) {
        return ank().get(str);
    }

    public static void anj() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null) {
            com.baidu.swan.apps.network.c.a.amZ().a(new a());
            arv.arH().putString("node_data_accredit_list", "");
            resetCache();
            com.baidu.swan.apps.network.c.a.amZ().update();
        }
    }

    public static void resetCache() {
        cxs = null;
    }

    @NonNull
    public static Map<String, e> ank() {
        JSONObject optJSONObject;
        ArrayMap<String, e> arrayMap;
        if (!com.baidu.swan.apps.performance.b.b.aom() || (arrayMap = cxs) == null) {
            ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
            com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
            if (arv == null) {
                return arrayMap2;
            }
            String string = arv.arH().getString("node_data_accredit_list", "");
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
                cxs = arrayMap2;
                return arrayMap2;
            } catch (JSONException e) {
                e.printStackTrace();
                return arrayMap2;
            }
        }
        return arrayMap;
    }
}
