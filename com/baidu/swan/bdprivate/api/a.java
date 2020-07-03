package com.baidu.swan.bdprivate.api;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b qh(String str) {
        return a(str, new c("getBDUSS") { // from class: com.baidu.swan.bdprivate.api.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean UZ() {
                return com.baidu.swan.apps.runtime.d.apI().aok() && com.baidu.swan.apps.runtime.d.apI().apE().apY().ot("mapp_i_get_bduss");
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                e apN = e.apN();
                if (apN == null) {
                    if (d.DEBUG) {
                        Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                    }
                    return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
                }
                apN.apY().b(com.baidu.swan.apps.runtime.d.apI(), "mapp_i_get_bduss", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            aVar.a(a.this.avU());
                            return;
                        }
                        int errorCode = hVar.getErrorCode();
                        String gZ = com.baidu.swan.apps.setting.oauth.c.gZ(errorCode);
                        if (d.DEBUG) {
                            Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + errorCode + ", " + gZ + ")");
                        }
                        aVar.a(new com.baidu.swan.apps.api.c.b(errorCode, gZ));
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b am(@NonNull JSONObject jSONObject) {
                return a.this.avU();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.baidu.swan.apps.api.c.b avU() {
        String cI = com.baidu.swan.bdprivate.a.a.cI(com.baidu.swan.apps.runtime.d.apI());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", cI);
            if (DEBUG) {
                Log.d("Api-Base-getBduss", "getBduss success: " + jSONObject.toString());
            }
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("Api-Base-getBduss", "getBduss failed: JsonException");
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(1001, "result JSONException");
        }
    }
}
