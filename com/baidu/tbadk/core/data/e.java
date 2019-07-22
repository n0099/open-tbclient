package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int bFL;
    public String bFM;
    public String labelName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bFL = jSONObject.optInt("label_id");
            this.labelName = jSONObject.optString("label_name");
            this.bFM = jSONObject.optString("label_rgb");
        }
    }
}
