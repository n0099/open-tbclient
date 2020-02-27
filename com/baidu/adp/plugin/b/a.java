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
    private static volatile a xO = null;
    private HashMap<String, Integer> xN = new HashMap<>();

    public static synchronized a jc() {
        a aVar;
        synchronized (a.class) {
            if (xO == null) {
                synchronized (a.class) {
                    if (xO == null) {
                        xO = new a();
                    }
                }
            }
            aVar = xO;
        }
        return aVar;
    }

    public void aW(String str) {
        if (str != null) {
            Integer num = this.xN.get(str);
            if (num == null) {
                num = 0;
            }
            this.xN.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void y(String str, String str2) {
        if (str != null && str2 != null) {
            aW(str);
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
        PluginSettings jS = c.jV().jS();
        if (jS != null) {
            gs.append("pver", jS.getContainerVersion());
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
        PluginSettings jS = c.jV().jS();
        if (jS != null) {
            gs.append("pver", jS.getContainerVersion());
        }
        gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gs.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gs);
    }

    public void g(String str, String str2, String str3) {
        h(str, str2, str3, null);
    }

    private void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gs = gs();
        if (str != null) {
            gs.append("workflow", str);
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
        PluginSettings jS = c.jV().jS();
        if (jS != null) {
            gs.append("pver", jS.getContainerVersion());
        }
        gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gs.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gs);
    }

    public void h(String str, String str2, String str3, String str4) {
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
        d(gs);
        if (str4 != null) {
            gs.append("comment", str4);
        }
        gs.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jS = c.jV().jS();
        if (jS != null) {
            gs.append("pver", jS.getContainerVersion());
        }
        gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(gs.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", gs);
    }

    public void jd() {
        if (this.xN.size() != 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            d(gs);
            gs.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", gs);
        }
    }

    public void log(String str) {
        g(str, null, null, null);
    }

    public void j(String str, int i) {
        g(str, null, null, "count_" + i);
    }

    public void z(String str, String str2) {
        g(str, null, str2, null);
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        int i = 0;
        if (pluginSetting == null) {
            pluginSetting = c.jV().findPluginSetting(str2);
        }
        if (pluginSetting != null) {
            i = pluginSetting.install_fail_count;
        }
        g(str, null, str2, "failContent_" + i + "-callFrom_" + str3);
    }

    public void b(String str, String str2, PluginSetting pluginSetting, String str3) {
        int i = 0;
        if (pluginSetting == null) {
            pluginSetting = c.jV().findPluginSetting(str2);
        }
        if (pluginSetting != null) {
            i = pluginSetting.install_fail_count;
        }
        g(str, str3, str2, "failContent_" + i);
    }

    public void i(String str, String str2, String str3, String str4) {
        g(str, str3, str2, str4);
    }

    private void d(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.xN.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.xN.clear();
        }
    }

    private com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void S(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean je() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
