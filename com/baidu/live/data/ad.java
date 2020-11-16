package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ad {
    public String aGz;
    public n aIB;
    public ab aIC;
    private int aID;
    public String msg;

    public boolean DJ() {
        return this.aID == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aGz = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aIB = new n();
                this.aIB.iconUrl = optJSONObject.optString("icon_url");
                this.aIB.msg = optJSONObject.optString("msg");
            }
            this.aID = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aIC = new ab();
                this.aIC.parserJson(optJSONObject2);
            }
        }
    }
}
