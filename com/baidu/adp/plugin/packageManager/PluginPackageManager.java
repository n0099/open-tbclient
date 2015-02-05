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
    private static int sJ = 2;
    private static volatile PluginPackageManager sK = null;
    private Hashtable<String, m> sL;
    private String sN;
    private boolean sO;
    private e sS;
    private boolean sM = false;
    private long sP = 0;
    private final String sQ = "com.baidu.adp.plugin.currentpath";
    private final String sR = "current_path";
    private BroadcastReceiver sT = new f(this);
    private BroadcastReceiver sU = new g(this);
    private com.baidu.adp.plugin.install.a sl = new h(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a sV = new i(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a sW = new j(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (tc) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager hV() {
        if (sK == null) {
            synchronized (PluginPackageManager.class) {
                if (sK == null) {
                    sK = new PluginPackageManager();
                }
            }
        }
        return sK;
    }

    private PluginPackageManager() {
        this.sL = null;
        this.sL = new Hashtable<>();
        hK();
    }

    private void hK() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            this.mContext.registerReceiver(this.sT, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean aZ = aZ(str);
        boolean aT = com.baidu.adp.plugin.install.c.hJ().aT(str);
        if (aZ && !aT) {
            bVar.aS(str);
        } else {
            m mVar = new m(this, null);
            mVar.packageName = str;
            mVar.timestamp = System.currentTimeMillis();
            mVar.tb = bVar;
            synchronized (this) {
                if (this.sL.size() < 1000) {
                    this.sL.put(str, mVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        hW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        m remove = this.sL.remove(str);
        if (remove != null && remove.tb != null) {
            if (z) {
                remove.tb.aS(str);
            } else {
                remove.tb.B(remove.packageName, str2);
            }
        }
    }

    private void hW() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, m>> it = this.sL.entrySet().iterator();
            while (it.hasNext()) {
                m value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.tb != null) {
                        value.tb.B(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean aZ(String str) {
        return bf(str);
    }

    public PluginSetting ba(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str);
    }

    public void bb(String str) {
        if (this.sM) {
            long iy = Util.iy();
            if (iy > 0 && iy < 31457280) {
                com.baidu.adp.plugin.b.a.hN().g("plugin_install", "rom too small", str);
            } else {
                com.baidu.adp.plugin.install.c.hJ().w(this.mContext, str);
            }
        }
    }

    public void hX() {
        if (this.sM) {
            long iy = Util.iy();
            if (iy > 0 && iy < 31457280) {
                com.baidu.adp.plugin.b.a.hN().g("plugin_install", "rom too small", "all buildin plugins");
            } else {
                com.baidu.adp.plugin.install.c.hJ().a(this.mContext, this.sl);
            }
        }
    }

    private void bc(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str)) != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(findPluginSetting.apkPath);
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = findPluginSetting.getAbandon_apk_path().split(",");
                for (String str2 : split) {
                    arrayList.add(str2);
                }
            }
            a.hS().i(arrayList);
            com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().bp(str);
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z) {
        this.sM = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ij().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.il().a(bVar2);
        this.sN = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().a(new l(this, str));
        hY();
    }

    private void hY() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.sM) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.sU, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.sM) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tp)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tp && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.hN().g("plugin_del_unuse", "server forbidden", str);
                bc(str);
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
                com.baidu.adp.plugin.b.a.hN().g("plugin_del_unuse", "scan unuse", str);
                a.hS().i(arrayList);
                com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().b(str, str4, this.sM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ() {
        PluginSettings io = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io();
        if (io != null) {
            System.currentTimeMillis();
            for (Map.Entry<String, PluginSetting> entry : io.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.tp) {
                    PluginCenter.getInstance().launch(value.packageName);
                }
            }
            hV().id();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.sM) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().K(false);
        }
    }

    public void ib() {
        if (this.sM) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.il().a(com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io(), this.sV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().k(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.tp);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().k(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.tp);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.tm) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tq;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tr;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == com.baidu.adp.plugin.packageManager.pluginSettings.d.tm) {
                        if (pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.enable = false;
                        }
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.tm) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tq;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.tr;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().a(pluginConfig.package_name, findPluginSetting);
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
    public void ic() {
        PluginSettings io = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io();
        if (io != null) {
            for (Map.Entry<String, PluginSetting> entry : io.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.tp) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tn) {
                        bb(Util.f(pluginSetting));
                    } else if ((pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tr && com.baidu.adp.lib.util.i.fg()) || pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.tq) {
                        c(pluginSetting);
                    }
                } else if (pluginSetting.versionCode == pluginSetting.tempVersionCode && pluginSetting.versionCode > 0 && !pluginSetting.enable) {
                    pluginSetting.enable = true;
                    pluginSetting.tempMd5 = "";
                    pluginSetting.url = "";
                    pluginSetting.tempVersionCode = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().a(pluginSetting.packageName, pluginSetting);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar) {
        if (this.sM && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            long iy = Util.iy();
            if (iy > 0 && iy - pluginSetting.size < 31457280) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.hN().g("plugin_download", "rom too small", pluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ij().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.sW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.sM) {
            c.hU().a(pluginSetting);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.K(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bd(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().bd(str);
    }

    public void be(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().be(str);
    }

    public boolean id() {
        return this.sM;
    }

    public boolean bf(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bg(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io().isFeatureForbidden(str);
    }

    public boolean bh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos im = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.il().im();
        if (im != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = im.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().a(findPluginSetting.packageName, findPluginSetting);
            this.sS = eVar;
            a(findPluginSetting, this.sW);
        }
    }

    public boolean ie() {
        return ih() && !this.sO;
    }

    public void ig() {
        this.sO = true;
    }

    public boolean ih() {
        PluginSettings io = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().io();
        if (io == null || io.getPlugins() == null || io.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : io.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bh(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos im;
        if (TextUtils.isEmpty(str) || (im = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.il().im()) == null) {
            return null;
        }
        return im.getPluginConfig(str);
    }

    public void bi(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ij().bl(str);
        }
    }

    public PluginStatus bj(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting(str);
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
