package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public boolean aJk;
    public long aJl;
    public boolean aJm;
    public long aJn;
    public long aJo;
    public long aJp;
    public String aJq;
    public String aJr;
    public String aJs;
    public String aJt;
    public String aJu;
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
            this.aJu = jSONObject.optString("rule_h5url");
            this.aJk = jSONObject.optInt("switch", 1) == 1;
            this.aJl = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aJm = jSONObject.optInt("status", 0) == 1;
            this.aJn = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aJo = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aJp = jSONObject.optLong("gift_score");
            this.aJq = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aJr = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aJs = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aJt = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aJk + ", initScore=" + this.aJl + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aJm + ", curScore=" + this.aJn + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aJo + ", giftName='" + this.giftName + "', giftScore=" + this.aJp + ", giftImageUrl='" + this.aJq + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aJr + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aJs + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aJt + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
