package com.baidu.adp.plugin.b;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a CY = null;
    private HashMap<String, Integer> CX = new HashMap<>();

    public static synchronized a lH() {
        a aVar;
        synchronized (a.class) {
            if (CY == null) {
                synchronized (a.class) {
                    if (CY == null) {
                        CY = new a();
                    }
                }
            }
            aVar = CY;
        }
        return aVar;
    }

    public void bh(String str) {
        if (str != null) {
            Integer num = this.CX.get(str);
            if (num == null) {
                num = 0;
            }
            this.CX.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void H(String str, String str2) {
        if (str != null && str2 != null) {
            bh(str);
        }
    }

    public void e(String str, long j) {
        a(str, j, 0);
    }

    public void a(String str, long j, String str2) {
        a(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        a(str, j, i, null);
    }

    public void a(String str, long j, int i, String str2) {
        d hd = hd();
        hd.q("workflow", String.valueOf(str) + "_cost");
        hd.e("cost", Long.valueOf(j));
        if (i != 0) {
            hd.e(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hd.q("pname", str2);
        }
        com.baidu.adp.lib.stats.a.hk().b("pluginproxy", hd);
    }

    public void g(String str, String str2, String str3) {
        d(str, str2, str3, null);
    }

    public void d(String str, String str2, String str3, String str4) {
        d hd = hd();
        if (str != null) {
            hd.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hd.q("reason", str2);
        }
        if (str3 != null) {
            hd.q("pname", str3);
        }
        c(hd);
        if (str4 != null) {
            hd.q("comment", str4);
        }
        BdLog.e(hd.toString());
        com.baidu.adp.lib.stats.a.hk().b("pluginproxy", hd);
        com.baidu.adp.lib.stats.a.hk().save();
    }

    public void lI() {
        if (this.CX.size() != 0) {
            d hd = hd();
            c(hd);
            com.baidu.adp.lib.stats.a.hk().b("pluginproxy", hd);
        }
    }

    public void bi(String str) {
        com.baidu.adp.lib.stats.a.hk().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void k(String str, int i) {
        com.baidu.adp.lib.stats.a.hk().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void I(String str, String str2) {
        com.baidu.adp.lib.stats.a.hk().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void a(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mp().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hk().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.CX.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.CX.clear();
        }
    }

    private d hd() {
        return com.baidu.adp.lib.stats.a.hk().ap("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lJ() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
