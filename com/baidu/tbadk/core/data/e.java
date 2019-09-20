package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int bGk;
    public String bGl;
    public String labelName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bGk = jSONObject.optInt("label_id");
            this.labelName = jSONObject.optString("label_name");
            this.bGl = jSONObject.optString("label_rgb");
        }
    }
}
