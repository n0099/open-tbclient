package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bEo;
    private int bEp;
    private int bEq;
    private boolean bEr;
    private String bEs;
    private int bEt = 1;
    private int bEu = 1;
    private int bEv;
    private bb bEw;
    private int byb;
    private int end_time;
    private int status;
    private int total_num;
    private String url;

    public int acB() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int acC() {
        return this.bEo;
    }

    public int acD() {
        return this.end_time;
    }

    public String getUrl() {
        return this.url;
    }

    public int acE() {
        return this.total_num;
    }

    public boolean acF() {
        return this.bEr;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bEo = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.end_time = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.byb = actInfo.activity_id.intValue();
            this.bEp = actInfo.award_act_id.intValue();
            this.bEq = actInfo.component_id.intValue();
            this.bEr = actInfo.is_senior.booleanValue();
            this.bEs = actInfo.banner_img;
            this.bEv = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bEt = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bEu = com.baidu.adp.lib.g.b.f(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bEt <= 0) {
                this.bEt = 1;
            }
            if (this.bEu <= 0) {
                this.bEu = 1;
            }
            this.bEw = new bb();
            this.bEw.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bEo = jSONObject.optInt("begin_time");
                this.end_time = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.byb = jSONObject.optInt("activity_id");
                this.bEp = jSONObject.optInt("award_act_id");
                this.bEq = jSONObject.optInt("component_id");
                this.bEr = jSONObject.optBoolean("is_senior");
                this.bEs = jSONObject.optString("banner_img");
                this.bEv = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bEt = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bEu = com.baidu.adp.lib.g.b.f(split[1], 1);
                }
                if (this.bEt <= 0) {
                    this.bEt = 1;
                }
                if (this.bEu <= 0) {
                    this.bEu = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
