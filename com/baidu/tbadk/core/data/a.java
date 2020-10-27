package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aSZ;
    private int ekx;
    private int eso;
    private int esp;
    private int esq;
    private int esr;
    private boolean ess;
    private String est;
    private int esu = 1;
    private int esv = 1;
    private int esw;
    private br esx;
    private int status;
    private int total_num;
    private String url;

    public int bhM() {
        return this.aSZ;
    }

    public int getStatus() {
        return this.status;
    }

    public int bhN() {
        return this.eso;
    }

    public int bhO() {
        return this.esp;
    }

    public String getUrl() {
        return this.url;
    }

    public int bhP() {
        return this.total_num;
    }

    public boolean bhQ() {
        return this.ess;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.aSZ = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.eso = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.esp = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.ekx = actInfo.activity_id.intValue();
            this.esq = actInfo.award_act_id.intValue();
            this.esr = actInfo.component_id.intValue();
            this.ess = actInfo.is_senior.booleanValue();
            this.est = actInfo.banner_img;
            this.esw = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.esu = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.esv = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.esu <= 0) {
                this.esu = 1;
            }
            if (this.esv <= 0) {
                this.esv = 1;
            }
            this.esx = new br();
            this.esx.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aSZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.eso = jSONObject.optInt("begin_time");
                this.esp = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.ekx = jSONObject.optInt("activity_id");
                this.esq = jSONObject.optInt("award_act_id");
                this.esr = jSONObject.optInt("component_id");
                this.ess = jSONObject.optBoolean("is_senior");
                this.est = jSONObject.optString("banner_img");
                this.esw = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.at.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.esu = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.esv = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                }
                if (this.esu <= 0) {
                    this.esu = 1;
                }
                if (this.esv <= 0) {
                    this.esv = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
