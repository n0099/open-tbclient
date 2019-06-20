package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bDo;
    private int bDp;
    private int bDq;
    private int bDr;
    private boolean bDs;
    private String bDt;
    private int bDu = 1;
    private int bDv = 1;
    private int bDw;
    private bb bDx;
    private int bxk;
    private int status;
    private int total_num;
    private String url;

    public int abz() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int abA() {
        return this.bDo;
    }

    public int abB() {
        return this.bDp;
    }

    public String getUrl() {
        return this.url;
    }

    public int abC() {
        return this.total_num;
    }

    public boolean abD() {
        return this.bDs;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bDo = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.bDp = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.bxk = actInfo.activity_id.intValue();
            this.bDq = actInfo.award_act_id.intValue();
            this.bDr = actInfo.component_id.intValue();
            this.bDs = actInfo.is_senior.booleanValue();
            this.bDt = actInfo.banner_img;
            this.bDw = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bDu = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bDv = com.baidu.adp.lib.g.b.f(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bDu <= 0) {
                this.bDu = 1;
            }
            if (this.bDv <= 0) {
                this.bDv = 1;
            }
            this.bDx = new bb();
            this.bDx.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bDo = jSONObject.optInt("begin_time");
                this.bDp = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.bxk = jSONObject.optInt("activity_id");
                this.bDq = jSONObject.optInt("award_act_id");
                this.bDr = jSONObject.optInt("component_id");
                this.bDs = jSONObject.optBoolean("is_senior");
                this.bDt = jSONObject.optString("banner_img");
                this.bDw = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bDu = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.bDv = com.baidu.adp.lib.g.b.f(split[1], 1);
                }
                if (this.bDu <= 0) {
                    this.bDu = 1;
                }
                if (this.bDv <= 0) {
                    this.bDv = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
