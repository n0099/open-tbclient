package com.baidu.ar.vo.a;

import com.baidu.ar.g.i;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static b aT(String str) {
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
                bVar.Q(jSONObject.getInt("place_type"));
            }
            if (jSONObject.has("position")) {
                bVar.aU(jSONObject.getString("position"));
            }
            if (jSONObject.has("distance")) {
                bVar.R(jSONObject.getInt("distance"));
            }
            if (jSONObject.has("pitch_angle")) {
                bVar.S(jSONObject.getInt("pitch_angle"));
            }
            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                bVar.aV(jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION));
            }
            if (jSONObject.has("immediately_place_model")) {
                bVar.X(jSONObject.getInt("immediately_place_model") == 1);
                return bVar;
            }
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return bVar;
        }
    }
}
