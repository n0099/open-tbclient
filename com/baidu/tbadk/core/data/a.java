package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aHO;
    private int dEL;
    private int dMq;
    private int dMr;
    private int dMs;
    private int dMt;
    private boolean dMu;
    private String dMv;
    private int dMw = 1;
    private int dMx = 1;
    private int dMy;
    private bq dMz;
    private int status;
    private int total_num;
    private String url;

    public int aTZ() {
        return this.aHO;
    }

    public int getStatus() {
        return this.status;
    }

    public int aUa() {
        return this.dMq;
    }

    public int aUb() {
        return this.dMr;
    }

    public String getUrl() {
        return this.url;
    }

    public int aUc() {
        return this.total_num;
    }

    public boolean aUd() {
        return this.dMu;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aHO = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dMq = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dMr = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dEL = actInfo.activity_id.intValue();
            this.dMs = actInfo.award_act_id.intValue();
            this.dMt = actInfo.component_id.intValue();
            this.dMu = actInfo.is_senior.booleanValue();
            this.dMv = actInfo.banner_img;
            this.dMy = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.as.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dMw = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dMx = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dMw <= 0) {
                this.dMw = 1;
            }
            if (this.dMx <= 0) {
                this.dMx = 1;
            }
            this.dMz = new bq();
            this.dMz.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aHO = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dMq = jSONObject.optInt("begin_time");
                this.dMr = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dEL = jSONObject.optInt("activity_id");
                this.dMs = jSONObject.optInt("award_act_id");
                this.dMt = jSONObject.optInt("component_id");
                this.dMu = jSONObject.optBoolean("is_senior");
                this.dMv = jSONObject.optString("banner_img");
                this.dMy = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.as.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dMw = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dMx = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dMw <= 0) {
                    this.dMw = 1;
                }
                if (this.dMx <= 0) {
                    this.dMx = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
