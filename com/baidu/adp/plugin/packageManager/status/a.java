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
    private static a Ff;
    private final LinkedHashMap<String, PluginStatus> Fg = new LinkedHashMap<>(10);

    private a() {
    }

    public static a kh() {
        if (Ff == null) {
            synchronized (a.class) {
                if (Ff == null) {
                    Ff = new a();
                }
            }
        }
        return Ff;
    }

    public void bt(String str) {
        PluginStatus bu = kh().bu(str);
        if (bu != null) {
            bu.Fc = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bu));
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
        PluginStatus bu = bu(str);
        if (bu == null) {
            bu = new PluginStatus();
        }
        bu.Fc = PluginPackageManager.PluginStatus.ERROR;
        bu.errorMsg = string;
        bu.Fd = string2;
        bu.errorCode = i;
        bu.Fe = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bu));
    }

    public void onLoadFailed(String str) {
        PluginStatus bu = bu(str);
        if (bu == null) {
            bu = new PluginStatus();
        }
        bu.Fc = PluginPackageManager.PluginStatus.ERROR;
        bu.errorCode = 100;
        bu.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bu.Fd = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bu));
    }

    public List<PluginStatus> ki() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Fg) {
            arrayList = new ArrayList(this.Fg.size());
            for (Map.Entry<String, PluginStatus> entry : this.Fg.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Fc == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus bu(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Fg) {
            pluginStatus = this.Fg.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.Cz = str;
                this.Fg.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
