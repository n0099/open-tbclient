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
/* loaded from: classes10.dex */
public class a extends c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0214a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b fD(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return fE(str);
    }

    public b fE(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        e aap = e.aap();
        if (aap == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-Storage", str);
        b bVar = (b) ah.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ah.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        String optString2 = jSONObject.optString("data");
        com.baidu.swan.apps.storage.c aax = aap.aax();
        if (!aax.available() && aax.acS().getString(optString, "").length() < optString2.length()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "not available");
            }
            return new b(1001, "not available");
        }
        aax.acS().putString(optString, optString2);
        com.baidu.swan.apps.ap.e.bTL.update();
        return new b(0);
    }

    public b HF() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return HG();
    }

    public b HG() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aap = e.aap();
        if (aap == null) {
            return new b(1001, "swan app is null");
        }
        aap.aax().acS().edit().clear().apply();
        com.baidu.swan.apps.ap.e.bTL.update();
        return new b(0);
    }

    public b fF(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return fG(str);
    }

    public b fG(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aap = e.aap();
        if (aap == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-Storage", str);
        b bVar = (b) ah.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) ah.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        aap.aax().acS().remove(optString);
        com.baidu.swan.apps.ap.e.bTL.update();
        return new b(0);
    }

    public b fH(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0214a() { // from class: com.baidu.swan.apps.api.module.j.a.1
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0214a
            public b a(e eVar, String str2) {
                String string = eVar.aax().acS().getString(str2, "");
                try {
                    JSONObject fJ = a.fJ(string);
                    if (fJ == null) {
                        fJ = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fJ.put("data", string);
                    }
                    return new b(0, fJ);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b fI(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0214a() { // from class: com.baidu.swan.apps.api.module.j.a.2
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0214a
            public b a(e eVar, String str2) {
                String string = eVar.aax().acS().getString(str2, "");
                try {
                    JSONObject fJ = a.fJ(string);
                    if (fJ == null) {
                        fJ = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fJ.put("data", string);
                    }
                    return new b(0, fJ);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b HH() {
        e aap = e.aap();
        if (aap == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aax = aap.aax();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aax.acS().getAll().keySet()));
            jSONObject.put("currentSize", aax.acU() / 1024);
            jSONObject.put("limitSize", aax.acV() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0214a interfaceC0214a) {
        e aap = e.aap();
        if (aap == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-Storage", str);
        b bVar = (b) ah.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) ah.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0214a.a(aap, optString);
    }

    public static JSONObject fJ(String str) {
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
