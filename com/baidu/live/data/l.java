package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l {
    private String aJH;
    private String text;

    public static l y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        l lVar = new l();
        lVar.text = jSONObject.optString("text");
        lVar.aJH = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        return lVar;
    }

    public String EA() {
        return this.aJH;
    }

    public String getText() {
        return this.text;
    }

    public void gl(String str) {
        this.aJH = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
