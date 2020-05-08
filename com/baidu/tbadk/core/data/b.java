package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int ayE;
    private int dgr;
    private int dlM;
    private int dlN;
    private int dlO;
    private int dlP;
    private boolean dlQ;
    private String dlR;
    private int dlS = 1;
    private int dlT = 1;
    private int dlU;
    private be dlV;
    private int status;
    private int total_num;
    private String url;

    public int aIy() {
        return this.ayE;
    }

    public int getStatus() {
        return this.status;
    }

    public int aIz() {
        return this.dlM;
    }

    public int aIA() {
        return this.dlN;
    }

    public String getUrl() {
        return this.url;
    }

    public int aIB() {
        return this.total_num;
    }

    public boolean aIC() {
        return this.dlQ;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.ayE = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dlM = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dlN = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dgr = actInfo.activity_id.intValue();
            this.dlO = actInfo.award_act_id.intValue();
            this.dlP = actInfo.component_id.intValue();
            this.dlQ = actInfo.is_senior.booleanValue();
            this.dlR = actInfo.banner_img;
            this.dlU = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dlS = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dlT = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dlS <= 0) {
                this.dlS = 1;
            }
            if (this.dlT <= 0) {
                this.dlT = 1;
            }
            this.dlV = new be();
            this.dlV.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ayE = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dlM = jSONObject.optInt("begin_time");
                this.dlN = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dgr = jSONObject.optInt("activity_id");
                this.dlO = jSONObject.optInt("award_act_id");
                this.dlP = jSONObject.optInt("component_id");
                this.dlQ = jSONObject.optBoolean("is_senior");
                this.dlR = jSONObject.optString("banner_img");
                this.dlU = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dlS = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dlT = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dlS <= 0) {
                    this.dlS = 1;
                }
                if (this.dlT <= 0) {
                    this.dlT = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
