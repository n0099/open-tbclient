package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String aez;
    public int labelId;
    public String labelName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.labelId = jSONObject.optInt("label_id");
            this.labelName = jSONObject.optString("label_name");
            this.aez = jSONObject.optString("label_rgb");
        }
    }
}
