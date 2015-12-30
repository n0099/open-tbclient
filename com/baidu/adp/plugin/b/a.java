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
    private static volatile a DA = null;
    private HashMap<String, Integer> Dz = new HashMap<>();

    public static synchronized a lf() {
        a aVar;
        synchronized (a.class) {
            if (DA == null) {
                synchronized (a.class) {
                    if (DA == null) {
                        DA = new a();
                    }
                }
            }
            aVar = DA;
        }
        return aVar;
    }

    public void bn(String str) {
        if (str != null) {
            Integer num = this.Dz.get(str);
            if (num == null) {
                num = 0;
            }
            this.Dz.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void D(String str, String str2) {
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
        d he = he();
        he.q("workflow", String.valueOf(str) + "_cost");
        he.e("cost", Long.valueOf(j));
        if (i != 0) {
            he.e(ImageViewerConfig.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            he.q("pname", str2);
        }
        he.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lM = c.lP().lM();
        if (lM != null) {
            he.q("pver", lM.getContainerVersion());
        }
        com.baidu.adp.lib.stats.a.hl().b("pluginproxy", he);
    }

    public void d(String str, String str2, String str3, String str4) {
        d he = he();
        if (str != null) {
            he.q("workflow", String.valueOf(str) + "_debug");
        }
        if (str2 != null) {
            he.q("reason", str2);
        }
        if (str3 != null) {
            he.q("pname", str3);
        }
        if (str4 != null) {
            he.q("comment", str4);
        }
        he.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lM = c.lP().lM();
        if (lM != null) {
            he.q("pver", lM.getContainerVersion());
        }
        BdLog.e(he.toString());
        com.baidu.adp.lib.stats.a.hl().b("pluginproxy", he);
        com.baidu.adp.lib.stats.a.hl().save();
    }

    public void h(String str, String str2, String str3) {
        e(str, str2, str3, null);
    }

    public void e(String str, String str2, String str3, String str4) {
        d he = he();
        if (str != null) {
            he.q("workflow", String.valueOf(str) + "_failure");
        }
        if (str2 != null) {
            he.q("reason", str2);
        }
        if (str3 != null) {
            he.q("pname", str3);
        }
        c(he);
        if (str4 != null) {
            he.q("comment", str4);
        }
        he.e(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings lM = c.lP().lM();
        if (lM != null) {
            he.q("pver", lM.getContainerVersion());
        }
        BdLog.e(he.toString());
        com.baidu.adp.lib.stats.a.hl().b("pluginproxy", he);
        com.baidu.adp.lib.stats.a.hl().save();
    }

    public void lg() {
        if (this.Dz.size() != 0) {
            d he = he();
            c(he);
            com.baidu.adp.lib.stats.a.hl().b("pluginproxy", he);
        }
    }

    public void bo(String str) {
        com.baidu.adp.lib.stats.a.hl().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void k(String str, int i) {
        com.baidu.adp.lib.stats.a.hl().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void E(String str, String str2) {
        com.baidu.adp.lib.stats.a.hl().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.lP().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hl().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.lP().findPluginSetting(str2);
        }
        com.baidu.adp.lib.stats.a.hl().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, ImageViewerConfig.INDEX, Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a.hl().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, "comment", str4);
    }

    private void c(d dVar) {
        if (dVar != null) {
            for (Map.Entry<String, Integer> entry : this.Dz.entrySet()) {
                dVar.q(String.valueOf(entry.getKey()) + "_count", String.valueOf(entry.getValue()));
            }
            this.Dz.clear();
        }
    }

    private d he() {
        return com.baidu.adp.lib.stats.a.hl().ar("dbg");
    }

    public void I(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lh() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
