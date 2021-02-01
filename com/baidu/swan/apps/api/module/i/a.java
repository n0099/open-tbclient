package com.baidu.swan.apps.api.module.i;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.c.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0381a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b kZ(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return la(str);
    }

    public b la(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aIK = e.aIK();
        if (aIK == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Storage", str);
        b bVar = (b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bh.second;
        String aU = aU(jSONObject);
        if (aU == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tk(aU)) {
            return new b(1001, "exceed storage key max length");
        }
        String aT = aT(jSONObject);
        if (aT == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tl(aT)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aIV = aIK.aIV();
        if (aIV.cC(aU, aT)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aIV.aLR().putString(aU, aT);
        com.baidu.swan.apps.al.e.dOe.update();
        return new b(0);
    }

    public b aki() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return akj();
    }

    public b akj() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aIK = e.aIK();
        if (aIK == null) {
            return new b(1001, "swan app is null");
        }
        aIK.aIV().aLR().edit().clear().apply();
        com.baidu.swan.apps.al.e.dOe.update();
        return new b(0);
    }

    public b lb(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return lc(str);
    }

    public b lc(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aIK = e.aIK();
        if (aIK == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Storage", str);
        b bVar = (b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aU = aU((JSONObject) bh.second);
        if (aU == null) {
            return new b(202);
        }
        aIK.aIV().aLR().remove(aU);
        com.baidu.swan.apps.al.e.dOe.update();
        return new b(0);
    }

    public b ld(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return le(str);
    }

    public b le(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0381a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0381a
            public b a(e eVar, String str2) {
                String string = eVar.aIV().aLR().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dLP) {
                    return new b(1002, "data not found");
                }
                JSONObject lf = a.lf(string);
                if (lf == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, lf);
            }
        });
    }

    public b akk() {
        e aIK = e.aIK();
        if (aIK == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aIV = aIK.aIV();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aIV.aLR().aMg()));
            jSONObject.put("currentSize", aIV.aLT() / 1024);
            jSONObject.put("limitSize", aIV.aLU() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0381a interfaceC0381a) {
        e aIK = e.aIK();
        if (aIK == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Storage", str);
        b bVar = (b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aU = aU((JSONObject) bh.second);
        if (aU == null) {
            return new b(202);
        }
        return interfaceC0381a.a(aIK, aU);
    }

    @Nullable
    public static JSONObject lf(@Nullable String str) {
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
    public static String aT(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dLQ) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aU(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
