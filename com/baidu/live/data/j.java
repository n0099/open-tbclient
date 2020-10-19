package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {
    private String aHf;
    private String text;

    public static j v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.text = jSONObject.optString("text");
        jVar.aHf = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return jVar;
    }

    public String DH() {
        return this.aHf;
    }

    public String getText() {
        return this.text;
    }

    public void gh(String str) {
        this.aHf = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
