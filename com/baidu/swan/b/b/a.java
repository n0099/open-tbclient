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
    public com.baidu.swan.apps.api.b.b b(@NonNull JSONObject jSONObject, @NonNull final com.baidu.swan.apps.p.b bVar) {
        if (DEBUG && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.K(null);
        } else {
            e acG = e.acG();
            if (acG == null) {
                bVar.onFail(10001, "authorize fail.");
            } else {
                acG.acP().d("mapp_gamecenter_private_api", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.b.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: c */
                    public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                        boolean z = true;
                        if ((eVar == null || eVar.forbidden || eVar.bTr != 1) ? false : false) {
                            bVar.K(null);
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
