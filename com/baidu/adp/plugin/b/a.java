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
    private static volatile a uP = null;
    private HashMap<String, Integer> uO = new HashMap<>();

    public static synchronized a iv() {
        a aVar;
        synchronized (a.class) {
            if (uP == null) {
                synchronized (a.class) {
                    if (uP == null) {
                        uP = new a();
                    }
                }
            }
            aVar = uP;
        }
        return aVar;
    }

    public void aH(String str) {
        if (str != null) {
            Integer num = this.uO.get(str);
            if (num == null) {
                num = 0;
            }
            this.uO.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void o(String str, String str2) {
        if (str != null && str2 != null) {
            aH(str);
        }
    }

    public void f(String str, long j) {
        b(str, j, 0);
    }

    public void b(String str, long j, String str2) {
        b(str, j, 0, str2);
    }

    public void b(String str, long j, int i) {
        b(str, j, i, null);
    }

    public void b(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a fU = fU();
        fU.append("workflow", str + "_cost");
        fU.append(BdStatsConstant.StatsKey.COST, Long.valueOf(j));
        if (i != 0) {
            fU.append("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            fU.append("pname", str2);
        }
        fU.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jm = c.jp().jm();
        if (jm != null) {
            fU.append("pver", jm.getContainerVersion());
        }
        fU.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", fU);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fU = fU();
        if (str != null) {
            fU.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            fU.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            fU.append("pname", str3);
        }
        if (str4 != null) {
            fU.append("comment", str4);
        }
        fU.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jm = c.jp().jm();
        if (jm != null) {
            fU.append("pver", jm.getContainerVersion());
        }
        fU.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(fU.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fU);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fU = fU();
        if (str != null) {
            fU.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            fU.append(TiebaInitialize.LogFields.REASON, str2);
        }
        if (str3 != null) {
            fU.append("pname", str3);
        }
        c(fU);
        if (str4 != null) {
            fU.append("comment", str4);
        }
        fU.append("pid", Integer.valueOf(Process.myPid()));
        PluginSettings jm = c.jp().jm();
        if (jm != null) {
            fU.append("pver", jm.getContainerVersion());
        }
        fU.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(fU.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fU);
        BdStatisticsManager.getInstance().save();
    }

    public void iw() {
        if (this.uO.size() != 0) {
            com.baidu.adp.lib.stats.a fU = fU();
            c(fU);
            fU.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", fU);
        }
    }

    public void aI(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void g(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void q(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.jp().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.jp().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), TiebaInitialize.LogFields.REASON, str3, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, TiebaInitialize.LogFields.REASON, str3, "comment", str4, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.uO.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.uO.clear();
        }
    }

    private com.baidu.adp.lib.stats.a fU() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void K(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean ix() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
