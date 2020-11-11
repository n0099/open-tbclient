package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public boolean aIl;
    public long aIm;
    public boolean aIn;
    public long aIo;
    public long aIp;
    public long aIq;
    public String aIr;
    public String aIs;
    public String aIt;
    public String aIu;
    public String aIv;
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
            this.aIv = jSONObject.optString("rule_h5url");
            this.aIl = jSONObject.optInt("switch", 1) == 1;
            this.aIm = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aIn = jSONObject.optInt("status", 0) == 1;
            this.aIo = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aIp = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aIq = jSONObject.optLong("gift_score");
            this.aIr = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aIs = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aIt = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aIu = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aIl + ", initScore=" + this.aIm + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aIn + ", curScore=" + this.aIo + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aIp + ", giftName='" + this.giftName + "', giftScore=" + this.aIq + ", giftImageUrl='" + this.aIr + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aIs + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aIt + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aIu + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
