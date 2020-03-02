package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int afX;
    private int cGZ;
    private int cMq;
    private int cMr;
    private int cMs;
    private int cMt;
    private boolean cMu;
    private String cMv;
    private int cMw = 1;
    private int cMx = 1;
    private int cMy;
    private be cMz;
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
        return this.cMq;
    }

    public int aAm() {
        return this.cMr;
    }

    public String getUrl() {
        return this.url;
    }

    public int aAn() {
        return this.total_num;
    }

    public boolean aAo() {
        return this.cMu;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.afX = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.cMq = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.cMr = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.cGZ = actInfo.activity_id.intValue();
            this.cMs = actInfo.award_act_id.intValue();
            this.cMt = actInfo.component_id.intValue();
            this.cMu = actInfo.is_senior.booleanValue();
            this.cMv = actInfo.banner_img;
            this.cMy = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMw = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMx = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.cMw <= 0) {
                this.cMw = 1;
            }
            if (this.cMx <= 0) {
                this.cMx = 1;
            }
            this.cMz = new be();
            this.cMz.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afX = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.cMq = jSONObject.optInt("begin_time");
                this.cMr = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.cGZ = jSONObject.optInt("activity_id");
                this.cMs = jSONObject.optInt("award_act_id");
                this.cMt = jSONObject.optInt("component_id");
                this.cMu = jSONObject.optBoolean("is_senior");
                this.cMv = jSONObject.optString("banner_img");
                this.cMy = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMw = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMx = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.cMw <= 0) {
                    this.cMw = 1;
                }
                if (this.cMx <= 0) {
                    this.cMx = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
