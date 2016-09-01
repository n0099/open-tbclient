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
    private static a mH = null;
    private final String mI = "c.tieba.baidu.com";
    private long mJ;
    private String mK;
    private long mL;

    public static final a dI() {
        if (mH == null) {
            synchronized (a.class) {
                if (mH == null) {
                    mH = new a();
                }
            }
        }
        return mH;
    }

    private a() {
        this.mJ = 0L;
        this.mK = null;
        this.mL = 0L;
        SharedPreferences dJ = dJ();
        this.mJ = dJ.getLong(Y("c.tieba.baidu.com"), 0L);
        this.mK = dJ.getString(Z("c.tieba.baidu.com"), null);
        this.mL = dJ.getLong(aa("c.tieba.baidu.com"), 0L);
    }

    public void b(String str, String str2, boolean z, boolean z2) {
        String host;
        if (!TextUtils.isEmpty(str) && i.gm()) {
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
                    long j = this.mJ;
                    long j2 = this.mL;
                    String str3 = this.mK;
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
                            this.mL = System.currentTimeMillis();
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
                d ao = com.baidu.adp.lib.stats.a.eI().ao("dbg");
                ao.q("host", str);
                ao.q("hostip", str2);
                ao.d("issuc", Boolean.valueOf(z));
                ao.d("isuseip", Boolean.valueOf(z2));
                Address b = com.baidu.adp.lib.e.a.dU().b(false, false);
                if (b != null) {
                    ao.d("lati", Double.valueOf(b.getLatitude()));
                    ao.d("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.eI().b("dnsproxy", ao);
                SharedPreferences dJ = dJ();
                EditorHelper.putLong(dJ, Y(str), currentTimeMillis);
                EditorHelper.putString(dJ, Z(str), str2);
                EditorHelper.putLong(dJ, aa(str), currentTimeMillis2);
                this.mJ = currentTimeMillis;
                this.mL = currentTimeMillis2;
                this.mK = str2;
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

    private SharedPreferences dJ() {
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
