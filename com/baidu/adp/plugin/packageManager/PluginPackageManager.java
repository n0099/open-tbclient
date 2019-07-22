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
    private static int Jf = 43;
    private static int Jg = 2;
    private static volatile PluginPackageManager Jh = null;
    private Hashtable<String, a> Ji;
    private String Jk;
    private boolean Jl;
    private d Jr;
    private boolean Js;
    private boolean Jj = false;
    private boolean isThirdProcess = false;
    private long Jm = 0;
    private boolean isInit = false;
    private boolean Jn = false;
    private int Jo = 0;
    private final String Jp = "com.baidu.adp.plugin.currentpath";
    private final String Jq = "current_path";
    private BroadcastReceiver Jt = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.1
        Map<String, Integer> installFailRetryMap = new HashMap();

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    String stringExtra = intent.getStringExtra(Constants.PACKAGE_NAME);
                    String stringExtra2 = intent.getStringExtra("install_dest_file");
                    String stringExtra3 = intent.getStringExtra("version_name");
                    int intExtra = intent.getIntExtra("version_code", 0);
                    String stringExtra4 = intent.getStringExtra("require_load");
                    boolean booleanExtra = intent.getBooleanExtra("is_inject_classloader", false);
                    String stringExtra5 = intent.getStringExtra("cmd_range");
                    PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(stringExtra);
                    if (findPluginSetting == null) {
                        findPluginSetting = new PluginSetting();
                        findPluginSetting.forbidden = false;
                    }
                    if (PluginPackageManager.this.Jj && this.installFailRetryMap.containsKey(findPluginSetting.packageName)) {
                        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "re_install_success", stringExtra, "retry_at_num_" + this.installFailRetryMap.get(findPluginSetting.packageName));
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
                    if (PluginPackageManager.this.Jj) {
                        com.baidu.adp.plugin.b.a.mc().e("plugin_install_suc", stringExtra, findPluginSetting);
                        if (intExtra < PluginPackageManager.Jf) {
                            com.baidu.adp.plugin.b.a.mc().B("plugin_launch_lowversion", stringExtra);
                            com.baidu.adp.plugin.b.a.mc().f("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(stringExtra, findPluginSetting, PluginPackageManager.this.Jj);
                    boolean z = false;
                    if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z) {
                        PluginCenter.getInstance().launch(findPluginSetting.packageName);
                    }
                    PluginPackageManager.this.b(stringExtra, true, (String) null);
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    String stringExtra6 = intent.getStringExtra("install_src_file");
                    if (stringExtra6 != null) {
                        String substring = stringExtra6.substring(stringExtra6.lastIndexOf("/") + 1, stringExtra6.lastIndexOf(".apk"));
                        String stringExtra7 = intent.getStringExtra("fail_reason");
                        String stringExtra8 = intent.getStringExtra("install_comment");
                        String stringExtra9 = intent.getStringExtra(Constants.PACKAGE_NAME);
                        PluginSetting pluginSetting = null;
                        if (!TextUtils.isEmpty(stringExtra9)) {
                            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(stringExtra9);
                            if (pluginSetting == null) {
                                pluginSetting = new PluginSetting();
                                pluginSetting.packageName = stringExtra9;
                            }
                            pluginSetting.enable = false;
                            if (PluginPackageManager.this.Jj) {
                                pluginSetting.install_fail_count++;
                                if (pluginSetting.install_fail_count >= 5) {
                                    PluginPackageManager.this.d(pluginSetting);
                                    pluginSetting.tempVersionCode = 0;
                                    pluginSetting.url = "";
                                    pluginSetting.tempMd5 = "";
                                    pluginSetting.install_fail_count = 0;
                                    pluginSetting.installStatus = 0;
                                }
                                if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.jt().getMaxAlertCount("alert_plugin", 3)) {
                                    BdStatisticsManager.getInstance().alert("alert_plugin", "package name = " + stringExtra9 + "; fail count = " + pluginSetting.install_fail_count);
                                }
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(stringExtra9, pluginSetting, PluginPackageManager.this.Jj);
                        }
                        PluginPackageManager.this.b(substring, false, stringExtra7);
                        if (PluginPackageManager.this.Jj) {
                            if (stringExtra8 != null) {
                                String lowerCase = stringExtra8.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                    stringExtra7 = "rom_size";
                                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                    stringExtra7 = "read_file_system";
                                    com.baidu.adp.plugin.b.a.mc().B("plugin_read_file_sys", stringExtra9);
                                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                    stringExtra7 = "permission_denied";
                                    com.baidu.adp.plugin.b.a.mc().B("plugin_permission_denied", stringExtra9);
                                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    stringExtra7 = "fsync_failed";
                                    com.baidu.adp.plugin.b.a.mc().B("plugin_fsync_failed", stringExtra9);
                                }
                            }
                            if ("rom_size".equals(stringExtra7)) {
                                com.baidu.adp.plugin.b.a.mc().B("plugin_rom_small", stringExtra9);
                            }
                            com.baidu.adp.plugin.b.a.mc().a("plugin_install_fail", stringExtra9, pluginSetting, stringExtra7);
                            com.baidu.adp.plugin.b.a.mc().g("plugin_install", stringExtra7, stringExtra9, stringExtra8);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    String stringExtra10 = intent.getStringExtra(Constants.PACKAGE_NAME);
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(stringExtra10);
                    if (findPluginSetting2 != null) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().f(stringExtra10, true);
                        if (findPluginSetting2.versionCode < PluginPackageManager.Jf) {
                            com.baidu.adp.plugin.b.a.mc().B("plugin_launch_lowversion", stringExtra10);
                            com.baidu.adp.plugin.b.a.mc().f("plugin_load", "load_lowversion", stringExtra10, "broadcast_cancel-" + findPluginSetting2.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.installStatus);
                        }
                    } else {
                        com.baidu.adp.plugin.b.a.mc().f("plugin_install", "install_cancel_settingnull", stringExtra10, null);
                    }
                    PluginPackageManager.this.b(stringExtra10, true, (String) null);
                } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                    String stringExtra11 = intent.getStringExtra("fail_reason");
                    String stringExtra12 = intent.getStringExtra(Constants.PACKAGE_NAME);
                    if (!TextUtils.isEmpty(stringExtra12)) {
                        PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(stringExtra12);
                        if (findPluginSetting3 == null) {
                            findPluginSetting3 = new PluginSetting();
                            findPluginSetting3.packageName = stringExtra12;
                        }
                        findPluginSetting3.enable = false;
                        if (PluginPackageManager.this.Jj && "low_version_code".equals(stringExtra11)) {
                            PluginPackageManager.this.d(findPluginSetting3);
                            findPluginSetting3.tempVersionCode = 0;
                            findPluginSetting3.url = "";
                            findPluginSetting3.tempMd5 = "";
                            findPluginSetting3.install_fail_count = 0;
                            findPluginSetting3.installStatus = 0;
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(stringExtra12, findPluginSetting3, PluginPackageManager.this.Jj);
                        if ("low_version_code".equals(stringExtra11)) {
                            com.baidu.adp.plugin.b.a.mc().B("plugin_low_version_code", stringExtra12);
                        }
                    }
                }
            }
        }
    };
    private BroadcastReceiver Ju = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            boolean z = true;
            if (intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
                Bundle resultExtras = getResultExtras(true);
                String str3 = "";
                if (resultExtras != null) {
                    str3 = resultExtras.getString(Constants.PACKAGE_NAME);
                }
                if (!TextUtils.isEmpty(str3) && resultExtras != null) {
                    str = str3;
                    str2 = resultExtras.getString("current_path");
                } else if (intent.getExtras() == null) {
                    str = str3;
                    str2 = "";
                } else {
                    str = intent.getExtras().getString(Constants.PACKAGE_NAME);
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
                bundle.putString(Constants.PACKAGE_NAME, str);
                bundle.putString("current_path", str2);
                setResultExtras(bundle);
                if (PluginPackageManager.this.Jj) {
                    PluginPackageManager.this.F(str, str2);
                }
            }
        }
    };
    private a.c IR = new a.c() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4
        @Override // com.baidu.adp.plugin.packageManager.a.c
        public void D(String str, String str2) {
            PluginSetting findPluginSetting;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str)) != null) {
                if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().bU(str);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().b(str, str3, PluginPackageManager.this.Jj);
                }
            }
        }
    };
    private com.baidu.adp.plugin.install.a Ib = new com.baidu.adp.plugin.install.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.6
        @Override // com.baidu.adp.plugin.install.a
        public void ai(boolean z) {
            if (z) {
                if (PluginPackageManager.ms().isMainProcess()) {
                    PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
                    com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "version_update_suc", null, PluginPackageManager.this.Jk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (mT == null ? "" : mT.getContainerVersion()));
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().bT(PluginPackageManager.this.Jk);
                if (PluginPackageManager.ms().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.mc().e("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.Jm);
                }
            } else if (PluginPackageManager.ms().isMainProcess()) {
                PluginSettings mT2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
                com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "version_update_fail", null, PluginPackageManager.this.Jk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (mT2 == null ? "" : mT2.getContainerVersion()));
            }
            PluginPackageManager.this.mA();
            PluginPackageManager.this.al(true);
        }

        @Override // com.baidu.adp.plugin.install.a
        public void bv(String str) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().f(str, true);
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str);
            if (findPluginSetting != null && findPluginSetting.versionCode < PluginPackageManager.Jf) {
                com.baidu.adp.plugin.b.a.mc().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.mc().f("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a Jv = new com.baidu.adp.plugin.packageManager.pluginServerConfig.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.9
        @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
        public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
            if (PluginPackageManager.Jg != 1) {
                if (!z || pluginNetConfigInfos == null) {
                    PluginPackageManager.this.Js = true;
                    PluginPackageManager.this.mL();
                } else {
                    String str = "";
                    if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                        List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                        PluginPackageManager.this.a(cVar, configs);
                        str = PluginPackageManager.this.k(configs);
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().setForbiddenFeatures(str);
                    PluginPackageManager.this.Js = false;
                }
            }
            PluginPackageManager.this.mD();
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a Jw = new com.baidu.adp.plugin.packageManager.pluginFileDownload.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.10
        private Map<String, Long> JB = new HashMap();

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean d(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void e(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.Jr != null) {
                PluginPackageManager.this.Jr.a(bdFileDownloadData);
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
            if (PluginPackageManager.this.Jr != null) {
                PluginPackageManager.this.Jr.b(bdFileDownloadData);
            }
            if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().m(id, a.b.JP);
                if (this.JB.containsKey(id)) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_download", "re-download-success", id, "costTimes:" + String.valueOf(System.currentTimeMillis() - this.JB.get(id).longValue()));
                    this.JB.remove(id);
                }
                com.baidu.adp.plugin.b.a.mc().A("plugin_download", bdFileDownloadData.getId());
                if (Util.p(findPluginSetting.size)) {
                    if (PluginPackageManager.this.Jr != null) {
                        a aVar = new a();
                        aVar.packageName = id;
                        aVar.timestamp = System.currentTimeMillis();
                        aVar.JE = new com.baidu.adp.plugin.install.b() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.10.1
                            @Override // com.baidu.adp.plugin.install.b
                            public void bw(String str) {
                                if (PluginPackageManager.this.Jr != null) {
                                    PluginPackageManager.this.Jr.a(bdFileDownloadData, 0, "");
                                }
                            }

                            @Override // com.baidu.adp.plugin.install.b
                            public void z(String str, String str2) {
                                String str3;
                                if (PluginPackageManager.this.Jr != null) {
                                    if ("rom_size".equals(str2)) {
                                        str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
                                    } else {
                                        str3 = "";
                                    }
                                    PluginPackageManager.this.Jr.a(bdFileDownloadData, -1, str3);
                                }
                            }
                        };
                        PluginPackageManager.this.Ji.put(id, aVar);
                    }
                    PluginPackageManager.this.E(Util.f(findPluginSetting), findPluginSetting.packageName);
                    return;
                }
                com.baidu.adp.plugin.install.d.e(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.ni()));
                if (PluginPackageManager.this.Jr != null) {
                    PluginPackageManager.this.Jr.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
            if (PluginPackageManager.this.Jr != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i);
                PluginPackageManager.this.Jr.c(bdFileDownloadData);
            }
            PluginPackageManager.this.mL();
            if (bdFileDownloadData != null) {
                if (!this.JB.containsKey(bdFileDownloadData.getId())) {
                    this.JB.put(bdFileDownloadData.getId(), Long.valueOf(System.currentTimeMillis()));
                }
                com.baidu.adp.plugin.b.a.mc().g("plugin_download", String.valueOf(i), bdFileDownloadData.getId(), str2);
            }
        }
    };
    private CustomMessageListener Jx = new CustomMessageListener(2000994) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.2
        private int Jy;
        private long lastCallTime;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PluginPackageManager.this.isInit && j.kc()) {
                if (this.Jy < 3) {
                    PluginPackageManager.this.al(PluginPackageManager.this.Js);
                    this.Jy++;
                    this.lastCallTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - this.lastCallTime > 60000) {
                    PluginPackageManager.this.al(PluginPackageManager.this.Js);
                    this.Jy = 0;
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

    public static final int mr() {
        return Jf;
    }

    public static PluginPackageManager ms() {
        if (Jh == null) {
            synchronized (PluginPackageManager.class) {
                if (Jh == null) {
                    Jh = new PluginPackageManager();
                }
            }
        }
        return Jh;
    }

    private PluginPackageManager() {
        this.Ji = null;
        this.Ji = new Hashtable<>();
        lL();
    }

    private void lL() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            this.mContext.registerReceiver(this.Jt, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean mt() {
        return this.Jn;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bF = bF(str);
        boolean bx = com.baidu.adp.plugin.install.c.lK().bx(str);
        if (bF && !bx) {
            bVar.bw(str);
        } else {
            a aVar = new a();
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.JE = bVar;
            synchronized (this) {
                if (this.Ji.size() < 1000) {
                    this.Ji.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        mu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, String str2) {
        a remove;
        if (!StringUtils.isNull(str) && (remove = this.Ji.remove(str)) != null && remove.JE != null) {
            if (z) {
                remove.JE.bw(str);
            } else {
                remove.JE.z(remove.packageName, str2);
            }
        }
    }

    private void mu() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Ji.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= KeepJobService.JOB_CHECK_PERIODIC) {
                    if (value.JE != null) {
                        value.JE.z(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bF(String str) {
        return bK(str);
    }

    public PluginSetting bG(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str);
    }

    public void E(String str, String str2) {
        File file;
        if (this.Jj) {
            com.baidu.adp.plugin.b.a.mc().e("plugin_install", str2, null);
            if (!Util.p(new File(str).length())) {
                com.baidu.adp.plugin.install.d.e(str, str2, "rom_size", String.valueOf(Util.ni()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.lK().H(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.mc().f("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void mv() {
        if (this.Jj) {
            com.baidu.adp.plugin.install.c.lK().a(this.mContext, this.Ib);
        }
    }

    private void bH(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.ml().a(arrayList, this.IR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b JE;
        String packageName;
        long timestamp;

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mw() {
        PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
        if (mT == null || mT.getPlugins() == null || G(this.Jk, mT.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : mT.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || mT.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
                            if (!Util.ng()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.mc().bB("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.mc().bB("hook_failed");
                                        com.baidu.adp.plugin.b.a.mc().g("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.mc().g("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.Hs) {
                        com.baidu.adp.plugin.b.a.mc().bB("patch_launch_failed");
                    }
                }
            }
        }
    }

    public void mx() {
        PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
        if (mT != null && !G(this.Jk, mT.getContainerVersion())) {
            a(mT);
        }
    }

    public void a(String str, boolean z, boolean z2) {
        this.Jj = z;
        this.isThirdProcess = z2;
        this.Jk = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            Jf = com.baidu.adp.lib.g.b.f(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), Jf);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a((e) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "begin");
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.mc().bB("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mO().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().a(bVar2);
        this.isInit = true;
        PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
        if (mT == null || (mT != null && G(this.Jk, mT.getContainerVersion()))) {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "install_buildin_plugin-" + this.Jk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (mT == null ? "settings_is_null" : mT.getContainerVersion()));
            this.Jm = System.currentTimeMillis();
            if (ms().isMainProcess()) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "version_update", null, this.Jk + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (mT == null ? "" : mT.getContainerVersion()));
            }
            mB();
            mv();
        } else {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin");
            if ((com.baidu.adp.lib.OrmObject.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
                BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Void doInBackground(Void... voidArr) {
                        Object c = com.baidu.adp.lib.OrmObject.a.a.c(Looper.getMainLooper(), "sThreadLocal");
                        if (c instanceof ThreadLocal) {
                            ((ThreadLocal) c).set(Looper.getMainLooper());
                        }
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin#2");
                            PluginPackageManager.this.my();
                            return null;
                        }
                        com.baidu.adp.plugin.b.a.mc().bB("plugin_asyncinit_fail");
                        com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin#3");
                                PluginPackageManager.this.my();
                            }
                        });
                        return null;
                    }
                };
                bdAsyncTask.setPriority(4);
                bdAsyncTask.execute(new Void[0]);
            } else {
                com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "load_plugin#1");
                my();
            }
        }
        mz();
        mC();
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadAllPlugins", "end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        mA();
        if (Build.VERSION.SDK_INT > 10) {
            al(true);
        }
    }

    private void mz() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Jj) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.Ju, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Jj) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.JQ)) {
                    Intent intent = new Intent("com.baidu.adp.plugin.currentpath");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.PACKAGE_NAME, value.packageName);
                    bundle.putString("current_path", "");
                    intent.putExtras(bundle);
                    this.mContext.sendOrderedBroadcast(intent, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.JQ && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.mc().g("plugin_del_unuse", "server forbidden", str);
                bH(str);
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
                com.baidu.adp.plugin.packageManager.a.ml().a(arrayList, this.IR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA() {
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "begin");
        PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
        if (mT == null) {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "PluginSettings_is_null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<PluginSetting> pluginSettingsSortLoadPriorty = mT.getPluginSettingsSortLoadPriorty();
        if (pluginSettingsSortLoadPriorty == null || pluginSettingsSortLoadPriorty.isEmpty()) {
            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "PluginSetting_list_is_null");
            return;
        }
        int i = 0;
        for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
            if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                if (!pluginSetting.isPatch || this.Jo <= 0) {
                    if (pluginSetting.enable && pluginSetting.installStatus != a.b.JQ) {
                        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch");
                        Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                        Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                        if (!launch.Hs && (plugin2 == null || !plugin2.isLoaded())) {
                            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_fail-reason_" + launch.reason + "-comment_" + launch.Hu);
                        } else {
                            com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", pluginSetting.packageName + "_launch_success");
                        }
                        if (!launch.Hs && plugin2 != null && !plugin2.isLoaded()) {
                            i++;
                            if (ms().isMainProcess()) {
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
                                sb.append(launch.Hu);
                            }
                        }
                    }
                    i = i;
                }
            }
        }
        if (ms().isMainProcess()) {
            if (i > 0) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_load", "load_allplugin", null, sb.toString());
            }
            PluginCenter.getInstance().logPluginLoadStat();
        }
        com.baidu.adp.plugin.b.b.C("PluginPackageManager_loadPlugin", "end");
    }

    private void mB() {
        if (this.Jj) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().am(false);
        }
    }

    public void al(final boolean z) {
        if (this.Jj) {
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.7
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT(), z, PluginPackageManager.this.Jv);
                }
            }, 1500L);
        }
    }

    private void mC() {
        MessageManager.getInstance().registerListener(2000987, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PluginSettings mT;
                PluginNetConfigInfos mR;
                List<PluginNetConfigInfos.PluginConfig> configs;
                boolean z = false;
                Object data = customResponsedMessage.getData();
                if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT()) != null) {
                    if (mT == null || !PluginPackageManager.this.G(PluginPackageManager.this.Jk, mT.getContainerVersion())) {
                        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
                        if (!TextUtils.isEmpty(pluginConfig.package_name) && (mR = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().mR()) != null && (configs = mR.getConfigs()) != null) {
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
                            PluginPackageManager.this.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().b(com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT()), pluginConfig);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().setForbiddenFeatures(PluginPackageManager.this.k(configs));
                            PluginPackageManager.this.mD();
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
        List<BasicNameValuePair> mP;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.JP) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.Jj) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().f(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().m(pluginConfig.package_name, a.b.JQ);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < Jf && this.Jj) {
                    com.baidu.adp.plugin.b.a.mc().f("plugin_install", "server_config_versionlower", pluginConfig.package_name, Jf + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (mP = cVar.mP()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(mP)) {
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
                                com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.mc().f("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().m(pluginConfig.package_name, a.b.JQ);
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
                            if (pluginConfig.newest.download_type == a.C0022a.JO) {
                                pluginSetting.installStatus = a.b.JR;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0022a.WIFI) {
                                    pluginSetting.installStatus = a.b.JS;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0022a.JO) {
                            pluginSetting.installStatus = a.b.JR;
                        } else if (pluginConfig.newest.download_type == a.C0022a.WIFI) {
                            pluginSetting.installStatus = a.b.JS;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.lK().k(pluginSetting.packageName, pluginSetting.rollback);
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
    public void mD() {
        PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
        if (mT != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : mT.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.JQ) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.JP) {
                        E(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.JS && j.kd()) || pluginSetting.installStatus == a.b.JR) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().bV(pluginSetting.packageName);
                    if (pluginSetting.versionCode < Jf) {
                        com.baidu.adp.plugin.b.a.mc().B("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.mc().f("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.Jj && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.p(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.mc().g("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mO().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mO().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.Jw, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Jj) {
            c.mq().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.Jr = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.J(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bI(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().bI(str);
    }

    public void bJ(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().bJ(str);
    }

    public String mE() {
        return this.Jk;
    }

    public boolean isMainProcess() {
        return this.Jj;
    }

    public boolean mF() {
        return this.isThirdProcess;
    }

    public boolean bK(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bL(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT().isFeatureForbidden(str);
    }

    public boolean bM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos mR = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().mR();
        if (mR != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = mR.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().a(findPluginSetting.packageName, findPluginSetting);
            this.Jr = dVar;
            a(findPluginSetting, this.Jw, true);
        }
    }

    public boolean mG() {
        return mI() && !this.Jl;
    }

    public void mH() {
        this.Jl = true;
    }

    public boolean mI() {
        PluginSettings mT = com.baidu.adp.plugin.packageManager.pluginSettings.c.mW().mT();
        if (mT == null || mT.getPlugins() == null || mT.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mT.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bM(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos mR;
        if (TextUtils.isEmpty(str) || (mR = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().mR()) == null) {
            return null;
        }
        return mR.getPluginConfig(str);
    }

    public void bN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mO().bQ(str);
        }
    }

    public boolean bO(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mO().bO(str);
    }

    public void mJ() {
        if (this.isInit) {
            b.mn().ak(this.Jj);
        }
    }

    public void aB(int i) {
        this.Jo = i;
    }

    public int mK() {
        return this.Jo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL() {
        if (this.Jj) {
            MessageManager.getInstance().unRegisterListener(this.Jx);
            MessageManager.getInstance().registerListener(this.Jx);
        }
    }
}
