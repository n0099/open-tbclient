package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a cjj;

    public static k e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.cjj = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void akU() {
        if (this.cjj != null) {
            this.cjj.onSuccess();
        }
    }

    public void nV(String str) {
        JSONObject nS = nS(str);
        if (this.cjj != null) {
            this.cjj.S(nS);
        }
    }

    private JSONObject nS(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", LivenessStat.TYPE_FACE_MATCH_FAIL);
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.nQ(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
