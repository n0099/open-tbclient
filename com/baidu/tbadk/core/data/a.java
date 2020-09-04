package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aNb;
    private int dNX;
    private int dVD;
    private int dVE;
    private int dVF;
    private int dVG;
    private boolean dVH;
    private String dVI;
    private int dVJ = 1;
    private int dVK = 1;
    private int dVL;
    private br dVM;
    private int status;
    private int total_num;
    private String url;

    public int bcq() {
        return this.aNb;
    }

    public int getStatus() {
        return this.status;
    }

    public int bcr() {
        return this.dVD;
    }

    public int bcs() {
        return this.dVE;
    }

    public String getUrl() {
        return this.url;
    }

    public int bct() {
        return this.total_num;
    }

    public boolean bcu() {
        return this.dVH;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aNb = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dVD = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dVE = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dNX = actInfo.activity_id.intValue();
            this.dVF = actInfo.award_act_id.intValue();
            this.dVG = actInfo.component_id.intValue();
            this.dVH = actInfo.is_senior.booleanValue();
            this.dVI = actInfo.banner_img;
            this.dVL = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dVJ = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dVK = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dVJ <= 0) {
                this.dVJ = 1;
            }
            if (this.dVK <= 0) {
                this.dVK = 1;
            }
            this.dVM = new br();
            this.dVM.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aNb = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dVD = jSONObject.optInt("begin_time");
                this.dVE = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dNX = jSONObject.optInt("activity_id");
                this.dVF = jSONObject.optInt("award_act_id");
                this.dVG = jSONObject.optInt("component_id");
                this.dVH = jSONObject.optBoolean("is_senior");
                this.dVI = jSONObject.optString("banner_img");
                this.dVL = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dVJ = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dVK = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dVJ <= 0) {
                    this.dVJ = 1;
                }
                if (this.dVK <= 0) {
                    this.dVK = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
