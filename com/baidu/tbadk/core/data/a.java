package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Tn;
    private int To;
    private int Tp;
    private int Tq;
    private int Tr;
    private int Ts;
    private String Tt;
    private int Tu = 1;
    private int Tv = 1;
    private int Tw;
    private bb Tx;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pF() {
        return this.Tn;
    }

    public int getStatus() {
        return this.status;
    }

    public int pG() {
        return this.To;
    }

    public int pH() {
        return this.Tp;
    }

    public String getUrl() {
        return this.url;
    }

    public int pI() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Tq;
    }

    public int pJ() {
        return this.Tr;
    }

    public int pK() {
        return this.Ts;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pL() {
        return this.Tt;
    }

    public int pM() {
        return this.Tw;
    }

    public bb pN() {
        return this.Tx;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Tn = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.To = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Tp = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Tq = actInfo.activity_id.intValue();
            this.Tr = actInfo.award_act_id.intValue();
            this.Ts = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Tt = actInfo.banner_img;
            this.Tw = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.Tu = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tv = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Tu <= 0) {
                this.Tu = 1;
            }
            if (this.Tv <= 0) {
                this.Tv = 1;
            }
            this.Tx = new bb();
            this.Tx.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Tn = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.To = jSONObject.optInt("begin_time");
                this.Tp = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Tq = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Tr = jSONObject.optInt("award_act_id");
                this.Ts = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Tt = jSONObject.optString("banner_img");
                this.Tw = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.Tu = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tv = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Tu <= 0) {
                    this.Tu = 1;
                }
                if (this.Tv <= 0) {
                    this.Tv = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
