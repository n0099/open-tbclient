package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bw {
    public String downloadUrl = "";
    public String aNI = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aNJ = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aNI = jSONObject.optString("pk_start_video_md5", "");
            this.aNJ = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
