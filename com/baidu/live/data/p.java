package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p {
    private String aIQ;
    private String text;

    public static p A(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        p pVar = new p();
        pVar.text = jSONObject.optString("text");
        pVar.aIQ = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return pVar;
    }

    public String BV() {
        return this.aIQ;
    }

    public String getText() {
        return this.text;
    }

    public void fB(String str) {
        this.aIQ = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
