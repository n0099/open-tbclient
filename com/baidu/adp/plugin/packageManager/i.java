package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.plugin.install.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.install.a
    public void L(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        if (z) {
            if (PluginPackageManager.lU().hs()) {
                PluginSettings mo = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo();
                com.baidu.adp.plugin.b.a lI = com.baidu.adp.plugin.b.a.lI();
                str3 = this.this$0.DI;
                lI.d("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (mo == null ? "" : mo.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c mr = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr();
            str2 = this.this$0.DI;
            mr.bD(str2);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a lI2 = com.baidu.adp.plugin.b.a.lI();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.DK;
                lI2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.lU().hs()) {
            PluginSettings mo2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo();
            com.baidu.adp.plugin.b.a lI3 = com.baidu.adp.plugin.b.a.lI();
            str = this.this$0.DI;
            lI3.d("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (mo2 == null ? "" : mo2.getContainerVersion()));
        }
        this.this$0.lZ();
        this.this$0.mb();
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bf(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().g(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.versionCode < 42) {
            com.baidu.adp.plugin.b.a.lI().F("plugin_launch_lowversion", str);
            com.baidu.adp.plugin.b.a.lI().d("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
        }
    }
}
