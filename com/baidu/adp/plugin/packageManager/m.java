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
    public void L(boolean z) {
        String str;
        long j;
        if (z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h mi = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi();
            str = this.this$0.Dy;
            mi.bG(str);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a lB = com.baidu.adp.plugin.b.a.lB();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.DA;
                lB.e("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.lQ();
        this.this$0.lS();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bj(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().f(str, true);
    }
}
