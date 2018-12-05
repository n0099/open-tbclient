package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.YulePostActivity;
/* loaded from: classes.dex */
public class bk {
    private String activity_banner;
    private String activity_button;
    private String activity_desc;
    private String activity_url;
    private long end_time;
    private long start_time;

    public String Bz() {
        return this.activity_banner;
    }

    public String getActivityUrl() {
        return this.activity_url;
    }

    public String BA() {
        return this.activity_button;
    }

    public void a(YulePostActivity yulePostActivity) {
        if (yulePostActivity != null) {
            this.start_time = yulePostActivity.start_time != null ? yulePostActivity.start_time.longValue() : -1L;
            this.end_time = yulePostActivity.end_time != null ? yulePostActivity.end_time.longValue() : -1L;
            this.activity_banner = yulePostActivity.activity_banner;
            this.activity_url = yulePostActivity.activity_url;
            this.activity_desc = yulePostActivity.activity_desc;
            this.activity_button = yulePostActivity.activity_button;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.start_time = jSONObject.optLong("start_time");
                this.end_time = jSONObject.optLong("end_time");
                this.activity_banner = jSONObject.optString("activity_banner");
                this.activity_url = jSONObject.optString("activity_url");
                this.activity_desc = jSONObject.optString("activity_desc");
                this.activity_button = jSONObject.optString("activity_button");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
