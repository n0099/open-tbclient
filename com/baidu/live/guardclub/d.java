package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String bgL;
    public String bgM;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bgL = jSONObject.optString("privilege_img_url");
                this.bgM = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
