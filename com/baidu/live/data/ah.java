package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class ah {
    public String aLy;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aLy) || this.aLy.length() <= 4) ? this.aLy : this.aLy.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aLy + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
