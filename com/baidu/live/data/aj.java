package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class aj {
    public String aHp;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aHp) || this.aHp.length() <= 4) ? this.aHp : this.aHp.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aHp + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
