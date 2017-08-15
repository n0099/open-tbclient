package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.i;
import com.baidu.tieba.compatible.EditorHelper;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private static a vD = null;
    private final String vE = "c.tieba.baidu.com";
    private long vF;
    private String vG;
    private long vH;

    public static final a eX() {
        if (vD == null) {
            synchronized (a.class) {
                if (vD == null) {
                    vD = new a();
                }
            }
        }
        return vD;
    }

    private a() {
        this.vF = 0L;
        this.vG = null;
        this.vH = 0L;
        SharedPreferences config = getConfig();
        this.vF = config.getLong(ah("c.tieba.baidu.com"), 0L);
        this.vG = config.getString(ai("c.tieba.baidu.com"), null);
        this.vH = config.getLong(aj("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.hr()) {
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
                    long j = this.vF;
                    long j2 = this.vH;
                    String str3 = this.vG;
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
                            host2 = ag(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.vH = System.currentTimeMillis();
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
                str2 = ag(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("host", str);
                statsItem.p("hostip", str2);
                statsItem.d("issuc", Boolean.valueOf(z));
                statsItem.d("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.fo().b(false, false);
                if (b != null) {
                    statsItem.d("lati", Double.valueOf(b.getLatitude()));
                    statsItem.d("longi", Double.valueOf(b.getLongitude()));
                }
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, ah(str), currentTimeMillis);
                EditorHelper.putString(config, ai(str), str2);
                EditorHelper.putLong(config, aj(str), currentTimeMillis2);
                this.vF = currentTimeMillis;
                this.vH = currentTimeMillis2;
                this.vG = str2;
            }
        }
    }

    private String ag(String str) {
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

    private String ah(String str) {
        return str + "-lastLogTime";
    }

    private String ai(String str) {
        return str + "-lastIpAddress";
    }

    private String aj(String str) {
        return str + "-lastGetIpTime";
    }
}
