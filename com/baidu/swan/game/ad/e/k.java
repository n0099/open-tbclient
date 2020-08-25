package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dmS;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.dmS = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void aJZ() {
        if (this.dmS != null) {
            this.dmS.onSuccess();
        }
    }

    public void ud(String str) {
        JSONObject ua = ua(str);
        if (this.dmS != null) {
            this.dmS.Y(ua);
        }
    }

    private JSONObject ua(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.tY(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
