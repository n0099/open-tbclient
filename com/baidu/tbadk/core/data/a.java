package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int activity_type;
    private int akk;
    private int apn;
    private int apo;
    private int apq;
    private int apr;
    private boolean aps;
    private String apt;
    private int apu = 1;
    private int apv = 1;
    private int apw;
    private ax apx;
    private int status;
    private int total_num;
    private String url;

    public int yk() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int yl() {
        return this.apn;
    }

    public int ym() {
        return this.apo;
    }

    public String getUrl() {
        return this.url;
    }

    public int yn() {
        return this.total_num;
    }

    public boolean yo() {
        return this.aps;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.apn = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.apo = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.akk = actInfo.activity_id.intValue();
            this.apq = actInfo.award_act_id.intValue();
            this.apr = actInfo.component_id.intValue();
            this.aps = actInfo.is_senior.booleanValue();
            this.apt = actInfo.banner_img;
            this.apw = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.apu = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.apv = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.apu <= 0) {
                this.apu = 1;
            }
            if (this.apv <= 0) {
                this.apv = 1;
            }
            this.apx = new ax();
            this.apx.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.apn = jSONObject.optInt("begin_time");
                this.apo = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.akk = jSONObject.optInt("activity_id");
                this.apq = jSONObject.optInt("award_act_id");
                this.apr = jSONObject.optInt("component_id");
                this.aps = jSONObject.optBoolean("is_senior");
                this.apt = jSONObject.optString("banner_img");
                this.apw = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ao.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.apu = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.apv = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.apu <= 0) {
                    this.apu = 1;
                }
                if (this.apv <= 0) {
                    this.apv = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
