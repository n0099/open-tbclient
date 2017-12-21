package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ug;
    private int Uh;
    private int Ui;
    private int Uj;
    private int Uk;
    private String Ul;
    private int Um = 1;
    private int Un = 1;
    private int Uo;
    private ax Up;
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
        return this.Ug;
    }

    public int pq() {
        return this.Uh;
    }

    public String getUrl() {
        return this.url;
    }

    public int pr() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Ui;
    }

    public int ps() {
        return this.Uj;
    }

    public int pt() {
        return this.Uk;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public int pu() {
        return this.Uo;
    }

    public ax pv() {
        return this.Up;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Ug = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Uh = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Ui = actInfo.activity_id.intValue();
            this.Uj = actInfo.award_act_id.intValue();
            this.Uk = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Ul = actInfo.banner_img;
            this.Uo = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Um = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Un = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Um <= 0) {
                this.Um = 1;
            }
            if (this.Un <= 0) {
                this.Un = 1;
            }
            this.Up = new ax();
            this.Up.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Ug = jSONObject.optInt("begin_time");
                this.Uh = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Ui = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Uj = jSONObject.optInt("award_act_id");
                this.Uk = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Ul = jSONObject.optString("banner_img");
                this.Uo = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Um = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Un = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Um <= 0) {
                    this.Um = 1;
                }
                if (this.Un <= 0) {
                    this.Un = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
