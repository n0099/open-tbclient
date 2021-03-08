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
    private static volatile a Vl = null;
    private HashMap<String, Integer> Vk = new HashMap<>();

    public static synchronized a pe() {
        a aVar;
        synchronized (a.class) {
            if (Vl == null) {
                synchronized (a.class) {
                    if (Vl == null) {
                        Vl = new a();
                    }
                }
            }
            aVar = Vl;
        }
        return aVar;
    }

    public void cv(String str) {
        if (str != null) {
            Integer num = this.Vk.get(str);
            if (num == null) {
                num = 0;
            }
            this.Vk.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void A(String str, String str2) {
        if (str != null && str2 != null) {
            cv(str);
        }
    }

    public void d(String str, long j) {
        a(str, j, 0);
    }

    public void b(String str, long j, String str2) {
        b(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        b(str, j, i, (String) null);
    }

    public void b(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a pg = pg();
        pg.append("workflow", str + "_cost");
        pg.append(BdStatsConstant.StatsKey.COST, Long.valueOf(j));
        if (i != 0) {
            pg.append("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            pg.append("pname", str2);
        }
        pg.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings pU = c.pX().pU();
        if (pU != null) {
            pg.append("pver", pU.getContainerVersion());
        }
        pg.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", pg);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a pg = pg();
        if (str != null) {
            pg.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            pg.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            pg.append("pname", str3);
        }
        if (str4 != null) {
            pg.append("comment", str4);
        }
        pg.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings pU = c.pX().pU();
        if (pU != null) {
            pg.append("pver", pU.getContainerVersion());
        }
        pg.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(pg.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", pg);
    }

    public void g(String str, String str2, String str3) {
        h(str, str2, str3, null);
    }

    private void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a pg = pg();
        if (str != null) {
            pg.append("workflow", str);
        }
        if (str2 != null) {
            pg.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            pg.append("pname", str3);
        }
        if (str4 != null) {
            pg.append("comment", str4);
        }
        pg.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings pU = c.pX().pU();
        if (pU != null) {
            pg.append("pver", pU.getContainerVersion());
        }
        pg.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(pg.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", pg);
    }

    public void h(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a pg = pg();
        if (str != null) {
            pg.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            pg.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            pg.append("pname", str3);
        }
        d(pg);
        if (str4 != null) {
            pg.append("comment", str4);
        }
        pg.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings pU = c.pX().pU();
        if (pU != null) {
            pg.append("pver", pU.getContainerVersion());
        }
        pg.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(pg.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", pg);
    }

    public void pf() {
        if (this.Vk.size() != 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            d(pg);
            pg.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", pg);
        }
    }

    public void log(String str) {
        g(str, null, null, null);
    }

    public void o(String str, int i) {
        g(str, null, null, "count_" + i);
    }

    public void B(String str, String str2) {
        g(str, null, str2, null);
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        int i = 0;
        if (pluginSetting == null) {
            pluginSetting = c.pX().findPluginSetting(str2);
        }
        if (pluginSetting != null) {
            i = pluginSetting.install_fail_count;
        }
        g(str, null, str2, "failContent_" + i + "-callFrom_" + str3);
    }

    public void b(String str, String str2, PluginSetting pluginSetting, String str3) {
        int i = 0;
        if (pluginSetting == null) {
            pluginSetting = c.pX().findPluginSetting(str2);
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
            for (Map.Entry<String, Integer> entry : this.Vk.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.Vk.clear();
        }
    }

    private com.baidu.adp.lib.stats.a pg() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void at(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean ph() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
