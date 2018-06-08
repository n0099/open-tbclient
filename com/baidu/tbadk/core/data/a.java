package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int activity_type;
    private int ade;
    private int adf;
    private int adg;
    private int adh;
    private int adi;
    private boolean adj;
    private String adk;
    private int adl = 1;
    private int adm = 1;
    private int adn;
    private ay ado;
    private int status;
    private int total_num;
    private String url;

    public int tI() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int tJ() {
        return this.ade;
    }

    public int tK() {
        return this.adf;
    }

    public String getUrl() {
        return this.url;
    }

    public int tL() {
        return this.total_num;
    }

    public boolean tM() {
        return this.adj;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.ade = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.adf = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.adg = actInfo.activity_id.intValue();
            this.adh = actInfo.award_act_id.intValue();
            this.adi = actInfo.component_id.intValue();
            this.adj = actInfo.is_senior.booleanValue();
            this.adk = actInfo.banner_img;
            this.adn = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.adl = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adm = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.adl <= 0) {
                this.adl = 1;
            }
            if (this.adm <= 0) {
                this.adm = 1;
            }
            this.ado = new ay();
            this.ado.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.ade = jSONObject.optInt("begin_time");
                this.adf = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.adg = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.adh = jSONObject.optInt("award_act_id");
                this.adi = jSONObject.optInt("component_id");
                this.adj = jSONObject.optBoolean("is_senior");
                this.adk = jSONObject.optString("banner_img");
                this.adn = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ao.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.adl = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adm = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.adl <= 0) {
                    this.adl = 1;
                }
                if (this.adm <= 0) {
                    this.adm = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
