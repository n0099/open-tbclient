package com.baidu.swan.game.ad.f;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static JSONObject nE(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", str);
            jSONObject.put("errMsg", LivenessStat.TYPE_FACE_MATCH_FAIL);
            jSONObject.put("errDes", com.baidu.swan.game.ad.e.b.nC(str));
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
