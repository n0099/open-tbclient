package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aa {
    public long ZC;
    public String ZD;
    public int ZE;
    public long createTime;
    public int eventType;
    public long id;
    public long liveId;
    public long sendTime;
    public long updateTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optLong("id");
            this.eventType = jSONObject.optInt("event_type");
            this.ZC = jSONObject.optLong("sender_uid");
            this.liveId = jSONObject.optLong("live_id");
            this.ZD = jSONObject.optString("event_desc");
            this.createTime = jSONObject.optLong("create_time");
            this.updateTime = jSONObject.optLong("update_time");
            this.sendTime = jSONObject.optLong("send_time");
            this.ZE = jSONObject.optInt("send_flag");
        }
    }
}
