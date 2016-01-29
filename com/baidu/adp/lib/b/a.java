package com.baidu.adp.lib.b;

import android.content.SharedPreferences;
import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.i;
import com.baidu.tieba.compatible.EditorHelper;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private static a tP = null;
    private final String tQ = "c.tieba.baidu.com";
    private long tR;
    private String tS;
    private long tT;

    public static final a gz() {
        if (tP == null) {
            synchronized (a.class) {
                if (tP == null) {
                    tP = new a();
                }
            }
        }
        return tP;
    }

    private a() {
        this.tR = 0L;
        this.tS = null;
        this.tT = 0L;
        SharedPreferences gA = gA();
        this.tR = gA.getLong(ae("c.tieba.baidu.com"), 0L);
        this.tS = gA.getString(af("c.tieba.baidu.com"), null);
        this.tT = gA.getLong(ag("c.tieba.baidu.com"), 0L);
    }

    public void d(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && i.iZ()) {
            try {
                String host = new URL(str).getHost();
                if ("c.tieba.baidu.com".equals(host)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.tR;
                    long j2 = this.tT;
                    String str2 = this.tS;
                    if (currentTimeMillis - j > 43200000) {
                        a(host, null, z, "12hour");
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(currentTimeMillis);
                    int i = calendar.get(6);
                    calendar.setTimeInMillis(j);
                    if (i != calendar.get(6)) {
                        a(host, null, z, "newday");
                    } else if (System.currentTimeMillis() - j2 > 3600000) {
                        String ad = ad(host);
                        if (!TextUtils.equals(ad, str2) || str2 == null) {
                            a(host, ad, z, "ipchange");
                        } else {
                            this.tT = System.currentTimeMillis();
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void a(String str, String str2, boolean z, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                str2 = ad(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                d aq = com.baidu.adp.lib.stats.a.ht().aq("dbg");
                aq.r("host", str);
                aq.r("hostip", str2);
                aq.b("issuc", Boolean.valueOf(z));
                Address b = com.baidu.adp.lib.e.a.gL().b(false, false);
                if (b != null) {
                    aq.b("lati", Double.valueOf(b.getLatitude()));
                    aq.b("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.ht().b("dnsproxy", aq);
                SharedPreferences gA = gA();
                EditorHelper.putLong(gA, ae(str), currentTimeMillis);
                EditorHelper.putString(gA, af(str), str2);
                EditorHelper.putLong(gA, ag(str), currentTimeMillis2);
                this.tR = currentTimeMillis;
                this.tT = currentTimeMillis2;
                this.tS = str2;
            }
        }
    }

    private String ad(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private SharedPreferences gA() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    private String ae(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String af(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String ag(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
