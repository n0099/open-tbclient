package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int OF;
    private int OG;
    private int OH;
    private int OI;
    private int OJ;
    private int OL;
    private String OM;
    private int OO = 1;
    private int OP = 1;
    private int OQ;
    private bd OR;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pa() {
        return this.OF;
    }

    public int getStatus() {
        return this.status;
    }

    public int pb() {
        return this.OG;
    }

    public int pc() {
        return this.OH;
    }

    public String getUrl() {
        return this.url;
    }

    public int pd() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.OI;
    }

    public int pe() {
        return this.OJ;
    }

    public int pf() {
        return this.OL;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pg() {
        return this.OM;
    }

    public int ph() {
        return this.OQ;
    }

    public bd pi() {
        return this.OR;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.OF = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.OG = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.OH = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.OI = actInfo.activity_id.intValue();
            this.OJ = actInfo.award_act_id.intValue();
            this.OL = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.OM = actInfo.banner_img;
            this.OQ = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ax.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.OO = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.OP = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.OO <= 0) {
                this.OO = 1;
            }
            if (this.OP <= 0) {
                this.OP = 1;
            }
            this.OR = new bd();
            this.OR.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.OF = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.OG = jSONObject.optInt("begin_time");
                this.OH = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME);
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.OI = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.OJ = jSONObject.optInt("award_act_id");
                this.OL = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.OM = jSONObject.optString("banner_img");
                this.OQ = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ax.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.OO = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.OP = com.baidu.adp.lib.h.b.g(split[1], 1);
                }
                if (this.OO <= 0) {
                    this.OO = 1;
                }
                if (this.OP <= 0) {
                    this.OP = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
