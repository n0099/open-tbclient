package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aqj;
    public String aqk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqj = jSONObject.optString("privilege_img_url");
                this.aqk = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
