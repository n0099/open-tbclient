package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int Df;
    private int Dg;
    private int Dh;
    private int status;
    private int total_num;
    private String url;

    public int mq() {
        return this.Df;
    }

    public int getStatus() {
        return this.status;
    }

    public int mr() {
        return this.Dg;
    }

    public int ms() {
        return this.Dh;
    }

    public String getUrl() {
        return this.url;
    }

    public int mt() {
        return this.total_num;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Df = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Dg = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Dh = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Df = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Dg = jSONObject.optInt("begin_time");
                this.Dh = jSONObject.optInt("end_time");
                this.url = jSONObject.optString(ImageViewerConfig.URL);
                this.total_num = jSONObject.optInt("total_num");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
