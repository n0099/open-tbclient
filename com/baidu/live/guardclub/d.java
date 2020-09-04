package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public String aYh;
    public String aYi;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aYh = jSONObject.optString("privilege_img_url");
                this.aYi = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
