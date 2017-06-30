package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.c;
import com.baidu.adp.lib.util.i;
import com.baidu.tieba.compatible.EditorHelper;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private static a tW = null;
    private final String tX = "c.tieba.baidu.com";
    private long tY;
    private String tZ;
    private long ub;

    public static final a eO() {
        if (tW == null) {
            synchronized (a.class) {
                if (tW == null) {
                    tW = new a();
                }
            }
        }
        return tW;
    }

    private a() {
        this.tY = 0L;
        this.tZ = null;
        this.ub = 0L;
        SharedPreferences config = getConfig();
        this.tY = config.getLong(Z("c.tieba.baidu.com"), 0L);
        this.tZ = config.getString(aa("c.tieba.baidu.com"), null);
        this.ub = config.getLong(ab("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.hj()) {
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
                    long j = this.tY;
                    long j2 = this.ub;
                    String str3 = this.tZ;
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
                            host2 = Y(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.ub = System.currentTimeMillis();
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
                str2 = Y(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                c statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("host", str);
                statsItem.p("hostip", str2);
                statsItem.d("issuc", Boolean.valueOf(z));
                statsItem.d("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.ff().b(false, false);
                if (b != null) {
                    statsItem.d("lati", Double.valueOf(b.getLatitude()));
                    statsItem.d("longi", Double.valueOf(b.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, Z(str), currentTimeMillis);
                EditorHelper.putString(config, aa(str), str2);
                EditorHelper.putLong(config, ab(str), currentTimeMillis2);
                this.tY = currentTimeMillis;
                this.ub = currentTimeMillis2;
                this.tZ = str2;
            }
        }
    }

    private String Y(String str) {
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

    private String Z(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String aa(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String ab(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
