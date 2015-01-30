package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int Dh;
    private int Di;
    private int Dj;
    private int status;
    private int total_num;
    private String url;

    public int mq() {
        return this.Dh;
    }

    public int getStatus() {
        return this.status;
    }

    public int mr() {
        return this.Di;
    }

    public int ms() {
        return this.Dj;
    }

    public String getUrl() {
        return this.url;
    }

    public int mt() {
        return this.total_num;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Dh = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Di = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Dj = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Dh = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Di = jSONObject.optInt("begin_time");
                this.Dj = jSONObject.optInt("end_time");
                this.url = jSONObject.optString(ImageViewerConfig.URL);
                this.total_num = jSONObject.optInt("total_num");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
