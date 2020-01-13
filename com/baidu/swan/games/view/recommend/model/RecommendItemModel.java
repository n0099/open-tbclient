package com.baidu.swan.games.view.recommend.model;

import android.support.annotation.Keep;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
@Keep
/* loaded from: classes10.dex */
public class RecommendItemModel {
    @com.google.gson.a.c("app_key")
    public String appKey;
    @com.google.gson.a.c("app_name")
    public String appName;
    public String buttonText;
    @com.google.gson.a.c("desc")
    public String desc;
    @com.google.gson.a.c("icon_url")
    public String iconUrl;
    @com.google.gson.a.c(SuspensionBallEntity.KEY_SCHEME)
    public String scheme;

    public String getAppName() {
        return this.appName;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }
}
