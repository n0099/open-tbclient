package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.a;
import com.baidu.adp.plugin.install.m;
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
/* loaded from: classes.dex */
public class PluginPackageManager {
    private static int Dt = 2;
    private static volatile PluginPackageManager Du = null;
    private d DD;
    private Hashtable<String, a> Dv;
    private String Dx;
    private boolean Dy;
    private boolean Dw = false;
    private long Dz = 0;
    private boolean DA = false;
    private final String DB = "com.baidu.adp.plugin.currentpath";
    private final String DC = "current_path";
    private BroadcastReceiver DE = new e(this);
    private BroadcastReceiver DF = new f(this);
    private a.c Dh = new g(this);
    private com.baidu.adp.plugin.install.a CE = new h(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DG = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DH = new j(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (DM) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager lS() {
        if (Du == null) {
            synchronized (PluginPackageManager.class) {
                if (Du == null) {
                    Du = new PluginPackageManager();
                }
            }
        }
        return Du;
    }

    private PluginPackageManager() {
        this.Dv = null;
        this.Dv = new Hashtable<>();
        lr();
    }

    private void lr() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            this.mContext.registerReceiver(this.DE, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bk = bk(str);
        boolean bd = com.baidu.adp.plugin.install.d.lq().bd(str);
        if (bk && !bd) {
            bVar.bc(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.DL = bVar;
            synchronized (this) {
                if (this.Dv.size() < 1000) {
                    this.Dv.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.Dv.remove(str);
        if (remove != null && remove.DL != null) {
            if (z) {
                remove.DL.bc(str);
            } else {
                remove.DL.C(remove.packageName, str2);
            }
        }
    }

    private void lT() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Dv.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.DL != null) {
                        value.DL.C(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bk(String str) {
        return bp(str);
    }

    public PluginSetting bl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str);
    }

    public void K(String str, String str2) {
        File file;
        if (this.Dw) {
            com.baidu.adp.plugin.b.a.lG().a("plugin_install", str2, (PluginSetting) null);
            com.baidu.adp.plugin.b.a.lG().d("plugin_install", "plugin_install", str2, null);
            if (!Util.j(new File(str).length())) {
                m.c(str, str2, "rom_size", String.valueOf(Util.my()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.lq().x(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.lG().d("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lU() {
        if (this.Dw) {
            com.baidu.adp.plugin.install.d.lq().a(this.mContext, this.CE);
        }
    }

    private void bm(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.lM().a(arrayList, this.Dh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b DL;
        String packageName;
        long timestamp;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(PluginPackageManager pluginPackageManager, a aVar) {
            this();
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z) {
        this.Dw = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mg().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mi().a(bVar2);
        this.Dx = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().a(new l(this, str));
        lV();
    }

    private void lV() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Dw) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DF, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Dw) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.DZ)) {
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
    public void L(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.DZ && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lG().g("plugin_del_unuse", "server forbidden", str);
                bm(str);
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
                com.baidu.adp.plugin.b.a.lG().g("plugin_del_unuse", "scan unuse", str);
                com.baidu.adp.plugin.packageManager.a.lM().a(arrayList, this.Dh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW() {
        PluginSettings ml = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml();
        if (ml != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<String, PluginSetting> entry : ml.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != a.b.DZ) {
                    a.b launch = PluginCenter.getInstance().launch(value.packageName);
                    com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(value.packageName);
                    if (!launch.Cj && plugin2 != null && !plugin2.isLoaded()) {
                        i++;
                        if (lS().hq()) {
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
                            sb.append(launch.Ck);
                        }
                    }
                }
            }
            if (lS().hq()) {
                if (i > 0) {
                    com.baidu.adp.plugin.b.a.lG().d("plugin_load", "load_allplugin", null, sb.toString());
                }
                PluginCenter.getInstance().logPluginLoadStat();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX() {
        if (this.Dw) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().N(false);
        }
    }

    public void lY() {
        if (this.Dw) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mi().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml(), this.DG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                if (findPluginSetting.installStatus == a.b.DY) {
                    String f = Util.f(findPluginSetting);
                    if (!new File(f).exists() && this.Dw) {
                        com.baidu.adp.plugin.b.a.lG().d("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                    }
                }
                findPluginSetting.priority = pluginConfig.priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.b.a.lG().d("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().l(pluginConfig.package_name, a.b.DZ);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        if (pluginConfig.newest == null) {
                            com.baidu.adp.plugin.b.a.lG().d("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, null);
                        } else {
                            com.baidu.adp.plugin.b.a.lG().d("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, null);
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().l(pluginConfig.package_name, a.b.DZ);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.install_fail_count = 0;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == a.C0011a.DX) {
                                findPluginSetting.installStatus = a.b.Ea;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                findPluginSetting.installStatus = a.b.Eb;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.DX) {
                        if (pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.enable = false;
                        }
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.install_fail_count = 0;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == a.C0011a.DX) {
                                findPluginSetting.installStatus = a.b.Ea;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                findPluginSetting.installStatus = a.b.Eb;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().a(pluginConfig.package_name, findPluginSetting);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(List<PluginNetConfigInfos.PluginConfig> list) {
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
    public void lZ() {
        PluginSettings ml = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml();
        if (ml != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : ml.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.DZ) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.DY) {
                        K(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.Eb && com.baidu.adp.lib.util.i.iO()) || pluginSetting.installStatus == a.b.Ea) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().bB(pluginSetting.packageName);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.Dw && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.lG().g("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mg().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mg().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Dw) {
            c.lR().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.DD = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.P(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bn(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().bn(str);
    }

    public void bo(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().bo(str);
    }

    public boolean hq() {
        return this.Dw;
    }

    public boolean bp(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bq(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml().isFeatureForbidden(str);
    }

    public boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos mj = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mi().mj();
        if (mj != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = mj.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str);
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
            if ((pluginConfig.newest == null || pluginConfig.newest.version_code <= 0 || TextUtils.isEmpty(pluginConfig.newest.url)) && dVar != null) {
                dVar.c(new BdFileDownloadData(pluginConfig.package_name));
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().a(findPluginSetting.packageName, findPluginSetting);
            this.DD = dVar;
            a(findPluginSetting, this.DH, true);
        }
    }

    public boolean ma() {
        return mc() && !this.Dy;
    }

    public void mb() {
        this.Dy = true;
    }

    public boolean mc() {
        PluginSettings ml = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml();
        if (ml == null || ml.getPlugins() == null || ml.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : ml.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && br(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos mj;
        if (TextUtils.isEmpty(str) || (mj = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mi().mj()) == null) {
            return null;
        }
        return mj.getPluginConfig(str);
    }

    public void bs(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mg().bw(str);
        }
    }

    public boolean bt(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mg().bt(str);
    }

    public PluginStatus bu(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str);
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

    public void md() {
        if (this.DA) {
            b.lO().clear(this.Dw);
        }
    }
}
