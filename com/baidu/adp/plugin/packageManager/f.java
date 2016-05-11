package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BroadcastReceiver {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x023a  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        boolean z;
        boolean z2;
        int i;
        PluginSetting pluginSetting;
        boolean z3;
        String str;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8 = false;
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
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(stringExtra);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.forbidden = false;
                }
                if (findPluginSetting.install_fail_count > 0) {
                    com.baidu.adp.plugin.b.a.hs().D("plugin_install_suc_fail", stringExtra);
                }
                findPluginSetting.packageName = stringExtra;
                if (!TextUtils.equals(stringExtra2, findPluginSetting.apkPath)) {
                    findPluginSetting.addAbandonApk(findPluginSetting.apkPath);
                }
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
                findPluginSetting.isThird = intent.getBooleanExtra("is_third", false);
                findPluginSetting.isPatch = intent.getBooleanExtra("is_patch", false);
                findPluginSetting.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                findPluginSetting.setInjectClassloader(booleanExtra);
                this.this$0.d(findPluginSetting);
                com.baidu.adp.plugin.packageManager.pluginSettings.c ii = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii();
                z6 = this.this$0.uK;
                ii.a(stringExtra, findPluginSetting, z6);
                if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                    z8 = true;
                }
                if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z8) {
                    PluginCenter.getInstance().launch(findPluginSetting.packageName);
                }
                this.this$0.a(stringExtra, true, (String) null);
                z7 = this.this$0.uK;
                if (z7) {
                    com.baidu.adp.plugin.b.a.hs().e("plugin_install_suc", stringExtra, findPluginSetting);
                    i2 = PluginPackageManager.uG;
                    if (intExtra < i2) {
                        com.baidu.adp.plugin.b.a.hs().D("plugin_launch_lowversion", stringExtra);
                        com.baidu.adp.plugin.b.a.hs().e("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + "-" + findPluginSetting.versionCode + "-" + findPluginSetting.forbidden + "-" + findPluginSetting.tempVersionCode + "-" + findPluginSetting.installStatus);
                    }
                }
            } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                String stringExtra6 = intent.getStringExtra("install_src_file");
                if (stringExtra6 != null) {
                    String substring = stringExtra6.substring(stringExtra6.lastIndexOf("/") + 1, stringExtra6.lastIndexOf(".apk"));
                    String stringExtra7 = intent.getStringExtra("fail_reason");
                    String stringExtra8 = intent.getStringExtra("install_comment");
                    String stringExtra9 = intent.getStringExtra("package_name");
                    if (TextUtils.isEmpty(stringExtra9)) {
                        pluginSetting = null;
                    } else {
                        pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(stringExtra9);
                        if (pluginSetting == null) {
                            pluginSetting = new PluginSetting();
                            pluginSetting.packageName = stringExtra9;
                        }
                        pluginSetting.enable = false;
                        z4 = this.this$0.uK;
                        if (z4) {
                            pluginSetting.install_fail_count++;
                            if (pluginSetting.install_fail_count >= 5) {
                                this.this$0.d(pluginSetting);
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = "";
                                pluginSetting.tempMd5 = "";
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                            }
                            if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_plugin", 3)) {
                                com.baidu.adp.lib.stats.a.dN().p("alert_plugin", "package name = " + stringExtra9 + "; fail count = " + pluginSetting.install_fail_count);
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c ii2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii();
                        z5 = this.this$0.uK;
                        ii2.a(stringExtra9, pluginSetting, z5);
                    }
                    this.this$0.a(substring, false, stringExtra7);
                    z3 = this.this$0.uK;
                    if (z3) {
                        if (stringExtra8 != null) {
                            String lowerCase = stringExtra8.toLowerCase(Locale.getDefault());
                            if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                str = "rom_size";
                            } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                str = "read_file_system";
                                com.baidu.adp.plugin.b.a.hs().D("plugin_read_file_sys", stringExtra9);
                            } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                str = "permission_denied";
                                com.baidu.adp.plugin.b.a.hs().D("plugin_permission_denied", stringExtra9);
                            } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                str = "fsync_failed";
                                com.baidu.adp.plugin.b.a.hs().D("plugin_fsync_failed", stringExtra9);
                            }
                            if ("rom_size".equals(str)) {
                                com.baidu.adp.plugin.b.a.hs().D("plugin_rom_small", stringExtra9);
                            }
                            com.baidu.adp.plugin.b.a.hs().a("plugin_install_fail", stringExtra9, pluginSetting, str);
                            com.baidu.adp.plugin.b.a.hs().f("plugin_install", str, stringExtra9, stringExtra8);
                        }
                        str = stringExtra7;
                        if ("rom_size".equals(str)) {
                        }
                        com.baidu.adp.plugin.b.a.hs().a("plugin_install_fail", stringExtra9, pluginSetting, str);
                        com.baidu.adp.plugin.b.a.hs().f("plugin_install", str, stringExtra9, stringExtra8);
                    }
                }
            } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                String stringExtra10 = intent.getStringExtra("package_name");
                PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(stringExtra10);
                if (findPluginSetting2 != null) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().f(stringExtra10, true);
                    int i3 = findPluginSetting2.versionCode;
                    i = PluginPackageManager.uG;
                    if (i3 < i) {
                        com.baidu.adp.plugin.b.a.hs().D("plugin_launch_lowversion", stringExtra10);
                        com.baidu.adp.plugin.b.a.hs().e("plugin_load", "load_lowversion", stringExtra10, "broadcast_cancel-" + findPluginSetting2.apkPath + "-" + findPluginSetting2.versionCode + "-" + findPluginSetting2.forbidden + "-" + findPluginSetting2.tempVersionCode + "-" + findPluginSetting2.installStatus);
                    }
                } else {
                    com.baidu.adp.plugin.b.a.hs().e("plugin_install", "install_cancel_settingnull", stringExtra10, null);
                }
                this.this$0.a(stringExtra10, true, (String) null);
            } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                String stringExtra11 = intent.getStringExtra("fail_reason");
                String stringExtra12 = intent.getStringExtra("package_name");
                if (!TextUtils.isEmpty(stringExtra12)) {
                    PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(stringExtra12);
                    if (findPluginSetting3 == null) {
                        findPluginSetting3 = new PluginSetting();
                        findPluginSetting3.packageName = stringExtra12;
                    }
                    findPluginSetting3.enable = false;
                    z = this.this$0.uK;
                    if (z && "low_version_code".equals(stringExtra11)) {
                        this.this$0.d(findPluginSetting3);
                        findPluginSetting3.tempVersionCode = 0;
                        findPluginSetting3.url = "";
                        findPluginSetting3.tempMd5 = "";
                        findPluginSetting3.install_fail_count = 0;
                        findPluginSetting3.installStatus = 0;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c ii3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii();
                    z2 = this.this$0.uK;
                    ii3.a(stringExtra12, findPluginSetting3, z2);
                    if ("low_version_code".equals(stringExtra11)) {
                        com.baidu.adp.plugin.b.a.hs().D("plugin_low_version_code", stringExtra12);
                    }
                }
            }
        }
    }
}
