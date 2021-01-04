package com.baidu.swan.gamecenter.a;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        super("authorize");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull final com.baidu.swan.apps.o.b bVar) {
        if (DEBUG && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.aI(null);
        } else {
            e aMl = e.aMl();
            if (aMl == null) {
                bVar.onFail(10001, "authorize fail.");
            } else {
                aMl.aMw().e("mapp_gamecenter_private_api", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.gamecenter.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: c */
                    public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                        boolean z = true;
                        if ((eVar == null || eVar.forbidden || eVar.dLO != 1) ? false : false) {
                            bVar.aI(null);
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
