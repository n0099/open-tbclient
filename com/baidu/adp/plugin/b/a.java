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
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class a {
    private static volatile a IE = null;
    private HashMap<String, Integer> IC = new HashMap<>();

    public static synchronized a mc() {
        a aVar;
        synchronized (a.class) {
            if (IE == null) {
                synchronized (a.class) {
                    if (IE == null) {
                        IE = new a();
                    }
                }
            }
            aVar = IE;
        }
        return aVar;
    }

    public void bA(String str) {
        if (str != null) {
            Integer num = this.IC.get(str);
            if (num == null) {
                num = 0;
            }
            this.IC.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void A(String str, String str2) {
        if (str != null && str2 != null) {
            bA(str);
        }
    }

    public void g(String str, long j) {
        a(str, j, 0);
    }

    public void b(String str, long j, String str2) {
        b(str, j, 0, str2);
    }

    public void a(String str, long j, int i) {
        b(str, j, i, null);
    }

    public void b(String str, long j, int i, String str2) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append("workflow", str + "_cost");
        iF.c("cost", Long.valueOf(j));
        if (i != 0) {
            iF.c(Config.TRACE_VISIT_RECENT_COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            iF.append("pname", str2);
        }
        iF.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mT = c.mW().mT();
        if (mT != null) {
            iF.append("pver", mT.getContainerVersion());
        }
        iF.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", iF);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a iF = iF();
        if (str != null) {
            iF.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            iF.append("reason", str2);
        }
        if (str3 != null) {
            iF.append("pname", str3);
        }
        if (str4 != null) {
            iF.append(ClientCookie.COMMENT_ATTR, str4);
        }
        iF.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mT = c.mW().mT();
        if (mT != null) {
            iF.append("pver", mT.getContainerVersion());
        }
        iF.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(iF.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", iF);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a iF = iF();
        if (str != null) {
            iF.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            iF.append("reason", str2);
        }
        if (str3 != null) {
            iF.append("pname", str3);
        }
        c(iF);
        if (str4 != null) {
            iF.append(ClientCookie.COMMENT_ATTR, str4);
        }
        iF.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mT = c.mW().mT();
        if (mT != null) {
            iF.append("pver", mT.getContainerVersion());
        }
        iF.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(iF.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", iF);
        BdStatisticsManager.getInstance().save();
    }

    public void md() {
        if (this.IC.size() != 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            c(iF);
            iF.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", iF);
        }
    }

    public void bB(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void l(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void B(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.mW().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mW().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, ClientCookie.COMMENT_ATTR, str4, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.IC.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.IC.clear();
        }
    }

    private com.baidu.adp.lib.stats.a iF() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void aj(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean me() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
