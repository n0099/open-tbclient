package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends l {
    public int aCN;
    public int aCO;
    public String mFilterName = "delta";
    public int aCG = 80;
    public int aCH = 50;
    public int aCI = 80;
    public int aCJ = 80;
    public int aCK = 80;
    public int aCL = 25;
    public int aCM = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aCG);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aCI);
            jSONObject.put("red_level", this.aCH);
            jSONObject.put("big_eye", this.aCJ);
            jSONObject.put("thin_face", this.aCK);
            jSONObject.put("chin", this.aCL);
            jSONObject.put("nose", this.aCM);
            jSONObject.put("v_face", this.aCN);
            jSONObject.put("face_three_counts", this.aCO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public f ff(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCG = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aCI = jSONObject.optInt("blur_level");
                this.aCJ = jSONObject.optInt("big_eye");
                this.aCK = jSONObject.optInt("thin_face");
                this.aCH = jSONObject.getInt("red_level");
                this.aCL = jSONObject.optInt("chin");
                this.aCM = jSONObject.getInt("nose");
                this.aCN = jSONObject.optInt("v_face");
                this.aCO = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
