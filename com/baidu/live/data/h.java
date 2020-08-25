package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    private String aDg;
    private String text;

    public static h v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.text = jSONObject.optString("text");
        hVar.aDg = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return hVar;
    }

    public String Cv() {
        return this.aDg;
    }

    public String getText() {
        return this.text;
    }

    public void fN(String str) {
        this.aDg = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
