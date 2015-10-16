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
    private static volatile a Da = null;
    private HashMap<String, Integer> CZ = new HashMap<>();

    public static synchronized a lF() {
        a aVar;
        synchronized (a.class) {
            if (Da == null) {
                synchronized (a.class) {
                    if (Da == null) {
                        Da = new a();
                    }
                }
            }
            aVar = Da;
        }
        return aVar;
    }

    public void bi(String str) {
        if (str != null) {
            Integer num = this.CZ.get(str);
            if (num == null) {
                num = 0;
            }
            this.CZ.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void H(String str, String str2) {
        if (str != null && str2 != null) {
            bi(str);
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
        d hb = hb();
        hb.q("workflow", String.valueOf(str) + "_cost");
        hb.e("cost", Long.valueOf(j));
        if (i != 0) {
            hb.e(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            hb.q("pname", str2);
        }
        hb.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mk = c.mn().mk();
        if (mk != null) {
            hb.q("pver", mk.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.hi().b("pluginproxy", hb);
    }

    public void d(String str, String str2, String str3, String str4) {
        d hb = hb();
        if (str != null) {
            hb.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            hb.q("reason", str2);
        }
        if (str3 != null) {
            hb.q("pname", str3);
        }
        if (str4 != null) {
            hb.q("comment", str4);
        }
        hb.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mk = c.mn().mk();
        if (mk != null) {
            hb.q("pver", mk.getContainerVersion());
        }
        BdLog.e(hb.toString());
        com.baidu.adp.lib.stats.a.hi().b("pluginproxy", hb);
        com.baidu.adp.lib.stats.a.hi().save();
    }

    public void g(String str, String str2, String str3) {
        e(str, str2, str3, null);
    }

    public void e(String str, String str2, String str3, String str4) {
        d hb = hb();
        if (str != null) {
            hb.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            hb.q("reason", str2);
        }
        if (str3 != null) {
            hb.q("pname", str3);
        }
        c(hb);
        if (str4 != null) {
            hb.q("comment", str4);
        }
        hb.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mk = c.mn().mk();
        if (mk != null) {
            hb.q("pver", mk.getContainerVersion());
        }
        BdLog.e(hb.toString());
        com.baidu.adp.lib.stats.a.hi().b("pluginproxy", hb);
        com.baidu.adp.lib.stats.a.hi().save();
    }

    public void lG() {
        if (this.CZ.size() != 0) {
            d hb = hb();
            c(hb);
            com.baidu.adp.lib.stats.a.hi().b("pluginproxy", hb);
        }
    }

    public void bj(String str) {
        com.baidu.adp.lib.stats.a.hi().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void k(String str, int i) {
        com.baidu.adp.lib.stats.a.hi().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void I(String str, String str2) {
        com.baidu.adp.lib.stats.a.hi().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void a(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mn().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hi().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mn().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hi().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.hi().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.CZ.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.CZ.clear();
        }
    }

    private d hb() {
        return com.baidu.adp.lib.stats.a.hi().ap("dbg");
    }

    public void M(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lH() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
