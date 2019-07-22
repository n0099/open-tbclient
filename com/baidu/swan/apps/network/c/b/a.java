package com.baidu.swan.apps.network.c.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
    public String HZ() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void L(JSONObject jSONObject) {
        com.baidu.swan.apps.ae.b Md;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (Md = com.baidu.swan.apps.ae.b.Md()) != null) {
            Md.Mh().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void Ia() {
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
        com.baidu.swan.apps.network.c.a.HT().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void HX() {
                Map Ic = a.Ic();
                if (Ic.size() > 0) {
                    com.baidu.swan.apps.an.d.a.this.D(Ic);
                } else {
                    com.baidu.swan.apps.network.c.a.HT().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void HX() {
                            com.baidu.swan.apps.an.d.a.this.D(a.Ic());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.an.d.a<e> aVar) {
        com.baidu.swan.apps.network.c.a.HT().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void HX() {
                e eVar = (e) a.Ic().get(str);
                if (eVar != null) {
                    aVar.D(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.HT().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void HX() {
                            aVar.D(a.Ic().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static e fN(String str) {
        return Ic().get(str);
    }

    public static void Ib() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            com.baidu.swan.apps.network.c.a.HT().a(new a());
            Md.Mh().putString("node_data_accredit_list", "");
            com.baidu.swan.apps.network.c.a.HT().update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Map<String, e> Ic() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null) {
            return arrayMap;
        }
        String string = Md.Mh().getString("node_data_accredit_list", "");
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
