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
            if (PluginPackageManager.jt().isMainProcess()) {
                PluginSettings jT = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().jT();
                com.baidu.adp.plugin.b.a jg = com.baidu.adp.plugin.b.a.jg();
                str3 = this.this$0.EG;
                jg.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (jT == null ? "" : jT.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c jW = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW();
            str2 = this.this$0.EG;
            jW.bs(str2);
            if (PluginPackageManager.jt().isMainProcess()) {
                com.baidu.adp.plugin.b.a jg2 = com.baidu.adp.plugin.b.a.jg();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.EI;
                jg2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.jt().isMainProcess()) {
            PluginSettings jT2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().jT();
            com.baidu.adp.plugin.b.a jg3 = com.baidu.adp.plugin.b.a.jg();
            str = this.this$0.EG;
            jg3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (jT2 == null ? "" : jT2.getContainerVersion()));
        }
        this.this$0.jB();
        this.this$0.N(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aU(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.EB;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.jg().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.jg().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
