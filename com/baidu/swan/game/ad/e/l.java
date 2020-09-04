package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dmW;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dmW = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aKa() {
        if (this.dmW != null) {
            this.dmW.onSuccess();
        }
    }

    public void uf(String str) {
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
