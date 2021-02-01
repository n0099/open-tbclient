package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public String bjm;
    public String bjn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bjm = jSONObject.optString("privilege_img_url");
                this.bjn = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
