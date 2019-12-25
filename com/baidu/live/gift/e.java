package com.baidu.live.gift;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private int adw;
    private int isLandScape;
    public String zipDownloadUrl;
    public String zipMD5;
    public String zipName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.zipMD5 = jSONObject.optString("zip_md5");
            this.zipDownloadUrl = jSONObject.optString("zip_url");
            this.zipName = jSONObject.optString("zip_name");
            this.isLandScape = jSONObject.optInt("is_landscape");
            this.adw = jSONObject.optInt("need_download");
        }
    }

    public boolean isLandScape() {
        return this.isLandScape == 1;
    }

    public boolean qn() {
        return this.adw == 1;
    }
}
