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
    private static a ahI = null;
    private final String ahJ = "c.tieba.baidu.com";
    private long ahK;
    private String ahL;
    private long ahM;

    public static final a mp() {
        if (ahI == null) {
            synchronized (a.class) {
                if (ahI == null) {
                    ahI = new a();
                }
            }
        }
        return ahI;
    }

    private a() {
        this.ahK = 0L;
        this.ahL = null;
        this.ahM = 0L;
        SharedPreferences config = getConfig();
        this.ahK = config.getLong(aj("c.tieba.baidu.com"), 0L);
        this.ahL = config.getString(ak("c.tieba.baidu.com"), null);
        this.ahM = config.getLong(al("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.oI()) {
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
                    long j = this.ahK;
                    long j2 = this.ahM;
                    String str3 = this.ahL;
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
                            host2 = ai(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.ahM = System.currentTimeMillis();
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
                str2 = ai(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("host", str);
                statsItem.append("hostip", str2);
                statsItem.h("issuc", Boolean.valueOf(z));
                statsItem.h("isuseip", Boolean.valueOf(z2));
                Address e = com.baidu.adp.lib.d.a.mF().e(false, false);
                if (e != null) {
                    statsItem.h("lati", Double.valueOf(e.getLatitude()));
                    statsItem.h("longi", Double.valueOf(e.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, aj(str), currentTimeMillis);
                EditorHelper.putString(config, ak(str), str2);
                EditorHelper.putLong(config, al(str), currentTimeMillis2);
                this.ahK = currentTimeMillis;
                this.ahM = currentTimeMillis2;
                this.ahL = str2;
            }
        }
    }

    private String ai(String str) {
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

    private String aj(String str) {
        return str + "-lastLogTime";
    }

    private String ak(String str) {
        return str + "-lastIpAddress";
    }

    private String al(String str) {
        return str + "-lastGetIpTime";
    }
}
