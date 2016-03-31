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
    private static a tY = null;
    private final String tZ = "c.tieba.baidu.com";
    private long ua;
    private String ub;
    private long uc;

    public static final a gz() {
        if (tY == null) {
            synchronized (a.class) {
                if (tY == null) {
                    tY = new a();
                }
            }
        }
        return tY;
    }

    private a() {
        this.ua = 0L;
        this.ub = null;
        this.uc = 0L;
        SharedPreferences gA = gA();
        this.ua = gA.getLong(ae("c.tieba.baidu.com"), 0L);
        this.ub = gA.getString(af("c.tieba.baidu.com"), null);
        this.uc = gA.getLong(ag("c.tieba.baidu.com"), 0L);
    }

    public void a(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && i.jf()) {
            try {
                URL url = new URL(str);
                String host = url.getHost();
                if ("c.tieba.baidu.com".equals(host) || TextUtils.isEmpty(str2)) {
                    str2 = url.getHost();
                    host = null;
                }
                if ("c.tieba.baidu.com".equals(str2)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.ua;
                    long j2 = this.uc;
                    String str3 = this.ub;
                    if (currentTimeMillis - j > 43200000) {
                        a(str2, host, z, "12hour");
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(currentTimeMillis);
                    int i = calendar.get(6);
                    calendar.setTimeInMillis(j);
                    if (i != calendar.get(6)) {
                        a(str2, host, z, "newday");
                    } else if (System.currentTimeMillis() - j2 > 3600000) {
                        if (TextUtils.isEmpty(host)) {
                            host = ad(str2);
                        }
                        if (!TextUtils.equals(host, str3) || str3 == null) {
                            a(str2, host, z, "ipchange");
                        } else {
                            this.uc = System.currentTimeMillis();
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
                d as = com.baidu.adp.lib.stats.a.hz().as("dbg");
                as.r("host", str);
                as.r("hostip", str2);
                as.b("issuc", Boolean.valueOf(z));
                Address b = com.baidu.adp.lib.e.a.gL().b(false, false);
                if (b != null) {
                    as.b("lati", Double.valueOf(b.getLatitude()));
                    as.b("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.hz().b("dnsproxy", as);
                SharedPreferences gA = gA();
                EditorHelper.putLong(gA, ae(str), currentTimeMillis);
                EditorHelper.putString(gA, af(str), str2);
                EditorHelper.putLong(gA, ag(str), currentTimeMillis2);
                this.ua = currentTimeMillis;
                this.uc = currentTimeMillis2;
                this.ub = str2;
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
