package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ae {
    public String aJj;
    public n aLq;
    public ac aLr;
    private int aLs;
    public String msg;

    public boolean Fu() {
        return this.aLs == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aJj = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aLq = new n();
                this.aLq.iconUrl = optJSONObject.optString("icon_url");
                this.aLq.msg = optJSONObject.optString("msg");
            }
            this.aLs = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aLr = new ac();
                this.aLr.parserJson(optJSONObject2);
            }
        }
    }
}
