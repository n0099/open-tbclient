package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dYT;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dYT = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aSM() {
        if (this.dYT != null) {
            this.dYT.onSuccess();
        }
    }

    public void vh(String str) {
        JSONObject vd = vd(str);
        if (this.dYT != null) {
            this.dYT.ad(vd);
        }
    }

    private JSONObject vd(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.c.a.p);
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.vb(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
