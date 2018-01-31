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
    private int aIF;
    private int aIG;
    private int aIH;
    private int aII;
    private int aIJ;
    private String aIK;
    private int aIL = 1;
    private int aIM = 1;
    private int aIN;
    private ax aIO;
    private int activity_type;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int wR() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int wS() {
        return this.aIF;
    }

    public int wT() {
        return this.aIG;
    }

    public String getUrl() {
        return this.url;
    }

    public int wU() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.aIH;
    }

    public int wV() {
        return this.aII;
    }

    public int wW() {
        return this.aIJ;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public int wX() {
        return this.aIN;
    }

    public ax wY() {
        return this.aIO;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.aIF = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aIG = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.aIH = actInfo.activity_id.intValue();
            this.aII = actInfo.award_act_id.intValue();
            this.aIJ = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.aIK = actInfo.banner_img;
            this.aIN = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aIL = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aIM = com.baidu.adp.lib.g.b.h(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.aIL <= 0) {
                this.aIL = 1;
            }
            if (this.aIM <= 0) {
                this.aIM = 1;
            }
            this.aIO = new ax();
            this.aIO.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.aIF = jSONObject.optInt("begin_time");
                this.aIG = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.aIH = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.aII = jSONObject.optInt("award_act_id");
                this.aIJ = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.aIK = jSONObject.optString("banner_img");
                this.aIN = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aIL = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aIM = com.baidu.adp.lib.g.b.h(split[1], 1);
                }
                if (this.aIL <= 0) {
                    this.aIL = 1;
                }
                if (this.aIM <= 0) {
                    this.aIM = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
