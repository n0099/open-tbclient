package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a ceS;

    public static j d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        j jVar = new j();
        jVar.ceS = com.baidu.swan.games.binding.model.a.f(cVar);
        return jVar;
    }

    public void aiA() {
        if (this.ceS != null) {
            this.ceS.onSuccess();
        }
    }

    public void nG(String str) {
        JSONObject nE = nE(str);
        if (this.ceS != null) {
            this.ceS.Q(nE);
        }
    }

    private JSONObject nE(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", LivenessStat.TYPE_FACE_MATCH_FAIL);
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.nC(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
