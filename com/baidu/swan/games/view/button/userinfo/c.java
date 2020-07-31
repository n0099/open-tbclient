package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public interface a {
        void cg(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.akr().akb() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.akr().akb(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.cMD != null) {
                        com.baidu.swan.apps.console.c.c("OpenData", "onOpenDataCallback success: ", aVar2.cMD);
                        aVar.cg(aVar2.cMD);
                        return;
                    }
                    aVar.cg(null);
                }
            });
        }
    }
}
