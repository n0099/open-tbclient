package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes.dex */
public class b {
    private int Pj;
    private int Pk;
    private int Pl;
    private int status;
    private int total_num;
    private String url;

    public int qq() {
        return this.Pj;
    }

    public int getStatus() {
        return this.status;
    }

    public int qr() {
        return this.Pk;
    }

    public int qs() {
        return this.Pl;
    }

    public String getUrl() {
        return this.url;
    }

    public int qt() {
        return this.total_num;
    }

    public void a(ActInfo actInfo) {
        if (actInfo != null) {
            this.Pj = actInfo.activity_type != null ? actInfo.activity_type.intValue() : -1;
            this.status = actInfo.status != null ? actInfo.status.intValue() : -1;
            this.Pk = actInfo.begin_time != null ? actInfo.begin_time.intValue() : -1;
            this.Pl = actInfo.end_time != null ? actInfo.end_time.intValue() : -1;
            this.url = actInfo.url;
            this.total_num = actInfo.total_num != null ? actInfo.total_num.intValue() : -1;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Pj = jSONObject.optInt("activity_type");
                this.status = jSONObject.optInt("status");
                this.Pk = jSONObject.optInt("begin_time");
                this.Pl = jSONObject.optInt("end_time");
                this.url = jSONObject.optString(ImageViewerConfig.URL);
                this.total_num = jSONObject.optInt("total_num");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
