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
    public interface InterfaceC0275a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b hf(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return hg(str);
    }

    public b hg(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        e akM = e.akM();
        if (akM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-Storage", str);
        b bVar = (b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        String optString2 = jSONObject.optString("data");
        com.baidu.swan.apps.storage.c akU = akM.akU();
        if (!akU.available() && akU.anp().getString(optString, "").length() < optString2.length()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "not available");
            }
            return new b(1001, "not available");
        }
        akU.anp().putString(optString, optString2);
        com.baidu.swan.apps.ap.e.cxa.update();
        return new b(0);
    }

    public b RL() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return RM();
    }

    public b RM() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e akM = e.akM();
        if (akM == null) {
            return new b(1001, "swan app is null");
        }
        akM.akU().anp().edit().clear().apply();
        com.baidu.swan.apps.ap.e.cxa.update();
        return new b(0);
    }

    public b hh(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return hi(str);
    }

    public b hi(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e akM = e.akM();
        if (akM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-Storage", str);
        b bVar = (b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) az.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        akM.akU().anp().remove(optString);
        com.baidu.swan.apps.ap.e.cxa.update();
        return new b(0);
    }

    public b hj(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0275a() { // from class: com.baidu.swan.apps.api.module.j.a.1
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0275a
            public b a(e eVar, String str2) {
                String string = eVar.akU().anp().getString(str2, "");
                try {
                    JSONObject hl = a.hl(string);
                    if (hl == null) {
                        hl = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        hl.put("data", string);
                    }
                    return new b(0, hl);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b hk(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0275a() { // from class: com.baidu.swan.apps.api.module.j.a.2
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0275a
            public b a(e eVar, String str2) {
                String string = eVar.akU().anp().getString(str2, "");
                try {
                    JSONObject hl = a.hl(string);
                    if (hl == null) {
                        hl = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        hl.put("data", string);
                    }
                    return new b(0, hl);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b RN() {
        e akM = e.akM();
        if (akM == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c akU = akM.akU();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) akU.anp().getAll().keySet()));
            jSONObject.put("currentSize", akU.anr() / 1024);
            jSONObject.put("limitSize", akU.ans() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0275a interfaceC0275a) {
        e akM = e.akM();
        if (akM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-Storage", str);
        b bVar = (b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) az.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0275a.a(akM, optString);
    }

    public static JSONObject hl(String str) {
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
