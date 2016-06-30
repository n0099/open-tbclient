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
    private static a jK = null;
    private final String jL = "c.tieba.baidu.com";
    private long jM;
    private String jN;
    private long jO;

    public static final a cO() {
        if (jK == null) {
            synchronized (a.class) {
                if (jK == null) {
                    jK = new a();
                }
            }
        }
        return jK;
    }

    private a() {
        this.jM = 0L;
        this.jN = null;
        this.jO = 0L;
        SharedPreferences cP = cP();
        this.jM = cP.getLong(V("c.tieba.baidu.com"), 0L);
        this.jN = cP.getString(W("c.tieba.baidu.com"), null);
        this.jO = cP.getLong(X("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.fr()) {
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
                    long j = this.jM;
                    long j2 = this.jO;
                    String str3 = this.jN;
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
                            host2 = U(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.jO = System.currentTimeMillis();
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
                str2 = U(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                d al = com.baidu.adp.lib.stats.a.dO().al("dbg");
                al.q("host", str);
                al.q("hostip", str2);
                al.b("issuc", Boolean.valueOf(z));
                al.b("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.e.a.da().b(false, false);
                if (b != null) {
                    al.b("lati", Double.valueOf(b.getLatitude()));
                    al.b("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.dO().b("dnsproxy", al);
                SharedPreferences cP = cP();
                EditorHelper.putLong(cP, V(str), currentTimeMillis);
                EditorHelper.putString(cP, W(str), str2);
                EditorHelper.putLong(cP, X(str), currentTimeMillis2);
                this.jM = currentTimeMillis;
                this.jO = currentTimeMillis2;
                this.jN = str2;
            }
        }
    }

    private String U(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private SharedPreferences cP() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    private String V(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String W(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String X(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
