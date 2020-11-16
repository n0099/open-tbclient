package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dNK;

    public static l e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.dNK = com.baidu.swan.games.binding.model.a.f(cVar);
        return lVar;
    }

    public void aRg() {
        if (this.dNK != null) {
            this.dNK.onSuccess();
        }
    }

    public void vM(String str) {
        JSONObject vI = vI(str);
        if (this.dNK != null) {
            this.dNK.ac(vI);
        }
    }

    private JSONObject vI(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.vG(str));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
