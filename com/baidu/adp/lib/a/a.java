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
    private static a ya = null;
    private final String yb = "c.tieba.baidu.com";
    private long yc;
    private String yd;
    private long ye;

    public static final a hk() {
        if (ya == null) {
            synchronized (a.class) {
                if (ya == null) {
                    ya = new a();
                }
            }
        }
        return ya;
    }

    private a() {
        this.yc = 0L;
        this.yd = null;
        this.ye = 0L;
        SharedPreferences config = getConfig();
        this.yc = config.getLong(at("c.tieba.baidu.com"), 0L);
        this.yd = config.getString(au("c.tieba.baidu.com"), null);
        this.ye = config.getLong(av("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.jE()) {
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
                    long j = this.yc;
                    long j2 = this.ye;
                    String str3 = this.yd;
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
                            host2 = as(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.ye = System.currentTimeMillis();
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
                str2 = as(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("host", str);
                statsItem.append("hostip", str2);
                statsItem.f("issuc", Boolean.valueOf(z));
                statsItem.f("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.hB().b(false, false);
                if (b != null) {
                    statsItem.f("lati", Double.valueOf(b.getLatitude()));
                    statsItem.f("longi", Double.valueOf(b.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, at(str), currentTimeMillis);
                EditorHelper.putString(config, au(str), str2);
                EditorHelper.putLong(config, av(str), currentTimeMillis2);
                this.yc = currentTimeMillis;
                this.ye = currentTimeMillis2;
                this.yd = str2;
            }
        }
    }

    private String as(String str) {
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

    private String at(String str) {
        return str + "-lastLogTime";
    }

    private String au(String str) {
        return str + "-lastIpAddress";
    }

    private String av(String str) {
        return str + "-lastGetIpTime";
    }
}
