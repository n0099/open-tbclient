package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String bfq;
    public String bfr;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bfq = jSONObject.optString("privilege_img_url");
                this.bfr = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
