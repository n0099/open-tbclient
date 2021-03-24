package com.baidu.swan.games.view.recommend.model;

import com.alipay.sdk.cons.b;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.NoProGuard;
import d.g.c.a.c;
/* loaded from: classes3.dex */
public class RecommendItemModel implements NoProGuard {
    @c(b.f1858h)
    public String appKey;
    @c(DpStatConstants.KEY_APP_NAME)
    public String appName;
    public String buttonText;
    @c("desc")
    public String desc;
    @c("icon_url")
    public String iconUrl;
    @c("scheme")
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
