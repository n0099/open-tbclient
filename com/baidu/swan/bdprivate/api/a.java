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
    public com.baidu.swan.apps.api.c.b qV(String str) {
        return a(str, new c("getBDUSS") { // from class: com.baidu.swan.bdprivate.api.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean VE() {
                return com.baidu.swan.apps.runtime.d.arr().apU() && com.baidu.swan.apps.runtime.d.arr().arn().arH().pc("mapp_i_get_bduss");
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                e arw = e.arw();
                if (arw == null) {
                    if (d.DEBUG) {
                        Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                    }
                    return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
                }
                arw.arH().b(com.baidu.swan.apps.runtime.d.arr(), "mapp_i_get_bduss", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            aVar.b(a.this.ayn());
                            return;
                        }
                        int errorCode = hVar.getErrorCode();
                        String eE = com.baidu.swan.apps.setting.oauth.c.eE(errorCode);
                        if (d.DEBUG) {
                            Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + errorCode + ", " + eE + ")");
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(errorCode, eE));
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b an(@NonNull JSONObject jSONObject) {
                return a.this.ayn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.baidu.swan.apps.api.c.b ayn() {
        String cN = com.baidu.swan.bdprivate.a.a.cN(com.baidu.swan.apps.runtime.d.arr());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", cN);
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
