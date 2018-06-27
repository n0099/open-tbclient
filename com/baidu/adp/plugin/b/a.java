package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class a {
    private static volatile a HD = null;
    private HashMap<String, Integer> HC = new HashMap<>();

    public static synchronized a ly() {
        a aVar;
        synchronized (a.class) {
            if (HD == null) {
                synchronized (a.class) {
                    if (HD == null) {
                        HD = new a();
                    }
                }
            }
            aVar = HD;
        }
        return aVar;
    }

    public void bx(String str) {
        if (str != null) {
            Integer num = this.HC.get(str);
            if (num == null) {
                num = 0;
            }
            this.HC.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void B(String str, String str2) {
        if (str != null && str2 != null) {
            bx(str);
        }
    }

    public void e(String str, long j) {
        b(str, j, 0);
    }

    public void a(String str, long j, String str2) {
        a(str, j, 0, str2);
    }

    public void b(String str, long j, int i) {
        a(str, j, i, (String) null);
    }

    public void a(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append("workflow", str + "_cost");
        ih.f("cost", Long.valueOf(j));
        if (i != 0) {
            ih.f("count", Integer.valueOf(i));
        }
        if (str2 != null) {
            ih.append("pname", str2);
        }
        ih.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mk = c.mn().mk();
        if (mk != null) {
            ih.append("pver", mk.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", ih);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a ih = ih();
        if (str != null) {
            ih.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            ih.append("reason", str2);
        }
        if (str3 != null) {
            ih.append("pname", str3);
        }
        if (str4 != null) {
            ih.append(ClientCookie.COMMENT_ATTR, str4);
        }
        ih.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mk = c.mn().mk();
        if (mk != null) {
            ih.append("pver", mk.getContainerVersion());
        }
        BdLog.e(ih.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", ih);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a ih = ih();
        if (str != null) {
            ih.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            ih.append("reason", str2);
        }
        if (str3 != null) {
            ih.append("pname", str3);
        }
        c(ih);
        if (str4 != null) {
            ih.append(ClientCookie.COMMENT_ATTR, str4);
        }
        ih.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mk = c.mn().mk();
        if (mk != null) {
            ih.append("pver", mk.getContainerVersion());
        }
        BdLog.e(ih.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", ih);
        BdStatisticsManager.getInstance().save();
    }

    public void lz() {
        if (this.HC.size() != 0) {
            com.baidu.adp.lib.stats.a ih = ih();
            c(ih);
            BdStatisticsManager.getInstance().debug("pluginproxy", ih);
        }
    }

    public void by(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void m(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void C(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mn().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mn().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, ClientCookie.COMMENT_ATTR, str4);
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.HC.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.HC.clear();
        }
    }

    private com.baidu.adp.lib.stats.a ih() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void S(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lA() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
