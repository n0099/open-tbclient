package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int activity_type;
    private int ali;
    private int alj;
    private int alk;
    private int alm;
    private int aln;
    private boolean alo;
    private String alp;
    private int alq = 1;
    private int alr = 1;
    private int als;
    private ax alt;
    private int status;
    private int total_num;
    private String url;

    public int wT() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int wU() {
        return this.ali;
    }

    public int wV() {
        return this.alj;
    }

    public String getUrl() {
        return this.url;
    }

    public int wW() {
        return this.total_num;
    }

    public boolean wX() {
        return this.alo;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.ali = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.alj = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.alk = actInfo.activity_id.intValue();
            this.alm = actInfo.award_act_id.intValue();
            this.aln = actInfo.component_id.intValue();
            this.alo = actInfo.is_senior.booleanValue();
            this.alp = actInfo.banner_img;
            this.als = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.alq = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.alr = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.alq <= 0) {
                this.alq = 1;
            }
            if (this.alr <= 0) {
                this.alr = 1;
            }
            this.alt = new ax();
            this.alt.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.ali = jSONObject.optInt("begin_time");
                this.alj = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.alk = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.alm = jSONObject.optInt("award_act_id");
                this.aln = jSONObject.optInt("component_id");
                this.alo = jSONObject.optBoolean("is_senior");
                this.alp = jSONObject.optString("banner_img");
                this.als = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ao.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.alq = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.alr = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.alq <= 0) {
                    this.alq = 1;
                }
                if (this.alr <= 0) {
                    this.alr = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
