package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aDX;
    private int dug;
    private int dzO;
    private int dzP;
    private int dzQ;
    private int dzR;
    private boolean dzS;
    private String dzT;
    private int dzU = 1;
    private int dzV = 1;
    private int dzW;
    private bf dzX;
    private int status;
    private int total_num;
    private String url;

    public int aOt() {
        return this.aDX;
    }

    public int getStatus() {
        return this.status;
    }

    public int aOu() {
        return this.dzO;
    }

    public int aOv() {
        return this.dzP;
    }

    public String getUrl() {
        return this.url;
    }

    public int aOw() {
        return this.total_num;
    }

    public boolean aOx() {
        return this.dzS;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aDX = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dzO = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dzP = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dug = actInfo.activity_id.intValue();
            this.dzQ = actInfo.award_act_id.intValue();
            this.dzR = actInfo.component_id.intValue();
            this.dzS = actInfo.is_senior.booleanValue();
            this.dzT = actInfo.banner_img;
            this.dzW = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dzU = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dzV = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dzU <= 0) {
                this.dzU = 1;
            }
            if (this.dzV <= 0) {
                this.dzV = 1;
            }
            this.dzX = new bf();
            this.dzX.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aDX = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dzO = jSONObject.optInt("begin_time");
                this.dzP = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dug = jSONObject.optInt("activity_id");
                this.dzQ = jSONObject.optInt("award_act_id");
                this.dzR = jSONObject.optInt("component_id");
                this.dzS = jSONObject.optBoolean("is_senior");
                this.dzT = jSONObject.optString("banner_img");
                this.dzW = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dzU = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dzV = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dzU <= 0) {
                    this.dzU = 1;
                }
                if (this.dzV <= 0) {
                    this.dzV = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
