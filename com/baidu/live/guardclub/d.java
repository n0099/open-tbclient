package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public String bkT;
    public String bkU;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bkT = jSONObject.optString("privilege_img_url");
                this.bkU = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
