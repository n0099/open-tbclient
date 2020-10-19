package com.baidu.adp.plugin.packageManager.status;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.live.adp.framework.MessageConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a UD;
    private final LinkedHashMap<String, PluginStatus> UE = new LinkedHashMap<>(10);

    private a() {
    }

    public static a qB() {
        if (UD == null) {
            synchronized (a.class) {
                if (UD == null) {
                    UD = new a();
                }
            }
        }
        return UD;
    }

    public void cQ(String str) {
        PluginStatus cS = qB().cS(str);
        if (cS != null) {
            cS.Uz = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_SUCCESS, cS));
    }

    public void j(String str, String str2, String str3) {
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
        PluginStatus cS = cS(str);
        if (cS == null) {
            cS = new PluginStatus();
        }
        cS.Uz = PluginPackageManager.PluginStatus.ERROR;
        cS.errorMsg = string;
        cS.UB = string2;
        cS.errorCode = i;
        cS.UC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_FAIL, cS));
    }

    public void cR(String str) {
        PluginStatus cS = cS(str);
        if (cS == null) {
            cS = new PluginStatus();
        }
        cS.Uz = PluginPackageManager.PluginStatus.ERROR;
        cS.errorCode = 100;
        cS.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        cS.UB = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_LOAD_FAIL, cS));
    }

    public List<PluginStatus> qC() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.UE) {
            arrayList = new ArrayList(this.UE.size());
            for (Map.Entry<String, PluginStatus> entry : this.UE.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Uz == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus cS(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.UE) {
            pluginStatus = this.UE.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.pkgName = str;
                this.UE.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
