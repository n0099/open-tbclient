package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int TY;
    private int TZ;
    private int Ua;
    private int status;
    private int total_num;
    private String url;

    public int rr() {
        return this.TY;
    }

    public int getStatus() {
        return this.status;
    }

    public int rs() {
        return this.TZ;
    }

    public int rt() {
        return this.Ua;
    }

    public String getUrl() {
        return this.url;
    }

    public int ru() {
        return this.total_num;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.TY = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.TZ = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Ua = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.TY = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.TZ = jSONObject.optInt("begin_time");
                this.Ua = jSONObject.optInt("end_time");
                this.url = jSONObject.optString("url");
                this.total_num = jSONObject.optInt("total_num");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
