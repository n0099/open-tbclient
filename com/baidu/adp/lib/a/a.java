package com.baidu.adp.lib.a;

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
    private static a mB = null;
    private final String mD = "c.tieba.baidu.com";
    private long mE;
    private String mF;
    private long mG;

    public static final a dG() {
        if (mB == null) {
            synchronized (a.class) {
                if (mB == null) {
                    mB = new a();
                }
            }
        }
        return mB;
    }

    private a() {
        this.mE = 0L;
        this.mF = null;
        this.mG = 0L;
        SharedPreferences dH = dH();
        this.mE = dH.getLong(Y("c.tieba.baidu.com"), 0L);
        this.mF = dH.getString(Z("c.tieba.baidu.com"), null);
        this.mG = dH.getLong(aa("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.gk()) {
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
                    long j = this.mE;
                    long j2 = this.mG;
                    String str3 = this.mF;
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
                            host2 = X(host);
                        }
                        if (!TextUtils.equals(host2, str3) || str3 == null) {
                            a(host, host2, z, "ipchange", z2);
                        } else {
                            this.mG = System.currentTimeMillis();
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
                str2 = X(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                d an = com.baidu.adp.lib.stats.a.eG().an("dbg");
                an.q("host", str);
                an.q("hostip", str2);
                an.d("issuc", Boolean.valueOf(z));
                an.d("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.d.a.dS().b(false, false);
                if (b != null) {
                    an.d("lati", Double.valueOf(b.getLatitude()));
                    an.d("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.eG().b("dnsproxy", an);
                SharedPreferences dH = dH();
                EditorHelper.putLong(dH, Y(str), currentTimeMillis);
                EditorHelper.putString(dH, Z(str), str2);
                EditorHelper.putLong(dH, aa(str), currentTimeMillis2);
                this.mE = currentTimeMillis;
                this.mG = currentTimeMillis2;
                this.mF = str2;
            }
        }
    }

    private String X(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private SharedPreferences dH() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    private String Y(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String Z(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String aa(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
