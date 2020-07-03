package com.baidu.swan.game.ad.f;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a cXe;

    public static j d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        j jVar = new j();
        jVar.cXe = com.baidu.swan.games.binding.model.a.f(cVar);
        return jVar;
    }

    public void axT() {
        if (this.cXe != null) {
            this.cXe.onSuccess();
        }
    }

    public void qP(String str) {
        JSONObject qN = qN(str);
        if (this.cXe != null) {
            this.cXe.Y(qN);
        }
    }

    private JSONObject qN(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.qL(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
