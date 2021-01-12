package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends l {
    public int aBi;
    public int aBj;
    public String mFilterName = "delta";
    public int aBb = 80;
    public int aBc = 50;
    public int aBd = 80;
    public int aBe = 80;
    public int aBf = 80;
    public int aBg = 25;
    public int aBh = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aBb);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aBd);
            jSONObject.put("red_level", this.aBc);
            jSONObject.put("big_eye", this.aBe);
            jSONObject.put("thin_face", this.aBf);
            jSONObject.put("chin", this.aBg);
            jSONObject.put("nose", this.aBh);
            jSONObject.put("v_face", this.aBi);
            jSONObject.put("face_three_counts", this.aBj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public f eN(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aBb = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aBd = jSONObject.optInt("blur_level");
                this.aBe = jSONObject.optInt("big_eye");
                this.aBf = jSONObject.optInt("thin_face");
                this.aBc = jSONObject.getInt("red_level");
                this.aBg = jSONObject.optInt("chin");
                this.aBh = jSONObject.getInt("nose");
                this.aBi = jSONObject.optInt("v_face");
                this.aBj = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
