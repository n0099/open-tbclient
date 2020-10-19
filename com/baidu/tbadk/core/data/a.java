package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aSe;
    private int ecb;
    private int ejP;
    private int ejQ;
    private int ejR;
    private int ejS;
    private boolean ejT;
    private String ejU;
    private int ejV = 1;
    private int ejW = 1;
    private int ejX;
    private br ejY;
    private int status;
    private int total_num;
    private String url;

    public int bfT() {
        return this.aSe;
    }

    public int getStatus() {
        return this.status;
    }

    public int bfU() {
        return this.ejP;
    }

    public int bfV() {
        return this.ejQ;
    }

    public String getUrl() {
        return this.url;
    }

    public int bfW() {
        return this.total_num;
    }

    public boolean bfX() {
        return this.ejT;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aSe = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.ejP = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.ejQ = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.ecb = actInfo.activity_id.intValue();
            this.ejR = actInfo.award_act_id.intValue();
            this.ejS = actInfo.component_id.intValue();
            this.ejT = actInfo.is_senior.booleanValue();
            this.ejU = actInfo.banner_img;
            this.ejX = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.ejV = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.ejW = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.ejV <= 0) {
                this.ejV = 1;
            }
            if (this.ejW <= 0) {
                this.ejW = 1;
            }
            this.ejY = new br();
            this.ejY.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aSe = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.ejP = jSONObject.optInt("begin_time");
                this.ejQ = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.ecb = jSONObject.optInt("activity_id");
                this.ejR = jSONObject.optInt("award_act_id");
                this.ejS = jSONObject.optInt("component_id");
                this.ejT = jSONObject.optBoolean("is_senior");
                this.ejU = jSONObject.optString("banner_img");
                this.ejX = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.ejV = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.ejW = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.ejV <= 0) {
                    this.ejV = 1;
                }
                if (this.ejW <= 0) {
                    this.ejW = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
