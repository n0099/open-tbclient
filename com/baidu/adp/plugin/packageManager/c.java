package com.baidu.adp.plugin.packageManager;

import android.os.Message;
import com.baidu.adp.plugin.packageManager.b;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* loaded from: classes.dex */
class c implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    final /* synthetic */ b.a DX;
    private final /* synthetic */ Message DY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar, Message message) {
        this.DX = aVar;
        this.DY = message;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        this.DY.obj = pluginSettings;
    }
}
