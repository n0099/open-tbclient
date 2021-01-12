package com.baidu.ar.vo.a;

import com.baidu.ar.h.i;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static b aW(String str) {
        File file = new File(str, "targets.json");
        if (file.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(i.f(file));
                if (jSONObject != null) {
                    return i(jSONObject.optJSONObject("slam_model"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static b i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            if (jSONObject.has("id")) {
                bVar.setId(jSONObject.getString("id"));
            }
            if (jSONObject.has("place_type")) {
                bVar.T(jSONObject.getInt("place_type"));
            }
            if (jSONObject.has("position")) {
                bVar.aX(jSONObject.getString("position"));
            }
            if (jSONObject.has("distance")) {
                bVar.U(jSONObject.getInt("distance"));
            }
            if (jSONObject.has("pitch_angle")) {
                bVar.V(jSONObject.getInt("pitch_angle"));
            }
            if (jSONObject.has("rotation")) {
                bVar.aY(jSONObject.getString("rotation"));
            }
            if (jSONObject.has("immediately_place_model")) {
                bVar.V(jSONObject.getInt("immediately_place_model") == 1);
                return bVar;
            }
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return bVar;
        }
    }
}
