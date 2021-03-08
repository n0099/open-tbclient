package com.baidu.swan.bdprivate.api;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d {

    /* loaded from: classes8.dex */
    public interface a {
        void uy(String str);
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b uB(String str) {
        e aIO = e.aIO();
        if (aIO == null) {
            if (DEBUG) {
                Log.e("getOpenBduss", "getOpenBduss failed: null swan runtime");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final JSONObject jSONObject = (JSONObject) bh.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        }
        aIO.aIZ().b(com.baidu.swan.apps.runtime.d.aIJ(), "scope_get_open_bduss", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    int errorCode = hVar.getErrorCode();
                    String gp = com.baidu.swan.apps.setting.oauth.c.gp(errorCode);
                    if (d.DEBUG) {
                        Log.e("getOpenBduss", "getOpenBduss failed: auth fail(" + errorCode + ", " + gp + ")");
                    }
                    b.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gp(errorCode)));
                    return;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("tpls");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                b.this.a(jSONObject.optString("clientId"), arrayList, optString);
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, ArrayList<String> arrayList, final String str2) {
        if (!com.baidu.swan.bdprivate.a.a.dT(com.baidu.swan.apps.runtime.d.aIJ())) {
            a(str2, new com.baidu.swan.apps.api.c.b(202, "user is not logged in or the params are invalid"));
        } else {
            com.baidu.swan.bdprivate.a.a.a(com.baidu.swan.apps.runtime.d.aIJ(), str, arrayList, new a() { // from class: com.baidu.swan.bdprivate.api.b.2
                @Override // com.baidu.swan.bdprivate.api.b.a
                public void uy(String str3) {
                    try {
                        b.this.a(str2, new com.baidu.swan.apps.api.c.b(0, new JSONObject(str3)));
                    } catch (JSONException e) {
                        b.this.a(str2, new com.baidu.swan.apps.api.c.b(10001, "internal error"));
                        if (d.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
