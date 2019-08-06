package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bEp;
    private int bEq;
    private int bEr;
    private boolean bEs;
    private String bEt;
    private int bEu = 1;
    private int bEv = 1;
    private int bEw;
    private bc bEx;
    private int byb;
    private int end_time;
    private int status;
    private int total_num;
    private String url;

    public int acC() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int acD() {
        return this.bEp;
    }

    public int acE() {
        return this.end_time;
    }

    public String getUrl() {
        return this.url;
    }

    public int acF() {
        return this.total_num;
    }

    public boolean acG() {
        return this.bEs;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bEp = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.end_time = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.byb = actInfo.activity_id.intValue();
            this.bEq = actInfo.award_act_id.intValue();
            this.bEr = actInfo.component_id.intValue();
            this.bEs = actInfo.is_senior.booleanValue();
            this.bEt = actInfo.banner_img;
            this.bEw = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bEu = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bEv = com.baidu.adp.lib.g.b.f(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bEu <= 0) {
                this.bEu = 1;
            }
            if (this.bEv <= 0) {
                this.bEv = 1;
            }
            this.bEx = new bc();
            this.bEx.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bEp = jSONObject.optInt("begin_time");
                this.end_time = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.byb = jSONObject.optInt("activity_id");
                this.bEq = jSONObject.optInt("award_act_id");
                this.bEr = jSONObject.optInt("component_id");
                this.bEs = jSONObject.optBoolean("is_senior");
                this.bEt = jSONObject.optString("banner_img");
                this.bEw = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bEu = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bEv = com.baidu.adp.lib.g.b.f(split[1], 1);
                }
                if (this.bEu <= 0) {
                    this.bEu = 1;
                }
                if (this.bEv <= 0) {
                    this.bEv = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
