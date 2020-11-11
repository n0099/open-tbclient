package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aIk;
    private String text;

    public static k y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        k kVar = new k();
        kVar.text = jSONObject.optString("text");
        kVar.aIk = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return kVar;
    }

    public String Ei() {
        return this.aIk;
    }

    public String getText() {
        return this.text;
    }

    public void gm(String str) {
        this.aIk = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
