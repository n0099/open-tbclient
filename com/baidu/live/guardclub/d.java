package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aqk;
    public String aql;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqk = jSONObject.optString("privilege_img_url");
                this.aql = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
