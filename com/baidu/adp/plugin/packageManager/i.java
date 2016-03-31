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
            if (PluginPackageManager.ls().hG()) {
                PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
                com.baidu.adp.plugin.b.a lf = com.baidu.adp.plugin.b.a.lf();
                str3 = this.this$0.Et;
                lf.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (lR == null ? "" : lR.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c lU = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU();
            str2 = this.this$0.Et;
            lU.bE(str2);
            if (PluginPackageManager.ls().hG()) {
                com.baidu.adp.plugin.b.a lf2 = com.baidu.adp.plugin.b.a.lf();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Ev;
                lf2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.ls().hG()) {
            PluginSettings lR2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
            com.baidu.adp.plugin.b.a lf3 = com.baidu.adp.plugin.b.a.lf();
            str = this.this$0.Et;
            lf3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (lR2 == null ? "" : lR2.getContainerVersion()));
        }
        this.this$0.lA();
        this.this$0.I(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bg(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.Eo;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.lf().E("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
