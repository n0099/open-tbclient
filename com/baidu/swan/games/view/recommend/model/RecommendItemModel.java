package com.baidu.swan.games.view.recommend.model;

import com.alipay.sdk.cons.b;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class RecommendItemModel implements NoProGuard {
    @SerializedName(b.f1831h)
    public String appKey;
    @SerializedName(DpStatConstants.KEY_APP_NAME)
    public String appName;
    public String buttonText;
    @SerializedName("desc")
    public String desc;
    @SerializedName("icon_url")
    public String iconUrl;
    @SerializedName("scheme")
    public String scheme;

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getScheme() {
        return this.scheme;
    }
}
