package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public class m {
    public static JSONObject ua(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.tY(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject gu(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isEnded", z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
