package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class ae {
    public String aJp;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aJp) || this.aJp.length() <= 4) ? this.aJp : this.aJp.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aJp + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
