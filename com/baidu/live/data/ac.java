package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ac {
    public String aHs;
    public n aJm;
    public ab aJn;
    private int aJo;
    public String msg;

    public boolean DW() {
        return this.aJo == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aHs = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aJm = new n();
                this.aJm.iconUrl = optJSONObject.optString("icon_url");
                this.aJm.msg = optJSONObject.optString("msg");
            }
            this.aJo = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aJn = new ab();
                this.aJn.parserJson(optJSONObject2);
            }
        }
    }
}
