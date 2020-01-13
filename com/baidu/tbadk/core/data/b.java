package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int adQ;
    private int cDa;
    private int cIm;
    private int cIn;
    private int cIo;
    private int cIp;
    private boolean cIq;
    private String cIr;
    private int cIs = 1;
    private int cIt = 1;
    private int cIu;
    private be cIv;
    private int status;
    private int total_num;
    private String url;

    public int axU() {
        return this.adQ;
    }

    public int getStatus() {
        return this.status;
    }

    public int axV() {
        return this.cIm;
    }

    public int axW() {
        return this.cIn;
    }

    public String getUrl() {
        return this.url;
    }

    public int axX() {
        return this.total_num;
    }

    public boolean axY() {
        return this.cIq;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.adQ = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.cIm = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.cIn = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.cDa = actInfo.activity_id.intValue();
            this.cIo = actInfo.award_act_id.intValue();
            this.cIp = actInfo.component_id.intValue();
            this.cIq = actInfo.is_senior.booleanValue();
            this.cIr = actInfo.banner_img;
            this.cIu = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cIs = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cIt = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.cIs <= 0) {
                this.cIs = 1;
            }
            if (this.cIt <= 0) {
                this.cIt = 1;
            }
            this.cIv = new be();
            this.cIv.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.adQ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.cIm = jSONObject.optInt("begin_time");
                this.cIn = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.cDa = jSONObject.optInt("activity_id");
                this.cIo = jSONObject.optInt("award_act_id");
                this.cIp = jSONObject.optInt("component_id");
                this.cIq = jSONObject.optBoolean("is_senior");
                this.cIr = jSONObject.optString("banner_img");
                this.cIu = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.cIs = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.cIt = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.cIs <= 0) {
                    this.cIs = 1;
                }
                if (this.cIt <= 0) {
                    this.cIt = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
