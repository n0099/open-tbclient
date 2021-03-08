package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q {
    public boolean aIR;
    public long aIS;
    public boolean aIT;
    public long aIU;
    public long aIV;
    public long aIW;
    public String aIX;
    public String aIY;
    public String aIZ;
    public String aJa;
    public boolean aJb;
    public String aJc;
    public long anchorId;
    public String anchorPortrait;
    public long endTime;
    public String giftName;
    public long giftNum;
    public long liveId;
    public long roomId;
    public long serverTime;
    public long startTime;
    public long userId;
    public String userName;
    public String userPortrait;

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJc = jSONObject.optString("rule_h5url");
            this.aIR = jSONObject.optInt("switch", 1) == 1;
            this.aIS = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aIT = jSONObject.optInt("status", 0) == 1;
            this.aIU = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aIV = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aIW = jSONObject.optLong("gift_score");
            this.aIX = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aIY = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aIZ = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aJa = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aIR + ", initScore=" + this.aIS + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aIT + ", curScore=" + this.aIU + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aIV + ", giftName='" + this.giftName + "', giftScore=" + this.aIW + ", giftImageUrl='" + this.aIX + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aIY + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aIZ + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aJa + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
