package com.baidu.swan.apps.api.module.i;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.c.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0387a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b lj(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return lk(str);
    }

    public b lk(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aEU = e.aEU();
        if (aEU == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-Storage", str);
        b bVar = (b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bj.second;
        String aN = aN(jSONObject);
        if (aN == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tp(aN)) {
            return new b(1001, "exceed storage key max length");
        }
        String aM = aM(jSONObject);
        if (aM == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tq(aM)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aFf = aEU.aFf();
        if (aFf.cE(aN, aM)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aFf.aIc().putString(aN, aM);
        com.baidu.swan.apps.am.e.dwY.update();
        return new b(0);
    }

    public b aht() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return ahu();
    }

    public b ahu() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aEU = e.aEU();
        if (aEU == null) {
            return new b(1001, "swan app is null");
        }
        aEU.aFf().aIc().edit().clear().apply();
        com.baidu.swan.apps.am.e.dwY.update();
        return new b(0);
    }

    public b ll(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return lm(str);
    }

    public b lm(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aEU = e.aEU();
        if (aEU == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-Storage", str);
        b bVar = (b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aN = aN((JSONObject) bj.second);
        if (aN == null) {
            return new b(202);
        }
        aEU.aFf().aIc().remove(aN);
        com.baidu.swan.apps.am.e.dwY.update();
        return new b(0);
    }

    public b ln(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return lo(str);
    }

    public b lo(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0387a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0387a
            public b a(e eVar, String str2) {
                String string = eVar.aFf().aIc().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.duJ) {
                    return new b(1002, "data not found");
                }
                JSONObject lp = a.lp(string);
                if (lp == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, lp);
            }
        });
    }

    public b ahv() {
        e aEU = e.aEU();
        if (aEU == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aFf = aEU.aFf();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aFf.aIc().aIr()));
            jSONObject.put("currentSize", aFf.aIe() / 1024);
            jSONObject.put("limitSize", aFf.aIf() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0387a interfaceC0387a) {
        e aEU = e.aEU();
        if (aEU == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-Storage", str);
        b bVar = (b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aN = aN((JSONObject) bj.second);
        if (aN == null) {
            return new b(202);
        }
        return interfaceC0387a.a(aEU, aN);
    }

    @Nullable
    public static JSONObject lp(@Nullable String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("key")) {
                    jSONObject.remove("key");
                    return jSONObject;
                }
                return jSONObject;
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("Api-Storage", "parseDataAsJsonResult:data is not json.");
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        if (str == null) {
            str = "";
        }
        try {
            jSONObject2.put("data", str);
            return jSONObject2;
        } catch (JSONException e2) {
            return null;
        }
    }

    @Nullable
    public static String aM(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.duK) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aN(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
