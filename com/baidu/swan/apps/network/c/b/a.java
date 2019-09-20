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
    public String Id() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void L(JSONObject jSONObject) {
        com.baidu.swan.apps.ae.b Mh;
        if (DEBUG) {
            Log.d("SwanAppAccreditNode", "onUpdate: ");
        }
        if (jSONObject != null && (Mh = com.baidu.swan.apps.ae.b.Mh()) != null) {
            Mh.Ml().putString("node_data_accredit_list", jSONObject.toString());
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void Ie() {
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
        com.baidu.swan.apps.network.c.a.HX().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1
            @Override // com.baidu.swan.apps.network.c.a.a
            public void Ib() {
                Map Ig = a.Ig();
                if (Ig.size() > 0) {
                    com.baidu.swan.apps.an.d.a.this.D(Ig);
                } else {
                    com.baidu.swan.apps.network.c.a.HX().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.1.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void Ib() {
                            com.baidu.swan.apps.an.d.a.this.D(a.Ig());
                        }
                    });
                }
            }
        });
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.an.d.a<e> aVar) {
        com.baidu.swan.apps.network.c.a.HX().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void Ib() {
                e eVar = (e) a.Ig().get(str);
                if (eVar != null) {
                    aVar.D(eVar);
                } else {
                    com.baidu.swan.apps.network.c.a.HX().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void Ib() {
                            aVar.D(a.Ig().get(str));
                        }
                    });
                }
            }
        });
    }

    @Nullable
    public static e fP(String str) {
        return Ig().get(str);
    }

    public static void If() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            com.baidu.swan.apps.network.c.a.HX().a(new a());
            Mh.Ml().putString("node_data_accredit_list", "");
            com.baidu.swan.apps.network.c.a.HX().update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Map<String, e> Ig() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null) {
            return arrayMap;
        }
        String string = Mh.Ml().getString("node_data_accredit_list", "");
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
