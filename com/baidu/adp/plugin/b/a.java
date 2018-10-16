package com.baidu.adp.plugin.b;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.appsearchlib.Info;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class a {
    private static volatile a Kw = null;
    private HashMap<String, Integer> Kv = new HashMap<>();

    public static synchronized a mQ() {
        a aVar;
        synchronized (a.class) {
            if (Kw == null) {
                synchronized (a.class) {
                    if (Kw == null) {
                        Kw = new a();
                    }
                }
            }
            aVar = Kw;
        }
        return aVar;
    }

    public void bO(String str) {
        if (str != null) {
            Integer num = this.Kv.get(str);
            if (num == null) {
                num = 0;
            }
            this.Kv.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void H(String str, String str2) {
        if (str != null && str2 != null) {
            bO(str);
        }
    }

    public void f(String str, long j) {
        a(str, j, 0);
    }

    public void a(String str, long j, String str2) {
        a(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        a(str, j, i, (String) null);
    }

    public void a(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a jD = jD();
        jD.append("workflow", str + "_cost");
        jD.f("cost", Long.valueOf(j));
        if (i != 0) {
            jD.f(Config.TRACE_VISIT_RECENT_COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            jD.append("pname", str2);
        }
        jD.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings nC = c.nF().nC();
        if (nC != null) {
            jD.append("pver", nC.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", jD);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a jD = jD();
        if (str != null) {
            jD.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            jD.append(WebSocketAction.PARAM_KEY_REASON, str2);
        }
        if (str3 != null) {
            jD.append("pname", str3);
        }
        if (str4 != null) {
            jD.append(ClientCookie.COMMENT_ATTR, str4);
        }
        jD.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings nC = c.nF().nC();
        if (nC != null) {
            jD.append("pver", nC.getContainerVersion());
        }
        BdLog.e(jD.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", jD);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a jD = jD();
        if (str != null) {
            jD.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            jD.append(WebSocketAction.PARAM_KEY_REASON, str2);
        }
        if (str3 != null) {
            jD.append("pname", str3);
        }
        c(jD);
        if (str4 != null) {
            jD.append(ClientCookie.COMMENT_ATTR, str4);
        }
        jD.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings nC = c.nF().nC();
        if (nC != null) {
            jD.append("pver", nC.getContainerVersion());
        }
        BdLog.e(jD.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", jD);
        BdStatisticsManager.getInstance().save();
    }

    public void mR() {
        if (this.Kv.size() != 0) {
            com.baidu.adp.lib.stats.a jD = jD();
            c(jD);
            BdStatisticsManager.getInstance().debug("pluginproxy", jD);
        }
    }

    public void bP(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void r(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void I(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.nF().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.nF().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), WebSocketAction.PARAM_KEY_REASON, str3);
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, WebSocketAction.PARAM_KEY_REASON, str3, ClientCookie.COMMENT_ATTR, str4);
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.Kv.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.Kv.clear();
        }
    }

    private com.baidu.adp.lib.stats.a jD() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void aa(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean mS() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
