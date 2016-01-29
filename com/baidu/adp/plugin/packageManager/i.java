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
            if (PluginPackageManager.lD().hA()) {
                PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
                com.baidu.adp.plugin.b.a lq = com.baidu.adp.plugin.b.a.lq();
                str3 = this.this$0.Eo;
                lq.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (lZ == null ? "" : lZ.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c mc = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc();
            str2 = this.this$0.Eo;
            mc.bG(str2);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a lq2 = com.baidu.adp.plugin.b.a.lq();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Eq;
                lq2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.lD().hA()) {
            PluginSettings lZ2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
            com.baidu.adp.plugin.b.a lq3 = com.baidu.adp.plugin.b.a.lq();
            str = this.this$0.Eo;
            lq3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (lZ2 == null ? "" : lZ2.getContainerVersion()));
        }
        this.this$0.lK();
        this.this$0.J(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bi(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().g(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.Ej;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.lq().F("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
