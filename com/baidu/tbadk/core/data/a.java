package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int acW;
    private int acX;
    private int acY;
    private int acZ;
    private int activity_type;
    private int ada;
    private boolean adb;
    private String adc;
    private int ade = 1;
    private int adf = 1;
    private int adg;
    private ax adh;
    private int status;
    private int total_num;
    private String url;

    public int tA() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int tB() {
        return this.acW;
    }

    public int tC() {
        return this.acX;
    }

    public String getUrl() {
        return this.url;
    }

    public int tD() {
        return this.total_num;
    }

    public boolean tE() {
        return this.adb;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.acW = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.acX = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.acY = actInfo.activity_id.intValue();
            this.acZ = actInfo.award_act_id.intValue();
            this.ada = actInfo.component_id.intValue();
            this.adb = actInfo.is_senior.booleanValue();
            this.adc = actInfo.banner_img;
            this.adg = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(",");
                    this.ade = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adf = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.ade <= 0) {
                this.ade = 1;
            }
            if (this.adf <= 0) {
                this.adf = 1;
            }
            this.adh = new ax();
            this.adh.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.acW = jSONObject.optInt("begin_time");
                this.acX = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.acY = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.acZ = jSONObject.optInt("award_act_id");
                this.ada = jSONObject.optInt("component_id");
                this.adb = jSONObject.optBoolean("is_senior");
                this.adc = jSONObject.optString("banner_img");
                this.adg = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    this.ade = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.adf = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.ade <= 0) {
                    this.ade = 1;
                }
                if (this.adf <= 0) {
                    this.adf = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
