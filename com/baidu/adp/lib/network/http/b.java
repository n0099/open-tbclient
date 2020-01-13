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
    private e nB;
    private HttpURLConnection qx;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long qy = 0;
    private long qz = 0;
    private long firstByteReachTime = 0;
    private long qA = 0;
    private long qB = 0;
    private boolean qC = false;
    private boolean qD = true;
    private boolean qE = true;
    private int qF = 0;
    private TimerTask qG = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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
        return this.qB;
    }

    public long fN() {
        return this.qA;
    }

    public long fO() {
        return this.qy;
    }

    public long fP() {
        return this.qz;
    }

    public long fQ() {
        return this.firstByteReachTime;
    }

    public boolean fR() {
        return this.qC;
    }

    public void H(boolean z) {
        this.qE = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.nB = eVar;
    }

    public void cancelNetConnect() {
        this.nB.fY().ro = true;
        com.baidu.adp.lib.f.a.close(this.qx);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a fL;
        Exception exc;
        ArrayList<String> lR;
        URL url2 = new URL(str);
        if (TextUtils.isEmpty(str) || !this.qE) {
            url = url2;
        } else {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult f = BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).f(str2, true);
                    if (f != null && (lR = f.lR()) != null && lR.size() > 0) {
                        this.qF %= lR.size();
                        String str3 = lR.get(this.qF);
                        if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                            this.nB.fX().l("Host", str2);
                            URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                            try {
                                this.qC = true;
                                dVar.qU = this.qF;
                                dVar.qR = str3;
                                dVar.qS = f.lP();
                                dVar.qT = f.lQ();
                                dVar.qC = this.qC;
                                return url3;
                            } catch (Exception e) {
                                exc = e;
                                url = url3;
                                BdLog.e(exc);
                                return !this.qD ? url : url;
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
        if (!this.qD && (fL = a.fL()) != null) {
            String ak = fL.ak(str);
            if (!TextUtils.isEmpty(ak)) {
                this.nB.fX().l("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + ak));
                this.qC = true;
                dVar.qR = ak;
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
                            this.nB.fX().l("X-Online-Host", url.getHost());
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
                if (this.qC && url.getProtocol().equals("https")) {
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
        dVar.qP = -1;
        if (this.nB.fY().ro) {
            throw new BdHttpCancelException();
        }
        String c = this.nB.fX().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.nB.fY().ro) {
            throw new BdHttpCancelException();
        }
        dVar.qP = -2;
        this.qx = c(a);
        dVar.qP = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.qx == null) {
                throw new SocketException("network not available.");
            }
            this.qx.setRequestMethod("GET");
            this.qx.setConnectTimeout(i2);
            this.qx.setReadTimeout(i);
            this.nB.fX().f(this.qx);
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.qP = -4;
            this.qx.connect();
            if (this.qy <= 0) {
                this.qy = System.currentTimeMillis();
            }
            this.qz = System.currentTimeMillis();
            dVar.qP = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qx.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qx.disconnect();
                this.qx.connect();
                if (this.nB.fY().ro) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.qP = -8;
            this.nB.fY().g(this.qx);
            if (c.contains("c.tieba.baidu.com") && (map = this.nB.fY().rp) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.qV = list.get(0);
                dVar.qW = list.get(1);
            }
            if (this.nB.fY().responseCode == 302 && (url = this.qx.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.qO = this.nB.fY().responseCode;
            dVar.downloadSize = this.qx.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qx);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nB.fY().retBytes = c(this.nB.fY().contentEncoding, e);
            }
            dVar.qP = -9;
            dVar.qM = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.qx != null) {
                this.qx.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.qB = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.qB == 0) {
            this.qB = System.currentTimeMillis();
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
                while (!this.nB.fY().ro && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.qA = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.nB.fY().ro) {
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
        this.qA = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.qP = -1;
        try {
            String url = this.nB.fX().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qP = -2;
            this.qx = c(a);
            dVar.qP = -3;
            System.currentTimeMillis();
            if (this.qx == null) {
                throw new SocketException("network not available.");
            }
            this.qx.setRequestMethod("POST");
            this.qx.setDoOutput(true);
            this.qx.setDoInput(true);
            this.qx.setConnectTimeout(i2);
            this.qx.setReadTimeout(i);
            this.qx.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            this.nB.fX().f(this.qx);
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.qP = -4;
            this.qx.connect();
            if (this.qy <= 0) {
                this.qy = System.currentTimeMillis();
            }
            this.qz = System.currentTimeMillis();
            dVar.qP = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.qG, 45000L);
            }
            dVar.qP = -6;
            this.nB.fX().a(this.qx, boundary, dVar);
            dVar.qP = -7;
            String contentType = this.qx.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qx.disconnect();
                this.qx.connect();
                if (this.nB.fY().ro) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qP = -8;
            this.nB.fY().g(this.qx);
            dVar.qO = this.nB.fY().responseCode;
            dVar.downloadSize = this.qx.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qx);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nB.fY().downSize = e.length;
                this.nB.fY().retBytes = c(this.nB.fY().contentEncoding, e);
            }
            dVar.qM = new Date().getTime() - time;
            dVar.qP = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.qx);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [784=8, 785=6, 786=6, 787=6] */
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
            String url2 = this.nB.fX().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.qx = a(a, i2, i);
            if (this.nB.fY().ro) {
                this.qA = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.qx);
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
                this.nB.fX().f(this.qx);
                this.qx.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.qx.connect();
                if (this.qy <= 0) {
                    this.qy = System.currentTimeMillis();
                }
                this.qz = System.currentTimeMillis();
                int responseCode = this.qx.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.qx.getURL();
                    if (url3 != null) {
                        dVar2.redirectUrl = url3.toString();
                    }
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.qx);
                        this.qx = a(new URL(url3.toString()), i2, i);
                        this.nB.fX().f(this.qx);
                        this.qx.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.qx.connect();
                        i3 = this.qx.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.nB.fY().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.qx.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.nB.fY().responseCode == 200 && (headerField = this.qx.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.nB.fY().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.qA = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.qx);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.qx.getContentType() != null && this.qx.getContentType().contains("text/vnd.wap.wml")) {
                    this.qx.disconnect();
                    this.nB.fY().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.qA = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.qx);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.qL = url2.getBytes().length;
                    dVar2.downloadSize = this.qx.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.qA = System.currentTimeMillis();
                        this.qA = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.qx);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.qx.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.j((int) length, i5);
                        }
                        while (!this.nB.fY().ro) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i6 += read;
                                    i8 += read;
                                    if (hVar != null && (i8 > i7 || i6 == i5)) {
                                        i8 = 0;
                                        hVar.j((int) (i6 + length), i5);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            dVar2.qY = i6;
                            dVar2.qZ = length;
                            dVar2.ra = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.qA = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.qx);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.qA = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.qx);
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
        return this.nB.fY().responseCode == 200 || this.nB.fY().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.qP = -1;
        try {
            String url = this.nB.fX().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qP = -2;
            this.qx = c(a);
            dVar.qP = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.qx == null) {
                throw new SocketException("network not available.");
            }
            this.qx.setRequestMethod("POST");
            this.qx.setDoOutput(true);
            this.qx.setDoInput(true);
            this.qx.setConnectTimeout(i2);
            this.qx.setReadTimeout(i);
            this.qx.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            this.nB.fX().f(this.qx);
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.qP = -4;
            this.qx.connect();
            if (this.qy <= 0) {
                this.qy = System.currentTimeMillis();
            }
            this.qz = System.currentTimeMillis();
            dVar.qP = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qP = -6;
            this.nB.fX().a(this.qx, dVar);
            dVar.qP = -7;
            if (this.nB.fY().ro) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qx.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qx.disconnect();
                this.qx.connect();
                if (this.nB.fY().ro) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.qP = -8;
            this.nB.fY().g(this.qx);
            dVar.qO = this.nB.fY().responseCode;
            dVar.downloadSize = this.qx.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qx);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nB.fY().downSize = e.length;
                this.nB.fY().retBytes = c(this.nB.fY().contentEncoding, e);
            }
            dVar.qM = new Date().getTime() - currentTimeMillis;
            dVar.qP = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.qx);
        }
    }

    public void L(int i) {
        this.qF = i;
    }
}
