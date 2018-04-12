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
    private static volatile a Bu = null;
    private HashMap<String, Integer> Bt = new HashMap<>();

    public static synchronized a iK() {
        a aVar;
        synchronized (a.class) {
            if (Bu == null) {
                synchronized (a.class) {
                    if (Bu == null) {
                        Bu = new a();
                    }
                }
            }
            aVar = Bu;
        }
        return aVar;
    }

    public void bj(String str) {
        if (str != null) {
            Integer num = this.Bt.get(str);
            if (num == null) {
                num = 0;
            }
            this.Bt.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void A(String str, String str2) {
        if (str != null && str2 != null) {
            bj(str);
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
        com.baidu.adp.lib.stats.a fq = fq();
        fq.append("workflow", str + "_cost");
        fq.f("cost", Long.valueOf(j));
        if (i != 0) {
            fq.f(WBPageConstants.ParamKey.COUNT, Integer.valueOf(i));
        }
        if (str2 != null) {
            fq.append("pname", str2);
        }
        fq.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jw = c.jz().jw();
        if (jw != null) {
            fq.append("pver", jw.getContainerVersion());
        }
        BdStatisticsManager.getInstance().debug("pluginproxy", fq);
    }

    public void f(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fq = fq();
        if (str != null) {
            fq.append("workflow", str + "_debug");
        }
        if (str2 != null) {
            fq.append("reason", str2);
        }
        if (str3 != null) {
            fq.append("pname", str3);
        }
        if (str4 != null) {
            fq.append(ClientCookie.COMMENT_ATTR, str4);
        }
        fq.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jw = c.jz().jw();
        if (jw != null) {
            fq.append("pver", jw.getContainerVersion());
        }
        BdLog.e(fq.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fq);
        BdStatisticsManager.getInstance().save();
    }

    public void g(String str, String str2, String str3) {
        g(str, str2, str3, null);
    }

    public void g(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fq = fq();
        if (str != null) {
            fq.append("workflow", str + "_failure");
        }
        if (str2 != null) {
            fq.append("reason", str2);
        }
        if (str3 != null) {
            fq.append("pname", str3);
        }
        c(fq);
        if (str4 != null) {
            fq.append(ClientCookie.COMMENT_ATTR, str4);
        }
        fq.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
        PluginSettings jw = c.jz().jw();
        if (jw != null) {
            fq.append("pver", jw.getContainerVersion());
        }
        BdLog.e(fq.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", fq);
        BdStatisticsManager.getInstance().save();
    }

    public void iL() {
        if (this.Bt.size() != 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            c(fq);
            BdStatisticsManager.getInstance().debug("pluginproxy", fq);
        }
    }

    public void bk(String str) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, new Object[0]);
    }

    public void m(String str, int i) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, i, new Object[0]);
    }

    public void B(String str, String str2) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2);
    }

    public void e(String str, String str2, PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            pluginSetting = c.jz().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0));
    }

    public void a(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = c.jz().findPluginSetting(str2);
        }
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "index", Integer.valueOf(pluginSetting != null ? pluginSetting.install_fail_count : 0), "reason", str3);
    }

    public void h(String str, String str2, String str3, String str4) {
        BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), str, null, 1, "pname", str2, "reason", str3, ClientCookie.COMMENT_ATTR, str4);
    }

    private void c(com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            for (Map.Entry<String, Integer> entry : this.Bt.entrySet()) {
                aVar.append(entry.getKey() + "_count", String.valueOf(entry.getValue()));
            }
            this.Bt.clear();
        }
    }

    private com.baidu.adp.lib.stats.a fq() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void Q(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public boolean iM() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }
}
