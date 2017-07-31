package com.baidu.adp.plugin.install;

import android.content.Intent;
/* loaded from: classes.dex */
public class PluginInstallerRetryService extends HighPriorityIntentService {
    public PluginInstallerRetryService() {
        super(PluginInstallerRetryService.class.getSimpleName());
    }

    public PluginInstallerRetryService(String str) {
        super(str);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService
    protected void onHandleIntent(Intent intent) {
        d.onHandleIntent(intent);
    }
}
