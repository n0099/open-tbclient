package com.baidu.live.ar;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends l {
    public int aEn;
    public int aEo;
    public String mFilterName = "delta";
    public int aEg = 80;
    public int aEh = 50;
    public int aEi = 80;
    public int aEj = 80;
    public int aEk = 80;
    public int aEl = 25;
    public int aEm = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.aEg);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.aEi);
            jSONObject.put("red_level", this.aEh);
            jSONObject.put("big_eye", this.aEj);
            jSONObject.put("thin_face", this.aEk);
            jSONObject.put("chin", this.aEl);
            jSONObject.put("nose", this.aEm);
            jSONObject.put("v_face", this.aEn);
            jSONObject.put("face_three_counts", this.aEo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public f fl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aEg = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.aEi = jSONObject.optInt("blur_level");
                this.aEj = jSONObject.optInt("big_eye");
                this.aEk = jSONObject.optInt("thin_face");
                this.aEh = jSONObject.getInt("red_level");
                this.aEl = jSONObject.optInt("chin");
                this.aEm = jSONObject.getInt("nose");
                this.aEn = jSONObject.optInt("v_face");
                this.aEo = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
