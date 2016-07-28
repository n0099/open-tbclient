package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ml;
    private int Mm;
    private int Mn;
    private int Mo;
    private int Mp;
    private int Mq;
    private String Mr;
    private int Ms = 1;
    private int Mt = 1;
    private int Mu;
    private ax Mv;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int ob() {
        return this.Ml;
    }

    public int getStatus() {
        return this.status;
    }

    public int oc() {
        return this.Mm;
    }

    public int od() {
        return this.Mn;
    }

    public String getUrl() {
        return this.url;
    }

    public int oe() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Mo;
    }

    public int of() {
        return this.Mp;
    }

    public int og() {
        return this.Mq;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String oh() {
        return this.Mr;
    }

    public int oi() {
        return this.Mu;
    }

    public ax oj() {
        return this.Mv;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ml = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Mm = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Mn = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Mo = actInfo.activity_id.intValue();
            this.Mp = actInfo.award_act_id.intValue();
            this.Mq = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Mr = actInfo.banner_img;
            this.Mu = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ba.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.Ms = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.Mt = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Ms <= 0) {
                this.Ms = 1;
            }
            if (this.Mt <= 0) {
                this.Mt = 1;
            }
            this.Mv = new ax();
            this.Mv.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ml = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Mm = jSONObject.optInt("begin_time");
                this.Mn = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME);
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Mo = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Mp = jSONObject.optInt("award_act_id");
                this.Mq = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Mr = jSONObject.optString("banner_img");
                this.Mu = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ba.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.Ms = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.Mt = com.baidu.adp.lib.h.b.g(split[1], 1);
                }
                if (this.Ms <= 0) {
                    this.Ms = 1;
                }
                if (this.Mt <= 0) {
                    this.Mt = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
