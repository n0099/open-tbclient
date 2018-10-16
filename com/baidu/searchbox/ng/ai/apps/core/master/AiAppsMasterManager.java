package com.baidu.searchbox.ng.ai.apps.core.master;

import android.content.Context;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
/* loaded from: classes2.dex */
public class AiAppsMasterManager extends AiAppsWebViewManager {
    private static final boolean DEBUG = false;
    private static final String MASTER_ID = "master";
    private static final String TAG = "AiAppsMasterManager";

    public AiAppsMasterManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void postInit() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected BrowserType getBrowserType() {
        return BrowserType.AI_APPS_MASTER;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public String getWebViewId() {
        return MASTER_ID;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void loadUrl(String str) {
        if (RemoteDebugger.isRemoteDebug()) {
            str = RemoteDebugger.getMasterWebViewUrl();
        }
        super.loadUrl(str);
    }
}
