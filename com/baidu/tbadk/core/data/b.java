package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int activity_type;
    private int bqP;
    private int bvW;
    private int bvX;
    private int bvY;
    private int bvZ;
    private boolean bwa;
    private String bwb;
    private int bwc = 1;
    private int bwd = 1;
    private int bwe;
    private bb bwf;
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
        return this.bvW;
    }

    public int WX() {
        return this.bvX;
    }

    public String getUrl() {
        return this.url;
    }

    public int WY() {
        return this.total_num;
    }

    public boolean WZ() {
        return this.bwa;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.bvW = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.bvX = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.bqP = actInfo.activity_id.intValue();
            this.bvY = actInfo.award_act_id.intValue();
            this.bvZ = actInfo.component_id.intValue();
            this.bwa = actInfo.is_senior.booleanValue();
            this.bwb = actInfo.banner_img;
            this.bwe = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bwc = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.bwd = com.baidu.adp.lib.g.b.l(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.bwc <= 0) {
                this.bwc = 1;
            }
            if (this.bwd <= 0) {
                this.bwd = 1;
            }
            this.bwf = new bb();
            this.bwf.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.bvW = jSONObject.optInt("begin_time");
                this.bvX = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.bqP = jSONObject.optInt("activity_id");
                this.bvY = jSONObject.optInt("award_act_id");
                this.bvZ = jSONObject.optInt("component_id");
                this.bwa = jSONObject.optBoolean("is_senior");
                this.bwb = jSONObject.optString("banner_img");
                this.bwe = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.ap.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.bwc = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.bwd = com.baidu.adp.lib.g.b.l(split[1], 1);
                }
                if (this.bwc <= 0) {
                    this.bwc = 1;
                }
                if (this.bwd <= 0) {
                    this.bwd = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
