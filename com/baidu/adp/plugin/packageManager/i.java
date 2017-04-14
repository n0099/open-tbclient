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
            if (PluginPackageManager.jx().isMainProcess()) {
                PluginSettings jX = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().jX();
                com.baidu.adp.plugin.b.a jk = com.baidu.adp.plugin.b.a.jk();
                str3 = this.this$0.Eh;
                jk.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (jX == null ? "" : jX.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c ka = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka();
            str2 = this.this$0.Eh;
            ka.bn(str2);
            if (PluginPackageManager.jx().isMainProcess()) {
                com.baidu.adp.plugin.b.a jk2 = com.baidu.adp.plugin.b.a.jk();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Ej;
                jk2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.jx().isMainProcess()) {
            PluginSettings jX2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().jX();
            com.baidu.adp.plugin.b.a jk3 = com.baidu.adp.plugin.b.a.jk();
            str = this.this$0.Eh;
            jk3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (jX2 == null ? "" : jX2.getContainerVersion()));
        }
        this.this$0.jF();
        this.this$0.N(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aP(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.Ec;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.jk().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.jk().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
