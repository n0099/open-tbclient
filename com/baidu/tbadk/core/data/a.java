package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Tl;
    private int Tm;
    private int Tn;
    private int To;
    private int Tp;
    private int Tq;
    private String Tr;
    private int Ts = 1;
    private int Tt = 1;
    private int Tu;
    private bb Tv;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pF() {
        return this.Tl;
    }

    public int getStatus() {
        return this.status;
    }

    public int pG() {
        return this.Tm;
    }

    public int pH() {
        return this.Tn;
    }

    public String getUrl() {
        return this.url;
    }

    public int pI() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.To;
    }

    public int pJ() {
        return this.Tp;
    }

    public int pK() {
        return this.Tq;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pL() {
        return this.Tr;
    }

    public int pM() {
        return this.Tu;
    }

    public bb pN() {
        return this.Tv;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Tl = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Tm = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Tn = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.To = actInfo.activity_id.intValue();
            this.Tp = actInfo.award_act_id.intValue();
            this.Tq = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Tr = actInfo.banner_img;
            this.Tu = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.Ts = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tt = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Ts <= 0) {
                this.Ts = 1;
            }
            if (this.Tt <= 0) {
                this.Tt = 1;
            }
            this.Tv = new bb();
            this.Tv.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Tl = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Tm = jSONObject.optInt("begin_time");
                this.Tn = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.To = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Tp = jSONObject.optInt("award_act_id");
                this.Tq = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Tr = jSONObject.optString("banner_img");
                this.Tu = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.Ts = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tt = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Ts <= 0) {
                    this.Ts = 1;
                }
                if (this.Tt <= 0) {
                    this.Tt = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
