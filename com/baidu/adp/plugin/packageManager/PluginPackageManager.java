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
    private static int Dr = 2;
    private static volatile PluginPackageManager Ds = null;
    private d DB;
    private Hashtable<String, a> Dt;
    private String Dv;
    private boolean Dw;
    private boolean Du = false;
    private long Dx = 0;
    private boolean Dy = false;
    private final String Dz = "com.baidu.adp.plugin.currentpath";
    private final String DA = "current_path";
    private BroadcastReceiver DC = new e(this);
    private BroadcastReceiver DD = new f(this);
    private a.c Df = new g(this);
    private com.baidu.adp.plugin.install.a CC = new h(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DE = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DF = new j(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (DK) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager lR() {
        if (Ds == null) {
            synchronized (PluginPackageManager.class) {
                if (Ds == null) {
                    Ds = new PluginPackageManager();
                }
            }
        }
        return Ds;
    }

    private PluginPackageManager() {
        this.Dt = null;
        this.Dt = new Hashtable<>();
        lq();
    }

    private void lq() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            this.mContext.registerReceiver(this.DC, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bm = bm(str);
        boolean bf = com.baidu.adp.plugin.install.d.lp().bf(str);
        if (bm && !bf) {
            bVar.be(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.DJ = bVar;
            synchronized (this) {
                if (this.Dt.size() < 1000) {
                    this.Dt.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.Dt.remove(str);
        if (remove != null && remove.DJ != null) {
            if (z) {
                remove.DJ.be(str);
            } else {
                remove.DJ.C(remove.packageName, str2);
            }
        }
    }

    private void lS() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Dt.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.DJ != null) {
                        value.DJ.C(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bm(String str) {
        return br(str);
    }

    public PluginSetting bn(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str);
    }

    public void K(String str, String str2) {
        File file;
        if (this.Du) {
            com.baidu.adp.plugin.b.a.lF().a("plugin_install", str2, (PluginSetting) null);
            if (!Util.l(new File(str).length())) {
                m.c(str, str2, "rom_size", String.valueOf(Util.mx()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.lp().x(this.mContext, str);
                    return;
                }
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lT() {
        if (this.Du) {
            com.baidu.adp.plugin.install.d.lp().a(this.mContext, this.CC);
        }
    }

    private void bo(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.lL().a(arrayList, this.Df);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b DJ;
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
        this.Du = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mf().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().a(bVar2);
        this.Dv = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().a(new l(this, str));
        lU();
    }

    private void lU() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Du) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DD, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Du) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.DX)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.DX && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lF().g("plugin_del_unuse", "server forbidden", str);
                bo(str);
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
                com.baidu.adp.plugin.b.a.lF().g("plugin_del_unuse", "scan unuse", str);
                com.baidu.adp.plugin.packageManager.a.lL().a(arrayList, this.Df);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV() {
        PluginSettings mk = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
        if (mk != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<String, PluginSetting> entry : mk.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != a.b.DX) {
                    a.b launch = PluginCenter.getInstance().launch(value.packageName);
                    com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(value.packageName);
                    if (!launch.Cj && plugin2 != null && !plugin2.isLoaded()) {
                        i++;
                        if (lR().hp()) {
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
                        }
                    }
                }
            }
            if (lR().hp() && i > 0) {
                com.baidu.adp.plugin.b.a.lF().d("plugin_load", "load_allplugin", null, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW() {
        if (this.Du) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().N(false);
        }
    }

    public void lX() {
        if (this.Du) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk(), this.DE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                if (findPluginSetting.installStatus == a.b.DW) {
                    String f = Util.f(findPluginSetting);
                    if (!new File(f).exists() && this.Du) {
                        com.baidu.adp.plugin.b.a.lF().d("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                    }
                }
                findPluginSetting.priority = pluginConfig.priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.b.a.lF().d("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().l(pluginConfig.package_name, a.b.DX);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        if (pluginConfig.newest == null) {
                            com.baidu.adp.plugin.b.a.lF().d("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, null);
                        } else {
                            com.baidu.adp.plugin.b.a.lF().d("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, null);
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().l(pluginConfig.package_name, a.b.DX);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.install_fail_count = 0;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == a.C0011a.DV) {
                                findPluginSetting.installStatus = a.b.DY;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                findPluginSetting.installStatus = a.b.DZ;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.DV) {
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
                            if (pluginConfig.newest.download_type == a.C0011a.DV) {
                                findPluginSetting.installStatus = a.b.DY;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                findPluginSetting.installStatus = a.b.DZ;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().a(pluginConfig.package_name, findPluginSetting);
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
    public void lY() {
        PluginSettings mk = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
        if (mk != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : mk.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.DX) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.DW) {
                        K(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.DZ && com.baidu.adp.lib.util.i.iN()) || pluginSetting.installStatus == a.b.DY) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().f(pluginSetting.packageName, true);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar) {
        if (this.Du && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            if (!Util.l(pluginSetting.size)) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.lF().g("plugin_download", "rom too small", pluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mf().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Du) {
            c.lQ().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.DB = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.P(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bp(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bp(str);
    }

    public void bq(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bq(str);
    }

    public boolean hp() {
        return this.Du;
    }

    public boolean br(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bs(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk().isFeatureForbidden(str);
    }

    public boolean bt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos mi = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi();
        if (mi != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = mi.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().a(findPluginSetting.packageName, findPluginSetting);
            this.DB = dVar;
            a(findPluginSetting, this.DF);
        }
    }

    public boolean lZ() {
        return mb() && !this.Dw;
    }

    public void ma() {
        this.Dw = true;
    }

    public boolean mb() {
        PluginSettings mk = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
        if (mk == null || mk.getPlugins() == null || mk.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mk.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bt(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos mi;
        if (TextUtils.isEmpty(str) || (mi = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi()) == null) {
            return null;
        }
        return mi.getPluginConfig(str);
    }

    public void bu(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mf().by(str);
        }
    }

    public boolean bv(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mf().bv(str);
    }

    public PluginStatus bw(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(str);
        if (findPluginSetting == null || !findPluginSetting.enable) {
            return PluginStatus.DISABLE;
        }
        if (findPluginSetting.forbidden && findPluginSetting.enable) {
            return PluginStatus.FORBIDDEN;
        }
        if (findPluginSetting.versionCode == 0 && findPluginSetting.tempVersionCode > 0) {
            return PluginStatus.UNINSTALLED;
        }
        return PluginStatus.NROMAL;
    }

    public void mc() {
        if (this.Dy) {
            b.lN().clear(this.Du);
        }
    }
}
