package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dPs;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dPs = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aRO() {
        if (this.dPs != null) {
            this.dPs.onSuccess();
        }
    }

    public void vR(String str) {
        JSONObject vN = vN(str);
        if (this.dPs != null) {
            this.dPs.ac(vN);
        }
    }

    private JSONObject vN(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.vL(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
