package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class c extends com.baidu.searchbox.dns.d.c.b<com.baidu.searchbox.dns.d.a.b> {
    public static boolean L = false;
    public static String M = null;
    public static long N = -1;
    public static boolean P = false;
    public static HttpDNSStat Q;
    public boolean E;
    public String F;
    public int H;
    public boolean O = false;

    /* loaded from: classes2.dex */
    public static class a implements HostnameVerifier {
        public static a y() {
            return new a();
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
        }
    }

    public c(boolean z, String str, int i2) {
        this.E = z;
        this.F = str;
        this.H = i2;
    }

    public static void a(long j) {
        N = j;
    }

    public static void b(boolean z) {
        P = z;
    }

    public static void k(String str) {
        M = str;
    }

    private String r() {
        return (P && !TextUtils.isEmpty(M) && this.H == 2) ? M : "180.76.76.112";
    }

    private void s() {
        com.baidu.searchbox.dns.d.a a2;
        if (!P || this.H != 2 || N <= 0 || System.currentTimeMillis() - N <= 1800000 || (a2 = b.o().a("httpsdns.baidu.com", false, 2)) == null) {
            return;
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " start update domain task: httpsdns.baidu.com");
        }
        a2.start();
    }

    private void u() {
        if (P && this.H == 2) {
            M = null;
            N = -1L;
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "changeToBGPServer");
            }
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void c(int i2) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " server error: " + i2);
        }
        this.O = true;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public Map<String, Object> getParameters() {
        HashMap hashMap = new HashMap();
        if (this.E) {
            hashMap.put(NotificationCompatJellybean.KEY_LABEL, this.F);
            if (L) {
                hashMap.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, com.baidu.searchbox.dns.a.a.e().g());
            }
        } else {
            hashMap.put(Config.DEVICE_NAME, this.F);
        }
        if (L) {
            hashMap.put("type", "ipv4,ipv6");
        }
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.d.c.a
    /* renamed from: l */
    public com.baidu.searchbox.dns.d.a.b m(String str) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " response " + str);
        }
        return new com.baidu.searchbox.dns.d.a.b(str);
    }

    @Override // com.baidu.searchbox.dns.d.c.b
    public String q() {
        if (L) {
            return "https://" + r() + "/v5/0001/";
        }
        return "https://" + r() + "/v2/0001/";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.d.c.a
    /* renamed from: t */
    public com.baidu.searchbox.dns.d.a.b x() {
        s();
        com.baidu.searchbox.dns.d.a.b bVar = (com.baidu.searchbox.dns.d.a.b) super.x();
        if (this.O) {
            u();
        }
        return bVar;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public boolean v() {
        return true;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public int w() {
        return 0;
    }

    public static void a(boolean z) {
        L = z;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(Exception exc) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " exception: ", exc);
        }
        this.O = true;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(HttpURLConnection httpURLConnection) {
        super.a(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        httpURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
        if (v()) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a.y());
        }
    }

    public static void a(HttpDNSStat httpDNSStat) {
        Q = httpDNSStat;
    }
}
