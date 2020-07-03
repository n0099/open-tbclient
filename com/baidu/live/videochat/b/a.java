package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public AlaLiveInfoData aBZ;
    public long awg;
    public String awh;
    public String awi;
    public AlaAvtsData awk;
    public AlaAvtsConfigInfo awl;
    public int blr;
    public String bls;
    public long blt;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.blr = jSONObject.optInt("match_status");
            this.bls = jSONObject.optString("status_text");
            this.awg = jSONObject.optLong("match_user_id");
            this.awh = jSONObject.optString("match_user_name");
            this.awi = jSONObject.optString("match_avatar");
            this.blt = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.awk = new AlaAvtsData();
                this.awk.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.awl = new AlaAvtsConfigInfo();
                this.awl.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aBZ = new AlaLiveInfoData();
                this.aBZ.parserJson(optJSONObject3);
            }
        }
    }
}
