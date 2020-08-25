package com.baidu.live.data;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class x {
    public String aEx;
    public String endColor;
    public String imageUrl;
    public String startColor;
    public String url;

    public String getLabelName() {
        return (TextUtils.isEmpty(this.aEx) || this.aEx.length() <= 4) ? this.aEx : this.aEx.substring(0, 4);
    }

    public String toString() {
        return "AlaSceneData{url='" + this.url + "', sceneName='" + this.aEx + "', imageUrl='" + this.imageUrl + "', startColor='" + this.startColor + "', endColor='" + this.endColor + "'}";
    }
}
