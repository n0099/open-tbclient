package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a eba;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.eba = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void onLoadSuccess() {
        if (this.eba != null) {
            this.eba.onSuccess();
        }
    }

    public void vz(String str) {
        JSONObject vw = vw(str);
        if (this.eba != null) {
            this.eba.ad(vw);
        }
    }

    private JSONObject vw(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.c.a.p);
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.vu(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
