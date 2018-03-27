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
    private int aJN;
    private int aJO;
    private int aJP;
    private int aJQ;
    private int aJR;
    private boolean aJS;
    private String aJT;
    private int aJU = 1;
    private int aJV = 1;
    private int aJW;
    private ax aJX;
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
        return this.aJN;
    }

    public int xG() {
        return this.aJO;
    }

    public String getUrl() {
        return this.url;
    }

    public int xH() {
        return this.total_num;
    }

    public boolean xI() {
        return this.aJS;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.aJN = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aJO = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.aJP = actInfo.activity_id.intValue();
            this.aJQ = actInfo.award_act_id.intValue();
            this.aJR = actInfo.component_id.intValue();
            this.aJS = actInfo.is_senior.booleanValue();
            this.aJT = actInfo.banner_img;
            this.aJW = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aJU = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aJV = com.baidu.adp.lib.g.b.h(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.aJU <= 0) {
                this.aJU = 1;
            }
            if (this.aJV <= 0) {
                this.aJV = 1;
            }
            this.aJX = new ax();
            this.aJX.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.aJN = jSONObject.optInt("begin_time");
                this.aJO = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.aJP = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.aJQ = jSONObject.optInt("award_act_id");
                this.aJR = jSONObject.optInt("component_id");
                this.aJS = jSONObject.optBoolean("is_senior");
                this.aJT = jSONObject.optString("banner_img");
                this.aJW = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aJU = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aJV = com.baidu.adp.lib.g.b.h(split[1], 1);
                }
                if (this.aJU <= 0) {
                    this.aJU = 1;
                }
                if (this.aJV <= 0) {
                    this.aJV = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
