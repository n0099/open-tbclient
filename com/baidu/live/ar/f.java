package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends l {
    public int aFV;
    public int aFW;
    public String mFilterName = "delta";
    public int aFO = 80;
    public int aFP = 50;
    public int aFQ = 80;
    public int aFR = 80;
    public int aFS = 80;
    public int aFT = 25;
    public int aFU = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aFO);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aFQ);
            jSONObject.put("red_level", this.aFP);
            jSONObject.put("big_eye", this.aFR);
            jSONObject.put("thin_face", this.aFS);
            jSONObject.put("chin", this.aFT);
            jSONObject.put("nose", this.aFU);
            jSONObject.put("v_face", this.aFV);
            jSONObject.put("face_three_counts", this.aFW);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public f fY(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aFO = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aFQ = jSONObject.optInt("blur_level");
                this.aFR = jSONObject.optInt("big_eye");
                this.aFS = jSONObject.optInt("thin_face");
                this.aFP = jSONObject.getInt("red_level");
                this.aFT = jSONObject.optInt("chin");
                this.aFU = jSONObject.getInt("nose");
                this.aFV = jSONObject.optInt("v_face");
                this.aFW = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
