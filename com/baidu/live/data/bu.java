package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bu {
    public String downloadUrl = "";
    public String aRG = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aRH = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aRG = jSONObject.optString("pk_start_video_md5", "");
            this.aRH = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
