package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", LivenessStat.TYPE_FACE_MATCH_FAIL);
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.a(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", gVar.realWidth);
            jSONObject.put("height", gVar.realHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
