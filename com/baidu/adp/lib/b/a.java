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
    private static a ko = null;
    private final String kp = "c.tieba.baidu.com";
    private long kq;
    private String kr;
    private long ks;

    public static final a cN() {
        if (ko == null) {
            synchronized (a.class) {
                if (ko == null) {
                    ko = new a();
                }
            }
        }
        return ko;
    }

    private a() {
        this.kq = 0L;
        this.kr = null;
        this.ks = 0L;
        SharedPreferences cO = cO();
        this.kq = cO.getLong(X("c.tieba.baidu.com"), 0L);
        this.kr = cO.getString(Y("c.tieba.baidu.com"), null);
        this.ks = cO.getLong(Z("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.fq()) {
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
                    long j = this.kq;
                    long j2 = this.ks;
                    String str3 = this.kr;
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
                            host2 = W(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.ks = System.currentTimeMillis();
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
                str2 = W(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                d an = com.baidu.adp.lib.stats.a.dN().an("dbg");
                an.q("host", str);
                an.q("hostip", str2);
                an.d("issuc", Boolean.valueOf(z));
                an.d("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.e.a.cZ().b(false, false);
                if (b != null) {
                    an.d("lati", Double.valueOf(b.getLatitude()));
                    an.d("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.dN().b("dnsproxy", an);
                SharedPreferences cO = cO();
                EditorHelper.putLong(cO, X(str), currentTimeMillis);
                EditorHelper.putString(cO, Y(str), str2);
                EditorHelper.putLong(cO, Z(str), currentTimeMillis2);
                this.kq = currentTimeMillis;
                this.ks = currentTimeMillis2;
                this.kr = str2;
            }
        }
    }

    private String W(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private SharedPreferences cO() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    private String X(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String Y(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String Z(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
