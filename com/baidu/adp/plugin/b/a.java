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
    private static volatile a xb = null;
    private HashMap<String, Integer> xa = new HashMap<>();

    public static synchronized a io() {
        a aVar;
        synchronized (a.class) {
            if (xb == null) {
                synchronized (a.class) {
                    if (xb == null) {
                        xb = new a();
                    }
                }
            }
            aVar = xb;
        }
        return aVar;
    }

    public void bg(String str) {
        if (str != null) {
            Integer num = this.xa.get(str);
            if (num == null) {
                num = 0;
            }
            this.xa.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void C(String str, String str2) {
        if (str != null && str2 != null) {
            bg(str);
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
        d eB = eB();
        eB.q("workflow", String.valueOf(str) + "_cost");
        eB.d("cost", Long.valueOf(j));
        if (i != 0) {
            eB.d(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            eB.q("pname", str2);
        }
        eB.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jb = c.je().jb();
        if (jb != null) {
            eB.q("pver", jb.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.eI().b("pluginproxy", eB);
    }

    public void e(String str, String str2, String str3, String str4) {
        d eB = eB();
        if (str != null) {
            eB.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            eB.q("reason", str2);
        }
        if (str3 != null) {
            eB.q("pname", str3);
        }
        if (str4 != null) {
            eB.q("comment", str4);
        }
        eB.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jb = c.je().jb();
        if (jb != null) {
            eB.q("pver", jb.getContainerVersion());
        }
        BdLog.e(eB.toString());
        com.baidu.adp.lib.stats.a.eI().b("pluginproxy", eB);
        com.baidu.adp.lib.stats.a.eI().save();
    }

    public void m(String str, String str2, String str3) {
        f(str, str2, str3, null);
    }

    public void f(String str, String str2, String str3, String str4) {
        d eB = eB();
        if (str != null) {
            eB.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            eB.q("reason", str2);
        }
        if (str3 != null) {
            eB.q("pname", str3);
        }
        c(eB);
        if (str4 != null) {
            eB.q("comment", str4);
        }
        eB.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jb = c.je().jb();
        if (jb != null) {
            eB.q("pver", jb.getContainerVersion());
        }
        BdLog.e(eB.toString());
        com.baidu.adp.lib.stats.a.eI().b("pluginproxy", eB);
        com.baidu.adp.lib.stats.a.eI().save();
    }

    public void ip() {
        if (this.xa.size() != 0) {
            d eB = eB();
            c(eB);
            com.baidu.adp.lib.stats.a.eI().b("pluginproxy", eB);
        }
    }

    public void bh(String str) {
        com.baidu.adp.lib.stats.a.eI().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void m(String str, int i) {
        com.baidu.adp.lib.stats.a.eI().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void D(String str, String str2) {
        com.baidu.adp.lib.stats.a.eI().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.je().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.eI().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.je().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.eI().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.eI().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.xa.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.xa.clear();
        }
    }

    private d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public void L(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean iq() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
