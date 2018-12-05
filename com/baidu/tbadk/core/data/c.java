package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String aqc;
    public int labelId;
    public String labelName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.labelId = jSONObject.optInt("label_id");
            this.labelName = jSONObject.optString("label_name");
            this.aqc = jSONObject.optString("label_rgb");
        }
    }
}
