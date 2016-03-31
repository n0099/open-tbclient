package com.baidu.adp.plugin;

import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.util.e {
    final /* synthetic */ Plugin CI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Plugin plugin2) {
        this.CI = plugin2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(Plugin.b bVar, String str) {
        if (PluginPackageManager.ls().hG()) {
            if (bVar.CK) {
                com.baidu.adp.plugin.b.a.lf().D("plugin_load", str);
            } else {
                com.baidu.adp.plugin.b.a.lf().bm("plugin_loaded_failed");
            }
        }
    }
}
