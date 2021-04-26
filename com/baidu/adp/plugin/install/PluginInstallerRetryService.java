package com.baidu.adp.plugin.install;

import android.content.Intent;
import d.a.c.h.g.d;
/* loaded from: classes.dex */
public class PluginInstallerRetryService extends HighPriorityIntentService {
    public PluginInstallerRetryService() {
        super(PluginInstallerRetryService.class.getSimpleName());
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService
    public void onHandleIntent(Intent intent) {
        d.p(intent);
    }

    public PluginInstallerRetryService(String str) {
        super(str);
    }
}
