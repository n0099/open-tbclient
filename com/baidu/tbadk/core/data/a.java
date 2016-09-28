package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int OC;
    private int OD;
    private int OE;
    private int OF;
    private int OG;
    private int OH;
    private String OI;
    private int OJ = 1;
    private int OL = 1;
    private int OM;
    private bb OO;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int oY() {
        return this.OC;
    }

    public int getStatus() {
        return this.status;
    }

    public int oZ() {
        return this.OD;
    }

    public int pa() {
        return this.OE;
    }

    public String getUrl() {
        return this.url;
    }

    public int pb() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.OF;
    }

    public int pc() {
        return this.OG;
    }

    public int pd() {
        return this.OH;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pe() {
        return this.OI;
    }

    public int pf() {
        return this.OM;
    }

    public bb pg() {
        return this.OO;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.OC = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.OD = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.OE = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.OF = actInfo.activity_id.intValue();
            this.OG = actInfo.award_act_id.intValue();
            this.OH = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.OI = actInfo.banner_img;
            this.OM = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.az.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.OJ = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.OL = com.baidu.adp.lib.h.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.OJ <= 0) {
                this.OJ = 1;
            }
            if (this.OL <= 0) {
                this.OL = 1;
            }
            this.OO = new bb();
            this.OO.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.OC = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.OD = jSONObject.optInt("begin_time");
                this.OE = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME);
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.OF = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.OG = jSONObject.optInt("award_act_id");
                this.OH = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.OI = jSONObject.optString("banner_img");
                this.OM = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.az.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.OJ = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.OL = com.baidu.adp.lib.h.b.g(split[1], 1);
                }
                if (this.OJ <= 0) {
                    this.OJ = 1;
                }
                if (this.OL <= 0) {
                    this.OL = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
