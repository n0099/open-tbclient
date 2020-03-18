package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int agi;
    private int cHl;
    private int cMC;
    private int cMD;
    private int cME;
    private int cMF;
    private boolean cMG;
    private String cMH;
    private int cMI = 1;
    private int cMJ = 1;
    private int cMK;
    private be cML;
    private int status;
    private int total_num;
    private String url;

    public int aAn() {
        return this.agi;
    }

    public int getStatus() {
        return this.status;
    }

    public int aAo() {
        return this.cMC;
    }

    public int aAp() {
        return this.cMD;
    }

    public String getUrl() {
        return this.url;
    }

    public int aAq() {
        return this.total_num;
    }

    public boolean aAr() {
        return this.cMG;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.agi = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.cMC = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.cMD = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.cHl = actInfo.activity_id.intValue();
            this.cME = actInfo.award_act_id.intValue();
            this.cMF = actInfo.component_id.intValue();
            this.cMG = actInfo.is_senior.booleanValue();
            this.cMH = actInfo.banner_img;
            this.cMK = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMI = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMJ = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.cMI <= 0) {
                this.cMI = 1;
            }
            if (this.cMJ <= 0) {
                this.cMJ = 1;
            }
            this.cML = new be();
            this.cML.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agi = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.cMC = jSONObject.optInt("begin_time");
                this.cMD = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.cHl = jSONObject.optInt("activity_id");
                this.cME = jSONObject.optInt("award_act_id");
                this.cMF = jSONObject.optInt("component_id");
                this.cMG = jSONObject.optBoolean("is_senior");
                this.cMH = jSONObject.optString("banner_img");
                this.cMK = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMI = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMJ = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.cMI <= 0) {
                    this.cMI = 1;
                }
                if (this.cMJ <= 0) {
                    this.cMJ = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
