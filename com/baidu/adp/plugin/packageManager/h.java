package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.plugin.install.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.install.a
    public void J(boolean z) {
        String str;
        long j;
        if (z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h ir = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir();
            str = this.this$0.sN;
            ir.bo(str);
            if (PluginPackageManager.hV().id()) {
                com.baidu.adp.plugin.b.a hN = com.baidu.adp.plugin.b.a.hN();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.sP;
                hN.b("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.hZ();
        this.this$0.ib();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aR(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().f(str, true);
    }
}
