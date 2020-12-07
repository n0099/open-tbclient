package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dUI;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dUI = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aUl() {
        if (this.dUI != null) {
            this.dUI.onSuccess();
        }
    }

    public void wt(String str) {
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
