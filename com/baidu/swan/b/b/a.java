package com.baidu.swan.b.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.b.d.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        super("authorize");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull final com.baidu.swan.apps.n.b bVar) {
        if (DEBUG && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.ah(null);
        } else {
            e apN = e.apN();
            if (apN == null) {
                bVar.onFail(10001, "authorize fail.");
            } else {
                apN.apY().d("mapp_gamecenter_private_api", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.b.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: c */
                    public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                        boolean z = true;
                        if ((eVar == null || eVar.forbidden || eVar.cJe != 1) ? false : false) {
                            bVar.ah(null);
                        } else {
                            bVar.onFail(10001, "authorize fail.");
                        }
                    }
                });
            }
        }
        return null;
    }
}
