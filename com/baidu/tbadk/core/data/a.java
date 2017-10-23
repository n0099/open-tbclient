package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ti;
    private int Tj;
    private int Tk;
    private int Tl;
    private int Tm;
    private int Tn;
    private String To;
    private int Tp = 1;
    private int Tq = 1;
    private int Tr;
    private bb Ts;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pd() {
        return this.Ti;
    }

    public int getStatus() {
        return this.status;
    }

    public int pe() {
        return this.Tj;
    }

    public int pf() {
        return this.Tk;
    }

    public String getUrl() {
        return this.url;
    }

    public int pg() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Tl;
    }

    public int ph() {
        return this.Tm;
    }

    public int pi() {
        return this.Tn;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pj() {
        return this.To;
    }

    public int pk() {
        return this.Tr;
    }

    public bb pl() {
        return this.Ts;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ti = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Tj = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Tk = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Tl = actInfo.activity_id.intValue();
            this.Tm = actInfo.award_act_id.intValue();
            this.Tn = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.To = actInfo.banner_img;
            this.Tr = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Tp = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tq = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Tp <= 0) {
                this.Tp = 1;
            }
            if (this.Tq <= 0) {
                this.Tq = 1;
            }
            this.Ts = new bb();
            this.Ts.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ti = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Tj = jSONObject.optInt("begin_time");
                this.Tk = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Tl = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Tm = jSONObject.optInt("award_act_id");
                this.Tn = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.To = jSONObject.optString("banner_img");
                this.Tr = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Tp = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tq = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Tp <= 0) {
                    this.Tp = 1;
                }
                if (this.Tq <= 0) {
                    this.Tq = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
