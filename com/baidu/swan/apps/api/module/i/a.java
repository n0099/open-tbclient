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
/* loaded from: classes7.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0397a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b ls(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return lt(str);
    }

    public b lt(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aGM = e.aGM();
        if (aGM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bi = com.baidu.swan.apps.api.d.b.bi("Api-Storage", str);
        b bVar = (b) bi.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bi.second;
        String aN = aN(jSONObject);
        if (aN == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.ty(aN)) {
            return new b(1001, "exceed storage key max length");
        }
        String aM = aM(jSONObject);
        if (aM == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tz(aM)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aGX = aGM.aGX();
        if (aGX.cD(aN, aM)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aGX.aJU().putString(aN, aM);
        com.baidu.swan.apps.am.e.dBj.update();
        return new b(0);
    }

    public b ajl() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return ajm();
    }

    public b ajm() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aGM = e.aGM();
        if (aGM == null) {
            return new b(1001, "swan app is null");
        }
        aGM.aGX().aJU().edit().clear().apply();
        com.baidu.swan.apps.am.e.dBj.update();
        return new b(0);
    }

    public b lu(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return lv(str);
    }

    public b lv(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aGM = e.aGM();
        if (aGM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bi = com.baidu.swan.apps.api.d.b.bi("Api-Storage", str);
        b bVar = (b) bi.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aN = aN((JSONObject) bi.second);
        if (aN == null) {
            return new b(202);
        }
        aGM.aGX().aJU().remove(aN);
        com.baidu.swan.apps.am.e.dBj.update();
        return new b(0);
    }

    public b lw(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return lx(str);
    }

    public b lx(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0397a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0397a
            public b a(e eVar, String str2) {
                String string = eVar.aGX().aJU().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dyU) {
                    return new b(1002, "data not found");
                }
                JSONObject ly = a.ly(string);
                if (ly == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, ly);
            }
        });
    }

    public b ajn() {
        e aGM = e.aGM();
        if (aGM == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aGX = aGM.aGX();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aGX.aJU().aKj()));
            jSONObject.put("currentSize", aGX.aJW() / 1024);
            jSONObject.put("limitSize", aGX.aJX() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0397a interfaceC0397a) {
        e aGM = e.aGM();
        if (aGM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bi = com.baidu.swan.apps.api.d.b.bi("Api-Storage", str);
        b bVar = (b) bi.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aN = aN((JSONObject) bi.second);
        if (aN == null) {
            return new b(202);
        }
        return interfaceC0397a.a(aGM, aN);
    }

    @Nullable
    public static JSONObject ly(@Nullable String str) {
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
        if (com.baidu.swan.apps.storage.c.dyV) {
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
