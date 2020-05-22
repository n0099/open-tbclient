package com.baidu.live.data;

import com.baidu.ar.pose.PoseAR;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class am {
    public long azC;
    public int azD;
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
            this.eventType = jSONObject.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY);
            this.azC = jSONObject.optLong("sender_uid");
            this.liveId = jSONObject.optLong("live_id");
            this.eventDesc = jSONObject.optString("event_desc");
            this.createTime = jSONObject.optLong("create_time");
            this.updateTime = jSONObject.optLong("update_time");
            this.sendTime = jSONObject.optLong("send_time");
            this.azD = jSONObject.optInt("send_flag");
        }
    }
}
