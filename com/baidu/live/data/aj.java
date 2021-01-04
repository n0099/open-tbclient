package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class aj {
    public String aMc;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aMc) || this.aMc.length() <= 4) ? this.aMc : this.aMc.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aMc + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
