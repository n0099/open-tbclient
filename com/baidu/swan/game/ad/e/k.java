package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dUI;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.dUI = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void aUk() {
        if (this.dUI != null) {
            this.dUI.onSuccess();
        }
    }

    public void ws(String str) {
        JSONObject wp = wp(str);
        if (this.dUI != null) {
            this.dUI.ac(wp);
        }
    }

    private JSONObject wp(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.wn(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
