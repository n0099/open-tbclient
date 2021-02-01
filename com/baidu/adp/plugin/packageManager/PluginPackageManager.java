package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.a;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.a;
import com.baidu.adp.plugin.packageManager.pluginSettings.e;
import com.baidu.adp.plugin.util.Util;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.kwad.sdk.collector.AppStatusRules;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PluginPackageManager {
    private boolean UB;
    private Hashtable<String, a> Uq;
    private String Us;
    private boolean Ut;
    private d Uz;
    private static int Uo = 43;
    private static int DEBUG_MODE = 2;
    private static volatile PluginPackageManager Up = null;
    private boolean Ur = false;
    private boolean isThirdProcess = false;
    private boolean isRemoteProcess = false;
    private long Uu = 0;
    private boolean isInit = false;
    private boolean Uv = false;
    private int Uw = 0;
    private final String Ux = "com.baidu.adp.plugin.currentpath";
    private final String Uy = "current_path";
    private BroadcastReceiver UC = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.1
        Map<String, Integer> installFailRetryMap = new HashMap();

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    String stringExtra = intent.getStringExtra("package_name");
                    String stringExtra2 = intent.getStringExtra("install_dest_file");
                    String stringExtra3 = intent.getStringExtra(SharedPrefConfig.VERSION_NAME);
                    int intExtra = intent.getIntExtra("version_code", 0);
                    String stringExtra4 = intent.getStringExtra("require_load");
                    boolean booleanExtra = intent.getBooleanExtra("is_inject_classloader", false);
                    String stringExtra5 = intent.getStringExtra("cmd_range");
                    String stringExtra6 = intent.getStringExtra("install_flag");
                    PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(stringExtra);
                    if (findPluginSetting == null) {
                        findPluginSetting = new PluginSetting();
                        findPluginSetting.forbidden = false;
                    }
                    if (PluginPackageManager.this.Ur && this.installFailRetryMap.containsKey(findPluginSetting.packageName)) {
                        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "re_install_success", stringExtra, "retry_at_num_" + this.installFailRetryMap.get(findPluginSetting.packageName));
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
                    if (PluginPackageManager.this.Ur) {
                        com.baidu.adp.plugin.b.a.pe().a("plugin_install_suc", stringExtra, findPluginSetting, "");
                        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "plugin_install_suc", stringExtra, "flag=" + stringExtra6 + "_fail=" + findPluginSetting.install_fail_count);
                        if (intExtra < PluginPackageManager.Uo) {
                            com.baidu.adp.plugin.b.a.pe().B("plugin_launch_lowversion", stringExtra);
                            com.baidu.adp.plugin.b.a.pe().f("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
                        }
                    }
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.url = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.hasRes = intent.getBooleanExtra("has_res", false);
                    findPluginSetting.isThird = intent.getBooleanExtra("is_third", false);
                    findPluginSetting.isPatch = intent.getBooleanExtra("is_patch", false);
                    findPluginSetting.replaceMethodClasses = intent.getStringExtra("replace_method_classes");
                    findPluginSetting.setInjectClassloader(booleanExtra);
                    PluginPackageManager.this.d(findPluginSetting);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(stringExtra, findPluginSetting, PluginPackageManager.this.Ur);
                    boolean z = false;
                    if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z) {
                        PluginCenter.getInstance().launch(findPluginSetting.packageName);
                    }
                    PluginPackageManager.this.b(stringExtra, true, (String) null);
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    String stringExtra7 = intent.getStringExtra("install_src_file");
                    if (stringExtra7 != null) {
                        String substring = stringExtra7.substring(stringExtra7.lastIndexOf("/") + 1, stringExtra7.lastIndexOf(".apk"));
                        String stringExtra8 = intent.getStringExtra("fail_reason");
                        String stringExtra9 = intent.getStringExtra("install_comment");
                        String stringExtra10 = intent.getStringExtra("package_name");
                        String stringExtra11 = intent.getStringExtra("install_flag");
                        PluginSetting pluginSetting = null;
                        if (!TextUtils.isEmpty(stringExtra10)) {
                            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(stringExtra10);
                            if ("apk_not_exist".equals(stringExtra8) && pluginSetting != null && pluginSetting.installStatus == 0 && pluginSetting.tempVersionCode == 0) {
                                com.baidu.adp.plugin.b.a.pe().f("plugin_install", "intercept_apk_not_exist", stringExtra10, stringExtra11 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + stringExtra7);
                                return;
                            } else if ("assets_not_found".equals(stringExtra8)) {
                                com.baidu.adp.plugin.b.a.pe().f("plugin_install", "assets_not_found", stringExtra10, stringExtra11 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + stringExtra9);
                                return;
                            } else {
                                if (pluginSetting == null) {
                                    pluginSetting = new PluginSetting();
                                    pluginSetting.packageName = stringExtra10;
                                }
                                pluginSetting.enable = false;
                                if (PluginPackageManager.this.Ur) {
                                    pluginSetting.install_fail_count++;
                                    if (pluginSetting.install_fail_count >= 5) {
                                        PluginPackageManager.this.d(pluginSetting);
                                        pluginSetting.tempVersionCode = 0;
                                        pluginSetting.url = "";
                                        pluginSetting.tempMd5 = "";
                                        pluginSetting.install_fail_count = 0;
                                        pluginSetting.installStatus = 0;
                                    }
                                    if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.ns().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_PLUGIN, 3)) {
                                        BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_PLUGIN, "package name = " + stringExtra10 + "; fail count = " + pluginSetting.install_fail_count);
                                    }
                                }
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(stringExtra10, pluginSetting, PluginPackageManager.this.Ur);
                            }
                        }
                        PluginPackageManager.this.b(substring, false, stringExtra8);
                        if (PluginPackageManager.this.Ur) {
                            if (stringExtra9 != null) {
                                String lowerCase = stringExtra9.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                    stringExtra8 = "rom_size";
                                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                    stringExtra8 = "read_file_system";
                                    com.baidu.adp.plugin.b.a.pe().B("plugin_read_file_sys", stringExtra10);
                                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                    stringExtra8 = "permission_denied";
                                    com.baidu.adp.plugin.b.a.pe().B("plugin_permission_denied", stringExtra10);
                                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    stringExtra8 = "fsync_failed";
                                    com.baidu.adp.plugin.b.a.pe().B("plugin_fsync_failed", stringExtra10);
                                }
                            }
                            if ("rom_size".equals(stringExtra8)) {
                                com.baidu.adp.plugin.b.a.pe().B("plugin_rom_small", stringExtra10);
                            }
                            com.baidu.adp.plugin.b.a.pe().b("plugin_install_fail", stringExtra10, pluginSetting, stringExtra8);
                            com.baidu.adp.plugin.b.a.pe().h("plugin_install", stringExtra8, stringExtra10, stringExtra9 + "_flag=" + stringExtra11);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    String stringExtra12 = intent.getStringExtra("package_name");
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(stringExtra12);
                    if (findPluginSetting2 != null) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().i(stringExtra12, true);
                        if (findPluginSetting2.versionCode < PluginPackageManager.Uo) {
                            com.baidu.adp.plugin.b.a.pe().B("plugin_launch_lowversion", stringExtra12);
                            com.baidu.adp.plugin.b.a.pe().f("plugin_load", "load_lowversion", stringExtra12, "broadcast_cancel-" + findPluginSetting2.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.installStatus);
                        }
                    } else {
                        com.baidu.adp.plugin.b.a.pe().f("plugin_install", "install_cancel_settingnull", stringExtra12, null);
                    }
                    PluginPackageManager.this.b(stringExtra12, true, (String) null);
                } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                    String stringExtra13 = intent.getStringExtra("fail_reason");
                    String stringExtra14 = intent.getStringExtra("package_name");
                    if (!TextUtils.isEmpty(stringExtra14)) {
                        PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(stringExtra14);
                        if (findPluginSetting3 == null) {
                            findPluginSetting3 = new PluginSetting();
                            findPluginSetting3.packageName = stringExtra14;
                        }
                        findPluginSetting3.enable = false;
                        if (PluginPackageManager.this.Ur && "low_version_code".equals(stringExtra13)) {
                            PluginPackageManager.this.d(findPluginSetting3);
                            findPluginSetting3.tempVersionCode = 0;
                            findPluginSetting3.url = "";
                            findPluginSetting3.tempMd5 = "";
                            findPluginSetting3.install_fail_count = 0;
                            findPluginSetting3.installStatus = 0;
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(stringExtra14, findPluginSetting3, PluginPackageManager.this.Ur);
                        if ("low_version_code".equals(stringExtra13)) {
                            com.baidu.adp.plugin.b.a.pe().B("plugin_low_version_code", stringExtra14);
                        }
                    }
                }
            }
        }
    };
    private BroadcastReceiver UD = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            boolean z = true;
            if (intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
                Bundle resultExtras = getResultExtras(true);
                String str2 = "";
                if (resultExtras != null) {
                    str2 = resultExtras.getString("package_name");
                }
                String str3 = "";
                if (!TextUtils.isEmpty(str2) && resultExtras != null) {
                    str3 = resultExtras.getString("current_path");
                    str = str2;
                } else if (intent.getExtras() != null) {
                    str = intent.getExtras().getString("package_name");
                    str3 = intent.getExtras().getString("current_path");
                } else {
                    str = str2;
                }
                String str4 = "";
                if (PluginCenter.getInstance().getPlugin(str) != null) {
                    str4 = PluginCenter.getInstance().getPlugin(str).getPluginApkFilePath();
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = str4;
                    } else {
                        String[] split = str3.split(",");
                        int length = split.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = false;
                                break;
                            } else if (split[i].equals(str4)) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z) {
                            str3 = str3 + "," + str4;
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("package_name", str);
                bundle.putString("current_path", str3);
                setResultExtras(bundle);
                if (PluginPackageManager.this.Ur) {
                    PluginPackageManager.this.E(str, str3);
                }
            }
        }
    };
    private a.c Ub = new a.c() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4
        @Override // com.baidu.adp.plugin.packageManager.a.c
        public void D(String str, String str2) {
            PluginSetting findPluginSetting;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str)) != null) {
                if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                    com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().cJ(str);
                } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                    String[] split = findPluginSetting.getAbandon_apk_path().split(",");
                    String str3 = "";
                    for (String str4 : split) {
                        if (!str2.equals(str4)) {
                            if (!TextUtils.isEmpty(str3)) {
                                str3 = str3 + ",";
                            }
                            str3 = str3 + str4;
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().b(str, str3, PluginPackageManager.this.Ur);
                }
            }
        }
    };
    private com.baidu.adp.plugin.install.a Tl = new com.baidu.adp.plugin.install.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.6
        @Override // com.baidu.adp.plugin.install.a
        public void onInstallFinish(boolean z) {
            if (z) {
                if (PluginPackageManager.pv().isMainProcess()) {
                    PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
                    com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "version_update_suc", null, PluginPackageManager.this.Us + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (pU == null ? "" : pU.getContainerVersion()));
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().cI(PluginPackageManager.this.Us);
                if (PluginPackageManager.pv().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.pe().d("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.Uu);
                }
            } else if (PluginPackageManager.pv().isMainProcess()) {
                PluginSettings pU2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
                com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "version_update_fail", null, PluginPackageManager.this.Us + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (pU2 == null ? "" : pU2.getContainerVersion()));
            }
            PluginPackageManager.this.pC();
            PluginPackageManager.this.av(true);
        }

        @Override // com.baidu.adp.plugin.install.a
        public void cm(String str) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().i(str, true);
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str);
            if (findPluginSetting != null && findPluginSetting.versionCode < PluginPackageManager.Uo) {
                com.baidu.adp.plugin.b.a.pe().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.pe().f("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a UE = new com.baidu.adp.plugin.packageManager.pluginServerConfig.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.9
        @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
        public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            if (PluginPackageManager.DEBUG_MODE != 1) {
                if (z && pluginNetConfigInfos != null) {
                    String str2 = "";
                    if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                        List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                        PluginPackageManager.this.a(cVar, configs);
                        str2 = PluginPackageManager.this.o(configs);
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().setForbiddenFeatures(str2);
                    PluginPackageManager.this.UB = false;
                    if (PluginPackageManager.this.Ur) {
                        MessageManager.getInstance().unRegisterListener(PluginPackageManager.this.UG);
                    }
                } else {
                    if (!k.isEmpty(str)) {
                        com.baidu.adp.plugin.b.a.pe().f("plugin_syncConfig", "plugin_syncConfigs_fail", null, str);
                    }
                    PluginPackageManager.this.UB = true;
                    PluginPackageManager.this.pN();
                }
            }
            PluginPackageManager.this.pF();
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a UF = new com.baidu.adp.plugin.packageManager.pluginFileDownload.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.10
        private Map<String, Long> UN = new HashMap();

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean d(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void e(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.Uz != null) {
                PluginPackageManager.this.Uz.a(bdFileDownloadData);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean f(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void g(final BdFileDownloadData bdFileDownloadData) {
            String id;
            PluginSetting findPluginSetting;
            if (PluginPackageManager.this.Uz != null) {
                PluginPackageManager.this.Uz.b(bdFileDownloadData);
            }
            if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().p(id, a.b.Vb);
                if (this.UN.containsKey(id)) {
                    com.baidu.adp.plugin.b.a.pe().f("plugin_download", "re-download-success", id, "costTimes:" + String.valueOf(System.currentTimeMillis() - this.UN.get(id).longValue()));
                    this.UN.remove(id);
                }
                com.baidu.adp.plugin.b.a.pe().A("plugin_download", bdFileDownloadData.getId());
                if (Util.M(findPluginSetting.size)) {
                    if (PluginPackageManager.this.Uz != null) {
                        a aVar = new a();
                        aVar.packageName = id;
                        aVar.timestamp = System.currentTimeMillis();
                        aVar.UR = new com.baidu.adp.plugin.install.b() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.10.1
                            @Override // com.baidu.adp.plugin.install.b
                            public void cn(String str) {
                                if (PluginPackageManager.this.Uz != null) {
                                    PluginPackageManager.this.Uz.a(bdFileDownloadData, 0, "");
                                }
                            }

                            @Override // com.baidu.adp.plugin.install.b
                            public void y(String str, String str2) {
                                String str3;
                                if (PluginPackageManager.this.Uz != null) {
                                    if ("rom_size".equals(str2)) {
                                        str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
                                    } else {
                                        str3 = "";
                                    }
                                    PluginPackageManager.this.Uz.a(bdFileDownloadData, -1, str3);
                                }
                            }
                        };
                        PluginPackageManager.this.Uq.put(id, aVar);
                    }
                    PluginPackageManager.this.h(Util.f(findPluginSetting), findPluginSetting.packageName, "install_from_download");
                    return;
                }
                com.baidu.adp.plugin.install.d.e(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.qi()));
                if (PluginPackageManager.this.Uz != null) {
                    PluginPackageManager.this.Uz.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
            if (PluginPackageManager.this.Uz != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i);
                PluginPackageManager.this.Uz.c(bdFileDownloadData);
            }
            PluginPackageManager.this.pN();
            if (bdFileDownloadData != null) {
                if (!this.UN.containsKey(bdFileDownloadData.getId())) {
                    this.UN.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
                }
                com.baidu.adp.plugin.b.a.pe().i("plugin_download_fail", bdFileDownloadData.getId(), String.valueOf(i), str2);
            }
        }
    };
    private CustomMessageListener UG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.2
        private int UH;
        private long lastCallTime;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PluginPackageManager.this.isInit && j.isNetWorkAvailable()) {
                if (this.UH < 3) {
                    PluginPackageManager.this.av(PluginPackageManager.this.UB);
                    this.UH++;
                    this.lastCallTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.lastCallTime > AppStatusRules.DEFAULT_GRANULARITY) {
                    PluginPackageManager.this.av(PluginPackageManager.this.UB);
                    this.UH = 0;
                    this.lastCallTime = System.currentTimeMillis();
                }
            }
        }
    };
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR
    }

    public static final int pu() {
        return Uo;
    }

    public static PluginPackageManager pv() {
        if (Up == null) {
            synchronized (PluginPackageManager.class) {
                if (Up == null) {
                    Up = new PluginPackageManager();
                }
            }
        }
        return Up;
    }

    private PluginPackageManager() {
        this.Uq = null;
        this.Uq = new Hashtable<>();
        oN();
    }

    private void oN() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            this.mContext.registerReceiver(this.UC, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean pw() {
        return this.Uv;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean cv = cv(str);
        boolean co = com.baidu.adp.plugin.install.c.oM().co(str);
        if (cv && !co) {
            bVar.cn(str);
        } else {
            a aVar = new a();
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.UR = bVar;
            synchronized (this) {
                if (this.Uq.size() < 1000) {
                    this.Uq.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        px();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, String str2) {
        a remove;
        if (!StringUtils.isNull(str) && (remove = this.Uq.remove(str)) != null && remove.UR != null) {
            if (z) {
                remove.UR.cn(str);
            } else {
                remove.UR.y(remove.packageName, str2);
            }
        }
    }

    private void px() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Uq.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.UR != null) {
                        value.UR.y(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean cv(String str) {
        return cA(str);
    }

    public PluginSetting cw(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str);
    }

    public void h(String str, String str2, String str3) {
        File file;
        if (this.Ur) {
            com.baidu.adp.plugin.b.a.pe().a("plugin_install", str2, null, str3);
            if (!Util.M(new File(str).length())) {
                com.baidu.adp.plugin.install.d.e(str, str2, "rom_size", String.valueOf(Util.qi()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.oM().w(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.pe().f("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void py() {
        if (this.Ur) {
            com.baidu.adp.plugin.install.c.oM().a(this.mContext, this.Tl);
        }
    }

    private void cx(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.po().a(arrayList, this.Ub);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b UR;
        String packageName;
        long timestamp;

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean pz() {
        PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
        if (pU == null || pU.getPlugins() == null || F(this.Us, pU.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : pU.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pU.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                return true;
            }
            while (r5.hasNext()) {
            }
        }
        return false;
    }

    private void a(PluginSettings pluginSettings) {
        List<PluginSetting> pluginSettingsSortLoadPriorty;
        if (pluginSettings != null && pluginSettings.getPlugins() != null && (pluginSettingsSortLoadPriorty = pluginSettings.getPluginSettingsSortLoadPriorty()) != null) {
            for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pluginSettings.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                    try {
                        if (Util.qg()) {
                            Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                            if (launch != null && !launch.isSucc) {
                                com.baidu.adp.plugin.b.a.pe().log("patch_launch_failed");
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                        com.baidu.adp.plugin.b.a.pe().h("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                        return;
                    }
                }
            }
        }
    }

    public void pA() {
        PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
        if (pU != null && !F(this.Us, pU.getContainerVersion())) {
            a(pU);
        }
    }

    public void a(String str, boolean z, boolean z2, boolean z3) {
        this.Ur = z;
        this.isThirdProcess = z2;
        this.isRemoteProcess = z3;
        this.Us = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            Uo = com.baidu.adp.lib.f.b.toInt(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), Uo);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a((e) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z, final Object obj) {
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "begin");
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.pe().log("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.pP().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().a(bVar2);
        this.isInit = true;
        PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
        if (pU == null || (pU != null && F(this.Us, pU.getContainerVersion()))) {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "install_buildin_plugin-" + this.Us + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (pU == null ? "settings_is_null" : pU.getContainerVersion()));
            this.Uu = System.currentTimeMillis();
            if (pv().isMainProcess()) {
                com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "version_update", null, this.Us + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (pU == null ? "" : pU.getContainerVersion()));
            }
            pD();
            py();
        } else {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin");
            if ((com.baidu.adp.lib.OrmObject.a.a.getValueForField(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
                BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        Object valueForField = com.baidu.adp.lib.OrmObject.a.a.getValueForField(Looper.getMainLooper(), "sThreadLocal");
                        if (valueForField instanceof ThreadLocal) {
                            ((ThreadLocal) valueForField).set(Looper.getMainLooper());
                        }
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin#2");
                            PluginPackageManager.this.y(obj);
                            return null;
                        }
                        com.baidu.adp.plugin.b.a.pe().log("plugin_asyncinit_fail");
                        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin#3");
                                PluginPackageManager.this.y(obj);
                            }
                        });
                        return null;
                    }
                };
                bdAsyncTask.setPriority(4);
                bdAsyncTask.execute(new Void[0]);
            } else {
                com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin#1");
                y(obj);
            }
        }
        pB();
        pE();
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Object obj) {
        pC();
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
        if (Build.VERSION.SDK_INT > 10) {
            av(true);
        }
    }

    private void pB() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Ur) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.UD, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Ur) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.Vc)) {
                    Intent intent = new Intent("com.baidu.adp.plugin.currentpath");
                    Bundle bundle = new Bundle();
                    bundle.putString("package_name", value.packageName);
                    bundle.putString("current_path", "");
                    intent.putExtras(bundle);
                    this.mContext.sendOrderedBroadcast(intent, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.Vc && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.pe().g("plugin_del_unuse", "server forbidden", str);
                cx(str);
            } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = str2.split(",");
                String[] split2 = findPluginSetting.getAbandon_apk_path().split(",");
                HashMap hashMap = new HashMap();
                ArrayList<a.b> arrayList = new ArrayList<>();
                for (String str3 : split) {
                    hashMap.put(str3, "");
                }
                for (String str4 : split2) {
                    if (hashMap.get(str4) == null) {
                        arrayList.add(new a.b(str, str4));
                    }
                }
                com.baidu.adp.plugin.packageManager.a.po().a(arrayList, this.Ub);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC() {
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "begin");
        PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
        if (pU == null) {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "PluginSettings_is_null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<PluginSetting> pluginSettingsSortLoadPriorty = pU.getPluginSettingsSortLoadPriorty();
        if (pluginSettingsSortLoadPriorty == null || pluginSettingsSortLoadPriorty.isEmpty()) {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "PluginSetting_list_is_null");
            return;
        }
        int i = 0;
        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
            if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                if (!pluginSetting.isPatch || this.Uw <= 0) {
                    if (pluginSetting.enable && pluginSetting.installStatus != a.b.Vc) {
                        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch");
                        if (!this.isRemoteProcess || "com.baidu.tieba.pluginCore".equals(pluginSetting.packageName) || "com.baidu.tieba.pluginExtend".equals(pluginSetting.packageName)) {
                            Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                            Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                            if (!launch.isSucc && (plugin2 == null || !plugin2.isLoaded())) {
                                com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_fail-reason_" + launch.reason + "-comment_" + launch.comment);
                            } else {
                                com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_success");
                            }
                            if (!launch.isSucc && plugin2 != null && !plugin2.isLoaded()) {
                                i++;
                                if (pv().isMainProcess()) {
                                    if (sb.length() > 0) {
                                        sb.append(",");
                                    }
                                    sb.append(pluginSetting.packageName);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.apkPath);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.forbidden);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.enable);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.installStatus);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.versionCode);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.install_fail_count);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(pluginSetting.getAbandon_apk_path());
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(launch.reason);
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb.append(launch.comment);
                                }
                            }
                        }
                    }
                    i = i;
                }
            }
        }
        if (pv().isMainProcess() && i > 0) {
            com.baidu.adp.plugin.b.a.pe().f("plugin_load", "load_allplugin", null, sb.toString());
        }
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "end");
    }

    private void pD() {
        if (this.Ur) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().aw(false);
        }
    }

    public void av(final boolean z) {
        if (this.Ur) {
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.7
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU(), z, PluginPackageManager.this.UE);
                }
            }, 1500L);
        }
    }

    private void pE() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_MIS_UPDATE, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PluginSettings pU;
                PluginNetConfigInfos pS;
                List<PluginNetConfigInfos.PluginConfig> configs;
                boolean z = false;
                Object data = customResponsedMessage.getData();
                if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU()) != null) {
                    if (pU == null || !PluginPackageManager.this.F(PluginPackageManager.this.Us, pU.getContainerVersion())) {
                        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
                        if (!TextUtils.isEmpty(pluginConfig.package_name) && (pS = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS()) != null && (configs = pS.getConfigs()) != null) {
                            int i = 0;
                            while (true) {
                                if (i >= configs.size()) {
                                    z = true;
                                    break;
                                } else if (!configs.get(i).package_name.equals(pluginConfig.package_name)) {
                                    i++;
                                } else {
                                    configs.set(i, pluginConfig);
                                    break;
                                }
                            }
                            if (z) {
                                configs.add(pluginConfig);
                            }
                            PluginPackageManager.this.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().b(com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU()), pluginConfig);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().setForbiddenFeatures(PluginPackageManager.this.o(configs));
                            PluginPackageManager.this.pF();
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> pQ;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.Vb) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.Ur) {
                    com.baidu.adp.plugin.b.a.pe().f("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                }
            }
            pluginSetting.priority = pluginConfig.priority;
            pluginSetting.load_priority = pluginConfig.load_priority;
            pluginSetting.ext = pluginConfig.ext;
            pluginSetting.rollback = 0;
            if (!TextUtils.isEmpty(pluginSetting.ext) && pluginSetting.ext.contains("rollback")) {
                try {
                    pluginSetting.rollback = new JSONObject(pluginSetting.ext).getInt("rollback");
                } catch (Throwable th) {
                    com.baidu.adp.plugin.b.a.pe().f("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().i(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().p(pluginConfig.package_name, a.b.Vc);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < Uo && this.Ur) {
                    com.baidu.adp.plugin.b.a.pe().f("plugin_install", "server_config_versionlower", pluginConfig.package_name, Uo + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginSetting.versionCode + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().i(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (pQ = cVar.pQ()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(pQ)) {
                                    if (basicNameValuePair != null && TextUtils.equals(basicNameValuePair.getName(), pluginConfig.package_name)) {
                                        str = basicNameValuePair.getValue();
                                        break;
                                    }
                                }
                            }
                            str = null;
                            if (str == null) {
                                str = "";
                            }
                            if (pluginConfig.newest == null) {
                                com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.pe().f("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().i(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().p(pluginConfig.package_name, a.b.Vc);
                        }
                    } else {
                        pluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                            pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            pluginSetting.url = pluginConfig.newest.url;
                            pluginSetting.tempMd5 = pluginConfig.newest.md5;
                            pluginSetting.install_fail_count = 0;
                            pluginSetting.installStatus = 0;
                            pluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == a.C0022a.Va) {
                                pluginSetting.installStatus = a.b.Vd;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0022a.WIFI) {
                                    pluginSetting.installStatus = a.b.Ve;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        }
                    }
                } else {
                    if (pluginSetting.versionCode == 0) {
                        pluginSetting.enable = false;
                    } else {
                        pluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                        pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                        pluginSetting.url = pluginConfig.newest.url;
                        pluginSetting.tempMd5 = pluginConfig.newest.md5;
                        pluginSetting.install_fail_count = 0;
                        pluginSetting.installStatus = 0;
                        pluginSetting.size = pluginConfig.newest.size;
                        if (pluginConfig.newest.download_type == a.C0022a.Va) {
                            pluginSetting.installStatus = a.b.Vd;
                        } else if (pluginConfig.newest.download_type == a.C0022a.WIFI) {
                            pluginSetting.installStatus = a.b.Ve;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.oM().n(pluginSetting.packageName, pluginSetting.rollback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            a(cVar, pluginConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o(List<PluginNetConfigInfos.PluginConfig> list) {
        String str;
        if (list == null) {
            return "";
        }
        String str2 = "";
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                str = pluginConfig.forbidden_features;
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + "," + str;
                    }
                    str2 = str;
                }
            }
            str = str2;
            str2 = str;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF() {
        PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
        if (pU != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : pU.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null) {
                    a(value, arrayList);
                }
            }
            Iterator<PluginSetting> it = arrayList.iterator();
            while (it.hasNext()) {
                PluginSetting next = it.next();
                if (next != null) {
                    b(next);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, ArrayList<PluginSetting> arrayList) {
        if (arrayList != null && pluginSetting != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                PluginSetting pluginSetting2 = arrayList.get(i);
                if (pluginSetting2 != null && pluginSetting2.priority > pluginSetting.priority) {
                    break;
                }
                i++;
            }
            arrayList.add(i, pluginSetting);
        }
    }

    private void b(PluginSetting pluginSetting) {
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            if (pluginSetting.versionCode <= 0) {
                pluginSetting.enable = false;
                com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().i(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.Vc) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.Vb) {
                        h(Util.f(pluginSetting), pluginSetting.packageName, "install_from_setting");
                        return;
                    } else if ((pluginSetting.installStatus == a.b.Ve && j.isWifiNet()) || pluginSetting.installStatus == a.b.Vd) {
                        c(pluginSetting);
                        return;
                    } else {
                        return;
                    }
                }
                if (pluginSetting.versionCode == pluginSetting.tempVersionCode && pluginSetting.versionCode > 0 && !pluginSetting.enable) {
                    pluginSetting.enable = true;
                    pluginSetting.tempMd5 = "";
                    pluginSetting.url = "";
                    pluginSetting.tempVersionCode = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().cK(pluginSetting.packageName);
                    if (pluginSetting.versionCode < Uo) {
                        com.baidu.adp.plugin.b.a.pe().B("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.pe().f("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.Ur && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            bdFileDownloadData.setSize(pluginSetting.size);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.M(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.pe().g("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.pP().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.pP().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.UF, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Ur) {
            c.pt().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.Uz = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.I(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void cy(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().cy(str);
    }

    public void cz(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().cz(str);
    }

    public String pG() {
        return this.Us;
    }

    public boolean isMainProcess() {
        return this.Ur;
    }

    public boolean pH() {
        return this.isThirdProcess;
    }

    public boolean cA(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean cB(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU().isFeatureForbidden(str);
    }

    public boolean cC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos pS = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS();
        if (pS != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = pS.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(str);
        if (findPluginSetting != null) {
            int i2 = findPluginSetting.versionCode;
            if (i2 < i || i2 < findPluginSetting.tempVersionCode) {
                return true;
            }
        } else if (i > 0) {
            return true;
        }
        return false;
    }

    public void a(PluginNetConfigInfos.PluginConfig pluginConfig, d dVar) {
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            if (pluginConfig.newest == null || pluginConfig.newest.version_code <= 0 || TextUtils.isEmpty(pluginConfig.newest.url)) {
                if (dVar != null) {
                    dVar.c(new BdFileDownloadData(pluginConfig.package_name));
                }
                if (pluginConfig.newest == null) {
                    return;
                }
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().a(findPluginSetting.packageName, findPluginSetting);
            this.Uz = dVar;
            a(findPluginSetting, this.UF, true);
        }
    }

    public boolean pI() {
        return pK() && !this.Ut;
    }

    public void pJ() {
        this.Ut = true;
    }

    public boolean pK() {
        PluginSettings pU = com.baidu.adp.plugin.packageManager.pluginSettings.c.pX().pU();
        if (pU == null || pU.getPlugins() == null || pU.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : pU.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && cC(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos pS;
        if (TextUtils.isEmpty(str) || (pS = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS()) == null) {
            return null;
        }
        return pS.getPluginConfig(str);
    }

    public void cD(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.pP().cG(str);
        }
    }

    public boolean cE(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.pP().cE(str);
    }

    public void pL() {
        if (this.isInit) {
            b.pq().au(this.Ur);
        }
    }

    public void aK(int i) {
        this.Uw = i;
    }

    public int pM() {
        return this.Uw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN() {
        if (this.Ur) {
            MessageManager.getInstance().unRegisterListener(this.UG);
            MessageManager.getInstance().registerListener(this.UG);
        }
    }
}
