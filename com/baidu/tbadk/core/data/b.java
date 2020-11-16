package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int aQS;
    private int aSH;
    private int eoK;
    private boolean ewA;
    private String ewB;
    private int ewC = 1;
    private int ewD = 1;
    private int ewE;
    private bs ewF;
    private int ewx;
    private int ewy;
    private int ewz;
    private int status;
    private int total_num;
    private String url;

    public int bjo() {
        return this.aSH;
    }

    public int getStatus() {
        return this.status;
    }

    public int bjp() {
        return this.ewx;
    }

    public int bjq() {
        return this.aQS;
    }

    public String getUrl() {
        return this.url;
    }

    public int bjr() {
        return this.total_num;
    }

    public boolean bjs() {
        return this.ewA;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aSH = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.ewx = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aQS = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.eoK = actInfo.activity_id.intValue();
            this.ewy = actInfo.award_act_id.intValue();
            this.ewz = actInfo.component_id.intValue();
            this.ewA = actInfo.is_senior.booleanValue();
            this.ewB = actInfo.banner_img;
            this.ewE = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.ewC = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.ewD = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.ewC <= 0) {
                this.ewC = 1;
            }
            if (this.ewD <= 0) {
                this.ewD = 1;
            }
            this.ewF = new bs();
            this.ewF.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aSH = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.ewx = jSONObject.optInt("begin_time");
                this.aQS = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.eoK = jSONObject.optInt("activity_id");
                this.ewy = jSONObject.optInt("award_act_id");
                this.ewz = jSONObject.optInt("component_id");
                this.ewA = jSONObject.optBoolean("is_senior");
                this.ewB = jSONObject.optString("banner_img");
                this.ewE = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.ewC = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.ewD = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.ewC <= 0) {
                    this.ewC = 1;
                }
                if (this.ewD <= 0) {
                    this.ewD = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
