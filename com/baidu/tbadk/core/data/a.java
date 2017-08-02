package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int SD;
    private int SE;
    private int SF;
    private int SG;
    private int SH;
    private int SI;
    private String SJ;
    private int SK = 1;
    private int SL = 1;
    private int SM;
    private bd SN;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pe() {
        return this.SD;
    }

    public int getStatus() {
        return this.status;
    }

    public int pf() {
        return this.SE;
    }

    public int pg() {
        return this.SF;
    }

    public String getUrl() {
        return this.url;
    }

    public int ph() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.SG;
    }

    public int pi() {
        return this.SH;
    }

    public int pj() {
        return this.SI;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pk() {
        return this.SJ;
    }

    public int pl() {
        return this.SM;
    }

    public bd pm() {
        return this.SN;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.SD = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.SE = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.SF = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.SG = actInfo.activity_id.intValue();
            this.SH = actInfo.award_act_id.intValue();
            this.SI = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.SJ = actInfo.banner_img;
            this.SM = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.al.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.SK = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.SL = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.SK <= 0) {
                this.SK = 1;
            }
            if (this.SL <= 0) {
                this.SL = 1;
            }
            this.SN = new bd();
            this.SN.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.SD = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.SE = jSONObject.optInt("begin_time");
                this.SF = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.SG = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.SH = jSONObject.optInt("award_act_id");
                this.SI = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.SJ = jSONObject.optString("banner_img");
                this.SM = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.al.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.SK = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.SL = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.SK <= 0) {
                    this.SK = 1;
                }
                if (this.SL <= 0) {
                    this.SL = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
