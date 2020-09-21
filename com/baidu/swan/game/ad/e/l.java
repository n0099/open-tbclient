package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a doZ;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.doZ = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aKL() {
        if (this.doZ != null) {
            this.doZ.onSuccess();
        }
    }

    public void uy(String str) {
        JSONObject uu = uu(str);
        if (this.doZ != null) {
            this.doZ.Z(uu);
        }
    }

    private JSONObject uu(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.us(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
