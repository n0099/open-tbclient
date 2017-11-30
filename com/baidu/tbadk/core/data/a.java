package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Uj;
    private int Uk;
    private int Ul;
    private int Um;
    private int Un;
    private String Uo;
    private int Up = 1;
    private int Uq = 1;
    private int Ur;
    private ax Us;
    private int activity_type;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pq() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int pr() {
        return this.Uj;
    }

    public int ps() {
        return this.Uk;
    }

    public String getUrl() {
        return this.url;
    }

    public int pt() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Ul;
    }

    public int pu() {
        return this.Um;
    }

    public int pv() {
        return this.Un;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public int pw() {
        return this.Ur;
    }

    public ax px() {
        return this.Us;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Uj = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Uk = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Ul = actInfo.activity_id.intValue();
            this.Um = actInfo.award_act_id.intValue();
            this.Un = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Uo = actInfo.banner_img;
            this.Ur = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Up = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Uq = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Up <= 0) {
                this.Up = 1;
            }
            if (this.Uq <= 0) {
                this.Uq = 1;
            }
            this.Us = new ax();
            this.Us.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Uj = jSONObject.optInt("begin_time");
                this.Uk = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Ul = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Um = jSONObject.optInt("award_act_id");
                this.Un = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Uo = jSONObject.optString("banner_img");
                this.Ur = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Up = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Uq = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Up <= 0) {
                    this.Up = 1;
                }
                if (this.Uq <= 0) {
                    this.Uq = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
