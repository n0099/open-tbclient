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
    private static a Tq;
    private final LinkedHashMap<String, PluginStatus> Tr = new LinkedHashMap<>(10);

    private a() {
    }

    public static a oX() {
        if (Tq == null) {
            synchronized (a.class) {
                if (Tq == null) {
                    Tq = new a();
                }
            }
        }
        return Tq;
    }

    public void cI(String str) {
        PluginStatus cK = oX().cK(str);
        if (cK != null) {
            cK.Tn = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_SUCCESS, cK));
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
        PluginStatus cK = cK(str);
        if (cK == null) {
            cK = new PluginStatus();
        }
        cK.Tn = PluginPackageManager.PluginStatus.ERROR;
        cK.errorMsg = string;
        cK.To = string2;
        cK.errorCode = i;
        cK.Tp = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_FAIL, cK));
    }

    public void cJ(String str) {
        PluginStatus cK = cK(str);
        if (cK == null) {
            cK = new PluginStatus();
        }
        cK.Tn = PluginPackageManager.PluginStatus.ERROR;
        cK.errorCode = 100;
        cK.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        cK.To = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_LOAD_FAIL, cK));
    }

    public List<PluginStatus> oY() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Tr) {
            arrayList = new ArrayList(this.Tr.size());
            for (Map.Entry<String, PluginStatus> entry : this.Tr.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Tn == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus cK(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Tr) {
            pluginStatus = this.Tr.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.pkgName = str;
                this.Tr.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
