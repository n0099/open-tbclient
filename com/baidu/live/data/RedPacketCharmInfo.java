package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RedPacketCharmInfo implements Serializable {
    public int count;
    public String id;
    public String senderAvatar;
    public long serverTime;
    public long startTime;
    public int status;

    public RedPacketCharmInfo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("redpacket_info")) != null) {
            this.count = jSONObject.optInt("redpacket_count");
            this.id = optJSONObject.optString("id");
            this.status = optJSONObject.optInt("status");
            this.senderAvatar = optJSONObject.optString("bd_portrait");
            this.serverTime = jSONObject.optLong("server_time");
            this.startTime = optJSONObject.optLong("start_time");
        }
    }
}
