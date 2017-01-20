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
            if (PluginPackageManager.iz().eN()) {
                PluginSettings iZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().iZ();
                com.baidu.adp.plugin.b.a im = com.baidu.adp.plugin.b.a.im();
                str3 = this.this$0.xs;
                im.e("plugin_setting", "version_update_suc", null, String.valueOf(str3) + "-" + (iZ == null ? "" : iZ.getContainerVersion()));
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c jc = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc();
            str2 = this.this$0.xs;
            jc.by(str2);
            if (PluginPackageManager.iz().eN()) {
                com.baidu.adp.plugin.b.a im2 = com.baidu.adp.plugin.b.a.im();
                long currentTimeMillis = System.currentTimeMillis();
                j = this.this$0.xu;
                im2.e("plugin_install", currentTimeMillis - j);
            }
        } else if (PluginPackageManager.iz().eN()) {
            PluginSettings iZ2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().iZ();
            com.baidu.adp.plugin.b.a im3 = com.baidu.adp.plugin.b.a.im();
            str = this.this$0.xs;
            im3.e("plugin_setting", "version_update_fail", null, String.valueOf(str) + "-" + (iZ2 == null ? "" : iZ2.getContainerVersion()));
        }
        this.this$0.iH();
        this.this$0.M(true);
    }

    @Override // com.baidu.adp.plugin.install.a
    public void ba(String str) {
        int i;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().f(str, true);
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            i = PluginPackageManager.xn;
            if (i2 < i) {
                com.baidu.adp.plugin.b.a.im().D("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.im().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
            }
        }
    }
}
