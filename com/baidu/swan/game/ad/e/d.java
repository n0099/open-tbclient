package com.baidu.swan.game.ad.e;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public class d {
    public static JSONObject vg(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", com.baidu.swan.game.ad.d.b.ve(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", fVar.realWidth);
            jSONObject.put("height", fVar.realHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
