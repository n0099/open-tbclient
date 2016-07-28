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
    public void I(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        if (z) {
            if (PluginPackageManager.hG().dU()) {
                PluginSettings ig = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().ig();
                com.baidu.adp.plugin.b.a ht = com.baidu.adp.plugin.b.a.ht();
                str3 = this.this$0.vp;
                ht.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (ig == null ? "" : ig.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c ij = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij();
            str2 = this.this$0.vp;
            ij.by(str2);
            if (PluginPackageManager.hG().dU()) {
                com.baidu.adp.plugin.b.a ht2 = com.baidu.adp.plugin.b.a.ht();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.vr;
                ht2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.hG().dU()) {
            PluginSettings ig2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().ig();
            com.baidu.adp.plugin.b.a ht3 = com.baidu.adp.plugin.b.a.ht();
            str = this.this$0.vp;
            ht3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (ig2 == null ? "" : ig2.getContainerVersion()));
        }
        this.this$0.hO();
        this.this$0.K(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void ba(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.vk;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.ht().D("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.ht().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
