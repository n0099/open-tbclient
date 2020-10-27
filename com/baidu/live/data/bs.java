package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bs {
    public String downloadUrl = "";
    public String aPt = "";
    public String videoPath = "";
    public String videoMd5 = "";
    public boolean aPu = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_start_video_url", "");
            this.aPt = jSONObject.optString("pk_start_video_md5", "");
            this.aPu = jSONObject.optInt("switch", 0) == 1;
        }
    }
}
