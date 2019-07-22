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
    private static a yU = null;
    private final String yV = "c.tieba.baidu.com";
    private long yW;
    private String yX;
    private long yY;

    public static final a hH() {
        if (yU == null) {
            synchronized (a.class) {
                if (yU == null) {
                    yU = new a();
                }
            }
        }
        return yU;
    }

    private a() {
        this.yW = 0L;
        this.yX = null;
        this.yY = 0L;
        SharedPreferences config = getConfig();
        this.yW = config.getLong(av("c.tieba.baidu.com"), 0L);
        this.yX = config.getString(aw("c.tieba.baidu.com"), null);
        this.yY = config.getLong(ax("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.kc()) {
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
                    long j = this.yW;
                    long j2 = this.yY;
                    String str3 = this.yX;
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
                            host2 = au(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.yY = System.currentTimeMillis();
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
                str2 = au(str);
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
                EditorHelper.putLong(config, av(str), currentTimeMillis);
                EditorHelper.putString(config, aw(str), str2);
                EditorHelper.putLong(config, ax(str), currentTimeMillis2);
                this.yW = currentTimeMillis;
                this.yY = currentTimeMillis2;
                this.yX = str2;
            }
        }
    }

    private String au(String str) {
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

    private String av(String str) {
        return str + "-lastLogTime";
    }

    private String aw(String str) {
        return str + "-lastIpAddress";
    }

    private String ax(String str) {
        return str + "-lastGetIpTime";
    }
}
