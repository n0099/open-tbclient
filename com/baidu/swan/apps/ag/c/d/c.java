package com.baidu.swan.apps.ag.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b aI(JSONObject jSONObject) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ag.c.d.b
    public String air() {
        return "mapp_choose_address";
    }

    @Override // com.baidu.swan.apps.ag.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        final com.baidu.swan.apps.ag.c.c.a aVar2 = new com.baidu.swan.apps.ag.c.c.a(bVar.bGI);
        aVar2.bGJ = bVar.bGJ;
        if (aVar == null || aVar.ctt.aos() == 10003) {
            com.baidu.swan.apps.ag.d.a.print("user denied");
            bVar2.G(aVar2);
            return;
        }
        com.baidu.swan.apps.ag.d.a.print("obtain address detail");
        com.baidu.swan.apps.w.a.abU().a(swanAppActivity, str, str, new com.baidu.swan.apps.b.a.b() { // from class: com.baidu.swan.apps.ag.c.d.c.1
            @Override // com.baidu.swan.apps.b.a.b
            public void W(JSONObject jSONObject) {
                com.baidu.swan.apps.ag.d.a.print("obtain address success");
                aVar2.isSuccess = true;
                if (jSONObject != null) {
                    aVar2.chr = jSONObject.toString();
                }
                bVar2.G(aVar2);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void ec(int i) {
                com.baidu.swan.apps.ag.d.a.print("obtain address failure, errCode = " + i);
                bVar2.G(aVar2);
            }
        });
    }
}
