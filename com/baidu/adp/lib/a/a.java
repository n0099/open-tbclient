package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.compatible.EditorHelper;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private static a yO = null;
    private final String yP = "c.tieba.baidu.com";
    private long yQ;
    private String yR;
    private long yS;

    public static final a hx() {
        if (yO == null) {
            synchronized (a.class) {
                if (yO == null) {
                    yO = new a();
                }
            }
        }
        return yO;
    }

    private a() {
        this.yQ = 0L;
        this.yR = null;
        this.yS = 0L;
        SharedPreferences config = getConfig();
        this.yQ = config.getLong(au("c.tieba.baidu.com"), 0L);
        this.yR = config.getString(av("c.tieba.baidu.com"), null);
        this.yS = config.getLong(aw("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.jS()) {
            try {
                URL url = new URL(str);
                String host2 = url.getHost();
                if ("c.tieba.baidu.com".equals(host2) || TextUtils.isEmpty(str2)) {
                    host = url.getHost();
                    host2 = null;
                } else {
                    host = str2;
                }
                if ("c.tieba.baidu.com".equals(host)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.yQ;
                    long j2 = this.yS;
                    String str3 = this.yR;
                    if (currentTimeMillis - j > 43200000) {
                        a(host, host2, z, "12hour", z2);
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(currentTimeMillis);
                    int i = calendar.get(6);
                    calendar.setTimeInMillis(j);
                    if (i != calendar.get(6)) {
                        a(host, host2, z, "newday", z2);
                    } else if (System.currentTimeMillis() - j2 > 3600000) {
                        if (TextUtils.isEmpty(host2)) {
                            host2 = at(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.yS = System.currentTimeMillis();
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void a(String str, String str2, boolean z, String str3, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                str2 = at(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("host", str);
                statsItem.append("hostip", str2);
                statsItem.c("issuc", Boolean.valueOf(z));
                statsItem.c("isuseip", Boolean.valueOf(z2));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, au(str), currentTimeMillis);
                EditorHelper.putString(config, av(str), str2);
                EditorHelper.putLong(config, aw(str), currentTimeMillis2);
                this.yQ = currentTimeMillis;
                this.yS = currentTimeMillis2;
                this.yR = str2;
            }
        }
    }

    private String at(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private SharedPreferences getConfig() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    private String au(String str) {
        return str + "-lastLogTime";
    }

    private String av(String str) {
        return str + "-lastIpAddress";
    }

    private String aw(String str) {
        return str + "-lastGetIpTime";
    }
}
