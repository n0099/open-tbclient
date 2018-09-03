package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int acX;
    private int acY;
    private int acZ;
    private int activity_type;
    private int ada;
    private int adb;
    private boolean adc;
    private String ade;
    private int adf = 1;
    private int adg = 1;
    private int adh;
    private ax adi;
    private int status;
    private int total_num;
    private String url;

    public int tz() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int tA() {
        return this.acX;
    }

    public int tB() {
        return this.acY;
    }

    public String getUrl() {
        return this.url;
    }

    public int tC() {
        return this.total_num;
    }

    public boolean tD() {
        return this.adc;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.acX = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.acY = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.acZ = actInfo.activity_id.intValue();
            this.ada = actInfo.award_act_id.intValue();
            this.adb = actInfo.component_id.intValue();
            this.adc = actInfo.is_senior.booleanValue();
            this.ade = actInfo.banner_img;
            this.adh = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.adf = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adg = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.adf <= 0) {
                this.adf = 1;
            }
            if (this.adg <= 0) {
                this.adg = 1;
            }
            this.adi = new ax();
            this.adi.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.acX = jSONObject.optInt("begin_time");
                this.acY = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.acZ = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.ada = jSONObject.optInt("award_act_id");
                this.adb = jSONObject.optInt("component_id");
                this.adc = jSONObject.optBoolean("is_senior");
                this.ade = jSONObject.optString("banner_img");
                this.adh = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.adf = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adg = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.adf <= 0) {
                    this.adf = 1;
                }
                if (this.adg <= 0) {
                    this.adg = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
