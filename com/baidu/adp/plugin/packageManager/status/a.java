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
    private static a Fi;
    private final LinkedHashMap<String, PluginStatus> Fj = new LinkedHashMap<>(10);

    private a() {
    }

    public static a kf() {
        if (Fi == null) {
            synchronized (a.class) {
                if (Fi == null) {
                    Fi = new a();
                }
            }
        }
        return Fi;
    }

    public void by(String str) {
        PluginStatus bz = kf().bz(str);
        if (bz != null) {
            bz.Ff = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bz));
    }

    public void g(String str, String str2, String str3) {
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
        PluginStatus bz = bz(str);
        if (bz == null) {
            bz = new PluginStatus();
        }
        bz.Ff = PluginPackageManager.PluginStatus.ERROR;
        bz.errorMsg = string;
        bz.Fg = string2;
        bz.errorCode = i;
        bz.Fh = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bz));
    }

    public void onLoadFailed(String str) {
        PluginStatus bz = bz(str);
        if (bz == null) {
            bz = new PluginStatus();
        }
        bz.Ff = PluginPackageManager.PluginStatus.ERROR;
        bz.errorCode = 100;
        bz.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bz.Fg = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bz));
    }

    public List<PluginStatus> kg() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Fj) {
            arrayList = new ArrayList(this.Fj.size());
            for (Map.Entry<String, PluginStatus> entry : this.Fj.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Ff == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus bz(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Fj) {
            pluginStatus = this.Fj.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.CC = str;
                this.Fj.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
