package com.baidu.swan.apps.network.c.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.setting.oauth.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile ArrayMap<String, e> cHr;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void u(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "data is null");
            return;
        }
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null) {
            com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        aAr.aAD().putString("node_data_accredit_list", jSONObject2);
        aAr.aAD().putString("cur_request_id", str);
        if (com.baidu.swan.apps.performance.b.c.awT()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.network.c.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.eZ(false);
                }
            }, "updateInfoReload");
        } else {
            resetCache();
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void avN() {
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "onFiltered");
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void onFail() {
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "onFail");
    }

    public static void s(@NonNull final com.baidu.swan.apps.ap.e.b<Map<String, e>> bVar) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        com.baidu.swan.apps.network.c.a.avF().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void avI() {
                Map<String, e> eZ = a.eZ(true);
                if (eZ.size() <= 0) {
                    if (a.DEBUG) {
                        Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                    }
                    com.baidu.swan.apps.network.c.a.avF().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void avI() {
                            if (a.DEBUG) {
                                Log.d("SwanAppUpdateManager", "has scope set");
                            }
                            com.baidu.swan.apps.ap.e.b.this.J(a.eZ(true));
                        }
                    });
                    return;
                }
                com.baidu.swan.apps.ap.e.b.this.J(eZ);
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "callback scope set");
                }
            }
        });
    }

    public static void b(final String str, @NonNull final com.baidu.swan.apps.ap.e.b<e> bVar) {
        final String pi = com.baidu.swan.apps.network.c.c.b.avR().pi(str);
        boolean awT = com.baidu.swan.apps.performance.b.c.awT();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + awT);
        }
        if (awT) {
            a(str, bVar, pi);
        } else {
            com.baidu.swan.apps.network.c.a.avF().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.3
                @Override // com.baidu.swan.apps.network.c.a.a
                public void avI() {
                    a.a(str, bVar, pi);
                }
            });
        }
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.ap.e.b<e> bVar, final String str2) {
        e eVar = eZ(true).get(str);
        if (eVar != null) {
            com.baidu.swan.apps.network.c.c.b.avR().pj(str2);
            bVar.J(eVar);
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "has not scope node，required request from server");
        }
        com.baidu.swan.apps.network.c.a.avF().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.4
            @Override // com.baidu.swan.apps.network.c.a.a
            public void avI() {
                com.baidu.swan.apps.network.c.c.b.avR().pj(str2);
                bVar.J(a.eZ(true).get(str));
            }
        });
    }

    @Nullable
    public static e ph(String str) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return eZ(true).get(str);
    }

    public static void avO() {
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "cleanAccreditListData");
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null) {
            com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        com.baidu.swan.apps.network.c.a.avF().a(new a());
        aAr.aAD().putString("node_data_accredit_list", "");
        resetCache();
        com.baidu.swan.apps.network.c.a.avF().update();
    }

    public static void resetCache() {
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "resetCache");
        cHr = null;
    }

    @NonNull
    public static Map<String, e> eZ(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = cHr;
        if (arrayMap != null && z) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
                return arrayMap;
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null) {
            com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String string = aAr.aAD().getString("node_data_accredit_list", "");
        com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "getAccreditListData - from sp =" + string);
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
            if (optJSONObject2 == null) {
                com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.i(next, optJSONObject));
                }
            }
            cHr = arrayMap2;
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ; size = " + (cHr == null ? 0 : cHr.size()));
            }
            com.baidu.swan.apps.console.c.bb("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.f("SwanAppUpdateManager", "getAccreditListData - parse json fail", e);
            return arrayMap2;
        }
    }
}
