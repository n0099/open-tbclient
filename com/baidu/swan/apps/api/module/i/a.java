package com.baidu.swan.apps.api.module.i;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.api.c.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0387a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b lg(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return lh(str);
    }

    public b lh(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aIN = e.aIN();
        if (aIN == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Storage", str);
        b bVar = (b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bh.second;
        String aW = aW(jSONObject);
        if (aW == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.tr(aW)) {
            return new b(1001, "exceed storage key max length");
        }
        String aV = aV(jSONObject);
        if (aV == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.ts(aV)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aIY = aIN.aIY();
        if (aIY.cC(aW, aV)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aIY.aLU().putString(aW, aV);
        com.baidu.swan.apps.al.e.dPF.update();
        return new b(0);
    }

    public b akl() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return akm();
    }

    public b akm() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aIN = e.aIN();
        if (aIN == null) {
            return new b(1001, "swan app is null");
        }
        aIN.aIY().aLU().edit().clear().apply();
        com.baidu.swan.apps.al.e.dPF.update();
        return new b(0);
    }

    public b li(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return lj(str);
    }

    public b lj(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aIN = e.aIN();
        if (aIN == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Storage", str);
        b bVar = (b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aW = aW((JSONObject) bh.second);
        if (aW == null) {
            return new b(202);
        }
        aIN.aIY().aLU().remove(aW);
        com.baidu.swan.apps.al.e.dPF.update();
        return new b(0);
    }

    public b lk(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return ll(str);
    }

    public b ll(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0387a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0387a
            public b a(e eVar, String str2) {
                String string = eVar.aIY().aLU().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dNq) {
                    return new b(1002, "data not found");
                }
                JSONObject lm = a.lm(string);
                if (lm == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, lm);
            }
        });
    }

    public b akn() {
        e aIN = e.aIN();
        if (aIN == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aIY = aIN.aIY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aIY.aLU().aMj()));
            jSONObject.put("currentSize", aIY.aLW() / 1024);
            jSONObject.put("limitSize", aIY.aLX() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0387a interfaceC0387a) {
        e aIN = e.aIN();
        if (aIN == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Storage", str);
        b bVar = (b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aW = aW((JSONObject) bh.second);
        if (aW == null) {
            return new b(202);
        }
        return interfaceC0387a.a(aIN, aW);
    }

    @Nullable
    public static JSONObject lm(@Nullable String str) {
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
    public static String aV(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dNr) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aW(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
