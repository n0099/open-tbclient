package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a xs = null;
    private HashMap<String, Integer> xr = new HashMap<>();

    public static synchronized a iO() {
        a aVar;
        synchronized (a.class) {
            if (xs == null) {
                synchronized (a.class) {
                    if (xs == null) {
                        xs = new a();
                    }
                }
            }
            aVar = xs;
        }
        return aVar;
    }

    public void aT(String str) {
        if (str != null) {
            Integer num = this.xr.get(str);
            if (num == null) {
                num = 0;
            }
            this.xr.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void u(String str, String str2) {
        if (str != null && str2 != null) {
            aT(str);
        }
    }

    public void e(String str, long j) {
        b(str, j, 0);
    }

    public void b(String str, long j, String str2) {
        b(str, j, 0, str2);
    }

    public void b(String str, long j, int i) {
        b(str, j, i, (String) null);
    }

    public void b(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a gt = gt();
        gt.append("workflow", str + "_cost");
        gt.append(BdStatsConstant.StatsKey.COST, Long.valueOf(j));
        if (i != 0) {
            gt.append("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            gt.append("pname", str2);
        }
        gt.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jE = c.jH().jE();
        if (jE != null) {
            gt.append("pver", jE.getContainerVersion());
        }
        gt.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", gt);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gt = gt();
        if (str != null) {
            gt.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            gt.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            gt.append("pname", str3);
        }
        if (str4 != null) {
            gt.append("comment", str4);
        }
        gt.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jE = c.jH().jE();
        if (jE != null) {
            gt.append("pver", jE.getContainerVersion());
        }
        gt.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gt.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gt);
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gt = gt();
        if (str != null) {
            gt.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            gt.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            gt.append("pname", str3);
        }
        c(gt);
        if (str4 != null) {
            gt.append("comment", str4);
        }
        gt.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jE = c.jH().jE();
        if (jE != null) {
            gt.append("pver", jE.getContainerVersion());
        }
        gt.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gt.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gt);
    }

    public void iP() {
        if (this.xr.size() != 0) {
            com.baidu.adp.lib.stats.a gt = gt();
            c(gt);
            gt.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", gt);
        }
    }

    public void aU(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void j(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void x(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.jH().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()), "comment", "callFrom_" + str3);
    }

    public void b(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.jH().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), TiebaInitialize.LogFields.REASON, str3, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, TiebaInitialize.LogFields.REASON, str3, "comment", str4, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.xr.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.xr.clear();
        }
    }

    private com.baidu.adp.lib.stats.a gt() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void P(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean iQ() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
