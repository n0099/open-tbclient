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

    public static synchronized a lE() {
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
        a(str, j, i, (String) null);
    }

    public void a(String str, long j, int i, String str2) {
        d ha = ha();
        ha.q("workflow", String.valueOf(str) + "_cost");
        ha.e("cost", Long.valueOf(j));
        if (i != 0) {
            ha.e(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            ha.q("pname", str2);
        }
        com.baidu.adp.lib.stats.a.hh().b("pluginproxy", ha);
    }

    public void d(String str, String str2, String str3, String str4) {
        d ha = ha();
        if (str != null) {
            ha.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            ha.q("reason", str2);
        }
        if (str3 != null) {
            ha.q("pname", str3);
        }
        if (str4 != null) {
            ha.q("comment", str4);
        }
        BdLog.e(ha.toString());
        com.baidu.adp.lib.stats.a.hh().b("pluginproxy", ha);
        com.baidu.adp.lib.stats.a.hh().save();
    }

    public void g(String str, String str2, String str3) {
        e(str, str2, str3, null);
    }

    public void e(String str, String str2, String str3, String str4) {
        d ha = ha();
        if (str != null) {
            ha.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            ha.q("reason", str2);
        }
        if (str3 != null) {
            ha.q("pname", str3);
        }
        c(ha);
        if (str4 != null) {
            ha.q("comment", str4);
        }
        BdLog.e(ha.toString());
        com.baidu.adp.lib.stats.a.hh().b("pluginproxy", ha);
        com.baidu.adp.lib.stats.a.hh().save();
    }

    public void lF() {
        if (this.CX.size() != 0) {
            d ha = ha();
            c(ha);
            com.baidu.adp.lib.stats.a.hh().b("pluginproxy", ha);
        }
    }

    public void bi(String str) {
        com.baidu.adp.lib.stats.a.hh().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void k(String str, int i) {
        com.baidu.adp.lib.stats.a.hh().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void I(String str, String str2) {
        com.baidu.adp.lib.stats.a.hh().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void a(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mm().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hh().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mm().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hh().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void h(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.a.hh().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.CX.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.CX.clear();
        }
    }

    private d ha() {
        return com.baidu.adp.lib.stats.a.hh().ap("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lG() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
