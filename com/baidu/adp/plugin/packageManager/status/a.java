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
    private static a Jf;
    private final LinkedHashMap<String, PluginStatus> Jg = new LinkedHashMap<>(10);

    private a() {
    }

    public static a mu() {
        if (Jf == null) {
            synchronized (a.class) {
                if (Jf == null) {
                    Jf = new a();
                }
            }
        }
        return Jf;
    }

    public void bW(String str) {
        PluginStatus bX = mu().bX(str);
        if (bX != null) {
            bX.Jc = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bX));
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
        PluginStatus bX = bX(str);
        if (bX == null) {
            bX = new PluginStatus();
        }
        bX.Jc = PluginPackageManager.PluginStatus.ERROR;
        bX.errorMsg = string;
        bX.Jd = string2;
        bX.errorCode = i;
        bX.Je = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bX));
    }

    public void onLoadFailed(String str) {
        PluginStatus bX = bX(str);
        if (bX == null) {
            bX = new PluginStatus();
        }
        bX.Jc = PluginPackageManager.PluginStatus.ERROR;
        bX.errorCode = 100;
        bX.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bX.Jd = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bX));
    }

    public List<PluginStatus> mv() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.Jg) {
            arrayList = new ArrayList(this.Jg.size());
            for (Map.Entry<String, PluginStatus> entry : this.Jg.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Jc == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus bX(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Jg) {
            pluginStatus = this.Jg.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.Gs = str;
                this.Jg.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
