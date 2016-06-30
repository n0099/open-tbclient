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
            if (PluginPackageManager.hH().dV()) {
                PluginSettings ih = com.baidu.adp.plugin.packageManager.pluginSettings.c.ik().ih();
                com.baidu.adp.plugin.b.a hu = com.baidu.adp.plugin.b.a.hu();
                str3 = this.this$0.uN;
                hu.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (ih == null ? "" : ih.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c ik = com.baidu.adp.plugin.packageManager.pluginSettings.c.ik();
            str2 = this.this$0.uN;
            ik.bx(str2);
            if (PluginPackageManager.hH().dV()) {
                com.baidu.adp.plugin.b.a hu2 = com.baidu.adp.plugin.b.a.hu();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.uP;
                hu2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.hH().dV()) {
            PluginSettings ih2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ik().ih();
            com.baidu.adp.plugin.b.a hu3 = com.baidu.adp.plugin.b.a.hu();
            str = this.this$0.uN;
            hu3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (ih2 == null ? "" : ih2.getContainerVersion()));
        }
        this.this$0.hP();
        this.this$0.I(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aZ(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ik().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ik().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.uI;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.hu().D("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.hu().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
