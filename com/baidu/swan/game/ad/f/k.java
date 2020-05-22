package com.baidu.swan.game.ad.f;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a cSu;

    public static k e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.cSu = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void awO() {
        if (this.cSu != null) {
            this.cSu.onSuccess();
        }
    }

    public void qI(String str) {
        JSONObject qF = qF(str);
        if (this.cSu != null) {
            this.cSu.Y(qF);
        }
    }

    private JSONObject qF(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.qD(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
