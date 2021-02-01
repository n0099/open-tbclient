package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class q {
    public String aHA;
    public boolean aHB;
    public String aHC;
    public boolean aHr;
    public long aHs;
    public boolean aHt;
    public long aHu;
    public long aHv;
    public long aHw;
    public String aHx;
    public String aHy;
    public String aHz;
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
            this.aHC = jSONObject.optString("rule_h5url");
            this.aHr = jSONObject.optInt("switch", 1) == 1;
            this.aHs = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aHt = jSONObject.optInt("status", 0) == 1;
            this.aHu = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aHv = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aHw = jSONObject.optLong("gift_score");
            this.aHx = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aHy = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aHz = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aHA = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aHr + ", initScore=" + this.aHs + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aHt + ", curScore=" + this.aHu + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aHv + ", giftName='" + this.giftName + "', giftScore=" + this.aHw + ", giftImageUrl='" + this.aHx + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aHy + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aHz + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aHA + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
