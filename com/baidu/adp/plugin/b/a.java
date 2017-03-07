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
    private static volatile a Eg = null;
    private HashMap<String, Integer> Ef = new HashMap<>();

    public static synchronized a jg() {
        a aVar;
        synchronized (a.class) {
            if (Eg == null) {
                synchronized (a.class) {
                    if (Eg == null) {
                        Eg = new a();
                    }
                }
            }
            aVar = Eg;
        }
        return aVar;
    }

    public void aZ(String str) {
        if (str != null) {
            Integer num = this.Ef.get(str);
            if (num == null) {
                num = 0;
            }
            this.Ef.put(str, Integer.valueOf(num.intValue() + 1));
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
        c fH = fH();
        fH.p("workflow", String.valueOf(str) + "_cost");
        fH.d("cost", Long.valueOf(j));
        if (i != 0) {
            fH.d(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            fH.p("pname", str2);
        }
        fH.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jT = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().jT();
        if (jT != null) {
            fH.p("pver", jT.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", fH);
    }

    public void e(String str, String str2, String str3, String str4) {
        c fH = fH();
        if (str != null) {
            fH.p("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            fH.p("reason", str2);
        }
        if (str3 != null) {
            fH.p("pname", str3);
        }
        if (str4 != null) {
            fH.p("comment", str4);
        }
        fH.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jT = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().jT();
        if (jT != null) {
            fH.p("pver", jT.getContainerVersion());
        }
        BdLog.e(fH.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fH);
        BdStatisticsManager.getInstance().save();
    }

    public void l(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        c fH = fH();
        if (str != null) {
            fH.p("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            fH.p("reason", str2);
        }
        if (str3 != null) {
            fH.p("pname", str3);
        }
        c(fH);
        if (str4 != null) {
            fH.p("comment", str4);
        }
        fH.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jT = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().jT();
        if (jT != null) {
            fH.p("pver", jT.getContainerVersion());
        }
        BdLog.e(fH.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fH);
        BdStatisticsManager.getInstance().save();
    }

    public void jh() {
        if (this.Ef.size() != 0) {
            c fH = fH();
            c(fH);
            BdStatisticsManager.getInstance().debug("pluginproxy", fH);
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
            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jW().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(c cVar) {
        if (cVar != null) {
            for (Map.Entry<String, Integer> entry : this.Ef.entrySet()) {
                cVar.p(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.Ef.clear();
        }
    }

    private c fH() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean ji() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
