package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int ST;
    private int SU;
    private int SV;
    private int SW;
    private int SX;
    private int SY;
    private String SZ;
    private int Ta = 1;
    private int Tb = 1;
    private int Tc;
    private bc Td;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int ph() {
        return this.ST;
    }

    public int getStatus() {
        return this.status;
    }

    public int pi() {
        return this.SU;
    }

    public int pj() {
        return this.SV;
    }

    public String getUrl() {
        return this.url;
    }

    public int pk() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.SW;
    }

    public int pl() {
        return this.SX;
    }

    public int pm() {
        return this.SY;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pn() {
        return this.SZ;
    }

    public int po() {
        return this.Tc;
    }

    public bc pp() {
        return this.Td;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.ST = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.SU = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.SV = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.SW = actInfo.activity_id.intValue();
            this.SX = actInfo.award_act_id.intValue();
            this.SY = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.SZ = actInfo.banner_img;
            this.Tc = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.Ta = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tb = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Ta <= 0) {
                this.Ta = 1;
            }
            if (this.Tb <= 0) {
                this.Tb = 1;
            }
            this.Td = new bc();
            this.Td.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ST = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.SU = jSONObject.optInt("begin_time");
                this.SV = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.SW = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.SX = jSONObject.optInt("award_act_id");
                this.SY = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.SZ = jSONObject.optString("banner_img");
                this.Tc = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.Ta = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Tb = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Ta <= 0) {
                    this.Ta = 1;
                }
                if (this.Tb <= 0) {
                    this.Tb = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
