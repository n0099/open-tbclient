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
    private static volatile a DN = null;
    private HashMap<String, Integer> DM = new HashMap<>();

    public static synchronized a lq() {
        a aVar;
        synchronized (a.class) {
            if (DN == null) {
                synchronized (a.class) {
                    if (DN == null) {
                        DN = new a();
                    }
                }
            }
            aVar = DN;
        }
        return aVar;
    }

    public void bn(String str) {
        if (str != null) {
            Integer num = this.DM.get(str);
            if (num == null) {
                num = 0;
            }
            this.DM.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void E(String str, String str2) {
        if (str != null && str2 != null) {
            bn(str);
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
        d hm = hm();
        hm.r("workflow", String.valueOf(str) + "_cost");
        hm.b("cost", Long.valueOf(j));
        if (i != 0) {
            hm.b(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hm.r("pname", str2);
        }
        hm.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lZ = c.mc().lZ();
        if (lZ != null) {
            hm.r("pver", lZ.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.ht().b("pluginproxy", hm);
    }

    public void e(String str, String str2, String str3, String str4) {
        d hm = hm();
        if (str != null) {
            hm.r("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            hm.r("reason", str2);
        }
        if (str3 != null) {
            hm.r("pname", str3);
        }
        if (str4 != null) {
            hm.r("comment", str4);
        }
        hm.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lZ = c.mc().lZ();
        if (lZ != null) {
            hm.r("pver", lZ.getContainerVersion());
        }
        BdLog.e(hm.toString());
        com.baidu.adp.lib.stats.a.ht().b("pluginproxy", hm);
        com.baidu.adp.lib.stats.a.ht().save();
    }

    public void h(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        d hm = hm();
        if (str != null) {
            hm.r("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hm.r("reason", str2);
        }
        if (str3 != null) {
            hm.r("pname", str3);
        }
        c(hm);
        if (str4 != null) {
            hm.r("comment", str4);
        }
        hm.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lZ = c.mc().lZ();
        if (lZ != null) {
            hm.r("pver", lZ.getContainerVersion());
        }
        BdLog.e(hm.toString());
        com.baidu.adp.lib.stats.a.ht().b("pluginproxy", hm);
        com.baidu.adp.lib.stats.a.ht().save();
    }

    public void lr() {
        if (this.DM.size() != 0) {
            d hm = hm();
            c(hm);
            com.baidu.adp.lib.stats.a.ht().b("pluginproxy", hm);
        }
    }

    public void bo(String str) {
        com.baidu.adp.lib.stats.a.ht().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void l(String str, int i) {
        com.baidu.adp.lib.stats.a.ht().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void F(String str, String str2) {
        com.baidu.adp.lib.stats.a.ht().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mc().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.ht().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mc().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.ht().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.ht().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.DM.entrySet()) {
                dVar.r(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.DM.clear();
        }
    }

    private d hm() {
        return com.baidu.adp.lib.stats.a.ht().aq("dbg");
    }

    public void I(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean ls() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
