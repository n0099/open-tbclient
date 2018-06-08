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
    private static a Jd;
    private final LinkedHashMap<String, PluginStatus> Je = new LinkedHashMap<>(10);

    private a() {
    }

    public static a mu() {
        if (Jd == null) {
            synchronized (a.class) {
                if (Jd == null) {
                    Jd = new a();
                }
            }
        }
        return Jd;
    }

    public void bU(String str) {
        PluginStatus bV = mu().bV(str);
        if (bV != null) {
            bV.Ja = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bV));
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
        PluginStatus bV = bV(str);
        if (bV == null) {
            bV = new PluginStatus();
        }
        bV.Ja = PluginPackageManager.PluginStatus.ERROR;
        bV.errorMsg = string;
        bV.Jb = string2;
        bV.errorCode = i;
        bV.Jc = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bV));
    }

    public void onLoadFailed(String str) {
        PluginStatus bV = bV(str);
        if (bV == null) {
            bV = new PluginStatus();
        }
        bV.Ja = PluginPackageManager.PluginStatus.ERROR;
        bV.errorCode = 100;
        bV.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bV.Jb = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bV));
    }

    public List<PluginStatus> mv() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Je) {
            arrayList = new ArrayList(this.Je.size());
            for (Map.Entry<String, PluginStatus> entry : this.Je.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Ja == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus bV(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Je) {
            pluginStatus = this.Je.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.Gq = str;
                this.Je.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
