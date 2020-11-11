package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ad {
    public String aIk;
    public n aKm;
    public ab aKn;
    private int aKo;
    public String msg;

    public boolean Es() {
        return this.aKo == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aIk = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aKm = new n();
                this.aKm.iconUrl = optJSONObject.optString("icon_url");
                this.aKm.msg = optJSONObject.optString("msg");
            }
            this.aKo = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aKn = new ab();
                this.aKn.parserJson(optJSONObject2);
            }
        }
    }
}
