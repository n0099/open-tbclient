package com.baidu.live.tbadk.core.data;

import com.baidu.live.tbadk.log.LogConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaBroadcastGiftToastData extends BaseData {
    public static final int BROAD_TYPE_REDPACKET = 3;
    public static final int BROAD_TYPE_TURNTABLE_GIFT = 4;
    public static final int BROAD_TYPE_TURNTABLE_SUCCESS = 5;
    public static final int GIFT_BROADCAST = 1;
    public static final int GUARD_CLUB_UPGRADE = 2;
    public static final int HOUR_RANK_CONFIRM = 2;
    public static final int HOUR_RANK_LEFT_ALARM = 1;
    public String feed_id;
    public long gift_id;
    public String gift_name;
    public String gift_url;
    public String keywords;
    public long live_id;
    public long msg_id;
    public JSONObject originJsonObject;
    public String otherParams;
    public String receiver;
    public String sender;
    public String sender_portrait;
    public String subjectName;
    public int broadcast_type = 0;
    public int broad_type = 1;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.originJsonObject = jSONObject;
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.sender = jSONObject.optString("sender");
            this.sender_portrait = jSONObject.optString("sender_portrait");
            this.receiver = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.gift_id = jSONObject.optLong(LogConfig.LOG_GIFT_ID, 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.msg_id = jSONObject.optLong("msg_id", 0L);
            this.gift_url = jSONObject.optString("gift_url");
            this.broad_type = jSONObject.optInt("broad_type", 1);
            if ((this.broad_type == 2 || this.broad_type == 4 || this.broad_type == 5) && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
                this.subjectName = optJSONObject.optString("subject_name");
                this.keywords = optJSONObject.optString("keywords");
            }
        }
    }

    public JSONObject toJsonObject() {
        return this.originJsonObject;
    }

    public void setBroadcastType(int i) {
        this.broadcast_type = i;
    }
}
