package com.baidu.adp.plugin.packageManager;

import android.os.Message;
import com.baidu.adp.plugin.packageManager.b;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* loaded from: classes.dex */
class c implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    final /* synthetic */ b.a uB;
    private final /* synthetic */ Message uC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, Message message) {
        this.uB = aVar;
        this.uC = message;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        this.uC.obj = pluginSettings;
    }
}
