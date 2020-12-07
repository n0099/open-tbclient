package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public class m {
    public static JSONObject wp(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.wn(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject hD(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isEnded", z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
