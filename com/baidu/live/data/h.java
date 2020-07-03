package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private String awR;
    private String text;

    public static h u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.text = jSONObject.optString("text");
        hVar.awR = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return hVar;
    }

    public String wv() {
        return this.awR;
    }

    public String getText() {
        return this.text;
    }

    public void ew(String str) {
        this.awR = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
