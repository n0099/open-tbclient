package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class dg {
    public int aUU;
    public int aUV;
    public String aUW;

    public void parserJson(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aUU = jSONObject.optInt("collection_guide_enterlive_time", 60);
                this.aUV = jSONObject.optInt("collection_guide_show_num_max", 3);
                this.aUW = jSONObject.optString("collection_guide_show_description", "收藏后，开播第一时间告诉你");
            } catch (JSONException e) {
            }
        }
    }
}
