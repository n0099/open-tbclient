package com.baidu.swan.apps.api.module.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
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
    public interface InterfaceC0315a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b in(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return io(str);
    }

    public b io(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e arv = e.arv();
        if (arv == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-Storage", str);
        b bVar = (b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        } else if (com.baidu.swan.apps.storage.c.pP(optString)) {
            return new b(1001, "exceed storage key max length");
        } else {
            String optString2 = jSONObject.optString("data");
            if (com.baidu.swan.apps.storage.c.pQ(optString2)) {
                return new b(1001, "exceed storage item max length");
            }
            com.baidu.swan.apps.storage.c arG = arv.arG();
            if (!arG.available() && arG.auG().getString(optString, "").length() < optString2.length()) {
                if (DEBUG) {
                    c.e("Api-Storage", "not available");
                }
                return new b(1001, "not available");
            }
            arG.auG().putString(optString, optString2);
            com.baidu.swan.apps.an.e.cRi.update();
            return new b(0);
        }
    }

    public b VY() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return VZ();
    }

    public b VZ() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e arv = e.arv();
        if (arv == null) {
            return new b(1001, "swan app is null");
        }
        arv.arG().auG().edit().clear().apply();
        com.baidu.swan.apps.an.e.cRi.update();
        return new b(0);
    }

    public b ip(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return iq(str);
    }

    public b iq(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e arv = e.arv();
        if (arv == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-Storage", str);
        b bVar = (b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aS.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        arv.arG().auG().remove(optString);
        com.baidu.swan.apps.an.e.cRi.update();
        return new b(0);
    }

    public b ir(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0315a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0315a
            public b a(e eVar, String str2) {
                String string = eVar.arG().auG().getString(str2, "");
                try {
                    JSONObject it = a.it(string);
                    if (it == null) {
                        it = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        it.put("data", string);
                    }
                    return new b(0, it);
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b is(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0315a() { // from class: com.baidu.swan.apps.api.module.i.a.2
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0315a
            public b a(e eVar, String str2) {
                String string = eVar.arG().auG().getString(str2, "");
                try {
                    JSONObject it = a.it(string);
                    if (it == null) {
                        it = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        it.put("data", string);
                    }
                    return new b(0, it);
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b Wa() {
        e arv = e.arv();
        if (arv == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c arG = arv.arG();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) arG.auG().auU()));
            jSONObject.put("currentSize", arG.auI() / 1024);
            jSONObject.put("limitSize", arG.auJ() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0315a interfaceC0315a) {
        e arv = e.arv();
        if (arv == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-Storage", str);
        b bVar = (b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aS.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0315a.a(arv, optString);
    }

    public static JSONObject it(String str) {
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
