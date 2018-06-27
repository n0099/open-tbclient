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
    private int adA = 1;
    private int adB = 1;
    private int adC;
    private ay adD;
    private int adt;
    private int adu;
    private int adv;
    private int adw;
    private int adx;
    private boolean ady;
    private String adz;
    private int status;
    private int total_num;
    private String url;

    public int tO() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int tP() {
        return this.adt;
    }

    public int tQ() {
        return this.adu;
    }

    public String getUrl() {
        return this.url;
    }

    public int tR() {
        return this.total_num;
    }

    public boolean tS() {
        return this.ady;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.adt = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.adu = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.adv = actInfo.activity_id.intValue();
            this.adw = actInfo.award_act_id.intValue();
            this.adx = actInfo.component_id.intValue();
            this.ady = actInfo.is_senior.booleanValue();
            this.adz = actInfo.banner_img;
            this.adC = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.adA = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adB = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.adA <= 0) {
                this.adA = 1;
            }
            if (this.adB <= 0) {
                this.adB = 1;
            }
            this.adD = new ay();
            this.adD.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.adt = jSONObject.optInt("begin_time");
                this.adu = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.adv = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.adw = jSONObject.optInt("award_act_id");
                this.adx = jSONObject.optInt("component_id");
                this.ady = jSONObject.optBoolean("is_senior");
                this.adz = jSONObject.optString("banner_img");
                this.adC = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.adA = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adB = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.adA <= 0) {
                    this.adA = 1;
                }
                if (this.adB <= 0) {
                    this.adB = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
