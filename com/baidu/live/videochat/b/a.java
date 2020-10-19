package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long aGd;
    public String aGe;
    public String aGf;
    public AlaAvtsData aGh;
    public AlaAvtsConfigInfo aGi;
    public AlaLiveInfoData aNb;
    public int byL;
    public String byM;
    public long byN;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.byL = jSONObject.optInt("match_status");
            this.byM = jSONObject.optString("status_text");
            this.aGd = jSONObject.optLong("match_user_id");
            this.aGe = jSONObject.optString("match_user_name");
            this.aGf = jSONObject.optString("match_avatar");
            this.byN = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aGh = new AlaAvtsData();
                this.aGh.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aGi = new AlaAvtsConfigInfo();
                this.aGi.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aNb = new AlaLiveInfoData();
                this.aNb.parserJson(optJSONObject3);
            }
        }
    }
}
