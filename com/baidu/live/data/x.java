package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x {
    public long SH;
    public String SJ;
    public long SK;
    public int SL;
    public long createTime;
    public int eventType;
    public long id;
    public long liveId;
    public long updateTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optLong("id");
            this.eventType = jSONObject.optInt("event_type");
            this.SH = jSONObject.optLong("sender_uid");
            this.liveId = jSONObject.optLong("live_id");
            this.SJ = jSONObject.optString("event_desc");
            this.createTime = jSONObject.optLong("create_time");
            this.updateTime = jSONObject.optLong("update_time");
            this.SK = jSONObject.optLong("send_time");
            this.SL = jSONObject.optInt("send_flag");
        }
    }
}
