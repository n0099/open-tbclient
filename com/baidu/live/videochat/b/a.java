package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int aYJ;
    public String aYK;
    public long aYL;
    public long ape;
    public String apf;
    public String apg;
    public AlaAvtsData api;
    public AlaAvtsConfigInfo apj;
    public AlaLiveInfoData auq;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aYJ = jSONObject.optInt("match_status");
            this.aYK = jSONObject.optString("status_text");
            this.ape = jSONObject.optLong("match_user_id");
            this.apf = jSONObject.optString("match_user_name");
            this.apg = jSONObject.optString("match_avatar");
            this.aYL = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.api = new AlaAvtsData();
                this.api.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.apj = new AlaAvtsConfigInfo();
                this.apj.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.auq = new AlaLiveInfoData();
                this.auq.parserJson(optJSONObject3);
            }
        }
    }
}
