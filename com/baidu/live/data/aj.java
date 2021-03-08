package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aj {
    public String aIQ;
    public s aLj;
    public ah aLk;
    private int aLl;
    public String msg;

    public boolean Cf() {
        return this.aLl == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aIQ = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aLj = new s();
                this.aLj.iconUrl = optJSONObject.optString("icon_url");
                this.aLj.msg = optJSONObject.optString("msg");
            }
            this.aLl = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aLk = new ah();
                this.aLk.parserJson(optJSONObject2);
            }
        }
    }
}
