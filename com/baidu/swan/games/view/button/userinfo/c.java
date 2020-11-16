package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.v.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public interface a {
        void cz(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.azg().ayQ() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.azg().ayQ(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.dwA != null) {
                        com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback success: ", aVar2.dwA);
                        aVar.cz(aVar2.dwA);
                        return;
                    }
                    aVar.cz(null);
                }
            });
        }
    }
}
