package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int TZ;
    private int Ua;
    private int Ub;
    private int status;
    private int total_num;
    private String url;

    public int rq() {
        return this.TZ;
    }

    public int getStatus() {
        return this.status;
    }

    public int rr() {
        return this.Ua;
    }

    public int rs() {
        return this.Ub;
    }

    public String getUrl() {
        return this.url;
    }

    public int rt() {
        return this.total_num;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.TZ = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Ua = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ub = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.TZ = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Ua = jSONObject.optInt("begin_time");
                this.Ub = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
