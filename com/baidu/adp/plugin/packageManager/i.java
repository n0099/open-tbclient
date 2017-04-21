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
            if (PluginPackageManager.jy().isMainProcess()) {
                PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
                com.baidu.adp.plugin.b.a jl = com.baidu.adp.plugin.b.a.jl();
                str3 = this.this$0.Ek;
                jl.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (jY == null ? "" : jY.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c kb = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb();
            str2 = this.this$0.Ek;
            kb.bn(str2);
            if (PluginPackageManager.jy().isMainProcess()) {
                com.baidu.adp.plugin.b.a jl2 = com.baidu.adp.plugin.b.a.jl();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Em;
                jl2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.jy().isMainProcess()) {
            PluginSettings jY2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
            com.baidu.adp.plugin.b.a jl3 = com.baidu.adp.plugin.b.a.jl();
            str = this.this$0.Ek;
            jl3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (jY2 == null ? "" : jY2.getContainerVersion()));
        }
        this.this$0.jG();
        this.this$0.N(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aP(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.Ef;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.jl().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.jl().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
