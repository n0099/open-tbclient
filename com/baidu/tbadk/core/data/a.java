package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ub;
    private int Uc;
    private int Ud;
    private int Ue;
    private int Uf;
    private int Ug;
    private String Uh;
    private int Ui = 1;
    private int Uj = 1;
    private int Uk;
    private bd Ul;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int po() {
        return this.Ub;
    }

    public int getStatus() {
        return this.status;
    }

    public int pp() {
        return this.Uc;
    }

    public int pq() {
        return this.Ud;
    }

    public String getUrl() {
        return this.url;
    }

    public int pr() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Ue;
    }

    public int ps() {
        return this.Uf;
    }

    public int pt() {
        return this.Ug;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pu() {
        return this.Uh;
    }

    public int pv() {
        return this.Uk;
    }

    public bd pw() {
        return this.Ul;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ub = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Uc = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ud = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Ue = actInfo.activity_id.intValue();
            this.Uf = actInfo.award_act_id.intValue();
            this.Ug = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Uh = actInfo.banner_img;
            this.Uk = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.al.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Ui = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Uj = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Ui <= 0) {
                this.Ui = 1;
            }
            if (this.Uj <= 0) {
                this.Uj = 1;
            }
            this.Ul = new bd();
            this.Ul.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ub = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Uc = jSONObject.optInt("begin_time");
                this.Ud = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Ue = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Uf = jSONObject.optInt("award_act_id");
                this.Ug = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Uh = jSONObject.optString("banner_img");
                this.Uk = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.al.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Ui = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Uj = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Ui <= 0) {
                    this.Ui = 1;
                }
                if (this.Uj <= 0) {
                    this.Uj = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
