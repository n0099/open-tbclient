package com.baidu.swan.gamecenter.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        super("authorize");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull final com.baidu.swan.apps.o.b bVar) {
        if (DEBUG && jSONObject.optBoolean(ETAG.KEY_DEBUG, false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.ao(null);
        } else {
            e aAs = e.aAs();
            if (aAs == null) {
                bVar.onFail(10001, "authorize fail.");
            } else {
                aAs.aAD().e("mapp_gamecenter_private_api", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.gamecenter.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: c */
                    public void J(com.baidu.swan.apps.setting.oauth.e eVar) {
                        boolean z = true;
                        if ((eVar == null || eVar.forbidden || eVar.cXo != 1) ? false : false) {
                            bVar.ao(null);
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
