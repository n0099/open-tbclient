package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public String aYf;
    public String aYg;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aYf = jSONObject.optString("privilege_img_url");
                this.aYg = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
