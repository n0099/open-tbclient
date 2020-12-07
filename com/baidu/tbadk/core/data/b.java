package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int aTU;
    private int aVJ;
    private int eDA;
    private boolean eDB;
    private String eDC;
    private int eDD = 1;
    private int eDE = 1;
    private int eDF;
    private bt eDG;
    private int eDy;
    private int eDz;
    private int evJ;
    private int status;
    private int total_num;
    private String url;

    public int bmy() {
        return this.aVJ;
    }

    public int getStatus() {
        return this.status;
    }

    public int bmz() {
        return this.eDy;
    }

    public int bmA() {
        return this.aTU;
    }

    public String getUrl() {
        return this.url;
    }

    public int bmB() {
        return this.total_num;
    }

    public boolean bmC() {
        return this.eDB;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aVJ = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eDy = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aTU = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.evJ = actInfo.activity_id.intValue();
            this.eDz = actInfo.award_act_id.intValue();
            this.eDA = actInfo.component_id.intValue();
            this.eDB = actInfo.is_senior.booleanValue();
            this.eDC = actInfo.banner_img;
            this.eDF = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.eDD = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eDE = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.eDD <= 0) {
                this.eDD = 1;
            }
            if (this.eDE <= 0) {
                this.eDE = 1;
            }
            this.eDG = new bt();
            this.eDG.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aVJ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eDy = jSONObject.optInt("begin_time");
                this.aTU = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.evJ = jSONObject.optInt("activity_id");
                this.eDz = jSONObject.optInt("award_act_id");
                this.eDA = jSONObject.optInt("component_id");
                this.eDB = jSONObject.optBoolean("is_senior");
                this.eDC = jSONObject.optString("banner_img");
                this.eDF = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.eDD = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eDE = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.eDD <= 0) {
                    this.eDD = 1;
                }
                if (this.eDE <= 0) {
                    this.eDE = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
