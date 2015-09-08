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
        if (PluginPackageManager.lQ().ho()) {
            PluginSettings mj = com.baidu.adp.plugin.packageManager.pluginSettings.c.mm().mj();
            com.baidu.adp.plugin.b.a lE = com.baidu.adp.plugin.b.a.lE();
            str2 = this.this$0.Du;
            lE.d("plugin_setting", "version_update", null, String.valueOf(str2) + "-" + (mj == null ? "" : mj.getContainerVersion()));
        }
        if (z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c mm = com.baidu.adp.plugin.packageManager.pluginSettings.c.mm();
            str = this.this$0.Du;
            mm.bA(str);
            if (PluginPackageManager.lQ().ho()) {
                com.baidu.adp.plugin.b.a lE2 = com.baidu.adp.plugin.b.a.lE();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Dw;
                lE2.e("plugin_install", currentTimeMillis - j);
            }
        }
        this.this$0.lU();
        this.this$0.lW();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bc(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mm().f(str, true);
    }
}
