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
    private static a Au = null;
    private final String Av = "c.tieba.baidu.com";
    private long Aw;
    private String Ax;
    private long Ay;

    public static final a iq() {
        if (Au == null) {
            synchronized (a.class) {
                if (Au == null) {
                    Au = new a();
                }
            }
        }
        return Au;
    }

    private a() {
        this.Aw = 0L;
        this.Ax = null;
        this.Ay = 0L;
        SharedPreferences config = getConfig();
        this.Aw = config.getLong(aK("c.tieba.baidu.com"), 0L);
        this.Ax = config.getString(aL("c.tieba.baidu.com"), null);
        this.Ay = config.getLong(aM("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.kK()) {
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
                    long j = this.Aw;
                    long j2 = this.Ay;
                    String str3 = this.Ax;
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
                            host2 = aJ(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.Ay = System.currentTimeMillis();
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
                str2 = aJ(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("host", str);
                statsItem.append("hostip", str2);
                statsItem.f("issuc", Boolean.valueOf(z));
                statsItem.f("isuseip", Boolean.valueOf(z2));
                Address d = com.baidu.adp.lib.d.a.iH().d(false, false);
                if (d != null) {
                    statsItem.f("lati", Double.valueOf(d.getLatitude()));
                    statsItem.f("longi", Double.valueOf(d.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, aK(str), currentTimeMillis);
                EditorHelper.putString(config, aL(str), str2);
                EditorHelper.putLong(config, aM(str), currentTimeMillis2);
                this.Aw = currentTimeMillis;
                this.Ay = currentTimeMillis2;
                this.Ax = str2;
            }
        }
    }

    private String aJ(String str) {
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

    private String aK(String str) {
        return str + "-lastLogTime";
    }

    private String aL(String str) {
        return str + "-lastIpAddress";
    }

    private String aM(String str) {
        return str + "-lastGetIpTime";
    }
}
