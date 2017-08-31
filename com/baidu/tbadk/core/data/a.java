package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Tg;
    private int Th;
    private int Ti;
    private int Tj;
    private int Tk;
    private int Tl;
    private String Tm;
    private int Tn = 1;
    private int To = 1;
    private int Tp;
    private bd Tq;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pj() {
        return this.Tg;
    }

    public int getStatus() {
        return this.status;
    }

    public int pk() {
        return this.Th;
    }

    public int pl() {
        return this.Ti;
    }

    public String getUrl() {
        return this.url;
    }

    public int pm() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Tj;
    }

    public int pn() {
        return this.Tk;
    }

    public int po() {
        return this.Tl;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pp() {
        return this.Tm;
    }

    public int pq() {
        return this.Tp;
    }

    public bd pr() {
        return this.Tq;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Tg = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Th = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ti = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Tj = actInfo.activity_id.intValue();
            this.Tk = actInfo.award_act_id.intValue();
            this.Tl = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Tm = actInfo.banner_img;
            this.Tp = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Tn = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.To = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Tn <= 0) {
                this.Tn = 1;
            }
            if (this.To <= 0) {
                this.To = 1;
            }
            this.Tq = new bd();
            this.Tq.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Tg = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Th = jSONObject.optInt("begin_time");
                this.Ti = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Tj = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Tk = jSONObject.optInt("award_act_id");
                this.Tl = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Tm = jSONObject.optString("banner_img");
                this.Tp = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Tn = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.To = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Tn <= 0) {
                    this.Tn = 1;
                }
                if (this.To <= 0) {
                    this.To = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
