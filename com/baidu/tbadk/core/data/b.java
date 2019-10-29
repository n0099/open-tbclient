package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int Ws;
    private int bRf;
    private int bWE;
    private int bWF;
    private int bWG;
    private int bWH;
    private boolean bWI;
    private String bWJ;
    private int bWK = 1;
    private int bWL = 1;
    private int bWM;
    private bc bWN;
    private int status;
    private int total_num;
    private String url;

    public int agM() {
        return this.Ws;
    }

    public int getStatus() {
        return this.status;
    }

    public int agN() {
        return this.bWE;
    }

    public int agO() {
        return this.bWF;
    }

    public String getUrl() {
        return this.url;
    }

    public int agP() {
        return this.total_num;
    }

    public boolean agQ() {
        return this.bWI;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Ws = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bWE = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.bWF = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.bRf = actInfo.activity_id.intValue();
            this.bWG = actInfo.award_act_id.intValue();
            this.bWH = actInfo.component_id.intValue();
            this.bWI = actInfo.is_senior.booleanValue();
            this.bWJ = actInfo.banner_img;
            this.bWM = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bWK = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    this.bWL = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bWK <= 0) {
                this.bWK = 1;
            }
            if (this.bWL <= 0) {
                this.bWL = 1;
            }
            this.bWN = new bc();
            this.bWN.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ws = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bWE = jSONObject.optInt("begin_time");
                this.bWF = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.bRf = jSONObject.optInt("activity_id");
                this.bWG = jSONObject.optInt("award_act_id");
                this.bWH = jSONObject.optInt("component_id");
                this.bWI = jSONObject.optBoolean("is_senior");
                this.bWJ = jSONObject.optString("banner_img");
                this.bWM = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bWK = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    this.bWL = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                }
                if (this.bWK <= 0) {
                    this.bWK = 1;
                }
                if (this.bWL <= 0) {
                    this.bWL = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
