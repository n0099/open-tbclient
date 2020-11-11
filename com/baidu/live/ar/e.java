package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends k {
    public int aEI;
    public int aEJ;
    public String mFilterName = "delta";
    public int aEB = 80;
    public int aEC = 50;
    public int aED = 80;
    public int aEE = 80;
    public int aEF = 80;
    public int aEG = 25;
    public int aEH = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aEB);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aED);
            jSONObject.put("red_level", this.aEC);
            jSONObject.put("big_eye", this.aEE);
            jSONObject.put("thin_face", this.aEF);
            jSONObject.put("chin", this.aEG);
            jSONObject.put("nose", this.aEH);
            jSONObject.put("v_face", this.aEI);
            jSONObject.put("face_three_counts", this.aEJ);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public e fZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aEB = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aED = jSONObject.optInt("blur_level");
                this.aEE = jSONObject.optInt("big_eye");
                this.aEF = jSONObject.optInt("thin_face");
                this.aEC = jSONObject.getInt("red_level");
                this.aEG = jSONObject.optInt("chin");
                this.aEH = jSONObject.getInt("nose");
                this.aEI = jSONObject.optInt("v_face");
                this.aEJ = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
