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
    public interface InterfaceC0315a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b id(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return ie(str);
    }

    public b ie(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e apM = e.apM();
        if (apM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-Storage", str);
        b bVar = (b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aR.second;
        String optString = jSONObject.optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        } else if (com.baidu.swan.apps.storage.c.pe(optString)) {
            return new b(1001, "exceed storage key max length");
        } else {
            String optString2 = jSONObject.optString("data");
            if (com.baidu.swan.apps.storage.c.pf(optString2)) {
                return new b(1001, "exceed storage item max length");
            }
            com.baidu.swan.apps.storage.c apX = apM.apX();
            if (!apX.available() && apX.asF().getString(optString, "").length() < optString2.length()) {
                if (DEBUG) {
                    c.e("Api-Storage", "not available");
                }
                return new b(1001, "not available");
            }
            apX.asF().putString(optString, optString2);
            com.baidu.swan.apps.an.e.cNN.update();
            return new b(0);
        }
    }

    public b Vs() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return Vt();
    }

    public b Vt() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e apM = e.apM();
        if (apM == null) {
            return new b(1001, "swan app is null");
        }
        apM.apX().asF().edit().clear().apply();
        com.baidu.swan.apps.an.e.cNN.update();
        return new b(0);
    }

    /* renamed from: if  reason: not valid java name */
    public b m25if(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return ig(str);
    }

    public b ig(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e apM = e.apM();
        if (apM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-Storage", str);
        b bVar = (b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aR.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(1001, "empty key");
        }
        apM.apX().asF().remove(optString);
        com.baidu.swan.apps.an.e.cNN.update();
        return new b(0);
    }

    public b ih(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return a(str, new InterfaceC0315a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0315a
            public b a(e eVar, String str2) {
                String string = eVar.apX().asF().getString(str2, "");
                try {
                    JSONObject ij = a.ij(string);
                    if (ij == null) {
                        ij = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        ij.put("data", string);
                    }
                    return new b(0, ij);
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(1001, "JSONException");
                }
            }
        });
    }

    public b ii(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0315a() { // from class: com.baidu.swan.apps.api.module.i.a.2
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0315a
            public b a(e eVar, String str2) {
                String string = eVar.apX().asF().getString(str2, "");
                try {
                    JSONObject ij = a.ij(string);
                    if (ij == null) {
                        ij = new JSONObject();
                        if (TextUtils.isEmpty(string)) {
                            string = "";
                        }
                        ij.put("data", string);
                    }
                    return new b(0, ij);
                } catch (JSONException e) {
                    if (d.DEBUG) {
                        e.printStackTrace();
                    }
                    return new b(202, "JSONException");
                }
            }
        });
    }

    public b Vu() {
        e apM = e.apM();
        if (apM == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c apX = apM.apX();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) apX.asF().asT()));
            jSONObject.put("currentSize", apX.asH() / 1024);
            jSONObject.put("limitSize", apX.asI() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0315a interfaceC0315a) {
        e apM = e.apM();
        if (apM == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-Storage", str);
        b bVar = (b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aR.second).optString("key");
        if (TextUtils.isEmpty(optString)) {
            if (DEBUG) {
                c.e("Api-Storage", "empty key");
            }
            return new b(202, "empty key");
        }
        return interfaceC0315a.a(apM, optString);
    }

    public static JSONObject ij(String str) {
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
