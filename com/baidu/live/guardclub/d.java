package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String beX;
    public String beY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.beX = jSONObject.optString("privilege_img_url");
                this.beY = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
