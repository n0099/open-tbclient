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
    private static a Kr = null;
    private final String Ks = "c.tieba.baidu.com";
    private long Kt;
    private String Ku;
    private long Kv;

    public static final a lX() {
        if (Kr == null) {
            synchronized (a.class) {
                if (Kr == null) {
                    Kr = new a();
                }
            }
        }
        return Kr;
    }

    private a() {
        this.Kt = 0L;
        this.Ku = null;
        this.Kv = 0L;
        SharedPreferences config = getConfig();
        this.Kt = config.getLong(bC("c.tieba.baidu.com"), 0L);
        this.Ku = config.getString(bD("c.tieba.baidu.com"), null);
        this.Kv = config.getLong(bE("c.tieba.baidu.com"), 0L);
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
                    long j = this.Kt;
                    long j2 = this.Kv;
                    String str3 = this.Ku;
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
                            host2 = bB(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.Kv = System.currentTimeMillis();
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
                str2 = bB(str);
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
                EditorHelper.putLong(config, bC(str), currentTimeMillis);
                EditorHelper.putString(config, bD(str), str2);
                EditorHelper.putLong(config, bE(str), currentTimeMillis2);
                this.Kt = currentTimeMillis;
                this.Kv = currentTimeMillis2;
                this.Ku = str2;
            }
        }
    }

    private String bB(String str) {
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

    private String bC(String str) {
        return str + "-lastLogTime";
    }

    private String bD(String str) {
        return str + "-lastIpAddress";
    }

    private String bE(String str) {
        return str + "-lastGetIpTime";
    }
}
