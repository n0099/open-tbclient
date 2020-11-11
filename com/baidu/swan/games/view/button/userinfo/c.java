package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {

    /* loaded from: classes10.dex */
    public interface a {
        void cF(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.azO().azy() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.azO().azy(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.dyh != null) {
                        com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback success: ", aVar2.dyh);
                        aVar.cF(aVar2.dyh);
                        return;
                    }
                    aVar.cF(null);
                }
            });
        }
    }
}
