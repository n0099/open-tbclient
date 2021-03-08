package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ck {
    private az aSA;
    private az aSB;
    private az aSC;
    private az aSD;
    private az aSv;
    private az aSw;
    private az aSx;
    private az aSy;
    private az aSz;

    public static ck fH(String str) {
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
            if (ckVar.aSv != null) {
                jSONObject.put("change_mode", ckVar.aSv.toJson());
            }
            if (ckVar.aSw != null) {
                jSONObject.put("match_success", ckVar.aSw.toJson());
            }
            if (ckVar.aSx != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, ckVar.aSx.toJson());
            }
            if (ckVar.aSy != null) {
                jSONObject.put("red_package_rain", ckVar.aSy.toJson());
            }
            if (ckVar.aSz != null) {
                jSONObject.put("pk_start", ckVar.aSz.toJson());
            }
            if (ckVar.aSA != null) {
                jSONObject.put("pk_red_win", ckVar.aSA.toJson());
            }
            if (ckVar.aSB != null) {
                jSONObject.put("pk_blue_win", ckVar.aSB.toJson());
            }
            if (ckVar.aSC != null) {
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, ckVar.aSC.toJson());
            }
            if (ckVar.aSD != null) {
                jSONObject.put("new_frame", ckVar.aSD.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSv = new az();
            this.aSv.parse(jSONObject.optJSONObject("change_mode"));
            this.aSw = new az();
            this.aSw.parse(jSONObject.optJSONObject("match_success"));
            this.aSx = new az();
            this.aSx.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aSy = new az();
            this.aSy.parse(jSONObject.optJSONObject("red_package_rain"));
            this.aSz = new az();
            this.aSz.parse(jSONObject.optJSONObject("pk_start"));
            this.aSA = new az();
            this.aSA.parse(jSONObject.optJSONObject("pk_red_win"));
            this.aSB = new az();
            this.aSB.parse(jSONObject.optJSONObject("pk_blue_win"));
            this.aSC = new az();
            this.aSC.parse(jSONObject.optJSONObject(AlaStaticKeys.ALA_STATIC_VALUE_ICON));
            this.aSD = new az();
            this.aSD.parse(jSONObject.optJSONObject("new_frame"));
        }
    }

    public az CF() {
        return this.aSv;
    }

    public az CG() {
        return this.aSw;
    }

    public az CH() {
        return this.aSx;
    }

    public az CI() {
        return this.aSy;
    }

    public az CJ() {
        return this.aSz;
    }

    public az CK() {
        return this.aSA;
    }

    public az CL() {
        return this.aSB;
    }

    public az CM() {
        return this.aSC;
    }

    public az CN() {
        return this.aSD;
    }
}
