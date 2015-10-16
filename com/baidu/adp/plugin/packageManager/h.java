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
        String str2;
        long j;
        String str3;
        if (z) {
            if (PluginPackageManager.lR().hp()) {
                PluginSettings mk = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
                com.baidu.adp.plugin.b.a lF = com.baidu.adp.plugin.b.a.lF();
                str3 = this.this$0.Dw;
                lF.d("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (mk == null ? "" : mk.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c mn = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn();
            str2 = this.this$0.Dw;
            mn.bB(str2);
            if (PluginPackageManager.lR().hp()) {
                com.baidu.adp.plugin.b.a lF2 = com.baidu.adp.plugin.b.a.lF();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Dy;
                lF2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.lR().hp()) {
            PluginSettings mk2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
            com.baidu.adp.plugin.b.a lF3 = com.baidu.adp.plugin.b.a.lF();
            str = this.this$0.Dw;
            lF3.d("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (mk2 == null ? "" : mk2.getContainerVersion()));
        }
        this.this$0.lV();
        this.this$0.lX();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bd(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().f(str, true);
    }
}
