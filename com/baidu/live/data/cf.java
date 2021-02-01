package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cf {
    public String downloadUrl = "";
    public String aQJ = "";
    public String videoPath = "";
    public String videoMd5 = "";

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("poke_video_url", "");
            this.aQJ = jSONObject.optString("poke_video_md5", "");
        }
    }
}
