package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dmW;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.dmW = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void aJZ() {
        if (this.dmW != null) {
            this.dmW.onSuccess();
        }
    }

    public void ue(String str) {
        JSONObject ub = ub(str);
        if (this.dmW != null) {
            this.dmW.Y(ub);
        }
    }

    private JSONObject ub(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.tZ(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
