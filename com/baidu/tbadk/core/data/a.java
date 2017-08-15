package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ud;
    private int Ue;
    private int Uf;
    private int Ug;
    private int Uh;
    private int Ui;
    private String Uj;
    private int Uk = 1;
    private int Ul = 1;
    private int Um;
    private bd Un;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int po() {
        return this.Ud;
    }

    public int getStatus() {
        return this.status;
    }

    public int pp() {
        return this.Ue;
    }

    public int pq() {
        return this.Uf;
    }

    public String getUrl() {
        return this.url;
    }

    public int pr() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Ug;
    }

    public int ps() {
        return this.Uh;
    }

    public int pt() {
        return this.Ui;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pu() {
        return this.Uj;
    }

    public int pv() {
        return this.Um;
    }

    public bd pw() {
        return this.Un;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ud = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Ue = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Uf = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Ug = actInfo.activity_id.intValue();
            this.Uh = actInfo.award_act_id.intValue();
            this.Ui = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Uj = actInfo.banner_img;
            this.Um = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.al.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Uk = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Ul = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Uk <= 0) {
                this.Uk = 1;
            }
            if (this.Ul <= 0) {
                this.Ul = 1;
            }
            this.Un = new bd();
            this.Un.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ud = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Ue = jSONObject.optInt("begin_time");
                this.Uf = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Ug = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Uh = jSONObject.optInt("award_act_id");
                this.Ui = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Uj = jSONObject.optString("banner_img");
                this.Um = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.al.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Uk = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Ul = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Uk <= 0) {
                    this.Uk = 1;
                }
                if (this.Ul <= 0) {
                    this.Ul = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
