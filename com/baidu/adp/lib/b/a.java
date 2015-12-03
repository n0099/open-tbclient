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
    private static a tE = null;
    private final String tF = "c.tieba.baidu.com";
    private long tG;
    private String tH;
    private long tI;

    public static final a gr() {
        if (tE == null) {
            synchronized (a.class) {
                if (tE == null) {
                    tE = new a();
                }
            }
        }
        return tE;
    }

    private a() {
        this.tG = 0L;
        this.tH = null;
        this.tI = 0L;
        SharedPreferences gs = gs();
        this.tG = gs.getLong(af("c.tieba.baidu.com"), 0L);
        this.tH = gs.getString(ag("c.tieba.baidu.com"), null);
        this.tI = gs.getLong(ah("c.tieba.baidu.com"), 0L);
    }

    public void d(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && i.iP()) {
            try {
                String host = new URL(str).getHost();
                if ("c.tieba.baidu.com".equals(host)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.tG;
                    long j2 = this.tI;
                    String str2 = this.tH;
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
                        String ae = ae(host);
                        if (!TextUtils.equals(ae, str2) || str2 == null) {
                            a(host, ae, z, "ipchange");
                        } else {
                            this.tI = System.currentTimeMillis();
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
                str2 = ae(str);
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                d ar = com.baidu.adp.lib.stats.a.hl().ar("dbg");
                ar.q("host", str);
                ar.q("hostip", str2);
                ar.e("issuc", Boolean.valueOf(z));
                Address b = com.baidu.adp.lib.e.a.gD().b(false, false);
                if (b != null) {
                    ar.e("lati", Double.valueOf(b.getLatitude()));
                    ar.e("longi", Double.valueOf(b.getLongitude()));
                }
                com.baidu.adp.lib.stats.a.hl().b("dnsproxy", ar);
                SharedPreferences gs = gs();
                EditorHelper.putLong(gs, af(str), currentTimeMillis);
                EditorHelper.putString(gs, ag(str), str2);
                EditorHelper.putLong(gs, ah(str), currentTimeMillis2);
                this.tG = currentTimeMillis;
                this.tI = currentTimeMillis2;
                this.tH = str2;
            }
        }
    }

    private String ae(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private SharedPreferences gs() {
        return BdBaseApplication.getInst().getSharedPreferences("adp", 0);
    }

    private String af(String str) {
        return String.valueOf(str) + "-lastLogTime";
    }

    private String ag(String str) {
        return String.valueOf(str) + "-lastIpAddress";
    }

    private String ah(String str) {
        return String.valueOf(str) + "-lastGetIpTime";
    }
}
