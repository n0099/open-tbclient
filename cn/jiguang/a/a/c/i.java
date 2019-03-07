package cn.jiguang.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import cn.jiguang.d.d.aa;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.sapi2.utils.SapiUtils;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class i extends Thread {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static final Object b = new Object();
    private static AtomicInteger c = new AtomicInteger();
    private static CookieManager kT;
    private String d;
    private String e;
    private String f;
    private Context g;
    private int h = 0;
    private String i;

    private i() {
    }

    private i(Context context) {
        String d = cn.jiguang.g.a.d(context, this.d);
        String c2 = cn.jiguang.g.a.c(context, this.e);
        String e = cn.jiguang.g.a.e(context, this.f);
        CookieManager cookieManager = new CookieManager();
        kT = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(kT);
        this.g = context;
        this.d = d;
        this.e = c2;
        this.f = e;
    }

    public static int a(String str) {
        if (cn.jiguang.g.i.a(str)) {
            return -1;
        }
        if (str.equalsIgnoreCase("ChinaTelecom")) {
            return 2;
        }
        if (str.equalsIgnoreCase("ChinaMobile")) {
            return 0;
        }
        return str.equalsIgnoreCase("ChinaUnicom") ? 1 : -1;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:201:0x0034 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:215:0x0034 */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x021e, code lost:
        r2 = "";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:203:0x015f A[ADDED_TO_REGION, EDGE_INSN: B:203:0x015f->B:35:0x015f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0155  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private j a(Context context, String str, int i, long j, boolean z, File file, String str2) {
        HttpURLConnection httpURLConnection;
        int i2;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2;
        Map<String, List<String>> map;
        int responseCode;
        InputStream inputStream2;
        Map<String, List<String>> headerFields;
        String str3;
        j = (j < 200 || j > 60000) ? 2000L : 2000L;
        String uuid = UUID.randomUUID().toString();
        HttpURLConnection httpURLConnection3 = null;
        InputStream inputStream3 = null;
        Map<String, List<String>> map2 = null;
        HttpURLConnection httpURLConnection4 = 0;
        int i3 = -1;
        if (kT == null) {
            kT = new CookieManager();
        }
        while (true) {
            try {
                i2 = httpURLConnection4;
                httpURLConnection4 = httpURLConnection3;
                httpURLConnection = cn.jiguang.h.d.R(context, str);
                try {
                    try {
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Charset", HTTP.UTF_8);
                        httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Mobile Safari/537.36");
                        if (kT.getCookieStore().getCookies().size() > 0) {
                            httpURLConnection.setRequestProperty("Cookie", TextUtils.join(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, kT.getCookieStore().getCookies()));
                        }
                        httpURLConnection.setInstanceFollowRedirects(z);
                        if (file != null) {
                            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("--");
                            stringBuffer.append(uuid);
                            stringBuffer.append("\r\n");
                            stringBuffer.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + file.getName() + "\"\r\n");
                            stringBuffer.append("Content-Type: application/octet-stream; charset=UTF-8\r\n");
                            stringBuffer.append("\r\n");
                            dataOutputStream.write(stringBuffer.toString().getBytes());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                dataOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream.close();
                            dataOutputStream.write("\r\n".getBytes());
                            dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        }
                        responseCode = httpURLConnection.getResponseCode();
                        try {
                            a(httpURLConnection.getHeaderFields());
                        } catch (AssertionError e) {
                            i3 = responseCode;
                        } catch (SSLPeerUnverifiedException e2) {
                            i3 = responseCode;
                            map = map2;
                            inputStream = inputStream3;
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e3) {
                            i3 = responseCode;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (AssertionError e4) {
                } catch (SSLPeerUnverifiedException e5) {
                    map = map2;
                    inputStream = inputStream3;
                    httpURLConnection2 = httpURLConnection;
                } catch (Exception e6) {
                }
            } catch (AssertionError e7) {
                httpURLConnection = httpURLConnection4;
            } catch (SSLPeerUnverifiedException e8) {
                inputStream = inputStream3;
                httpURLConnection2 = httpURLConnection4;
                map = map2;
            } catch (Exception e9) {
                httpURLConnection = httpURLConnection4;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection4;
            }
            if (responseCode == 302) {
                String headerField = httpURLConnection.getHeaderField("Location");
                if (i < 0) {
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                j a2 = a(context, headerField, i - 1, 0L, z, null, null);
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    return a2;
                }
                return a2;
            } else if (responseCode == 200) {
                inputStream2 = httpURLConnection.getInputStream();
                try {
                    try {
                        headerFields = httpURLConnection.getHeaderFields();
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream3 = inputStream2;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (AssertionError e13) {
                    i3 = responseCode;
                    inputStream3 = inputStream2;
                } catch (SSLPeerUnverifiedException e14) {
                    i3 = responseCode;
                    inputStream = inputStream2;
                    httpURLConnection2 = httpURLConnection;
                    map = map2;
                } catch (Exception e15) {
                    i3 = responseCode;
                    inputStream3 = inputStream2;
                }
                try {
                    byte[] a3 = cn.jiguang.g.f.a(inputStream2);
                    if (a3 != null && a3.length > 0) {
                        str3 = new String(a3, HTTP.UTF_8);
                        break;
                    }
                    break;
                } catch (AssertionError e16) {
                    i3 = responseCode;
                    map2 = headerFields;
                    inputStream3 = inputStream2;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection3 = httpURLConnection;
                        if (i3 == 404) {
                            break;
                        }
                        break;
                        return null;
                    }
                    httpURLConnection3 = httpURLConnection;
                    if (i3 == 404) {
                    }
                    return null;
                } catch (SSLPeerUnverifiedException e18) {
                    i3 = responseCode;
                    httpURLConnection2 = httpURLConnection;
                    map = headerFields;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        map2 = map;
                        inputStream3 = inputStream;
                        httpURLConnection3 = httpURLConnection2;
                    } else {
                        map2 = map;
                        inputStream3 = inputStream;
                        httpURLConnection3 = httpURLConnection2;
                    }
                    if (i3 == 404) {
                    }
                    return null;
                } catch (Exception e20) {
                    i3 = responseCode;
                    map2 = headerFields;
                    inputStream3 = inputStream2;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e21) {
                            e21.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection3 = httpURLConnection;
                        if (i3 == 404) {
                        }
                        return null;
                    }
                    httpURLConnection3 = httpURLConnection;
                    if (i3 == 404) {
                    }
                    return null;
                }
            } else {
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    i3 = responseCode;
                    httpURLConnection3 = httpURLConnection;
                } else {
                    i3 = responseCode;
                    httpURLConnection3 = httpURLConnection;
                }
                if (i3 == 404 || !(i3 == 200 || cn.jiguang.g.a.d(context))) {
                    break;
                } else if (i2 >= 3) {
                    return new j(-1, map2, "<<failed_with_retries>>");
                } else {
                    httpURLConnection4 = i2 + 1;
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e23) {
                    }
                }
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e24) {
                e24.printStackTrace();
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (responseCode < 200 || responseCode >= 300) {
            if (responseCode < 400 || responseCode >= 500) {
                if (responseCode >= 500) {
                }
            } else if (400 == responseCode) {
                str3 = "server fail";
            } else if (401 != responseCode && 404 != responseCode && 406 != responseCode && 408 != responseCode && 409 != responseCode) {
                str3 = null;
            }
            str3 = "<<error>>";
        } else if (str3 == null) {
            str3 = "<<error>>";
        }
        return new j(responseCode, headerFields, str3);
    }

    private String a(int i) {
        this.i = (i < 0 || i >= 3) ? "http://182.92.20.189:9099/" : cn.jiguang.d.a.a.b(this.g, "number_url" + i, "http://182.92.20.189:9099/");
        return this.i;
    }

    private String a(String str, j jVar) {
        if (a(this.g, jVar)) {
            return d(str);
        }
        return null;
    }

    private String a(TreeMap<String, String> treeMap) {
        if (treeMap.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append((Object) entry.getValue());
        }
        return cn.jiguang.g.a.a(sb.toString() + cn.jiguang.a.b.a.b(this.g)).toUpperCase();
    }

    public static void a(Context context) {
        if (c.get() >= 2) {
            return;
        }
        a.execute(new i(context));
    }

    private static void a(Map<String, List<String>> map) {
        List<String> list = map.get("Set-Cookie");
        if (list != null) {
            for (String str : list) {
                kT.getCookieStore().add(null, HttpCookie.parse(str).get(0));
            }
        }
    }

    private static boolean a(Context context, j jVar) {
        File K;
        if (context != null && jVar != null && (K = cn.jiguang.d.h.f.K(context, "resp.raw")) != null) {
            StringBuilder sb = new StringBuilder("");
            if (jVar.c != null && jVar.c.size() > 0) {
                for (Map.Entry<String, List<String>> entry : jVar.c.entrySet()) {
                    if (entry.getKey() != null) {
                        sb.append(entry.getKey()).append(": ");
                    }
                    Iterator<String> it = entry.getValue().iterator();
                    if (it.hasNext()) {
                        sb.append(it.next());
                        while (it.hasNext()) {
                            sb.append(", ").append(it.next());
                        }
                    }
                    sb.append("\n");
                }
            }
            sb.append("\r\n\r\n");
            if (!TextUtils.isEmpty(jVar.b)) {
                sb.append(jVar.b);
            }
            if (cn.jiguang.d.h.f.b(K, sb.toString())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(K);
                File K2 = cn.jiguang.d.h.f.K(context, "resp.zip");
                if (K2 == null) {
                    return false;
                }
                cn.jiguang.d.h.f.a(K2);
                try {
                    cn.jiguang.d.h.f.a(arrayList, K2);
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    private boolean a(String str, String str2, String str3) {
        String str4;
        TreeMap<String, String> treeMap = new TreeMap<>();
        if (!cn.jiguang.g.i.a(str)) {
            treeMap.put("imei", str);
        }
        if (!cn.jiguang.g.i.a(str2)) {
            treeMap.put("iccid", str2);
        }
        if (!cn.jiguang.g.i.a(str3)) {
            treeMap.put("imsi", str3);
        }
        treeMap.put("version", cn.jiguang.d.a.a.b(this.g, "number_version", "1.3.0"));
        treeMap.put("app_id", cn.jiguang.d.a.a.b(this.g, "number_appid", "7"));
        treeMap.put("req_time", cn.jiguang.d.h.c.b());
        treeMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, a(treeMap));
        String str5 = "";
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            try {
                str5 = str5 + "&" + ((Object) entry.getKey()) + "=" + URLEncoder.encode(entry.getValue(), HTTP.UTF_8);
            } catch (UnsupportedEncodingException e) {
            }
        }
        try {
            j a2 = a(this.g, this.i + "statistic/query?" + str5, 10, StatisticConfig.MIN_UPLOAD_INTERVAL, false, null, null);
            if (a2.a != 200) {
                return false;
            }
            JSONObject c2 = c(a2.b);
            if (c2 != null) {
                if (c2.optInt("code", -1) != 200) {
                    return false;
                }
                str4 = b(c2.optString("num"));
            } else if (a2.c == null && TextUtils.isEmpty(a2.b)) {
                str4 = null;
            } else {
                synchronized (b) {
                    this.h = 0;
                    try {
                        str4 = a(str5, a2);
                    } catch (Throwable th) {
                        str4 = null;
                    }
                    this.g.deleteFile("resp.raw");
                    this.g.deleteFile("resp.zip");
                }
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            e(str4);
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        String d = cn.jiguang.g.a.d(context, "");
        String c2 = cn.jiguang.g.a.c(context, "");
        return cn.jiguang.g.a.a(d + c2 + cn.jiguang.g.a.e(context, ""));
    }

    private String b(String str) {
        String f = f(str);
        if (!cn.jiguang.g.i.a(f) && Patterns.PHONE.matcher(f).matches()) {
            return f;
        }
        return null;
    }

    private static JSONObject c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONObject(str);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private String d(String str) {
        String a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            j a3 = a(this.g, this.i + "statistic/query?" + str, 10, StatisticConfig.MIN_UPLOAD_INTERVAL, false, cn.jiguang.d.h.f.K(this.g, "resp.zip"), "resp_data");
            if (a3.a == 200) {
                JSONObject c2 = c(a3.b);
                if (c2 == null) {
                    if (a3.c != null || !TextUtils.isEmpty(a3.b)) {
                        if (this.h > 4) {
                            return null;
                        }
                        this.h++;
                        try {
                            a2 = a(str, a3);
                        } catch (Throwable th) {
                        }
                    }
                    a2 = null;
                } else if (c2.optInt("code", -1) != 200) {
                    return null;
                } else {
                    a2 = b(c2.optString("num"));
                }
                return a2;
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }

    private void e(String str) {
        String a2;
        Context context = this.g;
        String b2 = b(context);
        if (cn.jiguang.g.i.a(b2)) {
            b2 = "number_num";
        }
        cn.jiguang.d.a.a.a(context, b2, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("num", str);
            if (!cn.jiguang.g.i.a(this.d)) {
                jSONObject.put("imei", this.d);
            }
            if (!cn.jiguang.g.i.a(this.f)) {
                jSONObject.put("imsi", this.f);
            }
            if (!cn.jiguang.g.i.a(this.e)) {
                jSONObject.put("iccid", this.e);
            }
            try {
                a2 = cn.jiguang.d.h.a.a.a(jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cn.jiguang.g.i.a(a2)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            aa.a(this.g, jSONObject2, "nb");
            jSONObject2.put("content", a2);
            cn.jiguang.a.c.c.a(this.g, jSONObject2);
            cn.jiguang.a.b.a.c(this.g, false);
        } catch (JSONException e2) {
        }
    }

    private String f(String str) {
        try {
            return cn.jiguang.d.h.a.a.a(str, cn.jiguang.a.b.a.b(this.g).substring(0, 16));
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[Catch: Exception -> 0x0116, TryCatch #0 {Exception -> 0x0116, blocks: (B:3:0x0007, B:5:0x000f, B:7:0x0017, B:10:0x0020, B:13:0x002f, B:15:0x003c, B:58:0x0112, B:17:0x0052, B:19:0x006a, B:21:0x0073, B:23:0x007c, B:25:0x0085, B:33:0x00ac, B:35:0x00b5, B:37:0x00be, B:40:0x00c9, B:42:0x00d2, B:44:0x00db, B:29:0x0091, B:31:0x009c, B:51:0x00ee, B:53:0x00fb, B:55:0x0103), top: B:62:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        int i2 = 0;
        c.incrementAndGet();
        if (cn.jiguang.g.i.a(this.d) && cn.jiguang.g.i.a(this.e) && cn.jiguang.g.i.a(this.f)) {
            return;
        }
        Context context = this.g;
        String b2 = b(context);
        if (cn.jiguang.g.i.a(b2)) {
            b2 = "number_num";
        }
        String b3 = cn.jiguang.d.a.a.b(context, b2, "");
        if (cn.jiguang.g.i.a(b3) || ((Boolean) cn.jiguang.d.a.d.b(this.g, "nb_upload", false)).booleanValue()) {
            cn.jiguang.d.a.d.a(this.g, "nb_lasttime", Long.valueOf(System.currentTimeMillis()));
            String str = this.f;
            if (!cn.jiguang.g.i.a(str)) {
                if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46007") || str.startsWith("46008")) {
                    i = 0;
                } else if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) {
                    i = 1;
                } else if (str.startsWith("46003") || str.startsWith("46005") || str.startsWith("46011")) {
                    i = 2;
                }
                if (i == -1) {
                    a(i);
                    if (!cn.jiguang.g.i.a(this.i)) {
                        a(this.d, this.e, this.f);
                    }
                } else {
                    String str2 = "";
                    while (i2 < 3) {
                        a(i2);
                        i2++;
                        if (!cn.jiguang.g.i.a(this.i) && !str2.equals(this.i)) {
                            str2 = this.i;
                            if (a(this.d, this.e, this.f)) {
                                break;
                            }
                        }
                    }
                }
            }
            i = -1;
            if (i == -1) {
            }
        } else {
            e(b3);
        }
        c.decrementAndGet();
    }
}
