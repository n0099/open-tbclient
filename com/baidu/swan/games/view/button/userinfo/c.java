package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.y.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.games.view.button.base.c {

    /* loaded from: classes9.dex */
    public interface a {
        void bH(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.Uf().TQ() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.Uf().TQ(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.bOM != null) {
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback success: " + aVar2.bOM);
                        aVar.bH(aVar2.bOM);
                        return;
                    }
                    aVar.bH(null);
                }
            });
        }
    }
}
