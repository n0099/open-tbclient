package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aJd;
    public String aJe;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aJd = jSONObject.optString("privilege_img_url");
                this.aJe = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
