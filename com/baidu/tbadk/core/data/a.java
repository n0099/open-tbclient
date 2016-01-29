package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ub;
    private int Uc;
    private int Ud;
    private int mActivityId;
    private int mAwardActId;
    private int mComponentId;
    private int status;
    private int total_num;
    private String url;

    public int rD() {
        return this.Ub;
    }

    public int getStatus() {
        return this.status;
    }

    public int rE() {
        return this.Uc;
    }

    public int rF() {
        return this.Ud;
    }

    public String getUrl() {
        return this.url;
    }

    public int rG() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.mActivityId;
    }

    public int getAwardActId() {
        return this.mAwardActId;
    }

    public int getComponentId() {
        return this.mComponentId;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ub = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Uc = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ud = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.mActivityId = actInfo.activity_id.intValue();
            this.mAwardActId = actInfo.award_act_id.intValue();
            this.mComponentId = actInfo.component_id.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ub = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Uc = jSONObject.optInt("begin_time");
                this.Ud = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.mActivityId = jSONObject.optInt("activity_id");
                this.mAwardActId = jSONObject.optInt(PbLotteryRequestMessage.AWARD_ACT_ID);
                this.mComponentId = jSONObject.optInt(PbLotteryRequestMessage.COMPONENT_ID);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
