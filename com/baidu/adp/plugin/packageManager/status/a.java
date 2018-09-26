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
    private static a Lv;
    private final LinkedHashMap<String, PluginStatus> Lw = new LinkedHashMap<>(10);

    private a() {
    }

    public static a nC() {
        if (Lv == null) {
            synchronized (a.class) {
                if (Lv == null) {
                    Lv = new a();
                }
            }
        }
        return Lv;
    }

    public void co(String str) {
        PluginStatus cp = nC().cp(str);
        if (cp != null) {
            cp.Ls = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, cp));
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
        PluginStatus cp = cp(str);
        if (cp == null) {
            cp = new PluginStatus();
        }
        cp.Ls = PluginPackageManager.PluginStatus.ERROR;
        cp.errorMsg = string;
        cp.Lt = string2;
        cp.errorCode = i;
        cp.Lu = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, cp));
    }

    public void onLoadFailed(String str) {
        PluginStatus cp = cp(str);
        if (cp == null) {
            cp = new PluginStatus();
        }
        cp.Ls = PluginPackageManager.PluginStatus.ERROR;
        cp.errorCode = 100;
        cp.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        cp.Lt = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, cp));
    }

    public List<PluginStatus> nD() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Lw) {
            arrayList = new ArrayList(this.Lw.size());
            for (Map.Entry<String, PluginStatus> entry : this.Lw.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Ls == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus cp(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Lw) {
            pluginStatus = this.Lw.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.IO = str;
                this.Lw.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
