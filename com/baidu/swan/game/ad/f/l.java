package com.baidu.swan.game.ad.f;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l {
    public static JSONObject qN(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.qL(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject fJ(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isEnded", z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
