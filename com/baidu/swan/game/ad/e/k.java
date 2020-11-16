package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.binding.model.a dNK;

    public static k d(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.dNK = com.baidu.swan.games.binding.model.a.f(cVar);
        return kVar;
    }

    public void aRf() {
        if (this.dNK != null) {
            this.dNK.onSuccess();
        }
    }

    public void vL(String str) {
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
