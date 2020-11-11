package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class af {
    public String aKp;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aKp) || this.aKp.length() <= 4) ? this.aKp : this.aKp.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aKp + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
