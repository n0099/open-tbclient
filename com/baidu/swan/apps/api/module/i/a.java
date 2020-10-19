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
    public interface InterfaceC0373a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b kQ(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return kR(str);
    }

    public b kR(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aDa = e.aDa();
        if (aDa == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-Storage", str);
        b bVar = (b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bc.second;
        String aK = aK(jSONObject);
        if (aK == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.sW(aK)) {
            return new b(1001, "exceed storage key max length");
        }
        String aJ = aJ(jSONObject);
        if (aJ == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.sX(aJ)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aDl = aDa.aDl();
        if (aDl.cx(aK, aJ)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aDl.aGi().putString(aK, aJ);
        com.baidu.swan.apps.am.e.doy.update();
        return new b(0);
    }

    public b afz() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return afA();
    }

    public b afA() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aDa = e.aDa();
        if (aDa == null) {
            return new b(1001, "swan app is null");
        }
        aDa.aDl().aGi().edit().clear().apply();
        com.baidu.swan.apps.am.e.doy.update();
        return new b(0);
    }

    public b kS(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return kT(str);
    }

    public b kT(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aDa = e.aDa();
        if (aDa == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-Storage", str);
        b bVar = (b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aK = aK((JSONObject) bc.second);
        if (aK == null) {
            return new b(202);
        }
        aDa.aDl().aGi().remove(aK);
        com.baidu.swan.apps.am.e.doy.update();
        return new b(0);
    }

    public b kU(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return kV(str);
    }

    public b kV(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0373a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0373a
            public b a(e eVar, String str2) {
                String string = eVar.aDl().aGi().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dmh) {
                    return new b(1002, "data not found");
                }
                JSONObject kW = a.kW(string);
                if (kW == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, kW);
            }
        });
    }

    public b afB() {
        e aDa = e.aDa();
        if (aDa == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aDl = aDa.aDl();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aDl.aGi().aGx()));
            jSONObject.put("currentSize", aDl.aGk() / 1024);
            jSONObject.put("limitSize", aDl.aGl() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0373a interfaceC0373a) {
        e aDa = e.aDa();
        if (aDa == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-Storage", str);
        b bVar = (b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aK = aK((JSONObject) bc.second);
        if (aK == null) {
            return new b(202);
        }
        return interfaceC0373a.a(aDa, aK);
    }

    @Nullable
    public static JSONObject kW(@Nullable String str) {
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
    public static String aJ(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dmi) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aK(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
