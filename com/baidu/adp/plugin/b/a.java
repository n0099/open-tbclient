package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.d;
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
    private static volatile a DT = null;
    private HashMap<String, Integer> DS = new HashMap<>();

    public static synchronized a lf() {
        a aVar;
        synchronized (a.class) {
            if (DT == null) {
                synchronized (a.class) {
                    if (DT == null) {
                        DT = new a();
                    }
                }
            }
            aVar = DT;
        }
        return aVar;
    }

    public void bl(String str) {
        if (str != null) {
            Integer num = this.DS.get(str);
            if (num == null) {
                num = 0;
            }
            this.DS.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void D(String str, String str2) {
        if (str != null && str2 != null) {
            bl(str);
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
        d hs = hs();
        hs.r("workflow", String.valueOf(str) + "_cost");
        hs.b("cost", Long.valueOf(j));
        if (i != 0) {
            hs.b(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hs.r("pname", str2);
        }
        hs.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lR = c.lU().lR();
        if (lR != null) {
            hs.r("pver", lR.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.hz().b("pluginproxy", hs);
    }

    public void e(String str, String str2, String str3, String str4) {
        d hs = hs();
        if (str != null) {
            hs.r("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            hs.r("reason", str2);
        }
        if (str3 != null) {
            hs.r("pname", str3);
        }
        if (str4 != null) {
            hs.r("comment", str4);
        }
        hs.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lR = c.lU().lR();
        if (lR != null) {
            hs.r("pver", lR.getContainerVersion());
        }
        BdLog.e(hs.toString());
        com.baidu.adp.lib.stats.a.hz().b("pluginproxy", hs);
        com.baidu.adp.lib.stats.a.hz().save();
    }

    public void h(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        d hs = hs();
        if (str != null) {
            hs.r("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hs.r("reason", str2);
        }
        if (str3 != null) {
            hs.r("pname", str3);
        }
        c(hs);
        if (str4 != null) {
            hs.r("comment", str4);
        }
        hs.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lR = c.lU().lR();
        if (lR != null) {
            hs.r("pver", lR.getContainerVersion());
        }
        BdLog.e(hs.toString());
        com.baidu.adp.lib.stats.a.hz().b("pluginproxy", hs);
        com.baidu.adp.lib.stats.a.hz().save();
    }

    public void lg() {
        if (this.DS.size() != 0) {
            d hs = hs();
            c(hs);
            com.baidu.adp.lib.stats.a.hz().b("pluginproxy", hs);
        }
    }

    public void bm(String str) {
        com.baidu.adp.lib.stats.a.hz().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void l(String str, int i) {
        com.baidu.adp.lib.stats.a.hz().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void E(String str, String str2) {
        com.baidu.adp.lib.stats.a.hz().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.lU().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hz().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.lU().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hz().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.hz().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.DS.entrySet()) {
                dVar.r(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.DS.clear();
        }
    }

    private d hs() {
        return com.baidu.adp.lib.stats.a.hz().as("dbg");
    }

    public void H(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lh() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
