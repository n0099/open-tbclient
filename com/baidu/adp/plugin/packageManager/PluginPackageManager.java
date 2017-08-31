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
    private static int DA = 43;
    private static int DB = 2;
    private static volatile PluginPackageManager DC = null;
    private Hashtable<String, a> DD;
    private String DF;
    private boolean DG;
    private d DM;
    private boolean DE = false;
    private boolean isThirdProcess = false;
    private long DH = 0;
    private boolean isInit = false;
    private boolean DI = false;
    private int DJ = 0;
    private final String DK = "com.baidu.adp.plugin.currentpath";
    private final String DL = "current_path";
    private BroadcastReceiver DN = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.1
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
                    PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(stringExtra);
                    if (findPluginSetting == null) {
                        findPluginSetting = new PluginSetting();
                        findPluginSetting.forbidden = false;
                    }
                    if (findPluginSetting.install_fail_count > 0) {
                        com.baidu.adp.plugin.b.a.jj().B("plugin_install_suc_fail", stringExtra);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(stringExtra, findPluginSetting, PluginPackageManager.this.DE);
                    if (findPluginSetting.isPatch && TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(findPluginSetting.requireLoad) && findPluginSetting.requireLoad.equals("0") && !z) {
                        PluginCenter.getInstance().launch(findPluginSetting.packageName);
                    }
                    PluginPackageManager.this.a(stringExtra, true, (String) null);
                    if (PluginPackageManager.this.DE) {
                        com.baidu.adp.plugin.b.a.jj().e("plugin_install_suc", stringExtra, findPluginSetting);
                        if (intExtra < PluginPackageManager.DA) {
                            com.baidu.adp.plugin.b.a.jj().B("plugin_launch_lowversion", stringExtra);
                            com.baidu.adp.plugin.b.a.jj().c("plugin_load", "load_lowversion", stringExtra, "broadcast_suc-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
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
                            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(stringExtra9);
                            if (pluginSetting == null) {
                                pluginSetting = new PluginSetting();
                                pluginSetting.packageName = stringExtra9;
                            }
                            pluginSetting.enable = false;
                            if (PluginPackageManager.this.DE) {
                                pluginSetting.install_fail_count++;
                                if (pluginSetting.install_fail_count >= 5) {
                                    PluginPackageManager.this.d(pluginSetting);
                                    pluginSetting.tempVersionCode = 0;
                                    pluginSetting.url = "";
                                    pluginSetting.tempMd5 = "";
                                    pluginSetting.install_fail_count = 0;
                                    pluginSetting.installStatus = 0;
                                }
                                if (pluginSetting.install_fail_count >= com.baidu.adp.lib.stats.switchs.a.gA().getMaxAlertCount("alert_plugin", 3)) {
                                    BdStatisticsManager.getInstance().alert("alert_plugin", "package name = " + stringExtra9 + "; fail count = " + pluginSetting.install_fail_count);
                                }
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(stringExtra9, pluginSetting, PluginPackageManager.this.DE);
                        }
                        PluginPackageManager.this.a(substring, false, stringExtra7);
                        if (PluginPackageManager.this.DE) {
                            if (stringExtra8 != null) {
                                String lowerCase = stringExtra8.toLowerCase(Locale.getDefault());
                                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                                    str = "rom_size";
                                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                                    str = "read_file_system";
                                    com.baidu.adp.plugin.b.a.jj().B("plugin_read_file_sys", stringExtra9);
                                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                                    str = "permission_denied";
                                    com.baidu.adp.plugin.b.a.jj().B("plugin_permission_denied", stringExtra9);
                                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                                    str = "fsync_failed";
                                    com.baidu.adp.plugin.b.a.jj().B("plugin_fsync_failed", stringExtra9);
                                }
                                if ("rom_size".equals(str)) {
                                    com.baidu.adp.plugin.b.a.jj().B("plugin_rom_small", stringExtra9);
                                }
                                com.baidu.adp.plugin.b.a.jj().a("plugin_install_fail", stringExtra9, pluginSetting, str);
                                com.baidu.adp.plugin.b.a.jj().d("plugin_install", str, stringExtra9, stringExtra8);
                            }
                            str = stringExtra7;
                            if ("rom_size".equals(str)) {
                            }
                            com.baidu.adp.plugin.b.a.jj().a("plugin_install_fail", stringExtra9, pluginSetting, str);
                            com.baidu.adp.plugin.b.a.jj().d("plugin_install", str, stringExtra9, stringExtra8);
                        }
                    }
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    String stringExtra10 = intent.getStringExtra("package_name");
                    PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(stringExtra10);
                    if (findPluginSetting2 != null) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(stringExtra10, true);
                        if (findPluginSetting2.versionCode < PluginPackageManager.DA) {
                            com.baidu.adp.plugin.b.a.jj().B("plugin_launch_lowversion", stringExtra10);
                            com.baidu.adp.plugin.b.a.jj().c("plugin_load", "load_lowversion", stringExtra10, "broadcast_cancel-" + findPluginSetting2.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting2.installStatus);
                        }
                    } else {
                        com.baidu.adp.plugin.b.a.jj().c("plugin_install", "install_cancel_settingnull", stringExtra10, null);
                    }
                    PluginPackageManager.this.a(stringExtra10, true, (String) null);
                } else if ("com.baidu.adp.plugin.deleted".equals(action)) {
                    String stringExtra11 = intent.getStringExtra("fail_reason");
                    String stringExtra12 = intent.getStringExtra("package_name");
                    if (!TextUtils.isEmpty(stringExtra12)) {
                        PluginSetting findPluginSetting3 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(stringExtra12);
                        if (findPluginSetting3 == null) {
                            findPluginSetting3 = new PluginSetting();
                            findPluginSetting3.packageName = stringExtra12;
                        }
                        findPluginSetting3.enable = false;
                        if (PluginPackageManager.this.DE && "low_version_code".equals(stringExtra11)) {
                            PluginPackageManager.this.d(findPluginSetting3);
                            findPluginSetting3.tempVersionCode = 0;
                            findPluginSetting3.url = "";
                            findPluginSetting3.tempMd5 = "";
                            findPluginSetting3.install_fail_count = 0;
                            findPluginSetting3.installStatus = 0;
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(stringExtra12, findPluginSetting3, PluginPackageManager.this.DE);
                        if ("low_version_code".equals(stringExtra11)) {
                            com.baidu.adp.plugin.b.a.jj().B("plugin_low_version_code", stringExtra12);
                        }
                    }
                }
            }
        }
    };
    private BroadcastReceiver DO = new BroadcastReceiver() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.2
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
                if (PluginPackageManager.this.DE) {
                    PluginPackageManager.this.E(str, str2);
                }
            }
        }
    };
    private a.c Dl = new a.c() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.3
        @Override // com.baidu.adp.plugin.packageManager.a.c
        public void C(String str, String str2) {
            PluginSetting findPluginSetting;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str)) != null) {
                if (!TextUtils.isEmpty(findPluginSetting.apkPath) && findPluginSetting.apkPath.equals(str2)) {
                    com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "del_unuse_plugin_setting", findPluginSetting.packageName, "apkpath-" + findPluginSetting.apkPath + "-forbidden-" + findPluginSetting.forbidden + "-enable-" + findPluginSetting.enable + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path() + "-versioncode-" + findPluginSetting.versionCode);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().by(str);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().b(str, str3, PluginPackageManager.this.DE);
                }
            }
        }
    };
    private com.baidu.adp.plugin.install.a CE = new com.baidu.adp.plugin.install.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.5
        @Override // com.baidu.adp.plugin.install.a
        public void M(boolean z) {
            if (z) {
                if (PluginPackageManager.jw().isMainProcess()) {
                    PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
                    com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "version_update_suc", null, PluginPackageManager.this.DF + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (jV == null ? "" : jV.getContainerVersion()));
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bx(PluginPackageManager.this.DF);
                if (PluginPackageManager.jw().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.jj().e("plugin_install", System.currentTimeMillis() - PluginPackageManager.this.DH);
                }
            } else if (PluginPackageManager.jw().isMainProcess()) {
                PluginSettings jV2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
                com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "version_update_fail", null, PluginPackageManager.this.DF + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (jV2 == null ? "" : jV2.getContainerVersion()));
            }
            PluginPackageManager.this.loadPlugin();
            PluginPackageManager.this.O(true);
        }

        @Override // com.baidu.adp.plugin.install.a
        public void aZ(String str) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(str, true);
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
            if (findPluginSetting != null && findPluginSetting.versionCode < PluginPackageManager.DA) {
                com.baidu.adp.plugin.b.a.jj().B("plugin_launch_lowversion", str);
                com.baidu.adp.plugin.b.a.jj().c("plugin_load", "load_lowversion", str, "innerapk_hadinstall-" + findPluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + findPluginSetting.installStatus);
            }
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DP = new com.baidu.adp.plugin.packageManager.pluginServerConfig.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.7
        @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
        public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
            if (PluginPackageManager.DB != 1 && z && pluginNetConfigInfos != null) {
                String str = "";
                if (pluginNetConfigInfos.getConfigs() != null && pluginNetConfigInfos.getConfigs().size() > 0) {
                    List<PluginNetConfigInfos.PluginConfig> configs = pluginNetConfigInfos.getConfigs();
                    PluginPackageManager.this.a(cVar, configs);
                    str = PluginPackageManager.this.g(configs);
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().setForbiddenFeatures(str);
            }
            PluginPackageManager.this.jG();
        }
    };
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DQ = new com.baidu.adp.plugin.packageManager.pluginFileDownload.a() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8
        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public boolean d(BdFileDownloadData bdFileDownloadData) {
            return true;
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void e(BdFileDownloadData bdFileDownloadData) {
            if (PluginPackageManager.this.DM != null) {
                PluginPackageManager.this.DM.a(bdFileDownloadData);
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
            if (PluginPackageManager.this.DM != null) {
                PluginPackageManager.this.DM.b(bdFileDownloadData);
            }
            if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().n(id, a.b.Eg);
                com.baidu.adp.plugin.b.a.jj().A("plugin_download", bdFileDownloadData.getId());
                if (Util.k(findPluginSetting.size)) {
                    if (PluginPackageManager.this.DM != null) {
                        a aVar = new a();
                        aVar.packageName = id;
                        aVar.timestamp = System.currentTimeMillis();
                        aVar.DU = new com.baidu.adp.plugin.install.b() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.8.1
                            @Override // com.baidu.adp.plugin.install.b
                            public void ba(String str) {
                                if (PluginPackageManager.this.DM != null) {
                                    PluginPackageManager.this.DM.a(bdFileDownloadData, 0, "");
                                }
                            }

                            @Override // com.baidu.adp.plugin.install.b
                            public void z(String str, String str2) {
                                String str3;
                                if (PluginPackageManager.this.DM != null) {
                                    if ("rom_size".equals(str2)) {
                                        str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
                                    } else {
                                        str3 = "";
                                    }
                                    PluginPackageManager.this.DM.a(bdFileDownloadData, -1, str3);
                                }
                            }
                        };
                        PluginPackageManager.this.DD.put(id, aVar);
                    }
                    PluginPackageManager.this.D(Util.f(findPluginSetting), findPluginSetting.packageName);
                    return;
                }
                com.baidu.adp.plugin.install.d.b(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.kk()));
                if (PluginPackageManager.this.DM != null) {
                    PluginPackageManager.this.DM.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
                }
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
            if (PluginPackageManager.this.DM != null) {
                bdFileDownloadData.setStatusMsg(str);
                bdFileDownloadData.setStatus(2);
                bdFileDownloadData.setErrorCode(i);
                PluginPackageManager.this.DM.c(bdFileDownloadData);
            }
            if (bdFileDownloadData != null) {
                com.baidu.adp.plugin.b.a.jj().d("plugin_download", String.valueOf(i), bdFileDownloadData.getId(), str2);
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

    public static final int jv() {
        return DA;
    }

    public static PluginPackageManager jw() {
        if (DC == null) {
            synchronized (PluginPackageManager.class) {
                if (DC == null) {
                    DC = new PluginPackageManager();
                }
            }
        }
        return DC;
    }

    private PluginPackageManager() {
        this.DD = null;
        this.DD = new Hashtable<>();
        iS();
    }

    private void iS() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.DN, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean jx() {
        return this.DI;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bi = bi(str);
        boolean bb = com.baidu.adp.plugin.install.c.iR().bb(str);
        if (bi && !bb) {
            bVar.ba(str);
        } else {
            a aVar = new a();
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.DU = bVar;
            synchronized (this) {
                if (this.DD.size() < 1000) {
                    this.DD.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        jy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.DD.remove(str);
        if (remove != null && remove.DU != null) {
            if (z) {
                remove.DU.ba(str);
            } else {
                remove.DU.z(remove.packageName, str2);
            }
        }
    }

    private void jy() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.DD.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.DU != null) {
                        value.DU.z(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bi(String str) {
        return bn(str);
    }

    public PluginSetting bj(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
    }

    public void D(String str, String str2) {
        File file;
        if (this.DE) {
            com.baidu.adp.plugin.b.a.jj().e("plugin_install", str2, null);
            if (!Util.k(new File(str).length())) {
                com.baidu.adp.plugin.install.d.b(str, str2, "rom_size", String.valueOf(Util.kk()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.iR().I(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.jj().c("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void jz() {
        if (this.DE) {
            com.baidu.adp.plugin.install.c.iR().a(this.mContext, this.CE);
        }
    }

    private void bk(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.jp().a(arrayList, this.Dl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b DU;
        String packageName;
        long timestamp;

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jA() {
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV == null || jV.getPlugins() == null || F(this.DF, jV.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : jV.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || jV.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
                            if (!Util.ki()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.jj().bf("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.jj().bf("hook_failed");
                                        com.baidu.adp.plugin.b.a.jj().d("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.jj().d("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.BW) {
                        com.baidu.adp.plugin.b.a.jj().bf("patch_launch_failed");
                    }
                }
            }
        }
    }

    public void jB() {
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV != null && !F(this.DF, jV.getContainerVersion())) {
            b(jV);
        }
    }

    public void c(String str, boolean z, boolean z2) {
        this.DE = z;
        this.isThirdProcess = z2;
        this.DF = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            DA = com.baidu.adp.lib.g.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), DA);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a((e) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.jj().bf("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jQ().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().a(bVar2);
        this.isInit = true;
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV == null || (jV != null && F(this.DF, jV.getContainerVersion()))) {
            this.DH = System.currentTimeMillis();
            if (jw().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "version_update", null, this.DF + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (jV == null ? "" : jV.getContainerVersion()));
            }
            jE();
            jz();
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
                        PluginPackageManager.this.jC();
                        return null;
                    }
                    com.baidu.adp.plugin.b.a.jj().bf("plugin_asyncinit_fail");
                    com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PluginPackageManager.this.jC();
                        }
                    });
                    return null;
                }
            };
            bdAsyncTask.setPriority(4);
            bdAsyncTask.execute(new Void[0]);
        } else {
            jC();
        }
        jD();
        jF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC() {
        loadPlugin();
        if (Build.VERSION.SDK_INT > 10) {
            O(true);
        }
    }

    private void jD() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.DE) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DO, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.DE) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.Eh)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.Eh && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.jj().f("plugin_del_unuse", "server forbidden", str);
                bk(str);
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
                com.baidu.adp.plugin.packageManager.a.jp().a(arrayList, this.Dl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPlugin() {
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = jV.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                        if (!pluginSetting.isPatch || this.DJ <= 0) {
                            if (pluginSetting.enable && pluginSetting.installStatus != a.b.Eh) {
                                Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                                Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                                if (!launch.BW && plugin2 != null && !plugin2.isLoaded()) {
                                    i++;
                                    if (jw().isMainProcess()) {
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
                                        sb.append(launch.BY);
                                    }
                                }
                            }
                            i = i;
                        }
                    }
                }
                if (jw().isMainProcess()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.jj().c("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    private void jE() {
        if (this.DE) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().P(false);
        }
    }

    public void O(boolean z) {
        if (this.DE) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV(), z, this.DP);
        }
    }

    private void jF() {
        MessageManager.getInstance().registerListener(2000987, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.packageManager.PluginPackageManager.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PluginSettings jV;
                PluginNetConfigInfos jT;
                List<PluginNetConfigInfos.PluginConfig> configs;
                boolean z = false;
                Object data = customResponsedMessage.getData();
                if (data != null && (data instanceof PluginNetConfigInfos.PluginConfig) && (jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV()) != null) {
                    if (jV == null || !PluginPackageManager.this.F(PluginPackageManager.this.DF, jV.getContainerVersion())) {
                        PluginNetConfigInfos.PluginConfig pluginConfig = (PluginNetConfigInfos.PluginConfig) data;
                        if (!TextUtils.isEmpty(pluginConfig.package_name) && (jT = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT()) != null && (configs = jT.getConfigs()) != null) {
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
                            PluginPackageManager.this.a(com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().c(com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV()), pluginConfig);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().setForbiddenFeatures(PluginPackageManager.this.g(configs));
                            PluginPackageManager.this.jG();
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
        List<BasicNameValuePair> jR;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.Eg) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.DE) {
                    com.baidu.adp.plugin.b.a.jj().c("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.jj().c("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().n(pluginConfig.package_name, a.b.Eh);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < DA && this.DE) {
                    com.baidu.adp.plugin.b.a.jj().c("plugin_install", "server_config_versionlower", pluginConfig.package_name, DA + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (jR = cVar.jR()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(jR)) {
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
                                com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.jj().c("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().n(pluginConfig.package_name, a.b.Eh);
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
                            if (pluginConfig.newest.download_type == a.C0010a.Ef) {
                                pluginSetting.installStatus = a.b.Ei;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0010a.WIFI) {
                                    pluginSetting.installStatus = a.b.Ej;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0010a.Ef) {
                            pluginSetting.installStatus = a.b.Ei;
                        } else if (pluginConfig.newest.download_type == a.C0010a.WIFI) {
                            pluginSetting.installStatus = a.b.Ej;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.iR().l(pluginSetting.packageName, pluginSetting.rollback);
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
    public void jG() {
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : jV.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.Eh) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.Eg) {
                        D(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.Ej && i.hj()) || pluginSetting.installStatus == a.b.Ei) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bz(pluginSetting.packageName);
                    if (pluginSetting.versionCode < DA) {
                        com.baidu.adp.plugin.b.a.jj().B("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.jj().c("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.forbidden + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.tempVersionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.DE && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.jj().f("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jQ().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jQ().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DQ, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.DE) {
            c.ju().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.DM = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.I(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bl(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bl(str);
    }

    public void bm(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bm(str);
    }

    public String jH() {
        return this.DF;
    }

    public boolean isMainProcess() {
        return this.DE;
    }

    public boolean jI() {
        return this.isThirdProcess;
    }

    public boolean bn(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bo(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV().isFeatureForbidden(str);
    }

    public boolean bp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos jT = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT();
        if (jT != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = jT.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().a(findPluginSetting.packageName, findPluginSetting);
            this.DM = dVar;
            a(findPluginSetting, this.DQ, true);
        }
    }

    public boolean jJ() {
        return jL() && !this.DG;
    }

    public void jK() {
        this.DG = true;
    }

    public boolean jL() {
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV == null || jV.getPlugins() == null || jV.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : jV.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bp(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos jT;
        if (TextUtils.isEmpty(str) || (jT = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT()) == null) {
            return null;
        }
        return jT.getPluginConfig(str);
    }

    public void bq(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jQ().bu(str);
        }
    }

    public boolean br(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jQ().br(str);
    }

    public PluginStatus bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str);
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

    public void jM() {
        if (this.isInit) {
            b.jr().clear(this.DE);
        }
    }

    public void aC(int i) {
        this.DJ = i;
    }

    public int jN() {
        return this.DJ;
    }
}
