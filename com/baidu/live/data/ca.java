package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ca {
    private as aOW;
    private as aOX;
    private as aOY;
    private as aOZ;

    public static ca gm(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ca caVar = new ca();
            caVar.parse(jSONObject);
            return caVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(ca caVar) {
        if (caVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (caVar.aOW != null) {
                jSONObject.put("change_mode", caVar.aOW.toJson());
            }
            if (caVar.aOX != null) {
                jSONObject.put("match_success", caVar.aOX.toJson());
            }
            if (caVar.aOY != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, caVar.aOY.toJson());
            }
            if (caVar.aOZ != null) {
                jSONObject.put("red_package_rain", caVar.aOZ.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOW = new as();
            this.aOW.parse(jSONObject.optJSONObject("change_mode"));
            this.aOX = new as();
            this.aOX.parse(jSONObject.optJSONObject("match_success"));
            this.aOY = new as();
            this.aOY.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aOZ = new as();
            this.aOZ.parse(jSONObject.optJSONObject("red_package_rain"));
        }
    }

    public as Ej() {
        return this.aOW;
    }

    public as Ek() {
        return this.aOX;
    }

    public as El() {
        return this.aOY;
    }

    public as Em() {
        return this.aOZ;
    }
}
