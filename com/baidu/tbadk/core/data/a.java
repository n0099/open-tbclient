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
    private String Ui;
    private int Uj = 1;
    private int Uk = 1;
    private int Ul;
    private ax Um;
    private int activity_type;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int po() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int pp() {
        return this.Ud;
    }

    public int pq() {
        return this.Ue;
    }

    public String getUrl() {
        return this.url;
    }

    public int pr() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Uf;
    }

    public int ps() {
        return this.Ug;
    }

    public int pt() {
        return this.Uh;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public int pu() {
        return this.Ul;
    }

    public ax pv() {
        return this.Um;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Ud = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ue = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Uf = actInfo.activity_id.intValue();
            this.Ug = actInfo.award_act_id.intValue();
            this.Uh = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Ui = actInfo.banner_img;
            this.Ul = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Uj = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Uk = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Uj <= 0) {
                this.Uj = 1;
            }
            if (this.Uk <= 0) {
                this.Uk = 1;
            }
            this.Um = new ax();
            this.Um.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Ud = jSONObject.optInt("begin_time");
                this.Ue = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Uf = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Ug = jSONObject.optInt("award_act_id");
                this.Uh = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Ui = jSONObject.optString("banner_img");
                this.Ul = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Uj = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Uk = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Uj <= 0) {
                    this.Uj = 1;
                }
                if (this.Uk <= 0) {
                    this.Uk = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
