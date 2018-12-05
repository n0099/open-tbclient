package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int activity_type;
    private int akb;
    private int aoK;
    private int aoL;
    private int aoM;
    private int aoN;
    private boolean aoO;
    private String aoP;
    private int aoQ = 1;
    private int aoR = 1;
    private int aoS;
    private ax aoT;
    private int status;
    private int total_num;
    private String url;

    public int xX() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int xY() {
        return this.aoK;
    }

    public int xZ() {
        return this.aoL;
    }

    public String getUrl() {
        return this.url;
    }

    public int ya() {
        return this.total_num;
    }

    public boolean yb() {
        return this.aoO;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.aoK = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aoL = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.akb = actInfo.activity_id.intValue();
            this.aoM = actInfo.award_act_id.intValue();
            this.aoN = actInfo.component_id.intValue();
            this.aoO = actInfo.is_senior.booleanValue();
            this.aoP = actInfo.banner_img;
            this.aoS = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.aoQ = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.aoR = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.aoQ <= 0) {
                this.aoQ = 1;
            }
            if (this.aoR <= 0) {
                this.aoR = 1;
            }
            this.aoT = new ax();
            this.aoT.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.aoK = jSONObject.optInt("begin_time");
                this.aoL = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.akb = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.aoM = jSONObject.optInt("award_act_id");
                this.aoN = jSONObject.optInt("component_id");
                this.aoO = jSONObject.optBoolean("is_senior");
                this.aoP = jSONObject.optString("banner_img");
                this.aoS = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ao.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.aoQ = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.aoR = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.aoQ <= 0) {
                    this.aoQ = 1;
                }
                if (this.aoR <= 0) {
                    this.aoR = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
