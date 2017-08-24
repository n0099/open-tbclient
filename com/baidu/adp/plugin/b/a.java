package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a Fl = null;
    private HashMap<String, Integer> Fk = new HashMap<>();

    public static synchronized a jr() {
        a aVar;
        synchronized (a.class) {
            if (Fl == null) {
                synchronized (a.class) {
                    if (Fl == null) {
                        Fl = new a();
                    }
                }
            }
            aVar = Fl;
        }
        return aVar;
    }

    public void bi(String str) {
        if (str != null) {
            Integer num = this.Fk.get(str);
            if (num == null) {
                num = 0;
            }
            this.Fk.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void A(String str, String str2) {
        if (str != null && str2 != null) {
            bi(str);
        }
    }

    public void f(String str, long j) {
        a(str, j, 0);
    }

    public void a(String str, long j, String str2) {
        a(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        a(str, j, i, (String) null);
    }

    public void a(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a fV = fV();
        fV.p("workflow", str + "_cost");
        fV.d("cost", Long.valueOf(j));
        if (i != 0) {
            fV.d(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            fV.p("pname", str2);
        }
        fV.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings kd = c.kg().kd();
        if (kd != null) {
            fV.p("pver", kd.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", fV);
    }

    public void c(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fV = fV();
        if (str != null) {
            fV.p("workflow", str + "_debug");
        }
        if (str2 != null) {
            fV.p("reason", str2);
        }
        if (str3 != null) {
            fV.p("pname", str3);
        }
        if (str4 != null) {
            fV.p("comment", str4);
        }
        fV.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings kd = c.kg().kd();
        if (kd != null) {
            fV.p("pver", kd.getContainerVersion());
        }
        BdLog.e(fV.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fV);
        BdStatisticsManager.getInstance().save();
    }

    public void f(String str, String str2, String str3) {
        d(str, str2, str3, null);
    }

    public void d(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fV = fV();
        if (str != null) {
            fV.p("workflow", str + "_failure");
        }
        if (str2 != null) {
            fV.p("reason", str2);
        }
        if (str3 != null) {
            fV.p("pname", str3);
        }
        c(fV);
        if (str4 != null) {
            fV.p("comment", str4);
        }
        fV.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings kd = c.kg().kd();
        if (kd != null) {
            fV.p("pver", kd.getContainerVersion());
        }
        BdLog.e(fV.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fV);
        BdStatisticsManager.getInstance().save();
    }

    public void js() {
        if (this.Fk.size() != 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            c(fV);
            BdStatisticsManager.getInstance().debug("pluginproxy", fV);
        }
    }

    public void bj(String str) {
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
            pluginSetting = c.kg().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.kg().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void e(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.Fk.entrySet()) {
                aVar.p(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.Fk.clear();
        }
    }

    private com.baidu.adp.lib.stats.a fV() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean jt() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
