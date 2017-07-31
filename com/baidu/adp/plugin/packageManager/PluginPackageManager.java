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
import com.baidu.adp.lib.util.i;
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
    private static int FE = 43;
    private static int FF = 2;
    private static volatile PluginPackageManager FG = null;
    private Hashtable<String, a> FH;
    private String FJ;
    private boolean FK;
    private d FQ;
    private boolean FI = false;
    private boolean isThirdProcess = false;
    private long FL = 0;
    private boolean isInit = false;
    private boolean FM = false;
    private int FN = 0;
    private final String FO = "com.baidu.adp.plugin.currentpath";
    private final String FP = "current_path";
    private BroadcastReceiver FR = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.1
        /* JADX WARN: Removed duplicated region for block: B:60:0x026c  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            PluginSetting pluginSetting;
            String str;
            boolean z = false;
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
                    PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(stringExtra);
                    if (findPluginSetting == null) {
                        findPluginSetting = new PluginSetting();
                        findPluginSetting.forbidden = false;
                    }
                    if (findPluginSetting.install_fail_count > 0) {
                        com.baidu.adp.plugin.b.a.jr().B("plugin_install_suc_fail", stringExtra);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(stringExtra, findPluginSetting, PluginPackageManager.this.FI);
                    if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z) {
                        PluginCenter.getInstance().launch(findPluginSetting.packageName);
                    }
                    PluginPackageManager.this.a(stringExtra, true, (String) null);
                    if (PluginPackageManager.this.FI) {
                        com.baidu.adp.plugin.b.a.jr().e("plugin_install_suc", stringExtra, findPluginSetting);
                        if (intExtra < PluginPackageManager.FE) {
                            com.baidu.adp.plugin.b.a.jr().B("plugin_launch_lowversion", stringExtra);
                            com.baidu.adp.plugin.b.a.jr().e("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
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
                            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(stringExtra9);
                            if (pluginSetting == null) {
                                pluginSetting = new PluginSetting();
                                pluginSetting.packageName = stringExtra9;
                            }
                            pluginSetting.enable = false;
                            if (PluginPackageManager.this.FI) {
                                pluginSetting.install_fail_count++;
                                if (pluginSetting.install_fail_count >= 5) {
                                    PluginPackageManager.this.d(pluginSetting);
                                    pluginSetting.tempVersionCode = 0;
                                    pluginSetting.url = "";
                                    pluginSetting.tempMd5 = "";
                                    pluginSetting.install_fail_count = 0;
                                    pluginSetting.installStatus = 0;
                                }
                                if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.gJ().getMaxAlertCount("alert_plugin", 3)) {
                                    BdStatisticsManager.getInstance().alert("alert_plugin", "package name = " + stringExtra9 + "; fail count = " + pluginSetting.install_fail_count);
                                }
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(stringExtra9, pluginSetting, PluginPackageManager.this.FI);
                        }
                        PluginPackageManager.this.a(substring, false, stringExtra7);
                        if (PluginPackageManager.this.FI) {
                            if (stringExtra8 != null) {
                                String lowerCase = stringExtra8.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                    str = "rom_size";
                                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                    str = "read_file_system";
                                    com.baidu.adp.plugin.b.a.jr().B("plugin_read_file_sys", stringExtra9);
                                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                    str = "permission_denied";
                                    com.baidu.adp.plugin.b.a.jr().B("plugin_permission_denied", stringExtra9);
                                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    str = "fsync_failed";
                                    com.baidu.adp.plugin.b.a.jr().B("plugin_fsync_failed", stringExtra9);
                                }
                                if ("rom_size".equals(str)) {
                                    com.baidu.adp.plugin.b.a.jr().B("plugin_rom_small", stringExtra9);
                                }
                                com.baidu.adp.plugin.b.a.jr().a("plugin_install_fail", stringExtra9, pluginSetting, str);
                                com.baidu.adp.plugin.b.a.jr().f("plugin_install", str, stringExtra9, stringExtra8);
                            }
                            str = stringExtra7;
                            if ("rom_size".equals(str)) {
                            }
                            com.baidu.adp.plugin.b.a.jr().a("plugin_install_fail", stringExtra9, pluginSetting, str);
                            com.baidu.adp.plugin.b.a.jr().f("plugin_install", str, stringExtra9, stringExtra8);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    String stringExtra10 = intent.getStringExtra("package_name");
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(stringExtra10);
                    if (findPluginSetting2 != null) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().f(stringExtra10, true);
                        if (findPluginSetting2.versionCode < PluginPackageManager.FE) {
                            com.baidu.adp.plugin.b.a.jr().B("plugin_launch_lowversion", stringExtra10);
                            com.baidu.adp.plugin.b.a.jr().e("plugin_load", "load_lowversion", stringExtra10, "broadcast_cancel-" + findPluginSetting2.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.installStatus);
                        }
                    } else {
                        com.baidu.adp.plugin.b.a.jr().e("plugin_install", "install_cancel_settingnull", stringExtra10, null);
                    }
                    PluginPackageManager.this.a(stringExtra10, true, (String) null);
                } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                    String stringExtra11 = intent.getStringExtra("fail_reason");
                    String stringExtra12 = intent.getStringExtra("package_name");
                    if (!TextUtils.isEmpty(stringExtra12)) {
                        PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(stringExtra12);
                        if (findPluginSetting3 == null) {
                            findPluginSetting3 = new PluginSetting();
                            findPluginSetting3.packageName = stringExtra12;
                        }
                        findPluginSetting3.enable = false;
                        if (PluginPackageManager.this.FI && "low_version_code".equals(stringExtra11)) {
                            PluginPackageManager.this.d(findPluginSetting3);
                            findPluginSetting3.tempVersionCode = 0;
                            findPluginSetting3.url = "";
                            findPluginSetting3.tempMd5 = "";
                            findPluginSetting3.install_fail_count = 0;
                            findPluginSetting3.installStatus = 0;
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(stringExtra12, findPluginSetting3, PluginPackageManager.this.FI);
                        if ("low_version_code".equals(stringExtra11)) {
                            com.baidu.adp.plugin.b.a.jr().B("plugin_low_version_code", stringExtra12);
                        }
                    }
                }
            }
        }
    };
    private BroadcastReceiver FS = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.2
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
                if (PluginPackageManager.this.FI) {
                    PluginPackageManager.this.E(str, str2);
                }
            }
        }
    };
    private a.c Fp = new a.c() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.3
        @Override // com.baidu.adp.plugin.packageManager.a.c
        public void C(String str, String str2) {
            PluginSetting findPluginSetting;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str)) != null) {
                if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                    com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().bB(str);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().b(str, str3, PluginPackageManager.this.FI);
                }
            }
        }
    };
    private com.baidu.adp.plugin.install.a EI = new com.baidu.adp.plugin.install.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5
        @Override // com.baidu.adp.plugin.install.a
        public void L(boolean z) {
            if (z) {
                if (PluginPackageManager.jE().isMainProcess()) {
                    PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
                    com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "version_update_suc", null, PluginPackageManager.this.FJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ke == null ? "" : ke.getContainerVersion()));
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().bA(PluginPackageManager.this.FJ);
                if (PluginPackageManager.jE().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.jr().f("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.FL);
                }
            } else if (PluginPackageManager.jE().isMainProcess()) {
                PluginSettings ke2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
                com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "version_update_fail", null, PluginPackageManager.this.FJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ke2 == null ? "" : ke2.getContainerVersion()));
            }
            PluginPackageManager.this.loadPlugin();
            PluginPackageManager.this.N(true);
        }

        @Override // com.baidu.adp.plugin.install.a
        public void bc(String str) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().f(str, true);
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str);
            if (findPluginSetting != null && findPluginSetting.versionCode < PluginPackageManager.FE) {
                com.baidu.adp.plugin.b.a.jr().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.jr().e("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a FT = new com.baidu.adp.plugin.packageManager.pluginServerConfig.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.7
        @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
        public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
            if (PluginPackageManager.FF != 1 && z && pluginNetConfigInfos != null) {
                String str = "";
                if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                    List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                    PluginPackageManager.this.a(cVar, configs);
                    str = PluginPackageManager.this.g(configs);
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().setForbiddenFeatures(str);
            }
            PluginPackageManager.this.jO();
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a FU = new com.baidu.adp.plugin.packageManager.pluginFileDownload.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8
        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean d(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void e(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.FQ != null) {
                PluginPackageManager.this.FQ.a(bdFileDownloadData);
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
            if (PluginPackageManager.this.FQ != null) {
                PluginPackageManager.this.FQ.b(bdFileDownloadData);
            }
            if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().n(id, a.b.Gk);
                com.baidu.adp.plugin.b.a.jr().A("plugin_download", bdFileDownloadData.getId());
                if (Util.k(findPluginSetting.size)) {
                    if (PluginPackageManager.this.FQ != null) {
                        a aVar = new a();
                        aVar.packageName = id;
                        aVar.timestamp = System.currentTimeMillis();
                        aVar.FY = new com.baidu.adp.plugin.install.b() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8.1
                            @Override // com.baidu.adp.plugin.install.b
                            public void bd(String str) {
                                if (PluginPackageManager.this.FQ != null) {
                                    PluginPackageManager.this.FQ.a(bdFileDownloadData, 0, "");
                                }
                            }

                            @Override // com.baidu.adp.plugin.install.b
                            public void z(String str, String str2) {
                                String str3;
                                if (PluginPackageManager.this.FQ != null) {
                                    if ("rom_size".equals(str2)) {
                                        str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
                                    } else {
                                        str3 = "";
                                    }
                                    PluginPackageManager.this.FQ.a(bdFileDownloadData, -1, str3);
                                }
                            }
                        };
                        PluginPackageManager.this.FH.put(id, aVar);
                    }
                    PluginPackageManager.this.D(Util.f(findPluginSetting), findPluginSetting.packageName);
                    return;
                }
                com.baidu.adp.plugin.install.d.d(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.kt()));
                if (PluginPackageManager.this.FQ != null) {
                    PluginPackageManager.this.FQ.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
            if (PluginPackageManager.this.FQ != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i);
                PluginPackageManager.this.FQ.c(bdFileDownloadData);
            }
            if (bdFileDownloadData != null) {
                com.baidu.adp.plugin.b.a.jr().f("plugin_download", String.valueOf(i), bdFileDownloadData.getId(), str2);
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

    public static final int jD() {
        return FE;
    }

    public static PluginPackageManager jE() {
        if (FG == null) {
            synchronized (PluginPackageManager.class) {
                if (FG == null) {
                    FG = new PluginPackageManager();
                }
            }
        }
        return FG;
    }

    private PluginPackageManager() {
        this.FH = null;
        this.FH = new Hashtable<>();
        ja();
    }

    private void ja() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.FR, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean jF() {
        return this.FM;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bl = bl(str);
        boolean be = com.baidu.adp.plugin.install.c.iZ().be(str);
        if (bl && !be) {
            bVar.bd(str);
        } else {
            a aVar = new a();
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.FY = bVar;
            synchronized (this) {
                if (this.FH.size() < 1000) {
                    this.FH.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        jG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.FH.remove(str);
        if (remove != null && remove.FY != null) {
            if (z) {
                remove.FY.bd(str);
            } else {
                remove.FY.z(remove.packageName, str2);
            }
        }
    }

    private void jG() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.FH.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.FY != null) {
                        value.FY.z(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bl(String str) {
        return bq(str);
    }

    public PluginSetting bm(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str);
    }

    public void D(String str, String str2) {
        File file;
        if (this.FI) {
            com.baidu.adp.plugin.b.a.jr().e("plugin_install", str2, null);
            if (!Util.k(new File(str).length())) {
                com.baidu.adp.plugin.install.d.d(str, str2, "rom_size", String.valueOf(Util.kt()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.iZ().I(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.jr().e("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void jH() {
        if (this.FI) {
            com.baidu.adp.plugin.install.c.iZ().a(this.mContext, this.EI);
        }
    }

    private void bn(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.jx().a(arrayList, this.Fp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b FY;
        String packageName;
        long timestamp;

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jI() {
        PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
        if (ke == null || ke.getPlugins() == null || F(this.FJ, ke.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : ke.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || ke.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                return true;
            }
            while (r5.hasNext()) {
            }
        }
        return false;
    }

    private void b(PluginSettings pluginSettings) {
        List<PluginSetting> pluginSettingsSortLoadPriorty;
        if (pluginSettings != null && pluginSettings.getPlugins() != null && (pluginSettingsSortLoadPriorty = pluginSettings.getPluginSettingsSortLoadPriorty()) != null) {
            boolean z = true;
            for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pluginSettings.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                    if (z) {
                        try {
                            if (!Util.kr()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.jr().bi("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.jr().bi("hook_failed");
                                        com.baidu.adp.plugin.b.a.jr().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.jr().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.Ea) {
                        com.baidu.adp.plugin.b.a.jr().bi("patch_launch_failed");
                    }
                }
            }
        }
    }

    public void jJ() {
        PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
        if (ke != null && !F(this.FJ, ke.getContainerVersion())) {
            b(ke);
        }
    }

    public void d(String str, boolean z, boolean z2) {
        this.FI = z;
        this.isThirdProcess = z2;
        this.FJ = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            FE = com.baidu.adp.lib.g.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), FE);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a((e) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.jr().bi("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jZ().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().a(bVar2);
        this.isInit = true;
        PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
        if (ke == null || (ke != null && F(this.FJ, ke.getContainerVersion()))) {
            this.FL = System.currentTimeMillis();
            if (jE().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "version_update", null, this.FJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (ke == null ? "" : ke.getContainerVersion()));
            }
            jM();
            jH();
        } else if ((com.baidu.adp.lib.OrmObject.a.a.d(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
            BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    Object d = com.baidu.adp.lib.OrmObject.a.a.d(Looper.getMainLooper(), "sThreadLocal");
                    if (d instanceof ThreadLocal) {
                        ((ThreadLocal) d).set(Looper.getMainLooper());
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        PluginPackageManager.this.jK();
                        return null;
                    }
                    com.baidu.adp.plugin.b.a.jr().bi("plugin_asyncinit_fail");
                    com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PluginPackageManager.this.jK();
                        }
                    });
                    return null;
                }
            };
            bdAsyncTask.setPriority(4);
            bdAsyncTask.execute(new Void[0]);
        } else {
            jK();
        }
        jL();
        jN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK() {
        loadPlugin();
        if (Build.VERSION.SDK_INT > 10) {
            N(true);
        }
    }

    private void jL() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.FI) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.FS, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.FI) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.Gl)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.Gl && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.jr().f("plugin_del_unuse", "server forbidden", str);
                bn(str);
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
                com.baidu.adp.plugin.packageManager.a.jx().a(arrayList, this.Fp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPlugin() {
        PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
        if (ke != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = ke.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                        if (!pluginSetting.isPatch || this.FN <= 0) {
                            if (pluginSetting.enable && pluginSetting.installStatus != a.b.Gl) {
                                Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                                Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                                if (!launch.Ea && plugin2 != null && !plugin2.isLoaded()) {
                                    i++;
                                    if (jE().isMainProcess()) {
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
                                        sb.append(launch.Ec);
                                    }
                                }
                            }
                            i = i;
                        }
                    }
                }
                if (jE().isMainProcess()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.jr().e("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    private void jM() {
        if (this.FI) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().O(false);
        }
    }

    public void N(boolean z) {
        if (this.FI) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke(), z, this.FT);
        }
    }

    private void jN() {
        MessageManager.getInstance().registerListener(2000987, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PluginSettings ke;
                PluginNetConfigInfos kc;
                List<PluginNetConfigInfos.PluginConfig> configs;
                boolean z = false;
                Object data = customResponsedMessage.getData();
                if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke()) != null) {
                    if (ke == null || !PluginPackageManager.this.F(PluginPackageManager.this.FJ, ke.getContainerVersion())) {
                        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
                        if (!TextUtils.isEmpty(pluginConfig.package_name) && (kc = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc()) != null && (configs = kc.getConfigs()) != null) {
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
                            PluginPackageManager.this.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().c(com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke()), pluginConfig);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().setForbiddenFeatures(PluginPackageManager.this.g(configs));
                            PluginPackageManager.this.jO();
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
        List<BasicNameValuePair> ka;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.Gk) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.FI) {
                    com.baidu.adp.plugin.b.a.jr().e("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.jr().e("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().f(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().n(pluginConfig.package_name, a.b.Gl);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < FE && this.FI) {
                    com.baidu.adp.plugin.b.a.jr().e("plugin_install", "server_config_versionlower", pluginConfig.package_name, FE + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (ka = cVar.ka()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(ka)) {
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
                                com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.jr().e("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().n(pluginConfig.package_name, a.b.Gl);
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
                            if (pluginConfig.newest.download_type == a.C0011a.Gj) {
                                pluginSetting.installStatus = a.b.Gm;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                    pluginSetting.installStatus = a.b.Gn;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0011a.Gj) {
                            pluginSetting.installStatus = a.b.Gm;
                        } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                            pluginSetting.installStatus = a.b.Gn;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.iZ().l(pluginSetting.packageName, pluginSetting.rollback);
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
    public String g(List<PluginNetConfigInfos.PluginConfig> list) {
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
    public void jO() {
        PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
        if (ke != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : ke.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.Gl) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.Gk) {
                        D(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.Gn && i.hs()) || pluginSetting.installStatus == a.b.Gm) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().bC(pluginSetting.packageName);
                    if (pluginSetting.versionCode < FE) {
                        com.baidu.adp.plugin.b.a.jr().B("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.jr().e("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.FI && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.k(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.jr().f("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jZ().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jZ().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.FU, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.FI) {
            c.jC().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.FQ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.I(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bo(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().bo(str);
    }

    public void bp(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().bp(str);
    }

    public String jP() {
        return this.FJ;
    }

    public boolean isMainProcess() {
        return this.FI;
    }

    public boolean jQ() {
        return this.isThirdProcess;
    }

    public boolean bq(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean br(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke().isFeatureForbidden(str);
    }

    public boolean bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos kc = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc();
        if (kc != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = kc.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().a(findPluginSetting.packageName, findPluginSetting);
            this.FQ = dVar;
            a(findPluginSetting, this.FU, true);
        }
    }

    public boolean jR() {
        return jT() && !this.FK;
    }

    public void jS() {
        this.FK = true;
    }

    public boolean jT() {
        PluginSettings ke = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().ke();
        if (ke == null || ke.getPlugins() == null || ke.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : ke.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bs(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos kc;
        if (TextUtils.isEmpty(str) || (kc = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc()) == null) {
            return null;
        }
        return kc.getPluginConfig(str);
    }

    public void bt(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jZ().bx(str);
        }
    }

    public boolean bu(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jZ().bu(str);
    }

    public PluginStatus bv(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kh().findPluginSetting(str);
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

    public void jU() {
        if (this.isInit) {
            b.jz().clear(this.FI);
        }
    }

    public void aE(int i) {
        this.FN = i;
    }

    public int jV() {
        return this.FN;
    }
}
