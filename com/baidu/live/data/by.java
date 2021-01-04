package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class by {
    public String downloadUrl = "";
    public String aSv = "";
    public String videoPath = "";
    public String videoMd5 = "";

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("poke_video_url", "");
            this.aSv = jSONObject.optString("poke_video_md5", "");
        }
    }
}
