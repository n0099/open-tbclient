package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String aSR;
    public String aSS;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aSR = jSONObject.optString("privilege_img_url");
                this.aSS = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
