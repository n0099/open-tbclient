package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class k {
    private static final boolean c = com.baidu.swan.apps.b.DEBUG;
    public JsFunction bfa;
    public JsFunction bfc;

    public static k c(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.bfa = cVar.ja("success");
        kVar.bfc = cVar.ja(LivenessStat.TYPE_FACE_MATCH_FAIL);
        return kVar;
    }

    public void a() {
        if (this.bfa != null) {
            this.bfa.call();
        }
    }

    public void a(String str) {
        JSONObject iN = iN(str);
        if (this.bfc != null) {
            this.bfc.call(iN);
        }
    }

    private JSONObject iN(String str) {
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
