package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a ciW;

    public static j d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        j jVar = new j();
        jVar.ciW = com.baidu.swan.games.binding.model.a.f(cVar);
        return jVar;
    }

    public void akO() {
        if (this.ciW != null) {
            this.ciW.onSuccess();
        }
    }

    public void nV(String str) {
        JSONObject nT = nT(str);
        if (this.ciW != null) {
            this.ciW.S(nT);
        }
    }

    private JSONObject nT(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", LivenessStat.TYPE_FACE_MATCH_FAIL);
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.nR(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
