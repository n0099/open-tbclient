package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private String aye;
    private String text;

    public static h u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.text = jSONObject.optString("text");
        hVar.aye = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return hVar;
    }

    public String wX() {
        return this.aye;
    }

    public String getText() {
        return this.text;
    }

    public void ev(String str) {
        this.aye = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
