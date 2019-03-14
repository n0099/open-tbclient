package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bqQ;
    private int bvY;
    private int bvZ;
    private int bwa;
    private int bwb;
    private boolean bwc;
    private String bwd;
    private int bwe = 1;
    private int bwf = 1;
    private int bwg;
    private bb bwh;
    private int status;
    private int total_num;
    private String url;

    public int WV() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int WW() {
        return this.bvY;
    }

    public int WX() {
        return this.bvZ;
    }

    public String getUrl() {
        return this.url;
    }

    public int WY() {
        return this.total_num;
    }

    public boolean WZ() {
        return this.bwc;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bvY = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.bvZ = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.bqQ = actInfo.activity_id.intValue();
            this.bwa = actInfo.award_act_id.intValue();
            this.bwb = actInfo.component_id.intValue();
            this.bwc = actInfo.is_senior.booleanValue();
            this.bwd = actInfo.banner_img;
            this.bwg = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bwe = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.bwf = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bwe <= 0) {
                this.bwe = 1;
            }
            if (this.bwf <= 0) {
                this.bwf = 1;
            }
            this.bwh = new bb();
            this.bwh.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bvY = jSONObject.optInt("begin_time");
                this.bvZ = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.bqQ = jSONObject.optInt("activity_id");
                this.bwa = jSONObject.optInt("award_act_id");
                this.bwb = jSONObject.optInt("component_id");
                this.bwc = jSONObject.optBoolean("is_senior");
                this.bwd = jSONObject.optString("banner_img");
                this.bwg = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bwe = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.bwf = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.bwe <= 0) {
                    this.bwe = 1;
                }
                if (this.bwf <= 0) {
                    this.bwf = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
