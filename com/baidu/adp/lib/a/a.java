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
    private static a yg = null;
    private final String yh = "c.tieba.baidu.com";
    private long yi;
    private String yj;
    private long yk;

    public static final a hl() {
        if (yg == null) {
            synchronized (a.class) {
                if (yg == null) {
                    yg = new a();
                }
            }
        }
        return yg;
    }

    private a() {
        this.yi = 0L;
        this.yj = null;
        this.yk = 0L;
        SharedPreferences config = getConfig();
        this.yi = config.getLong(as("c.tieba.baidu.com"), 0L);
        this.yj = config.getString(at("c.tieba.baidu.com"), null);
        this.yk = config.getLong(au("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.jD()) {
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
                    long j = this.yi;
                    long j2 = this.yk;
                    String str3 = this.yj;
                    if (currentTimeMillis - j > 43200000) {
                        b(host, host2, z, "12hour", z2);
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(currentTimeMillis);
                    int i = calendar.get(6);
                    calendar.setTimeInMillis(j);
                    if (i != calendar.get(6)) {
                        b(host, host2, z, "newday", z2);
                    } else if (System.currentTimeMillis() - j2 > 3600000) {
                        if (TextUtils.isEmpty(host2)) {
                            host2 = ar(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            b(host, host2, z, "ipchange", z2);
                        } else {
                            this.yk = System.currentTimeMillis();
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void b(String str, String str2, boolean z, String str3, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                str2 = ar(str);
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
                EditorHelper.putLong(config, as(str), currentTimeMillis);
                EditorHelper.putString(config, at(str), str2);
                EditorHelper.putLong(config, au(str), currentTimeMillis2);
                this.yi = currentTimeMillis;
                this.yk = currentTimeMillis2;
                this.yj = str2;
            }
        }
    }

    private String ar(String str) {
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

    private String as(String str) {
        return str + "-lastLogTime";
    }

    private String at(String str) {
        return str + "-lastIpAddress";
    }

    private String au(String str) {
        return str + "-lastGetIpTime";
    }
}
