package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ue;
    private int Uf;
    private int Ug;
    private int Uh;
    private int Ui;
    private int Uj;
    private String Uk;
    private int Ul = 1;
    private int Um = 1;
    private int Un;
    private bd Uo;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pp() {
        return this.Ue;
    }

    public int getStatus() {
        return this.status;
    }

    public int pq() {
        return this.Uf;
    }

    public int pr() {
        return this.Ug;
    }

    public String getUrl() {
        return this.url;
    }

    public int ps() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Uh;
    }

    public int pt() {
        return this.Ui;
    }

    public int pu() {
        return this.Uj;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pv() {
        return this.Uk;
    }

    public int pw() {
        return this.Un;
    }

    public bd px() {
        return this.Uo;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ue = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Uf = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ug = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Uh = actInfo.activity_id.intValue();
            this.Ui = actInfo.award_act_id.intValue();
            this.Uj = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Uk = actInfo.banner_img;
            this.Un = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.al.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Ul = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Um = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Ul <= 0) {
                this.Ul = 1;
            }
            if (this.Um <= 0) {
                this.Um = 1;
            }
            this.Uo = new bd();
            this.Uo.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ue = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Uf = jSONObject.optInt("begin_time");
                this.Ug = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Uh = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Ui = jSONObject.optInt("award_act_id");
                this.Uj = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Uk = jSONObject.optString("banner_img");
                this.Un = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.al.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Ul = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Um = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Ul <= 0) {
                    this.Ul = 1;
                }
                if (this.Um <= 0) {
                    this.Um = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
