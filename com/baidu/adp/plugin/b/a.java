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
    private static volatile a uk = null;
    private HashMap<String, Integer> uj = new HashMap<>();

    public static synchronized a hs() {
        a aVar;
        synchronized (a.class) {
            if (uk == null) {
                synchronized (a.class) {
                    if (uk == null) {
                        uk = new a();
                    }
                }
            }
            aVar = uk;
        }
        return aVar;
    }

    public void be(String str) {
        if (str != null) {
            Integer num = this.uj.get(str);
            if (num == null) {
                num = 0;
            }
            this.uj.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void C(String str, String str2) {
        if (str != null && str2 != null) {
            be(str);
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
        d dG = dG();
        dG.q("workflow", String.valueOf(str) + "_cost");
        dG.b("cost", Long.valueOf(j));
        if (i != 0) {
            dG.b("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            dG.q("pname", str2);
        }
        dG.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings m9if = c.ii().m9if();
        if (m9if != null) {
            dG.q("pver", m9if.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.dN().b("pluginproxy", dG);
    }

    public void e(String str, String str2, String str3, String str4) {
        d dG = dG();
        if (str != null) {
            dG.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            dG.q("reason", str2);
        }
        if (str3 != null) {
            dG.q("pname", str3);
        }
        if (str4 != null) {
            dG.q("comment", str4);
        }
        dG.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings m9if = c.ii().m9if();
        if (m9if != null) {
            dG.q("pver", m9if.getContainerVersion());
        }
        BdLog.e(dG.toString());
        com.baidu.adp.lib.stats.a.dN().b("pluginproxy", dG);
        com.baidu.adp.lib.stats.a.dN().save();
    }

    public void h(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        d dG = dG();
        if (str != null) {
            dG.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            dG.q("reason", str2);
        }
        if (str3 != null) {
            dG.q("pname", str3);
        }
        c(dG);
        if (str4 != null) {
            dG.q("comment", str4);
        }
        dG.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings m9if = c.ii().m9if();
        if (m9if != null) {
            dG.q("pver", m9if.getContainerVersion());
        }
        BdLog.e(dG.toString());
        com.baidu.adp.lib.stats.a.dN().b("pluginproxy", dG);
        com.baidu.adp.lib.stats.a.dN().save();
    }

    public void ht() {
        if (this.uj.size() != 0) {
            d dG = dG();
            c(dG);
            com.baidu.adp.lib.stats.a.dN().b("pluginproxy", dG);
        }
    }

    public void bf(String str) {
        com.baidu.adp.lib.stats.a.dN().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void m(String str, int i) {
        com.baidu.adp.lib.stats.a.dN().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void D(String str, String str2) {
        com.baidu.adp.lib.stats.a.dN().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.ii().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.dN().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.ii().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.dN().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.dN().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.uj.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.uj.clear();
        }
    }

    private d dG() {
        return com.baidu.adp.lib.stats.a.dN().al("dbg");
    }

    public void H(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean hu() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
