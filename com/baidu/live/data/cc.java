package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cc {
    public String downloadUrl = "";
    public String aSj = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aSk = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aSj = jSONObject.optString("pk_start_video_md5", "");
            this.aSk = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
