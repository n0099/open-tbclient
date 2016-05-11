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
    private static int uG = 43;
    private static int uH = 2;
    private static volatile PluginPackageManager uI = null;
    private Hashtable<String, a> uJ;
    private String uL;
    private boolean uM;
    private e uT;
    private boolean uK = false;
    private boolean isThirdProcess = false;
    private long uN = 0;
    private boolean uO = false;
    private boolean uP = false;
    private int uQ = 0;
    private final String uR = "com.baidu.adp.plugin.currentpath";
    private final String uS = "current_path";
    private BroadcastReceiver uU = new f(this);
    private BroadcastReceiver uV = new g(this);
    private a.c ur = new h(this);
    private com.baidu.adp.plugin.install.a tJ = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a uW = new j(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a uX = new k(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (vc) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static final int hE() {
        return uG;
    }

    public static PluginPackageManager hF() {
        if (uI == null) {
            synchronized (PluginPackageManager.class) {
                if (uI == null) {
                    uI = new PluginPackageManager();
                }
            }
        }
        return uI;
    }

    private PluginPackageManager() {
        this.uJ = null;
        this.uJ = new Hashtable<>();
        hb();
    }

    private void hb() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.deleted");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.uU, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public boolean hG() {
        return this.uP;
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bi = bi(str);
        boolean bb = com.baidu.adp.plugin.install.d.ha().bb(str);
        if (bi && !bb) {
            bVar.ba(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.vb = bVar;
            synchronized (this) {
                if (this.uJ.size() < 1000) {
                    this.uJ.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        hH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.uJ.remove(str);
        if (remove != null && remove.vb != null) {
            if (z) {
                remove.vb.ba(str);
            } else {
                remove.vb.B(remove.packageName, str2);
            }
        }
    }

    private void hH() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.uJ.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.vb != null) {
                        value.vb.B(value.packageName, "plugin install time out");
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
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str);
    }

    public void F(String str, String str2) {
        File file;
        if (this.uK) {
            com.baidu.adp.plugin.b.a.hs().e("plugin_install", str2, null);
            if (!Util.j(new File(str).length())) {
                com.baidu.adp.plugin.install.m.d(str, str2, "rom_size", String.valueOf(Util.it()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.ha().o(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.hs().e("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void hI() {
        if (this.uK) {
            com.baidu.adp.plugin.install.d.ha().a(this.mContext, this.tJ);
        }
    }

    private void bk(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.hy().a(arrayList, this.ur);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        String packageName;
        long timestamp;
        com.baidu.adp.plugin.install.b vb;

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
    public boolean hJ() {
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if == null || m9if.getPlugins() == null || H(this.uL, m9if.getContainerVersion())) {
            return false;
        }
        for (PluginSetting pluginSetting : m9if.getPlugins().values()) {
            if (!(!pluginSetting.enable || pluginSetting.forbidden || !pluginSetting.isPatch || m9if.isFeatureForbidden(pluginSetting.packageName)) || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
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
                            if (!Util.ir()) {
                                if (!PluginNative.bLoadLibrary) {
                                    com.baidu.adp.plugin.b.a.hs().bf("hook_loadlibrary_falied");
                                } else {
                                    int hookdvmResolveClass = PluginNative.hookdvmResolveClass();
                                    if (hookdvmResolveClass != 0) {
                                        com.baidu.adp.plugin.b.a.hs().bf("hook_failed");
                                        com.baidu.adp.plugin.b.a.hs().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "plugin_patch_hook_failed : " + hookdvmResolveClass);
                                    } else {
                                        z = false;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            com.baidu.adp.plugin.b.a.hs().f("plugin_load", "plugin_patch_hook_failed", pluginSetting.packageName, "exception : " + th.getMessage());
                            return;
                        }
                    }
                    PluginCenter.getInstance().launch(pluginSetting.packageName);
                }
            }
        }
    }

    public void hK() {
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if != null && !H(this.uL, m9if.getContainerVersion())) {
            b(m9if);
        }
    }

    public void d(String str, boolean z, boolean z2) {
        this.uK = z;
        this.isThirdProcess = z2;
        this.uL = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            uG = com.baidu.adp.lib.h.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), uG);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a((com.baidu.adp.plugin.packageManager.pluginSettings.f) null);
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, boolean z) {
        if (this.uO) {
            com.baidu.adp.plugin.b.a.hs().bf("plugin_pkgmanager_recreate");
        }
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ia().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().a(bVar2);
        this.uO = true;
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if == null || (m9if != null && H(this.uL, m9if.getContainerVersion()))) {
            this.uN = System.currentTimeMillis();
            if (hF().dU()) {
                com.baidu.adp.plugin.b.a.hs().e("plugin_setting", "version_update", null, String.valueOf(this.uL) + "-" + (m9if == null ? "" : m9if.getContainerVersion()));
            }
            hO();
            hI();
        } else if ((com.baidu.adp.lib.a.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && z) {
            m mVar = new m(this);
            mVar.setPriority(4);
            mVar.execute(new Void[0]);
        } else {
            hL();
        }
        hM();
        hP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL() {
        hN();
        if (Build.VERSION.SDK_INT > 10) {
            I(false);
        }
    }

    private void hM() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.uK) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.uV, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.uK) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.vo)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.vo && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.hs().h("plugin_del_unuse", "server forbidden", str);
                bk(str);
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
                com.baidu.adp.plugin.packageManager.a.hy().a(arrayList, this.ur);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hN() {
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = m9if.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && (!pluginSetting.isPatch || !TextUtils.isEmpty(pluginSetting.replaceMethodClasses))) {
                        if (!pluginSetting.isPatch || this.uQ <= 0) {
                            if (pluginSetting.enable && pluginSetting.installStatus != a.b.vo) {
                                Plugin.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                                Plugin plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                                if (!launch.sZ && plugin2 != null && !plugin2.isLoaded()) {
                                    i++;
                                    if (hF().dU()) {
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
                                        sb.append(launch.tb);
                                    }
                                }
                            }
                        }
                    }
                }
                if (hF().dU()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.hs().e("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    private void hO() {
        if (this.uK) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().J(false);
        }
    }

    public void I(boolean z) {
        if (this.uK) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if(), z, this.uW);
        }
    }

    private void hP() {
        MessageManager.getInstance().registerListener(2000987, new o(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> ib;
        boolean z;
        boolean z2 = false;
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                PluginSetting pluginSetting2 = new PluginSetting();
                pluginSetting2.enable = false;
                pluginSetting2.packageName = pluginConfig.package_name;
                pluginSetting = pluginSetting2;
            } else {
                pluginSetting = findPluginSetting;
            }
            if (pluginSetting.installStatus == a.b.vn) {
                String f = Util.f(pluginSetting);
                if (!new File(f).exists() && this.uK) {
                    com.baidu.adp.plugin.b.a.hs().e("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
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
                    com.baidu.adp.plugin.b.a.hs().e("plugin_install", "server_config_ext_format_error", pluginConfig.package_name, pluginConfig.ext);
                }
            }
            if (pluginConfig.forbidden == 1) {
                com.baidu.adp.plugin.b.a.hs().e("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().f(pluginConfig.package_name, false);
                com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().n(pluginConfig.package_name, a.b.vo);
            } else {
                if (pluginConfig.newest != null && pluginConfig.newest.version_code < uG && this.uK) {
                    com.baidu.adp.plugin.b.a.hs().e("plugin_install", "server_config_versionlower", pluginConfig.package_name, String.valueOf(uG) + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                }
                if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (pluginSetting.rollback > 0) {
                            pluginSetting.tempVersionCode = 0;
                            pluginSetting.url = null;
                            pluginSetting.tempMd5 = null;
                            pluginSetting.installStatus = 0;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(pluginConfig.package_name, pluginSetting);
                            z2 = true;
                        } else {
                            if (cVar != null && (ib = cVar.ib()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(ib)) {
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
                                com.baidu.adp.plugin.b.a.hs().e("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + "-" + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.hs().e("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + "-config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().f(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().n(pluginConfig.package_name, a.b.vo);
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
                            if (pluginConfig.newest.download_type == a.C0012a.vm) {
                                pluginSetting.installStatus = a.b.vp;
                                z = false;
                            } else {
                                if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                                    pluginSetting.installStatus = a.b.vq;
                                    z = false;
                                }
                                z = false;
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(pluginConfig.package_name, pluginSetting);
                            z2 = z;
                        } else {
                            if (pluginSetting.rollback > 0) {
                                pluginSetting.tempVersionCode = 0;
                                pluginSetting.url = null;
                                pluginSetting.tempMd5 = null;
                                pluginSetting.installStatus = 0;
                                z = true;
                                com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(pluginConfig.package_name, pluginSetting);
                                z2 = z;
                            }
                            z = false;
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(pluginConfig.package_name, pluginSetting);
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
                        if (pluginConfig.newest.download_type == a.C0012a.vm) {
                            pluginSetting.installStatus = a.b.vp;
                        } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                            pluginSetting.installStatus = a.b.vq;
                        }
                    } else if (pluginSetting.rollback > 0) {
                        pluginSetting.tempVersionCode = 0;
                        pluginSetting.url = null;
                        pluginSetting.tempMd5 = null;
                        pluginSetting.installStatus = 0;
                        z2 = true;
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(pluginConfig.package_name, pluginSetting);
                }
            }
            if (pluginSetting.rollback > 0 && z2) {
                com.baidu.adp.plugin.install.d.ha().l(pluginSetting.packageName, pluginSetting.rollback);
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
    public void hQ() {
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : m9if.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.vo) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.vn) {
                        F(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.vq && com.baidu.adp.lib.util.i.fr()) || pluginSetting.installStatus == a.b.vp) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().bz(pluginSetting.packageName);
                    if (pluginSetting.versionCode < uG) {
                        com.baidu.adp.plugin.b.a.hs().D("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.hs().e("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.uK && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.j(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.hs().h("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ia().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ia().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.uX, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.uK) {
            d.hD().a(pluginSetting);
        }
    }

    public void a(e eVar) {
        this.uT = eVar;
    }

    private boolean H(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.K(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bl(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().bl(str);
    }

    public void bm(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().bm(str);
    }

    public String hR() {
        return this.uL;
    }

    public boolean dU() {
        return this.uK;
    }

    public boolean hS() {
        return this.isThirdProcess;
    }

    public boolean bn(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bo(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if().isFeatureForbidden(str);
    }

    public boolean bp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos id = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().id();
        if (id != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = id.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().a(findPluginSetting.packageName, findPluginSetting);
            this.uT = eVar;
            a(findPluginSetting, this.uX, true);
        }
    }

    public boolean hT() {
        return hV() && !this.uM;
    }

    public void hU() {
        this.uM = true;
    }

    public boolean hV() {
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if == null || m9if.getPlugins() == null || m9if.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : m9if.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bp(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos id;
        if (TextUtils.isEmpty(str) || (id = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().id()) == null) {
            return null;
        }
        return id.getPluginConfig(str);
    }

    public void bq(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ia().bu(str);
        }
    }

    public boolean br(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ia().br(str);
    }

    public PluginStatus bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting(str);
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

    public void hW() {
        if (this.uO) {
            b.hA().clear(this.uK);
        }
    }

    public void am(int i) {
        this.uQ = i;
    }

    public int hX() {
        return this.uQ;
    }
}
