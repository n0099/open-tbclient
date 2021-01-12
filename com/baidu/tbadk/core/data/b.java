package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int aQg;
    private int aSC;
    private int eAn;
    private int eIA;
    private int eIB;
    private int eIC;
    private boolean eID;
    private String eIE;
    private int eIF = 1;
    private int eIG = 1;
    private int eIH;
    private bu eII;
    private int status;
    private int total_num;
    private String url;

    public int blg() {
        return this.aSC;
    }

    public int getStatus() {
        return this.status;
    }

    public int blh() {
        return this.eIA;
    }

    public int bli() {
        return this.aQg;
    }

    public String getUrl() {
        return this.url;
    }

    public int blj() {
        return this.total_num;
    }

    public boolean blk() {
        return this.eID;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aSC = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eIA = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aQg = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.eAn = actInfo.activity_id.intValue();
            this.eIB = actInfo.award_act_id.intValue();
            this.eIC = actInfo.component_id.intValue();
            this.eID = actInfo.is_senior.booleanValue();
            this.eIE = actInfo.banner_img;
            this.eIH = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.eIF = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eIG = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.eIF <= 0) {
                this.eIF = 1;
            }
            if (this.eIG <= 0) {
                this.eIG = 1;
            }
            this.eII = new bu();
            this.eII.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aSC = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eIA = jSONObject.optInt("begin_time");
                this.aQg = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.eAn = jSONObject.optInt("activity_id");
                this.eIB = jSONObject.optInt("award_act_id");
                this.eIC = jSONObject.optInt("component_id");
                this.eID = jSONObject.optBoolean("is_senior");
                this.eIE = jSONObject.optString("banner_img");
                this.eIH = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.eIF = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eIG = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.eIF <= 0) {
                    this.eIF = 1;
                }
                if (this.eIG <= 0) {
                    this.eIG = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
