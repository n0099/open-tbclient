package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cc {
    public String downloadUrl = "";
    public String aQJ = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aQK = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aQJ = jSONObject.optString("pk_start_video_md5", "");
            this.aQK = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
