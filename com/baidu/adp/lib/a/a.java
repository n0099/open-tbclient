package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.compatible.EditorHelper;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private static a Ja = null;
    private final String Jb = "c.tieba.baidu.com";
    private long Jc;
    private String Je;
    private long Jf;

    public static final a kg() {
        if (Ja == null) {
            synchronized (a.class) {
                if (Ja == null) {
                    Ja = new a();
                }
            }
        }
        return Ja;
    }

    private a() {
        this.Jc = 0L;
        this.Je = null;
        this.Jf = 0L;
        SharedPreferences config = getConfig();
        this.Jc = config.getLong(bv("c.tieba.baidu.com"), 0L);
        this.Je = config.getString(bw("c.tieba.baidu.com"), null);
        this.Jf = config.getLong(bx("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.isNetWorkAvailable()) {
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
                    long j = this.Jc;
                    long j2 = this.Jf;
                    String str3 = this.Je;
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
                    } else if (System.currentTimeMillis() - j2 > BdKVCache.MILLS_1Hour) {
                        if (TextUtils.isEmpty(host2)) {
                            host2 = bu(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.Jf = System.currentTimeMillis();
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
                str2 = bu(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("host", str);
                statsItem.append("hostip", str2);
                statsItem.append("issuc", Boolean.valueOf(z));
                statsItem.append("isuseip", Boolean.valueOf(z2));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, bv(str), currentTimeMillis);
                EditorHelper.putString(config, bw(str), str2);
                EditorHelper.putLong(config, bx(str), currentTimeMillis2);
                this.Jc = currentTimeMillis;
                this.Jf = currentTimeMillis2;
                this.Je = str2;
            }
        }
    }

    private String bu(String str) {
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

    private String bv(String str) {
        return str + "-lastLogTime";
    }

    private String bw(String str) {
        return str + "-lastIpAddress";
    }

    private String bx(String str) {
        return str + "-lastGetIpTime";
    }
}
