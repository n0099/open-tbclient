package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class dg {
    public int aTu;
    public int aTv;
    public String aTw;

    public void parserJson(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aTu = jSONObject.optInt("collection_guide_enterlive_time", 60);
                this.aTv = jSONObject.optInt("collection_guide_show_num_max", 3);
                this.aTw = jSONObject.optString("collection_guide_show_description", "收藏后，开播第一时间告诉你");
            } catch (JSONException e) {
            }
        }
    }
}
