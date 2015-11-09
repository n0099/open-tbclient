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
    private static volatile a Db = null;
    private HashMap<String, Integer> Da = new HashMap<>();

    public static synchronized a lG() {
        a aVar;
        synchronized (a.class) {
            if (Db == null) {
                synchronized (a.class) {
                    if (Db == null) {
                        Db = new a();
                    }
                }
            }
            aVar = Db;
        }
        return aVar;
    }

    public void bg(String str) {
        if (str != null) {
            Integer num = this.Da.get(str);
            if (num == null) {
                num = 0;
            }
            this.Da.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void H(String str, String str2) {
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
        d hc = hc();
        hc.q("workflow", String.valueOf(str) + "_cost");
        hc.e("cost", Long.valueOf(j));
        if (i != 0) {
            hc.e(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hc.q("pname", str2);
        }
        hc.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings ml = c.mo().ml();
        if (ml != null) {
            hc.q("pver", ml.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.hj().b("pluginproxy", hc);
    }

    public void d(String str, String str2, String str3, String str4) {
        d hc = hc();
        if (str != null) {
            hc.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            hc.q("reason", str2);
        }
        if (str3 != null) {
            hc.q("pname", str3);
        }
        if (str4 != null) {
            hc.q("comment", str4);
        }
        hc.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings ml = c.mo().ml();
        if (ml != null) {
            hc.q("pver", ml.getContainerVersion());
        }
        BdLog.e(hc.toString());
        com.baidu.adp.lib.stats.a.hj().b("pluginproxy", hc);
        com.baidu.adp.lib.stats.a.hj().save();
    }

    public void g(String str, String str2, String str3) {
        e(str, str2, str3, null);
    }

    public void e(String str, String str2, String str3, String str4) {
        d hc = hc();
        if (str != null) {
            hc.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hc.q("reason", str2);
        }
        if (str3 != null) {
            hc.q("pname", str3);
        }
        c(hc);
        if (str4 != null) {
            hc.q("comment", str4);
        }
        hc.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings ml = c.mo().ml();
        if (ml != null) {
            hc.q("pver", ml.getContainerVersion());
        }
        BdLog.e(hc.toString());
        com.baidu.adp.lib.stats.a.hj().b("pluginproxy", hc);
        com.baidu.adp.lib.stats.a.hj().save();
    }

    public void lH() {
        if (this.Da.size() != 0) {
            d hc = hc();
            c(hc);
            com.baidu.adp.lib.stats.a.hj().b("pluginproxy", hc);
        }
    }

    public void bh(String str) {
        com.baidu.adp.lib.stats.a.hj().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void k(String str, int i) {
        com.baidu.adp.lib.stats.a.hj().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void I(String str, String str2) {
        com.baidu.adp.lib.stats.a.hj().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void a(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mo().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hj().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mo().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hj().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.hj().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.Da.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.Da.clear();
        }
    }

    private d hc() {
        return com.baidu.adp.lib.stats.a.hj().an("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lI() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
