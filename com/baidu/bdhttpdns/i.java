package com.baidu.bdhttpdns;

import android.net.http.Headers;
import com.baidu.android.imsdk.db.TableDefine;
import com.xiaomi.mipush.sdk.Constants;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class i {
    private static volatile i aep;
    private static c aeq;
    private static boolean b = true;
    private String d;
    private int o;
    private String c = "180.76.76.200";
    private boolean f = true;
    private long g = 0;
    private final Object j = new Object();
    private ArrayList<String> k = new ArrayList<>();
    private String l = "";
    private String m = "";
    private boolean n = false;
    private int p = 10;
    private final Object i = new Object();
    private final HashSet<String> aer = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public interface a {
        void a(int i, d dVar, Map<String, e> map, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class b implements Runnable {
        private d aes;
        private a aet;
        private String c;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1278a = false;
        private boolean f = false;

        public b(String str, d dVar, a aVar) {
            this.c = str;
            this.aes = dVar;
            this.aet = aVar;
        }

        private String a(String str, d dVar) {
            String str2;
            long currentTimeMillis = i.this.g + (System.currentTimeMillis() / 1000) + 300;
            String a2 = i.this.a(str, currentTimeMillis);
            if (a2 == null) {
                return null;
            }
            if (i.this.d == null || i.this.o >= 3) {
                str2 = i.this.c;
                this.f = false;
                l.a("Using BGPServerIp(%s)", i.this.c);
            } else {
                str2 = i.this.d;
                this.f = true;
                l.a("Using IDCServerIP(%s)", i.this.d);
            }
            String format = dVar.equals(d.TAG_OF_HOSTS) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, i.this.l, str, a2, Long.valueOf(currentTimeMillis), "1.3", "android") : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, i.this.l, str, a2, Long.valueOf(currentTimeMillis), "1.3", "android");
            return i.this.f ? String.format("https://%s", format) : String.format("http://%s", format);
        }

        private void a() {
            String a2 = a(this.c, this.aes);
            if (a2 != null) {
                a(a2);
                return;
            }
            this.aet.a(-1, this.aes, null, this.c);
            l.a("Httpdns request failed for  %s(%s), get url error", this.aes.toString(), this.c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0218  */
        /* JADX WARN: Type inference failed for: r0v48 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(String str) {
            HttpsURLConnection httpsURLConnection;
            Map map;
            HttpURLConnection httpURLConnection = null;
            HashMap hashMap = new HashMap();
            Boolean bool = true;
            try {
                try {
                    URL url = new URL(str);
                    if (i.this.f) {
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                        httpsURLConnection2.setRequestProperty("Host", "httpdns.baidubce.com");
                        httpsURLConnection2.setHostnameVerifier(i.aeq);
                        httpsURLConnection = httpsURLConnection2;
                    } else {
                        httpsURLConnection = (HttpURLConnection) url.openConnection();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    if (bool.booleanValue() && this.f) {
                        i.this.o = 0;
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                httpsURLConnection = null;
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                httpsURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (bool.booleanValue()) {
                    i.this.o = 0;
                }
                throw th;
            }
            try {
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpsURLConnection.setRequestProperty(com.baidubce.http.Headers.ACCEPT_ENCODING, "gzip, deflate");
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream errorStream = responseCode >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream();
                if (errorStream != null) {
                    String a2 = i.this.a(errorStream, httpsURLConnection);
                    if (a2 == null) {
                        Boolean bool2 = false;
                        i.this.a(Boolean.valueOf(this.f));
                        l.a("Httpdns request failed for %s(%s), get empty response data", this.aes.toString(), this.c);
                        this.aet.a(-1, this.aes, null, this.c);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (bool2.booleanValue() && this.f) {
                            i.this.o = 0;
                            return;
                        }
                        return;
                    }
                    Map a3 = i.this.a(a2, this.c, this.aes);
                    if (a3.get("isSignExpired").equals(true)) {
                        this.f1278a = true;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (bool.booleanValue() && this.f) {
                            i.this.o = 0;
                            return;
                        }
                        return;
                    }
                    if (a3.get("isMsgOK").equals(true) && responseCode == 200) {
                        map = i.this.N(a2, this.c);
                    } else {
                        this.aet.a(-1, this.aes, null, this.c);
                        map = hashMap;
                    }
                    hashMap = map;
                } else {
                    bool = false;
                    i.this.a(Boolean.valueOf(this.f));
                    l.a("Httpdns request failed for %s(%s), get null response stream", this.aes.toString(), this.c);
                    this.aet.a(-1, this.aes, null, this.c);
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                if (bool.booleanValue() && this.f) {
                    i.this.o = 0;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                Boolean bool3 = false;
                i.this.a(Boolean.valueOf(this.f));
                l.a("Httpdns request failed for %s(%s), caught network IOException", this.aes.toString(), this.c);
                this.aet.a(-1, this.aes, null, this.c);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                if (bool3.booleanValue() && this.f) {
                    i.this.o = 0;
                }
                if (hashMap != null) {
                }
                this.aet.a(-1, this.aes, null, this.c);
            } catch (ArrayIndexOutOfBoundsException e4) {
                e = e4;
                e.printStackTrace();
                Boolean bool4 = false;
                i.this.a(Boolean.valueOf(this.f));
                l.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.aes.toString(), this.c);
                this.aet.a(-1, this.aes, null, this.c);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                if (bool4.booleanValue() && this.f) {
                    i.this.o = 0;
                }
                if (hashMap != null) {
                }
                this.aet.a(-1, this.aes, null, this.c);
            }
            if (hashMap != null || hashMap.isEmpty()) {
                this.aet.a(-1, this.aes, null, this.c);
            } else {
                this.aet.a(0, this.aes, hashMap, this.c);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            if (this.f1278a) {
                l.a("Retry for %s(%s).", this.aes.toString(), this.c);
                a();
            }
            synchronized (i.this.i) {
                if (!this.aes.equals(d.TAG_OF_HOSTS)) {
                    for (String str : this.c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        i.this.aer.remove(str);
                    }
                }
            }
            synchronized (i.this.j) {
                if (this.aes.equals(d.DNLIST_HOSTS)) {
                    for (String str2 : this.c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        i.this.k.remove(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class c implements HostnameVerifier {
        private c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession);
        }
    }

    /* loaded from: classes19.dex */
    public enum d {
        DNLIST_HOSTS,
        TAG_OF_HOSTS
    }

    /* loaded from: classes19.dex */
    public class e {
        private final ArrayList<String> b;
        private final long c;

        public e(ArrayList<String> arrayList, long j) {
            this.b = arrayList;
            this.c = j;
        }

        public ArrayList<String> a() {
            return this.b;
        }

        public long b() {
            return this.c;
        }
    }

    private i() {
        aeq = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(InputStream inputStream, HttpURLConnection httpURLConnection) {
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            try {
                if (contentEncoding.contains("gzip")) {
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
                    return a(byteArrayOutputStream.toByteArray(), contentLength);
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

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, long j) {
        return com.baidu.bdhttpdns.e.e(String.format("%s-%s-%d", str, e(), Long.valueOf(j)));
    }

    private String a(byte[] bArr, int i) {
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
            } while (!b(byteArrayOutputStream.toString()));
            gZIPInputStream.close();
            return byteArrayOutputStream.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.o++;
            l.a("requestIDCFailNum: %s", Integer.valueOf(this.o));
        }
    }

    public static boolean b(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i tb() {
        if (aep == null) {
            synchronized (i.class) {
                if (aep == null) {
                    aep = new i();
                }
            }
        }
        return aep;
    }

    Map N(String str, String str2) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("serverip")) {
                JSONArray optJSONArray = jSONObject.optJSONObject("serverip").optJSONArray("ipv4");
                if (optJSONArray.length() > 0) {
                    this.d = optJSONArray.optString(0);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                l.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next).optJSONObject("ipv4");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                    l.a("Httpdns request failed, host(%s), response has no ip field", next);
                    hashMap.put(next, null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString = optJSONArray2.optString(i2);
                        if (optString == null || optString.isEmpty()) {
                            l.a("Httpdns request warning, host(%s), response get ip error", next);
                        } else if (com.baidu.bdhttpdns.e.a(optString)) {
                            arrayList.add(optString);
                        } else {
                            l.a("Httpdns request warning, host(%s), response get invalid ip(%s)", next, optString);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        l.a("Httpdns request failed, host(%s), response has no valid ip", next);
                        hashMap.put(next, null);
                    } else {
                        try {
                            long j = optJSONObject2.getLong("ttl");
                            if (j < 0) {
                                l.a("Httpdns request failed, host(%s), response has invalid ttl(%s)", next, Long.valueOf(j));
                                hashMap.put(next, null);
                            } else {
                                hashMap.put(next, new e(arrayList, j));
                                i++;
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            l.a("Httpdns request failed, host(%s), response has no ttl", next);
                            return null;
                        }
                    }
                }
            }
            if (i == 0) {
                return null;
            }
            return hashMap;
        } catch (JSONException e3) {
            e3.printStackTrace();
            l.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
            return null;
        }
    }

    Map a(String str, String str2, d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("isMsgOK", false);
        hashMap.put("isSignExpired", false);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("msg");
            if (optString == null || optString.isEmpty()) {
                l.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
            } else if ("SignatureExpired".equals(optString)) {
                int optInt = jSONObject.optInt("timestamp");
                if (optInt == 0) {
                    l.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
                } else {
                    this.g = optInt - (System.currentTimeMillis() / 1000);
                    hashMap.put("isSignExpired", true);
                }
            } else if ("ok".equals(optString)) {
                hashMap.put("isMsgOK", true);
            } else {
                l.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, optString);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            l.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
        }
        return hashMap;
    }

    public void a(String str) {
        synchronized (this.j) {
            if (!this.k.contains(str)) {
                this.k.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, d dVar, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.i) {
            if (dVar.equals(d.DNLIST_HOSTS)) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.aer.contains(str2)) {
                        l.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.aer.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append((String) arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                str = sb.toString().replaceAll("^,*|,*$", "");
            }
            if (str != null && !str.isEmpty()) {
                try {
                    m.td().b().execute(new b(str, dVar, aVar));
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                    l.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                }
            }
        }
    }

    public void a(ArrayList<String> arrayList, a aVar) {
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int i = 0;
        int i2 = 0;
        while (i < arrayList2.size()) {
            String str = "";
            int i3 = 0;
            while (true) {
                if (i3 >= this.p) {
                    break;
                }
                int i4 = i3 + (this.p * i2);
                if (i4 >= arrayList2.size()) {
                    i = i4;
                    break;
                }
                str = str + ((String) arrayList2.get(i4)) + Constants.ACCEPT_TIME_SEPARATOR_SP;
                i3++;
                i = i4;
            }
            i2++;
            if (str != null && !str.isEmpty()) {
                String substring = str.substring(0, str.length() - 1);
                l.a("Hosts for httpdns request is (%s) ", substring);
                a(substring, d.DNLIST_HOSTS, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f = z;
    }

    public void b() {
        this.o = 0;
        this.d = null;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public ArrayList c() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.m = com.baidu.bdhttpdns.e.f(str);
        if (this.m == null) {
            this.m = str;
            b = false;
        }
    }

    String e() {
        return !b ? this.m : com.baidu.bdhttpdns.e.g(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.n;
    }
}
