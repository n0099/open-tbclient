package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aGz;
    private String text;

    public static k s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        k kVar = new k();
        kVar.text = jSONObject.optString("text");
        kVar.aGz = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return kVar;
    }

    public String Dz() {
        return this.aGz;
    }

    public String getText() {
        return this.text;
    }

    public void gg(String str) {
        this.aGz = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
