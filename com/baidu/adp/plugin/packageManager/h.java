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
            if (PluginPackageManager.lS().hq()) {
                PluginSettings ml = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml();
                com.baidu.adp.plugin.b.a lG = com.baidu.adp.plugin.b.a.lG();
                str3 = this.this$0.Dx;
                lG.d("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (ml == null ? "" : ml.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c mo = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo();
            str2 = this.this$0.Dx;
            mo.bz(str2);
            if (PluginPackageManager.lS().hq()) {
                com.baidu.adp.plugin.b.a lG2 = com.baidu.adp.plugin.b.a.lG();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Dz;
                lG2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.lS().hq()) {
            PluginSettings ml2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml();
            com.baidu.adp.plugin.b.a lG3 = com.baidu.adp.plugin.b.a.lG();
            str = this.this$0.Dx;
            lG3.d("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (ml2 == null ? "" : ml2.getContainerVersion()));
        }
        this.this$0.lW();
        this.this$0.lY();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bb(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().f(str, true);
    }
}
