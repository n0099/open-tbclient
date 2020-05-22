package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private String auL;
    private String text;

    public static h s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.text = jSONObject.optString("text");
        hVar.auL = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return hVar;
    }

    public String vX() {
        return this.auL;
    }

    public String getText() {
        return this.text;
    }

    public void er(String str) {
        this.auL = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
