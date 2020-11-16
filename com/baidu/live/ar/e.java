package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends k {
    public int aCX;
    public int aCY;
    public String mFilterName = "delta";
    public int aCQ = 80;
    public int aCR = 50;
    public int aCS = 80;
    public int aCT = 80;
    public int aCU = 80;
    public int aCV = 25;
    public int aCW = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aCQ);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aCS);
            jSONObject.put("red_level", this.aCR);
            jSONObject.put("big_eye", this.aCT);
            jSONObject.put("thin_face", this.aCU);
            jSONObject.put("chin", this.aCV);
            jSONObject.put("nose", this.aCW);
            jSONObject.put("v_face", this.aCX);
            jSONObject.put("face_three_counts", this.aCY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public e fT(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCQ = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aCS = jSONObject.optInt("blur_level");
                this.aCT = jSONObject.optInt("big_eye");
                this.aCU = jSONObject.optInt("thin_face");
                this.aCR = jSONObject.getInt("red_level");
                this.aCV = jSONObject.optInt("chin");
                this.aCW = jSONObject.getInt("nose");
                this.aCX = jSONObject.optInt("v_face");
                this.aCY = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
