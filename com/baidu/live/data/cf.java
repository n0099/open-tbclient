package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cf {
    public String downloadUrl = "";
    public String aSj = "";
    public String videoPath = "";
    public String videoMd5 = "";

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("poke_video_url", "");
            this.aSj = jSONObject.optString("poke_video_md5", "");
        }
    }
}
