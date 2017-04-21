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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PluginPackageManager {
    private static int Ef = 43;
    private static int Eg = 2;
    private static volatile PluginPackageManager Eh = null;
    private Hashtable<String, a> Ei;
    private String Ek;
    private boolean El;
    private e Er;
    private boolean Ej = false;
    private boolean isThirdProcess = false;
    private long Em = 0;
    private boolean isInit = false;
    private boolean En = false;
    private int Eo = 0;
    private final String Ep = "com.baidu.adp.plugin.currentpath";
    private final String Eq = "current_path";
    private BroadcastReceiver Es = new f(this);
    private BroadcastReceiver Et = new g(this);
    private a.c DQ = new h(this);
    private com.baidu.adp.plugin.install.a Dj = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a Eu = new j(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a Ev = new k(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (EA) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static final int jx() {
        return Ef;
    }

    public static PluginPackageManager jy() {
        if (Eh == null) {
            synchronized (PluginPackageManager.class) {
                if (Eh == null) {
                    Eh = new PluginPackageManager();
                }
            }
        }
        return Eh;
    }

    private PluginPackageManager() {
        this.Ei = null;
        this.Ei = new Hashtable<>();
        iU();
    }

    private void iU() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.Es, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean jz() {
        return this.En;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean aY = aY(str);
        boolean aR = com.baidu.adp.plugin.install.c.iT().aR(str);
        if (aY && !aR) {
            bVar.aQ(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.Ez = bVar;
            synchronized (this) {
                if (this.Ei.size() < 1000) {
                    this.Ei.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        jA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.Ei.remove(str);
        if (remove != null && remove.Ez != null) {
            if (z) {
                remove.Ez.aQ(str);
            } else {
                remove.Ez.z(remove.packageName, str2);
            }
        }
    }

    private void jA() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Ei.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.Ez != null) {
                        value.Ez.z(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean aY(String str) {
        return bd(str);
    }

    public PluginSetting aZ(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str);
    }

    public void D(String str, String str2) {
        File file;
        if (this.Ej) {
            com.baidu.adp.plugin.b.a.jl().e("plugin_install", str2, null);
            if (!Util.k(new File(str).length())) {
                com.baidu.adp.plugin.install.l.d(str, str2, "rom_size", String.valueOf(Util.kn()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.iT().H(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.jl().e("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void jB() {
        if (this.Ej) {
            com.baidu.adp.plugin.install.c.iT().a(this.mContext, this.Dj);
        }
    }

    private void ba(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.jr().a(arrayList, this.DQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b Ez;
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
    public boolean jC() {
        PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
        if (jY == null || jY.getPlugins() == null || F(this.Ek, jY.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : jY.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || jY.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
                            if (!Util.kl()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.jl().aV("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.jl().aV("hook_failed");
                                        com.baidu.adp.plugin.b.a.jl().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.jl().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                    if (launch != null && !launch.CB) {
                        com.baidu.adp.plugin.b.a.jl().aV("patch_launch_failed");
                    }
                }
            }
        }
    }

    public void jD() {
        PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
        if (jY != null && !F(this.Ek, jY.getContainerVersion())) {
            b(jY);
        }
    }

    public void d(String str, boolean z, boolean z2) {
        this.Ej = z;
        this.isThirdProcess = z2;
        this.Ek = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            Ef = com.baidu.adp.lib.g.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), Ef);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a((com.baidu.adp.plugin.packageManager.pluginSettings.f) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        if (this.isInit) {
            com.baidu.adp.plugin.b.a.jl().aV("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jT().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jV().a(bVar2);
        this.isInit = true;
        PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
        if (jY == null || (jY != null && F(this.Ek, jY.getContainerVersion()))) {
            this.Em = System.currentTimeMillis();
            if (jy().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jl().e("plugin_setting", "version_update", null, String.valueOf(this.Ek) + "-" + (jY == null ? "" : jY.getContainerVersion()));
            }
            jH();
            jB();
        } else if ((com.baidu.adp.lib.OrmObject.a.a.d(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
            m mVar = new m(this);
            mVar.setPriority(4);
            mVar.execute(new Void[0]);
        } else {
            jE();
        }
        jF();
        jI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jE() {
        jG();
        if (Build.VERSION.SDK_INT > 10) {
            N(true);
        }
    }

    private void jF() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Ej) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.Et, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Ej) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.EM)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.EM && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.jl().f("plugin_del_unuse", "server forbidden", str);
                ba(str);
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
                com.baidu.adp.plugin.packageManager.a.jr().a(arrayList, this.DQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jG() {
        PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
        if (jY != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = jY.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                        if (!pluginSetting.isPatch || this.Eo <= 0) {
                            if (pluginSetting.enable && pluginSetting.installStatus != a.b.EM) {
                                Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                                Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                                if (!launch.CB && plugin2 != null && !plugin2.isLoaded()) {
                                    i++;
                                    if (jy().isMainProcess()) {
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
                                        sb.append(launch.CD);
                                    }
                                }
                            }
                        }
                    }
                }
                if (jy().isMainProcess()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.jl().e("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    private void jH() {
        if (this.Ej) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().O(false);
        }
    }

    public void N(boolean z) {
        if (this.Ej) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jV().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY(), z, this.Eu);
        }
    }

    private void jI() {
        MessageManager.getInstance().registerListener(2000987, new o(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> jU;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.EL) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.Ej) {
                    com.baidu.adp.plugin.b.a.jl().e("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.jl().e("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.jl().e("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().f(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().n(pluginConfig.package_name, a.b.EM);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < Ef && this.Ej) {
                    com.baidu.adp.plugin.b.a.jl().e("plugin_install", "server_config_versionlower", pluginConfig.package_name, String.valueOf(Ef) + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (jU = cVar.jU()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(jU)) {
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
                                com.baidu.adp.plugin.b.a.jl().e("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + "-" + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.jl().e("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + "-config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().n(pluginConfig.package_name, a.b.EM);
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
                            if (pluginConfig.newest.download_type == a.C0010a.EK) {
                                pluginSetting.installStatus = a.b.EN;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0010a.WIFI) {
                                    pluginSetting.installStatus = a.b.EO;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0010a.EK) {
                            pluginSetting.installStatus = a.b.EN;
                        } else if (pluginConfig.newest.download_type == a.C0010a.WIFI) {
                            pluginSetting.installStatus = a.b.EO;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.c.iT().l(pluginSetting.packageName, pluginSetting.rollback);
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
    public void jJ() {
        PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
        if (jY != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : jY.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.EM) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.EL) {
                        D(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.EO && com.baidu.adp.lib.util.i.hl()) || pluginSetting.installStatus == a.b.EN) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().bp(pluginSetting.packageName);
                    if (pluginSetting.versionCode < Ef) {
                        com.baidu.adp.plugin.b.a.jl().B("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.jl().e("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.Ej && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.jl().f("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jT().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jT().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.Ev, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Ej) {
            d.jw().a(pluginSetting);
        }
    }

    public void a(e eVar) {
        this.Er = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.I(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bb(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().bb(str);
    }

    public void bc(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().bc(str);
    }

    public String jK() {
        return this.Ek;
    }

    public boolean isMainProcess() {
        return this.Ej;
    }

    public boolean jL() {
        return this.isThirdProcess;
    }

    public boolean bd(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean be(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY().isFeatureForbidden(str);
    }

    public boolean bf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos jW = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jV().jW();
        if (jW != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = jW.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str);
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
            if (pluginConfig.newest == null || pluginConfig.newest.version_code <= 0 || TextUtils.isEmpty(pluginConfig.newest.url)) {
                if (eVar != null) {
                    eVar.c(new BdFileDownloadData(pluginConfig.package_name));
                }
                if (pluginConfig.newest == null) {
                    return;
                }
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().a(findPluginSetting.packageName, findPluginSetting);
            this.Er = eVar;
            a(findPluginSetting, this.Ev, true);
        }
    }

    public boolean jM() {
        return jO() && !this.El;
    }

    public void jN() {
        this.El = true;
    }

    public boolean jO() {
        PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
        if (jY == null || jY.getPlugins() == null || jY.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : jY.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bf(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos jW;
        if (TextUtils.isEmpty(str) || (jW = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jV().jW()) == null) {
            return null;
        }
        return jW.getPluginConfig(str);
    }

    public void bg(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jT().bk(str);
        }
    }

    public boolean bh(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.jT().bh(str);
    }

    public PluginStatus bi(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().findPluginSetting(str);
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

    public void jP() {
        if (this.isInit) {
            b.jt().clear(this.Ej);
        }
    }

    public void aC(int i) {
        this.Eo = i;
    }

    public int jQ() {
        return this.Eo;
    }
}
