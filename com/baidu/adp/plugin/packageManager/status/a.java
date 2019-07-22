package com.baidu.adp.plugin.packageManager.status;

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
public class a {
    private static a Km;
    private final LinkedHashMap<String, PluginStatus> Kn = new LinkedHashMap<>(10);

    private a() {
    }

    public static a nd() {
        if (Km == null) {
            synchronized (a.class) {
                if (Km == null) {
                    Km = new a();
                }
            }
        }
        return Km;
    }

    public void bZ(String str) {
        PluginStatus ca = nd().ca(str);
        if (ca != null) {
            ca.Kj = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, ca));
    }

    public void h(String str, String str2, String str3) {
        String string;
        String string2;
        int i = 1;
        if ("rom_size".equals(str2)) {
            string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
            string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
            i = 2;
        } else if (!"plugin_install_retry_timeout".equals(str2) && !"plugin_install_timeout".equals(str2)) {
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(Locale.getDefault());
                if (lowerCase.contains("no_space_left_on_device") || lowerCase.contains("no space left on device")) {
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
                    i = 2;
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
                }
            } else {
                string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
            }
        } else {
            return;
        }
        PluginStatus ca = ca(str);
        if (ca == null) {
            ca = new PluginStatus();
        }
        ca.Kj = PluginPackageManager.PluginStatus.ERROR;
        ca.errorMsg = string;
        ca.Kk = string2;
        ca.errorCode = i;
        ca.Kl = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, ca));
    }

    public void onLoadFailed(String str) {
        PluginStatus ca = ca(str);
        if (ca == null) {
            ca = new PluginStatus();
        }
        ca.Kj = PluginPackageManager.PluginStatus.ERROR;
        ca.errorCode = 100;
        ca.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        ca.Kk = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, ca));
    }

    public List<PluginStatus> ne() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Kn) {
            arrayList = new ArrayList(this.Kn.size());
            for (Map.Entry<String, PluginStatus> entry : this.Kn.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Kj == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus ca(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Kn) {
            pluginStatus = this.Kn.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.Ht = str;
                this.Kn.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
