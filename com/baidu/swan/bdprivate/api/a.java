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
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b uK(String str) {
        return a(str, new com.baidu.swan.apps.api.a.c("getBDUSS") { // from class: com.baidu.swan.bdprivate.api.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean ajz() {
                return com.baidu.swan.apps.runtime.d.aHq().aFD() && com.baidu.swan.apps.runtime.d.aHq().aHm().aHG().sN("mapp_i_get_bduss");
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                e aHv = e.aHv();
                if (aHv == null) {
                    if (d.DEBUG) {
                        Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                    }
                    return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
                }
                aHv.aHG().b(com.baidu.swan.apps.runtime.d.aHq(), "mapp_i_get_bduss", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            aVar.b(a.this.aOi());
                            return;
                        }
                        int errorCode = hVar.getErrorCode();
                        String hD = com.baidu.swan.apps.setting.oauth.c.hD(errorCode);
                        if (d.DEBUG) {
                            Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + errorCode + ", " + hD + ")");
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(errorCode, hD));
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b aI(@NonNull JSONObject jSONObject) {
                return a.this.aOi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.baidu.swan.apps.api.c.b aOi() {
        String cY = com.baidu.swan.bdprivate.a.a.cY(com.baidu.swan.apps.runtime.d.aHq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", cY);
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
