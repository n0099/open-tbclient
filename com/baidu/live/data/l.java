package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l {
    private String aEU;
    private String text;

    public static l y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        l lVar = new l();
        lVar.text = jSONObject.optString("text");
        lVar.aEU = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return lVar;
    }

    public String AF() {
        return this.aEU;
    }

    public String getText() {
        return this.text;
    }

    public void fa(String str) {
        this.aEU = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
