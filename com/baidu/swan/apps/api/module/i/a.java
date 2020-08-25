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
/* loaded from: classes8.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0361a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b jK(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return jL(str);
    }

    public b jL(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e azI = e.azI();
        if (azI == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-Storage", str);
        b bVar = (b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        String aA = aA(jSONObject);
        if (aA == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.rP(aA)) {
            return new b(1001, "exceed storage key max length");
        }
        String az = az(jSONObject);
        if (az == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.rQ(az)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c azT = azI.azT();
        if (azT.cs(aA, az)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        azT.aCP().putString(aA, az);
        com.baidu.swan.apps.am.e.dai.update();
        return new b(0);
    }

    public b ace() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return acf();
    }

    public b acf() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e azI = e.azI();
        if (azI == null) {
            return new b(1001, "swan app is null");
        }
        azI.azT().aCP().edit().clear().apply();
        com.baidu.swan.apps.am.e.dai.update();
        return new b(0);
    }

    public b jM(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return jN(str);
    }

    public b jN(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e azI = e.azI();
        if (azI == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-Storage", str);
        b bVar = (b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aA = aA((JSONObject) aX.second);
        if (aA == null) {
            return new b(202);
        }
        azI.azT().aCP().remove(aA);
        com.baidu.swan.apps.am.e.dai.update();
        return new b(0);
    }

    public b jO(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return jP(str);
    }

    public b jP(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0361a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0361a
            public b a(e eVar, String str2) {
                String string = eVar.azT().aCP().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.cXT) {
                    return new b(1002, "data not found");
                }
                JSONObject jQ = a.jQ(string);
                if (jQ == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, jQ);
            }
        });
    }

    public b acg() {
        e azI = e.azI();
        if (azI == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c azT = azI.azT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) azT.aCP().aDe()));
            jSONObject.put("currentSize", azT.aCR() / 1024);
            jSONObject.put("limitSize", azT.aCS() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0361a interfaceC0361a) {
        e azI = e.azI();
        if (azI == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-Storage", str);
        b bVar = (b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aA = aA((JSONObject) aX.second);
        if (aA == null) {
            return new b(202);
        }
        return interfaceC0361a.a(azI, aA);
    }

    @Nullable
    public static JSONObject jQ(@Nullable String str) {
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
    public static String az(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.cXU) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aA(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
