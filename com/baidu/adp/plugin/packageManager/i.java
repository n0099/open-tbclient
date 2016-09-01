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
    public void K(boolean z) {
        String str;
        String str2;
        long j;
        String str3;
        if (z) {
            if (PluginPackageManager.iB().eP()) {
                PluginSettings jb = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().jb();
                com.baidu.adp.plugin.b.a io = com.baidu.adp.plugin.b.a.io();
                str3 = this.this$0.xB;
                io.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (jb == null ? "" : jb.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c je = com.baidu.adp.plugin.packageManager.pluginSettings.c.je();
            str2 = this.this$0.xB;
            je.bz(str2);
            if (PluginPackageManager.iB().eP()) {
                com.baidu.adp.plugin.b.a io2 = com.baidu.adp.plugin.b.a.io();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.xD;
                io2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.iB().eP()) {
            PluginSettings jb2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().jb();
            com.baidu.adp.plugin.b.a io3 = com.baidu.adp.plugin.b.a.io();
            str = this.this$0.xB;
            io3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (jb2 == null ? "" : jb2.getContainerVersion()));
        }
        this.this$0.iJ();
        this.this$0.M(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void bb(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.je().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.xw;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.io().D("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.io().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
