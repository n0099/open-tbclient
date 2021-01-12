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
    public interface InterfaceC0384a {
        b a(e eVar, String str);
    }

    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public b kH(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return kI(str);
    }

    public b kI(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new b(1001, "exceed storage item max length");
        }
        e aIr = e.aIr();
        if (aIr == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-Storage", str);
        b bVar = (b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bn.second;
        String aX = aX(jSONObject);
        if (aX == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.sR(aX)) {
            return new b(1001, "exceed storage key max length");
        }
        String aW = aW(jSONObject);
        if (aW == null) {
            return new b(202);
        }
        if (com.baidu.swan.apps.storage.c.sS(aW)) {
            return new b(1001, "exceed storage item max length");
        }
        com.baidu.swan.apps.storage.c aIC = aIr.aIC();
        if (aIC.cI(aX, aW)) {
            if (DEBUG) {
                c.e("Api-Storage", "exceed storage max length");
            }
            return new b(1003, "exceed storage max length");
        }
        aIC.aLy().putString(aX, aW);
        com.baidu.swan.apps.al.e.dMa.update();
        return new b(0);
    }

    public b ajK() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return ajL();
    }

    public b ajL() {
        if (DEBUG) {
            Log.d("Api-Storage", "start clear storage");
        }
        e aIr = e.aIr();
        if (aIr == null) {
            return new b(1001, "swan app is null");
        }
        aIr.aIC().aLy().edit().clear().apply();
        com.baidu.swan.apps.al.e.dMa.update();
        return new b(0);
    }

    public b kJ(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return kK(str);
    }

    public b kK(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start remove storage");
        }
        e aIr = e.aIr();
        if (aIr == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-Storage", str);
        b bVar = (b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aX = aX((JSONObject) bn.second);
        if (aX == null) {
            return new b(202);
        }
        aIr.aIC().aLy().remove(aX);
        com.baidu.swan.apps.al.e.dMa.update();
        return new b(0);
    }

    public b kL(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return kM(str);
    }

    public b kM(String str) {
        if (DEBUG) {
            Log.d("Api-Storage", "start get storage");
        }
        return a(str, new InterfaceC0384a() { // from class: com.baidu.swan.apps.api.module.i.a.1
            @Override // com.baidu.swan.apps.api.module.i.a.InterfaceC0384a
            public b a(e eVar, String str2) {
                String string = eVar.aIC().aLy().getString(str2, null);
                if (string == null && com.baidu.swan.apps.storage.c.dJL) {
                    return new b(1002, "data not found");
                }
                JSONObject kN = a.kN(string);
                if (kN == null) {
                    return new b(202, "JSONException");
                }
                return new b(0, kN);
            }
        });
    }

    public b ajM() {
        e aIr = e.aIr();
        if (aIr == null) {
            return new b(1001, "swan app is null");
        }
        com.baidu.swan.apps.storage.c aIC = aIr.aIC();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) aIC.aLy().aLN()));
            jSONObject.put("currentSize", aIC.aLA() / 1024);
            jSONObject.put("limitSize", aIC.aLB() / 1024);
            return new b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new b(202, "JSONException");
        }
    }

    private b a(String str, InterfaceC0384a interfaceC0384a) {
        e aIr = e.aIr();
        if (aIr == null) {
            return new b(1001, "swan app is null");
        }
        Pair<b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-Storage", str);
        b bVar = (b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Storage", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String aX = aX((JSONObject) bn.second);
        if (aX == null) {
            return new b(202);
        }
        return interfaceC0384a.a(aIr, aX);
    }

    @Nullable
    public static JSONObject kN(@Nullable String str) {
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
    public static String aW(@NonNull JSONObject jSONObject) {
        if (com.baidu.swan.apps.storage.c.dJM) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String aX(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }
}
