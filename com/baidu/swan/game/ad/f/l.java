package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class l {
    private static final boolean c = com.baidu.swan.apps.b.DEBUG;
    public JsFunction bxd;
    public JsFunction bxe;

    public static l d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.bxd = cVar.jD("success");
        lVar.bxe = cVar.jD(LivenessStat.TYPE_FACE_MATCH_FAIL);
        return lVar;
    }

    public void a() {
        if (this.bxd != null) {
            this.bxd.call();
        }
    }

    public void a(String str) {
        JSONObject jq = jq(str);
        if (this.bxe != null) {
            this.bxe.call(jq);
        }
    }

    private JSONObject jq(String str) {
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
