package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bw {
    public String downloadUrl = "";
    public String aSv = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aSw = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aSv = jSONObject.optString("pk_start_video_md5", "");
            this.aSw = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
