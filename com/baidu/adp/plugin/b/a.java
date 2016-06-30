package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static volatile a um = null;
    private HashMap<String, Integer> ul = new HashMap<>();

    public static synchronized a hu() {
        a aVar;
        synchronized (a.class) {
            if (um == null) {
                synchronized (a.class) {
                    if (um == null) {
                        um = new a();
                    }
                }
            }
            aVar = um;
        }
        return aVar;
    }

    public void be(String str) {
        if (str != null) {
            Integer num = this.ul.get(str);
            if (num == null) {
                num = 0;
            }
            this.ul.put(str, Integer.valueOf(num.intValue() + 1));
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
        d dH = dH();
        dH.q("workflow", String.valueOf(str) + "_cost");
        dH.b("cost", Long.valueOf(j));
        if (i != 0) {
            dH.b("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            dH.q("pname", str2);
        }
        dH.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings ih = c.ik().ih();
        if (ih != null) {
            dH.q("pver", ih.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.dO().b("pluginproxy", dH);
    }

    public void e(String str, String str2, String str3, String str4) {
        d dH = dH();
        if (str != null) {
            dH.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            dH.q("reason", str2);
        }
        if (str3 != null) {
            dH.q("pname", str3);
        }
        if (str4 != null) {
            dH.q("comment", str4);
        }
        dH.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings ih = c.ik().ih();
        if (ih != null) {
            dH.q("pver", ih.getContainerVersion());
        }
        BdLog.e(dH.toString());
        com.baidu.adp.lib.stats.a.dO().b("pluginproxy", dH);
        com.baidu.adp.lib.stats.a.dO().save();
    }

    public void m(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        d dH = dH();
        if (str != null) {
            dH.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            dH.q("reason", str2);
        }
        if (str3 != null) {
            dH.q("pname", str3);
        }
        c(dH);
        if (str4 != null) {
            dH.q("comment", str4);
        }
        dH.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings ih = c.ik().ih();
        if (ih != null) {
            dH.q("pver", ih.getContainerVersion());
        }
        BdLog.e(dH.toString());
        com.baidu.adp.lib.stats.a.dO().b("pluginproxy", dH);
        com.baidu.adp.lib.stats.a.dO().save();
    }

    public void hv() {
        if (this.ul.size() != 0) {
            d dH = dH();
            c(dH);
            com.baidu.adp.lib.stats.a.dO().b("pluginproxy", dH);
        }
    }

    public void bf(String str) {
        com.baidu.adp.lib.stats.a.dO().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void m(String str, int i) {
        com.baidu.adp.lib.stats.a.dO().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void D(String str, String str2) {
        com.baidu.adp.lib.stats.a.dO().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.ik().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.dO().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.ik().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.dO().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.dO().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.ul.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.ul.clear();
        }
    }

    private d dH() {
        return com.baidu.adp.lib.stats.a.dO().al("dbg");
    }

    public void H(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean hw() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
