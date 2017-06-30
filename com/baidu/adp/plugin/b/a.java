package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a DK = null;
    private HashMap<String, Integer> DJ = new HashMap<>();

    public static synchronized a jj() {
        a aVar;
        synchronized (a.class) {
            if (DK == null) {
                synchronized (a.class) {
                    if (DK == null) {
                        DK = new a();
                    }
                }
            }
            aVar = DK;
        }
        return aVar;
    }

    public void aZ(String str) {
        if (str != null) {
            Integer num = this.DJ.get(str);
            if (num == null) {
                num = 0;
            }
            this.DJ.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void A(String str, String str2) {
        if (str != null && str2 != null) {
            aZ(str);
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
        c fM = fM();
        fM.p("workflow", String.valueOf(str) + "_cost");
        fM.d("cost", Long.valueOf(j));
        if (i != 0) {
            fM.d(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            fM.p("pname", str2);
        }
        fM.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV != null) {
            fM.p("pver", jV.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", fM);
    }

    public void e(String str, String str2, String str3, String str4) {
        c fM = fM();
        if (str != null) {
            fM.p("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            fM.p("reason", str2);
        }
        if (str3 != null) {
            fM.p("pname", str3);
        }
        if (str4 != null) {
            fM.p("comment", str4);
        }
        fM.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV != null) {
            fM.p("pver", jV.getContainerVersion());
        }
        BdLog.e(fM.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fM);
        BdStatisticsManager.getInstance().save();
    }

    public void f(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        c fM = fM();
        if (str != null) {
            fM.p("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            fM.p("reason", str2);
        }
        if (str3 != null) {
            fM.p("pname", str3);
        }
        c(fM);
        if (str4 != null) {
            fM.p("comment", str4);
        }
        fM.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
        if (jV != null) {
            fM.p("pver", jV.getContainerVersion());
        }
        BdLog.e(fM.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fM);
        BdStatisticsManager.getInstance().save();
    }

    public void jk() {
        if (this.DJ.size() != 0) {
            c fM = fM();
            c(fM);
            BdStatisticsManager.getInstance().debug("pluginproxy", fM);
        }
    }

    public void ba(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void m(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void B(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(c cVar) {
        if (cVar != null) {
            for (Map.Entry<String, Integer> entry : this.DJ.entrySet()) {
                cVar.p(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.DJ.clear();
        }
    }

    private c fM() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean jl() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
