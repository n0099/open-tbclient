package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int afX;
    private int cGY;
    private int cMp;
    private int cMq;
    private int cMr;
    private int cMs;
    private boolean cMt;
    private String cMu;
    private int cMv = 1;
    private int cMw = 1;
    private int cMx;
    private be cMy;
    private int status;
    private int total_num;
    private String url;

    public int aAi() {
        return this.afX;
    }

    public int getStatus() {
        return this.status;
    }

    public int aAj() {
        return this.cMp;
    }

    public int aAk() {
        return this.cMq;
    }

    public String getUrl() {
        return this.url;
    }

    public int aAl() {
        return this.total_num;
    }

    public boolean aAm() {
        return this.cMt;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.afX = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.cMp = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.cMq = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.cGY = actInfo.activity_id.intValue();
            this.cMr = actInfo.award_act_id.intValue();
            this.cMs = actInfo.component_id.intValue();
            this.cMt = actInfo.is_senior.booleanValue();
            this.cMu = actInfo.banner_img;
            this.cMx = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMv = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMw = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.cMv <= 0) {
                this.cMv = 1;
            }
            if (this.cMw <= 0) {
                this.cMw = 1;
            }
            this.cMy = new be();
            this.cMy.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afX = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.cMp = jSONObject.optInt("begin_time");
                this.cMq = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.cGY = jSONObject.optInt("activity_id");
                this.cMr = jSONObject.optInt("award_act_id");
                this.cMs = jSONObject.optInt("component_id");
                this.cMt = jSONObject.optBoolean("is_senior");
                this.cMu = jSONObject.optString("banner_img");
                this.cMx = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cMv = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cMw = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.cMv <= 0) {
                    this.cMv = 1;
                }
                if (this.cMw <= 0) {
                    this.cMw = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
