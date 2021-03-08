package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a ecB;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.ecB = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aTb() {
        if (this.ecB != null) {
            this.ecB.onSuccess();
        }
    }

    public void vH(String str) {
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
