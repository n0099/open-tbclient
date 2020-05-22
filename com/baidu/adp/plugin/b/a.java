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
    private static volatile a Rg = null;
    private HashMap<String, Integer> Rf = new HashMap<>();

    public static synchronized a nH() {
        a aVar;
        synchronized (a.class) {
            if (Rg == null) {
                synchronized (a.class) {
                    if (Rg == null) {
                        Rg = new a();
                    }
                }
            }
            aVar = Rg;
        }
        return aVar;
    }

    public void cm(String str) {
        if (str != null) {
            Integer num = this.Rf.get(str);
            if (num == null) {
                num = 0;
            }
            this.Rf.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void C(String str, String str2) {
        if (str != null && str2 != null) {
            cm(str);
        }
    }

    public void e(String str, long j) {
        a(str, j, 0);
    }

    public void b(String str, long j, String str2) {
        b(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        b(str, j, i, (String) null);
    }

    public void b(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a kY = kY();
        kY.append("workflow", str + "_cost");
        kY.append(BdStatsConstant.StatsKey.COST, Long.valueOf(j));
        if (i != 0) {
            kY.append("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            kY.append("pname", str2);
        }
        kY.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings ox = c.oA().ox();
        if (ox != null) {
            kY.append("pver", ox.getContainerVersion());
        }
        kY.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", kY);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a kY = kY();
        if (str != null) {
            kY.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            kY.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            kY.append("pname", str3);
        }
        if (str4 != null) {
            kY.append("comment", str4);
        }
        kY.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings ox = c.oA().ox();
        if (ox != null) {
            kY.append("pver", ox.getContainerVersion());
        }
        kY.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(kY.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", kY);
    }

    public void g(String str, String str2, String str3) {
        h(str, str2, str3, null);
    }

    private void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a kY = kY();
        if (str != null) {
            kY.append("workflow", str);
        }
        if (str2 != null) {
            kY.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            kY.append("pname", str3);
        }
        if (str4 != null) {
            kY.append("comment", str4);
        }
        kY.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings ox = c.oA().ox();
        if (ox != null) {
            kY.append("pver", ox.getContainerVersion());
        }
        kY.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(kY.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", kY);
    }

    public void h(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a kY = kY();
        if (str != null) {
            kY.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            kY.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            kY.append("pname", str3);
        }
        d(kY);
        if (str4 != null) {
            kY.append("comment", str4);
        }
        kY.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings ox = c.oA().ox();
        if (ox != null) {
            kY.append("pver", ox.getContainerVersion());
        }
        kY.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(kY.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", kY);
    }

    public void nI() {
        if (this.Rf.size() != 0) {
            com.baidu.adp.lib.stats.a kY = kY();
            d(kY);
            kY.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", kY);
        }
    }

    public void log(String str) {
        g(str, null, null, null);
    }

    public void n(String str, int i) {
        g(str, null, null, "count_" + i);
    }

    public void D(String str, String str2) {
        g(str, null, str2, null);
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        int i = 0;
        if (pluginSetting == null) {
            pluginSetting = c.oA().findPluginSetting(str2);
        }
        if (pluginSetting != null) {
            i = pluginSetting.install_fail_count;
        }
        g(str, null, str2, "failContent_" + i + "-callFrom_" + str3);
    }

    public void b(String str, String str2, PluginSetting pluginSetting, String str3) {
        int i = 0;
        if (pluginSetting == null) {
            pluginSetting = c.oA().findPluginSetting(str2);
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
            for (Map.Entry<String, Integer> entry : this.Rf.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.Rf.clear();
        }
    }

    private com.baidu.adp.lib.stats.a kY() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void at(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean nJ() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
