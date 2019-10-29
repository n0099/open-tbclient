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
    private static a nZ = null;
    private final String oa = "c.tieba.baidu.com";
    private long ob;
    private String oc;
    private long od;

    public static final a fh() {
        if (nZ == null) {
            synchronized (a.class) {
                if (nZ == null) {
                    nZ = new a();
                }
            }
        }
        return nZ;
    }

    private a() {
        this.ob = 0L;
        this.oc = null;
        this.od = 0L;
        SharedPreferences config = getConfig();
        this.ob = config.getLong(ab("c.tieba.baidu.com"), 0L);
        this.oc = config.getString(ac("c.tieba.baidu.com"), null);
        this.od = config.getLong(ad("c.tieba.baidu.com"), 0L);
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
                    long j = this.ob;
                    long j2 = this.od;
                    String str3 = this.oc;
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
                            host2 = aa(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.od = System.currentTimeMillis();
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
                str2 = aa(str);
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
                EditorHelper.putLong(config, ab(str), currentTimeMillis);
                EditorHelper.putString(config, ac(str), str2);
                EditorHelper.putLong(config, ad(str), currentTimeMillis2);
                this.ob = currentTimeMillis;
                this.od = currentTimeMillis2;
                this.oc = str2;
            }
        }
    }

    private String aa(String str) {
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

    private String ab(String str) {
        return str + "-lastLogTime";
    }

    private String ac(String str) {
        return str + "-lastIpAddress";
    }

    private String ad(String str) {
        return str + "-lastGetIpTime";
    }
}
