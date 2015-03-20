package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BroadcastReceiver {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (intent != null) {
            String action = intent.getAction();
            if ("com.baidu.adp.plugin.installed".equals(action)) {
                String stringExtra = intent.getStringExtra("package_name");
                String stringExtra2 = intent.getStringExtra("install_dest_file");
                String stringExtra3 = intent.getStringExtra("version_name");
                int intExtra = intent.getIntExtra("version_code", 0);
                String stringExtra4 = intent.getStringExtra("require_load");
                boolean booleanExtra = intent.getBooleanExtra("is_inject_classloader", false);
                String stringExtra5 = intent.getStringExtra("cmd_range");
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(stringExtra);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.forbidden = false;
                }
                findPluginSetting.packageName = stringExtra;
                findPluginSetting.addAbandonApk(findPluginSetting.apkPath);
                findPluginSetting.apkPath = stringExtra2;
                findPluginSetting.setCmdRange(stringExtra5);
                findPluginSetting.enable = true;
                findPluginSetting.requireLoad = stringExtra4;
                findPluginSetting.version = stringExtra3;
                findPluginSetting.versionCode = intExtra;
                findPluginSetting.installStatus = 0;
                findPluginSetting.tempVersionCode = 0;
                findPluginSetting.tempMd5 = "";
                findPluginSetting.url = "";
                findPluginSetting.install_fail_count = 0;
                findPluginSetting.setInjectClassloader(booleanExtra);
                this.this$0.d(findPluginSetting);
                com.baidu.adp.plugin.packageManager.pluginSettings.h lP = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP();
                z4 = this.this$0.DH;
                lP.a(stringExtra, findPluginSetting, z4);
                if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals(GameInfoData.NOT_FROM_DETAIL)) {
                    PluginCenter.getInstance().launch(findPluginSetting.packageName);
                }
                this.this$0.a(stringExtra, true, (String) null);
                z5 = this.this$0.DH;
                if (z5) {
                    com.baidu.adp.plugin.b.a.lh().I("plugin_install", stringExtra);
                }
            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                String stringExtra6 = intent.getStringExtra("install_src_file");
                String substring = stringExtra6.substring(stringExtra6.lastIndexOf("/") + 1, stringExtra6.lastIndexOf(".apk"));
                String stringExtra7 = intent.getStringExtra("fail_reason");
                String stringExtra8 = intent.getStringExtra("install_comment");
                String stringExtra9 = intent.getStringExtra("package_name");
                if (!TextUtils.isEmpty(stringExtra9)) {
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(stringExtra9);
                    if (findPluginSetting2 == null) {
                        findPluginSetting2 = new PluginSetting();
                        findPluginSetting2.packageName = stringExtra9;
                    }
                    findPluginSetting2.enable = false;
                    z2 = this.this$0.DH;
                    if (z2) {
                        findPluginSetting2.install_fail_count++;
                        if (findPluginSetting2.install_fail_count >= 5) {
                            this.this$0.d(findPluginSetting2);
                            findPluginSetting2.tempVersionCode = 0;
                            findPluginSetting2.url = "";
                            findPluginSetting2.tempMd5 = "";
                            findPluginSetting2.install_fail_count = 0;
                            findPluginSetting2.installStatus = 0;
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.h lP2 = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP();
                    z3 = this.this$0.DH;
                    lP2.a(stringExtra9, findPluginSetting2, z3);
                }
                this.this$0.a(substring, false, stringExtra7);
                z = this.this$0.DH;
                if (z) {
                    com.baidu.adp.plugin.b.a.lh().be("plugin_install_fail");
                    com.baidu.adp.plugin.b.a.lh().d("plugin_install", stringExtra7, stringExtra9, stringExtra8);
                }
            }
        }
    }
}
