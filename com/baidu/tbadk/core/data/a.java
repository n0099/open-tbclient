package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private String TA;
    private int TB = 1;
    private int TC = 1;
    private int TD;
    private bb TE;
    private int Tu;
    private int Tv;
    private int Tw;
    private int Tx;
    private int Ty;
    private int Tz;
    private boolean mIsSenior;
    private int status;
    private int total_num;
    private String url;

    public int pk() {
        return this.Tu;
    }

    public int getStatus() {
        return this.status;
    }

    public int pl() {
        return this.Tv;
    }

    public int pm() {
        return this.Tw;
    }

    public String getUrl() {
        return this.url;
    }

    public int pn() {
        return this.total_num;
    }

    public int getActivityId() {
        return this.Tx;
    }

    public int po() {
        return this.Ty;
    }

    public int pp() {
        return this.Tz;
    }

    public boolean getIsSenior() {
        return this.mIsSenior;
    }

    public String pq() {
        return this.TA;
    }

    public int pr() {
        return this.TD;
    }

    public bb ps() {
        return this.TE;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Tu = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Tv = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Tw = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Tx = actInfo.activity_id.intValue();
            this.Ty = actInfo.award_act_id.intValue();
            this.Tz = actInfo.component_id.intValue();
            this.mIsSenior = actInfo.is_senior.booleanValue();
            this.TA = actInfo.banner_img;
            this.TD = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.TB = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.TC = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.TB <= 0) {
                this.TB = 1;
            }
            if (this.TC <= 0) {
                this.TC = 1;
            }
            this.TE = new bb();
            this.TE.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Tu = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Tv = jSONObject.optInt("begin_time");
                this.Tw = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Tx = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Ty = jSONObject.optInt("award_act_id");
                this.Tz = jSONObject.optInt("component_id");
                this.mIsSenior = jSONObject.optBoolean("is_senior");
                this.TA = jSONObject.optString("banner_img");
                this.TD = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.am.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.TB = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.TC = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.TB <= 0) {
                    this.TB = 1;
                }
                if (this.TC <= 0) {
                    this.TC = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
