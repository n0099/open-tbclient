package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int aUJ;
    private int aXh;
    private int eDU;
    private int eMh;
    private int eMi;
    private int eMj;
    private boolean eMk;
    private String eMl;
    private int eMm = 1;
    private int eMn = 1;
    private int eMo;
    private bw eMp;
    private int status;
    private int total_num;
    private String url;

    public int blA() {
        return this.aXh;
    }

    public int getStatus() {
        return this.status;
    }

    public int blB() {
        return this.eMh;
    }

    public int blC() {
        return this.aUJ;
    }

    public String getUrl() {
        return this.url;
    }

    public int blD() {
        return this.total_num;
    }

    public boolean blE() {
        return this.eMk;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aXh = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eMh = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aUJ = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.eDU = actInfo.activity_id.intValue();
            this.eMi = actInfo.award_act_id.intValue();
            this.eMj = actInfo.component_id.intValue();
            this.eMk = actInfo.is_senior.booleanValue();
            this.eMl = actInfo.banner_img;
            this.eMo = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.eMm = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eMn = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.eMm <= 0) {
                this.eMm = 1;
            }
            if (this.eMn <= 0) {
                this.eMn = 1;
            }
            this.eMp = new bw();
            this.eMp.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aXh = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eMh = jSONObject.optInt("begin_time");
                this.aUJ = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.eDU = jSONObject.optInt("activity_id");
                this.eMi = jSONObject.optInt("award_act_id");
                this.eMj = jSONObject.optInt("component_id");
                this.eMk = jSONObject.optBoolean("is_senior");
                this.eMl = jSONObject.optString("banner_img");
                this.eMo = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.eMm = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eMn = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.eMm <= 0) {
                    this.eMm = 1;
                }
                if (this.eMn <= 0) {
                    this.eMn = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
