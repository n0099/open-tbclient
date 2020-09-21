package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String baF;
    public String baG;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.baF = jSONObject.optString("privilege_img_url");
                this.baG = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
