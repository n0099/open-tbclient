package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.w.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.games.view.button.base.c {

    /* loaded from: classes2.dex */
    public interface a {
        void aW(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && e.LD().Lp() != null) {
            com.baidu.swan.apps.setting.b.a.a(e.LD().Lp(), "snsapi_userinfo", "1", new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.boV != null) {
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback success: " + aVar2.boV);
                        aVar.aW(aVar2.boV);
                        return;
                    }
                    aVar.aW(null);
                }
            });
        }
    }
}
