package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public boolean aGA;
    public long aGB;
    public boolean aGC;
    public long aGD;
    public long aGE;
    public long aGF;
    public String aGG;
    public String aGH;
    public String aGI;
    public String aGJ;
    public String aGK;
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
            this.aGK = jSONObject.optString("rule_h5url");
            this.aGA = jSONObject.optInt("switch", 1) == 1;
            this.aGB = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aGC = jSONObject.optInt("status", 0) == 1;
            this.aGD = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aGE = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aGF = jSONObject.optLong("gift_score");
            this.aGG = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aGH = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aGI = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aGJ = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aGA + ", initScore=" + this.aGB + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aGC + ", curScore=" + this.aGD + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aGE + ", giftName='" + this.giftName + "', giftScore=" + this.aGF + ", giftImageUrl='" + this.aGG + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aGH + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aGI + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aGJ + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
