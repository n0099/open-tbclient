package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dBd;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dBd = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aNu() {
        if (this.dBd != null) {
            this.dBd.onSuccess();
        }
    }

    public void vk(String str) {
        JSONObject vg = vg(str);
        if (this.dBd != null) {
            this.dBd.ac(vg);
        }
    }

    private JSONObject vg(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.ve(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
