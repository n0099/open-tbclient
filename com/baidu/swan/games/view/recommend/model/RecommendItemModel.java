package com.baidu.swan.games.view.recommend.model;

import com.baidu.searchbox.NoProGuard;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class RecommendItemModel implements NoProGuard {
    @SerializedName(GameGuideConfigInfo.KEY_APP_KEY)
    public String appKey;
    @SerializedName("app_name")
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
