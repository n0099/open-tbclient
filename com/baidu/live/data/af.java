package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class af {
    public String aEU;
    public o aHf;
    public ad aHg;
    private int aHh;
    public String msg;

    public boolean AP() {
        return this.aHh == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aEU = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aHf = new o();
                this.aHf.iconUrl = optJSONObject.optString("icon_url");
                this.aHf.msg = optJSONObject.optString("msg");
            }
            this.aHh = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aHg = new ad();
                this.aHg.parserJson(optJSONObject2);
            }
        }
    }
}
