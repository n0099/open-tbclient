package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BroadcastReceiver {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PluginSetting pluginSetting;
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(stringExtra);
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
                findPluginSetting.hasRes = intent.getBooleanExtra("has_res", false);
                findPluginSetting.setInjectClassloader(booleanExtra);
                this.this$0.d(findPluginSetting);
                com.baidu.adp.plugin.packageManager.pluginSettings.c mp = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp();
                z4 = this.this$0.Dt;
                mp.a(stringExtra, findPluginSetting, z4);
                if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0")) {
                    PluginCenter.getInstance().launch(findPluginSetting.packageName);
                }
                this.this$0.a(stringExtra, true, (String) null);
                z5 = this.this$0.Dt;
                if (z5) {
                    com.baidu.adp.plugin.b.a.lH().a("plugin_install_suc", stringExtra, findPluginSetting);
                }
            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                String stringExtra6 = intent.getStringExtra("install_src_file");
                String substring = stringExtra6.substring(stringExtra6.lastIndexOf("/") + 1, stringExtra6.lastIndexOf(".apk"));
                String stringExtra7 = intent.getStringExtra("fail_reason");
                String stringExtra8 = intent.getStringExtra("install_comment");
                String stringExtra9 = intent.getStringExtra("package_name");
                if (TextUtils.isEmpty(stringExtra9)) {
                    pluginSetting = null;
                } else {
                    pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(stringExtra9);
                    if (pluginSetting == null) {
                        pluginSetting = new PluginSetting();
                        pluginSetting.packageName = stringExtra9;
                    }
                    pluginSetting.enable = false;
                    z2 = this.this$0.Dt;
                    if (z2) {
                        pluginSetting.install_fail_count++;
                        if (pluginSetting.install_fail_count >= 5) {
                            this.this$0.d(pluginSetting);
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = "";
                            pluginSetting.tempMd5 = "";
                            pluginSetting.install_fail_count = 0;
                            pluginSetting.installStatus = 0;
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c mp2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp();
                    z3 = this.this$0.Dt;
                    mp2.a(stringExtra9, pluginSetting, z3);
                }
                this.this$0.a(substring, false, stringExtra7);
                z = this.this$0.Dt;
                if (z) {
                    com.baidu.adp.plugin.b.a.lH().a("plugin_install_fail", stringExtra9, pluginSetting);
                    com.baidu.adp.plugin.b.a.lH().d("plugin_install", stringExtra7, stringExtra9, stringExtra8);
                }
            }
        }
    }
}
