package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends k {
    public int aFD;
    public int aFE;
    public String mFilterName = "delta";
    public int aFw = 80;
    public int aFx = 50;
    public int aFy = 80;
    public int aFz = 80;
    public int aFA = 80;
    public int aFB = 25;
    public int aFC = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aFw);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aFy);
            jSONObject.put("red_level", this.aFx);
            jSONObject.put("big_eye", this.aFz);
            jSONObject.put("thin_face", this.aFA);
            jSONObject.put("chin", this.aFB);
            jSONObject.put("nose", this.aFC);
            jSONObject.put("v_face", this.aFD);
            jSONObject.put("face_three_counts", this.aFE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public e go(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aFw = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aFy = jSONObject.optInt("blur_level");
                this.aFz = jSONObject.optInt("big_eye");
                this.aFA = jSONObject.optInt("thin_face");
                this.aFx = jSONObject.getInt("red_level");
                this.aFB = jSONObject.optInt("chin");
                this.aFC = jSONObject.getInt("nose");
                this.aFD = jSONObject.optInt("v_face");
                this.aFE = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
