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
/* loaded from: classes9.dex */
public class a extends c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0212a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b fA(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return fB(str);
    }

    public b fB(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        e ZS = e.ZS();
        if (ZS == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-Storage", str);
        b bVar = (b) ag.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ag.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        String optString2 = jSONObject.optString("data");
        com.baidu.swan.apps.storage.c aaa = ZS.aaa();
        if (!aaa.available() && aaa.acv().getString(optString, "").length() < optString2.length()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "not available");
            }
            return new b(1001, "not available");
        }
        aaa.acv().putString(optString, optString2);
        com.baidu.swan.apps.ap.e.bTz.update();
        return new b(0);
    }

    public b Hj() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return Hk();
    }

    public b Hk() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e ZS = e.ZS();
        if (ZS == null) {
            return new b(1001, "swan app is null");
        }
        ZS.aaa().acv().edit().clear().apply();
        com.baidu.swan.apps.ap.e.bTz.update();
        return new b(0);
    }

    public b fC(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return fD(str);
    }

    public b fD(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e ZS = e.ZS();
        if (ZS == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-Storage", str);
        b bVar = (b) ag.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) ag.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        ZS.aaa().acv().remove(optString);
        com.baidu.swan.apps.ap.e.bTz.update();
        return new b(0);
    }

    public b fE(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0212a() { // from class: com.baidu.swan.apps.api.module.j.a.1
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0212a
            public b a(e eVar, String str2) {
                String string = eVar.aaa().acv().getString(str2, "");
                try {
                    JSONObject fG = a.fG(string);
                    if (fG == null) {
                        fG = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fG.put("data", string);
                    }
                    return new b(0, fG);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b fF(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0212a() { // from class: com.baidu.swan.apps.api.module.j.a.2
            @Override // com.baidu.swan.apps.api.module.j.a.InterfaceC0212a
            public b a(e eVar, String str2) {
                String string = eVar.aaa().acv().getString(str2, "");
                try {
                    JSONObject fG = a.fG(string);
                    if (fG == null) {
                        fG = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        fG.put("data", string);
                    }
                    return new b(0, fG);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b Hl() {
        e ZS = e.ZS();
        if (ZS == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aaa = ZS.aaa();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aaa.acv().getAll().keySet()));
            jSONObject.put("currentSize", aaa.acx() / 1024);
            jSONObject.put("limitSize", aaa.acy() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0212a interfaceC0212a) {
        e ZS = e.ZS();
        if (ZS == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-Storage", str);
        b bVar = (b) ag.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) ag.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0212a.a(ZS, optString);
    }

    public static JSONObject fG(String str) {
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
