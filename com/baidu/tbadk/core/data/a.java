package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int SA = 1;
    private int SB = 1;
    private int SC;
    private bd SD;
    private int St;
    private int Su;
    private int Sv;
    private int Sw;
    private int Sx;
    private int Sy;
    private String Sz;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pe() {
        return this.St;
    }

    public int getStatus() {
        return this.status;
    }

    public int pf() {
        return this.Su;
    }

    public int pg() {
        return this.Sv;
    }

    public String getUrl() {
        return this.url;
    }

    public int ph() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Sw;
    }

    public int pi() {
        return this.Sx;
    }

    public int pj() {
        return this.Sy;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pk() {
        return this.Sz;
    }

    public int pl() {
        return this.SC;
    }

    public bd pm() {
        return this.SD;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.St = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Su = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Sv = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Sw = actInfo.activity_id.intValue();
            this.Sx = actInfo.award_act_id.intValue();
            this.Sy = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.Sz = actInfo.banner_img;
            this.SC = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.SA = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.SB = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.SA <= 0) {
                this.SA = 1;
            }
            if (this.SB <= 0) {
                this.SB = 1;
            }
            this.SD = new bd();
            this.SD.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.St = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Su = jSONObject.optInt("begin_time");
                this.Sv = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Sw = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Sx = jSONObject.optInt("award_act_id");
                this.Sy = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.Sz = jSONObject.optString("banner_img");
                this.SC = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.SA = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.SB = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.SA <= 0) {
                    this.SA = 1;
                }
                if (this.SB <= 0) {
                    this.SB = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
