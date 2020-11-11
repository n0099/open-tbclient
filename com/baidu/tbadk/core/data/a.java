package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aSD;
    private int aUs;
    private int eqr;
    private int eyi;
    private int eyj;
    private int eyk;
    private boolean eyl;
    private String eyn;
    private int eyo = 1;
    private int eyp = 1;
    private int eyq;
    private br eyr;
    private int status;
    private int total_num;
    private String url;

    public int bkm() {
        return this.aUs;
    }

    public int getStatus() {
        return this.status;
    }

    public int bkn() {
        return this.eyi;
    }

    public int bko() {
        return this.aSD;
    }

    public String getUrl() {
        return this.url;
    }

    public int bkp() {
        return this.total_num;
    }

    public boolean bkq() {
        return this.eyl;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aUs = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eyi = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aSD = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.eqr = actInfo.activity_id.intValue();
            this.eyj = actInfo.award_act_id.intValue();
            this.eyk = actInfo.component_id.intValue();
            this.eyl = actInfo.is_senior.booleanValue();
            this.eyn = actInfo.banner_img;
            this.eyq = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.eyo = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eyp = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.eyo <= 0) {
                this.eyo = 1;
            }
            if (this.eyp <= 0) {
                this.eyp = 1;
            }
            this.eyr = new br();
            this.eyr.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aUs = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eyi = jSONObject.optInt("begin_time");
                this.aSD = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.eqr = jSONObject.optInt("activity_id");
                this.eyj = jSONObject.optInt("award_act_id");
                this.eyk = jSONObject.optInt("component_id");
                this.eyl = jSONObject.optBoolean("is_senior");
                this.eyn = jSONObject.optString("banner_img");
                this.eyq = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.eyo = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eyp = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.eyo <= 0) {
                    this.eyo = 1;
                }
                if (this.eyp <= 0) {
                    this.eyp = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
