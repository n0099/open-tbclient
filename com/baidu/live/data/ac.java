package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class ac {
    public String aIO;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aIO) || this.aIO.length() <= 4) ? this.aIO : this.aIO.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aIO + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
