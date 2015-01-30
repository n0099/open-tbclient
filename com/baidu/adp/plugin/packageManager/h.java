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
            com.baidu.adp.plugin.packageManager.pluginSettings.h iy = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy();
            str = this.this$0.sQ;
            iy.br(str);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a hU = com.baidu.adp.plugin.b.a.hU();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.sS;
                hU.b("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.ih();
        this.this$0.ij();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aU(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().f(str, true);
    }
}
