package com.baidu.swan.apps.ae.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.ae.c.d.b
    com.baidu.swan.apps.api.c.b aN(JSONObject jSONObject) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ae.c.d.b
    public String alX() {
        return "mapp_choose_address";
    }

    @Override // com.baidu.swan.apps.ae.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ae.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a> bVar2) {
        final com.baidu.swan.apps.ae.c.c.a aVar2 = new com.baidu.swan.apps.ae.c.c.a(bVar.bPF);
        aVar2.bPG = bVar.bPG;
        if (aVar == null || aVar.cFu.asM() == 10003) {
            com.baidu.swan.apps.ae.d.a.print("user denied");
            bVar2.K(aVar2);
            return;
        }
        com.baidu.swan.apps.ae.d.a.print("obtain address detail");
        com.baidu.swan.apps.u.a.aeX().a(swanAppActivity, str, str, new com.baidu.swan.apps.b.a.b() { // from class: com.baidu.swan.apps.ae.c.d.c.1
            @Override // com.baidu.swan.apps.b.a.b
            public void ab(JSONObject jSONObject) {
                com.baidu.swan.apps.ae.d.a.print("obtain address success");
                aVar2.isSuccess = true;
                if (jSONObject != null) {
                    aVar2.csM = jSONObject.toString();
                }
                bVar2.K(aVar2);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void ek(int i) {
                com.baidu.swan.apps.ae.d.a.print("obtain address failure, errCode = " + i);
                bVar2.K(aVar2);
            }
        });
    }
}
