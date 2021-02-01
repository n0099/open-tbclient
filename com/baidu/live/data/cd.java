package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cd {
    public String downloadUrl = "";
    public String aQJ = "";
    public String videoPath = "";
    public String videoMd5 = "";

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.downloadUrl = jSONObject.optString("pk_task_effect_video_url", "");
            this.aQJ = jSONObject.optString("pk_task_effect_video_md5", "");
        }
    }
}
