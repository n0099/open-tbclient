package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cd {
    private av aNU;
    private av aNV;
    private av aNW;
    private av aNX;
    private av aNY;
    private av aNZ;
    private av aOa;

    public static cd fg(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cd cdVar = new cd();
            cdVar.parse(jSONObject);
            return cdVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(cd cdVar) {
        if (cdVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (cdVar.aNU != null) {
                jSONObject.put("change_mode", cdVar.aNU.toJson());
            }
            if (cdVar.aNV != null) {
                jSONObject.put("match_success", cdVar.aNV.toJson());
            }
            if (cdVar.aNW != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, cdVar.aNW.toJson());
            }
            if (cdVar.aNX != null) {
                jSONObject.put("red_package_rain", cdVar.aNX.toJson());
            }
            if (cdVar.aNY != null) {
                jSONObject.put("pk_start", cdVar.aNY.toJson());
            }
            if (cdVar.aNZ != null) {
                jSONObject.put("pk_red_win", cdVar.aNZ.toJson());
            }
            if (cdVar.aOa != null) {
                jSONObject.put("pk_blue_win", cdVar.aOa.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNU = new av();
            this.aNU.parse(jSONObject.optJSONObject("change_mode"));
            this.aNV = new av();
            this.aNV.parse(jSONObject.optJSONObject("match_success"));
            this.aNW = new av();
            this.aNW.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aNX = new av();
            this.aNX.parse(jSONObject.optJSONObject("red_package_rain"));
            this.aNY = new av();
            this.aNY.parse(jSONObject.optJSONObject("pk_start"));
            this.aNZ = new av();
            this.aNZ.parse(jSONObject.optJSONObject("pk_red_win"));
            this.aOa = new av();
            this.aOa.parse(jSONObject.optJSONObject("pk_blue_win"));
        }
    }

    public av Bp() {
        return this.aNU;
    }

    public av Bq() {
        return this.aNV;
    }

    public av Br() {
        return this.aNW;
    }

    public av Bs() {
        return this.aNX;
    }

    public av Bt() {
        return this.aNY;
    }

    public av Bu() {
        return this.aNZ;
    }

    public av Bv() {
        return this.aOa;
    }
}
