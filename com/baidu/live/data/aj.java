package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class aj {
    public String aHq;
    public s aJJ;
    public ah aJK;
    private int aJL;
    public String msg;

    public boolean Cc() {
        return this.aJL == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.msg = jSONObject.optString("msg");
            this.aHq = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("super_king");
            if (optJSONObject != null) {
                this.aJJ = new s();
                this.aJJ.iconUrl = optJSONObject.optString("icon_url");
                this.aJJ.msg = optJSONObject.optString("msg");
            }
            this.aJL = jSONObject.optInt("is_season_over", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("division");
            if (optJSONObject2 != null) {
                this.aJK = new ah();
                this.aJK.parserJson(optJSONObject2);
            }
        }
    }
}
