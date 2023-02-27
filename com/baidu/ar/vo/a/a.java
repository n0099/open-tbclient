package com.baidu.ar.vo.a;

import com.baidu.ar.h.i;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static b aW(String str) {
        File file = new File(str, "targets.json");
        if (file.exists()) {
            try {
                return i(new JSONObject(i.f(file)).optJSONObject("slam_model"));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static b i(JSONObject jSONObject) {
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
            if (jSONObject.has(CriusAttrConstants.POSITION)) {
                bVar.aX(jSONObject.getString(CriusAttrConstants.POSITION));
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
                boolean z = true;
                if (jSONObject.getInt("immediately_place_model") != 1) {
                    z = false;
                }
                bVar.V(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bVar;
    }
}
