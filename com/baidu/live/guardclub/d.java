package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aOS;
    public String aOT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aOS = jSONObject.optString("privilege_img_url");
                this.aOT = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
