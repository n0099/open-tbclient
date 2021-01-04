package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class da {
    public int aVe;
    public int aVf;
    public String aVg;

    public void parserJson(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aVe = jSONObject.optInt("collection_guide_enterlive_time", 60);
                this.aVf = jSONObject.optInt("collection_guide_show_num_max", 3);
                this.aVg = jSONObject.optString("collection_guide_show_description", "收藏后，开播第一时间告诉你");
            } catch (JSONException e) {
            }
        }
    }
}
