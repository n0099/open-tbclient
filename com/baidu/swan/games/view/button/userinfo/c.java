package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {

    /* loaded from: classes9.dex */
    public interface a {
        void cJ(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.aDG().aDq() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.aDG().aDq(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.dMd != null) {
                        com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback success: ", aVar2.dMd);
                        aVar.cJ(aVar2.dMd);
                        return;
                    }
                    aVar.cJ(null);
                }
            });
        }
    }
}
