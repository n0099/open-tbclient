package com.baidu.live.im.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YuyinImForbiddenStateData implements Serializable {
    public int anchorBan;
    public int banState;
    public a foreverInfo;
    public int globalBan;
    public int liveBan;
    public int errno = 0;
    public String errMsg = "";

    /* loaded from: classes11.dex */
    public static class a {
        public int bpt;
        public String bpu;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bpt = jSONObject.optInt("is_forever");
                this.bpu = jSONObject.optString("count_down");
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.banState = optJSONObject.optInt("is_ban");
            this.globalBan = optJSONObject.optInt("global_ban");
            this.liveBan = optJSONObject.optInt("live_ban");
            this.anchorBan = optJSONObject.optInt("anchor_ban");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("forever_info");
            this.foreverInfo = new a();
            this.foreverInfo.parseJson(optJSONObject2);
        }
    }
}
