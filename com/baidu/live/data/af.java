package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class af {
    public long abV;
    public int abW;
    public long createTime;
    public String eventDesc;
    public int eventType;
    public long id;
    public long liveId;
    public long sendTime;
    public long updateTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optLong("id");
            this.eventType = jSONObject.optInt("event_type");
            this.abV = jSONObject.optLong("sender_uid");
            this.liveId = jSONObject.optLong("live_id");
            this.eventDesc = jSONObject.optString("event_desc");
            this.createTime = jSONObject.optLong("create_time");
            this.updateTime = jSONObject.optLong("update_time");
            this.sendTime = jSONObject.optLong("send_time");
            this.abW = jSONObject.optInt("send_flag");
        }
    }
}
