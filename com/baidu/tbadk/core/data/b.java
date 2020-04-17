package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int ayy;
    private int dgm;
    private int dlI;
    private int dlJ;
    private int dlK;
    private int dlL;
    private boolean dlM;
    private String dlN;
    private int dlO = 1;
    private int dlP = 1;
    private int dlQ;
    private be dlR;
    private int status;
    private int total_num;
    private String url;

    public int aIA() {
        return this.ayy;
    }

    public int getStatus() {
        return this.status;
    }

    public int aIB() {
        return this.dlI;
    }

    public int aIC() {
        return this.dlJ;
    }

    public String getUrl() {
        return this.url;
    }

    public int aID() {
        return this.total_num;
    }

    public boolean aIE() {
        return this.dlM;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.ayy = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dlI = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dlJ = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dgm = actInfo.activity_id.intValue();
            this.dlK = actInfo.award_act_id.intValue();
            this.dlL = actInfo.component_id.intValue();
            this.dlM = actInfo.is_senior.booleanValue();
            this.dlN = actInfo.banner_img;
            this.dlQ = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dlO = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dlP = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dlO <= 0) {
                this.dlO = 1;
            }
            if (this.dlP <= 0) {
                this.dlP = 1;
            }
            this.dlR = new be();
            this.dlR.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ayy = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dlI = jSONObject.optInt("begin_time");
                this.dlJ = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dgm = jSONObject.optInt("activity_id");
                this.dlK = jSONObject.optInt("award_act_id");
                this.dlL = jSONObject.optInt("component_id");
                this.dlM = jSONObject.optBoolean("is_senior");
                this.dlN = jSONObject.optString("banner_img");
                this.dlQ = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dlO = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dlP = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dlO <= 0) {
                    this.dlO = 1;
                }
                if (this.dlP <= 0) {
                    this.dlP = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
