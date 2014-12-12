package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginPackageManager {
    private static int sD = 2;
    private static volatile PluginPackageManager sE = null;
    private Hashtable<String, n> sF;
    private String sH;
    private boolean sI;
    private boolean sG = false;
    private long sJ = 0;
    private final String sK = "com.baidu.adp.plugin.currentpath";
    private final String sL = "current_path";
    private BroadcastReceiver sM = new f(this);
    private BroadcastReceiver sN = new g(this);
    private com.baidu.adp.plugin.install.a si = new h(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a sO = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a sP = new j(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (sV) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager ic() {
        if (sE == null) {
            synchronized (PluginPackageManager.class) {
                if (sE == null) {
                    sE = new PluginPackageManager();
                }
            }
        }
        return sE;
    }

    private PluginPackageManager() {
        this.sF = null;
        this.sF = new Hashtable<>();
        hT();
    }

    private void hT() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.adp.plugin.installed");
        intentFilter.addAction("com.baidu.adp.plugin.installfail");
        this.mContext.registerReceiver(this.sM, intentFilter);
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bc = bc(str);
        boolean aW = com.baidu.adp.plugin.install.c.hS().aW(str);
        if (bc && !aW) {
            bVar.aV(str);
        } else {
            n nVar = new n(this, null);
            nVar.packageName = str;
            nVar.timestamp = System.currentTimeMillis();
            nVar.sU = bVar;
            synchronized (this) {
                if (this.sF.size() < 1000) {
                    this.sF.put(str, nVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        id();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        n remove = this.sF.remove(str);
        if (remove != null && remove.sU != null) {
            if (z) {
                remove.sU.aV(str);
            } else {
                remove.sU.C(remove.packageName, str2);
            }
        }
    }

    private void id() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, n>> it = this.sF.entrySet().iterator();
            while (it.hasNext()) {
                n value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.sU != null) {
                        value.sU.C(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bc(String str) {
        return bi(str);
    }

    public PluginSetting bd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str);
    }

    public void be(String str) {
        if (this.sG) {
            com.baidu.adp.plugin.install.c.hS().w(this.mContext, str);
        }
    }

    public void ie() {
        if (this.sG) {
            com.baidu.adp.plugin.install.c.hS().a(this.mContext, this.si);
        }
    }

    private void bf(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str)) != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(findPluginSetting.apkPath);
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = findPluginSetting.getAbandon_apk_path().split(",");
                for (String str2 : split) {
                    arrayList.add(str2);
                }
            }
            a.hZ().i(arrayList);
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().bs(str);
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z) {
        this.sG = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.iq().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().a(bVar2);
        this.sH = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(new k(this, str));
        ig();
    }

    private void ig() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.sG) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.sN, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.sG) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.ti)) {
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
        if (!TextUtils.isEmpty(str)) {
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str);
            if (findPluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.ti && TextUtils.isEmpty(str2)) {
                bf(str);
            } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = str2.split(",");
                String[] split2 = findPluginSetting.getAbandon_apk_path().split(",");
                HashMap hashMap = new HashMap();
                ArrayList<String> arrayList = new ArrayList<>();
                for (String str3 : split) {
                    hashMap.put(str3, "");
                }
                String str4 = "";
                for (String str5 : split2) {
                    if (hashMap.get(str5) == null) {
                        arrayList.add(str5);
                    } else {
                        str4 = TextUtils.isEmpty(str4) ? str5 : String.valueOf(str4) + "," + str5;
                    }
                }
                a.hZ().i(arrayList);
                com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().b(str, str4, this.sG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih() {
        PluginSettings iv = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv();
        if (iv != null) {
            System.currentTimeMillis();
            for (Map.Entry<String, PluginSetting> entry : iv.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.ti) {
                    PluginCenter.gX().aP(value.packageName);
                }
            }
            ic().il();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii() {
        if (this.sG) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().K(false);
        }
    }

    public void ij() {
        if (this.sG) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().a(com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv(), this.sO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().k(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.ti);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().k(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.ti);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            d(findPluginSetting);
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.installStatus = 0;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.tg) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tj;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tk;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == com.baidu.adp.plugin.packageManager.pluginSettings.d.tg) {
                        if (pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.enable = false;
                        }
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            d(findPluginSetting);
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.installStatus = 0;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.tg) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tj;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tk;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(pluginConfig.package_name, findPluginSetting);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(List<PluginNetConfigInfos.PluginConfig> list) {
        String str = "";
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig == null || !TextUtils.isEmpty(pluginConfig.package_name)) {
                String str2 = pluginConfig.forbidden_features;
                if (!TextUtils.isEmpty(str2)) {
                    str = TextUtils.isEmpty(str) ? str2 : String.valueOf(str) + "," + str2;
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik() {
        PluginSettings iv = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv();
        if (iv != null) {
            for (Map.Entry<String, PluginSetting> entry : iv.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null) {
                    b(value);
                }
            }
        }
    }

    private void b(PluginSetting pluginSetting) {
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            if (pluginSetting.versionCode <= 0) {
                pluginSetting.enable = false;
                com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.ti) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.th) {
                        be(Util.f(pluginSetting));
                    } else if ((pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tk && com.baidu.adp.lib.util.i.fh()) || pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tj) {
                        c(pluginSetting);
                    }
                } else if (pluginSetting.versionCode == pluginSetting.tempVersionCode && pluginSetting.versionCode > 0 && !pluginSetting.enable) {
                    pluginSetting.enable = true;
                    pluginSetting.tempMd5 = "";
                    pluginSetting.url = "";
                    pluginSetting.tempVersionCode = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(pluginSetting.packageName, pluginSetting);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar) {
        if (this.sG && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.iq().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.sP);
    }

    public void d(PluginSetting pluginSetting) {
        if (this.sG) {
            c.ib().a(pluginSetting);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.G(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bg(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().bg(str);
    }

    public void bh(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().bh(str);
    }

    public boolean il() {
        return this.sG;
    }

    public boolean bi(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bj(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv().isFeatureForbidden(str);
    }

    public boolean bk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos it = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it();
        if (it != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = it.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(findPluginSetting.packageName, findPluginSetting);
            a(findPluginSetting, new l(this, eVar));
        }
    }

    public boolean im() {
        return io() && !this.sI;
    }

    public void in() {
        this.sI = true;
    }

    public boolean io() {
        PluginSettings iv = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv();
        if (iv == null || iv.getPlugins() == null || iv.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : iv.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bk(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos it;
        if (TextUtils.isEmpty(str) || (it = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it()) == null) {
            return null;
        }
        return it.getPluginConfig(str);
    }

    public void bl(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.iq().bo(str);
        }
    }

    public PluginStatus bm(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str);
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
}
