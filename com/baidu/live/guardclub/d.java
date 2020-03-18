package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aqu;
    public String aqv;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqu = jSONObject.optString("privilege_img_url");
                this.aqv = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
