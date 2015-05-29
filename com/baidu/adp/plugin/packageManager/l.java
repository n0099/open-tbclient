package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements d {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.packageManager.d
    public void L(String str, String str2) {
        PluginSetting findPluginSetting;
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str)) != null) {
            if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().bH(str);
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
                com.baidu.adp.plugin.packageManager.pluginSettings.h mi = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi();
                z = this.this$0.Dx;
                mi.b(str, str3, z);
            }
        }
    }
}
