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
    public interface InterfaceC0401a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b lS(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return lT(str);
    }

    public b lT(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aMk = e.aMk();
        if (aMk == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-Storage", str);
        b bVar = (b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        String aX = aX(jSONObject);
        if (aX == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.uc(aX)) {
            return new b(1001, "exceed storage key max length");
        }
        String aW = aW(jSONObject);
        if (aW == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.ud(aW)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aMv = aMk.aMv();
        if (aMv.cJ(aX, aW)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aMv.aPr().putString(aX, aW);
        com.baidu.swan.apps.al.e.dQM.update();
        return new b(0);
    }

    public b anD() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return anE();
    }

    public b anE() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aMk = e.aMk();
        if (aMk == null) {
            return new b(1001, "swan app is null");
        }
        aMk.aMv().aPr().edit().clear().apply();
        com.baidu.swan.apps.al.e.dQM.update();
        return new b(0);
    }

    public b lU(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return lV(str);
    }

    public b lV(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aMk = e.aMk();
        if (aMk == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-Storage", str);
        b bVar = (b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aX = aX((JSONObject) bo.second);
        if (aX == null) {
            return new b(202);
        }
        aMk.aMv().aPr().remove(aX);
        com.baidu.swan.apps.al.e.dQM.update();
        return new b(0);
    }

    public b lW(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return lX(str);
    }

    public b lX(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0401a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0401a
            public b a(e eVar, String str2) {
                String string = eVar.aMv().aPr().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dOx) {
                    return new b(1002, "data not found");
                }
                JSONObject lY = a.lY(string);
                if (lY == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, lY);
            }
        });
    }

    public b anF() {
        e aMk = e.aMk();
        if (aMk == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aMv = aMk.aMv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aMv.aPr().aPG()));
            jSONObject.put("currentSize", aMv.aPt() / 1024);
            jSONObject.put("limitSize", aMv.aPu() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0401a interfaceC0401a) {
        e aMk = e.aMk();
        if (aMk == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-Storage", str);
        b bVar = (b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aX = aX((JSONObject) bo.second);
        if (aX == null) {
            return new b(202);
        }
        return interfaceC0401a.a(aMk, aX);
    }

    @Nullable
    public static JSONObject lY(@Nullable String str) {
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
    public static String aW(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dOy) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aX(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
