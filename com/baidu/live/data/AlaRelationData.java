package com.baidu.live.data;

import com.baidu.live.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaRelationData implements Serializable {
    public static final int FOLLOW_STATUS_FOLLOWED_EACH_OTHER = 2;
    public static final int FOLLOW_STATUS_FOLLOWED_NO = 0;
    public static final int FOLLOW_STATUS_FOLLOWED_SINGLE = 1;
    public static final int FOLLOW_STATUS_FOLLOWED_YES = 1;
    public static final String RELATION_DATA = "relation_data";
    public long user_id = 0;
    public long to_user_id = 0;
    public int follow_status = 0;
    public int push_switch = 0;
    public long like_degree = 0;
    public long dislike_degree = 0;
    public long intimacy_degree = 0;
    public int mask_status = 0;
    public long update_time = 0;
    public long create_time = 0;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.user_id = jSONObject.optLong("user_id");
                this.to_user_id = jSONObject.optLong("to_user_id");
                this.follow_status = jSONObject.optInt("follow_status");
                this.push_switch = jSONObject.optInt("push_switch");
                this.like_degree = jSONObject.optLong("like_degree");
                this.dislike_degree = jSONObject.optLong("dislike_degree");
                this.intimacy_degree = jSONObject.optLong("intimacy_degree");
                this.mask_status = jSONObject.optInt("mask_status");
                this.update_time = jSONObject.optLong("update_time");
                this.create_time = jSONObject.optLong("create_time");
            } catch (Exception e) {
            }
        }
    }

    public long getUserId() {
        return this.user_id;
    }

    public long getToUserId() {
        return this.to_user_id;
    }

    public int getFollowStatus() {
        return this.follow_status;
    }

    public void setFollowStatus(int i) {
        this.follow_status = i;
    }

    public int getPushSwitch() {
        return this.push_switch;
    }

    public void setPushSwitch(int i) {
        this.push_switch = i;
    }

    public long getLikeDegree() {
        return this.like_degree;
    }

    public void setLikeDegree(long j) {
        this.like_degree = j;
    }

    public long getDislikeDegree() {
        return this.dislike_degree;
    }

    public void setDislikeDegree(long j) {
        this.dislike_degree = j;
    }

    public long getIntimacyDegree() {
        return this.intimacy_degree;
    }

    public void setIntimacyDegree(long j) {
        this.intimacy_degree = j;
    }

    public int getMaskStatus() {
        return this.mask_status;
    }

    public void setMaskStatus(int i) {
        this.mask_status = i;
    }

    public long getUpdateTime() {
        return this.update_time;
    }

    public void setUpdateTime(long j) {
        this.update_time = j;
    }

    public long getCreateTime() {
        return this.create_time;
    }

    public void setCreateTime(long j) {
        this.create_time = j;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.user_id);
            jSONObject.put("to_user_id", this.to_user_id);
            jSONObject.put("follow_status", this.follow_status);
            jSONObject.put("push_switch", this.push_switch);
            jSONObject.put("like_degree", this.like_degree);
            jSONObject.put("dislike_degree", this.dislike_degree);
            jSONObject.put("intimacy_degree", this.intimacy_degree);
            jSONObject.put("mask_status", this.mask_status);
            jSONObject.put("update_time", this.update_time);
            jSONObject.put("create_time", this.create_time);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
