package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    private String aDi;
    private String text;

    public static h v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.text = jSONObject.optString("text");
        hVar.aDi = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return hVar;
    }

    public String Cv() {
        return this.aDi;
    }

    public String getText() {
        return this.text;
    }

    public void fO(String str) {
        this.aDi = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
