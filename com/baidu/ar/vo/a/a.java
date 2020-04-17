package com.baidu.ar.vo.a;

import com.baidu.ar.f.g;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static b aO(String str) {
        File file = new File(str, "targets.json");
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(g.f(file));
                if (jSONObject != null) {
                    return h(jSONObject.optJSONObject("slam_model"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static b h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            if (jSONObject.has("id")) {
                bVar.setId(jSONObject.getString("id"));
            }
            if (jSONObject.has("place_type")) {
                bVar.I(jSONObject.getInt("place_type"));
            }
            if (jSONObject.has("position")) {
                bVar.aP(jSONObject.getString("position"));
            }
            if (jSONObject.has("distance")) {
                bVar.J(jSONObject.getInt("distance"));
            }
            if (jSONObject.has("pitch_angle")) {
                bVar.K(jSONObject.getInt("pitch_angle"));
            }
            if (jSONObject.has("rotation")) {
                bVar.aQ(jSONObject.getString("rotation"));
            }
            if (jSONObject.has("immediately_place_model")) {
                bVar.W(jSONObject.getInt("immediately_place_model") == 1);
                return bVar;
            }
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return bVar;
        }
    }
}
