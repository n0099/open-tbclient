package com.baidu.adp.plugin.packageManager;

import android.os.Message;
import com.baidu.adp.plugin.packageManager.b;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* loaded from: classes.dex */
class c implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    final /* synthetic */ b.a Ew;
    private final /* synthetic */ Message Ex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, Message message) {
        this.Ew = aVar;
        this.Ex = message;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        this.Ex.obj = pluginSettings;
    }
}
