package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Mn;
    private int Mo;
    private int Mp;
    private int Mq;
    private int Mr;
    private int Ms;
    private String Mt;
    private int Mu = 1;
    private int Mv = 1;
    private int Mw;
    private as Mx;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int om() {
        return this.Mn;
    }

    public int getStatus() {
        return this.status;
    }

    public int on() {
        return this.Mo;
    }

    public int oo() {
        return this.Mp;
    }

    public String getUrl() {
        return this.url;
    }

    public int op() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Mq;
    }

    public int oq() {
        return this.Mr;
    }

    public int or() {
        return this.Ms;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String os() {
        return this.Mt;
    }

    public int ot() {
        return this.Mw;
    }

    public as ou() {
        return this.Mx;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Mn = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Mo = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Mp = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Mq = actInfo.activity_id.intValue();
            this.Mr = actInfo.award_act_id.intValue();
            this.Ms = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Mt = actInfo.banner_img;
            this.Mw = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ba.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.Mu = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.Mv = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Mu <= 0) {
                this.Mu = 1;
            }
            if (this.Mv <= 0) {
                this.Mv = 1;
            }
            this.Mx = new as();
            this.Mx.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Mn = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Mo = jSONObject.optInt("begin_time");
                this.Mp = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME);
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Mq = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Mr = jSONObject.optInt("award_act_id");
                this.Ms = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Mt = jSONObject.optString("banner_img");
                this.Mw = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ba.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.Mu = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.Mv = com.baidu.adp.lib.h.b.g(split[1], 1);
                }
                if (this.Mu <= 0) {
                    this.Mu = 1;
                }
                if (this.Mv <= 0) {
                    this.Mv = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
