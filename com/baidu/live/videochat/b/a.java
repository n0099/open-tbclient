package com.baidu.live.videochat.b;

import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public long aCp;
    public String aCq;
    public String aCr;
    public AlaAvtsData aCt;
    public AlaAvtsConfigInfo aCu;
    public AlaLiveInfoData aIG;
    public int bru;
    public String brv;
    public long brw;
    public long chatId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bru = jSONObject.optInt("match_status");
            this.brv = jSONObject.optString("status_text");
            this.aCp = jSONObject.optLong("match_user_id");
            this.aCq = jSONObject.optString("match_user_name");
            this.aCr = jSONObject.optString("match_avatar");
            this.brw = jSONObject.optLong("match_time");
            this.chatId = jSONObject.optLong("chat_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("avts_addr");
            if (optJSONObject != null) {
                this.aCt = new AlaAvtsData();
                this.aCt.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("avts_conf");
            if (optJSONObject2 != null) {
                this.aCu = new AlaAvtsConfigInfo();
                this.aCu.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("match_live_info");
            if (optJSONObject3 != null) {
                this.aIG = new AlaLiveInfoData();
                this.aIG.parserJson(optJSONObject3);
            }
        }
    }
}
