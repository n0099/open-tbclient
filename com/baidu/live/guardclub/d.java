package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public String bkM;
    public String bkN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bkM = jSONObject.optString("privilege_img_url");
                this.bkN = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
