package com.baidu.searchbox.ng.ai.apps.lifecycle;

import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
/* loaded from: classes2.dex */
public interface AiAppsWebViewCallback {
    void onCreate(AiAppsWebViewManager aiAppsWebViewManager);

    void onDestroy(AiAppsWebViewManager aiAppsWebViewManager);

    void onPause(AiAppsWebViewManager aiAppsWebViewManager);

    void onResume(AiAppsWebViewManager aiAppsWebViewManager);
}
