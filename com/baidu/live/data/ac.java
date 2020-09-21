package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class ac {
    public String aFK;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aFK) || this.aFK.length() <= 4) ? this.aFK : this.aFK.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aFK + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
