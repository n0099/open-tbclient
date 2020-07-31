package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dcJ;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.dcJ = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void aBj() {
        if (this.dcJ != null) {
            this.dcJ.onSuccess();
        }
    }

    public void rL(String str) {
        JSONObject rH = rH(str);
        if (this.dcJ != null) {
            this.dcJ.Y(rH);
        }
    }

    private JSONObject rH(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.rF(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
