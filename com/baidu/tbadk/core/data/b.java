package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int adB;
    private int cCP;
    private int cIa;
    private int cIb;
    private int cIc;
    private int cId;
    private boolean cIe;
    private String cIf;
    private int cIg = 1;
    private int cIh = 1;
    private int cIi;
    private be cIj;
    private int status;
    private int total_num;
    private String url;

    public int axB() {
        return this.adB;
    }

    public int getStatus() {
        return this.status;
    }

    public int axC() {
        return this.cIa;
    }

    public int axD() {
        return this.cIb;
    }

    public String getUrl() {
        return this.url;
    }

    public int axE() {
        return this.total_num;
    }

    public boolean axF() {
        return this.cIe;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.adB = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.cIa = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.cIb = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.cCP = actInfo.activity_id.intValue();
            this.cIc = actInfo.award_act_id.intValue();
            this.cId = actInfo.component_id.intValue();
            this.cIe = actInfo.is_senior.booleanValue();
            this.cIf = actInfo.banner_img;
            this.cIi = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cIg = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cIh = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.cIg <= 0) {
                this.cIg = 1;
            }
            if (this.cIh <= 0) {
                this.cIh = 1;
            }
            this.cIj = new be();
            this.cIj.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.adB = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.cIa = jSONObject.optInt("begin_time");
                this.cIb = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.cCP = jSONObject.optInt("activity_id");
                this.cIc = jSONObject.optInt("award_act_id");
                this.cId = jSONObject.optInt("component_id");
                this.cIe = jSONObject.optBoolean("is_senior");
                this.cIf = jSONObject.optString("banner_img");
                this.cIi = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cIg = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cIh = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.cIg <= 0) {
                    this.cIg = 1;
                }
                if (this.cIh <= 0) {
                    this.cIh = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
