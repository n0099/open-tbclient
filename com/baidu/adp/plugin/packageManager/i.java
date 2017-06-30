package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.xiaomi.mipush.sdk.Constants;
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
            if (PluginPackageManager.jw().isMainProcess()) {
                PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
                com.baidu.adp.plugin.b.a jj = com.baidu.adp.plugin.b.a.jj();
                str3 = this.this$0.Ek;
                jj.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (jV == null ? "" : jV.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY();
            str2 = this.this$0.Ek;
            jY.bs(str2);
            if (PluginPackageManager.jw().isMainProcess()) {
                com.baidu.adp.plugin.b.a jj2 = com.baidu.adp.plugin.b.a.jj();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.Em;
                jj2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.jw().isMainProcess()) {
            PluginSettings jV2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
            com.baidu.adp.plugin.b.a jj3 = com.baidu.adp.plugin.b.a.jj();
            str = this.this$0.Ek;
            jj3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (jV2 == null ? "" : jV2.getContainerVersion()));
        }
        this.this$0.loadPlugin();
        this.this$0.N(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void aU(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.Ef;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.jj().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.jj().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    }
}
