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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.webkit.internal.ETAG;
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
    private static int La = 43;
    private static int Lb = 2;
    private static volatile PluginPackageManager Lc = null;
    private Hashtable<String, a> Ld;
    private String Le;
    private boolean Lf;
    private d Ll;
    private boolean Lm;
    private boolean isMainProcess = false;
    private boolean isThirdProcess = false;
    private long Lg = 0;
    private boolean isInit = false;
    private boolean Lh = false;
    private int Li = 0;
    private final String Lj = "com.baidu.adp.plugin.currentpath";
    private final String Lk = "current_path";
    private BroadcastReceiver Ln = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.1
        Map<String, Integer> installFailRetryMap = new HashMap();

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    String stringExtra = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                    String stringExtra2 = intent.getStringExtra("install_dest_file");
                    String stringExtra3 = intent.getStringExtra("version_name");
                    int intExtra = intent.getIntExtra("version_code", 0);
                    String stringExtra4 = intent.getStringExtra("require_load");
                    boolean booleanExtra = intent.getBooleanExtra("is_inject_classloader", false);
                    String stringExtra5 = intent.getStringExtra("cmd_range");
                    PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(stringExtra);
                    if (findPluginSetting == null) {
                        findPluginSetting = new PluginSetting();
                        findPluginSetting.forbidden = false;
                    }
                    if (findPluginSetting.install_fail_count > 0) {
                        com.baidu.adp.plugin.b.a.mN().I("plugin_install_suc_fail", stringExtra);
                    }
                    if (PluginPackageManager.this.isMainProcess && this.installFailRetryMap.containsKey(findPluginSetting.packageName)) {
                        com.baidu.adp.plugin.b.a.mN().f("plugin_install", "re_install_success", stringExtra, "retry_at_num_" + this.installFailRetryMap.get(findPluginSetting.packageName));
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
                    PluginPackageManager.this.d(findPluginSetting);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(stringExtra, findPluginSetting, PluginPackageManager.this.isMainProcess);
                    boolean z = false;
                    if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z) {
                        PluginCenter.getInstance().launch(findPluginSetting.packageName);
                    }
                    PluginPackageManager.this.b(stringExtra, true, (String) null);
                    if (PluginPackageManager.this.isMainProcess) {
                        com.baidu.adp.plugin.b.a.mN().e("plugin_install_suc", stringExtra, findPluginSetting);
                        if (intExtra < PluginPackageManager.La) {
                            com.baidu.adp.plugin.b.a.mN().I("plugin_launch_lowversion", stringExtra);
                            com.baidu.adp.plugin.b.a.mN().f("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    String stringExtra6 = intent.getStringExtra("install_src_file");
                    if (stringExtra6 != null) {
                        String substring = stringExtra6.substring(stringExtra6.lastIndexOf("/") + 1, stringExtra6.lastIndexOf(".apk"));
                        String stringExtra7 = intent.getStringExtra("fail_reason");
                        String stringExtra8 = intent.getStringExtra("install_comment");
                        String stringExtra9 = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                        PluginSetting pluginSetting = null;
                        if (!TextUtils.isEmpty(stringExtra9)) {
                            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(stringExtra9);
                            if (pluginSetting == null) {
                                pluginSetting = new PluginSetting();
                                pluginSetting.packageName = stringExtra9;
                            }
                            pluginSetting.enable = false;
                            if (PluginPackageManager.this.isMainProcess) {
                                pluginSetting.install_fail_count++;
                                if (pluginSetting.install_fail_count >= 5) {
                                    PluginPackageManager.this.d(pluginSetting);
                                    pluginSetting.tempVersionCode = 0;
                                    pluginSetting.url = "";
                                    pluginSetting.tempMd5 = "";
                                    pluginSetting.install_fail_count = 0;
                                    pluginSetting.installStatus = 0;
                                }
                                if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.ko().getMaxAlertCount("alert_plugin", 3)) {
                                    BdStatisticsManager.getInstance().alert("alert_plugin", "package name = " + stringExtra9 + "; fail count = " + pluginSetting.install_fail_count);
                                }
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(stringExtra9, pluginSetting, PluginPackageManager.this.isMainProcess);
                        }
                        PluginPackageManager.this.b(substring, false, stringExtra7);
                        if (PluginPackageManager.this.isMainProcess) {
                            if (stringExtra8 != null) {
                                String lowerCase = stringExtra8.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                    stringExtra7 = "rom_size";
                                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                    stringExtra7 = "read_file_system";
                                    com.baidu.adp.plugin.b.a.mN().I("plugin_read_file_sys", stringExtra9);
                                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                    stringExtra7 = "permission_denied";
                                    com.baidu.adp.plugin.b.a.mN().I("plugin_permission_denied", stringExtra9);
                                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    stringExtra7 = "fsync_failed";
                                    com.baidu.adp.plugin.b.a.mN().I("plugin_fsync_failed", stringExtra9);
                                }
                            }
                            if ("rom_size".equals(stringExtra7)) {
                                com.baidu.adp.plugin.b.a.mN().I("plugin_rom_small", stringExtra9);
                            }
                            com.baidu.adp.plugin.b.a.mN().a("plugin_install_fail", stringExtra9, pluginSetting, stringExtra7);
                            com.baidu.adp.plugin.b.a.mN().g("plugin_install", stringExtra7, stringExtra9, stringExtra8);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    String stringExtra10 = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(stringExtra10);
                    if (findPluginSetting2 != null) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().i(stringExtra10, true);
                        if (findPluginSetting2.versionCode < PluginPackageManager.La) {
                            com.baidu.adp.plugin.b.a.mN().I("plugin_launch_lowversion", stringExtra10);
                            com.baidu.adp.plugin.b.a.mN().f("plugin_load", "load_lowversion", stringExtra10, "broadcast_cancel-" + findPluginSetting2.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.installStatus);
                        }
                    } else {
                        com.baidu.adp.plugin.b.a.mN().f("plugin_install", "install_cancel_settingnull", stringExtra10, null);
                    }
                    PluginPackageManager.this.b(stringExtra10, true, (String) null);
                } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                    String stringExtra11 = intent.getStringExtra("fail_reason");
                    String stringExtra12 = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                    if (!TextUtils.isEmpty(stringExtra12)) {
                        PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(stringExtra12);
                        if (findPluginSetting3 == null) {
                            findPluginSetting3 = new PluginSetting();
                            findPluginSetting3.packageName = stringExtra12;
                        }
                        findPluginSetting3.enable = false;
                        if (PluginPackageManager.this.isMainProcess && "low_version_code".equals(stringExtra11)) {
                            PluginPackageManager.this.d(findPluginSetting3);
                            findPluginSetting3.tempVersionCode = 0;
                            findPluginSetting3.url = "";
                            findPluginSetting3.tempMd5 = "";
                            findPluginSetting3.install_fail_count = 0;
                            findPluginSetting3.installStatus = 0;
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(stringExtra12, findPluginSetting3, PluginPackageManager.this.isMainProcess);
                        if ("low_version_code".equals(stringExtra11)) {
                            com.baidu.adp.plugin.b.a.mN().I("plugin_low_version_code", stringExtra12);
                        }
                    }
                }
            }
        }
    };
    private BroadcastReceiver Lo = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            boolean z = true;
            if (intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
                Bundle resultExtras = getResultExtras(true);
                String str3 = "";
                if (resultExtras != null) {
                    str3 = resultExtras.getString(ETAG.KEY_PACKAGE_NAME);
                }
                if (!TextUtils.isEmpty(str3) && resultExtras != null) {
                    str = str3;
                    str2 = resultExtras.getString("current_path");
                } else if (intent.getExtras() == null) {
                    str = str3;
                    str2 = "";
                } else {
                    str = intent.getExtras().getString(ETAG.KEY_PACKAGE_NAME);
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
                        String[] split = str2.split(",");
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
                            str2 = str2 + "," + str4;
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString(ETAG.KEY_PACKAGE_NAME, str);
                bundle.putString("current_path", str2);
                setResultExtras(bundle);
                if (PluginPackageManager.this.isMainProcess) {
                    PluginPackageManager.this.M(str, str2);
                }
            }
        }
    };
    private a.c KN = new a.c() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.3
        @Override // com.baidu.adp.plugin.packageManager.a.c
        public void K(String str, String str2) {
            PluginSetting findPluginSetting;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str)) != null) {
                if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                    com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().cj(str);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().b(str, str3, PluginPackageManager.this.isMainProcess);
                }
            }
        }
    };
    private com.baidu.adp.plugin.install.a JY = new com.baidu.adp.plugin.install.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5
        @Override // com.baidu.adp.plugin.install.a
        public void onInstallFinish(boolean z) {
            if (z) {
                if (PluginPackageManager.nd().isMainProcess()) {
                    PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
                    com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "version_update_suc", null, PluginPackageManager.this.Le + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (nD == null ? "" : nD.getContainerVersion()));
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().ci(PluginPackageManager.this.Le);
                if (PluginPackageManager.nd().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.mN().f("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.Lg);
                }
            } else if (PluginPackageManager.nd().isMainProcess()) {
                PluginSettings nD2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
                com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "version_update_fail", null, PluginPackageManager.this.Le + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (nD2 == null ? "" : nD2.getContainerVersion()));
            }
            PluginPackageManager.this.loadPlugin();
            PluginPackageManager.this.ap(true);
        }

        @Override // com.baidu.adp.plugin.install.a
        public void bJ(String str) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().i(str, true);
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str);
            if (findPluginSetting != null && findPluginSetting.versionCode < PluginPackageManager.La) {
                com.baidu.adp.plugin.b.a.mN().I("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.mN().f("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a Lp = new com.baidu.adp.plugin.packageManager.pluginServerConfig.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.7
        @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
        public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
            if (PluginPackageManager.Lb != 1) {
                if (!z || pluginNetConfigInfos == null) {
                    PluginPackageManager.this.Lm = true;
                    PluginPackageManager.this.nv();
                } else {
                    String str = "";
                    if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                        List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                        PluginPackageManager.this.a(cVar, configs);
                        str = PluginPackageManager.this.k(configs);
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().setForbiddenFeatures(str);
                    PluginPackageManager.this.Lm = false;
                }
            }
            PluginPackageManager.this.nn();
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a Lq = new com.baidu.adp.plugin.packageManager.pluginFileDownload.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8
        private Map<String, Long> Lt = new HashMap();

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean d(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void e(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.Ll != null) {
                PluginPackageManager.this.Ll.a(bdFileDownloadData);
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
            if (PluginPackageManager.this.Ll != null) {
                PluginPackageManager.this.Ll.b(bdFileDownloadData);
            }
            if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
                com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().s(id, a.b.LJ);
                if (this.Lt.containsKey(id)) {
                    com.baidu.adp.plugin.b.a.mN().f("plugin_download", "re-download-success", id, "costTimes:" + String.valueOf(System.currentTimeMillis() - this.Lt.get(id).longValue()));
                    this.Lt.remove(id);
                }
                com.baidu.adp.plugin.b.a.mN().H("plugin_download", bdFileDownloadData.getId());
                if (Util.t(findPluginSetting.size)) {
                    if (PluginPackageManager.this.Ll != null) {
                        a aVar = new a();
                        aVar.packageName = id;
                        aVar.timestamp = System.currentTimeMillis();
                        aVar.Lx = new com.baidu.adp.plugin.install.b() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8.1
                            @Override // com.baidu.adp.plugin.install.b
                            public void bK(String str) {
                                if (PluginPackageManager.this.Ll != null) {
                                    PluginPackageManager.this.Ll.a(bdFileDownloadData, 0, "");
                                }
                            }

                            @Override // com.baidu.adp.plugin.install.b
                            public void G(String str, String str2) {
                                String str3;
                                if (PluginPackageManager.this.Ll != null) {
                                    if ("rom_size".equals(str2)) {
                                        str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
                                    } else {
                                        str3 = "";
                                    }
                                    PluginPackageManager.this.Ll.a(bdFileDownloadData, -1, str3);
                                }
                            }
                        };
                        PluginPackageManager.this.Ld.put(id, aVar);
                    }
                    PluginPackageManager.this.L(Util.f(findPluginSetting), findPluginSetting.packageName);
                    return;
                }
                com.baidu.adp.plugin.install.d.e(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.nS()));
                if (PluginPackageManager.this.Ll != null) {
                    PluginPackageManager.this.Ll.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
            if (PluginPackageManager.this.Ll != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i);
                PluginPackageManager.this.Ll.c(bdFileDownloadData);
            }
            PluginPackageManager.this.nv();
            if (bdFileDownloadData != null) {
                if (!this.Lt.containsKey(bdFileDownloadData.getId())) {
                    this.Lt.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
                }
                com.baidu.adp.plugin.b.a.mN().g("plugin_download", String.valueOf(i), bdFileDownloadData.getId(), str2);
            }
        }
    };
    private CustomMessageListener Lr = new CustomMessageListener(2000994) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.9
        private int Lw;
        private long lastCallTime;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PluginPackageManager.this.isInit && j.kV()) {
                if (this.Lw < 3) {
                    PluginPackageManager.this.ap(PluginPackageManager.this.Lm);
                    this.Lw++;
                    this.lastCallTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.lastCallTime > 60000) {
                    PluginPackageManager.this.ap(PluginPackageManager.this.Lm);
                    this.Lw = 0;
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

    public static final int nc() {
        return La;
    }

    public static PluginPackageManager nd() {
        if (Lc == null) {
            synchronized (PluginPackageManager.class) {
                if (Lc == null) {
                    Lc = new PluginPackageManager();
                }
            }
        }
        return Lc;
    }

    private PluginPackageManager() {
        this.Ld = null;
        this.Ld = new Hashtable<>();
        mw();
    }

    private void mw() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.Ln, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean ne() {
        return this.Lh;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bT = bT(str);
        boolean bL = com.baidu.adp.plugin.install.c.mv().bL(str);
        if (bT && !bL) {
            bVar.bK(str);
        } else {
            a aVar = new a();
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.Lx = bVar;
            synchronized (this) {
                if (this.Ld.size() < 1000) {
                    this.Ld.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        nf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, String str2) {
        a remove;
        if (!StringUtils.isNull(str) && (remove = this.Ld.remove(str)) != null && remove.Lx != null) {
            if (z) {
                remove.Lx.bK(str);
            } else {
                remove.Lx.G(remove.packageName, str2);
            }
        }
    }

    private void nf() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Ld.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= KeepJobService.JOB_CHECK_PERIODIC) {
                    if (value.Lx != null) {
                        value.Lx.G(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bT(String str) {
        return bY(str);
    }

    public PluginSetting bU(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str);
    }

    public void L(String str, String str2) {
        File file;
        if (this.isMainProcess) {
            com.baidu.adp.plugin.b.a.mN().e("plugin_install", str2, null);
            if (!Util.t(new File(str).length())) {
                com.baidu.adp.plugin.install.d.e(str, str2, "rom_size", String.valueOf(Util.nS()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.mv().V(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.mN().f("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void ng() {
        if (this.isMainProcess) {
            com.baidu.adp.plugin.install.c.mv().a(this.mContext, this.JY);
        }
    }

    private void bV(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.mW().a(arrayList, this.KN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b Lx;
        String packageName;
        long timestamp;

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean nh() {
        PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
        if (nD == null || nD.getPlugins() == null || N(this.Le, nD.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : nD.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || nD.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
                            if (!Util.nQ()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.mN().bP("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.mN().bP("hook_failed");
                                        com.baidu.adp.plugin.b.a.mN().g("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.mN().g("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.Jr) {
                        com.baidu.adp.plugin.b.a.mN().bP("patch_launch_failed");
                    }
                }
            }
        }
    }

    public void ni() {
        PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
        if (nD != null && !N(this.Le, nD.getContainerVersion())) {
            a(nD);
        }
    }

    public void a(String str, boolean z, boolean z2) {
        this.isMainProcess = z;
        this.isThirdProcess = z2;
        this.Le = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            La = com.baidu.adp.lib.g.b.l(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), La);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a((e) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "begin");
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.mN().bP("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ny().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().a(bVar2);
        this.isInit = true;
        PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
        if (nD == null || (nD != null && N(this.Le, nD.getContainerVersion()))) {
            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "install_buildin_plugin-" + this.Le + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (nD == null ? "settings_is_null" : nD.getContainerVersion()));
            this.Lg = System.currentTimeMillis();
            if (nd().isMainProcess()) {
                com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "version_update", null, this.Le + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (nD == null ? "" : nD.getContainerVersion()));
            }
            nl();
            ng();
        } else {
            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "load_plugin");
            if ((com.baidu.adp.lib.OrmObject.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
                BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        Object c = com.baidu.adp.lib.OrmObject.a.a.c(Looper.getMainLooper(), "sThreadLocal");
                        if (c instanceof ThreadLocal) {
                            ((ThreadLocal) c).set(Looper.getMainLooper());
                        }
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "load_plugin#2");
                            PluginPackageManager.this.nj();
                            return null;
                        }
                        com.baidu.adp.plugin.b.a.mN().bP("plugin_asyncinit_fail");
                        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "load_plugin#3");
                                PluginPackageManager.this.nj();
                            }
                        });
                        return null;
                    }
                };
                bdAsyncTask.setPriority(4);
                bdAsyncTask.execute(new Void[0]);
            } else {
                com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "load_plugin#1");
                nj();
            }
        }
        nk();
        nm();
        com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadAllPlugins", "end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        loadPlugin();
        if (Build.VERSION.SDK_INT > 10) {
            ap(true);
        }
    }

    private void nk() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.isMainProcess) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.Lo, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.isMainProcess) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.LK)) {
                    Intent intent = new Intent("com.baidu.adp.plugin.currentpath");
                    Bundle bundle = new Bundle();
                    bundle.putString(ETAG.KEY_PACKAGE_NAME, value.packageName);
                    bundle.putString("current_path", "");
                    intent.putExtras(bundle);
                    this.mContext.sendOrderedBroadcast(intent, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.LK && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.mN().g("plugin_del_unuse", "server forbidden", str);
                bV(str);
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
                com.baidu.adp.plugin.packageManager.a.mW().a(arrayList, this.KN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPlugin() {
        com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", "begin");
        PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
        if (nD == null) {
            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", "PluginSettings_is_null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<PluginSetting> pluginSettingsSortLoadPriorty = nD.getPluginSettingsSortLoadPriorty();
        if (pluginSettingsSortLoadPriorty == null || pluginSettingsSortLoadPriorty.isEmpty()) {
            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", "PluginSetting_list_is_null");
            return;
        }
        int i = 0;
        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
            if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                if (!pluginSetting.isPatch || this.Li <= 0) {
                    if (pluginSetting.enable && pluginSetting.installStatus != a.b.LK) {
                        com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch");
                        Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                        Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                        if (!launch.Jr && (plugin2 == null || !plugin2.isLoaded())) {
                            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_fail-reason_" + launch.reason + "-comment_" + launch.Jt);
                        } else {
                            com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_success");
                        }
                        if (!launch.Jr && plugin2 != null && !plugin2.isLoaded()) {
                            i++;
                            if (nd().isMainProcess()) {
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
                                sb.append(launch.Jt);
                            }
                        }
                    }
                    i = i;
                }
            }
        }
        if (nd().isMainProcess()) {
            if (i > 0) {
                com.baidu.adp.plugin.b.a.mN().f("plugin_load", "load_allplugin", null, sb.toString());
            }
            PluginCenter.getInstance().logPluginLoadStat();
        }
        com.baidu.adp.plugin.b.b.J("PluginPackageManager_loadPlugin", "end");
    }

    private void nl() {
        if (this.isMainProcess) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().aq(false);
        }
    }

    public void ap(boolean z) {
        if (this.isMainProcess) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD(), z, this.Lp);
        }
    }

    private void nm() {
        MessageManager.getInstance().registerListener(2000987, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PluginSettings nD;
                PluginNetConfigInfos nB;
                List<PluginNetConfigInfos.PluginConfig> configs;
                boolean z = false;
                Object data = customResponsedMessage.getData();
                if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD()) != null) {
                    if (nD == null || !PluginPackageManager.this.N(PluginPackageManager.this.Le, nD.getContainerVersion())) {
                        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
                        if (!TextUtils.isEmpty(pluginConfig.package_name) && (nB = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB()) != null && (configs = nB.getConfigs()) != null) {
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
                            PluginPackageManager.this.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().b(com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD()), pluginConfig);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().setForbiddenFeatures(PluginPackageManager.this.k(configs));
                            PluginPackageManager.this.nn();
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
        List<BasicNameValuePair> nz;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.LJ) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.isMainProcess) {
                    com.baidu.adp.plugin.b.a.mN().f("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.mN().f("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().i(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().s(pluginConfig.package_name, a.b.LK);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < La && this.isMainProcess) {
                    com.baidu.adp.plugin.b.a.mN().f("plugin_install", "server_config_versionlower", pluginConfig.package_name, La + BaseRequestAction.SPLITE + pluginSetting.versionCode + BaseRequestAction.SPLITE + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().i(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (nz = cVar.nz()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(nz)) {
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
                                com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.mN().f("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().i(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().s(pluginConfig.package_name, a.b.LK);
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
                            if (pluginConfig.newest.download_type == a.C0023a.LI) {
                                pluginSetting.installStatus = a.b.LM;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0023a.WIFI) {
                                    pluginSetting.installStatus = a.b.LN;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0023a.LI) {
                            pluginSetting.installStatus = a.b.LM;
                        } else if (pluginConfig.newest.download_type == a.C0023a.WIFI) {
                            pluginSetting.installStatus = a.b.LN;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.mv().q(pluginSetting.packageName, pluginSetting.rollback);
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
    public String k(List<PluginNetConfigInfos.PluginConfig> list) {
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
    public void nn() {
        PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
        if (nD != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : nD.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().i(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.LK) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.LJ) {
                        L(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.LN && j.kW()) || pluginSetting.installStatus == a.b.LM) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().ck(pluginSetting.packageName);
                    if (pluginSetting.versionCode < La) {
                        com.baidu.adp.plugin.b.a.mN().I("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.mN().f("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.isMainProcess && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.t(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.mN().g("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ny().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ny().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.Lq, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.isMainProcess) {
            c.nb().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.Ll = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.Q(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bW(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().bW(str);
    }

    public void bX(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().bX(str);
    }

    public String no() {
        return this.Le;
    }

    public boolean isMainProcess() {
        return this.isMainProcess;
    }

    public boolean np() {
        return this.isThirdProcess;
    }

    public boolean bY(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bZ(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD().isFeatureForbidden(str);
    }

    public boolean ca(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos nB = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB();
        if (nB != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = nB.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().a(findPluginSetting.packageName, findPluginSetting);
            this.Ll = dVar;
            a(findPluginSetting, this.Lq, true);
        }
    }

    public boolean nq() {
        return ns() && !this.Lf;
    }

    public void nr() {
        this.Lf = true;
    }

    public boolean ns() {
        PluginSettings nD = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().nD();
        if (nD == null || nD.getPlugins() == null || nD.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : nD.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && ca(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos nB;
        if (TextUtils.isEmpty(str) || (nB = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB()) == null) {
            return null;
        }
        return nB.getPluginConfig(str);
    }

    public void cb(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ny().cf(str);
        }
    }

    public boolean cc(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ny().cc(str);
    }

    public PluginStatus cd(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.nG().findPluginSetting(str);
        if (findPluginSetting == null) {
            return PluginStatus.DISABLE;
        }
        if (findPluginSetting.forbidden && findPluginSetting.enable) {
            return PluginStatus.FORBIDDEN;
        }
        if (findPluginSetting.versionCode == 0 && findPluginSetting.tempVersionCode > 0) {
            return PluginStatus.UNINSTALLED;
        }
        if (!findPluginSetting.enable) {
            return PluginStatus.DISABLE;
        }
        return PluginStatus.NROMAL;
    }

    public void nt() {
        if (this.isInit) {
            b.mY().clear(this.isMainProcess);
        }
    }

    public void aZ(int i) {
        this.Li = i;
    }

    public int nu() {
        return this.Li;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv() {
        if (this.isMainProcess) {
            MessageManager.getInstance().unRegisterListener(this.Lr);
            MessageManager.getInstance().registerListener(this.Lr);
        }
    }
}
