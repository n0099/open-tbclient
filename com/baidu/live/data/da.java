package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class da {
    public int aQr;
    public int aQs;
    public String aQt;

    public void parserJson(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aQr = jSONObject.optInt("collection_guide_enterlive_time", 60);
                this.aQs = jSONObject.optInt("collection_guide_show_num_max", 3);
                this.aQt = jSONObject.optString("collection_guide_show_description", "收藏后，开播第一时间告诉你");
            } catch (JSONException e) {
            }
        }
    }
}
