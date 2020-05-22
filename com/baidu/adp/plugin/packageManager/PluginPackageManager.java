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
import com.baidu.adp.plugin.PluginNative;
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
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
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
    private Hashtable<String, a> RH;
    private String RJ;
    private boolean RK;
    private d RT;
    private boolean RU;
    private static int RF = 43;
    private static int DEBUG_MODE = 2;
    private static volatile PluginPackageManager RG = null;
    private boolean RI = false;
    private boolean isThirdProcess = false;
    private boolean isRemoteProcess = false;
    private long RL = 0;
    private boolean isInit = false;
    private boolean RO = false;
    private int RP = 0;
    private final String RQ = "com.baidu.adp.plugin.currentpath";
    private final String RR = "current_path";
    private BroadcastReceiver RV = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.1
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
                    PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(stringExtra);
                    if (findPluginSetting == null) {
                        findPluginSetting = new PluginSetting();
                        findPluginSetting.forbidden = false;
                    }
                    if (PluginPackageManager.this.RI && this.installFailRetryMap.containsKey(findPluginSetting.packageName)) {
                        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "re_install_success", stringExtra, "retry_at_num_" + this.installFailRetryMap.get(findPluginSetting.packageName));
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
                    if (PluginPackageManager.this.RI) {
                        com.baidu.adp.plugin.b.a.nH().a("plugin_install_suc", stringExtra, findPluginSetting, "");
                        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "plugin_install_suc", stringExtra, "flag=" + stringExtra6 + "_fail=" + findPluginSetting.install_fail_count);
                        if (intExtra < PluginPackageManager.RF) {
                            com.baidu.adp.plugin.b.a.nH().D("plugin_launch_lowversion", stringExtra);
                            com.baidu.adp.plugin.b.a.nH().f("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(stringExtra, findPluginSetting, PluginPackageManager.this.RI);
                    boolean z = false;
                    if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z) {
                        PluginCenter.getInstance().launch(findPluginSetting.packageName);
                    }
                    PluginPackageManager.this.a(stringExtra, true, (String) null);
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
                            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(stringExtra10);
                            if ("apk_not_exist".equals(stringExtra8) && pluginSetting != null && pluginSetting.installStatus == 0 && pluginSetting.tempVersionCode == 0) {
                                com.baidu.adp.plugin.b.a.nH().f("plugin_install", "intercept_apk_not_exist", stringExtra10, stringExtra11 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + stringExtra7);
                                return;
                            } else if ("assets_not_found".equals(stringExtra8)) {
                                com.baidu.adp.plugin.b.a.nH().f("plugin_install", "assets_not_found", stringExtra10, stringExtra11 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + stringExtra9);
                                return;
                            } else {
                                if (pluginSetting == null) {
                                    pluginSetting = new PluginSetting();
                                    pluginSetting.packageName = stringExtra10;
                                }
                                pluginSetting.enable = false;
                                if (PluginPackageManager.this.RI) {
                                    pluginSetting.install_fail_count++;
                                    if (pluginSetting.install_fail_count >= 5) {
                                        PluginPackageManager.this.d(pluginSetting);
                                        pluginSetting.tempVersionCode = 0;
                                        pluginSetting.url = "";
                                        pluginSetting.tempMd5 = "";
                                        pluginSetting.install_fail_count = 0;
                                        pluginSetting.installStatus = 0;
                                    }
                                    if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.lX().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_PLUGIN, 3)) {
                                        BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_PLUGIN, "package name = " + stringExtra10 + "; fail count = " + pluginSetting.install_fail_count);
                                    }
                                }
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(stringExtra10, pluginSetting, PluginPackageManager.this.RI);
                            }
                        }
                        PluginPackageManager.this.a(substring, false, stringExtra8);
                        if (PluginPackageManager.this.RI) {
                            if (stringExtra9 != null) {
                                String lowerCase = stringExtra9.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                    stringExtra8 = "rom_size";
                                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                    stringExtra8 = "read_file_system";
                                    com.baidu.adp.plugin.b.a.nH().D("plugin_read_file_sys", stringExtra10);
                                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                    stringExtra8 = "permission_denied";
                                    com.baidu.adp.plugin.b.a.nH().D("plugin_permission_denied", stringExtra10);
                                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    stringExtra8 = "fsync_failed";
                                    com.baidu.adp.plugin.b.a.nH().D("plugin_fsync_failed", stringExtra10);
                                }
                            }
                            if ("rom_size".equals(stringExtra8)) {
                                com.baidu.adp.plugin.b.a.nH().D("plugin_rom_small", stringExtra10);
                            }
                            com.baidu.adp.plugin.b.a.nH().b("plugin_install_fail", stringExtra10, pluginSetting, stringExtra8);
                            com.baidu.adp.plugin.b.a.nH().h("plugin_install", stringExtra8, stringExtra10, stringExtra9 + "_flag=" + stringExtra11);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    String stringExtra12 = intent.getStringExtra("package_name");
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(stringExtra12);
                    if (findPluginSetting2 != null) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().i(stringExtra12, true);
                        if (findPluginSetting2.versionCode < PluginPackageManager.RF) {
                            com.baidu.adp.plugin.b.a.nH().D("plugin_launch_lowversion", stringExtra12);
                            com.baidu.adp.plugin.b.a.nH().f("plugin_load", "load_lowversion", stringExtra12, "broadcast_cancel-" + findPluginSetting2.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.installStatus);
                        }
                    } else {
                        com.baidu.adp.plugin.b.a.nH().f("plugin_install", "install_cancel_settingnull", stringExtra12, null);
                    }
                    PluginPackageManager.this.a(stringExtra12, true, (String) null);
                } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                    String stringExtra13 = intent.getStringExtra("fail_reason");
                    String stringExtra14 = intent.getStringExtra("package_name");
                    if (!TextUtils.isEmpty(stringExtra14)) {
                        PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(stringExtra14);
                        if (findPluginSetting3 == null) {
                            findPluginSetting3 = new PluginSetting();
                            findPluginSetting3.packageName = stringExtra14;
                        }
                        findPluginSetting3.enable = false;
                        if (PluginPackageManager.this.RI && "low_version_code".equals(stringExtra13)) {
                            PluginPackageManager.this.d(findPluginSetting3);
                            findPluginSetting3.tempVersionCode = 0;
                            findPluginSetting3.url = "";
                            findPluginSetting3.tempMd5 = "";
                            findPluginSetting3.install_fail_count = 0;
                            findPluginSetting3.installStatus = 0;
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(stringExtra14, findPluginSetting3, PluginPackageManager.this.RI);
                        if ("low_version_code".equals(stringExtra13)) {
                            com.baidu.adp.plugin.b.a.nH().D("plugin_low_version_code", stringExtra14);
                        }
                    }
                }
            }
        }
    };
    private BroadcastReceiver RW = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            boolean z = true;
            if (intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
                Bundle resultExtras = getResultExtras(true);
                String str3 = "";
                if (resultExtras != null) {
                    str3 = resultExtras.getString("package_name");
                }
                if (!TextUtils.isEmpty(str3) && resultExtras != null) {
                    str = str3;
                    str2 = resultExtras.getString("current_path");
                } else if (intent.getExtras() == null) {
                    str = str3;
                    str2 = "";
                } else {
                    str = intent.getExtras().getString("package_name");
                    str2 = intent.getExtras().getString("current_path");
                }
                String str4 = "";
                if (PluginCenter.getInstance().getPlugin(str) != null) {
                    str4 = PluginCenter.getInstance().getPlugin(str).getPluginApkFilePath();
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = str4;
                    } else {
                        String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            str2 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str4;
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("package_name", str);
                bundle.putString("current_path", str2);
                setResultExtras(bundle);
                if (PluginPackageManager.this.RI) {
                    PluginPackageManager.this.G(str, str2);
                }
            }
        }
    };
    private a.c Rs = new a.c() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4
        @Override // com.baidu.adp.plugin.packageManager.a.c
        public void F(String str, String str2) {
            PluginSetting findPluginSetting;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str)) != null) {
                if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                    com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().cE(str);
                } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                    String[] split = findPluginSetting.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    String str3 = "";
                    for (String str4 : split) {
                        if (!str2.equals(str4)) {
                            if (!TextUtils.isEmpty(str3)) {
                                str3 = str3 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                            }
                            str3 = str3 + str4;
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().b(str, str3, PluginPackageManager.this.RI);
                }
            }
        }
    };
    private com.baidu.adp.plugin.install.a QC = new com.baidu.adp.plugin.install.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.6
        @Override // com.baidu.adp.plugin.install.a
        public void onInstallFinish(boolean z) {
            if (z) {
                if (PluginPackageManager.nX().isMainProcess()) {
                    PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
                    com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "version_update_suc", null, PluginPackageManager.this.RJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ox == null ? "" : ox.getContainerVersion()));
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().cD(PluginPackageManager.this.RJ);
                if (PluginPackageManager.nX().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.nH().e("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.RL);
                }
            } else if (PluginPackageManager.nX().isMainProcess()) {
                PluginSettings ox2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
                com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "version_update_fail", null, PluginPackageManager.this.RJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ox2 == null ? "" : ox2.getContainerVersion()));
            }
            PluginPackageManager.this.oe();
            PluginPackageManager.this.av(true);
        }

        @Override // com.baidu.adp.plugin.install.a
        public void ch(String str) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().i(str, true);
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str);
            if (findPluginSetting != null && findPluginSetting.versionCode < PluginPackageManager.RF) {
                com.baidu.adp.plugin.b.a.nH().D("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.nH().f("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a RX = new com.baidu.adp.plugin.packageManager.pluginServerConfig.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.9
        @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
        public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            if (PluginPackageManager.DEBUG_MODE != 1) {
                if (z && pluginNetConfigInfos != null) {
                    String str2 = "";
                    if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                        List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                        PluginPackageManager.this.a(cVar, configs);
                        str2 = PluginPackageManager.this.l(configs);
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().setForbiddenFeatures(str2);
                    PluginPackageManager.this.RU = false;
                    if (PluginPackageManager.this.RI) {
                        MessageManager.getInstance().unRegisterListener(PluginPackageManager.this.RZ);
                    }
                } else {
                    if (!k.isEmpty(str)) {
                        com.baidu.adp.plugin.b.a.nH().f("plugin_syncConfig", "plugin_syncConfigs_fail", null, str);
                    }
                    PluginPackageManager.this.RU = true;
                    PluginPackageManager.this.oq();
                }
            }
            PluginPackageManager.this.oi();
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a RY = new com.baidu.adp.plugin.packageManager.pluginFileDownload.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.10
        private Map<String, Long> Sf = new HashMap();

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean d(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void e(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.RT != null) {
                PluginPackageManager.this.RT.a(bdFileDownloadData);
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
            if (PluginPackageManager.this.RT != null) {
                PluginPackageManager.this.RT.b(bdFileDownloadData);
            }
            if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().o(id, a.b.Ss);
                if (this.Sf.containsKey(id)) {
                    com.baidu.adp.plugin.b.a.nH().f("plugin_download", "re-download-success", id, "costTimes:" + String.valueOf(System.currentTimeMillis() - this.Sf.get(id).longValue()));
                    this.Sf.remove(id);
                }
                com.baidu.adp.plugin.b.a.nH().C("plugin_download", bdFileDownloadData.getId());
                if (Util.O(findPluginSetting.size)) {
                    if (PluginPackageManager.this.RT != null) {
                        a aVar = new a();
                        aVar.packageName = id;
                        aVar.timestamp = System.currentTimeMillis();
                        aVar.Si = new com.baidu.adp.plugin.install.b() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.10.1
                            @Override // com.baidu.adp.plugin.install.b
                            public void ci(String str) {
                                if (PluginPackageManager.this.RT != null) {
                                    PluginPackageManager.this.RT.a(bdFileDownloadData, 0, "");
                                }
                            }

                            @Override // com.baidu.adp.plugin.install.b
                            public void A(String str, String str2) {
                                String str3;
                                if (PluginPackageManager.this.RT != null) {
                                    if ("rom_size".equals(str2)) {
                                        str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
                                    } else {
                                        str3 = "";
                                    }
                                    PluginPackageManager.this.RT.a(bdFileDownloadData, -1, str3);
                                }
                            }
                        };
                        PluginPackageManager.this.RH.put(id, aVar);
                    }
                    PluginPackageManager.this.h(Util.f(findPluginSetting), findPluginSetting.packageName, "install_from_download");
                    return;
                }
                com.baidu.adp.plugin.install.d.e(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.oL()));
                if (PluginPackageManager.this.RT != null) {
                    PluginPackageManager.this.RT.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
            if (PluginPackageManager.this.RT != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i);
                PluginPackageManager.this.RT.c(bdFileDownloadData);
            }
            PluginPackageManager.this.oq();
            if (bdFileDownloadData != null) {
                if (!this.Sf.containsKey(bdFileDownloadData.getId())) {
                    this.Sf.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
                }
                com.baidu.adp.plugin.b.a.nH().i("plugin_download_fail", bdFileDownloadData.getId(), String.valueOf(i), str2);
            }
        }
    };
    private CustomMessageListener RZ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.2
        private int Sa;
        private long lastCallTime;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PluginPackageManager.this.isInit && j.isNetWorkAvailable()) {
                if (this.Sa < 3) {
                    PluginPackageManager.this.av(PluginPackageManager.this.RU);
                    this.Sa++;
                    this.lastCallTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.lastCallTime > 60000) {
                    PluginPackageManager.this.av(PluginPackageManager.this.RU);
                    this.Sa = 0;
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

    public static final int nW() {
        return RF;
    }

    public static PluginPackageManager nX() {
        if (RG == null) {
            synchronized (PluginPackageManager.class) {
                if (RG == null) {
                    RG = new PluginPackageManager();
                }
            }
        }
        return RG;
    }

    private PluginPackageManager() {
        this.RH = null;
        this.RH = new Hashtable<>();
        nq();
    }

    private void nq() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            this.mContext.registerReceiver(this.RV, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean nY() {
        return this.RO;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean cq = cq(str);
        boolean cj = com.baidu.adp.plugin.install.c.np().cj(str);
        if (cq && !cj) {
            bVar.ci(str);
        } else {
            a aVar = new a();
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.Si = bVar;
            synchronized (this) {
                if (this.RH.size() < 1000) {
                    this.RH.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        nZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove;
        if (!StringUtils.isNull(str) && (remove = this.RH.remove(str)) != null && remove.Si != null) {
            if (z) {
                remove.Si.ci(str);
            } else {
                remove.Si.A(remove.packageName, str2);
            }
        }
    }

    private void nZ() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.RH.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= KeepJobService.JOB_CHECK_PERIODIC) {
                    if (value.Si != null) {
                        value.Si.A(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean cq(String str) {
        return cv(str);
    }

    public PluginSetting cr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str);
    }

    public void h(String str, String str2, String str3) {
        File file;
        if (this.RI) {
            com.baidu.adp.plugin.b.a.nH().a("plugin_install", str2, null, str3);
            if (!Util.O(new File(str).length())) {
                com.baidu.adp.plugin.install.d.e(str, str2, "rom_size", String.valueOf(Util.oL()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.np().w(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.nH().f("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void oa() {
        if (this.RI) {
            com.baidu.adp.plugin.install.c.np().a(this.mContext, this.QC);
        }
    }

    private void cs(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.nQ().a(arrayList, this.Rs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b Si;
        String packageName;
        long timestamp;

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ob() {
        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
        if (ox == null || ox.getPlugins() == null || H(this.RJ, ox.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : ox.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || ox.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
            boolean z = true;
            for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pluginSettings.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                    if (z) {
                        try {
                            if (!Util.oJ()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.nH().log("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.nH().log("hook_failed");
                                        com.baidu.adp.plugin.b.a.nH().h("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.nH().h("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.isSucc) {
                        com.baidu.adp.plugin.b.a.nH().log("patch_launch_failed");
                    }
                }
            }
        }
    }

    public void oc() {
        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
        if (ox != null && !H(this.RJ, ox.getContainerVersion())) {
            a(ox);
        }
    }

    public void a(String str, boolean z, boolean z2, boolean z3) {
        this.RI = z;
        this.isThirdProcess = z2;
        this.isRemoteProcess = z3;
        this.RJ = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            RF = com.baidu.adp.lib.f.b.toInt(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), RF);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a((e) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z, final Object obj) {
        com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "begin");
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.nH().log("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.os().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().a(bVar2);
        this.isInit = true;
        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
        if (ox == null || (ox != null && H(this.RJ, ox.getContainerVersion()))) {
            com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "install_buildin_plugin-" + this.RJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ox == null ? "settings_is_null" : ox.getContainerVersion()));
            this.RL = System.currentTimeMillis();
            if (nX().isMainProcess()) {
                com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "version_update", null, this.RJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ox == null ? "" : ox.getContainerVersion()));
            }
            og();
            oa();
        } else {
            com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "load_plugin");
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
                            com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "load_plugin#2");
                            PluginPackageManager.this.A(obj);
                            return null;
                        }
                        com.baidu.adp.plugin.b.a.nH().log("plugin_asyncinit_fail");
                        com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "load_plugin#3");
                                PluginPackageManager.this.A(obj);
                            }
                        });
                        return null;
                    }
                };
                bdAsyncTask.setPriority(4);
                bdAsyncTask.execute(new Void[0]);
            } else {
                com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "load_plugin#1");
                A(obj);
            }
        }
        od();
        oh();
        com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadAllPlugins", "end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Object obj) {
        oe();
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
        if (Build.VERSION.SDK_INT > 10) {
            av(true);
        }
    }

    private void od() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.RI) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.RW, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.RI) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.St)) {
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
    public void G(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.St && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.nH().g("plugin_del_unuse", "server forbidden", str);
                cs(str);
            } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String[] split2 = findPluginSetting.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                com.baidu.adp.plugin.packageManager.a.nQ().a(arrayList, this.Rs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe() {
        com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", "begin");
        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
        if (ox == null) {
            com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", "PluginSettings_is_null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<PluginSetting> pluginSettingsSortLoadPriorty = ox.getPluginSettingsSortLoadPriorty();
        if (pluginSettingsSortLoadPriorty == null || pluginSettingsSortLoadPriorty.isEmpty()) {
            com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", "PluginSetting_list_is_null");
            return;
        }
        int i = 0;
        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
            if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                if (!pluginSetting.isPatch || this.RP <= 0) {
                    if (pluginSetting.enable && pluginSetting.installStatus != a.b.St) {
                        com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch");
                        if (!this.isRemoteProcess || "com.baidu.tieba.pluginCore".equals(pluginSetting.packageName) || "com.baidu.tieba.pluginExtend".equals(pluginSetting.packageName)) {
                            Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                            Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                            if (!launch.isSucc && (plugin2 == null || !plugin2.isLoaded())) {
                                com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_fail-reason_" + launch.reason + "-comment_" + launch.PU);
                            } else {
                                com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_success");
                            }
                            if (!launch.isSucc && plugin2 != null && !plugin2.isLoaded()) {
                                i++;
                                if (nX().isMainProcess()) {
                                    if (sb.length() > 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                                    sb.append(launch.PU);
                                }
                            }
                        }
                    }
                    i = i;
                }
            }
        }
        if (nX().isMainProcess() && i > 0) {
            com.baidu.adp.plugin.b.a.nH().f("plugin_load", "load_allplugin", null, sb.toString());
        }
        com.baidu.adp.plugin.b.b.E("PluginPackageManager_loadPlugin", "end");
    }

    private void og() {
        if (this.RI) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().aw(false);
        }
    }

    public void av(final boolean z) {
        if (this.RI) {
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.7
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox(), z, PluginPackageManager.this.RX);
                }
            }, 1500L);
        }
    }

    private void oh() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_MIS_UPDATE, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PluginSettings ox;
                PluginNetConfigInfos ov;
                List<PluginNetConfigInfos.PluginConfig> configs;
                boolean z = false;
                Object data = customResponsedMessage.getData();
                if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox()) != null) {
                    if (ox == null || !PluginPackageManager.this.H(PluginPackageManager.this.RJ, ox.getContainerVersion())) {
                        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
                        if (!TextUtils.isEmpty(pluginConfig.package_name) && (ov = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov()) != null && (configs = ov.getConfigs()) != null) {
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
                            PluginPackageManager.this.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().b(com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox()), pluginConfig);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().setForbiddenFeatures(PluginPackageManager.this.l(configs));
                            PluginPackageManager.this.oi();
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
        List<BasicNameValuePair> ot;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.Ss) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.RI) {
                    com.baidu.adp.plugin.b.a.nH().f("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.nH().f("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().i(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().o(pluginConfig.package_name, a.b.St);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < RF && this.RI) {
                    com.baidu.adp.plugin.b.a.nH().f("plugin_install", "server_config_versionlower", pluginConfig.package_name, RF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginSetting.versionCode + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().i(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (ot = cVar.ot()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(ot)) {
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
                                com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.nH().f("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().i(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().o(pluginConfig.package_name, a.b.St);
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
                            if (pluginConfig.newest.download_type == a.C0028a.Sr) {
                                pluginSetting.installStatus = a.b.Su;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0028a.WIFI) {
                                    pluginSetting.installStatus = a.b.Sv;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0028a.Sr) {
                            pluginSetting.installStatus = a.b.Su;
                        } else if (pluginConfig.newest.download_type == a.C0028a.WIFI) {
                            pluginSetting.installStatus = a.b.Sv;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.np().m(pluginSetting.packageName, pluginSetting.rollback);
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
    public String l(List<PluginNetConfigInfos.PluginConfig> list) {
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
                        str = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str;
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
    public void oi() {
        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
        if (ox != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : ox.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().i(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.St) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.Ss) {
                        h(Util.f(pluginSetting), pluginSetting.packageName, "install_from_setting");
                        return;
                    } else if ((pluginSetting.installStatus == a.b.Sv && j.isWifiNet()) || pluginSetting.installStatus == a.b.Su) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().cF(pluginSetting.packageName);
                    if (pluginSetting.versionCode < RF) {
                        com.baidu.adp.plugin.b.a.nH().D("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.nH().f("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.RI && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            bdFileDownloadData.setSize(pluginSetting.size);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.O(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.nH().g("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.os().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.os().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.RY, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.RI) {
            c.nV().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.RT = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.K(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void ct(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ct(str);
    }

    public void cu(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().cu(str);
    }

    public String oj() {
        return this.RJ;
    }

    public boolean isMainProcess() {
        return this.RI;
    }

    public boolean ok() {
        return this.isThirdProcess;
    }

    public boolean cv(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean cw(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox().isFeatureForbidden(str);
    }

    public boolean cx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos ov = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov();
        if (ov != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = ov.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().a(findPluginSetting.packageName, findPluginSetting);
            this.RT = dVar;
            a(findPluginSetting, this.RY, true);
        }
    }

    public boolean ol() {
        return on() && !this.RK;
    }

    public void om() {
        this.RK = true;
    }

    public boolean on() {
        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
        if (ox == null || ox.getPlugins() == null || ox.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : ox.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && cx(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos ov;
        if (TextUtils.isEmpty(str) || (ov = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov()) == null) {
            return null;
        }
        return ov.getPluginConfig(str);
    }

    public void cy(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.os().cB(str);
        }
    }

    public boolean cz(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.os().cz(str);
    }

    public void oo() {
        if (this.isInit) {
            b.nS().au(this.RI);
        }
    }

    public void ar(int i) {
        this.RP = i;
    }

    public int op() {
        return this.RP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        if (this.RI) {
            MessageManager.getInstance().unRegisterListener(this.RZ);
            MessageManager.getInstance().registerListener(this.RZ);
        }
    }
}
