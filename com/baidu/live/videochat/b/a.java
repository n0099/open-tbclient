package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public AlaLiveInfoData aDu;
    public long axl;
    public String axm;
    public String axn;
    public AlaAvtsData axp;
    public AlaAvtsConfigInfo axq;
    public int blL;
    public String blM;
    public long blN;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blL = jSONObject.optInt("match_status");
            this.blM = jSONObject.optString("status_text");
            this.axl = jSONObject.optLong("match_user_id");
            this.axm = jSONObject.optString("match_user_name");
            this.axn = jSONObject.optString("match_avatar");
            this.blN = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.axp = new AlaAvtsData();
                this.axp.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.axq = new AlaAvtsConfigInfo();
                this.axq.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aDu = new AlaLiveInfoData();
                this.aDu.parserJson(optJSONObject3);
            }
        }
    }
}
