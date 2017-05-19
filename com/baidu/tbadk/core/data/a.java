package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int SG;
    private int SH;
    private int SI;
    private int SJ;
    private int SK;
    private int SL;
    private String SM;
    private int SN = 1;
    private int SO = 1;
    private int SP;
    private bc SQ;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pm() {
        return this.SG;
    }

    public int getStatus() {
        return this.status;
    }

    public int pn() {
        return this.SH;
    }

    public int po() {
        return this.SI;
    }

    public String getUrl() {
        return this.url;
    }

    public int pp() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.SJ;
    }

    public int pq() {
        return this.SK;
    }

    public int pr() {
        return this.SL;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String ps() {
        return this.SM;
    }

    public int pt() {
        return this.SP;
    }

    public bc pu() {
        return this.SQ;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.SG = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.SH = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.SI = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.SJ = actInfo.activity_id.intValue();
            this.SK = actInfo.award_act_id.intValue();
            this.SL = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.SM = actInfo.banner_img;
            this.SP = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.SN = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.SO = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.SN <= 0) {
                this.SN = 1;
            }
            if (this.SO <= 0) {
                this.SO = 1;
            }
            this.SQ = new bc();
            this.SQ.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.SG = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.SH = jSONObject.optInt("begin_time");
                this.SI = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.SJ = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.SK = jSONObject.optInt("award_act_id");
                this.SL = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.SM = jSONObject.optString("banner_img");
                this.SP = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.SN = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.SO = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.SN <= 0) {
                    this.SN = 1;
                }
                if (this.SO <= 0) {
                    this.SO = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
