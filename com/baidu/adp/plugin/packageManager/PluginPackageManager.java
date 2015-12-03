package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
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
    private static int DE = 2;
    private static volatile PluginPackageManager DF = null;
    private Hashtable<String, a> DG;
    private String DI;
    private boolean DJ;
    private e DO;
    private boolean DH = false;
    private long DK = 0;
    private boolean DL = false;
    private final String DM = "com.baidu.adp.plugin.currentpath";
    private final String DN = "current_path";
    private BroadcastReceiver DP = new f(this);
    private BroadcastReceiver DQ = new g(this);
    private a.c Do = new h(this);
    private com.baidu.adp.plugin.install.a CK = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DR = new j(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DS = new k(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (Eb) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager lU() {
        if (DF == null) {
            synchronized (PluginPackageManager.class) {
                if (DF == null) {
                    DF = new PluginPackageManager();
                }
            }
        }
        return DF;
    }

    private PluginPackageManager() {
        this.DG = null;
        this.DG = new Hashtable<>();
        ls();
    }

    private void ls() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.DP, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bo = bo(str);
        boolean bh = com.baidu.adp.plugin.install.d.lr().bh(str);
        if (bo && !bh) {
            bVar.bg(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.Ea = bVar;
            synchronized (this) {
                if (this.DG.size() < 1000) {
                    this.DG.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.DG.remove(str);
        if (remove != null && remove.Ea != null) {
            if (z) {
                remove.Ea.bg(str);
            } else {
                remove.Ea.D(remove.packageName, str2);
            }
        }
    }

    private void lV() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.DG.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.Ea != null) {
                        value.Ea.D(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bo(String str) {
        return bt(str);
    }

    public PluginSetting bp(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
    }

    public void H(String str, String str2) {
        File file;
        if (this.DH) {
            com.baidu.adp.plugin.b.a.lI().e("plugin_install", str2, null);
            if (!Util.j(new File(str).length())) {
                com.baidu.adp.plugin.install.m.c(str, str2, "rom_size", String.valueOf(Util.mC()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.lr().x(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.lI().d("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lW() {
        if (this.DH) {
            com.baidu.adp.plugin.install.d.lr().a(this.mContext, this.CK);
        }
    }

    private void bq(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.lO().a(arrayList, this.Do);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b Ea;
        String packageName;
        long timestamp;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(PluginPackageManager pluginPackageManager, a aVar) {
            this();
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z, boolean z2) {
        if (this.DL) {
            com.baidu.adp.plugin.b.a.lI().bl("plugin_pkgmanager_recreate");
        }
        this.DH = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mj().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().a(bVar2);
        this.DI = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().a(new m(this, str, z2));
        lY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX() {
        lZ();
        if (Build.VERSION.SDK_INT > 10) {
            mb();
        }
    }

    private void lY() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.DH) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DQ, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.DH) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.En)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.En && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lI().h("plugin_del_unuse", "server forbidden", str);
                bq(str);
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
                com.baidu.adp.plugin.packageManager.a.lO().a(arrayList, this.Do);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ() {
        PluginSettings mo = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo();
        if (mo != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<String, PluginSetting> entry : mo.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != a.b.En) {
                    a.b launch = PluginCenter.getInstance().launch(value.packageName);
                    com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(value.packageName);
                    if (!launch.Cq && plugin2 != null && !plugin2.isLoaded()) {
                        i++;
                        if (lU().hs()) {
                            if (sb.length() > 0) {
                                sb.append(",");
                            }
                            sb.append(value.packageName);
                            sb.append("-");
                            sb.append(value.apkPath);
                            sb.append("-");
                            sb.append(value.forbidden);
                            sb.append("-");
                            sb.append(value.enable);
                            sb.append("-");
                            sb.append(value.installStatus);
                            sb.append("-");
                            sb.append(value.versionCode);
                            sb.append("-");
                            sb.append(value.install_fail_count);
                            sb.append("-");
                            sb.append(value.getAbandon_apk_path());
                            sb.append("-");
                            sb.append(launch.reason);
                            sb.append("-");
                            sb.append(launch.Cr);
                        }
                    }
                }
            }
            if (lU().hs()) {
                if (i > 0) {
                    com.baidu.adp.plugin.b.a.lI().d("plugin_load", "load_allplugin", null, sb.toString());
                }
                PluginCenter.getInstance().logPluginLoadStat();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma() {
        if (this.DH) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().N(false);
        }
    }

    public void mb() {
        if (this.DH) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo(), this.DR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> mk;
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    PluginSetting pluginSetting2 = new PluginSetting();
                    pluginSetting2.enable = false;
                    pluginSetting2.packageName = pluginConfig.package_name;
                    pluginSetting = pluginSetting2;
                } else {
                    pluginSetting = findPluginSetting;
                }
                if (pluginSetting.installStatus == a.b.Em) {
                    String f = Util.f(pluginSetting);
                    if (!new File(f).exists() && this.DH) {
                        com.baidu.adp.plugin.b.a.lI().d("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                    }
                }
                pluginSetting.priority = pluginConfig.priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.b.a.lI().d("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().g(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().l(pluginConfig.package_name, a.b.En);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                        if (cVar != null && (mk = cVar.mk()) != null) {
                            for (BasicNameValuePair basicNameValuePair : new ArrayList(mk)) {
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
                            com.baidu.adp.plugin.b.a.lI().d("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + "-" + pluginSetting.apkPath);
                        } else {
                            com.baidu.adp.plugin.b.a.lI().d("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + "-config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().g(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().l(pluginConfig.package_name, a.b.En);
                    } else {
                        pluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                            pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            pluginSetting.url = pluginConfig.newest.url;
                            pluginSetting.tempMd5 = pluginConfig.newest.md5;
                            pluginSetting.install_fail_count = 0;
                            pluginSetting.installStatus = 0;
                            pluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == a.C0011a.El) {
                                pluginSetting.installStatus = a.b.Eo;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                pluginSetting.installStatus = a.b.Ep;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().a(pluginConfig.package_name, pluginSetting);
                    }
                } else {
                    if (pluginSetting.versionCode == 0) {
                        pluginSetting.enable = false;
                    } else {
                        pluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.El) {
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
                            if (pluginConfig.newest.download_type == a.C0011a.El) {
                                pluginSetting.installStatus = a.b.Eo;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                pluginSetting.installStatus = a.b.Ep;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().a(pluginConfig.package_name, pluginSetting);
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
    public void mc() {
        PluginSettings mo = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo();
        if (mo != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : mo.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().g(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.En) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.Em) {
                        H(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.Ep && com.baidu.adp.lib.util.i.iQ()) || pluginSetting.installStatus == a.b.Eo) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bF(pluginSetting.packageName);
                    if (pluginSetting.versionCode < 42) {
                        com.baidu.adp.plugin.b.a.lI().F("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.lI().d("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.DH && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.lI().h("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mj().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mj().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DS, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.DH) {
            d.lT().a(pluginSetting);
        }
    }

    public void a(e eVar) {
        this.DO = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.M(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void br(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().br(str);
    }

    public void bs(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bs(str);
    }

    public boolean hs() {
        return this.DH;
    }

    public boolean bt(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bu(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo().isFeatureForbidden(str);
    }

    public boolean bv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos mm = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().mm();
        if (mm != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = mm.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().a(findPluginSetting.packageName, findPluginSetting);
            this.DO = eVar;
            a(findPluginSetting, this.DS, true);
        }
    }

    public boolean md() {
        return mf() && !this.DJ;
    }

    public void me() {
        this.DJ = true;
    }

    public boolean mf() {
        PluginSettings mo = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo();
        if (mo == null || mo.getPlugins() == null || mo.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mo.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bv(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos mm;
        if (TextUtils.isEmpty(str) || (mm = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().mm()) == null) {
            return null;
        }
        return mm.getPluginConfig(str);
    }

    public void bw(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mj().bA(str);
        }
    }

    public boolean bx(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mj().bx(str);
    }

    public PluginStatus by(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str);
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

    public void mg() {
        if (this.DL) {
            b.lQ().clear(this.DH);
        }
    }
}
