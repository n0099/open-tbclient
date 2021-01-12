package com.baidu.swan.apps.ac.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b bA(JSONObject jSONObject) {
        return null;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    String aEx() {
        return "mapp_choose_address";
    }

    @Override // com.baidu.swan.apps.ac.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        final com.baidu.swan.apps.ac.c.c.a aVar2 = new com.baidu.swan.apps.ac.c.c.a(bVar.cJc);
        aVar2.cJd = bVar.cJd;
        if (aVar == null || aVar.dIj.aMM() == 10003) {
            com.baidu.swan.apps.ac.d.a.print("user denied");
            bVar2.N(aVar2);
            return;
        }
        com.baidu.swan.apps.ac.d.a.print("obtain address detail");
        com.baidu.swan.apps.t.a.awE().a(swanAppActivity, str, str, new com.baidu.swan.apps.b.a.b() { // from class: com.baidu.swan.apps.ac.c.d.c.1
            @Override // com.baidu.swan.apps.b.a.b
            public void aH(JSONObject jSONObject) {
                com.baidu.swan.apps.ac.d.a.print("obtain address success");
                aVar2.isSuccess = true;
                if (jSONObject != null) {
                    aVar2.dqo = jSONObject.toString();
                }
                bVar2.N(aVar2);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void fX(int i) {
                com.baidu.swan.apps.ac.d.a.print("obtain address failure, errCode = " + i);
                bVar2.N(aVar2);
            }
        });
    }
}
