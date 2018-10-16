package com.baidu.searchbox.dns.d;

import com.baidu.mobstat.Config;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class c extends com.baidu.searchbox.dns.d.c.b<com.baidu.searchbox.dns.d.a.b> {
    private boolean y;
    private String z;

    public c(boolean z, String str) {
        this.y = z;
        this.z = str;
    }

    @Override // com.baidu.searchbox.dns.d.c.b
    protected String o() {
        return "https://180.76.76.112/v2/0001/";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    public Map<String, Object> getParameters() {
        HashMap hashMap = new HashMap();
        if (this.y) {
            hashMap.put("label", this.z);
        } else {
            hashMap.put(Config.DEVICE_NAME, this.z);
        }
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    /* renamed from: f */
    public com.baidu.searchbox.dns.d.a.b g(String str) {
        return new com.baidu.searchbox.dns.d.a.b(str);
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void a(int i) {
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void a(Exception exc) {
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected boolean p() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(HttpURLConnection httpURLConnection) {
        super.a(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
        if (p()) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a.r());
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected int q() {
        return 0;
    }

    /* loaded from: classes2.dex */
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

        static a r() {
            return new a();
        }
    }
}
