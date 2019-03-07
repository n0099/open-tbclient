package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
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
    private static a Bh = null;
    private final String Bi = "c.tieba.baidu.com";
    private long Bj;
    private String Bk;
    private long Bl;

    public static final a iF() {
        if (Bh == null) {
            synchronized (a.class) {
                if (Bh == null) {
                    Bh = new a();
                }
            }
        }
        return Bh;
    }

    private a() {
        this.Bj = 0L;
        this.Bk = null;
        this.Bl = 0L;
        SharedPreferences config = getConfig();
        this.Bj = config.getLong(aK("c.tieba.baidu.com"), 0L);
        this.Bk = config.getString(aL("c.tieba.baidu.com"), null);
        this.Bl = config.getLong(aM("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && j.kY()) {
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
                    long j = this.Bj;
                    long j2 = this.Bl;
                    String str3 = this.Bk;
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
                            this.Bl = System.currentTimeMillis();
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
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                SharedPreferences config = getConfig();
                EditorHelper.putLong(config, aK(str), currentTimeMillis);
                EditorHelper.putString(config, aL(str), str2);
                EditorHelper.putLong(config, aM(str), currentTimeMillis2);
                this.Bj = currentTimeMillis;
                this.Bl = currentTimeMillis2;
                this.Bk = str2;
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
