package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p {
    private String aHq;
    private String text;

    public static p y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        p pVar = new p();
        pVar.text = jSONObject.optString("text");
        pVar.aHq = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return pVar;
    }

    public String BS() {
        return this.aHq;
    }

    public String getText() {
        return this.text;
    }

    public void fv(String str) {
        this.aHq = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
