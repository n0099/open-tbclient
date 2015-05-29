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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginPackageManager {
    private static int Du = 2;
    private static volatile PluginPackageManager Dv = null;
    private i DE;
    private Hashtable<String, r> Dw;
    private String Dy;
    private boolean Dz;
    private boolean Dx = false;
    private long DA = 0;
    private boolean isInit = false;
    private final String DB = "com.baidu.adp.plugin.currentpath";
    private final String DD = "current_path";
    private BroadcastReceiver DF = new j(this);
    private BroadcastReceiver DG = new k(this);
    private d Di = new l(this);
    private com.baidu.adp.plugin.install.a CS = new m(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DH = new n(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DI = new o(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (DN) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager lM() {
        if (Dv == null) {
            synchronized (PluginPackageManager.class) {
                if (Dv == null) {
                    Dv = new PluginPackageManager();
                }
            }
        }
        return Dv;
    }

    private PluginPackageManager() {
        this.Dw = null;
        this.Dw = new Hashtable<>();
        ly();
    }

    private void ly() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            this.mContext.registerReceiver(this.DF, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean br = br(str);
        boolean bl = com.baidu.adp.plugin.install.c.lx().bl(str);
        if (br && !bl) {
            bVar.bk(str);
        } else {
            r rVar = new r(this, null);
            rVar.packageName = str;
            rVar.timestamp = System.currentTimeMillis();
            rVar.DM = bVar;
            synchronized (this) {
                if (this.Dw.size() < 1000) {
                    this.Dw.put(str, rVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        r remove = this.Dw.remove(str);
        if (remove != null && remove.DM != null) {
            if (z) {
                remove.DM.bk(str);
            } else {
                remove.DM.E(remove.packageName, str2);
            }
        }
    }

    private void lN() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, r>> it = this.Dw.entrySet().iterator();
            while (it.hasNext()) {
                r value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.DM != null) {
                        value.DM.E(value.packageName, "plugin install time out");
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
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str);
    }

    public void M(String str, String str2) {
        File file;
        if (this.Dx) {
            long mp = Util.mp();
            if (mp > 0 && mp < 31457280) {
                com.baidu.adp.plugin.b.a.lB().g("plugin_install", "rom too small", str);
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.lx().w(this.mContext, str);
                    return;
                }
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lO() {
        if (this.Dx) {
            long mp = Util.mp();
            if (mp > 0 && mp < 31457280) {
                com.baidu.adp.plugin.b.a.lB().g("plugin_install", "rom too small", "all buildin plugins");
            } else {
                com.baidu.adp.plugin.install.c.lx().a(this.mContext, this.CS);
            }
        }
    }

    private void bt(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str)) != null) {
            ArrayList<c> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new c(str, str2));
                }
            }
            arrayList.add(new c(str, findPluginSetting.apkPath));
            a.lG().a(arrayList, this.Di);
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z) {
        this.Dx = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ma().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().a(bVar2);
        this.Dy = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().a(new q(this, str));
        lP();
    }

    private void lP() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.Dx) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DG, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.Dx) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ea)) {
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
    public void N(String str, String str2) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ea && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lB().g("plugin_del_unuse", "server forbidden", str);
                bt(str);
            } else if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                String[] split = str2.split(",");
                String[] split2 = findPluginSetting.getAbandon_apk_path().split(",");
                HashMap hashMap = new HashMap();
                ArrayList<c> arrayList = new ArrayList<>();
                for (String str3 : split) {
                    hashMap.put(str3, "");
                }
                for (String str4 : split2) {
                    if (hashMap.get(str4) == null) {
                        arrayList.add(new c(str, str4));
                    }
                }
                com.baidu.adp.plugin.b.a.lB().g("plugin_del_unuse", "scan unuse", str);
                a.lG().a(arrayList, this.Di);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ() {
        PluginSettings mf = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf();
        if (mf != null) {
            System.currentTimeMillis();
            for (Map.Entry<String, PluginSetting> entry : mf.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.Ea) {
                    PluginCenter.getInstance().launch(value.packageName);
                }
            }
            lM().iE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR() {
        if (this.Dx) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().M(false);
        }
    }

    public void lS() {
        if (this.Dx) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().a(com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf(), this.DH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                findPluginSetting.priority = pluginConfig.priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().j(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.Ea);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().j(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.Ea);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.install_fail_count = 0;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.DY) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.Eb;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.Ec;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == com.baidu.adp.plugin.packageManager.pluginSettings.d.DY) {
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
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.DY) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.Eb;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.Ec;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().a(pluginConfig.package_name, findPluginSetting);
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
    public void lT() {
        PluginSettings mf = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf();
        if (mf != null) {
            ArrayList<PluginSetting> arrayList = new ArrayList<>();
            for (Map.Entry<String, PluginSetting> entry : mf.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.Ea) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.DZ) {
                        M(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ec && com.baidu.adp.lib.util.k.iY()) || pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Eb) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().f(pluginSetting.packageName, true);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar) {
        if (this.Dx && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            long mp = Util.mp();
            if (mp > 0 && mp - pluginSetting.size < 31457280) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.lB().g("plugin_download", "rom too small", pluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ma().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.Dx) {
            g.lL().a(pluginSetting);
        }
    }

    public void a(i iVar) {
        this.DE = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.R(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bu(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().bu(str);
    }

    public void bv(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().bv(str);
    }

    public boolean iE() {
        return this.Dx;
    }

    public boolean bw(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bx(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf().isFeatureForbidden(str);
    }

    public boolean by(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        PluginNetConfigInfos md = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md();
        if (md != null) {
            PluginNetConfigInfos.PluginConfig pluginConfig = md.getPluginConfig(str);
            if (pluginConfig != null && pluginConfig.enable == 1) {
                return false;
            }
            if (pluginConfig != null && pluginConfig.newest != null) {
                i = pluginConfig.newest.version_code;
            }
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str);
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

    public void a(PluginNetConfigInfos.PluginConfig pluginConfig, i iVar) {
        if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
            if ((pluginConfig.newest == null || pluginConfig.newest.version_code <= 0 || TextUtils.isEmpty(pluginConfig.newest.url)) && iVar != null) {
                iVar.c(new BdFileDownloadData(pluginConfig.package_name));
            }
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().a(findPluginSetting.packageName, findPluginSetting);
            this.DE = iVar;
            a(findPluginSetting, this.DI);
        }
    }

    public boolean lU() {
        return lW() && !this.Dz;
    }

    public void lV() {
        this.Dz = true;
    }

    public boolean lW() {
        PluginSettings mf = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().mf();
        if (mf == null || mf.getPlugins() == null || mf.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mf.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && by(value.packageName)) {
                return true;
            }
        }
        return false;
    }

    public PluginNetConfigInfos.PluginConfig getPluginConfig(String str) {
        PluginNetConfigInfos md;
        if (TextUtils.isEmpty(str) || (md = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md()) == null) {
            return null;
        }
        return md.getPluginConfig(str);
    }

    public void bz(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ma().bD(str);
        }
    }

    public boolean bA(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.ma().bA(str);
    }

    public PluginStatus bB(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting(str);
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

    public void lX() {
        if (this.isInit) {
            e.lI().clear(this.Dx);
        }
    }
}
