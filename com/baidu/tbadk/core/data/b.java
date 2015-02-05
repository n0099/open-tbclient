package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int De;
    private int Df;
    private int Dg;
    private int status;
    private int total_num;
    private String url;

    public int mj() {
        return this.De;
    }

    public int getStatus() {
        return this.status;
    }

    public int mk() {
        return this.Df;
    }

    public int ml() {
        return this.Dg;
    }

    public String getUrl() {
        return this.url;
    }

    public int mm() {
        return this.total_num;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.De = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Df = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Dg = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.De = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Df = jSONObject.optInt("begin_time");
                this.Dg = jSONObject.optInt("end_time");
                this.url = jSONObject.optString(ImageViewerConfig.URL);
                this.total_num = jSONObject.optInt("total_num");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
