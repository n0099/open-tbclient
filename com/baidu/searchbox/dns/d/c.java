package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TbEnum;
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
    private static String L = null;
    private static long M = -1;
    private static boolean O = false;
    private static HttpDNSStat P;
    private boolean E;
    private String F;
    private int H;
    private boolean N = false;

    public c(boolean z, String str, int i) {
        this.E = z;
        this.F = str;
        this.H = i;
    }

    @Override // com.baidu.searchbox.dns.d.c.b
    protected String q() {
        if (!DnsUtil.DEBUG || TextUtils.isEmpty(DnsUtil.httpDnsDebugAddress)) {
            return SapiUtils.COOKIE_HTTPS_URL_PREFIX + r() + (DnsUtil.iPv6TestEnable ? "/v6/0001/" : "/v5/0001/");
        }
        return DnsUtil.httpDnsDebugAddress;
    }

    private String r() {
        return (O && !TextUtils.isEmpty(L) && this.H == 2) ? L : "180.76.76.112";
    }

    private void s() {
        com.baidu.searchbox.dns.d.a a2;
        if (O && this.H == 2 && M > 0 && System.currentTimeMillis() - M > 1800000 && (a2 = b.o().a("httpsdns.baidu.com", false, 2)) != null) {
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
        if (this.N) {
            u();
        }
        return bVar;
    }

    public static void k(String str) {
        L = str;
    }

    public static void a(long j) {
        M = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    public Map<String, Object> getParameters() {
        HashMap hashMap = new HashMap();
        if (this.E) {
            hashMap.put("label", this.F);
        } else {
            hashMap.put(Config.DEVICE_NAME, this.F);
        }
        hashMap.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, com.baidu.searchbox.dns.a.a.e().g());
        hashMap.put("type", "ipv4,ipv6");
        if (DnsUtil.iPv6TestEnable) {
            hashMap.put(TbEnum.ParamKey.GROUP, DnsUtil.iPv6Perfer ? "ipv6" : "ipv4");
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
        this.N = true;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void a(Exception exc) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " exception: ", exc);
        }
        this.N = true;
    }

    private void u() {
        if (O && this.H == 2) {
            L = null;
            M = -1L;
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "changeToBGPServer");
            }
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected boolean v() {
        return q().toLowerCase().startsWith("https");
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
        O = z;
    }

    public static void a(HttpDNSStat httpDNSStat) {
        P = httpDNSStat;
    }
}
