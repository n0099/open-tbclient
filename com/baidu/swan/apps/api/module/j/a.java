package com.baidu.swan.apps.api.module.j;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.b.b;
import com.baidu.swan.apps.runtime.e;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0224a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b fS(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return fT(str);
    }

    public b fT(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        e acF = e.acF();
        if (acF == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-Storage", str);
        b bVar = (b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ar.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        String optString2 = jSONObject.optString("data");
        com.baidu.swan.apps.storage.c acN = acF.acN();
        if (!acN.available() && acN.afi().getString(optString, "").length() < optString2.length()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "not available");
            }
            return new b(1001, "not available");
        }
        acN.afi().putString(optString, optString2);
        com.baidu.swan.apps.ap.e.bXR.update();
        return new b(0);
    }

    public b JW() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return JX();
    }

    public b JX() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e acF = e.acF();
        if (acF == null) {
            return new b(1001, "swan app is null");
        }
        acF.acN().afi().edit().clear().apply();
        com.baidu.swan.apps.ap.e.bXR.update();
        return new b(0);
    }

    public b fU(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return fV(str);
    }

    public b fV(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e acF = e.acF();
        if (acF == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-Storage", str);
        b bVar = (b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) ar.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        acF.acN().afi().remove(optString);
        com.baidu.swan.apps.ap.e.bXR.update();
        return new b(0);
    }

    public b fW(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0224a() { // from class: com.baidu.swan.apps.api.module.j.a.1
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0224a
            public b a(e eVar, String str2) {
                String string = eVar.acN().afi().getString(str2, "");
                try {
                    JSONObject fY = a.fY(string);
                    if (fY == null) {
                        fY = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fY.put("data", string);
                    }
                    return new b(0, fY);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b fX(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0224a() { // from class: com.baidu.swan.apps.api.module.j.a.2
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0224a
            public b a(e eVar, String str2) {
                String string = eVar.acN().afi().getString(str2, "");
                try {
                    JSONObject fY = a.fY(string);
                    if (fY == null) {
                        fY = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fY.put("data", string);
                    }
                    return new b(0, fY);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b JY() {
        e acF = e.acF();
        if (acF == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c acN = acF.acN();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) acN.afi().getAll().keySet()));
            jSONObject.put("currentSize", acN.afk() / 1024);
            jSONObject.put("limitSize", acN.afl() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0224a interfaceC0224a) {
        e acF = e.acF();
        if (acF == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-Storage", str);
        b bVar = (b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) ar.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0224a.a(acF, optString);
    }

    public static JSONObject fY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("key")) {
                jSONObject.remove("key");
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
