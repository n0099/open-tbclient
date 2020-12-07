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
/* loaded from: classes25.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0409a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b lZ(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return ma(str);
    }

    public b ma(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aJU = e.aJU();
        if (aJU == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-Storage", str);
        b bVar = (b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        String aP = aP(jSONObject);
        if (aP == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.uf(aP)) {
            return new b(1001, "exceed storage key max length");
        }
        String aO = aO(jSONObject);
        if (aO == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.ug(aO)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aKf = aJU.aKf();
        if (aKf.cK(aP, aO)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aKf.aNb().putString(aP, aO);
        com.baidu.swan.apps.am.e.dIh.update();
        return new b(0);
    }

    public b amt() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return amu();
    }

    public b amu() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aJU = e.aJU();
        if (aJU == null) {
            return new b(1001, "swan app is null");
        }
        aJU.aKf().aNb().edit().clear().apply();
        com.baidu.swan.apps.am.e.dIh.update();
        return new b(0);
    }

    public b mb(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return mc(str);
    }

    public b mc(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aJU = e.aJU();
        if (aJU == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-Storage", str);
        b bVar = (b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aP = aP((JSONObject) bp.second);
        if (aP == null) {
            return new b(202);
        }
        aJU.aKf().aNb().remove(aP);
        com.baidu.swan.apps.am.e.dIh.update();
        return new b(0);
    }

    public b md(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return me(str);
    }

    public b me(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0409a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0409a
            public b a(e eVar, String str2) {
                String string = eVar.aKf().aNb().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dFT) {
                    return new b(1002, "data not found");
                }
                JSONObject mf = a.mf(string);
                if (mf == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, mf);
            }
        });
    }

    public b amv() {
        e aJU = e.aJU();
        if (aJU == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aKf = aJU.aKf();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aKf.aNb().aNq()));
            jSONObject.put("currentSize", aKf.aNd() / 1024);
            jSONObject.put("limitSize", aKf.aNe() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0409a interfaceC0409a) {
        e aJU = e.aJU();
        if (aJU == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-Storage", str);
        b bVar = (b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aP = aP((JSONObject) bp.second);
        if (aP == null) {
            return new b(202);
        }
        return interfaceC0409a.a(aJU, aP);
    }

    @Nullable
    public static JSONObject mf(@Nullable String str) {
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
    public static String aO(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dFU) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aP(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
