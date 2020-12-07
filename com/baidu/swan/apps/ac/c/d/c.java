package com.baidu.swan.apps.ac.c.d;

import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b bs(JSONObject jSONObject) {
        return null;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    String aGX() {
        return "mapp_choose_address";
    }

    @Override // com.baidu.swan.apps.ac.c.d.a
    void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        final com.baidu.swan.apps.ac.c.c.a aVar2 = new com.baidu.swan.apps.ac.c.c.a(bVar.cIV);
        aVar2.cIW = bVar.cIW;
        if (aVar == null || aVar.dEr.aOo() == 10003) {
            com.baidu.swan.apps.ac.d.a.print("user denied");
            bVar2.O(aVar2);
            return;
        }
        com.baidu.swan.apps.ac.d.a.print("obtain address detail");
        com.baidu.swan.apps.t.a.azg().a(swanAppActivity, str, str, new com.baidu.swan.apps.b.a.b() { // from class: com.baidu.swan.apps.ac.c.d.c.1
            @Override // com.baidu.swan.apps.b.a.b
            public void az(JSONObject jSONObject) {
                com.baidu.swan.apps.ac.d.a.print("obtain address success");
                aVar2.isSuccess = true;
                if (jSONObject != null) {
                    aVar2.dqe = jSONObject.toString();
                }
                bVar2.O(aVar2);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void hK(int i) {
                com.baidu.swan.apps.ac.d.a.print("obtain address failure, errCode = " + i);
                bVar2.O(aVar2);
            }
        });
    }
}
