package com.baidu.swan.bdprivate.api;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends d {

    /* loaded from: classes11.dex */
    public interface a {
        void qT(String str);
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b qW(String str) {
        e arw = e.arw();
        if (arw == null) {
            if (DEBUG) {
                Log.e("getOpenBduss", "getOpenBduss failed: null swan runtime");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Base", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final JSONObject jSONObject = (JSONObject) aS.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(201, "empty cb");
        }
        arw.arH().b(com.baidu.swan.apps.runtime.d.arr(), "scope_get_open_bduss", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    int errorCode = hVar.getErrorCode();
                    String eE = com.baidu.swan.apps.setting.oauth.c.eE(errorCode);
                    if (d.DEBUG) {
                        Log.e("getOpenBduss", "getOpenBduss failed: auth fail(" + errorCode + ", " + eE + ")");
                    }
                    b.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.eE(errorCode)));
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
        if (!com.baidu.swan.bdprivate.a.a.cM(com.baidu.swan.apps.runtime.d.arr())) {
            a(str2, new com.baidu.swan.apps.api.c.b(202, "user is not logged in or the params are invalid"));
        } else {
            com.baidu.swan.bdprivate.a.a.a(com.baidu.swan.apps.runtime.d.arr(), str, arrayList, new a() { // from class: com.baidu.swan.bdprivate.api.b.2
                @Override // com.baidu.swan.bdprivate.api.b.a
                public void qT(String str3) {
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
