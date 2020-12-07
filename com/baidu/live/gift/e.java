package com.baidu.live.gift;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private int aVz;
    private int isLandScape;
    public String videoMd5;
    public String videoUrl;
    public String zipDownloadUrl;
    public String zipMD5;
    public String zipName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.zipMD5 = jSONObject.optString("zip_md5");
            this.zipDownloadUrl = jSONObject.optString("zip_url");
            this.zipName = jSONObject.optString("zip_name");
            this.videoUrl = jSONObject.optString("video_url");
            this.videoMd5 = jSONObject.optString("video_md5");
            this.isLandScape = jSONObject.optInt("is_landscape");
            this.aVz = jSONObject.optInt("need_download");
        }
    }

    public boolean isLandScape() {
        return this.isLandScape == 1;
    }
}
