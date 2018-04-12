package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class a {
    private int Vi;
    private int Vj;
    private int Vk;
    private int Vl;
    private int Vm;
    private boolean Vn;
    private String Vo;
    private int Vp = 1;
    private int Vq = 1;
    private int Vr;
    private ay Vs;
    private int activity_type;
    private int status;
    private int total_num;
    private String url;

    public int qn() {
        return this.activity_type;
    }

    public int getStatus() {
        return this.status;
    }

    public int qo() {
        return this.Vi;
    }

    public int qp() {
        return this.Vj;
    }

    public String getUrl() {
        return this.url;
    }

    public int qq() {
        return this.total_num;
    }

    public boolean qr() {
        return this.Vn;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.activity_type = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Vi = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Vj = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
            this.Vk = actInfo.activity_id.intValue();
            this.Vl = actInfo.award_act_id.intValue();
            this.Vm = actInfo.component_id.intValue();
            this.Vn = actInfo.is_senior.booleanValue();
            this.Vo = actInfo.banner_img;
            this.Vr = actInfo.show_total_num.intValue();
            String str = actInfo.banner_img_size;
            if (!com.baidu.tbadk.core.util.an.isEmpty(str)) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Vp = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Vq = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.Vp <= 0) {
                this.Vp = 1;
            }
            if (this.Vq <= 0) {
                this.Vq = 1;
            }
            this.Vs = new ay();
            this.Vs.a(actInfo.lottery_senior);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.activity_type = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.status = jSONObject.optInt("status");
                this.Vi = jSONObject.optInt("begin_time");
                this.Vj = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
                this.Vk = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
                this.Vl = jSONObject.optInt("award_act_id");
                this.Vm = jSONObject.optInt("component_id");
                this.Vn = jSONObject.optBoolean("is_senior");
                this.Vo = jSONObject.optString("banner_img");
                this.Vr = jSONObject.optInt("show_total_num");
                String optString = jSONObject.optString("banner_img_size");
                if (!com.baidu.tbadk.core.util.an.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.Vp = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.Vq = com.baidu.adp.lib.g.b.g(split[1], 1);
                }
                if (this.Vp <= 0) {
                    this.Vp = 1;
                }
                if (this.Vq <= 0) {
                    this.Vq = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
