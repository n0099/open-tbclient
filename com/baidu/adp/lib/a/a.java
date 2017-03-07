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
    private static a uv = null;
    private final String uw = "c.tieba.baidu.com";
    private long ux;
    private String uy;
    private long uz;

    public static final a eP() {
        if (uv == null) {
            synchronized (a.class) {
                if (uv == null) {
                    uv = new a();
                }
            }
        }
        return uv;
    }

    private a() {
        this.ux = 0L;
        this.uy = null;
        this.uz = 0L;
        SharedPreferences config = getConfig();
        this.ux = config.getLong(X("c.tieba.baidu.com"), 0L);
        this.uy = config.getString(Y("c.tieba.baidu.com"), null);
        this.uz = config.getLong(Z("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.he()) {
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
                    long j = this.ux;
                    long j2 = this.uz;
                    String str3 = this.uy;
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
                            host2 = W(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.uz = System.currentTimeMillis();
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
                str2 = W(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                c statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("host", str);
                statsItem.p("hostip", str2);
                statsItem.d("issuc", Boolean.valueOf(z));
                statsItem.d("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.fa().b(false, false);
                if (b != null) {
                    statsItem.d("lati", Double.valueOf(b.getLatitude()));
                    statsItem.d("longi", Double.valueOf(b.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, X(str), currentTimeMillis);
                EditorHelper.putString(config, Y(str), str2);
                EditorHelper.putLong(config, Z(str), currentTimeMillis2);
                this.ux = currentTimeMillis;
                this.uz = currentTimeMillis2;
                this.uy = str2;
            }
        }
    }

    private String W(String str) {
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

    private String X(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String Y(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String Z(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
