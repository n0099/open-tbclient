package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.a;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.c {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.packageManager.a.c
    public void G(String str, String str2) {
        PluginSetting findPluginSetting;
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str)) != null) {
            if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bH(str);
            } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = findPluginSetting.getAbandon_apk_path().split(",");
                String str3 = "";
                for (String str4 : split) {
                    if (!str2.equals(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = String.valueOf(str3) + ",";
                        }
                        str3 = String.valueOf(str3) + str4;
                    }
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c mc = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc();
                z = this.this$0.En;
                mc.b(str, str3, z);
            }
        }
    }
}
