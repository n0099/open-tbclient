package com.baidu.bdhttpdns;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import d.b.g.k;
import d.b.g.l;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class i {
    public static volatile i n = null;
    public static boolean o = true;
    public static c p;

    /* renamed from: b  reason: collision with root package name */
    public String f4287b;
    public int l;

    /* renamed from: a  reason: collision with root package name */
    public String f4286a = "180.76.76.200";

    /* renamed from: c  reason: collision with root package name */
    public boolean f4288c = true;

    /* renamed from: d  reason: collision with root package name */
    public long f4289d = 0;

    /* renamed from: g  reason: collision with root package name */
    public final Object f4292g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<String> f4293h = new ArrayList<>();
    public String i = "";
    public String j = "";
    public boolean k = false;
    public int m = 10;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4291f = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f4290e = new HashSet<>();

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, d dVar, Map<String, e> map, String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f4294e;

        /* renamed from: f  reason: collision with root package name */
        public d f4295f;

        /* renamed from: g  reason: collision with root package name */
        public a f4296g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4297h = false;
        public boolean i = false;

        public b(String str, d dVar, a aVar) {
            this.f4294e = str;
            this.f4295f = dVar;
            this.f4296g = aVar;
        }

        public final String a(String str, d dVar) {
            String str2;
            long currentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + i.this.f4289d;
            String g2 = i.this.g(str, currentTimeMillis);
            if (g2 == null) {
                return null;
            }
            if (i.this.f4287b == null || i.this.l >= 3) {
                str2 = i.this.f4286a;
                this.i = false;
                k.a("Using BGPServerIp(%s)", i.this.f4286a);
            } else {
                str2 = i.this.f4287b;
                this.i = true;
                k.a("Using IDCServerIP(%s)", i.this.f4287b);
            }
            String format = dVar.equals(d.TAG_OF_HOSTS) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, i.this.i, str, g2, Long.valueOf(currentTimeMillis), "1.3", "android") : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, i.this.i, str, g2, Long.valueOf(currentTimeMillis), "1.3", "android");
            return i.this.f4288c ? String.format("https://%s", format) : String.format("http://%s", format);
        }

        public final void b() {
            String a2 = a(this.f4294e, this.f4295f);
            if (a2 != null) {
                c(a2);
                return;
            }
            this.f4296g.a(-1, this.f4295f, null, this.f4294e);
            k.a("Httpdns request failed for  %s(%s), get url error", this.f4295f.toString(), this.f4294e);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0137 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x000c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x000c */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0169, code lost:
            if (r1 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x016b, code lost:
            r1.disconnect();
            r1 = r1;
            r14 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x019e, code lost:
            if (r1 == null) goto L59;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01d1  */
        /* JADX WARN: Type inference failed for: r14v13, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r7v26, types: [com.baidu.bdhttpdns.i] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(String str) {
            Throwable th;
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            String str2;
            String str3;
            HttpURLConnection httpURLConnection3;
            HttpsURLConnection httpsURLConnection;
            int responseCode;
            InputStream errorStream;
            a aVar;
            d dVar;
            String str4;
            Boolean bool;
            Boolean bool2;
            Map<String, e> hashMap = new HashMap<>();
            Boolean bool3 = Boolean.TRUE;
            HttpURLConnection httpURLConnection4 = null;
            try {
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection4 = bool3;
                bool3 = str;
            }
            try {
                try {
                    URL url = new URL(str);
                    if (i.this.f4288c) {
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                        httpsURLConnection2.setRequestProperty("Host", "httpdns.baidubce.com");
                        httpsURLConnection2.setHostnameVerifier(i.p);
                        httpsURLConnection = httpsURLConnection2;
                    } else {
                        httpsURLConnection = (HttpURLConnection) url.openConnection();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection4 = bool3;
                    bool3 = str2;
                    if (httpURLConnection4 != null) {
                        httpURLConnection4.disconnect();
                    }
                    if (bool3.booleanValue() && this.i) {
                        i.this.l = 0;
                    }
                    throw th;
                }
                try {
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                    httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                    httpsURLConnection.connect();
                    responseCode = httpsURLConnection.getResponseCode();
                    errorStream = responseCode >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream();
                } catch (IOException e2) {
                    httpURLConnection2 = httpsURLConnection;
                    e = e2;
                    e.printStackTrace();
                    ?? r14 = Boolean.FALSE;
                    i.this.l(Boolean.valueOf(this.i));
                    k.a("Httpdns request failed for %s(%s), caught network IOException", this.f4295f.toString(), this.f4294e);
                    a aVar2 = this.f4296g;
                    d dVar2 = this.f4295f;
                    str2 = this.f4294e;
                    aVar2.a(-1, dVar2, null, str2);
                    httpURLConnection3 = httpURLConnection2;
                    str3 = r14;
                    bool3 = httpURLConnection2;
                    str = r14;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    httpURLConnection = httpsURLConnection;
                    e = e3;
                    e.printStackTrace();
                    ?? r142 = Boolean.FALSE;
                    i.this.l(Boolean.valueOf(this.i));
                    k.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.f4295f.toString(), this.f4294e);
                    a aVar3 = this.f4296g;
                    d dVar3 = this.f4295f;
                    str2 = this.f4294e;
                    aVar3.a(-1, dVar3, null, str2);
                    httpURLConnection3 = httpURLConnection;
                    str3 = r142;
                    bool3 = httpURLConnection;
                    str = r142;
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection4 = httpsURLConnection;
                    bool3 = bool3;
                    th = th;
                    if (httpURLConnection4 != null) {
                    }
                    if (bool3.booleanValue()) {
                        i.this.l = 0;
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                httpURLConnection2 = null;
            } catch (ArrayIndexOutOfBoundsException e5) {
                e = e5;
                httpURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                if (httpURLConnection4 != null) {
                }
                if (bool3.booleanValue()) {
                }
                throw th;
            }
            if (errorStream != null) {
                String f2 = i.this.f(errorStream, httpsURLConnection);
                if (f2 == null) {
                    Boolean bool4 = Boolean.FALSE;
                    i.this.l(Boolean.valueOf(this.i));
                    k.a("Httpdns request failed for %s(%s), get empty response data", this.f4295f.toString(), this.f4294e);
                    this.f4296g.a(-1, this.f4295f, null, this.f4294e);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                Map j = i.this.j(f2, this.f4294e, this.f4295f);
                if (j.get("isSignExpired").equals(Boolean.TRUE)) {
                    this.f4297h = true;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (this.i) {
                        i.this.l = 0;
                        return;
                    }
                    return;
                } else if (j.get("isMsgOK").equals(Boolean.TRUE) && responseCode == 200) {
                    hashMap = i.this.i(f2, this.f4294e);
                    bool2 = bool3;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (bool2.booleanValue() && this.i) {
                        i.this.l = 0;
                    }
                    if (hashMap != null || hashMap.isEmpty()) {
                        this.f4296g.a(-1, this.f4295f, null, this.f4294e);
                    } else {
                        this.f4296g.a(0, this.f4295f, hashMap, this.f4294e);
                        return;
                    }
                } else {
                    aVar = this.f4296g;
                    dVar = this.f4295f;
                    str4 = this.f4294e;
                    bool = bool3;
                }
            } else {
                Boolean bool5 = Boolean.FALSE;
                i.this.l(Boolean.valueOf(this.i));
                k.a("Httpdns request failed for %s(%s), get null response stream", this.f4295f.toString(), this.f4294e);
                aVar = this.f4296g;
                dVar = this.f4295f;
                str4 = this.f4294e;
                bool = bool5;
            }
            aVar.a(-1, dVar, null, str4);
            bool2 = bool;
            if (httpsURLConnection != null) {
            }
            if (bool2.booleanValue()) {
                i.this.l = 0;
            }
            if (hashMap != null) {
            }
            this.f4296g.a(-1, this.f4295f, null, this.f4294e);
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            if (this.f4297h) {
                k.a("Retry for %s(%s).", this.f4295f.toString(), this.f4294e);
                b();
            }
            synchronized (i.this.f4291f) {
                if (!this.f4295f.equals(d.TAG_OF_HOSTS)) {
                    for (String str : this.f4294e.split(",")) {
                        i.this.f4290e.remove(str);
                    }
                }
            }
            synchronized (i.this.f4292g) {
                if (this.f4295f.equals(d.DNLIST_HOSTS)) {
                    for (String str2 : this.f4294e.split(",")) {
                        i.this.f4293h.remove(str2);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements HostnameVerifier {
        public c(i iVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession);
        }
    }

    /* loaded from: classes2.dex */
    public enum d {
        DNLIST_HOSTS,
        TAG_OF_HOSTS
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<String> f4301a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4302b;

        public e(i iVar, ArrayList<String> arrayList, long j) {
            this.f4301a = arrayList;
            this.f4302b = j;
        }

        public ArrayList<String> a() {
            return this.f4301a;
        }

        public long b() {
            return this.f4302b;
        }
    }

    public i() {
        p = new c();
    }

    public static i b() {
        if (n == null) {
            synchronized (i.class) {
                if (n == null) {
                    n = new i();
                }
            }
        }
        return n;
    }

    public static boolean t(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public String A() {
        return !o ? this.j : d.b.g.e.l(this.j);
    }

    public boolean C() {
        return this.k;
    }

    public final String f(InputStream inputStream, HttpURLConnection httpURLConnection) {
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            try {
                if (contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 0) {
                        contentLength = 1024;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (-1 == read) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } else {
                        byte[] bArr2 = new byte[contentLength];
                        inputStream.read(bArr2);
                        byteArrayOutputStream.write(bArr2, 0, contentLength);
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return h(byteArrayOutputStream.toByteArray(), contentLength);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    public final String g(String str, long j) {
        return d.b.g.e.j(String.format("%s-%s-%d", str, A(), Long.valueOf(j)));
    }

    public final String h(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            do {
                int read = gZIPInputStream.read(bArr2, 0, i);
                byteArrayOutputStream.write(bArr2, 0, read);
                if (read == -1) {
                    break;
                }
            } while (!t(byteArrayOutputStream.toString()));
            gZIPInputStream.close();
            return byteArrayOutputStream.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Map i(String str, String str2) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("serverip")) {
                JSONArray optJSONArray = jSONObject.optJSONObject("serverip").optJSONArray("ipv4");
                if (optJSONArray.length() > 0) {
                    this.f4287b = optJSONArray.optString(0);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                k.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next).optJSONObject("ipv4");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("ip");
                if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                    k.a("Httpdns request failed, host(%s), response has no ip field", next);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString = optJSONArray2.optString(i2);
                        if (optString == null || optString.isEmpty()) {
                            k.a("Httpdns request warning, host(%s), response get ip error", next);
                        } else if (d.b.g.e.e(optString)) {
                            arrayList.add(optString);
                        } else {
                            k.a("Httpdns request warning, host(%s), response get invalid ip(%s)", next, optString);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        k.a("Httpdns request failed, host(%s), response has no valid ip", next);
                    } else {
                        try {
                            long j = optJSONObject2.getLong("ttl");
                            if (j < 0) {
                                k.a("Httpdns request failed, host(%s), response has invalid ttl(%s)", next, Long.valueOf(j));
                            } else {
                                hashMap.put(next, new e(this, arrayList, j));
                                i++;
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            k.a("Httpdns request failed, host(%s), response has no ttl", next);
                            return null;
                        }
                    }
                }
                hashMap.put(next, null);
            }
            if (i == 0) {
                return null;
            }
            return hashMap;
        } catch (JSONException e3) {
            e3.printStackTrace();
            k.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
            return null;
        }
    }

    public Map j(String str, String str2, d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("isMsgOK", Boolean.FALSE);
        hashMap.put("isSignExpired", Boolean.FALSE);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("msg");
            if (optString == null || optString.isEmpty()) {
                k.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
                return hashMap;
            } else if (!"SignatureExpired".equals(optString)) {
                if ("ok".equals(optString)) {
                    hashMap.put("isMsgOK", Boolean.TRUE);
                    return hashMap;
                }
                k.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, optString);
                return hashMap;
            } else {
                int optInt = jSONObject.optInt("timestamp");
                if (optInt == 0) {
                    k.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
                } else {
                    this.f4289d = optInt - (System.currentTimeMillis() / 1000);
                    hashMap.put("isSignExpired", Boolean.TRUE);
                }
                return hashMap;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            k.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
            return hashMap;
        }
    }

    public final synchronized void l(Boolean bool) {
        if (bool.booleanValue()) {
            int i = this.l + 1;
            this.l = i;
            k.a("requestIDCFailNum: %s", Integer.valueOf(i));
        }
    }

    public void m(String str) {
        synchronized (this.f4292g) {
            if (!this.f4293h.contains(str)) {
                this.f4293h.add(str);
            }
        }
    }

    public void n(String str, d dVar, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.f4291f) {
            if (dVar.equals(d.DNLIST_HOSTS)) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(str.split(",")));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.f4290e.contains(str2)) {
                        k.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.f4290e.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append((String) arrayList.get(i));
                    sb.append(",");
                }
                str = sb.toString().replaceAll("^,*|,*$", "");
            }
            if (str != null && !str.isEmpty()) {
                try {
                    l.a().b().execute(new b(str, dVar, aVar));
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                    k.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                }
            }
        }
    }

    public void o(ArrayList<String> arrayList, a aVar) {
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int i = 0;
        int i2 = 0;
        while (i < arrayList2.size()) {
            String str = "";
            int i3 = 0;
            while (true) {
                int i4 = this.m;
                if (i3 >= i4 || (i = i3 + (i4 * i2)) >= arrayList2.size()) {
                    break;
                }
                str = str + ((String) arrayList2.get(i)) + ",";
                i3++;
            }
            i2++;
            if (str != null && !str.isEmpty()) {
                String substring = str.substring(0, str.length() - 1);
                k.a("Hosts for httpdns request is (%s) ", substring);
                n(substring, d.DNLIST_HOSTS, aVar);
            }
        }
    }

    public void p(boolean z) {
        this.f4288c = z;
    }

    public void r() {
        this.l = 0;
        this.f4287b = null;
    }

    public void s(boolean z) {
        this.k = z;
    }

    public ArrayList v() {
        return this.f4293h;
    }

    public void w(String str) {
        this.i = str;
    }

    public void y(String str) {
        String k = d.b.g.e.k(str);
        this.j = k;
        if (k == null) {
            this.j = str;
            o = false;
        }
    }
}
