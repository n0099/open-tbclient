package com.baidu.swan.apps.ag.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b ax(JSONObject jSONObject) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ag.c.d.b
    public String aam() {
        return "mapp_choose_address";
    }

    @Override // com.baidu.swan.apps.ag.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        final com.baidu.swan.apps.ag.c.c.a aVar2 = new com.baidu.swan.apps.ag.c.c.a(bVar.biA);
        aVar2.biB = bVar.biB;
        if (aVar == null || aVar.bUE.agn() == 10003) {
            com.baidu.swan.apps.ag.d.a.print("user denied");
            bVar2.F(aVar2);
            return;
        }
        com.baidu.swan.apps.ag.d.a.print("obtain address detail");
        com.baidu.swan.apps.w.a.Uf().a(swanAppActivity, str, str, new com.baidu.swan.apps.b.a.b() { // from class: com.baidu.swan.apps.ag.c.d.c.1
            @Override // com.baidu.swan.apps.b.a.b
            public void L(JSONObject jSONObject) {
                com.baidu.swan.apps.ag.d.a.print("obtain address success");
                aVar2.isSuccess = true;
                if (jSONObject != null) {
                    aVar2.bII = jSONObject.toString();
                }
                bVar2.F(aVar2);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void dX(int i) {
                com.baidu.swan.apps.ag.d.a.print("obtain address failure, errCode = " + i);
                bVar2.F(aVar2);
            }
        });
    }
}
