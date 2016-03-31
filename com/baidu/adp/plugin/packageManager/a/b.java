package com.baidu.adp.plugin.packageManager.a;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private static b Fs;
    private final LinkedHashMap<String, a> Ft = new LinkedHashMap<>(10);

    private b() {
    }

    public static b ma() {
        if (Fs == null) {
            synchronized (b.class) {
                if (Fs == null) {
                    Fs = new b();
                }
            }
        }
        return Fs;
    }

    public void bK(String str) {
        a bM = ma().bM(str);
        if (bM != null) {
            bM.Fp = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bM));
    }

    public void j(String str, String str2, String str3) {
        String string;
        String string2;
        int i = 2;
        if ("rom_size".equals(str2)) {
            string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
            string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
        } else if (!"plugin_install_retry_timeout".equals(str2) && !"plugin_install_timeout".equals(str2)) {
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(Locale.getDefault());
                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
                } else if (lowerCase.contains("read-only_file_system") || lowerCase.contains("read-only file system")) {
                    i = 3;
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_need_restart);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_need_restart);
                } else if (lowerCase.contains("permission_denied") || lowerCase.contains("permission denied")) {
                    i = 4;
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_need_restart);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_need_restart);
                } else if (lowerCase.contains("fsync_failed") || lowerCase.contains("fsync failed")) {
                    i = 5;
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
                } else {
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
                    i = 1;
                }
            } else {
                string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
                i = 1;
            }
        } else {
            return;
        }
        a bM = bM(str);
        if (bM == null) {
            bM = new a();
        }
        bM.Fp = PluginPackageManager.PluginStatus.ERROR;
        bM.errorMsg = string;
        bM.Fq = string2;
        bM.errorCode = i;
        bM.Fr = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bM));
    }

    public void bL(String str) {
        a bM = bM(str);
        if (bM == null) {
            bM = new a();
        }
        bM.Fp = PluginPackageManager.PluginStatus.ERROR;
        bM.errorCode = 100;
        bM.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bM.Fq = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bM));
    }

    public List<a> mb() {
        ArrayList arrayList;
        a value;
        synchronized (this.Ft) {
            arrayList = new ArrayList(this.Ft.size());
            for (Map.Entry<String, a> entry : this.Ft.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Fp == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public a bM(String str) {
        a aVar;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Ft) {
            aVar = this.Ft.get(str);
            if (aVar == null) {
                aVar = new a();
                aVar.pkgName = str;
                this.Ft.put(str, aVar);
            }
        }
        return aVar;
    }
}
