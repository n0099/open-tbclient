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
/* loaded from: classes10.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String WU() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void av(JSONObject jSONObject) {
        e aap;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (aap = e.aap()) != null) {
            aap.aaz().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void WV() {
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
        com.baidu.swan.apps.network.c.a.WL().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void WP() {
                Map<String, com.baidu.swan.apps.setting.oauth.e> WX = a.WX();
                if (WX.size() > 0) {
                    com.baidu.swan.apps.as.d.b.this.B(WX);
                } else {
                    com.baidu.swan.apps.network.c.a.WL().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void WP() {
                            com.baidu.swan.apps.as.d.b.this.B(a.WX());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e> bVar) {
        com.baidu.swan.apps.network.c.a.WL().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void WP() {
                com.baidu.swan.apps.setting.oauth.e eVar = a.WX().get(str);
                if (eVar != null) {
                    bVar.B(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.WL().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void WP() {
                            bVar.B(a.WX().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static com.baidu.swan.apps.setting.oauth.e jt(String str) {
        return WX().get(str);
    }

    public static void WW() {
        e aap = e.aap();
        if (aap != null) {
            com.baidu.swan.apps.network.c.a.WL().a(new a());
            aap.aaz().putString("node_data_accredit_list", "");
            com.baidu.swan.apps.network.c.a.WL().update();
        }
    }

    @NonNull
    public static Map<String, com.baidu.swan.apps.setting.oauth.e> WX() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        e aap = e.aap();
        if (aap == null) {
            return arrayMap;
        }
        String string = aap.aaz().getString("node_data_accredit_list", "");
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
                    arrayMap.put(next, com.baidu.swan.apps.setting.oauth.e.h(next, optJSONObject));
                }
            }
            return arrayMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayMap;
        }
    }
}
