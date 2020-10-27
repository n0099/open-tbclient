package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dJA;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.dJA = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void aPn() {
        if (this.dJA != null) {
            this.dJA.onSuccess();
        }
    }

    public void vC(String str) {
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
