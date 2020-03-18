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

    public b fR(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return fS(str);
    }

    public b fS(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        e acI = e.acI();
        if (acI == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aq = com.baidu.swan.apps.api.c.b.aq("Api-Storage", str);
        b bVar = (b) aq.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aq.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        String optString2 = jSONObject.optString("data");
        com.baidu.swan.apps.storage.c acQ = acI.acQ();
        if (!acQ.available() && acQ.afl().getString(optString, "").length() < optString2.length()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "not available");
            }
            return new b(1001, "not available");
        }
        acQ.afl().putString(optString, optString2);
        com.baidu.swan.apps.ap.e.bYc.update();
        return new b(0);
    }

    public b JZ() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return Ka();
    }

    public b Ka() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e acI = e.acI();
        if (acI == null) {
            return new b(1001, "swan app is null");
        }
        acI.acQ().afl().edit().clear().apply();
        com.baidu.swan.apps.ap.e.bYc.update();
        return new b(0);
    }

    public b fT(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return fU(str);
    }

    public b fU(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e acI = e.acI();
        if (acI == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aq = com.baidu.swan.apps.api.c.b.aq("Api-Storage", str);
        b bVar = (b) aq.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aq.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        acI.acQ().afl().remove(optString);
        com.baidu.swan.apps.ap.e.bYc.update();
        return new b(0);
    }

    public b fV(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0224a() { // from class: com.baidu.swan.apps.api.module.j.a.1
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0224a
            public b a(e eVar, String str2) {
                String string = eVar.acQ().afl().getString(str2, "");
                try {
                    JSONObject fX = a.fX(string);
                    if (fX == null) {
                        fX = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fX.put("data", string);
                    }
                    return new b(0, fX);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b fW(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0224a() { // from class: com.baidu.swan.apps.api.module.j.a.2
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0224a
            public b a(e eVar, String str2) {
                String string = eVar.acQ().afl().getString(str2, "");
                try {
                    JSONObject fX = a.fX(string);
                    if (fX == null) {
                        fX = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fX.put("data", string);
                    }
                    return new b(0, fX);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b Kb() {
        e acI = e.acI();
        if (acI == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c acQ = acI.acQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) acQ.afl().getAll().keySet()));
            jSONObject.put("currentSize", acQ.afn() / 1024);
            jSONObject.put("limitSize", acQ.afo() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0224a interfaceC0224a) {
        e acI = e.acI();
        if (acI == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aq = com.baidu.swan.apps.api.c.b.aq("Api-Storage", str);
        b bVar = (b) aq.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aq.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0224a.a(acI, optString);
    }

    public static JSONObject fX(String str) {
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
