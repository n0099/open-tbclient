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
    private int afA;
    private int afB;
    private int afC;
    private boolean afD;
    private String afE;
    private int afF = 1;
    private int afG = 1;
    private int afH;
    private ax afI;
    private int afy;
    private int afz;
    private int status;
    private int total_num;
    private String url;

    public int uC() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int uD() {
        return this.afy;
    }

    public int uE() {
        return this.afz;
    }

    public String getUrl() {
        return this.url;
    }

    public int uF() {
        return this.total_num;
    }

    public boolean uG() {
        return this.afD;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.afy = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.afz = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.afA = actInfo.activity_id.intValue();
            this.afB = actInfo.award_act_id.intValue();
            this.afC = actInfo.component_id.intValue();
            this.afD = actInfo.is_senior.booleanValue();
            this.afE = actInfo.banner_img;
            this.afH = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.afF = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.afG = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.afF <= 0) {
                this.afF = 1;
            }
            if (this.afG <= 0) {
                this.afG = 1;
            }
            this.afI = new ax();
            this.afI.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.afy = jSONObject.optInt("begin_time");
                this.afz = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.afA = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.afB = jSONObject.optInt("award_act_id");
                this.afC = jSONObject.optInt("component_id");
                this.afD = jSONObject.optBoolean("is_senior");
                this.afE = jSONObject.optString("banner_img");
                this.afH = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ao.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.afF = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.afG = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.afF <= 0) {
                    this.afF = 1;
                }
                if (this.afG <= 0) {
                    this.afG = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
