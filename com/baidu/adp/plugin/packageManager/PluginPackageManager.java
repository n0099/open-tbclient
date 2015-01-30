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
    private static int sM = 2;
    private static volatile PluginPackageManager sN = null;
    private Hashtable<String, m> sO;
    private String sQ;
    private boolean sR;
    private e sV;
    private boolean sP = false;
    private long sS = 0;
    private final String sT = "com.baidu.adp.plugin.currentpath";
    private final String sU = "current_path";
    private BroadcastReceiver sW = new f(this);
    private BroadcastReceiver sX = new g(this);
    private com.baidu.adp.plugin.install.a sq = new h(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a sY = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a sZ = new j(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (tf) with 'values()' method */
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
        if (sN == null) {
            synchronized (PluginPackageManager.class) {
                if (sN == null) {
                    sN = new PluginPackageManager();
                }
            }
        }
        return sN;
    }

    private PluginPackageManager() {
        this.sO = null;
        this.sO = new Hashtable<>();
        hR();
    }

    private void hR() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            this.mContext.registerReceiver(this.sW, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bc = bc(str);
        boolean aW = com.baidu.adp.plugin.install.c.hQ().aW(str);
        if (bc && !aW) {
            bVar.aV(str);
        } else {
            m mVar = new m(this, null);
            mVar.packageName = str;
            mVar.timestamp = System.currentTimeMillis();
            mVar.te = bVar;
            synchronized (this) {
                if (this.sO.size() < 1000) {
                    this.sO.put(str, mVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        id();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        m remove = this.sO.remove(str);
        if (remove != null && remove.te != null) {
            if (z) {
                remove.te.aV(str);
            } else {
                remove.te.B(remove.packageName, str2);
            }
        }
    }

    private void id() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, m>> it = this.sO.entrySet().iterator();
            while (it.hasNext()) {
                m value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.te != null) {
                        value.te.B(value.packageName, "plugin install time out");
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
        if (this.sP) {
            long iF = Util.iF();
            if (iF > 0 && iF < 31457280) {
                com.baidu.adp.plugin.b.a.hU().g("plugin_install", "rom too small", str);
            } else {
                com.baidu.adp.plugin.install.c.hQ().w(this.mContext, str);
            }
        }
    }

    public void ie() {
        if (this.sP) {
            long iF = Util.iF();
            if (iF > 0 && iF < 31457280) {
                com.baidu.adp.plugin.b.a.hU().g("plugin_install", "rom too small", "all buildin plugins");
            } else {
                com.baidu.adp.plugin.install.c.hQ().a(this.mContext, this.sq);
            }
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
        this.sP = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.iq().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().a(bVar2);
        this.sQ = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(new l(this, str));
        ig();
    }

    private void ig() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.sP) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.sX, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.sP) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.ts)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.ts && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.hU().g("plugin_del_unuse", "server forbidden", str);
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
                com.baidu.adp.plugin.b.a.hU().g("plugin_del_unuse", "scan unuse", str);
                a.hZ().i(arrayList);
                com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().b(str, str4, this.sP);
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
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.ts) {
                    PluginCenter.gW().aP(value.packageName);
                }
            }
            ic().il();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii() {
        if (this.sP) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().K(false);
        }
    }

    public void ij() {
        if (this.sP) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().a(com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().iv(), this.sY);
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().k(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.ts);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().k(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.ts);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.tq) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tt;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tu;
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
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == com.baidu.adp.plugin.packageManager.pluginSettings.d.tq) {
                        if (pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.enable = false;
                        }
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.tq) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tt;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tu;
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
            if (pluginSetting.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.ts) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tr) {
                        be(Util.f(pluginSetting));
                    } else if ((pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tu && com.baidu.adp.lib.util.i.fg()) || pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tt) {
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
        if (this.sP && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            long iF = Util.iF();
            if (iF > 0 && iF - pluginSetting.size < 31457280) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.hU().g("plugin_download", "rom too small", pluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.iq().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.sZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.sP) {
            c.ib().a(pluginSetting);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.K(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bg(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().bg(str);
    }

    public void bh(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().bh(str);
    }

    public boolean il() {
        return this.sP;
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
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().a(findPluginSetting.packageName, findPluginSetting);
            this.sV = eVar;
            a(findPluginSetting, this.sZ);
        }
    }

    public boolean im() {
        return io() && !this.sR;
    }

    public void in() {
        this.sR = true;
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
