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
    private static volatile a xw = null;
    private HashMap<String, Integer> xv = new HashMap<>();

    public static synchronized a iN() {
        a aVar;
        synchronized (a.class) {
            if (xw == null) {
                synchronized (a.class) {
                    if (xw == null) {
                        xw = new a();
                    }
                }
            }
            aVar = xw;
        }
        return aVar;
    }

    public void aT(String str) {
        if (str != null) {
            Integer num = this.xv.get(str);
            if (num == null) {
                num = 0;
            }
            this.xv.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void t(String str, String str2) {
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
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("workflow", str + "_cost");
        gs.append(BdStatsConstant.StatsKey.COST, Long.valueOf(j));
        if (i != 0) {
            gs.append("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            gs.append("pname", str2);
        }
        gs.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jD = c.jG().jD();
        if (jD != null) {
            gs.append("pver", jD.getContainerVersion());
        }
        gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", gs);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gs = gs();
        if (str != null) {
            gs.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            gs.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            gs.append("pname", str3);
        }
        if (str4 != null) {
            gs.append("comment", str4);
        }
        gs.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jD = c.jG().jD();
        if (jD != null) {
            gs.append("pver", jD.getContainerVersion());
        }
        gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gs.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gs);
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gs = gs();
        if (str != null) {
            gs.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            gs.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            gs.append("pname", str3);
        }
        c(gs);
        if (str4 != null) {
            gs.append("comment", str4);
        }
        gs.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jD = c.jG().jD();
        if (jD != null) {
            gs.append("pver", jD.getContainerVersion());
        }
        gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gs.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gs);
    }

    public void iO() {
        if (this.xv.size() != 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            c(gs);
            gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", gs);
        }
    }

    public void aU(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void j(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void u(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.jG().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()), "comment", "callFrom_" + str3);
    }

    public void b(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.jG().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), TiebaInitialize.LogFields.REASON, str3, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, TiebaInitialize.LogFields.REASON, str3, "comment", str4, "appver", BdStatisticsManager.getInstance().getAppVersion(), "pid", Integer.valueOf(Process.myPid()));
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.xv.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.xv.clear();
        }
    }

    private com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void P(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean iP() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
