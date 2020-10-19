package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String bdZ;
    public String bea;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bdZ = jSONObject.optString("privilege_img_url");
                this.bea = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
