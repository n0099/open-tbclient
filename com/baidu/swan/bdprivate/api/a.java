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
/* loaded from: classes3.dex */
public class a extends d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public com.baidu.swan.apps.api.c.b tr(String str) {
        return a(str, new com.baidu.swan.apps.api.a.c("getBDUSS") { // from class: com.baidu.swan.bdprivate.api.a.1
            @Override // com.baidu.swan.apps.api.a.c
            protected boolean act() {
                return com.baidu.swan.apps.runtime.d.aAn().ayA() && com.baidu.swan.apps.runtime.d.aAn().aAj().aAD().rt("mapp_i_get_bduss");
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull final c.a aVar) {
                e aAs = e.aAs();
                if (aAs == null) {
                    if (d.DEBUG) {
                        Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                    }
                    return new com.baidu.swan.apps.api.c.b(1001, "null swan runtime");
                }
                aAs.aAD().b(com.baidu.swan.apps.runtime.d.aAn(), "mapp_i_get_bduss", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void J(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            aVar.b(a.this.aHf());
                            return;
                        }
                        int errorCode = hVar.getErrorCode();
                        String gL = com.baidu.swan.apps.setting.oauth.c.gL(errorCode);
                        if (d.DEBUG) {
                            Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + errorCode + ", " + gL + ")");
                        }
                        aVar.b(new com.baidu.swan.apps.api.c.b(errorCode, gL));
                    }
                });
                return new com.baidu.swan.apps.api.c.b(0);
            }

            @Override // com.baidu.swan.apps.api.a.c
            @NonNull
            protected com.baidu.swan.apps.api.c.b as(@NonNull JSONObject jSONObject) {
                return a.this.aHf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.baidu.swan.apps.api.c.b aHf() {
        String cS = com.baidu.swan.bdprivate.a.a.cS(com.baidu.swan.apps.runtime.d.aAn());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", cS);
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
