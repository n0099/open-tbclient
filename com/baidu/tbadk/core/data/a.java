package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aOT;
    private int dQa;
    private int dXN;
    private int dXO;
    private int dXP;
    private int dXQ;
    private boolean dXR;
    private String dXS;
    private int dXT = 1;
    private int dXU = 1;
    private int dXV;
    private br dXW;
    private int status;
    private int total_num;
    private String url;

    public int bdk() {
        return this.aOT;
    }

    public int getStatus() {
        return this.status;
    }

    public int bdl() {
        return this.dXN;
    }

    public int bdm() {
        return this.dXO;
    }

    public String getUrl() {
        return this.url;
    }

    public int bdn() {
        return this.total_num;
    }

    public boolean bdo() {
        return this.dXR;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aOT = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dXN = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dXO = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dQa = actInfo.activity_id.intValue();
            this.dXP = actInfo.award_act_id.intValue();
            this.dXQ = actInfo.component_id.intValue();
            this.dXR = actInfo.is_senior.booleanValue();
            this.dXS = actInfo.banner_img;
            this.dXV = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dXT = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dXU = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dXT <= 0) {
                this.dXT = 1;
            }
            if (this.dXU <= 0) {
                this.dXU = 1;
            }
            this.dXW = new br();
            this.dXW.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aOT = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dXN = jSONObject.optInt("begin_time");
                this.dXO = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dQa = jSONObject.optInt("activity_id");
                this.dXP = jSONObject.optInt("award_act_id");
                this.dXQ = jSONObject.optInt("component_id");
                this.dXR = jSONObject.optBoolean("is_senior");
                this.dXS = jSONObject.optString("banner_img");
                this.dXV = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dXT = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dXU = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dXT <= 0) {
                    this.dXT = 1;
                }
                if (this.dXU <= 0) {
                    this.dXU = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
