package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class af {
    public String aJH;
    public o aLS;
    public ad aLT;
    private int aLU;
    public String msg;

    public boolean EK() {
        return this.aLU == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aJH = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aLS = new o();
                this.aLS.iconUrl = optJSONObject.optString("icon_url");
                this.aLS.msg = optJSONObject.optString("msg");
            }
            this.aLU = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aLT = new ad();
                this.aLT.parserJson(optJSONObject2);
            }
        }
    }
}
