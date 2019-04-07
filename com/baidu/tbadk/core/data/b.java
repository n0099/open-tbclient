package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bqT;
    private int bwb;
    private int bwc;
    private int bwd;
    private int bwe;
    private boolean bwf;
    private String bwg;
    private int bwh = 1;
    private int bwi = 1;
    private int bwj;
    private bb bwk;
    private int status;
    private int total_num;
    private String url;

    public int WS() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int WT() {
        return this.bwb;
    }

    public int WU() {
        return this.bwc;
    }

    public String getUrl() {
        return this.url;
    }

    public int WV() {
        return this.total_num;
    }

    public boolean WW() {
        return this.bwf;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bwb = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.bwc = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.bqT = actInfo.activity_id.intValue();
            this.bwd = actInfo.award_act_id.intValue();
            this.bwe = actInfo.component_id.intValue();
            this.bwf = actInfo.is_senior.booleanValue();
            this.bwg = actInfo.banner_img;
            this.bwj = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bwh = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.bwi = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bwh <= 0) {
                this.bwh = 1;
            }
            if (this.bwi <= 0) {
                this.bwi = 1;
            }
            this.bwk = new bb();
            this.bwk.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bwb = jSONObject.optInt("begin_time");
                this.bwc = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.bqT = jSONObject.optInt("activity_id");
                this.bwd = jSONObject.optInt("award_act_id");
                this.bwe = jSONObject.optInt("component_id");
                this.bwf = jSONObject.optBoolean("is_senior");
                this.bwg = jSONObject.optString("banner_img");
                this.bwj = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bwh = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.bwi = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.bwh <= 0) {
                    this.bwh = 1;
                }
                if (this.bwi <= 0) {
                    this.bwi = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
