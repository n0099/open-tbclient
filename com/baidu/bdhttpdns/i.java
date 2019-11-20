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
/* loaded from: classes.dex */
public final class i {
    private static volatile i ED;
    private static c EE;
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
    private final HashSet<String> EF = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i, d dVar, Map<String, e> map, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private d EG;
        private a EH;
        private String c;
        public boolean a = false;
        private boolean f = false;

        public b(String str, d dVar, a aVar) {
            this.c = str;
            this.EG = dVar;
            this.EH = aVar;
        }

        private String a(String str, d dVar) {
            String str2;
            long currentTimeMillis = i.this.g + (System.currentTimeMillis() / 1000) + 300;
            String g = i.this.g(str, currentTimeMillis);
            if (g == null) {
                return null;
            }
            if (i.this.d == null || i.this.o >= 3) {
                str2 = i.this.c;
                this.f = false;
                f.a("Using BGPServerIp(%s)", i.this.c);
            } else {
                str2 = i.this.d;
                this.f = true;
                f.a("Using IDCServerIP(%s)", i.this.d);
            }
            String format = dVar.equals(d.TAG_OF_HOSTS) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, i.this.l, str, g, Long.valueOf(currentTimeMillis), "1.3", "android") : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true", str2, i.this.l, str, g, Long.valueOf(currentTimeMillis), "1.3", "android");
            return i.this.f ? String.format("https://%s", format) : String.format("http://%s", format);
        }

        private void a() {
            String a = a(this.c, this.EG);
            if (a != null) {
                a(a);
                return;
            }
            this.EH.a(-1, this.EG, null, this.c);
            f.a("Httpdns request failed for  %s(%s), get url error", this.EG.toString(), this.c);
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
                        httpsURLConnection2.setRequestProperty(HTTP.TARGET_HOST, "httpdns.baidubce.com");
                        httpsURLConnection2.setHostnameVerifier(i.EE);
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
                httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream errorStream = responseCode >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream();
                if (errorStream != null) {
                    String a = i.this.a(errorStream, httpsURLConnection);
                    if (a == null) {
                        Boolean bool2 = false;
                        i.this.a(Boolean.valueOf(this.f));
                        f.a("Httpdns request failed for %s(%s), get empty response data", this.EG.toString(), this.c);
                        this.EH.a(-1, this.EG, null, this.c);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (bool2.booleanValue() && this.f) {
                            i.this.o = 0;
                            return;
                        }
                        return;
                    }
                    Map a2 = i.this.a(a, this.c, this.EG);
                    if (a2.get("isSignExpired").equals(true)) {
                        this.a = true;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (bool.booleanValue() && this.f) {
                            i.this.o = 0;
                            return;
                        }
                        return;
                    }
                    if (a2.get("isMsgOK").equals(true) && responseCode == 200) {
                        map = i.this.C(a, this.c);
                    } else {
                        this.EH.a(-1, this.EG, null, this.c);
                        map = hashMap;
                    }
                    hashMap = map;
                } else {
                    bool = false;
                    i.this.a(Boolean.valueOf(this.f));
                    f.a("Httpdns request failed for %s(%s), get null response stream", this.EG.toString(), this.c);
                    this.EH.a(-1, this.EG, null, this.c);
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
                f.a("Httpdns request failed for %s(%s), caught network IOException", this.EG.toString(), this.c);
                this.EH.a(-1, this.EG, null, this.c);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                if (bool3.booleanValue() && this.f) {
                    i.this.o = 0;
                }
                if (hashMap != null) {
                }
                this.EH.a(-1, this.EG, null, this.c);
            } catch (ArrayIndexOutOfBoundsException e4) {
                e = e4;
                e.printStackTrace();
                Boolean bool4 = false;
                i.this.a(Boolean.valueOf(this.f));
                f.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.EG.toString(), this.c);
                this.EH.a(-1, this.EG, null, this.c);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                if (bool4.booleanValue() && this.f) {
                    i.this.o = 0;
                }
                if (hashMap != null) {
                }
                this.EH.a(-1, this.EG, null, this.c);
            }
            if (hashMap != null || hashMap.isEmpty()) {
                this.EH.a(-1, this.EG, null, this.c);
            } else {
                this.EH.a(0, this.EG, hashMap, this.c);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            if (this.a) {
                f.a("Retry for %s(%s).", this.EG.toString(), this.c);
                a();
            }
            synchronized (i.this.i) {
                if (!this.EG.equals(d.TAG_OF_HOSTS)) {
                    for (String str : this.c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        i.this.EF.remove(str);
                    }
                }
            }
            synchronized (i.this.j) {
                if (this.EG.equals(d.DNLIST_HOSTS)) {
                    for (String str2 : this.c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        i.this.k.remove(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements HostnameVerifier {
        private c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession);
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        DNLIST_HOSTS,
        TAG_OF_HOSTS
    }

    /* loaded from: classes.dex */
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
        EE = new c();
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HTTP.UTF_8));
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
            f.a("requestIDCFailNum: %s", Integer.valueOf(this.o));
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

    /* JADX INFO: Access modifiers changed from: private */
    public String g(String str, long j) {
        return com.baidu.bdhttpdns.a.e(String.format("%s-%s-%d", str, e(), Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i lD() {
        if (ED == null) {
            synchronized (i.class) {
                if (ED == null) {
                    ED = new i();
                }
            }
        }
        return ED;
    }

    Map C(String str, String str2) {
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
                f.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next).optJSONObject("ipv4");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                    f.a("Httpdns request failed, host(%s), response has no ip field", next);
                    hashMap.put(next, null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString = optJSONArray2.optString(i2);
                        if (optString == null || optString.isEmpty()) {
                            f.a("Httpdns request warning, host(%s), response get ip error", next);
                        } else if (com.baidu.bdhttpdns.a.a(optString)) {
                            arrayList.add(optString);
                        } else {
                            f.a("Httpdns request warning, host(%s), response get invalid ip(%s)", next, optString);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        f.a("Httpdns request failed, host(%s), response has no valid ip", next);
                        hashMap.put(next, null);
                    } else {
                        try {
                            long j = optJSONObject2.getLong("ttl");
                            if (j < 0) {
                                f.a("Httpdns request failed, host(%s), response has invalid ttl(%s)", next, Long.valueOf(j));
                                hashMap.put(next, null);
                            } else {
                                hashMap.put(next, new e(arrayList, j));
                                i++;
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            f.a("Httpdns request failed, host(%s), response has no ttl", next);
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
            f.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
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
                f.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
            } else if ("SignatureExpired".equals(optString)) {
                int optInt = jSONObject.optInt("timestamp");
                if (optInt == 0) {
                    f.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
                } else {
                    this.g = optInt - (System.currentTimeMillis() / 1000);
                    hashMap.put("isSignExpired", true);
                }
            } else if ("ok".equals(optString)) {
                hashMap.put("isMsgOK", true);
            } else {
                f.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, optString);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            f.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
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
                    if (this.EF.contains(str2)) {
                        f.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.EF.add(str2);
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
                    g.lF().b().execute(new b(str, dVar, aVar));
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                    f.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
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
                f.a("Hosts for httpdns request is (%s) ", substring);
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
        this.m = com.baidu.bdhttpdns.a.f(str);
        if (this.m == null) {
            this.m = str;
            b = false;
        }
    }

    String e() {
        return !b ? this.m : com.baidu.bdhttpdns.a.g(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.n;
    }
}
