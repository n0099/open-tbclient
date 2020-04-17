package com.baidu.swan.game.ad.f;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a cIe;

    public static j d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        j jVar = new j();
        jVar.cIe = com.baidu.swan.games.binding.model.a.f(cVar);
        return jVar;
    }

    public void atg() {
        if (this.cIe != null) {
            this.cIe.onSuccess();
        }
    }

    public void pj(String str) {
        JSONObject ph = ph(str);
        if (this.cIe != null) {
            this.cIe.T(ph);
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
