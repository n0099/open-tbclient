package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cc {
    private at aRY;
    private at aRZ;
    private at aSa;
    private at aSb;

    public static cc gI(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cc ccVar = new cc();
            ccVar.parse(jSONObject);
            return ccVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(cc ccVar) {
        if (ccVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (ccVar.aRY != null) {
                jSONObject.put("change_mode", ccVar.aRY.toJson());
            }
            if (ccVar.aRZ != null) {
                jSONObject.put("match_success", ccVar.aRZ.toJson());
            }
            if (ccVar.aSa != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, ccVar.aSa.toJson());
            }
            if (ccVar.aSb != null) {
                jSONObject.put("red_package_rain", ccVar.aSb.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRY = new at();
            this.aRY.parse(jSONObject.optJSONObject("change_mode"));
            this.aRZ = new at();
            this.aRZ.parse(jSONObject.optJSONObject("match_success"));
            this.aSa = new at();
            this.aSa.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aSb = new at();
            this.aSb.parse(jSONObject.optJSONObject("red_package_rain"));
        }
    }

    public at FU() {
        return this.aRY;
    }

    public at FV() {
        return this.aRZ;
    }

    public at FW() {
        return this.aSa;
    }

    public at FX() {
        return this.aSb;
    }
}
