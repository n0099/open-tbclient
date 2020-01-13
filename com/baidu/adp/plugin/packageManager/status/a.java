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
    private static a zb;
    private final LinkedHashMap<String, PluginStatus> zc = new LinkedHashMap<>(10);

    private a() {
    }

    public static a jM() {
        if (zb == null) {
            synchronized (a.class) {
                if (zb == null) {
                    zb = new a();
                }
            }
        }
        return zb;
    }

    public void bq(String str) {
        PluginStatus bs = jM().bs(str);
        if (bs != null) {
            bs.yY = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_SUCCESS, bs));
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
        PluginStatus bs = bs(str);
        if (bs == null) {
            bs = new PluginStatus();
        }
        bs.yY = PluginPackageManager.PluginStatus.ERROR;
        bs.errorMsg = string;
        bs.yZ = string2;
        bs.errorCode = i;
        bs.za = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_INSTALL_FAIL, bs));
    }

    public void br(String str) {
        PluginStatus bs = bs(str);
        if (bs == null) {
            bs = new PluginStatus();
        }
        bs.yY = PluginPackageManager.PluginStatus.ERROR;
        bs.errorCode = 100;
        bs.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bs.yZ = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_LOAD_FAIL, bs));
    }

    public List<PluginStatus> jN() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.zc) {
            arrayList = new ArrayList(this.zc.size());
            for (Map.Entry<String, PluginStatus> entry : this.zc.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.yY == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus bs(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.zc) {
            pluginStatus = this.zc.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.pkgName = str;
                this.zc.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }
}
