package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dJA;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dJA = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aPo() {
        if (this.dJA != null) {
            this.dJA.onSuccess();
        }
    }

    public void vD(String str) {
        JSONObject vz = vz(str);
        if (this.dJA != null) {
            this.dJA.ac(vz);
        }
    }

    private JSONObject vz(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.vx(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
