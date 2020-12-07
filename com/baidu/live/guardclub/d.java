package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String bjo;
    public String bjp;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bjo = jSONObject.optString("privilege_img_url");
                this.bjp = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
