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
    private e GQ;
    private HttpURLConnection JL;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long JM = 0;
    private long JN = 0;
    private long firstByteReachTime = 0;
    private long JO = 0;
    private long JP = 0;
    private boolean JQ = false;
    private boolean JR = true;
    private boolean JS = true;
    private boolean JT = true;
    private int JU = 0;
    private TimerTask JV = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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

    public long ks() {
        return this.JP;
    }

    public long kt() {
        return this.JO;
    }

    public long ku() {
        return this.JM;
    }

    public long kv() {
        return this.JN;
    }

    public long kw() {
        return this.firstByteReachTime;
    }

    public boolean kx() {
        return this.JQ;
    }

    public void ag(boolean z) {
        this.JS = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.GQ = eVar;
    }

    public void cancelNetConnect() {
        this.GQ.kE().KE = true;
        com.baidu.adp.lib.f.a.close(this.JL);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a kr;
        Exception exc;
        URL url2 = new URL(str);
        if (!TextUtils.isEmpty(str) && this.JS && this.JT) {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.L(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.Ki = j.qM();
                        dVar.Kj = j.qN();
                        ArrayList<String> qO = j.qO();
                        if (qO != null && qO.size() > 0) {
                            dVar.Kk = qO.toString();
                            int size = this.JU % qO.size();
                            String str3 = qO.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.GQ.kD().s("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.JQ = true;
                                    dVar.Kl = size;
                                    dVar.Kh = str3;
                                    dVar.JQ = this.JQ;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.JR ? url : url;
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
        } else {
            url = url2;
        }
        if (!this.JR && this.JT && (kr = a.kr()) != null) {
            String bA = kr.bA(str);
            if (!TextUtils.isEmpty(bA)) {
                this.GQ.kD().s("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bA));
                this.JQ = true;
                dVar.Kh = bA;
                return url4;
            }
            return url;
        }
        return url;
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
                            this.GQ.kD().s("X-Online-Host", url.getHost());
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
                if (this.JQ && url.getProtocol().equals("https")) {
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
        dVar.Kf = -1;
        if (this.GQ.kE().KE) {
            throw new BdHttpCancelException();
        }
        String c = this.GQ.kD().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.GQ.kE().KE) {
            throw new BdHttpCancelException();
        }
        dVar.Kf = -2;
        this.JL = c(a);
        dVar.Kf = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.JL == null) {
                throw new SocketException("network not available.");
            }
            this.JL.setRequestMethod("GET");
            this.JL.setConnectTimeout(i2);
            this.JL.setReadTimeout(i);
            this.GQ.kD().f(this.JL);
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.Kf = -4;
            this.JL.connect();
            if (this.JM <= 0) {
                this.JM = System.currentTimeMillis();
            }
            this.JN = System.currentTimeMillis();
            dVar.Kf = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            String contentType = this.JL.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bN(contentType)) {
                this.JL.disconnect();
                this.JL.connect();
                if (this.GQ.kE().KE) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Kf = -8;
            this.GQ.kE().g(this.JL);
            if (c.contains("c.tieba.baidu.com") && (map = this.GQ.kE().KF) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.Km = list.get(0);
                dVar.Kn = list.get(1);
            }
            if (this.GQ.kE().responseCode == 302 && (url = this.JL.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.Ke = this.GQ.kE().responseCode;
            dVar.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.JL);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.GQ.kE().retBytes = c(this.GQ.kE().contentEncoding, e);
            }
            dVar.Kf = -9;
            dVar.Kc = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.JL != null) {
                this.JL.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.JP = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.JP == 0) {
            this.JP = System.currentTimeMillis();
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
                while (!this.GQ.kE().KE && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.GQ.kE().KE) {
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
        this.JO = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Kf = -1;
        try {
            String url = this.GQ.kD().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            dVar.Kf = -2;
            this.JL = c(a);
            dVar.Kf = -3;
            System.currentTimeMillis();
            if (this.JL == null) {
                throw new SocketException("network not available.");
            }
            this.JL.setRequestMethod("POST");
            this.JL.setDoOutput(true);
            this.JL.setDoInput(true);
            this.JL.setConnectTimeout(i2);
            this.JL.setReadTimeout(i);
            this.JL.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            this.GQ.kD().f(this.JL);
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.Kf = -4;
            this.JL.connect();
            if (this.JM <= 0) {
                this.JM = System.currentTimeMillis();
            }
            this.JN = System.currentTimeMillis();
            dVar.Kf = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.JV, 45000L);
            }
            dVar.Kf = -6;
            this.GQ.kD().a(this.JL, boundary, dVar);
            dVar.Kf = -7;
            String contentType = this.JL.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bN(contentType)) {
                this.JL.disconnect();
                this.JL.connect();
                if (this.GQ.kE().KE) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            dVar.Kf = -8;
            this.GQ.kE().g(this.JL);
            dVar.Ke = this.GQ.kE().responseCode;
            dVar.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.JL);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.GQ.kE().downSize = e.length;
                this.GQ.kE().retBytes = c(this.GQ.kE().contentEncoding, e);
            }
            dVar.Kc = new Date().getTime() - time;
            dVar.Kf = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.JL);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [787=8, 788=6, 789=6, 790=6] */
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
            String url2 = this.GQ.kD().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.JL = a(a, i2, i);
            if (this.GQ.kE().KE) {
                this.JO = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.JL);
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
                this.GQ.kD().f(this.JL);
                this.JL.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.JL.connect();
                if (this.JM <= 0) {
                    this.JM = System.currentTimeMillis();
                }
                this.JN = System.currentTimeMillis();
                int responseCode = this.JL.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.JL.getURL();
                    if (url3 != null) {
                        dVar2.redirectUrl = url3.toString();
                    }
                    if (url3 == null || TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.JL);
                        this.JL = a(new URL(url3.toString()), i2, i);
                        this.GQ.kD().f(this.JL);
                        this.JL.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.JL.connect();
                        i3 = this.JL.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.GQ.kE().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.JL.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.GQ.kE().responseCode == 200 && (headerField = this.JL.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.GQ.kE().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.JO = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.JL);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.JL.getContentType() != null && this.JL.getContentType().contains("text/vnd.wap.wml")) {
                    this.JL.disconnect();
                    this.GQ.kE().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.JO = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.JL);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.Kb = url2.getBytes().length;
                    dVar2.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.JO = System.currentTimeMillis();
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.JL);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.JL.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.onProgress((int) length, i5);
                        }
                        while (!this.GQ.kE().KE) {
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
                            dVar2.Kp = i6;
                            dVar2.Kq = length;
                            dVar2.Kr = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.JO = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.JL);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.JO = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.JL);
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
        return this.GQ.kE().responseCode == 200 || this.GQ.kE().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Kf = -1;
        try {
            String url = this.GQ.kD().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            dVar.Kf = -2;
            this.JL = c(a);
            dVar.Kf = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.JL == null) {
                throw new SocketException("network not available.");
            }
            this.JL.setRequestMethod("POST");
            this.JL.setDoOutput(true);
            this.JL.setDoInput(true);
            this.JL.setConnectTimeout(i2);
            this.JL.setReadTimeout(i);
            this.JL.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            this.GQ.kD().f(this.JL);
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.Kf = -4;
            this.JL.connect();
            if (this.JM <= 0) {
                this.JM = System.currentTimeMillis();
            }
            this.JN = System.currentTimeMillis();
            dVar.Kf = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            dVar.Kf = -6;
            this.GQ.kD().a(this.JL, dVar);
            dVar.Kf = -7;
            if (this.GQ.kE().KE) {
                throw new BdHttpCancelException();
            }
            String contentType = this.JL.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bN(contentType)) {
                this.JL.disconnect();
                this.JL.connect();
                if (this.GQ.kE().KE) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Kf = -8;
            this.GQ.kE().g(this.JL);
            dVar.Ke = this.GQ.kE().responseCode;
            dVar.downloadSize = this.JL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.JL);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.GQ.kE().downSize = e.length;
                this.GQ.kE().retBytes = c(this.GQ.kE().contentEncoding, e);
            }
            dVar.Kc = new Date().getTime() - currentTimeMillis;
            dVar.Kf = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.JL);
        }
    }

    public void ab(int i) {
        this.JU = i;
    }

    public void ah(boolean z) {
        this.JT = z;
    }
}
