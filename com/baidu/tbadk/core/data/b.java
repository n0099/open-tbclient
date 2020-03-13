package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int afX;
    private int cHa;
    private be cMA;
    private int cMr;
    private int cMs;
    private int cMt;
    private int cMu;
    private boolean cMv;
    private String cMw;
    private int cMx = 1;
    private int cMy = 1;
    private int cMz;
    private int status;
    private int total_num;
    private String url;

    public int aAk() {
        return this.afX;
    }

    public int getStatus() {
        return this.status;
    }

    public int aAl() {
        return this.cMr;
    }

    public int aAm() {
        return this.cMs;
    }

    public String getUrl() {
        return this.url;
    }

    public int aAn() {
        return this.total_num;
    }

    public boolean aAo() {
        return this.cMv;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.afX = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.cMr = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.cMs = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.cHa = actInfo.activity_id.intValue();
            this.cMt = actInfo.award_act_id.intValue();
            this.cMu = actInfo.component_id.intValue();
            this.cMv = actInfo.is_senior.booleanValue();
            this.cMw = actInfo.banner_img;
            this.cMz = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMx = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMy = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.cMx <= 0) {
                this.cMx = 1;
            }
            if (this.cMy <= 0) {
                this.cMy = 1;
            }
            this.cMA = new be();
            this.cMA.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afX = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.cMr = jSONObject.optInt("begin_time");
                this.cMs = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.cHa = jSONObject.optInt("activity_id");
                this.cMt = jSONObject.optInt("award_act_id");
                this.cMu = jSONObject.optInt("component_id");
                this.cMv = jSONObject.optBoolean("is_senior");
                this.cMw = jSONObject.optString("banner_img");
                this.cMz = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMx = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMy = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.cMx <= 0) {
                    this.cMx = 1;
                }
                if (this.cMy <= 0) {
                    this.cMy = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
