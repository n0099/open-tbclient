package com.baidu.swan.apps.ad.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.ad.c.d.b
    com.baidu.swan.apps.api.c.b aW(JSONObject jSONObject) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ad.c.d.b
    public String aoM() {
        return "mapp_choose_address";
    }

    @Override // com.baidu.swan.apps.ad.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ad.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a> bVar2) {
        final com.baidu.swan.apps.ad.c.c.a aVar2 = new com.baidu.swan.apps.ad.c.c.a(bVar.bVl);
        aVar2.bVm = bVar.bVm;
        if (aVar == null || aVar.cNv.avT() == 10003) {
            com.baidu.swan.apps.ad.d.a.print("user denied");
            bVar2.J(aVar2);
            return;
        }
        com.baidu.swan.apps.ad.d.a.print("obtain address detail");
        com.baidu.swan.apps.t.a.ahp().a(swanAppActivity, str, str, new com.baidu.swan.apps.b.a.b() { // from class: com.baidu.swan.apps.ad.c.d.c.1
            @Override // com.baidu.swan.apps.b.a.b
            public void ai(JSONObject jSONObject) {
                com.baidu.swan.apps.ad.d.a.print("obtain address success");
                aVar2.isSuccess = true;
                if (jSONObject != null) {
                    aVar2.cAa = jSONObject.toString();
                }
                bVar2.J(aVar2);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void er(int i) {
                com.baidu.swan.apps.ad.d.a.print("obtain address failure, errCode = " + i);
                bVar2.J(aVar2);
            }
        });
    }
}
