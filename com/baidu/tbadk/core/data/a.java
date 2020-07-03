package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aGt;
    private int dGf;
    private int dGg;
    private int dGh;
    private int dGi;
    private boolean dGj;
    private String dGk;
    private int dGl = 1;
    private int dGm = 1;
    private int dGn;
    private bp dGo;
    private int dyP;
    private int status;
    private int total_num;
    private String url;

    public int aQd() {
        return this.aGt;
    }

    public int getStatus() {
        return this.status;
    }

    public int aQe() {
        return this.dGf;
    }

    public int aQf() {
        return this.dGg;
    }

    public String getUrl() {
        return this.url;
    }

    public int aQg() {
        return this.total_num;
    }

    public boolean aQh() {
        return this.dGj;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aGt = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dGf = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dGg = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dyP = actInfo.activity_id.intValue();
            this.dGh = actInfo.award_act_id.intValue();
            this.dGi = actInfo.component_id.intValue();
            this.dGj = actInfo.is_senior.booleanValue();
            this.dGk = actInfo.banner_img;
            this.dGn = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ar.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dGl = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dGm = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dGl <= 0) {
                this.dGl = 1;
            }
            if (this.dGm <= 0) {
                this.dGm = 1;
            }
            this.dGo = new bp();
            this.dGo.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aGt = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dGf = jSONObject.optInt("begin_time");
                this.dGg = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dyP = jSONObject.optInt("activity_id");
                this.dGh = jSONObject.optInt("award_act_id");
                this.dGi = jSONObject.optInt("component_id");
                this.dGj = jSONObject.optBoolean("is_senior");
                this.dGk = jSONObject.optString("banner_img");
                this.dGn = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ar.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dGl = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dGm = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dGl <= 0) {
                    this.dGl = 1;
                }
                if (this.dGm <= 0) {
                    this.dGm = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
