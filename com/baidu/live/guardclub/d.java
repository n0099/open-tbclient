package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public String bgd;
    public String bge;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bgd = jSONObject.optString("privilege_img_url");
                this.bge = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
