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
/* loaded from: classes10.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile ArrayMap<String, e> dbS;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void u(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "data is null");
            return;
        }
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null) {
            com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        aEU.aFg().putString("node_data_accredit_list", jSONObject2);
        aEU.aFg().putString("cur_request_id", str);
        if (com.baidu.swan.apps.performance.b.c.aBy()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.network.c.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.fI(false);
                }
            }, "updateInfoReload");
        } else {
            resetCache();
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aAs() {
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "onFiltered");
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void onFail() {
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "onFail");
    }

    public static void s(@NonNull final com.baidu.swan.apps.ap.e.b<Map<String, e>> bVar) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        com.baidu.swan.apps.network.c.a.aAk().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aAn() {
                Map<String, e> fI = a.fI(true);
                if (fI.size() <= 0) {
                    if (a.DEBUG) {
                        Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                    }
                    com.baidu.swan.apps.network.c.a.aAk().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void aAn() {
                            if (a.DEBUG) {
                                Log.d("SwanAppUpdateManager", "has scope set");
                            }
                            com.baidu.swan.apps.ap.e.b.this.M(a.fI(true));
                        }
                    });
                    return;
                }
                com.baidu.swan.apps.ap.e.b.this.M(fI);
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "callback scope set");
                }
            }
        });
    }

    public static void b(final String str, @NonNull final com.baidu.swan.apps.ap.e.b<e> bVar) {
        final String qn = com.baidu.swan.apps.network.c.c.b.aAw().qn(str);
        boolean aBy = com.baidu.swan.apps.performance.b.c.aBy();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + aBy);
        }
        if (aBy) {
            a(str, bVar, qn);
        } else {
            com.baidu.swan.apps.network.c.a.aAk().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.3
                @Override // com.baidu.swan.apps.network.c.a.a
                public void aAn() {
                    a.a(str, bVar, qn);
                }
            });
        }
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.ap.e.b<e> bVar, final String str2) {
        e eVar = fI(true).get(str);
        if (eVar != null) {
            com.baidu.swan.apps.network.c.c.b.aAw().qo(str2);
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
        com.baidu.swan.apps.network.c.a.aAk().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.4
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aAn() {
                com.baidu.swan.apps.network.c.c.b.aAw().qo(str2);
                bVar.M(a.fI(true).get(str));
            }
        });
    }

    @Nullable
    public static e qm(String str) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return fI(true).get(str);
    }

    public static void aAt() {
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "cleanAccreditListData");
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null) {
            com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        com.baidu.swan.apps.network.c.a.aAk().a(new a());
        aEU.aFg().putString("node_data_accredit_list", "");
        resetCache();
        com.baidu.swan.apps.network.c.a.aAk().update();
    }

    public static void resetCache() {
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "resetCache");
        dbS = null;
    }

    @NonNull
    public static Map<String, e> fI(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = dbS;
        if (arrayMap != null && z) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
                return arrayMap;
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null) {
            com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String string = aEU.aFg().getString("node_data_accredit_list", "");
        com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "getAccreditListData - from sp =" + string);
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
            if (optJSONObject2 == null) {
                com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.i(next, optJSONObject));
                }
            }
            dbS = arrayMap2;
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ; size = " + (dbS == null ? 0 : dbS.size()));
            }
            com.baidu.swan.apps.console.c.bn("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.f("SwanAppUpdateManager", "getAccreditListData - parse json fail", e);
            return arrayMap2;
        }
    }
}
