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
    private static b Eu;
    private final LinkedHashMap<String, a> Ev = new LinkedHashMap<>(10);

    private b() {
    }

    public static b mt() {
        if (Eu == null) {
            synchronized (b.class) {
                if (Eu == null) {
                    Eu = new b();
                }
            }
        }
        return Eu;
    }

    public void bG(String str) {
        a bI = mt().bI(str);
        if (bI != null) {
            bI.Er = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bI));
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
        a bI = bI(str);
        if (bI == null) {
            bI = new a();
        }
        bI.Er = PluginPackageManager.PluginStatus.ERROR;
        bI.errorMsg = string;
        bI.Es = string2;
        bI.errorCode = i;
        bI.Et = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bI));
    }

    public void bH(String str) {
        a bI = bI(str);
        if (bI == null) {
            bI = new a();
        }
        bI.Er = PluginPackageManager.PluginStatus.ERROR;
        bI.errorCode = 100;
        bI.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bI.Es = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bI));
    }

    public List<a> mu() {
        ArrayList arrayList;
        a value;
        synchronized (this.Ev) {
            arrayList = new ArrayList(this.Ev.size());
            for (Map.Entry<String, a> entry : this.Ev.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Er == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public a bI(String str) {
        a aVar;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Ev) {
            aVar = this.Ev.get(str);
            if (aVar == null) {
                aVar = new a();
                aVar.pkgName = str;
                this.Ev.put(str, aVar);
            }
        }
        return aVar;
    }
}
