package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a edF;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.edF = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aWF() {
        if (this.edF != null) {
            this.edF.onSuccess();
        }
    }

    public void ws(String str) {
        JSONObject wo = wo(str);
        if (this.edF != null) {
            this.edF.ad(wo);
        }
    }

    private JSONObject wo(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.c.a.p);
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.wm(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
