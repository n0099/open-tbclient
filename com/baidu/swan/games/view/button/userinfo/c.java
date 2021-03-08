package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {

    /* loaded from: classes8.dex */
    public interface a {
        void cI(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.aAo().azY() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.aAo().azY(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.dKW != null) {
                        com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback success: ", aVar2.dKW);
                        aVar.cI(aVar2.dKW);
                        return;
                    }
                    aVar.cI(null);
                }
            });
        }
    }
}
