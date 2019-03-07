package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.w.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.games.view.button.base.c {

    /* loaded from: classes2.dex */
    public interface a {
        void av(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && e.Ec().DO() != null) {
            com.baidu.swan.apps.setting.b.a.a(e.Ec().DO(), "snsapi_userinfo", "1", new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: a */
                public void D(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.aRQ != null) {
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback success: " + aVar2.aRQ);
                        aVar.av(aVar2.aRQ);
                        return;
                    }
                    aVar.av(null);
                }
            });
        }
    }
}
