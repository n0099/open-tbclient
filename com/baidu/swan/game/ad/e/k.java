package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a ecB;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.ecB = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void onLoadSuccess() {
        if (this.ecB != null) {
            this.ecB.onSuccess();
        }
    }

    public void vG(String str) {
        JSONObject vD = vD(str);
        if (this.ecB != null) {
            this.ecB.af(vD);
        }
    }

    private JSONObject vD(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.c.a.p);
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.vB(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
