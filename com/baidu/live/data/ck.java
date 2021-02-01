package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ck {
    private az aQV;
    private az aQW;
    private az aQX;
    private az aQY;
    private az aQZ;
    private az aRa;
    private az aRb;
    private az aRc;
    private az aRd;

    public static ck fB(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ck ckVar = new ck();
            ckVar.parse(jSONObject);
            return ckVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(ck ckVar) {
        if (ckVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (ckVar.aQV != null) {
                jSONObject.put("change_mode", ckVar.aQV.toJson());
            }
            if (ckVar.aQW != null) {
                jSONObject.put("match_success", ckVar.aQW.toJson());
            }
            if (ckVar.aQX != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, ckVar.aQX.toJson());
            }
            if (ckVar.aQY != null) {
                jSONObject.put("red_package_rain", ckVar.aQY.toJson());
            }
            if (ckVar.aQZ != null) {
                jSONObject.put("pk_start", ckVar.aQZ.toJson());
            }
            if (ckVar.aRa != null) {
                jSONObject.put("pk_red_win", ckVar.aRa.toJson());
            }
            if (ckVar.aRb != null) {
                jSONObject.put("pk_blue_win", ckVar.aRb.toJson());
            }
            if (ckVar.aRc != null) {
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, ckVar.aRc.toJson());
            }
            if (ckVar.aRd != null) {
                jSONObject.put("new_frame", ckVar.aRd.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQV = new az();
            this.aQV.parse(jSONObject.optJSONObject("change_mode"));
            this.aQW = new az();
            this.aQW.parse(jSONObject.optJSONObject("match_success"));
            this.aQX = new az();
            this.aQX.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aQY = new az();
            this.aQY.parse(jSONObject.optJSONObject("red_package_rain"));
            this.aQZ = new az();
            this.aQZ.parse(jSONObject.optJSONObject("pk_start"));
            this.aRa = new az();
            this.aRa.parse(jSONObject.optJSONObject("pk_red_win"));
            this.aRb = new az();
            this.aRb.parse(jSONObject.optJSONObject("pk_blue_win"));
            this.aRc = new az();
            this.aRc.parse(jSONObject.optJSONObject(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
            this.aRd = new az();
            this.aRd.parse(jSONObject.optJSONObject("new_frame"));
        }
    }

    public az CC() {
        return this.aQV;
    }

    public az CD() {
        return this.aQW;
    }

    public az CE() {
        return this.aQX;
    }

    public az CF() {
        return this.aQY;
    }

    public az CG() {
        return this.aQZ;
    }

    public az CH() {
        return this.aRa;
    }

    public az CI() {
        return this.aRb;
    }

    public az CJ() {
        return this.aRc;
    }

    public az CK() {
        return this.aRd;
    }
}
