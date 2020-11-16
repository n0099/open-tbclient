package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class af {
    public String aIE;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aIE) || this.aIE.length() <= 4) ? this.aIE : this.aIE.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aIE + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
