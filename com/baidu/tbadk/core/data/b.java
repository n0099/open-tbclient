package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int VZ;
    private int bQo;
    private int bVN;
    private int bVO;
    private int bVP;
    private int bVQ;
    private boolean bVR;
    private String bVS;
    private int bVT = 1;
    private int bVU = 1;
    private int bVV;
    private bc bVW;
    private int status;
    private int total_num;
    private String url;

    public int agK() {
        return this.VZ;
    }

    public int getStatus() {
        return this.status;
    }

    public int agL() {
        return this.bVN;
    }

    public int agM() {
        return this.bVO;
    }

    public String getUrl() {
        return this.url;
    }

    public int agN() {
        return this.total_num;
    }

    public boolean agO() {
        return this.bVR;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.VZ = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bVN = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.bVO = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.bQo = actInfo.activity_id.intValue();
            this.bVP = actInfo.award_act_id.intValue();
            this.bVQ = actInfo.component_id.intValue();
            this.bVR = actInfo.is_senior.booleanValue();
            this.bVS = actInfo.banner_img;
            this.bVV = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bVT = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    this.bVU = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bVT <= 0) {
                this.bVT = 1;
            }
            if (this.bVU <= 0) {
                this.bVU = 1;
            }
            this.bVW = new bc();
            this.bVW.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bVN = jSONObject.optInt("begin_time");
                this.bVO = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.bQo = jSONObject.optInt("activity_id");
                this.bVP = jSONObject.optInt("award_act_id");
                this.bVQ = jSONObject.optInt("component_id");
                this.bVR = jSONObject.optBoolean("is_senior");
                this.bVS = jSONObject.optString("banner_img");
                this.bVV = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.aq.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bVT = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    this.bVU = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                }
                if (this.bVT <= 0) {
                    this.bVT = 1;
                }
                if (this.bVU <= 0) {
                    this.bVU = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
