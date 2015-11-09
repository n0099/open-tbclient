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
    private static b Ev;
    private final LinkedHashMap<String, a> Ew = new LinkedHashMap<>(10);

    private b() {
    }

    public static b mu() {
        if (Ev == null) {
            synchronized (b.class) {
                if (Ev == null) {
                    Ev = new b();
                }
            }
        }
        return Ev;
    }

    public void bE(String str) {
        a bG = mu().bG(str);
        if (bG != null) {
            bG.Es = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bG));
    }

    public void h(String str, String str2, String str3) {
        String string;
        String string2;
        int i = 2;
        if ("rom_size".equals(str2)) {
            string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
            string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
        } else if (!"plugin_install_retry_timeout".equals(str2) && !"plugin_install_timeout".equals(str2)) {
            if (str3 != null) {
                if (str3.toLowerCase(Locale.getDefault()).contains("no_space_left_on_device")) {
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
                } else if (str3.toLowerCase(Locale.getDefault()).contains("read-only_file_system")) {
                    i = 3;
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_need_restart);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_need_restart);
                } else if (str3.toLowerCase(Locale.getDefault()).contains("permission_denied")) {
                    i = 4;
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_need_restart);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_need_restart);
                } else if (str3.toLowerCase(Locale.getDefault()).contains("fsync_failed")) {
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
        a bG = bG(str);
        if (bG == null) {
            bG = new a();
        }
        bG.Es = PluginPackageManager.PluginStatus.ERROR;
        bG.errorMsg = string;
        bG.Et = string2;
        bG.errorCode = i;
        bG.Eu = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bG));
    }

    public void bF(String str) {
        a bG = bG(str);
        if (bG == null) {
            bG = new a();
        }
        bG.Es = PluginPackageManager.PluginStatus.ERROR;
        bG.errorCode = 100;
        bG.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bG.Et = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bG));
    }

    public List<a> mv() {
        ArrayList arrayList;
        a value;
        synchronized (this.Ew) {
            arrayList = new ArrayList(this.Ew.size());
            for (Map.Entry<String, a> entry : this.Ew.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Es == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public a bG(String str) {
        a aVar;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Ew) {
            aVar = this.Ew.get(str);
            if (aVar == null) {
                aVar = new a();
                aVar.pkgName = str;
                this.Ew.put(str, aVar);
            }
        }
        return aVar;
    }
}
