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
    private static int DW = 43;
    private static int DX = 2;
    private static volatile PluginPackageManager DY = null;
    private Hashtable<String, a> DZ;
    private String Eb;
    private boolean Ec;
    private e Eh;
    private boolean Ea = false;
    private boolean isThirdProcess = false;
    private long Ed = 0;
    private boolean Ee = false;
    private final String Ef = "com.baidu.adp.plugin.currentpath";
    private final String Eg = "current_path";
    private BroadcastReceiver Ei = new f(this);
    private BroadcastReceiver Ej = new g(this);
    private a.c DG = new h(this);
    private com.baidu.adp.plugin.install.a Dc = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a Ek = new j(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a El = new k(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (Et) with 'values()' method */
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
        return DW;
    }

    public static PluginPackageManager ls() {
        if (DY == null) {
            synchronized (PluginPackageManager.class) {
                if (DY == null) {
                    DY = new PluginPackageManager();
                }
            }
        }
        return DY;
    }

    private PluginPackageManager() {
        this.DZ = null;
        this.DZ = new Hashtable<>();
        kP();
    }

    private void kP() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.setPriority(1000);
            this.mContext.registerReceiver(this.Ei, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean br = br(str);
        boolean bk = com.baidu.adp.plugin.install.d.kO().bk(str);
        if (br && !bk) {
            bVar.bj(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.Es = bVar;
            synchronized (this) {
                if (this.DZ.size() < 1000) {
                    this.DZ.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.DZ.remove(str);
        if (remove != null && remove.Es != null) {
            if (z) {
                remove.Es.bj(str);
            } else {
                remove.Es.C(remove.packageName, str2);
            }
        }
    }

    private void lt() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.DZ.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.Es != null) {
                        value.Es.C(value.packageName, "plugin install time out");
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
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str);
    }

    public void G(String str, String str2) {
        File file;
        if (this.Ea) {
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", str2, null);
            if (!Util.j(new File(str).length())) {
                com.baidu.adp.plugin.install.m.c(str, str2, "rom_size", String.valueOf(Util.lZ()));
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.kO().x(this.mContext, str);
                    return;
                }
                com.baidu.adp.plugin.b.a.lf().d("plugin_install", "plugin_install_filenotexist", str2, null);
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lu() {
        if (this.Ea) {
            com.baidu.adp.plugin.install.d.kO().a(this.mContext, this.Dc);
        }
    }

    private void bt(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.ll().a(arrayList, this.DG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b Es;
        String packageName;
        long timestamp;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(PluginPackageManager pluginPackageManager, a aVar) {
            this();
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z, boolean z2, boolean z3) {
        if (this.Ee) {
            com.baidu.adp.plugin.b.a.lf().bo("plugin_pkgmanager_recreate");
        }
        this.Ea = z;
        this.isThirdProcess = z2;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().a(bVar2);
        this.Eb = str;
        try {
            BdBaseApplication inst = BdBaseApplication.getInst();
            DW = com.baidu.adp.lib.h.b.g(String.valueOf(inst.getPackageManager().getApplicationInfo(inst.getPackageName(), 128).metaData.get("PLUGIN_MIN_VERSIONCODE")), DW);
        } catch (Throwable th) {
        }
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().a(new m(this, str, z3));
        lw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv() {
        lx();
        if (Build.VERSION.SDK_INT > 10) {
            J(false);
        }
    }

    private void lw() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Ea) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.Ej, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Ea) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.EF)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.EF && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lf().h("plugin_del_unuse", "server forbidden", str);
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
                com.baidu.adp.plugin.packageManager.a.ll().a(arrayList, this.DG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM();
        if (lM != null) {
            StringBuilder sb = new StringBuilder();
            List<PluginSetting> pluginSettingsSortLoadPriorty = lM.getPluginSettingsSortLoadPriorty();
            if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty()) {
                int i = 0;
                for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                    if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName) && pluginSetting.enable && pluginSetting.installStatus != a.b.EF) {
                        a.b launch = PluginCenter.getInstance().launch(pluginSetting.packageName);
                        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName);
                        if (!launch.Cv && plugin2 != null && !plugin2.isLoaded()) {
                            i++;
                            if (ls().hs()) {
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
                                sb.append(launch.Cw);
                            }
                        }
                    }
                }
                if (ls().hs()) {
                    if (i > 0) {
                        com.baidu.adp.plugin.b.a.lf().d("plugin_load", "load_allplugin", null, sb.toString());
                    }
                    PluginCenter.getInstance().logPluginLoadStat();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly() {
        if (this.Ea) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().K(false);
        }
    }

    public void J(boolean z) {
        if (this.Ea) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM(), z, this.Ek);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, List<PluginNetConfigInfos.PluginConfig> list) {
        PluginSetting pluginSetting;
        String str;
        List<BasicNameValuePair> lI;
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    PluginSetting pluginSetting2 = new PluginSetting();
                    pluginSetting2.enable = false;
                    pluginSetting2.packageName = pluginConfig.package_name;
                    pluginSetting = pluginSetting2;
                } else {
                    pluginSetting = findPluginSetting;
                }
                if (pluginSetting.installStatus == a.b.EE) {
                    String f = Util.f(pluginSetting);
                    if (!new File(f).exists() && this.Ea) {
                        com.baidu.adp.plugin.b.a.lf().d("plugin_install", "download_suc_file_not_exist", pluginConfig.package_name, f);
                    }
                }
                pluginSetting.priority = pluginConfig.priority;
                pluginSetting.load_priority = pluginConfig.load_priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.b.a.lf().d("plugin_setting", "server_forbidden_plugin", pluginConfig.package_name, null);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().g(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().l(pluginConfig.package_name, a.b.EF);
                } else {
                    if (pluginConfig.newest != null && pluginConfig.newest.version_code < DW && this.Ea) {
                        com.baidu.adp.plugin.b.a.lf().d("plugin_install", "server_config_versionlower", pluginConfig.package_name, String.valueOf(DW) + "_" + pluginSetting.versionCode + "_" + pluginConfig.newest.version_code);
                    }
                    if (pluginConfig.enable == 1) {
                        if (pluginConfig.newest == null || pluginConfig.newest.version_code <= pluginSetting.versionCode) {
                            if (cVar != null && (lI = cVar.lI()) != null) {
                                for (BasicNameValuePair basicNameValuePair : new ArrayList(lI)) {
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
                                com.baidu.adp.plugin.b.a.lf().d("plugin_setting", "server_disable_plugin_nonewest", pluginConfig.package_name, "up-" + str + "-set-" + pluginSetting.versionCode + "-" + pluginSetting.apkPath);
                            } else {
                                com.baidu.adp.plugin.b.a.lf().d("plugin_setting", "server_disable_plugin_newestversionlow", pluginConfig.package_name, "up-" + str + "-config-" + pluginConfig.newest.version_code + "-set-" + pluginSetting.versionCode);
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().g(pluginConfig.package_name, false);
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().l(pluginConfig.package_name, a.b.EF);
                        } else {
                            pluginSetting.enable = false;
                            if (pluginConfig.newest.version_code > pluginSetting.tempVersionCode && pluginConfig.newest.version_code > pluginSetting.versionCode) {
                                pluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                                pluginSetting.url = pluginConfig.newest.url;
                                pluginSetting.tempMd5 = pluginConfig.newest.md5;
                                pluginSetting.install_fail_count = 0;
                                pluginSetting.installStatus = 0;
                                pluginSetting.size = pluginConfig.newest.size;
                                if (pluginConfig.newest.download_type == a.C0012a.ED) {
                                    pluginSetting.installStatus = a.b.EG;
                                } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                                    pluginSetting.installStatus = a.b.EH;
                                }
                            }
                            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().a(pluginConfig.package_name, pluginSetting);
                        }
                    } else {
                        if (pluginSetting.versionCode == 0) {
                            pluginSetting.enable = false;
                        } else {
                            pluginSetting.enable = true;
                        }
                        if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.ED) {
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
                                if (pluginConfig.newest.download_type == a.C0012a.ED) {
                                    pluginSetting.installStatus = a.b.EG;
                                } else if (pluginConfig.newest.download_type == a.C0012a.WIFI) {
                                    pluginSetting.installStatus = a.b.EH;
                                }
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().a(pluginConfig.package_name, pluginSetting);
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
    public void lz() {
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM();
        if (lM != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : lM.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().g(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.EF) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.EE) {
                        G(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.EH && com.baidu.adp.lib.util.i.iR()) || pluginSetting.installStatus == a.b.EG) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().bI(pluginSetting.packageName);
                    if (pluginSetting.versionCode < DW) {
                        com.baidu.adp.plugin.b.a.lf().E("plugin_launch_lowversion", pluginSetting.packageName);
                        com.baidu.adp.plugin.b.a.lf().d("plugin_load", "load_lowversion", pluginSetting.packageName, "set_by_config-" + pluginSetting.apkPath + "-" + pluginSetting.versionCode + "-" + pluginSetting.forbidden + "-" + pluginSetting.tempVersionCode + "-" + pluginSetting.installStatus);
                    }
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar, boolean z) {
        if (this.Ea && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.lf().h("plugin_download", "rom too small", pluginSetting.packageName);
            } else if (z) {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().b(bdFileDownloadData, aVar);
            } else {
                com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().a(bdFileDownloadData, aVar);
            }
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.El, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Ea) {
            d.lq().a(pluginSetting);
        }
    }

    public void a(e eVar) {
        this.Eh = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.L(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bu(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().bu(str);
    }

    public void bv(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().bv(str);
    }

    public boolean hs() {
        return this.Ea;
    }

    public boolean lA() {
        return this.isThirdProcess;
    }

    public boolean bw(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bx(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM().isFeatureForbidden(str);
    }

    public boolean by(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos lK = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK();
        if (lK != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = lK.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().a(findPluginSetting.packageName, findPluginSetting);
            this.Eh = eVar;
            a(findPluginSetting, this.El, true);
        }
    }

    public boolean lB() {
        return lD() && !this.Ec;
    }

    public void lC() {
        this.Ec = true;
    }

    public boolean lD() {
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM();
        if (lM == null || lM.getPlugins() == null || lM.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : lM.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && by(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos lK;
        if (TextUtils.isEmpty(str) || (lK = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK()) == null) {
            return null;
        }
        return lK.getPluginConfig(str);
    }

    public void bz(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().bD(str);
        }
    }

    public boolean bA(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().bA(str);
    }

    public PluginStatus bB(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str);
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

    public void lE() {
        if (this.Ee) {
            b.ln().clear(this.Ea);
        }
    }
}
