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
    private static volatile a It = null;
    private HashMap<String, Integer> Is = new HashMap<>();

    public static synchronized a lM() {
        a aVar;
        synchronized (a.class) {
            if (It == null) {
                synchronized (a.class) {
                    if (It == null) {
                        It = new a();
                    }
                }
            }
            aVar = It;
        }
        return aVar;
    }

    public void by(String str) {
        if (str != null) {
            Integer num = this.Is.get(str);
            if (num == null) {
                num = 0;
            }
            this.Is.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void A(String str, String str2) {
        if (str != null && str2 != null) {
            by(str);
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
        com.baidu.adp.lib.stats.a iw = iw();
        iw.append("workflow", str + "_cost");
        iw.c("cost", Long.valueOf(j));
        if (i != 0) {
            iw.c(Config.TRACE_VISIT_RECENT_COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            iw.append("pname", str2);
        }
        iw.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mD = c.mG().mD();
        if (mD != null) {
            iw.append("pver", mD.getContainerVersion());
        }
        iw.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", iw);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a iw = iw();
        if (str != null) {
            iw.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            iw.append("reason", str2);
        }
        if (str3 != null) {
            iw.append("pname", str3);
        }
        if (str4 != null) {
            iw.append(ClientCookie.COMMENT_ATTR, str4);
        }
        iw.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mD = c.mG().mD();
        if (mD != null) {
            iw.append("pver", mD.getContainerVersion());
        }
        iw.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(iw.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", iw);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a iw = iw();
        if (str != null) {
            iw.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            iw.append("reason", str2);
        }
        if (str3 != null) {
            iw.append("pname", str3);
        }
        c(iw);
        if (str4 != null) {
            iw.append(ClientCookie.COMMENT_ATTR, str4);
        }
        iw.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings mD = c.mG().mD();
        if (mD != null) {
            iw.append("pver", mD.getContainerVersion());
        }
        iw.append("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(iw.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", iw);
        BdStatisticsManager.getInstance().save();
    }

    public void lN() {
        if (this.Is.size() != 0) {
            com.baidu.adp.lib.stats.a iw = iw();
            c(iw);
            iw.append("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", iw);
        }
    }

    public void bz(String str) {
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
            pluginSetting = c.mG().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.mG().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, ClientCookie.COMMENT_ATTR, str4, "appver", BdStatisticsManager.getInstance().getAppVersion());
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.Is.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.Is.clear();
        }
    }

    private com.baidu.adp.lib.stats.a iw() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void ah(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean lO() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
