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
    private static a rV = null;
    private final String rW = "c.tieba.baidu.com";
    private long rX;
    private String rY;
    private long rZ;

    public static final a eu() {
        if (rV == null) {
            synchronized (a.class) {
                if (rV == null) {
                    rV = new a();
                }
            }
        }
        return rV;
    }

    private a() {
        this.rX = 0L;
        this.rY = null;
        this.rZ = 0L;
        SharedPreferences config = getConfig();
        this.rX = config.getLong(ag("c.tieba.baidu.com"), 0L);
        this.rY = config.getString(ah("c.tieba.baidu.com"), null);
        this.rZ = config.getLong(ai("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.gP()) {
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
                    long j = this.rX;
                    long j2 = this.rZ;
                    String str3 = this.rY;
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
                            host2 = af(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            b(host, host2, z, "ipchange", z2);
                        } else {
                            this.rZ = System.currentTimeMillis();
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
                str2 = af(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("host", str);
                statsItem.append("hostip", str2);
                statsItem.f("issuc", Boolean.valueOf(z));
                statsItem.f("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.eK().b(false, false);
                if (b != null) {
                    statsItem.f("lati", Double.valueOf(b.getLatitude()));
                    statsItem.f("longi", Double.valueOf(b.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, ag(str), currentTimeMillis);
                EditorHelper.putString(config, ah(str), str2);
                EditorHelper.putLong(config, ai(str), currentTimeMillis2);
                this.rX = currentTimeMillis;
                this.rZ = currentTimeMillis2;
                this.rY = str2;
            }
        }
    }

    private String af(String str) {
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

    private String ag(String str) {
        return str + "-lastLogTime";
    }

    private String ah(String str) {
        return str + "-lastIpAddress";
    }

    private String ai(String str) {
        return str + "-lastGetIpTime";
    }
}
