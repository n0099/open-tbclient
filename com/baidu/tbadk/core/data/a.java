package com.baidu.tbadk.core.data;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int aJX;
    private int aJY;
    private int aJZ;
    private int aKa;
    private int aKb;
    private boolean aKc;
    private String aKd;
    private int aKe = 1;
    private int aKf = 1;
    private int aKg;
    private ax aKh;
    private int activity_type;
    private int status;
    private int total_num;
    private String url;

    public int xE() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int xF() {
        return this.aJX;
    }

    public int xG() {
        return this.aJY;
    }

    public String getUrl() {
        return this.url;
    }

    public int xH() {
        return this.total_num;
    }

    public boolean xI() {
        return this.aKc;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.aJX = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aJY = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.aJZ = actInfo.activity_id.intValue();
            this.aKa = actInfo.award_act_id.intValue();
            this.aKb = actInfo.component_id.intValue();
            this.aKc = actInfo.is_senior.booleanValue();
            this.aKd = actInfo.banner_img;
            this.aKg = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aKe = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aKf = com.baidu.adp.lib.g.b.h(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.aKe <= 0) {
                this.aKe = 1;
            }
            if (this.aKf <= 0) {
                this.aKf = 1;
            }
            this.aKh = new ax();
            this.aKh.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.aJX = jSONObject.optInt("begin_time");
                this.aJY = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.aJZ = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.aKa = jSONObject.optInt("award_act_id");
                this.aKb = jSONObject.optInt("component_id");
                this.aKc = jSONObject.optBoolean("is_senior");
                this.aKd = jSONObject.optString("banner_img");
                this.aKg = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aKe = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aKf = com.baidu.adp.lib.g.b.h(split[1], 1);
                }
                if (this.aKe <= 0) {
                    this.aKe = 1;
                }
                if (this.aKf <= 0) {
                    this.aKf = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
