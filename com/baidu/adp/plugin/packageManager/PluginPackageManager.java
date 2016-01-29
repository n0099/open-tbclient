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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.PluginNative;
import com.baidu.adp.plugin.a;
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
    private static int Ej = 43;
    private static int Ek = 2;
    private static volatile PluginPackageManager El = null;
    private Hashtable<String, a> Em;
    private String Eo;
    private boolean Ep;
    private e Ev;
    private boolean En = false;
    private boolean isThirdProcess = false;
    private long Eq = 0;
    private boolean Er = false;
    private boolean Es = false;
    private final String Et = "com.baidu.adp.plugin.currentpath";
    private final String Eu = "current_path";
    private BroadcastReceiver Ew = new f(this);
    private BroadcastReceiver Ex = new g(this);
    private a.c DU = new h(this);
    private com.baidu.adp.plugin.install.a Dm = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a Ey = new j(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a Ez = new k(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (EE) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static final int lC() {
        return Ej;
    }

    public static PluginPackageManager lD() {
        if (El == null) {
            synchronized (PluginPackageManager.class) {
                if (El == null) {
                    El = new PluginPackageManager();
                }
            }
        }
        return El;
    }

    private PluginPackageManager() {
        this.Em = null;
        this.Em = new Hashtable<>();
        kZ();
    }

    private void kZ() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.Ew, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean lE() {
        return this.Es;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean br = br(str);
        boolean bk = com.baidu.adp.plugin.install.d.kY().bk(str);
        if (br && !bk) {
            bVar.bj(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.ED = bVar;
            synchronized (this) {
                if (this.Em.size() < 1000) {
                    this.Em.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.Em.remove(str);
        if (remove != null && remove.ED != null) {
            if (z) {
                remove.ED.bj(str);
            } else {
                remove.ED.D(remove.packageName, str2);
            }
        }
    }

    private void lF() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Em.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.ED != null) {
                        value.ED.D(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean br(String str) {
        return bw(str);
    }

    public PluginSetting bs(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
    }

    public void H(String str, String str2) {
        File file;
        if (this.En) {
            com.baidu.adp.plugin.b.a.lq().e("plugin_install", str2, null);
            if (!Util.k(new File(str).length())) {
                com.baidu.adp.plugin.install.m.d(str, str2, "rom_size", String.valueOf(Util.mn()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.kY().x(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.lq().e("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lG() {
        if (this.En) {
            com.baidu.adp.plugin.install.d.kY().a(this.mContext, this.Dm);
        }
    }

    private void bt(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.lw().a(arrayList, this.DU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b ED;
        String packageName;
        long timestamp;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(PluginPackageManager pluginPackageManager, a aVar) {
            this();
        }
    }

    private void b(PluginSettings pluginSettings) {
        List<PluginSetting> pluginSettingsSortLoadPriorty;
        if (pluginSettings != null && pluginSettings.getPlugins() != null && (pluginSettingsSortLoadPriorty = pluginSettings.getPluginSettingsSortLoadPriorty()) != null) {
            boolean z = true;
            for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || pluginSettings.isFeatureForbidden(pluginSetting.packageName))) {
                    if (z && !Util.ml()) {
                        if (!PluginNative.bLoadLibrary || !PluginNative.hookdvmResolveClass()) {
                            com.baidu.adp.plugin.b.a.lq().f("plugin_load", "loadPatchs_failed", pluginSetting.packageName, "patch Library load failed! " + pluginSetting.packageName);
                            return;
                        }
                        z = false;
                    }
                    PluginCenter.getInstance().launch(pluginSetting.packageName);
                }
            }
        }
    }

    public void lH() {
        PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
        if (lZ != null && !J(this.Eo, lZ.getContainerVersion())) {
            b(lZ);
        }
    }

    public void d(String str, boolean z, boolean z2) {
        this.En = z;
        this.isThirdProcess = z2;
        this.Eo = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            Ej = com.baidu.adp.lib.h.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), Ej);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().a((com.baidu.adp.plugin.packageManager.pluginSettings.f) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        if (this.Er) {
            com.baidu.adp.plugin.b.a.lq().bo("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lU().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().a(bVar2);
        this.Er = true;
        PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
        if (lZ == null || (lZ != null && J(this.Eo, lZ.getContainerVersion()))) {
            this.Eq = System.currentTimeMillis();
            if (lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_setting", "version_update", null, String.valueOf(this.Eo) + "-" + (lZ == null ? "" : lZ.getContainerVersion()));
            }
            lL();
            lG();
        } else if ((com.baidu.adp.lib.a.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
            m mVar = new m(this);
            mVar.setPriority(4);
            mVar.execute(new Void[0]);
        } else {
            lI();
        }
        lJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI() {
        lK();
        if (Build.VERSION.SDK_INT > 10) {
            J(false);
        }
    }

    private void lJ() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.En) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.Ex, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.En) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.ER)) {
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
    public void I(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.ER && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lq().h("plugin_del_unuse", "server forbidden", str);
                bt(str);
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
                com.baidu.adp.plugin.packageManager.a.lw().a(arrayList, this.DU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK() {
        PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
        if (lZ != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = lZ.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && !pluginSetting.isPatch && pluginSetting.enable && pluginSetting.installStatus != a.b.ER) {
                        a.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                        if (!launch.CF && plugin2 != null && !plugin2.isLoaded()) {
                            i++;
                            if (lD().hA()) {
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
                                sb.append(launch.CG);
                            }
                        }
                    }
                }
                if (lD().hA()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.lq().e("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    private void lL() {
        if (this.En) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().K(false);
        }
    }

    public void J(boolean z) {
        if (this.En) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ(), z, this.Ey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> lV;
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    PluginSetting pluginSetting2 = new PluginSetting();
                    pluginSetting2.enable = false;
                    pluginSetting2.packageName = pluginConfig.package_name;
                    pluginSetting = pluginSetting2;
                } else {
                    pluginSetting = findPluginSetting;
                }
                if (pluginSetting.installStatus == a.b.EQ) {
                    String f = Util.f(pluginSetting);
                    if (!new File(f).exists() && this.En) {
                        com.baidu.adp.plugin.b.a.lq().e("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                    }
                }
                pluginSetting.priority = pluginConfig.priority;
                pluginSetting.load_priority = pluginConfig.load_priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.b.a.lq().e("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().g(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().m(pluginConfig.package_name, a.b.ER);
                } else {
                    if (pluginConfig.newest != null && pluginConfig.newest.version_code < Ej && this.En) {
                        com.baidu.adp.plugin.b.a.lq().e("plugin_install", "server_config_versionlower", pluginConfig.package_name, String.valueOf(Ej) + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                    }
                    if (pluginConfig.enable == 1) {
                        if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                            if (cVar != null && (lV = cVar.lV()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(lV)) {
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
                                com.baidu.adp.plugin.b.a.lq().e("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + "-" + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.lq().e("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + "-config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().g(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().m(pluginConfig.package_name, a.b.ER);
                        } else {
                            pluginSetting.enable = false;
                            if (pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                                pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                                pluginSetting.url = pluginConfig.newest.url;
                                pluginSetting.tempMd5 = pluginConfig.newest.md5;
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                                pluginSetting.size = pluginConfig.newest.size;
                                if (pluginConfig.newest.download_type == a.C0012a.EP) {
                                    pluginSetting.installStatus = a.b.ES;
                                } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                                    pluginSetting.installStatus = a.b.ET;
                                }
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().a(pluginConfig.package_name, pluginSetting);
                        }
                    } else {
                        if (pluginSetting.versionCode == 0) {
                            pluginSetting.enable = false;
                        } else {
                            pluginSetting.enable = true;
                        }
                        if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.EP) {
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
                                if (pluginConfig.newest.download_type == a.C0012a.EP) {
                                    pluginSetting.installStatus = a.b.ES;
                                } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                                    pluginSetting.installStatus = a.b.ET;
                                }
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().a(pluginConfig.package_name, pluginSetting);
                    }
                }
            }
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
    public void lM() {
        PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
        if (lZ != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : lZ.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().g(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.ER) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.EQ) {
                        H(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.ET && com.baidu.adp.lib.util.i.ja()) || pluginSetting.installStatus == a.b.ES) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bI(pluginSetting.packageName);
                    if (pluginSetting.versionCode < Ej) {
                        com.baidu.adp.plugin.b.a.lq().F("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.lq().e("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.En && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.lq().h("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lU().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lU().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.Ez, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.En) {
            d.lB().a(pluginSetting);
        }
    }

    public void a(e eVar) {
        this.Ev = eVar;
    }

    private boolean J(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.M(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bu(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bu(str);
    }

    public void bv(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bv(str);
    }

    public boolean hA() {
        return this.En;
    }

    public boolean lN() {
        return this.isThirdProcess;
    }

    public boolean bw(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bx(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ().isFeatureForbidden(str);
    }

    public boolean by(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos lX = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().lX();
        if (lX != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = lX.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().a(findPluginSetting.packageName, findPluginSetting);
            this.Ev = eVar;
            a(findPluginSetting, this.Ez, true);
        }
    }

    public boolean lO() {
        return lQ() && !this.Ep;
    }

    public void lP() {
        this.Ep = true;
    }

    public boolean lQ() {
        PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
        if (lZ == null || lZ.getPlugins() == null || lZ.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : lZ.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && by(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos lX;
        if (TextUtils.isEmpty(str) || (lX = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().lX()) == null) {
            return null;
        }
        return lX.getPluginConfig(str);
    }

    public void bz(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lU().bD(str);
        }
    }

    public boolean bA(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lU().bA(str);
    }

    public PluginStatus bB(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str);
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

    public void lR() {
        if (this.Er) {
            b.ly().clear(this.En);
        }
    }
}
