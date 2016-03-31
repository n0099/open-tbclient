package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int RA;
    private int RB;
    private int RC;
    private boolean RD;
    private String RE;
    private int RF = 1;
    private int RG = 1;
    private int RH;
    private al RI;
    private int Rx;
    private int Ry;
    private int Rz;
    private int status;
    private int total_num;
    private String url;

    public int qU() {
        return this.Rx;
    }

    public int getStatus() {
        return this.status;
    }

    public int qV() {
        return this.Ry;
    }

    public int qW() {
        return this.Rz;
    }

    public String getUrl() {
        return this.url;
    }

    public int qX() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.RA;
    }

    public int qY() {
        return this.RB;
    }

    public int qZ() {
        return this.RC;
    }

    public boolean ra() {
        return this.RD;
    }

    public String rb() {
        return this.RE;
    }

    public int rc() {
        return this.RH;
    }

    public al rd() {
        return this.RI;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Rx = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Ry = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Rz = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.RA = actInfo.activity_id.intValue();
            this.RB = actInfo.award_act_id.intValue();
            this.RC = actInfo.component_id.intValue();
            this.RD = actInfo.is_senior.booleanValue();
            this.RE = actInfo.banner_img;
            this.RH = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ay.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.RF = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.RG = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.RF <= 0) {
                this.RF = 1;
            }
            if (this.RG <= 0) {
                this.RG = 1;
            }
            this.RI = new al();
            this.RI.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Rx = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Ry = jSONObject.optInt("begin_time");
                this.Rz = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.RA = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.RB = jSONObject.optInt("award_act_id");
                this.RC = jSONObject.optInt("component_id");
                this.RD = jSONObject.optBoolean("is_senior");
                this.RE = jSONObject.optString("banner_img");
                this.RH = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ay.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.RF = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.RG = com.baidu.adp.lib.h.b.g(split[1], 1);
                }
                if (this.RF <= 0) {
                    this.RF = 1;
                }
                if (this.RG <= 0) {
                    this.RG = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
