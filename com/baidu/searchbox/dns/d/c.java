package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidubce.http.Headers;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes11.dex */
public class c extends com.baidu.searchbox.dns.d.c.b<com.baidu.searchbox.dns.d.a.b> {
    private static boolean L = false;
    private static String M = null;
    private static long N = -1;
    private static boolean P = false;
    private static HttpDNSStat Q;
    private boolean E;
    private String F;
    private int H;
    private boolean O = false;

    public c(boolean z, String str, int i) {
        this.E = z;
        this.F = str;
        this.H = i;
    }

    @Override // com.baidu.searchbox.dns.d.c.b
    protected String q() {
        return L ? SapiUtils.COOKIE_HTTPS_URL_PREFIX + r() + "/v5/0001/" : SapiUtils.COOKIE_HTTPS_URL_PREFIX + r() + "/v2/0001/";
    }

    private String r() {
        return (P && !TextUtils.isEmpty(M) && this.H == 2) ? M : "180.76.76.112";
    }

    private void s() {
        com.baidu.searchbox.dns.d.a a2;
        if (P && this.H == 2 && N > 0 && System.currentTimeMillis() - N > 1800000 && (a2 = b.o().a("httpsdns.baidu.com", false, 2)) != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: httpsdns.baidu.com");
            }
            a2.start();
        }
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

    public static void k(String str) {
        M = str;
    }

    public static void a(long j) {
        N = j;
    }

    public static void a(boolean z) {
        L = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    public Map<String, Object> getParameters() {
        HashMap hashMap = new HashMap();
        if (this.E) {
            hashMap.put("label", this.F);
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
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    /* renamed from: l */
    public com.baidu.searchbox.dns.d.a.b m(String str) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " response " + str);
        }
        return new com.baidu.searchbox.dns.d.a.b(str);
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void c(int i) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " server error: " + i);
        }
        this.O = true;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void a(Exception exc) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " exception: ", exc);
        }
        this.O = true;
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
    protected boolean v() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(HttpURLConnection httpURLConnection) {
        super.a(httpURLConnection);
        httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
        httpURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
        if (v()) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a.y());
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected int w() {
        return 0;
    }

    /* loaded from: classes11.dex */
    private static class a implements HostnameVerifier {
        private a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        static a y() {
            return new a();
        }
    }

    public static void b(boolean z) {
        P = z;
    }

    public static void a(HttpDNSStat httpDNSStat) {
        Q = httpDNSStat;
    }
}
