package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
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
    private f nE;
    private HttpURLConnection qA;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long qB = 0;
    private long qC = 0;
    private long firstByteReachTime = 0;
    private long qD = 0;
    private long qE = 0;
    private boolean qF = false;
    private boolean qG = true;
    private boolean qH = true;
    private TimerTask qI = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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
        return this.qE;
    }

    public long fN() {
        return this.qD;
    }

    public long fO() {
        return this.qB;
    }

    public long fP() {
        return this.qC;
    }

    public long fQ() {
        return this.firstByteReachTime;
    }

    public boolean fR() {
        return this.qF;
    }

    public void H(boolean z) {
        this.qH = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.nE = fVar;
    }

    public void cancelNetConnect() {
        this.nE.fZ().ro = true;
        com.baidu.adp.lib.f.a.close(this.qA);
    }

    private URL a(String str, d dVar) throws Exception {
        a fL;
        URL url = new URL(str);
        if (!TextUtils.isEmpty(str) && this.qH) {
            try {
                String host = url.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult f = BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).f(str2, true);
                    if (f != null) {
                        String b = e.fX().b(f.lR(), str2);
                        if (!TextUtils.isEmpty(b) && (!b.startsWith("10.") || !url.getProtocol().equals("https"))) {
                            this.nE.fY().m("Host", str2);
                            URL url2 = new URL(str.replaceFirst("://(.*)" + str2, "://" + b));
                            try {
                                this.qF = true;
                                dVar.qT = b;
                                dVar.qU = f.lP();
                                dVar.qV = f.lQ();
                                dVar.qF = this.qF;
                                return url2;
                            } catch (Exception e) {
                                url = url2;
                                e = e;
                                BdLog.e(e);
                                return !this.qG ? url : url;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (!this.qG && (fL = a.fL()) != null) {
            String ak = fL.ak(str);
            if (!TextUtils.isEmpty(ak)) {
                this.nE.fY().m("Host", url.getHost());
                URL url3 = new URL(str.replace("://" + url.getHost(), "://" + ak));
                this.qF = true;
                dVar.qT = ak;
                return url3;
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
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (com.baidu.adp.lib.util.j.isMobileNet() && (curMobileProxyHost = com.baidu.adp.lib.util.j.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
                    if (com.baidu.adp.lib.util.j.isWap(curMobileProxyHost) && com.baidu.adp.lib.util.j.isSupportWap()) {
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
                            this.nE.fY().m("X-Online-Host", url.getHost());
                            httpsURLConnection = httpURLConnection;
                        } catch (Exception e) {
                            httpsURLConnection = httpURLConnection;
                            e = e;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpsURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, com.baidu.adp.lib.util.j.curMobileProxyPort())));
                    }
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.qF && url.getProtocol().equals("https")) {
                    final HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new j(httpsURLConnection2));
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
        dVar.qR = -1;
        if (this.nE.fZ().ro) {
            throw new BdHttpCancelException();
        }
        String c = this.nE.fY().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.nE.fZ().ro) {
            throw new BdHttpCancelException();
        }
        dVar.qR = -2;
        this.qA = c(a);
        dVar.qR = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.qA == null) {
                throw new SocketException("network not available.");
            }
            this.qA.setRequestMethod("GET");
            this.qA.setConnectTimeout(i2);
            this.qA.setReadTimeout(i);
            this.nE.fY().f(this.qA);
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.qR = -4;
            this.qA.connect();
            if (this.qB <= 0) {
                this.qB = System.currentTimeMillis();
            }
            this.qC = System.currentTimeMillis();
            dVar.qR = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qA.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qA.disconnect();
                this.qA.connect();
                if (this.nE.fZ().ro) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.qR = -8;
            this.nE.fZ().g(this.qA);
            if (c.contains("c.tieba.baidu.com") && (map = this.nE.fZ().rp) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.qW = list.get(0);
                dVar.qX = list.get(1);
            }
            dVar.qQ = this.nE.fZ().responseCode;
            dVar.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qA);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nE.fZ().retBytes = c(this.nE.fZ().contentEncoding, e);
            }
            dVar.qR = -9;
            dVar.qO = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.qA != null) {
                this.qA.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.qE = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.qE == 0) {
            this.qE = System.currentTimeMillis();
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
                while (!this.nE.fZ().ro && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.nE.fZ().ro) {
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
        this.qD = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.qR = -1;
        try {
            String url = this.nE.fY().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qR = -2;
            this.qA = c(a);
            dVar.qR = -3;
            System.currentTimeMillis();
            if (this.qA == null) {
                throw new SocketException("network not available.");
            }
            this.qA.setRequestMethod("POST");
            this.qA.setDoOutput(true);
            this.qA.setDoInput(true);
            this.qA.setConnectTimeout(i2);
            this.qA.setReadTimeout(i);
            this.qA.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            this.nE.fY().f(this.qA);
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.qR = -4;
            this.qA.connect();
            if (this.qB <= 0) {
                this.qB = System.currentTimeMillis();
            }
            this.qC = System.currentTimeMillis();
            dVar.qR = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.qI, 45000L);
            }
            dVar.qR = -6;
            this.nE.fY().a(this.qA, boundary, dVar);
            dVar.qR = -7;
            String contentType = this.qA.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qA.disconnect();
                this.qA.connect();
                if (this.nE.fZ().ro) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qR = -8;
            this.nE.fZ().g(this.qA);
            dVar.qQ = this.nE.fZ().responseCode;
            dVar.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qA);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nE.fZ().downSize = e.length;
                this.nE.fZ().retBytes = c(this.nE.fZ().contentEncoding, e);
            }
            dVar.qO = new Date().getTime() - time;
            dVar.qR = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.qA);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [770=8, 771=6, 772=6, 773=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        int i3;
        URL url;
        boolean z3;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url2 = this.nE.fY().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.qA = a(a, i2, i);
            if (this.nE.fZ().ro) {
                this.qD = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.qA);
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
                this.nE.fY().f(this.qA);
                this.qA.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.qA.connect();
                if (this.qB <= 0) {
                    this.qB = System.currentTimeMillis();
                }
                this.qC = System.currentTimeMillis();
                int responseCode = this.qA.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.qA.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.qA);
                        this.qA = a(new URL(url3.toString()), i2, i);
                        this.nE.fY().f(this.qA);
                        this.qA.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.qA.connect();
                        i3 = this.qA.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.nE.fZ().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.qA.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.nE.fZ().responseCode == 200 && (headerField = this.qA.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.nE.fZ().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.qD = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.qA);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.qA.getContentType() != null && this.qA.getContentType().contains("text/vnd.wap.wml")) {
                    this.qA.disconnect();
                    this.nE.fZ().responseCode = 0;
                    boolean a2 = a(str, iVar, i, i2, z, dVar2, z2);
                    this.qD = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.qA);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.qN = url2.getBytes().length;
                    dVar2.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.qD = System.currentTimeMillis();
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.qA);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.qA.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (iVar != null && length > 0) {
                            iVar.j((int) length, i5);
                        }
                        while (!this.nE.fZ().ro) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i6 += read;
                                    i8 += read;
                                    if (iVar != null && (i8 > i7 || i6 == i5)) {
                                        i8 = 0;
                                        iVar.j((int) (i6 + length), i5);
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
                            this.qD = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.qA);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.qD = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.qA);
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
        return this.nE.fZ().responseCode == 200 || this.nE.fZ().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.qR = -1;
        try {
            String url = this.nE.fY().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qR = -2;
            this.qA = c(a);
            dVar.qR = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.qA == null) {
                throw new SocketException("network not available.");
            }
            this.qA.setRequestMethod("POST");
            this.qA.setDoOutput(true);
            this.qA.setDoInput(true);
            this.qA.setConnectTimeout(i2);
            this.qA.setReadTimeout(i);
            this.qA.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            this.nE.fY().f(this.qA);
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.qR = -4;
            this.qA.connect();
            if (this.qB <= 0) {
                this.qB = System.currentTimeMillis();
            }
            this.qC = System.currentTimeMillis();
            dVar.qR = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            dVar.qR = -6;
            this.nE.fY().a(this.qA, dVar);
            dVar.qR = -7;
            if (this.nE.fZ().ro) {
                throw new BdHttpCancelException();
            }
            String contentType = this.qA.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ax(contentType)) {
                this.qA.disconnect();
                this.qA.connect();
                if (this.nE.fZ().ro) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.qR = -8;
            this.nE.fZ().g(this.qA);
            dVar.qQ = this.nE.fZ().responseCode;
            dVar.downloadSize = this.qA.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.qA);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.nE.fZ().downSize = e.length;
                this.nE.fZ().retBytes = c(this.nE.fZ().contentEncoding, e);
            }
            dVar.qO = new Date().getTime() - currentTimeMillis;
            dVar.qR = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.qA);
        }
    }
}
