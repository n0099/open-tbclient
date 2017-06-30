package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int So;
    private int Sp;
    private int Sq;
    private int Sr;
    private int Ss;
    private int St;
    private String Su;
    private int Sv = 1;
    private int Sw = 1;
    private int Sx;
    private be Sy;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pb() {
        return this.So;
    }

    public int getStatus() {
        return this.status;
    }

    public int pc() {
        return this.Sp;
    }

    public int pd() {
        return this.Sq;
    }

    public String getUrl() {
        return this.url;
    }

    public int pe() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Sr;
    }

    public int pf() {
        return this.Ss;
    }

    public int pg() {
        return this.St;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String ph() {
        return this.Su;
    }

    public int pi() {
        return this.Sx;
    }

    public be pj() {
        return this.Sy;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.So = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Sp = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Sq = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Sr = actInfo.activity_id.intValue();
            this.Ss = actInfo.award_act_id.intValue();
            this.St = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Su = actInfo.banner_img;
            this.Sx = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aw.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Sv = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Sw = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Sv <= 0) {
                this.Sv = 1;
            }
            if (this.Sw <= 0) {
                this.Sw = 1;
            }
            this.Sy = new be();
            this.Sy.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.So = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Sp = jSONObject.optInt("begin_time");
                this.Sq = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Sr = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Ss = jSONObject.optInt("award_act_id");
                this.St = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Su = jSONObject.optString("banner_img");
                this.Sx = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aw.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Sv = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Sw = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Sv <= 0) {
                    this.Sv = 1;
                }
                if (this.Sw <= 0) {
                    this.Sw = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
