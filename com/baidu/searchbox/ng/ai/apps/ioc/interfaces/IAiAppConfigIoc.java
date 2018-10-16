package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
/* loaded from: classes2.dex */
public interface IAiAppConfigIoc {
    boolean disableJsPromptS();

    String getAiAppFormIdUrl();

    String getAiAppsCommonAiUrl();

    String getAiAppsResetUrl();

    String getAiAppsUpdateUrl();

    String getBuildTime();

    String getCommitId();

    CookieManager getCookieManager(boolean z, boolean z2);

    String getHostForHttps();

    String getHostName();

    String getLowVersionUpgradePageUrl();

    String getRecommendProductsUrl();

    String getRecommendSimilarUrl();

    long getServerTimeDelta();

    String getZeusVersion(Context context);

    void initMobstat();

    boolean isDebug();

    boolean isRemoteDebug();
}
