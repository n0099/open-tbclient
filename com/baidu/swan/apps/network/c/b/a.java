package com.baidu.swan.apps.network.c.b;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.setting.oauth.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile ArrayMap<String, e> drd;

    @Override // com.baidu.swan.apps.network.c.b.b
    @NonNull
    public String getNodeName() {
        return "accredit";
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void q(JSONObject jSONObject, String str) {
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "data is null");
            return;
        }
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null) {
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        aIN.aIZ().putString("node_data_accredit_list", jSONObject2);
        aIN.aIZ().putString("cur_request_id", str);
        if (com.baidu.swan.apps.performance.b.c.aEw()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.network.c.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.gq(false);
                }
            }, "updateInfoReload");
        } else {
            resetCache();
        }
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void aDt() {
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "onFiltered");
    }

    @Override // com.baidu.swan.apps.network.c.b.b
    public void onFail() {
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "onFail");
    }

    public static void s(@NonNull final com.baidu.swan.apps.ao.e.b<Map<String, e>> bVar) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        com.baidu.swan.apps.network.c.a.aDl().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aDo() {
                Map<String, e> gq = a.gq(true);
                if (gq.size() <= 0) {
                    if (a.DEBUG) {
                        Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                    }
                    com.baidu.swan.apps.network.c.a.aDl().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.2.1
                        @Override // com.baidu.swan.apps.network.c.a.a
                        public void aDo() {
                            if (a.DEBUG) {
                                Log.d("SwanAppUpdateManager", "has scope set");
                            }
                            com.baidu.swan.apps.ao.e.b.this.N(a.gq(true));
                        }
                    });
                    return;
                }
                com.baidu.swan.apps.ao.e.b.this.N(gq);
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "callback scope set");
                }
            }
        });
    }

    public static void b(final String str, @NonNull final com.baidu.swan.apps.ao.e.b<e> bVar) {
        final String qk = com.baidu.swan.apps.network.c.c.b.aDx().qk(str);
        boolean aEw = com.baidu.swan.apps.performance.b.c.aEw();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + aEw);
        }
        if (aEw) {
            a(str, bVar, qk);
        } else {
            com.baidu.swan.apps.network.c.a.aDl().a(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.3
                @Override // com.baidu.swan.apps.network.c.a.a
                public void aDo() {
                    a.a(str, bVar, qk);
                }
            });
        }
    }

    public static void a(final String str, @NonNull final com.baidu.swan.apps.ao.e.b<e> bVar, final String str2) {
        e eVar = gq(true).get(str);
        if (eVar != null) {
            com.baidu.swan.apps.network.c.c.b.aDx().end(str2);
            bVar.N(eVar);
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "has not scope node，required request from server");
        }
        com.baidu.swan.apps.network.c.a.aDl().b(new com.baidu.swan.apps.network.c.a.a() { // from class: com.baidu.swan.apps.network.c.b.a.4
            @Override // com.baidu.swan.apps.network.c.a.a
            public void aDo() {
                com.baidu.swan.apps.network.c.c.b.aDx().end(str2);
                bVar.N(a.gq(true).get(str));
            }
        });
    }

    @Nullable
    public static e qj(String str) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return gq(true).get(str);
    }

    public static void aDu() {
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "cleanAccreditListData");
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null) {
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        com.baidu.swan.apps.network.c.a.aDl().a(new a());
        aIN.aIZ().putString("node_data_accredit_list", "");
        resetCache();
        com.baidu.swan.apps.network.c.a.aDl().update();
    }

    public static void resetCache() {
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "resetCache");
        drd = null;
    }

    @NonNull
    public static Map<String, e> gq(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = drd;
        if (arrayMap != null && z) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
                return arrayMap;
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null) {
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String string = aIN.aIZ().getString("node_data_accredit_list", "");
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "getAccreditListData - from sp =" + string);
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
            if (optJSONObject2 == null) {
                com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.m(next, optJSONObject));
                }
            }
            drd = arrayMap2;
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "getAccreditListData cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ; size = " + (drd == null ? 0 : drd.size()));
            }
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.g("SwanAppUpdateManager", "getAccreditListData - parse json fail", e);
            return arrayMap2;
        }
    }
}
