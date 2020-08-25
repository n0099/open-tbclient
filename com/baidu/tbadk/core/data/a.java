package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes2.dex */
public class a {
    private int aMZ;
    private int dNT;
    private int dVA;
    private int dVB;
    private int dVC;
    private boolean dVD;
    private String dVE;
    private int dVF = 1;
    private int dVG = 1;
    private int dVH;
    private br dVI;
    private int dVz;
    private int status;
    private int total_num;
    private String url;

    public int bcq() {
        return this.aMZ;
    }

    public int getStatus() {
        return this.status;
    }

    public int bcr() {
        return this.dVz;
    }

    public int bcs() {
        return this.dVA;
    }

    public String getUrl() {
        return this.url;
    }

    public int bct() {
        return this.total_num;
    }

    public boolean bcu() {
        return this.dVD;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aMZ = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.dVz = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.dVA = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.dNT = actInfo.activity_id.intValue();
            this.dVB = actInfo.award_act_id.intValue();
            this.dVC = actInfo.component_id.intValue();
            this.dVD = actInfo.is_senior.booleanValue();
            this.dVE = actInfo.banner_img;
            this.dVH = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dVF = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dVG = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.dVF <= 0) {
                this.dVF = 1;
            }
            if (this.dVG <= 0) {
                this.dVG = 1;
            }
            this.dVI = new br();
            this.dVI.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aMZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.dVz = jSONObject.optInt("begin_time");
                this.dVA = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.dNT = jSONObject.optInt("activity_id");
                this.dVB = jSONObject.optInt("award_act_id");
                this.dVC = jSONObject.optInt("component_id");
                this.dVD = jSONObject.optBoolean("is_senior");
                this.dVE = jSONObject.optString("banner_img");
                this.dVH = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.dVF = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.dVG = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.dVF <= 0) {
                    this.dVF = 1;
                }
                if (this.dVG <= 0) {
                    this.dVG = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
