package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int aYO;
    public String aYP;
    public long aYQ;
    public long apk;
    public String apl;
    public String apm;
    public AlaAvtsData apo;
    public AlaAvtsConfigInfo apq;
    public AlaLiveInfoData auw;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aYO = jSONObject.optInt("match_status");
            this.aYP = jSONObject.optString("status_text");
            this.apk = jSONObject.optLong("match_user_id");
            this.apl = jSONObject.optString("match_user_name");
            this.apm = jSONObject.optString("match_avatar");
            this.aYQ = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.apo = new AlaAvtsData();
                this.apo.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.apq = new AlaAvtsConfigInfo();
                this.apq.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.auw = new AlaLiveInfoData();
                this.auw.parserJson(optJSONObject3);
            }
        }
    }
}
