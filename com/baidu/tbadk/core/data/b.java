package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bEN;
    private int bEO;
    private int bEP;
    private boolean bEQ;
    private String bER;
    private int bES = 1;
    private int bET = 1;
    private int bEU;
    private bc bEV;
    private int byz;
    private int end_time;
    private int status;
    private int total_num;
    private String url;

    public int acG() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int acH() {
        return this.bEN;
    }

    public int acI() {
        return this.end_time;
    }

    public String getUrl() {
        return this.url;
    }

    public int acJ() {
        return this.total_num;
    }

    public boolean acK() {
        return this.bEQ;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bEN = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.end_time = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.byz = actInfo.activity_id.intValue();
            this.bEO = actInfo.award_act_id.intValue();
            this.bEP = actInfo.component_id.intValue();
            this.bEQ = actInfo.is_senior.booleanValue();
            this.bER = actInfo.banner_img;
            this.bEU = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bES = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bET = com.baidu.adp.lib.g.b.f(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bES <= 0) {
                this.bES = 1;
            }
            if (this.bET <= 0) {
                this.bET = 1;
            }
            this.bEV = new bc();
            this.bEV.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bEN = jSONObject.optInt("begin_time");
                this.end_time = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.byz = jSONObject.optInt("activity_id");
                this.bEO = jSONObject.optInt("award_act_id");
                this.bEP = jSONObject.optInt("component_id");
                this.bEQ = jSONObject.optBoolean("is_senior");
                this.bER = jSONObject.optString("banner_img");
                this.bEU = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bES = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bET = com.baidu.adp.lib.g.b.f(split[1], 1);
                }
                if (this.bES <= 0) {
                    this.bES = 1;
                }
                if (this.bET <= 0) {
                    this.bET = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
