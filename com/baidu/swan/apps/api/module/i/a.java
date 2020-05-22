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
/* loaded from: classes11.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0309a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b hV(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return hW(str);
    }

    public b hW(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aoF = e.aoF();
        if (aoF == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-Storage", str);
        b bVar = (b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        } else if (com.baidu.swan.apps.storage.c.oW(optString)) {
            return new b(1001, "exceed storage key max length");
        } else {
            String optString2 = jSONObject.optString("data");
            if (com.baidu.swan.apps.storage.c.oX(optString2)) {
                return new b(1001, "exceed storage item max length");
            }
            com.baidu.swan.apps.storage.c aoQ = aoF.aoQ();
            if (!aoQ.available() && aoQ.ary().getString(optString, "").length() < optString2.length()) {
                if (DEBUG) {
                    c.e("Api-Storage", "not available");
                }
                return new b(1001, "not available");
            }
            aoQ.ary().putString(optString, optString2);
            com.baidu.swan.apps.an.e.cJd.update();
            return new b(0);
        }
    }

    public b Um() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return Un();
    }

    public b Un() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aoF = e.aoF();
        if (aoF == null) {
            return new b(1001, "swan app is null");
        }
        aoF.aoQ().ary().edit().clear().apply();
        com.baidu.swan.apps.an.e.cJd.update();
        return new b(0);
    }

    public b hX(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return hY(str);
    }

    public b hY(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aoF = e.aoF();
        if (aoF == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-Storage", str);
        b bVar = (b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aP.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        aoF.aoQ().ary().remove(optString);
        com.baidu.swan.apps.an.e.cJd.update();
        return new b(0);
    }

    public b hZ(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0309a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0309a
            public b a(e eVar, String str2) {
                String string = eVar.aoQ().ary().getString(str2, "");
                try {
                    JSONObject ib = a.ib(string);
                    if (ib == null) {
                        ib = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        ib.put("data", string);
                    }
                    return new b(0, ib);
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b ia(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0309a() { // from class: com.baidu.swan.apps.api.module.i.a.2
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0309a
            public b a(e eVar, String str2) {
                String string = eVar.aoQ().ary().getString(str2, "");
                try {
                    JSONObject ib = a.ib(string);
                    if (ib == null) {
                        ib = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        ib.put("data", string);
                    }
                    return new b(0, ib);
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b Uo() {
        e aoF = e.aoF();
        if (aoF == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aoQ = aoF.aoQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aoQ.ary().arM()));
            jSONObject.put("currentSize", aoQ.arA() / 1024);
            jSONObject.put("limitSize", aoQ.arB() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0309a interfaceC0309a) {
        e aoF = e.aoF();
        if (aoF == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-Storage", str);
        b bVar = (b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aP.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0309a.a(aoF, optString);
    }

    public static JSONObject ib(String str) {
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
