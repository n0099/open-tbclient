package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public String aHA;
    public String aHB;
    public String aHC;
    public String aHD;
    public String aHE;
    public boolean aHt;
    public long aHu;
    public boolean aHv;
    public long aHw;
    public long aHx;
    public long aHy;
    public String aHz;
    public long anchorId;
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
            this.aHE = jSONObject.optString("rule_h5url");
            this.aHt = jSONObject.optInt("switch", 1) == 1;
            this.aHu = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aHv = jSONObject.optInt("status", 0) == 1;
            this.aHw = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aHx = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aHy = jSONObject.optLong("gift_score");
            this.aHz = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aHA = optJSONObject.optString("user_nickname");
                this.aHB = optJSONObject.optString("portrait");
                this.aHC = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aHD = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aHt + ", initScore=" + this.aHu + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aHv + ", curScore=" + this.aHw + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aHx + ", giftName='" + this.giftName + "', giftScore=" + this.aHy + ", giftImageUrl='" + this.aHz + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aHA + "', anchorPortrait='" + this.aHB + "', anchorBDPortrait='" + this.aHC + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aHD + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
