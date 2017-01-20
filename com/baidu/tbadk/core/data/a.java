package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int NP;
    private int NQ;
    private int NR;
    private int NS;
    private int NT;
    private int NU;
    private String NV;
    private int NW = 1;
    private int NX = 1;
    private int NY;
    private ba NZ;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int oT() {
        return this.NP;
    }

    public int getStatus() {
        return this.status;
    }

    public int oU() {
        return this.NQ;
    }

    public int oV() {
        return this.NR;
    }

    public String getUrl() {
        return this.url;
    }

    public int oW() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.NS;
    }

    public int oX() {
        return this.NT;
    }

    public int oY() {
        return this.NU;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String oZ() {
        return this.NV;
    }

    public int pa() {
        return this.NY;
    }

    public ba pb() {
        return this.NZ;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.NP = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.NQ = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.NR = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.NS = actInfo.activity_id.intValue();
            this.NT = actInfo.award_act_id.intValue();
            this.NU = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.NV = actInfo.banner_img;
            this.NY = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.NW = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.NX = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.NW <= 0) {
                this.NW = 1;
            }
            if (this.NX <= 0) {
                this.NX = 1;
            }
            this.NZ = new ba();
            this.NZ.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.NP = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.NQ = jSONObject.optInt("begin_time");
                this.NR = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.NS = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.NT = jSONObject.optInt("award_act_id");
                this.NU = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.NV = jSONObject.optString("banner_img");
                this.NY = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.NW = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.NX = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.NW <= 0) {
                    this.NW = 1;
                }
                if (this.NX <= 0) {
                    this.NX = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
