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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.PluginNative;
import com.baidu.adp.plugin.packageManager.a;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.a;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PluginPackageManager {
    private static int Eo = 43;
    private static int Ep = 2;
    private static volatile PluginPackageManager Eq = null;
    private e EA;
    private Hashtable<String, a> Er;
    private String Et;
    private boolean Eu;
    private boolean Es = false;
    private boolean isThirdProcess = false;
    private long Ev = 0;
    private boolean Ew = false;
    private boolean Ex = false;
    private final String Ey = "com.baidu.adp.plugin.currentpath";
    private final String Ez = "current_path";
    private BroadcastReceiver EB = new f(this);
    private BroadcastReceiver EC = new g(this);
    private a.c DZ = new h(this);
    private com.baidu.adp.plugin.install.a Dr = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a ED = new j(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a EE = new k(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (EJ) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static final int lr() {
        return Eo;
    }

    public static PluginPackageManager ls() {
        if (Eq == null) {
            synchronized (PluginPackageManager.class) {
                if (Eq == null) {
                    Eq = new PluginPackageManager();
                }
            }
        }
        return Eq;
    }

    private PluginPackageManager() {
        this.Er = null;
        this.Er = new Hashtable<>();
        kO();
    }

    private void kO() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.EB, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean lt() {
        return this.Ex;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bp = bp(str);
        boolean bi = com.baidu.adp.plugin.install.d.kN().bi(str);
        if (bp && !bi) {
            bVar.bh(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.EI = bVar;
            synchronized (this) {
                if (this.Er.size() < 1000) {
                    this.Er.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.Er.remove(str);
        if (remove != null && remove.EI != null) {
            if (z) {
                remove.EI.bh(str);
            } else {
                remove.EI.C(remove.packageName, str2);
            }
        }
    }

    private void lu() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Er.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.EI != null) {
                        value.EI.C(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bp(String str) {
        return bu(str);
    }

    public PluginSetting bq(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
    }

    public void G(String str, String str2) {
        File file;
        if (this.Es) {
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", str2, null);
            if (!Util.k(new File(str).length())) {
                com.baidu.adp.plugin.install.m.d(str, str2, "rom_size", String.valueOf(Util.mf()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.kN().o(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.lf().e("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lv() {
        if (this.Es) {
            com.baidu.adp.plugin.install.d.kN().a(this.mContext, this.Dr);
        }
    }

    private void br(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.ll().a(arrayList, this.DZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b EI;
        String packageName;
        long timestamp;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(PluginPackageManager pluginPackageManager, a aVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean lw() {
        PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
        if (lR == null || lR.getPlugins() == null || I(this.Et, lR.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : lR.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || lR.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
                    if (z && !Util.md()) {
                        if (!PluginNative.bLoadLibrary) {
                            com.baidu.adp.plugin.b.a.lf().bm("plugin_patch_hook_loadlibrary_falied");
                            return;
                        }
                        int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                        if (hookdvmResolveClass != 0) {
                            com.baidu.adp.plugin.b.a.lf().bm("plugin_patch_hook_failed");
                            com.baidu.adp.plugin.b.a.lf().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                            return;
                        }
                        z = false;
                    }
                    PluginCenter.getInstance().launch(pluginSetting.packageName);
                }
            }
        }
    }

    public void lx() {
        PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
        if (lR != null && !I(this.Et, lR.getContainerVersion())) {
            b(lR);
        }
    }

    public void d(String str, boolean z, boolean z2) {
        this.Es = z;
        this.isThirdProcess = z2;
        this.Et = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            Eo = com.baidu.adp.lib.h.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), Eo);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().a((com.baidu.adp.plugin.packageManager.pluginSettings.f) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        if (this.Ew) {
            com.baidu.adp.plugin.b.a.lf().bm("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lM().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().a(bVar2);
        this.Ew = true;
        PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
        if (lR == null || (lR != null && I(this.Et, lR.getContainerVersion()))) {
            this.Ev = System.currentTimeMillis();
            if (ls().hG()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_setting", "version_update", null, String.valueOf(this.Et) + "-" + (lR == null ? "" : lR.getContainerVersion()));
            }
            lB();
            lv();
        } else if ((com.baidu.adp.lib.a.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
            m mVar = new m(this);
            mVar.setPriority(4);
            mVar.execute(new Void[0]);
        } else {
            ly();
        }
        lz();
        lC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly() {
        lA();
        if (Build.VERSION.SDK_INT > 10) {
            I(false);
        }
    }

    private void lz() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Es) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.EC, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Es) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.EW)) {
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
    public void H(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.EW && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lf().h("plugin_del_unuse", "server forbidden", str);
                br(str);
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
                com.baidu.adp.plugin.packageManager.a.ll().a(arrayList, this.DZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
        if (lR != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = lR.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                        if (pluginSetting.enable && pluginSetting.installStatus != a.b.EW) {
                            Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                            Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                            if (!launch.CK && plugin2 != null && !plugin2.isLoaded()) {
                                i++;
                                if (ls().hG()) {
                                    if (sb.length() > 0) {
                                        sb.append(",");
                                    }
                                    sb.append(pluginSetting.packageName);
                                    sb.append("-");
                                    sb.append(pluginSetting.apkPath);
                                    sb.append("-");
                                    sb.append(pluginSetting.forbidden);
                                    sb.append("-");
                                    sb.append(pluginSetting.enable);
                                    sb.append("-");
                                    sb.append(pluginSetting.installStatus);
                                    sb.append("-");
                                    sb.append(pluginSetting.versionCode);
                                    sb.append("-");
                                    sb.append(pluginSetting.install_fail_count);
                                    sb.append("-");
                                    sb.append(pluginSetting.getAbandon_apk_path());
                                    sb.append("-");
                                    sb.append(launch.reason);
                                    sb.append("-");
                                    sb.append(launch.CL);
                                }
                            }
                        }
                    }
                }
                if (ls().hG()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.lf().e("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    private void lB() {
        if (this.Es) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().J(false);
        }
    }

    public void I(boolean z) {
        if (this.Es) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR(), z, this.ED);
        }
    }

    private void lC() {
        MessageManager.getInstance().registerListener(2000987, new o(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> lN;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.EV) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.Es) {
                    com.baidu.adp.plugin.b.a.lf().e("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                }
            }
            pluginSetting.priority = pluginConfig.priority;
            pluginSetting.load_priority = pluginConfig.load_priority;
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().f(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().m(pluginConfig.package_name, a.b.EW);
                return;
            }
            if (pluginConfig.newest != null && pluginConfig.newest.version_code < Eo && this.Es) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_install", "server_config_versionlower", pluginConfig.package_name, String.valueOf(Eo) + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
            }
            if (pluginConfig.enable == 1) {
                if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                    if (cVar != null && (lN = cVar.lN()) != null) {
                        for (BasicNameValuePair basicNameValuePair : new ArrayList(lN)) {
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
                        com.baidu.adp.plugin.b.a.lf().e("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + "-" + pluginSetting.apkPath);
                    } else {
                        com.baidu.adp.plugin.b.a.lf().e("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + "-config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().m(pluginConfig.package_name, a.b.EW);
                    return;
                }
                pluginSetting.enable = false;
                if (pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                    pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                    pluginSetting.url = pluginConfig.newest.url;
                    pluginSetting.tempMd5 = pluginConfig.newest.md5;
                    pluginSetting.install_fail_count = 0;
                    pluginSetting.installStatus = 0;
                    pluginSetting.size = pluginConfig.newest.size;
                    if (pluginConfig.newest.download_type == a.C0012a.EU) {
                        pluginSetting.installStatus = a.b.EX;
                    } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                        pluginSetting.installStatus = a.b.EY;
                    }
                }
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().a(pluginConfig.package_name, pluginSetting);
                return;
            }
            if (pluginSetting.versionCode == 0) {
                pluginSetting.enable = false;
            } else {
                pluginSetting.enable = true;
            }
            if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.EU) {
                if (pluginConfig.newest.version_code > pluginSetting.versionCode) {
                    pluginSetting.enable = false;
                }
                if (pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                    pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                    pluginSetting.url = pluginConfig.newest.url;
                    pluginSetting.tempMd5 = pluginConfig.newest.md5;
                    pluginSetting.install_fail_count = 0;
                    pluginSetting.installStatus = 0;
                    pluginSetting.size = pluginConfig.newest.size;
                    if (pluginConfig.newest.download_type == a.C0012a.EU) {
                        pluginSetting.installStatus = a.b.EX;
                    } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                        pluginSetting.installStatus = a.b.EY;
                    }
                }
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().a(pluginConfig.package_name, pluginSetting);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            a(cVar, pluginConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(List<PluginNetConfigInfos.PluginConfig> list) {
        if (list == null) {
            return "";
        }
        String str = "";
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                String str2 = pluginConfig.forbidden_features;
                if (!TextUtils.isEmpty(str2)) {
                    str = TextUtils.isEmpty(str) ? str2 : String.valueOf(str) + "," + str2;
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
        if (lR != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : lR.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.EW) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.EV) {
                        G(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.EY && com.baidu.adp.lib.util.i.jg()) || pluginSetting.installStatus == a.b.EX) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().bG(pluginSetting.packageName);
                    if (pluginSetting.versionCode < Eo) {
                        com.baidu.adp.plugin.b.a.lf().E("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.lf().e("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.Es && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.lf().h("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lM().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lM().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.EE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Es) {
            d.lq().a(pluginSetting);
        }
    }

    public void a(e eVar) {
        this.EA = eVar;
    }

    private boolean I(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.L(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bs(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().bs(str);
    }

    public void bt(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().bt(str);
    }

    public String lE() {
        return this.Et;
    }

    public boolean hG() {
        return this.Es;
    }

    public boolean lF() {
        return this.isThirdProcess;
    }

    public boolean bu(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bv(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR().isFeatureForbidden(str);
    }

    public boolean bw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos lP = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().lP();
        if (lP != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = lP.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
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

    public void a(PluginNetConfigInfos.PluginConfig pluginConfig, e eVar) {
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            if ((pluginConfig.newest == null || pluginConfig.newest.version_code <= 0 || TextUtils.isEmpty(pluginConfig.newest.url)) && eVar != null) {
                eVar.c(new BdFileDownloadData(pluginConfig.package_name));
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().a(findPluginSetting.packageName, findPluginSetting);
            this.EA = eVar;
            a(findPluginSetting, this.EE, true);
        }
    }

    public boolean lG() {
        return lI() && !this.Eu;
    }

    public void lH() {
        this.Eu = true;
    }

    public boolean lI() {
        PluginSettings lR = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().lR();
        if (lR == null || lR.getPlugins() == null || lR.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : lR.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bw(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos lP;
        if (TextUtils.isEmpty(str) || (lP = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().lP()) == null) {
            return null;
        }
        return lP.getPluginConfig(str);
    }

    public void bx(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lM().bB(str);
        }
    }

    public boolean by(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lM().by(str);
    }

    public PluginStatus bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(str);
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

    public void lJ() {
        if (this.Ew) {
            b.ln().clear(this.Es);
        }
    }
}
