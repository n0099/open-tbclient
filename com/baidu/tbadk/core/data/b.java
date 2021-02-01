package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int aTj;
    private int aVH;
    private int eCt;
    private int eKG;
    private int eKH;
    private int eKI;
    private boolean eKJ;
    private String eKK;
    private int eKL = 1;
    private int eKM = 1;
    private int eKN;
    private bw eKO;
    private int status;
    private int total_num;
    private String url;

    public int bly() {
        return this.aVH;
    }

    public int getStatus() {
        return this.status;
    }

    public int blz() {
        return this.eKG;
    }

    public int blA() {
        return this.aTj;
    }

    public String getUrl() {
        return this.url;
    }

    public int blB() {
        return this.total_num;
    }

    public boolean blC() {
        return this.eKJ;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aVH = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eKG = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aTj = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.eCt = actInfo.activity_id.intValue();
            this.eKH = actInfo.award_act_id.intValue();
            this.eKI = actInfo.component_id.intValue();
            this.eKJ = actInfo.is_senior.booleanValue();
            this.eKK = actInfo.banner_img;
            this.eKN = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.eKL = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eKM = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.eKL <= 0) {
                this.eKL = 1;
            }
            if (this.eKM <= 0) {
                this.eKM = 1;
            }
            this.eKO = new bw();
            this.eKO.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aVH = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eKG = jSONObject.optInt("begin_time");
                this.aTj = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.eCt = jSONObject.optInt("activity_id");
                this.eKH = jSONObject.optInt("award_act_id");
                this.eKI = jSONObject.optInt("component_id");
                this.eKJ = jSONObject.optBoolean("is_senior");
                this.eKK = jSONObject.optString("banner_img");
                this.eKN = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.au.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.eKL = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eKM = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.eKL <= 0) {
                    this.eKL = 1;
                }
                if (this.eKM <= 0) {
                    this.eKM = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
