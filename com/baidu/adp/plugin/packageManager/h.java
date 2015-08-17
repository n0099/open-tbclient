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
    public void L(boolean z) {
        String str;
        long j;
        if (z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c mp = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp();
            str = this.this$0.Du;
            mp.bA(str);
            if (PluginPackageManager.lT().hr()) {
                com.baidu.adp.plugin.b.a lH = com.baidu.adp.plugin.b.a.lH();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Dw;
                lH.e("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.lX();
        this.this$0.lZ();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bc(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().f(str, true);
    }
}
