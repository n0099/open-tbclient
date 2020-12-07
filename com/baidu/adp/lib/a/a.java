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
    private static a LM = null;
    private final String LN = "c.tieba.baidu.com";
    private long LO;
    private String LQ;
    private long LR;

    public static final a mc() {
        if (LM == null) {
            synchronized (a.class) {
                if (LM == null) {
                    LM = new a();
                }
            }
        }
        return LM;
    }

    private a() {
        this.LO = 0L;
        this.LQ = null;
        this.LR = 0L;
        SharedPreferences config = getConfig();
        this.LO = config.getLong(bH("c.tieba.baidu.com"), 0L);
        this.LQ = config.getString(bI("c.tieba.baidu.com"), null);
        this.LR = config.getLong(bJ("c.tieba.baidu.com"), 0L);
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
                    long j = this.LO;
                    long j2 = this.LR;
                    String str3 = this.LQ;
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
                            host2 = bG(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.LR = System.currentTimeMillis();
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
                str2 = bG(str);
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
                EditorHelper.putLong(config, bH(str), currentTimeMillis);
                EditorHelper.putString(config, bI(str), str2);
                EditorHelper.putLong(config, bJ(str), currentTimeMillis2);
                this.LO = currentTimeMillis;
                this.LR = currentTimeMillis2;
                this.LQ = str2;
            }
        }
    }

    private String bG(String str) {
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

    private String bH(String str) {
        return str + "-lastLogTime";
    }

    private String bI(String str) {
        return str + "-lastIpAddress";
    }

    private String bJ(String str) {
        return str + "-lastGetIpTime";
    }
}
