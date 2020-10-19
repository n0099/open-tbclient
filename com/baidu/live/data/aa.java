package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aa {
    public String aHf;
    public k aIL;
    public z aIM;
    private int aIN;
    public String msg;

    public boolean DN() {
        return this.aIN == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aHf = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aIL = new k();
                this.aIL.iconUrl = optJSONObject.optString("icon_url");
                this.aIL.msg = optJSONObject.optString("msg");
            }
            this.aIN = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aIM = new z();
                this.aIM.parserJson(optJSONObject2);
            }
        }
    }
}
