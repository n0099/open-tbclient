package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aa {
    public String aEb;
    public k aFH;
    public z aFI;
    private int aFJ;
    public String msg;

    public boolean CQ() {
        return this.aFJ == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aEb = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aFH = new k();
                this.aFH.iconUrl = optJSONObject.optString("icon_url");
                this.aFH.msg = optJSONObject.optString("msg");
            }
            this.aFJ = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aFI = new z();
                this.aFI.parserJson(optJSONObject2);
            }
        }
    }
}
