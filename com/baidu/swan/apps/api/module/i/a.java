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
    public interface InterfaceC0399a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b ly(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return lz(str);
    }

    public b lz(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aHu = e.aHu();
        if (aHu == null) {
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
        String aT = aT(jSONObject);
        if (aT == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tD(aT)) {
            return new b(1001, "exceed storage key max length");
        }
        String aS = aS(jSONObject);
        if (aS == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tE(aS)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aHF = aHu.aHF();
        if (aHF.cE(aT, aS)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aHF.aKC().putString(aT, aS);
        com.baidu.swan.apps.am.e.dCQ.update();
        return new b(0);
    }

    public b ajT() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return ajU();
    }

    public b ajU() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aHu = e.aHu();
        if (aHu == null) {
            return new b(1001, "swan app is null");
        }
        aHu.aHF().aKC().edit().clear().apply();
        com.baidu.swan.apps.am.e.dCQ.update();
        return new b(0);
    }

    public b lA(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return lB(str);
    }

    public b lB(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aHu = e.aHu();
        if (aHu == null) {
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
        String aT = aT((JSONObject) bj.second);
        if (aT == null) {
            return new b(202);
        }
        aHu.aHF().aKC().remove(aT);
        com.baidu.swan.apps.am.e.dCQ.update();
        return new b(0);
    }

    public b lC(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return lD(str);
    }

    public b lD(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0399a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0399a
            public b a(e eVar, String str2) {
                String string = eVar.aHF().aKC().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dAB) {
                    return new b(1002, "data not found");
                }
                JSONObject lE = a.lE(string);
                if (lE == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, lE);
            }
        });
    }

    public b ajV() {
        e aHu = e.aHu();
        if (aHu == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aHF = aHu.aHF();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aHF.aKC().aKR()));
            jSONObject.put("currentSize", aHF.aKE() / 1024);
            jSONObject.put("limitSize", aHF.aKF() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0399a interfaceC0399a) {
        e aHu = e.aHu();
        if (aHu == null) {
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
        String aT = aT((JSONObject) bj.second);
        if (aT == null) {
            return new b(202);
        }
        return interfaceC0399a.a(aHu, aT);
    }

    @Nullable
    public static JSONObject lE(@Nullable String str) {
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
    public static String aS(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dAC) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aT(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
