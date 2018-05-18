package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Ve;
    private int Vf;
    private int Vg;
    private int Vh;
    private int Vi;
    private boolean Vj;
    private String Vk;
    private int Vl = 1;
    private int Vm = 1;
    private int Vn;
    private ay Vo;
    private int activity_type;
    private int status;
    private int total_num;
    private String url;

    public int qm() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int qn() {
        return this.Ve;
    }

    public int qo() {
        return this.Vf;
    }

    public String getUrl() {
        return this.url;
    }

    public int qp() {
        return this.total_num;
    }

    public boolean qq() {
        return this.Vj;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Ve = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Vf = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Vg = actInfo.activity_id.intValue();
            this.Vh = actInfo.award_act_id.intValue();
            this.Vi = actInfo.component_id.intValue();
            this.Vj = actInfo.is_senior.booleanValue();
            this.Vk = actInfo.banner_img;
            this.Vn = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.an.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Vl = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Vm = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Vl <= 0) {
                this.Vl = 1;
            }
            if (this.Vm <= 0) {
                this.Vm = 1;
            }
            this.Vo = new ay();
            this.Vo.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Ve = jSONObject.optInt("begin_time");
                this.Vf = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Vg = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Vh = jSONObject.optInt("award_act_id");
                this.Vi = jSONObject.optInt("component_id");
                this.Vj = jSONObject.optBoolean("is_senior");
                this.Vk = jSONObject.optString("banner_img");
                this.Vn = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.an.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Vl = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Vm = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Vl <= 0) {
                    this.Vl = 1;
                }
                if (this.Vm <= 0) {
                    this.Vm = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
