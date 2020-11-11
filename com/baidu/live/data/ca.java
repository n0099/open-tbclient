package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ca {
    private as aQH;
    private as aQI;
    private as aQJ;
    private as aQK;

    public static ca gt(String str) {
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
            if (caVar.aQH != null) {
                jSONObject.put("change_mode", caVar.aQH.toJson());
            }
            if (caVar.aQI != null) {
                jSONObject.put("match_success", caVar.aQI.toJson());
            }
            if (caVar.aQJ != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, caVar.aQJ.toJson());
            }
            if (caVar.aQK != null) {
                jSONObject.put("red_package_rain", caVar.aQK.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQH = new as();
            this.aQH.parse(jSONObject.optJSONObject("change_mode"));
            this.aQI = new as();
            this.aQI.parse(jSONObject.optJSONObject("match_success"));
            this.aQJ = new as();
            this.aQJ.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aQK = new as();
            this.aQK.parse(jSONObject.optJSONObject("red_package_rain"));
        }
    }

    public as ES() {
        return this.aQH;
    }

    public as ET() {
        return this.aQI;
    }

    public as EU() {
        return this.aQJ;
    }

    public as EV() {
        return this.aQK;
    }
}
