package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class an {
    public String aLu;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aLu) || this.aLu.length() <= 4) ? this.aLu : this.aLu.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aLu + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
