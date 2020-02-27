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
    private e nF;
    private HttpURLConnection qy;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long qz = 0;
    private long qA = 0;
    private long firstByteReachTime = 0;
    private long qB = 0;
    private long qC = 0;
    private boolean qD = false;
    private boolean qE = true;
    private boolean qF = true;
    private int qG = 0;
    private TimerTask qH = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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

    public long fM() {
        return this.qC;
    }

    public long fN() {
        return this.qB;
    }

    public long fO() {
        return this.qz;
    }

    public long fP() {
        return this.qA;
    }

    public long fQ() {
        return this.firstByteReachTime;
    }

    public boolean fR() {
        return this.qD;
    }

    public void H(boolean z) {
        this.qF = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.nF = eVar;
    }

    public void cancelNetConnect() {
        this.nF.fY().rp = true;
        com.baidu.adp.lib.f.a.close(this.qy);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a fL;
        Exception exc;
        ArrayList<String> mg;
        URL url2 = new URL(str);
        if (TextUtils.isEmpty(str) || !this.qF) {
            url = url2;
        } else {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult f = BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).f(str2, true);
                    if (f != null && (mg = f.mg()) != null && mg.size() > 0) {
                        this.qG %= mg.size();
                        String str3 = mg.get(this.qG);
                        if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                            this.nF.fX().n("Host", str2);
                            URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                            try {
                                this.qD = true;
                                dVar.qV = this.qG;
                                dVar.qS = str3;
                                dVar.qT = f.me();
                                dVar.qU = f.mf();
                                dVar.qD = this.qD;
                                return url3;
                            } catch (Exception e) {
                                exc = e;
                                url = url3;
                                BdLog.e(exc);
                                return !this.qE ? url : url;
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
        if (!this.qE && (fL = a.fL()) != null) {
            String ak = fL.ak(str);
            if (!TextUtils.isEmpty(ak)) {
                this.nF.fX().n("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + ak));
                this.qD = true;
                dVar.qS = ak;
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
                            this.nF.fX().n("X-Online-Host", url.getHost());
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
                if (this.qD && url.getProtocol().equals("https")) {
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
        Map<String, List<String>> map;
        List<String> list;
        dVar.qQ = -1;
        if (this.nF.fY().rp) {
            throw new BdHttpCancelException();
        }
        String c = this.nF.fX().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.nF.fY().rp) {
            throw new BdHttpCancelException();
        }
        dVar.qQ = -2;
        this.qy = c(a);
        dVar.qQ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.qy == null) {
                throw new SocketException("network not available.");
            }
            this.qy.setRequestMethod("GET");
            this.qy.setConnectTimeout(i2);
            this.qy.setReadTimeout(i);
            this.nF.fX().f(this.qy);
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.qQ = -4;
            this.qy.connect();
            if (this.qz <= 0) {
                this.qz = System.currentTimeMillis();
            }
            this.qA = System.currentTimeMillis();
            dVar.qQ = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qy.disconnect();
                this.qy.connect();
                if (this.nF.fY().rp) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.qQ = -8;
            this.nF.fY().g(this.qy);
            if (c.contains("c.tieba.baidu.com") && (map = this.nF.fY().rq) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.qW = list.get(0);
                dVar.qX = list.get(1);
            }
            dVar.qP = this.nF.fY().responseCode;
            dVar.downloadSize = this.qy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qy);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nF.fY().retBytes = c(this.nF.fY().contentEncoding, e);
            }
            dVar.qQ = -9;
            dVar.qN = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.qy != null) {
                this.qy.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.qC = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.qC == 0) {
            this.qC = System.currentTimeMillis();
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
                while (!this.nF.fY().rp && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.qB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.nF.fY().rp) {
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
        this.qB = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.qQ = -1;
        try {
            String url = this.nF.fX().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            dVar.qQ = -2;
            this.qy = c(a);
            dVar.qQ = -3;
            System.currentTimeMillis();
            if (this.qy == null) {
                throw new SocketException("network not available.");
            }
            this.qy.setRequestMethod("POST");
            this.qy.setDoOutput(true);
            this.qy.setDoInput(true);
            this.qy.setConnectTimeout(i2);
            this.qy.setReadTimeout(i);
            this.qy.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            this.nF.fX().f(this.qy);
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.qQ = -4;
            this.qy.connect();
            if (this.qz <= 0) {
                this.qz = System.currentTimeMillis();
            }
            this.qA = System.currentTimeMillis();
            dVar.qQ = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.qH, 45000L);
            }
            dVar.qQ = -6;
            this.nF.fX().a(this.qy, boundary, dVar);
            dVar.qQ = -7;
            String contentType = this.qy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qy.disconnect();
                this.qy.connect();
                if (this.nF.fY().rp) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            dVar.qQ = -8;
            this.nF.fY().g(this.qy);
            dVar.qP = this.nF.fY().responseCode;
            dVar.downloadSize = this.qy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qy);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nF.fY().downSize = e.length;
                this.nF.fY().retBytes = c(this.nF.fY().contentEncoding, e);
            }
            dVar.qN = new Date().getTime() - time;
            dVar.qQ = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.qy);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [775=8, 776=6, 777=6, 778=6] */
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
            String url2 = this.nF.fX().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.qy = a(a, i2, i);
            if (this.nF.fY().rp) {
                this.qB = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.qy);
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
                this.nF.fX().f(this.qy);
                this.qy.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.qy.connect();
                if (this.qz <= 0) {
                    this.qz = System.currentTimeMillis();
                }
                this.qA = System.currentTimeMillis();
                int responseCode = this.qy.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.qy.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.qy);
                        this.qy = a(new URL(url3.toString()), i2, i);
                        this.nF.fX().f(this.qy);
                        this.qy.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.qy.connect();
                        i3 = this.qy.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.nF.fY().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.qy.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.nF.fY().responseCode == 200 && (headerField = this.qy.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.nF.fY().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.qB = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.qy);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.qy.getContentType() != null && this.qy.getContentType().contains("text/vnd.wap.wml")) {
                    this.qy.disconnect();
                    this.nF.fY().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.qB = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.qy);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.qM = url2.getBytes().length;
                    dVar2.downloadSize = this.qy.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.qB = System.currentTimeMillis();
                        this.qB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.qy);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.qy.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.k((int) length, i5);
                        }
                        while (!this.nF.fY().rp) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i6 += read;
                                    i8 += read;
                                    if (hVar != null && (i8 > i7 || i6 == i5)) {
                                        i8 = 0;
                                        hVar.k((int) (i6 + length), i5);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            dVar2.qZ = i6;
                            dVar2.ra = length;
                            dVar2.rb = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.qB = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.qy);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.qB = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.qy);
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
        return this.nF.fY().responseCode == 200 || this.nF.fY().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.qQ = -1;
        try {
            String url = this.nF.fX().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            dVar.qQ = -2;
            this.qy = c(a);
            dVar.qQ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.qy == null) {
                throw new SocketException("network not available.");
            }
            this.qy.setRequestMethod("POST");
            this.qy.setDoOutput(true);
            this.qy.setDoInput(true);
            this.qy.setConnectTimeout(i2);
            this.qy.setReadTimeout(i);
            this.qy.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            this.nF.fX().f(this.qy);
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.qQ = -4;
            this.qy.connect();
            if (this.qz <= 0) {
                this.qz = System.currentTimeMillis();
            }
            this.qA = System.currentTimeMillis();
            dVar.qQ = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            dVar.qQ = -6;
            this.nF.fX().a(this.qy, dVar);
            dVar.qQ = -7;
            if (this.nF.fY().rp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qy.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qy.disconnect();
                this.qy.connect();
                if (this.nF.fY().rp) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.qQ = -8;
            this.nF.fY().g(this.qy);
            dVar.qP = this.nF.fY().responseCode;
            dVar.downloadSize = this.qy.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qy);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nF.fY().downSize = e.length;
                this.nF.fY().retBytes = c(this.nF.fY().contentEncoding, e);
            }
            dVar.qN = new Date().getTime() - currentTimeMillis;
            dVar.qQ = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.qy);
        }
    }

    public void O(int i) {
        this.qG = i;
    }
}
