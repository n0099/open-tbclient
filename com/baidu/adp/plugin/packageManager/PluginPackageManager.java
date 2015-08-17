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
    private static int Dq = 2;
    private static volatile PluginPackageManager Dr = null;
    private d DA;
    private Hashtable<String, a> Ds;
    private String Du;
    private boolean Dv;
    private boolean Dt = false;
    private long Dw = 0;
    private boolean Dx = false;
    private final String Dy = "com.baidu.adp.plugin.currentpath";
    private final String Dz = "current_path";
    private BroadcastReceiver DB = new e(this);
    private BroadcastReceiver DC = new f(this);
    private a.c De = new g(this);
    private com.baidu.adp.plugin.install.a CB = new h(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DD = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DE = new j(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (DJ) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager lT() {
        if (Dr == null) {
            synchronized (PluginPackageManager.class) {
                if (Dr == null) {
                    Dr = new PluginPackageManager();
                }
            }
        }
        return Dr;
    }

    private PluginPackageManager() {
        this.Ds = null;
        this.Ds = new Hashtable<>();
        ls();
    }

    private void ls() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            this.mContext.registerReceiver(this.DB, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bl = bl(str);
        boolean be = com.baidu.adp.plugin.install.d.lr().be(str);
        if (bl && !be) {
            bVar.bd(str);
        } else {
            a aVar = new a(this, null);
            aVar.packageName = str;
            aVar.timestamp = System.currentTimeMillis();
            aVar.DI = bVar;
            synchronized (this) {
                if (this.Ds.size() < 1000) {
                    this.Ds.put(str, aVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        a remove = this.Ds.remove(str);
        if (remove != null && remove.DI != null) {
            if (z) {
                remove.DI.bd(str);
            } else {
                remove.DI.C(remove.packageName, str2);
            }
        }
    }

    private void lU() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, a>> it = this.Ds.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.DI != null) {
                        value.DI.C(value.packageName, "plugin install time out");
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
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str);
    }

    public void K(String str, String str2) {
        File file;
        if (this.Dt) {
            com.baidu.adp.plugin.b.a.lH().a("plugin_install", str2, (PluginSetting) null);
            if (!Util.j(new File(str).length())) {
                m.c(str, str2, "rom_size", String.valueOf(Util.mz()));
                com.baidu.adp.plugin.b.a.lH().g("plugin_install", "rom too small", str);
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.d.lr().x(this.mContext, str);
                    return;
                }
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lV() {
        if (this.Dt) {
            com.baidu.adp.plugin.install.d.lr().a(this.mContext, this.CB);
        }
    }

    private void bn(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str)) != null) {
            ArrayList<a.b> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new a.b(str, str2));
                }
            }
            arrayList.add(new a.b(str, findPluginSetting.apkPath));
            com.baidu.adp.plugin.packageManager.a.lN().a(arrayList, this.De);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.adp.plugin.install.b DI;
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
        this.Dt = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mh().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().a(bVar2);
        this.Du = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().a(new l(this, str));
        lW();
    }

    private void lW() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Dt) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DC, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Dt) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == a.b.DW)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == a.b.DW && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lH().g("plugin_del_unuse", "server forbidden", str);
                bn(str);
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
                com.baidu.adp.plugin.b.a.lH().g("plugin_del_unuse", "scan unuse", str);
                com.baidu.adp.plugin.packageManager.a.lN().a(arrayList, this.De);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX() {
        PluginSettings mm = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm();
        if (mm != null) {
            for (Map.Entry<String, PluginSetting> entry : mm.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != a.b.DW) {
                    PluginCenter.getInstance().launch(value.packageName);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY() {
        if (this.Dt) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().N(false);
        }
    }

    public void lZ() {
        if (this.Dt) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().a(com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm(), this.DD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                findPluginSetting.priority = pluginConfig.priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().l(pluginConfig.package_name, a.b.DW);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().l(pluginConfig.package_name, a.b.DW);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.install_fail_count = 0;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == a.C0011a.DU) {
                                findPluginSetting.installStatus = a.b.DX;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                findPluginSetting.installStatus = a.b.DY;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == a.c.DU) {
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
                            if (pluginConfig.newest.download_type == a.C0011a.DU) {
                                findPluginSetting.installStatus = a.b.DX;
                            } else if (pluginConfig.newest.download_type == a.C0011a.WIFI) {
                                findPluginSetting.installStatus = a.b.DY;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().a(pluginConfig.package_name, findPluginSetting);
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
    public void ma() {
        PluginSettings mm = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm();
        if (mm != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : mm.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != a.b.DW) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == a.b.DV) {
                        K(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == a.b.DY && com.baidu.adp.lib.util.i.iP()) || pluginSetting.installStatus == a.b.DX) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().f(pluginSetting.packageName, true);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar) {
        if (this.Dt && pluginSetting != null) {
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
                com.baidu.adp.plugin.b.a.lH().g("plugin_download", "rom too small", pluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mh().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Dt) {
            c.lS().a(pluginSetting);
        }
    }

    public void a(d dVar) {
        this.DA = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.P(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bo(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().bo(str);
    }

    public void bp(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().bp(str);
    }

    public boolean hr() {
        return this.Dt;
    }

    public boolean bq(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean br(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm().isFeatureForbidden(str);
    }

    public boolean bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos mk = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk();
        if (mk != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = mk.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().a(findPluginSetting.packageName, findPluginSetting);
            this.DA = dVar;
            a(findPluginSetting, this.DE);
        }
    }

    public boolean mb() {
        return md() && !this.Dv;
    }

    public void mc() {
        this.Dv = true;
    }

    public boolean md() {
        PluginSettings mm = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm();
        if (mm == null || mm.getPlugins() == null || mm.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mm.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bs(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos mk;
        if (TextUtils.isEmpty(str) || (mk = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk()) == null) {
            return null;
        }
        return mk.getPluginConfig(str);
    }

    public void bt(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mh().bx(str);
        }
    }

    public boolean bu(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.mh().bu(str);
    }

    public PluginStatus bv(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str);
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

    public void me() {
        if (this.Dx) {
            b.lP().clear(this.Dt);
        }
    }
}
