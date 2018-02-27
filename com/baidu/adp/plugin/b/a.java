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
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqP = null;
    private HashMap<String, Integer> aqO = new HashMap<>();

    public static synchronized a qF() {
        a aVar;
        synchronized (a.class) {
            if (aqP == null) {
                synchronized (a.class) {
                    if (aqP == null) {
                        aqP = new a();
                    }
                }
            }
            aVar = aqP;
        }
        return aVar;
    }

    public void bm(String str) {
        if (str != null) {
            Integer num = this.aqO.get(str);
            if (num == null) {
                num = 0;
            }
            this.aqO.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void z(String str, String str2) {
        if (str != null && str2 != null) {
            bm(str);
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
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append("workflow", str + "_cost");
        nn.h("cost", Long.valueOf(j));
        if (i != 0) {
            nn.h(WBPageConstants.ParamKey.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            nn.append("pname", str2);
        }
        nn.h(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings rr = c.ru().rr();
        if (rr != null) {
            nn.append("pver", rr.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", nn);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a nn = nn();
        if (str != null) {
            nn.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            nn.append("reason", str2);
        }
        if (str3 != null) {
            nn.append("pname", str3);
        }
        if (str4 != null) {
            nn.append(ClientCookie.COMMENT_ATTR, str4);
        }
        nn.h(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings rr = c.ru().rr();
        if (rr != null) {
            nn.append("pver", rr.getContainerVersion());
        }
        BdLog.e(nn.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", nn);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a nn = nn();
        if (str != null) {
            nn.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            nn.append("reason", str2);
        }
        if (str3 != null) {
            nn.append("pname", str3);
        }
        c(nn);
        if (str4 != null) {
            nn.append(ClientCookie.COMMENT_ATTR, str4);
        }
        nn.h(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings rr = c.ru().rr();
        if (rr != null) {
            nn.append("pver", rr.getContainerVersion());
        }
        BdLog.e(nn.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", nn);
        BdStatisticsManager.getInstance().save();
    }

    public void qG() {
        if (this.aqO.size() != 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            c(nn);
            BdStatisticsManager.getInstance().debug("pluginproxy", nn);
        }
    }

    public void bn(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void n(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void A(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.ru().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.ru().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, ClientCookie.COMMENT_ATTR, str4);
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.aqO.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.aqO.clear();
        }
    }

    private com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void ax(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean qH() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
