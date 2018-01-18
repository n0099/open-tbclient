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
    private int aIC;
    private int aID;
    private int aIE;
    private int aIF;
    private int aIG;
    private String aIH;
    private int aII = 1;
    private int aIJ = 1;
    private int aIK;
    private ax aIL;
    private int activity_type;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int wQ() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int wR() {
        return this.aIC;
    }

    public int wS() {
        return this.aID;
    }

    public String getUrl() {
        return this.url;
    }

    public int wT() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.aIE;
    }

    public int wU() {
        return this.aIF;
    }

    public int wV() {
        return this.aIG;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public int wW() {
        return this.aIK;
    }

    public ax wX() {
        return this.aIL;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.aIC = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.aID = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.aIE = actInfo.activity_id.intValue();
            this.aIF = actInfo.award_act_id.intValue();
            this.aIG = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.aIH = actInfo.banner_img;
            this.aIK = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aII = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aIJ = com.baidu.adp.lib.g.b.h(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.aII <= 0) {
                this.aII = 1;
            }
            if (this.aIJ <= 0) {
                this.aIJ = 1;
            }
            this.aIL = new ax();
            this.aIL.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                this.aIC = jSONObject.optInt("begin_time");
                this.aID = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.aIE = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.aIF = jSONObject.optInt("award_act_id");
                this.aIG = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.aIH = jSONObject.optString("banner_img");
                this.aIK = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.aII = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.aIJ = com.baidu.adp.lib.g.b.h(split[1], 1);
                }
                if (this.aII <= 0) {
                    this.aII = 1;
                }
                if (this.aIJ <= 0) {
                    this.aIJ = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
