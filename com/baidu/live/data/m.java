package com.baidu.live.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m {
    public boolean aEV;
    public long aEW;
    public boolean aEX;
    public long aEY;
    public long aEZ;
    public long aFa;
    public String aFb;
    public String aFc;
    public String aFd;
    public String aFe;
    public boolean aFf;
    public String aFg;
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
            this.aFg = jSONObject.optString("rule_h5url");
            this.aEV = jSONObject.optInt("switch", 1) == 1;
            this.aEW = jSONObject.optLong("init_score");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.aEX = jSONObject.optInt("status", 0) == 1;
            this.aEY = jSONObject.optLong("cur_score");
            this.liveId = jSONObject.optLong("live_id");
            this.roomId = jSONObject.optLong("room_id");
            this.aEZ = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            this.aFa = jSONObject.optLong("gift_score");
            this.aFb = jSONObject.optString("thumbnail_url");
            this.giftNum = jSONObject.optLong("gift_num");
            JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
            if (optJSONObject != null) {
                this.anchorId = optJSONObject.optLong("user_id");
                this.aFc = optJSONObject.optString("user_nickname");
                this.anchorPortrait = optJSONObject.optString("portrait");
                this.aFd = optJSONObject.optString("bd_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user");
            if (optJSONObject2 != null) {
                this.userId = optJSONObject2.optLong("user_id");
                this.userName = optJSONObject2.optString("user_nickname");
                this.userPortrait = optJSONObject2.optString("portrait");
                this.aFe = optJSONObject2.optString("bd_portrait");
            }
        }
    }

    public String toString() {
        return "AlaHeadlineInfo{isHeadLineOpen=" + this.aEV + ", initScore=" + this.aEW + ", startTime=" + this.startTime + ", getHeadlineStatus=" + this.aEX + ", curScore=" + this.aEY + ", liveId=" + this.liveId + ", roomId=" + this.roomId + ", giftID=" + this.aEZ + ", giftName='" + this.giftName + "', giftScore=" + this.aFa + ", giftImageUrl='" + this.aFb + "', giftNum=" + this.giftNum + ", anchorId=" + this.anchorId + ", anchorName='" + this.aFc + "', anchorPortrait='" + this.anchorPortrait + "', anchorBDPortrait='" + this.aFd + "', userId=" + this.userId + ", userName='" + this.userName + "', userPortrait='" + this.userPortrait + "', userBDPortrait='" + this.aFe + "', endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", endTime-serverTime=" + (this.endTime - this.serverTime) + '}';
    }
}
