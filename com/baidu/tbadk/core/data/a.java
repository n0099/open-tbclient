package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int activity_type;
    private boolean akA;
    private String akB;
    private int akC = 1;
    private int akD = 1;
    private int akE;
    private ax akF;
    private int akv;
    private int akw;
    private int akx;
    private int aky;
    private int akz;
    private int status;
    private int total_num;
    private String url;

    public int wL() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int wM() {
        return this.akv;
    }

    public int wN() {
        return this.akw;
    }

    public String getUrl() {
        return this.url;
    }

    public int wO() {
        return this.total_num;
    }

    public boolean wP() {
        return this.akA;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.akv = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.akw = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.akx = actInfo.activity_id.intValue();
            this.aky = actInfo.award_act_id.intValue();
            this.akz = actInfo.component_id.intValue();
            this.akA = actInfo.is_senior.booleanValue();
            this.akB = actInfo.banner_img;
            this.akE = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.akC = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.akD = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.akC <= 0) {
                this.akC = 1;
            }
            if (this.akD <= 0) {
                this.akD = 1;
            }
            this.akF = new ax();
            this.akF.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.akv = jSONObject.optInt("begin_time");
                this.akw = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.akx = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.aky = jSONObject.optInt("award_act_id");
                this.akz = jSONObject.optInt("component_id");
                this.akA = jSONObject.optBoolean("is_senior");
                this.akB = jSONObject.optString("banner_img");
                this.akE = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ao.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.akC = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.akD = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.akC <= 0) {
                    this.akC = 1;
                }
                if (this.akD <= 0) {
                    this.akD = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
