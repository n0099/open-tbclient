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
    public void G(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        if (z) {
            if (PluginPackageManager.hF().dU()) {
                PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
                com.baidu.adp.plugin.b.a hs = com.baidu.adp.plugin.b.a.hs();
                str3 = this.this$0.uL;
                hs.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (m9if == null ? "" : m9if.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c ii = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii();
            str2 = this.this$0.uL;
            ii.bx(str2);
            if (PluginPackageManager.hF().dU()) {
                com.baidu.adp.plugin.b.a hs2 = com.baidu.adp.plugin.b.a.hs();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.uN;
                hs2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.hF().dU()) {
            PluginSettings m9if2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
            com.baidu.adp.plugin.b.a hs3 = com.baidu.adp.plugin.b.a.hs();
            str = this.this$0.uL;
            hs3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (m9if2 == null ? "" : m9if2.getContainerVersion()));
        }
        this.this$0.hN();
        this.this$0.I(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aZ(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.uG;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.hs().D("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.hs().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
