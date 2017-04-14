package com.baidu.adp.plugin;

import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.util.e {
    final /* synthetic */ Plugin Cw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Plugin plugin2) {
        this.Cw = plugin2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(Plugin.b bVar, String str) {
        if (PluginPackageManager.jx().isMainProcess()) {
            if (bVar.Cy) {
                com.baidu.adp.plugin.b.a.jk().A("plugin_load", str);
            } else {
                com.baidu.adp.plugin.b.a.jk().aV("plugin_loaded_failed");
            }
        }
    }
}
