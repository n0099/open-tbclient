package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class l {
    private static final boolean c = com.baidu.swan.apps.b.DEBUG;
    public JsFunction bdO;
    public JsFunction bdP;

    public static l d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.bdO = cVar.iR("success");
        lVar.bdP = cVar.iR(LivenessStat.TYPE_FACE_MATCH_FAIL);
        return lVar;
    }

    public void a() {
        if (this.bdO != null) {
            this.bdO.call();
        }
    }

    public void a(String str) {
        JSONObject iF = iF(str);
        if (this.bdP != null) {
            this.bdP.call(iF);
        }
    }

    private JSONObject iF(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", LivenessStat.TYPE_FACE_MATCH_FAIL);
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.a(str));
        } catch (Exception e) {
            if (c) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
