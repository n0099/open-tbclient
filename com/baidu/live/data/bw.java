package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bw {
    public String downloadUrl = "";
    public String aRG = "";
    public String videoPath = "";
    public String videoMd5 = "";

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("poke_video_url", "");
            this.aRG = jSONObject.optString("poke_video_md5", "");
        }
    }
}
