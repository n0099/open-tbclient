package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int aUT;
    private int aXp;
    private int eEZ;
    private int eNl;
    private int eNm;
    private int eNn;
    private boolean eNo;
    private String eNp;
    private int eNq = 1;
    private int eNr = 1;
    private int eNs;
    private bu eNt;
    private int status;
    private int total_num;
    private String url;

    public int bpa() {
        return this.aXp;
    }

    public int getStatus() {
        return this.status;
    }

    public int bpb() {
        return this.eNl;
    }

    public int bpc() {
        return this.aUT;
    }

    public String getUrl() {
        return this.url;
    }

    public int bpd() {
        return this.total_num;
    }

    public boolean bpe() {
        return this.eNo;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aXp = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eNl = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aUT = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.eEZ = actInfo.activity_id.intValue();
            this.eNm = actInfo.award_act_id.intValue();
            this.eNn = actInfo.component_id.intValue();
            this.eNo = actInfo.is_senior.booleanValue();
            this.eNp = actInfo.banner_img;
            this.eNs = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.eNq = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eNr = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.eNq <= 0) {
                this.eNq = 1;
            }
            if (this.eNr <= 0) {
                this.eNr = 1;
            }
            this.eNt = new bu();
            this.eNt.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aXp = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eNl = jSONObject.optInt("begin_time");
                this.aUT = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.eEZ = jSONObject.optInt("activity_id");
                this.eNm = jSONObject.optInt("award_act_id");
                this.eNn = jSONObject.optInt("component_id");
                this.eNo = jSONObject.optBoolean("is_senior");
                this.eNp = jSONObject.optString("banner_img");
                this.eNs = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.eNq = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.eNr = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.eNq <= 0) {
                    this.eNq = 1;
                }
                if (this.eNr <= 0) {
                    this.eNr = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
