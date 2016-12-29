package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int OB;
    private int OC;
    private int OD;
    private int OE;
    private int OF;
    private int OG;
    private String OH;
    private int OI = 1;
    private int OJ = 1;
    private int OL;
    private az OM;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pa() {
        return this.OB;
    }

    public int getStatus() {
        return this.status;
    }

    public int pb() {
        return this.OC;
    }

    public int pc() {
        return this.OD;
    }

    public String getUrl() {
        return this.url;
    }

    public int pd() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.OE;
    }

    public int pe() {
        return this.OF;
    }

    public int pf() {
        return this.OG;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pg() {
        return this.OH;
    }

    public int ph() {
        return this.OL;
    }

    public az pi() {
        return this.OM;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.OB = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.OC = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.OD = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.OE = actInfo.activity_id.intValue();
            this.OF = actInfo.award_act_id.intValue();
            this.OG = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.OH = actInfo.banner_img;
            this.OL = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.av.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.OI = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.OJ = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.OI <= 0) {
                this.OI = 1;
            }
            if (this.OJ <= 0) {
                this.OJ = 1;
            }
            this.OM = new az();
            this.OM.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.OB = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.OC = jSONObject.optInt("begin_time");
                this.OD = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.OE = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.OF = jSONObject.optInt("award_act_id");
                this.OG = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.OH = jSONObject.optString("banner_img");
                this.OL = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.av.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.OI = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.OJ = com.baidu.adp.lib.h.b.g(split[1], 1);
                }
                if (this.OI <= 0) {
                    this.OI = 1;
                }
                if (this.OJ <= 0) {
                    this.OJ = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
