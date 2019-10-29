package com.baidu.ala.gift;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaDynamicGiftZip implements Serializable {
    private int isLandScape;
    public int isNeedDownload;
    public String zipDownloadUrl;
    public String zipMD5;
    public String zipName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.zipMD5 = jSONObject.optString("zip_md5");
            this.zipDownloadUrl = jSONObject.optString("zip_url");
            this.zipName = jSONObject.optString("zip_name");
            this.isLandScape = jSONObject.optInt("is_landscape");
            this.isNeedDownload = jSONObject.optInt("need_download");
        }
    }

    public boolean isLandScape() {
        return this.isLandScape == 1;
    }

    public boolean isNeedDownload() {
        return this.isNeedDownload == 1;
    }
}
