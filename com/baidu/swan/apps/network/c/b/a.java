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
/* loaded from: classes25.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile ArrayMap<String, e> dnf;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void r(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "data is null");
            return;
        }
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        aJU.aKg().putString("node_data_accredit_list", jSONObject2);
        aJU.aKg().putString("cur_request_id", str);
        if (com.baidu.swan.apps.performance.b.c.aGy()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.network.c.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.gj(false);
                }
            }, "updateInfoReload");
        } else {
            resetCache();
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aFt() {
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "onFiltered");
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void onFail() {
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "onFail");
    }

    public static void s(@NonNull final com.baidu.swan.apps.ap.e.b<Map<String, e>> bVar) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        com.baidu.swan.apps.network.c.a.aFl().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aFo() {
                Map<String, e> gj = a.gj(true);
                if (gj.size() <= 0) {
                    if (a.DEBUG) {
                        Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                    }
                    com.baidu.swan.apps.network.c.a.aFl().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void aFo() {
                            if (a.DEBUG) {
                                Log.d("SwanAppUpdateManager", "has scope set");
                            }
                            com.baidu.swan.apps.ap.e.b.this.M(a.gj(true));
                        }
                    });
                    return;
                }
                com.baidu.swan.apps.ap.e.b.this.M(gj);
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "callback scope set");
                }
            }
        });
    }

    public static void b(final String str, @NonNull final com.baidu.swan.apps.ap.e.b<e> bVar) {
        final String rc = com.baidu.swan.apps.network.c.c.b.aFx().rc(str);
        boolean aGy = com.baidu.swan.apps.performance.b.c.aGy();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + aGy);
        }
        if (aGy) {
            a(str, bVar, rc);
        } else {
            com.baidu.swan.apps.network.c.a.aFl().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.3
                @Override // com.baidu.swan.apps.network.c.a.a
                public void aFo() {
                    a.a(str, bVar, rc);
                }
            });
        }
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.ap.e.b<e> bVar, final String str2) {
        e eVar = gj(true).get(str);
        if (eVar != null) {
            com.baidu.swan.apps.network.c.c.b.aFx().rd(str2);
            bVar.M(eVar);
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "has not scope node，required request from server");
        }
        com.baidu.swan.apps.network.c.a.aFl().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.4
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aFo() {
                com.baidu.swan.apps.network.c.c.b.aFx().rd(str2);
                bVar.M(a.gj(true).get(str));
            }
        });
    }

    @Nullable
    public static e rb(String str) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return gj(true).get(str);
    }

    public static void aFu() {
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "cleanAccreditListData");
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        com.baidu.swan.apps.network.c.a.aFl().a(new a());
        aJU.aKg().putString("node_data_accredit_list", "");
        resetCache();
        com.baidu.swan.apps.network.c.a.aFl().update();
    }

    public static void resetCache() {
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "resetCache");
        dnf = null;
    }

    @NonNull
    public static Map<String, e> gj(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = dnf;
        if (arrayMap != null && z) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
                return arrayMap;
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String string = aJU.aKg().getString("node_data_accredit_list", "");
        com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "getAccreditListData - from sp =" + string);
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
            if (optJSONObject2 == null) {
                com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.k(next, optJSONObject));
                }
            }
            dnf = arrayMap2;
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ; size = " + (dnf == null ? 0 : dnf.size()));
            }
            com.baidu.swan.apps.console.c.bt("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.f("SwanAppUpdateManager", "getAccreditListData - parse json fail", e);
            return arrayMap2;
        }
    }
}
