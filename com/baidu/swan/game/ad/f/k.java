package com.baidu.swan.game.ad.f;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a cIk;

    public static k e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.cIk = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void ath() {
        if (this.cIk != null) {
            this.cIk.onSuccess();
        }
    }

    public void pk(String str) {
        JSONObject ph = ph(str);
        if (this.cIk != null) {
            this.cIk.U(ph);
        }
    }

    private JSONObject ph(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.pf(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
