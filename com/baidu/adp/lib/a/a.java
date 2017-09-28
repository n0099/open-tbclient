package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import android.location.Address;
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
    private static a ts = null;
    private final String tt = "c.tieba.baidu.com";
    private long tu;

    /* renamed from: tv  reason: collision with root package name */
    private String f0tv;
    private long tw;

    public static final a eL() {
        if (ts == null) {
            synchronized (a.class) {
                if (ts == null) {
                    ts = new a();
                }
            }
        }
        return ts;
    }

    private a() {
        this.tu = 0L;
        this.f0tv = null;
        this.tw = 0L;
        SharedPreferences config = getConfig();
        this.tu = config.getLong(ab("c.tieba.baidu.com"), 0L);
        this.f0tv = config.getString(ac("c.tieba.baidu.com"), null);
        this.tw = config.getLong(ad("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.hh()) {
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
                    long j = this.tu;
                    long j2 = this.tw;
                    String str3 = this.f0tv;
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
                            host2 = aa(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.tw = System.currentTimeMillis();
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
                str2 = aa(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("host", str);
                statsItem.p("hostip", str2);
                statsItem.c("issuc", Boolean.valueOf(z));
                statsItem.c("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.fc().b(false, false);
                if (b != null) {
                    statsItem.c("lati", Double.valueOf(b.getLatitude()));
                    statsItem.c("longi", Double.valueOf(b.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, ab(str), currentTimeMillis);
                EditorHelper.putString(config, ac(str), str2);
                EditorHelper.putLong(config, ad(str), currentTimeMillis2);
                this.tu = currentTimeMillis;
                this.tw = currentTimeMillis2;
                this.f0tv = str2;
            }
        }
    }

    private String aa(String str) {
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

    private String ab(String str) {
        return str + "-lastLogTime";
    }

    private String ac(String str) {
        return str + "-lastIpAddress";
    }

    private String ad(String str) {
        return str + "-lastGetIpTime";
    }
}
