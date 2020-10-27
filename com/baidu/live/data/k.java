package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aHs;
    private String text;

    public static k v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        k kVar = new k();
        kVar.text = jSONObject.optString("text");
        kVar.aHs = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return kVar;
    }

    public String DP() {
        return this.aHs;
    }

    public String getText() {
        return this.text;
    }

    public void gi(String str) {
        this.aHs = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
