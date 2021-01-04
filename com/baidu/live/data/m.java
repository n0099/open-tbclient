package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class m {
    public boolean aJI;
    public long aJJ;
    public boolean aJK;
    public long aJL;
    public long aJM;
    public long aJN;
    public String aJO;
    public String aJP;
    public String aJQ;
    public String aJR;
    public boolean aJS;
    public String aJT;
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
            this.aJT = jSONObject.optString("rule_h5url");
            this.aJI = jSONObject.optInt("switch", 1) == 1;
            this.aJJ = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aJK = jSONObject.optInt("status", 0) == 1;
            this.aJL = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aJM = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aJN = jSONObject.optLong("gift_score");
            this.aJO = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aJP = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aJQ = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aJR = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aJI + ", initScore=" + this.aJJ + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aJK + ", curScore=" + this.aJL + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aJM + ", giftName='" + this.giftName + "', giftScore=" + this.aJN + ", giftImageUrl='" + this.aJO + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aJP + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aJQ + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aJR + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
