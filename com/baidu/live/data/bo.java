package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bo {
    public String downloadUrl = "";
    public String aOO = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aOP = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aOO = jSONObject.optString("pk_start_video_md5", "");
            this.aOP = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
