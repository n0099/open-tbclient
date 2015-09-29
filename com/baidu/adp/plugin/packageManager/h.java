package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
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
        String str2;
        if (PluginPackageManager.lR().hp()) {
            PluginSettings mk = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
            com.baidu.adp.plugin.b.a lF = com.baidu.adp.plugin.b.a.lF();
            str2 = this.this$0.Dv;
            lF.d("plugin_setting", "version_update", null, String.valueOf(str2) + "-" + (mk == null ? "" : mk.getContainerVersion()));
        }
        if (z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c mn = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn();
            str = this.this$0.Dv;
            mn.bB(str);
            if (PluginPackageManager.lR().hp()) {
                com.baidu.adp.plugin.b.a lF2 = com.baidu.adp.plugin.b.a.lF();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Dx;
                lF2.e("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.lV();
        this.this$0.lX();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bd(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().f(str, true);
    }
}
