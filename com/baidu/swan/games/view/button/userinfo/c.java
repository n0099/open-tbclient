package com.baidu.swan.games.view.button.userinfo;

import com.baidu.swan.apps.w.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.games.view.button.base.c {

    /* loaded from: classes11.dex */
    public interface a {
        void bT(JSONObject jSONObject);
    }

    public void a(final a aVar) {
        if (aVar != null && f.ahV().ahF() != null) {
            com.baidu.swan.apps.setting.b.a.a(f.ahV().ahF(), "snsapi_userinfo", null, true, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.games.view.button.userinfo.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.b.a aVar2) {
                    if (aVar2 != null && aVar2.cEG != null) {
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback success: " + aVar2.cEG);
                        aVar.bT(aVar2.cEG);
                        return;
                    }
                    aVar.bT(null);
                }
            });
        }
    }
}
