package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bt {
    public String downloadUrl = "";
    public String aQq = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aQr = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aQq = jSONObject.optString("pk_start_video_md5", "");
            this.aQr = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
