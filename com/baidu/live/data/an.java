package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class an {
    public String aJU;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aJU) || this.aJU.length() <= 4) ? this.aJU : this.aJU.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aJU + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
