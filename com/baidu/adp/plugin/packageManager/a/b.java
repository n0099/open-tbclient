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
    private static b Fn;
    private final LinkedHashMap<String, a> Fo = new LinkedHashMap<>(10);

    private b() {
    }

    public static b mi() {
        if (Fn == null) {
            synchronized (b.class) {
                if (Fn == null) {
                    Fn = new b();
                }
            }
        }
        return Fn;
    }

    public void bM(String str) {
        a bO = mi().bO(str);
        if (bO != null) {
            bO.Fk = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, bO));
    }

    public void j(String str, String str2, String str3) {
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
        a bO = bO(str);
        if (bO == null) {
            bO = new a();
        }
        bO.Fk = PluginPackageManager.PluginStatus.ERROR;
        bO.errorMsg = string;
        bO.Fl = string2;
        bO.errorCode = i;
        bO.Fm = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, bO));
    }

    public void bN(String str) {
        a bO = bO(str);
        if (bO == null) {
            bO = new a();
        }
        bO.Fk = PluginPackageManager.PluginStatus.ERROR;
        bO.errorCode = 100;
        bO.errorMsg = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        bO.Fl = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, bO));
    }

    public List<a> mj() {
        ArrayList arrayList;
        a value;
        synchronized (this.Fo) {
            arrayList = new ArrayList(this.Fo.size());
            for (Map.Entry<String, a> entry : this.Fo.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.Fk == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public a bO(String str) {
        a aVar;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Fo) {
            aVar = this.Fo.get(str);
            if (aVar == null) {
                aVar = new a();
                aVar.pkgName = str;
                this.Fo.put(str, aVar);
            }
        }
        return aVar;
    }
}
