package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public String labelColor;
    public int labelId;
    public String labelName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.labelId = jSONObject.optInt("label_id");
            this.labelName = jSONObject.optString("label_name");
            this.labelColor = jSONObject.optString("label_rgb");
        }
    }
}
