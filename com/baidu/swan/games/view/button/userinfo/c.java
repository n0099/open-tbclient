package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public interface a {
        void cp(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.asJ().ast() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.asJ().ast(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void J(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.cXD != null) {
                        com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback success: ", aVar2.cXD);
                        aVar.cp(aVar2.cXD);
                        return;
                    }
                    aVar.cp(null);
                }
            });
        }
    }
}
