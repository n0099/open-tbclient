package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cd {
    private av aSH;
    private av aSI;
    private av aSJ;
    private av aSK;
    private av aSL;
    private av aSM;
    private av aSN;

    public static cd gr(String str) {
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
            if (cdVar.aSH != null) {
                jSONObject.put("change_mode", cdVar.aSH.toJson());
            }
            if (cdVar.aSI != null) {
                jSONObject.put("match_success", cdVar.aSI.toJson());
            }
            if (cdVar.aSJ != null) {
                jSONObject.put(SdkStaticKeys.RANK_TYPE_CHARM, cdVar.aSJ.toJson());
            }
            if (cdVar.aSK != null) {
                jSONObject.put("red_package_rain", cdVar.aSK.toJson());
            }
            if (cdVar.aSL != null) {
                jSONObject.put("pk_start", cdVar.aSL.toJson());
            }
            if (cdVar.aSM != null) {
                jSONObject.put("pk_red_win", cdVar.aSM.toJson());
            }
            if (cdVar.aSN != null) {
                jSONObject.put("pk_blue_win", cdVar.aSN.toJson());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSH = new av();
            this.aSH.parse(jSONObject.optJSONObject("change_mode"));
            this.aSI = new av();
            this.aSI.parse(jSONObject.optJSONObject("match_success"));
            this.aSJ = new av();
            this.aSJ.parse(jSONObject.optJSONObject(SdkStaticKeys.RANK_TYPE_CHARM));
            this.aSK = new av();
            this.aSK.parse(jSONObject.optJSONObject("red_package_rain"));
            this.aSL = new av();
            this.aSL.parse(jSONObject.optJSONObject("pk_start"));
            this.aSM = new av();
            this.aSM.parse(jSONObject.optJSONObject("pk_red_win"));
            this.aSN = new av();
            this.aSN.parse(jSONObject.optJSONObject("pk_blue_win"));
        }
    }

    public av Fk() {
        return this.aSH;
    }

    public av Fl() {
        return this.aSI;
    }

    public av Fm() {
        return this.aSJ;
    }

    public av Fn() {
        return this.aSK;
    }

    public av Fo() {
        return this.aSL;
    }

    public av Fp() {
        return this.aSM;
    }

    public av Fq() {
        return this.aSN;
    }
}
