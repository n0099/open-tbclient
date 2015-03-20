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
    private static int DE = 2;
    private static volatile PluginPackageManager DF = null;
    private Hashtable<String, r> DG;
    private String DI;
    private boolean DJ;
    private i DN;
    private boolean DH = false;
    private long DK = 0;
    private boolean isInit = false;
    private final String DL = "com.baidu.adp.plugin.currentpath";
    private final String DM = "current_path";
    private BroadcastReceiver DO = new j(this);
    private BroadcastReceiver DP = new k(this);
    private d Dr = new l(this);
    private com.baidu.adp.plugin.install.a Db = new m(this);
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a DQ = new n(this);
    private com.baidu.adp.plugin.packageManager.pluginFileDownload.a DR = new o(this);
    private Context mContext = BdBaseApplication.getInst();

    /* loaded from: classes.dex */
    public enum PluginStatus {
        DISABLE,
        FORBIDDEN,
        UNINSTALLED,
        NROMAL,
        ERROR;

        /* JADX DEBUG: Replace access to removed values field (DX) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginStatus[] valuesCustom() {
            PluginStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginStatus[] pluginStatusArr = new PluginStatus[length];
            System.arraycopy(valuesCustom, 0, pluginStatusArr, 0, length);
            return pluginStatusArr;
        }
    }

    public static PluginPackageManager ls() {
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
        le();
    }

    private void le() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            this.mContext.registerReceiver(this.DO, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void a(String str, com.baidu.adp.plugin.install.b bVar) {
        boolean bh = bh(str);
        boolean bb = com.baidu.adp.plugin.install.c.ld().bb(str);
        if (bh && !bb) {
            bVar.ba(str);
        } else {
            r rVar = new r(this, null);
            rVar.packageName = str;
            rVar.timestamp = System.currentTimeMillis();
            rVar.DW = bVar;
            synchronized (this) {
                if (this.DG.size() < 1000) {
                    this.DG.put(str, rVar);
                } else {
                    BdLog.e("packageaction count is morethan 1000");
                }
            }
        }
        lt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        r remove = this.DG.remove(str);
        if (remove != null && remove.DW != null) {
            if (z) {
                remove.DW.ba(str);
            } else {
                remove.DW.C(remove.packageName, str2);
            }
        }
    }

    private void lt() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, r>> it = this.DG.entrySet().iterator();
            while (it.hasNext()) {
                r value = it.next().getValue();
                if (value != null && currentTimeMillis - value.timestamp >= 600000) {
                    if (value.DW != null) {
                        value.DW.C(value.packageName, "plugin install time out");
                    }
                    it.remove();
                }
            }
        }
    }

    public boolean bh(String str) {
        return bm(str);
    }

    public PluginSetting bi(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str);
    }

    public void K(String str, String str2) {
        File file;
        if (this.DH) {
            long lW = Util.lW();
            if (lW > 0 && lW < 31457280) {
                com.baidu.adp.plugin.b.a.lh().g("plugin_install", "rom too small", str);
            } else if (str != null && (file = new File(str)) != null) {
                if (file.exists()) {
                    com.baidu.adp.plugin.install.c.ld().w(this.mContext, str);
                    return;
                }
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str2);
                if (findPluginSetting != null) {
                    findPluginSetting.tempVersionCode = 0;
                    findPluginSetting.url = "";
                    findPluginSetting.tempMd5 = "";
                    findPluginSetting.install_fail_count = 0;
                    findPluginSetting.installStatus = 0;
                    findPluginSetting.size = 0;
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().a(str2, findPluginSetting);
                }
            }
        }
    }

    public void lu() {
        if (this.DH) {
            long lW = Util.lW();
            if (lW > 0 && lW < 31457280) {
                com.baidu.adp.plugin.b.a.lh().g("plugin_install", "rom too small", "all buildin plugins");
            } else {
                com.baidu.adp.plugin.install.c.ld().a(this.mContext, this.Db);
            }
        }
    }

    private void bj(String str) {
        PluginSetting findPluginSetting;
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str)) != null) {
            ArrayList<c> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(findPluginSetting.getAbandon_apk_path())) {
                for (String str2 : findPluginSetting.getAbandon_apk_path().split(",")) {
                    arrayList.add(new c(str, str2));
                }
            }
            arrayList.add(new c(str, findPluginSetting.apkPath));
            a.lm().a(arrayList, this.Dr);
        }
    }

    public void a(com.baidu.adp.plugin.packageManager.pluginFileDownload.b bVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.b bVar2, String str, boolean z) {
        this.DH = z;
        com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().a(bVar);
        com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().a(bVar2);
        this.DI = str;
        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().a(new q(this, str));
        lv();
    }

    private void lv() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.currentpath");
            if (this.DH) {
                intentFilter.setPriority(1);
            } else {
                intentFilter.setPriority(1000);
            }
            this.mContext.registerReceiver(this.DP, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.DH) {
            for (Map.Entry<String, PluginSetting> entry : com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM().getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && (!TextUtils.isEmpty(value.getAbandon_apk_path()) || value.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ej)) {
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
        if (!TextUtils.isEmpty(str) && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str)) != null) {
            if (findPluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ej && TextUtils.isEmpty(str2)) {
                com.baidu.adp.plugin.b.a.lh().g("plugin_del_unuse", "server forbidden", str);
                bj(str);
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
                com.baidu.adp.plugin.b.a.lh().g("plugin_del_unuse", "scan unuse", str);
                a.lm().a(arrayList, this.Dr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM();
        if (lM != null) {
            System.currentTimeMillis();
            for (Map.Entry<String, PluginSetting> entry : lM.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(value.packageName) && value.enable && value.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.Ej) {
                    PluginCenter.getInstance().launch(value.packageName);
                }
            }
            ls().lA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx() {
        if (this.DH) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().K(false);
        }
    }

    public void ly() {
        if (this.DH) {
            com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().a(com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM(), this.DQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<PluginNetConfigInfos.PluginConfig> list) {
        for (PluginNetConfigInfos.PluginConfig pluginConfig : list) {
            if (pluginConfig != null && !TextUtils.isEmpty(pluginConfig.package_name)) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(pluginConfig.package_name);
                if (findPluginSetting == null) {
                    findPluginSetting = new PluginSetting();
                    findPluginSetting.enable = false;
                    findPluginSetting.packageName = pluginConfig.package_name;
                }
                findPluginSetting.priority = pluginConfig.priority;
                if (pluginConfig.forbidden == 1) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().f(pluginConfig.package_name, false);
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().j(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.Ej);
                } else if (pluginConfig.enable == 1) {
                    if (pluginConfig.newest == null || pluginConfig.newest.version_code <= findPluginSetting.versionCode) {
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().f(pluginConfig.package_name, false);
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().j(pluginConfig.package_name, com.baidu.adp.plugin.packageManager.pluginSettings.c.Ej);
                    } else {
                        findPluginSetting.enable = false;
                        if (pluginConfig.newest.version_code > findPluginSetting.tempVersionCode && pluginConfig.newest.version_code > findPluginSetting.versionCode) {
                            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
                            findPluginSetting.url = pluginConfig.newest.url;
                            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
                            findPluginSetting.install_fail_count = 0;
                            findPluginSetting.installStatus = 0;
                            findPluginSetting.size = pluginConfig.newest.size;
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.Eh) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.Ek;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.El;
                            }
                        }
                        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().a(pluginConfig.package_name, findPluginSetting);
                    }
                } else {
                    if (findPluginSetting.versionCode == 0) {
                        findPluginSetting.enable = false;
                    } else {
                        findPluginSetting.enable = true;
                    }
                    if (pluginConfig.newest != null && pluginConfig.newest.is_force_update == com.baidu.adp.plugin.packageManager.pluginSettings.d.Eh) {
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
                            if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.Eh) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.Ek;
                            } else if (pluginConfig.newest.download_type == com.baidu.adp.plugin.packageManager.pluginSettings.b.WIFI) {
                                findPluginSetting.installStatus = com.baidu.adp.plugin.packageManager.pluginSettings.c.El;
                            }
                        }
                    }
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().a(pluginConfig.package_name, findPluginSetting);
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
    public void lz() {
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM();
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
                com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().f(pluginSetting.packageName, false);
            }
            if (pluginSetting.installStatus != com.baidu.adp.plugin.packageManager.pluginSettings.c.Ej) {
                if (pluginSetting.versionCode < pluginSetting.tempVersionCode) {
                    if (pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ei) {
                        K(Util.f(pluginSetting), pluginSetting.packageName);
                        return;
                    } else if ((pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.El && com.baidu.adp.lib.util.k.iI()) || pluginSetting.installStatus == com.baidu.adp.plugin.packageManager.pluginSettings.c.Ek) {
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
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().a(pluginSetting.packageName, pluginSetting);
                }
                if (pluginSetting.enable && pluginSetting.versionCode > 0) {
                    com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().f(pluginSetting.packageName, true);
                }
            }
        }
    }

    private void a(PluginSetting pluginSetting, com.baidu.adp.plugin.packageManager.pluginFileDownload.a aVar) {
        if (this.DH && pluginSetting != null) {
            BdFileDownloadData bdFileDownloadData = new BdFileDownloadData(pluginSetting.packageName, pluginSetting.url);
            bdFileDownloadData.setName(Util.e(pluginSetting));
            bdFileDownloadData.setPath(Util.f(pluginSetting));
            bdFileDownloadData.setCheck(pluginSetting.tempMd5);
            BdLog.i("pluginFileDownloader startDownload downloadPlugin");
            long lW = Util.lW();
            if (lW > 0 && lW - pluginSetting.size < 31457280) {
                if (aVar != null) {
                    bdFileDownloadData.setStatusMsg(BdBaseApplication.getInst().getString(R.string.rom_too_small));
                    bdFileDownloadData.setStatus(2);
                    bdFileDownloadData.setErrorCode(-1);
                    aVar.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small), "rom is too small");
                }
                com.baidu.adp.plugin.b.a.lh().g("plugin_download", "rom too small", pluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().a(bdFileDownloadData, aVar);
        }
    }

    private void c(PluginSetting pluginSetting) {
        a(pluginSetting, this.DR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PluginSetting pluginSetting) {
        if (this.DH) {
            g.lr().a(pluginSetting);
        }
    }

    public void a(i iVar) {
        this.DN = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Util.N(str2, str) != Util.VersionCompare.EQUAL;
    }

    public void bk(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().bk(str);
    }

    public void bl(String str) {
        com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().bl(str);
    }

    public boolean lA() {
        return this.DH;
    }

    public boolean bm(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str);
        return findPluginSetting != null && findPluginSetting.enable;
    }

    public boolean bn(String str) {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public boolean isFeatureForbidden(String str) {
        if (com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM() == null) {
            return false;
        }
        return com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM().isFeatureForbidden(str);
    }

    public boolean bo(String str) {
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
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str);
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
            PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(pluginConfig.package_name);
            if (findPluginSetting == null) {
                findPluginSetting = new PluginSetting();
                findPluginSetting.packageName = pluginConfig.package_name;
            }
            findPluginSetting.tempMd5 = pluginConfig.newest.md5;
            findPluginSetting.tempVersionCode = pluginConfig.newest.version_code;
            findPluginSetting.url = pluginConfig.newest.url;
            findPluginSetting.size = pluginConfig.newest.size;
            com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().a(findPluginSetting.packageName, findPluginSetting);
            this.DN = iVar;
            a(findPluginSetting, this.DR);
        }
    }

    public boolean lB() {
        return lD() && !this.DJ;
    }

    public void lC() {
        this.DJ = true;
    }

    public boolean lD() {
        PluginSettings lM = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().lM();
        if (lM == null || lM.getPlugins() == null || lM.getPlugins().size() == 0) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : lM.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (value != null && bo(value.packageName)) {
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

    public void bp(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().bt(str);
        }
    }

    public boolean bq(String str) {
        return com.baidu.adp.plugin.packageManager.pluginFileDownload.c.lH().bq(str);
    }

    public PluginStatus br(String str) {
        if (TextUtils.isEmpty(str)) {
            return PluginStatus.ERROR;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.lP().findPluginSetting(str);
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

    public void lE() {
        if (this.isInit) {
            e.lo().clear(this.DH);
        }
    }
}
