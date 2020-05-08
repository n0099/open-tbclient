package com.baidu.live.guardclub;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aJj;
    public String aJk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aJj = jSONObject.optString("privilege_img_url");
                this.aJk = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
