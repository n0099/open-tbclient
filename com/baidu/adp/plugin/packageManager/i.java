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
    public void H(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        if (z) {
            if (PluginPackageManager.ls().hs()) {
                PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM();
                com.baidu.adp.plugin.b.a lf = com.baidu.adp.plugin.b.a.lf();
                str3 = this.this$0.Eb;
                lf.d("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (lM == null ? "" : lM.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c lP = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP();
            str2 = this.this$0.Eb;
            lP.bG(str2);
            if (PluginPackageManager.ls().hs()) {
                com.baidu.adp.plugin.b.a lf2 = com.baidu.adp.plugin.b.a.lf();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Ed;
                lf2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.ls().hs()) {
            PluginSettings lM2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM();
            com.baidu.adp.plugin.b.a lf3 = com.baidu.adp.plugin.b.a.lf();
            str = this.this$0.Eb;
            lf3.d("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (lM2 == null ? "" : lM2.getContainerVersion()));
        }
        this.this$0.lx();
        this.this$0.J(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bi(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().g(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.DW;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.lf().E("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.lf().d("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
