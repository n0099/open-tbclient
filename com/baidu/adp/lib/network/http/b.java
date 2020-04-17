package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e GM;
    private HttpURLConnection Jy;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Jz = 0;
    private long JA = 0;
    private long firstByteReachTime = 0;
    private long JB = 0;
    private long JC = 0;
    private boolean JD = false;
    private boolean JE = true;
    private boolean JF = true;
    private int JG = 0;
    private TimerTask JH = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.cancelNetConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer timer = new Timer();

    public long kq() {
        return this.JC;
    }

    public long kr() {
        return this.JB;
    }

    public long ks() {
        return this.Jz;
    }

    public long kt() {
        return this.JA;
    }

    public long ku() {
        return this.firstByteReachTime;
    }

    public boolean kv() {
        return this.JD;
    }

    public void ag(boolean z) {
        this.JF = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.GM = eVar;
    }

    public void cancelNetConnect() {
        this.GM.kC().Kp = true;
        com.baidu.adp.lib.f.a.close(this.Jy);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a kp;
        Exception exc;
        URL url2 = new URL(str);
        if (TextUtils.isEmpty(str) || !this.JF) {
            url = url2;
        } else {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.X(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.JT = j.qG();
                        dVar.JU = j.qH();
                        ArrayList<String> qI = j.qI();
                        if (qI != null && qI.size() > 0) {
                            dVar.JV = qI.toString();
                            int size = this.JG % qI.size();
                            String str3 = qI.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.GM.kB().s("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.JD = true;
                                    dVar.JW = size;
                                    dVar.JS = str3;
                                    dVar.JD = this.JD;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.JE ? url : url;
                                }
                            }
                        }
                    }
                }
                url = url2;
            } catch (Exception e2) {
                url = url2;
                exc = e2;
            }
        }
        if (!this.JE && (kp = a.kp()) != null) {
            String bz = kp.bz(str);
            if (!TextUtils.isEmpty(bz)) {
                this.GM.kB().s("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bz));
                this.JD = true;
                dVar.JS = bz;
                return url4;
            }
            return url;
        }
    }

    private HttpURLConnection a(URL url, int i, int i2) throws SocketException {
        HttpURLConnection c = c(url);
        if (c != null) {
            c.setConnectTimeout(i);
            c.setReadTimeout(i2);
            return c;
        }
        throw new SocketException();
    }

    private HttpURLConnection c(URL url) {
        String curMobileProxyHost;
        HttpsURLConnection httpsURLConnection = null;
        try {
            if (j.isNetWorkAvailable()) {
                if (j.isMobileNet() && (curMobileProxyHost = j.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
                    if (j.isWap(curMobileProxyHost) && j.isSupportWap()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(curMobileProxyHost);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.GM.kB().s("X-Online-Host", url.getHost());
                            httpsURLConnection = httpURLConnection;
                        } catch (Exception e) {
                            httpsURLConnection = httpURLConnection;
                            e = e;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpsURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, j.curMobileProxyPort())));
                    }
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.JD && url.getProtocol().equals("https")) {
                    final HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new i(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.adp.lib.network.http.b.2
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str, SSLSession sSLSession) {
                            String requestProperty = httpsURLConnection2.getRequestProperty("Host");
                            if (requestProperty == null) {
                                requestProperty = httpsURLConnection2.getURL().getHost();
                            }
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
                        }
                    });
                    httpsURLConnection = httpsURLConnection2;
                    return httpsURLConnection;
                }
                return httpsURLConnection;
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a(int i, int i2, d dVar) throws Exception {
        URL url;
        Map<String, List<String>> map;
        List<String> list;
        dVar.JQ = -1;
        if (this.GM.kC().Kp) {
            throw new BdHttpCancelException();
        }
        String c = this.GM.kB().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.GM.kC().Kp) {
            throw new BdHttpCancelException();
        }
        dVar.JQ = -2;
        this.Jy = c(a);
        dVar.JQ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Jy == null) {
                throw new SocketException("network not available.");
            }
            this.Jy.setRequestMethod("GET");
            this.Jy.setConnectTimeout(i2);
            this.Jy.setReadTimeout(i);
            this.GM.kB().f(this.Jy);
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.JQ = -4;
            this.Jy.connect();
            if (this.Jz <= 0) {
                this.Jz = System.currentTimeMillis();
            }
            this.JA = System.currentTimeMillis();
            dVar.JQ = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Jy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bM(contentType)) {
                this.Jy.disconnect();
                this.Jy.connect();
                if (this.GM.kC().Kp) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.JQ = -8;
            this.GM.kC().g(this.Jy);
            if (c.contains("c.tieba.baidu.com") && (map = this.GM.kC().Kq) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.JX = list.get(0);
                dVar.JY = list.get(1);
            }
            if (this.GM.kC().responseCode == 302 && (url = this.Jy.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.JP = this.GM.kC().responseCode;
            dVar.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Jy);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.GM.kC().retBytes = c(this.GM.kC().contentEncoding, e);
            }
            dVar.JQ = -9;
            dVar.JN = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Jy != null) {
                this.Jy.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.JC = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.JC == 0) {
            this.JC = System.currentTimeMillis();
            return bArr;
        } else {
            return bArr;
        }
    }

    private byte[] e(HttpURLConnection httpURLConnection) throws Exception {
        byte[] bArr;
        InputStream inputStream;
        Throwable th;
        int read;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                inputStream2 = httpURLConnection.getInputStream();
                while (!this.GM.kC().Kp && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.GM.kC().Kp) {
                    throw new BdHttpCancelException();
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } else {
            bArr = null;
        }
        this.JB = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.JQ = -1;
        try {
            String url = this.GM.kB().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            dVar.JQ = -2;
            this.Jy = c(a);
            dVar.JQ = -3;
            System.currentTimeMillis();
            if (this.Jy == null) {
                throw new SocketException("network not available.");
            }
            this.Jy.setRequestMethod("POST");
            this.Jy.setDoOutput(true);
            this.Jy.setDoInput(true);
            this.Jy.setConnectTimeout(i2);
            this.Jy.setReadTimeout(i);
            this.Jy.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            this.GM.kB().f(this.Jy);
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.JQ = -4;
            this.Jy.connect();
            if (this.Jz <= 0) {
                this.Jz = System.currentTimeMillis();
            }
            this.JA = System.currentTimeMillis();
            dVar.JQ = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.JH, 45000L);
            }
            dVar.JQ = -6;
            this.GM.kB().a(this.Jy, boundary, dVar);
            dVar.JQ = -7;
            String contentType = this.Jy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bM(contentType)) {
                this.Jy.disconnect();
                this.Jy.connect();
                if (this.GM.kC().Kp) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            dVar.JQ = -8;
            this.GM.kC().g(this.Jy);
            dVar.JP = this.GM.kC().responseCode;
            dVar.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Jy);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.GM.kC().downSize = e.length;
                this.GM.kC().retBytes = c(this.GM.kC().contentEncoding, e);
            }
            dVar.JN = new Date().getTime() - time;
            dVar.JQ = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Jy);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [785=8, 786=6, 787=6, 788=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        int i3;
        URL url;
        boolean z3;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url2 = this.GM.kB().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.Jy = a(a, i2, i);
            if (this.GM.kC().Kp) {
                this.JB = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Jy);
                com.baidu.adp.lib.f.a.close((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.createFileIfNotFound(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.GM.kB().f(this.Jy);
                this.Jy.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Jy.connect();
                if (this.Jz <= 0) {
                    this.Jz = System.currentTimeMillis();
                }
                this.JA = System.currentTimeMillis();
                int responseCode = this.Jy.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.Jy.getURL();
                    if (url3 != null) {
                        dVar2.redirectUrl = url3.toString();
                    }
                    if (url3 == null || TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.Jy);
                        this.Jy = a(new URL(url3.toString()), i2, i);
                        this.GM.kB().f(this.Jy);
                        this.Jy.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Jy.connect();
                        i3 = this.Jy.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.GM.kC().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.Jy.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.GM.kC().responseCode == 200 && (headerField = this.Jy.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.GM.kC().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.JB = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.Jy);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.Jy.getContentType() != null && this.Jy.getContentType().contains("text/vnd.wap.wml")) {
                    this.Jy.disconnect();
                    this.GM.kC().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.JB = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.Jy);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.JM = url2.getBytes().length;
                    dVar2.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.JB = System.currentTimeMillis();
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Jy);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.Jy.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.onProgress((int) length, i5);
                        }
                        while (!this.GM.kC().Kp) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i6 += read;
                                    i8 += read;
                                    if (hVar != null && (i8 > i7 || i6 == i5)) {
                                        i8 = 0;
                                        hVar.onProgress((int) (i6 + length), i5);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            dVar2.Ka = i6;
                            dVar2.Kb = length;
                            dVar2.Kc = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.JB = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.Jy);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.JB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.Jy);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private boolean isFileSegSuccess() {
        return this.GM.kC().responseCode == 200 || this.GM.kC().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.JQ = -1;
        try {
            String url = this.GM.kB().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            dVar.JQ = -2;
            this.Jy = c(a);
            dVar.JQ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Jy == null) {
                throw new SocketException("network not available.");
            }
            this.Jy.setRequestMethod("POST");
            this.Jy.setDoOutput(true);
            this.Jy.setDoInput(true);
            this.Jy.setConnectTimeout(i2);
            this.Jy.setReadTimeout(i);
            this.Jy.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            this.GM.kB().f(this.Jy);
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.JQ = -4;
            this.Jy.connect();
            if (this.Jz <= 0) {
                this.Jz = System.currentTimeMillis();
            }
            this.JA = System.currentTimeMillis();
            dVar.JQ = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            dVar.JQ = -6;
            this.GM.kB().a(this.Jy, dVar);
            dVar.JQ = -7;
            if (this.GM.kC().Kp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Jy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bM(contentType)) {
                this.Jy.disconnect();
                this.Jy.connect();
                if (this.GM.kC().Kp) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.JQ = -8;
            this.GM.kC().g(this.Jy);
            dVar.JP = this.GM.kC().responseCode;
            dVar.downloadSize = this.Jy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Jy);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.GM.kC().downSize = e.length;
                this.GM.kC().retBytes = c(this.GM.kC().contentEncoding, e);
            }
            dVar.JN = new Date().getTime() - currentTimeMillis;
            dVar.JQ = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Jy);
        }
    }

    public void aa(int i) {
        this.JG = i;
    }
}
