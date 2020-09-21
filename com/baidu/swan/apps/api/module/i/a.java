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
/* loaded from: classes3.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0356a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b ke(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return kf(str);
    }

    public b kf(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aAr = e.aAr();
        if (aAr == null) {
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
        String aD = aD(jSONObject);
        if (aD == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.sj(aD)) {
            return new b(1001, "exceed storage key max length");
        }
        String aC = aC(jSONObject);
        if (aC == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.sk(aC)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aAC = aAr.aAC();
        if (aAC.cs(aD, aC)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aAC.aDz().putString(aD, aC);
        com.baidu.swan.apps.am.e.dco.update();
        return new b(0);
    }

    public b acN() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return acO();
    }

    public b acO() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aAr = e.aAr();
        if (aAr == null) {
            return new b(1001, "swan app is null");
        }
        aAr.aAC().aDz().edit().clear().apply();
        com.baidu.swan.apps.am.e.dco.update();
        return new b(0);
    }

    public b kg(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return kh(str);
    }

    public b kh(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aAr = e.aAr();
        if (aAr == null) {
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
        String aD = aD((JSONObject) aX.second);
        if (aD == null) {
            return new b(202);
        }
        aAr.aAC().aDz().remove(aD);
        com.baidu.swan.apps.am.e.dco.update();
        return new b(0);
    }

    public b ki(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return kj(str);
    }

    public b kj(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0356a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0356a
            public b a(e eVar, String str2) {
                String string = eVar.aAC().aDz().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.cZX) {
                    return new b(1002, "data not found");
                }
                JSONObject kk = a.kk(string);
                if (kk == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, kk);
            }
        });
    }

    public b acP() {
        e aAr = e.aAr();
        if (aAr == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aAC = aAr.aAC();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aAC.aDz().aDO()));
            jSONObject.put("currentSize", aAC.aDB() / 1024);
            jSONObject.put("limitSize", aAC.aDC() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0356a interfaceC0356a) {
        e aAr = e.aAr();
        if (aAr == null) {
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
        String aD = aD((JSONObject) aX.second);
        if (aD == null) {
            return new b(202);
        }
        return interfaceC0356a.a(aAr, aD);
    }

    @Nullable
    public static JSONObject kk(@Nullable String str) {
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
    public static String aC(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.cZY) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aD(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
