package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.plugin.install.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.install.a
    public void J(boolean z) {
        String str;
        long j;
        if (z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h lP = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP();
            str = this.this$0.DI;
            lP.bw(str);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a lh = com.baidu.adp.plugin.b.a.lh();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.DK;
                lh.b("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.lw();
        this.this$0.ly();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aZ(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().f(str, true);
    }
}
