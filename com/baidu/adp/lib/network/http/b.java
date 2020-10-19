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
    private e Iv;
    private HttpURLConnection Lo;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Lp = 0;
    private long Lq = 0;
    private long firstByteReachTime = 0;
    private long Lr = 0;
    private long Ls = 0;
    private boolean Lt = false;
    private boolean Lu = true;
    private boolean Lv = true;
    private boolean Lw = true;
    private int Lx = 0;
    private TimerTask Ly = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.cancelNetConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private TimerTask Lz = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.2
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                com.baidu.adp.lib.f.a.close(b.this.Lo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer timer = new Timer();

    public long mm() {
        return this.Ls;
    }

    public long mn() {
        return this.Lr;
    }

    public long mo() {
        return this.Lp;
    }

    public long mp() {
        return this.Lq;
    }

    public long mq() {
        return this.firstByteReachTime;
    }

    public boolean mr() {
        return this.Lt;
    }

    public void ah(boolean z) {
        this.Lv = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.Iv = eVar;
    }

    public void cancelNetConnect() {
        this.Iv.my().Mn = true;
        com.baidu.adp.lib.f.a.close(this.Lo);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a ml;
        Exception exc;
        URL url2 = new URL(str);
        if (!TextUtils.isEmpty(str) && this.Lv && this.Lw) {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.LQ = j.sW();
                        dVar.LR = j.sX();
                        ArrayList<String> sY = j.sY();
                        if (sY != null && sY.size() > 0) {
                            dVar.LS = sY.toString();
                            int size = this.Lx % sY.size();
                            String str3 = sY.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.Iv.mx().u("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.Lt = true;
                                    dVar.LU = size;
                                    dVar.LO = str3;
                                    dVar.Lt = this.Lt;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.Lu ? url : url;
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
        if (!this.Lu && this.Lw && (ml = a.ml()) != null) {
            String bI = ml.bI(str);
            if (!TextUtils.isEmpty(bI)) {
                this.Iv.mx().u("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bI));
                this.Lt = true;
                dVar.LO = bI;
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
                            this.Iv.mx().u("X-Online-Host", url.getHost());
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
                if (this.Lt && url.getProtocol().equals("https")) {
                    final HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new i(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.adp.lib.network.http.b.3
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
        dVar.LM = -1;
        if (this.Iv.my().Mn) {
            throw new BdHttpCancelException();
        }
        String c = this.Iv.mx().c(dVar);
        dVar.url = c;
        URL a2 = a(c, dVar);
        if (this.Iv.my().Mn) {
            throw new BdHttpCancelException();
        }
        dVar.LM = -2;
        this.Lo = c(a2);
        dVar.LM = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Lo == null) {
                throw new SocketException("network not available.");
            }
            this.Lo.setRequestMethod("GET");
            this.Lo.setConnectTimeout(i2);
            this.Lo.setReadTimeout(i);
            this.Iv.mx().f(this.Lo);
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.LM = -4;
            this.Lo.connect();
            if (this.Lp <= 0) {
                this.Lp = System.currentTimeMillis();
            }
            this.Lq = System.currentTimeMillis();
            dVar.LM = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            if (this.Iv.mx().mF() && this.timer != null && this.Lx >= 0 && this.Lx < 3) {
                this.timer.schedule(this.Lz, (this.Lx + 1) * 3000);
            }
            String contentType = this.Lo.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bT(contentType)) {
                this.Lo.disconnect();
                this.Lo.connect();
                if (this.Iv.my().Mn) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.LM = -8;
            this.Iv.my().g(this.Lo);
            if (c.contains("c.tieba.baidu.com") && (map = this.Iv.my().Mo) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.LV = list.get(0);
                dVar.LW = list.get(1);
            }
            if (this.Iv.my().responseCode == 302 && (url = this.Lo.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.LK = this.Iv.my().responseCode;
            dVar.downloadSize = this.Lo.getHeaderFields().toString().getBytes().length;
            if (this.timer != null) {
                this.timer.cancel();
            }
            byte[] e = e(this.Lo);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.Iv.my().retBytes = c(this.Iv.my().contentEncoding, e);
            }
            dVar.LM = -9;
            dVar.LI = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            if (this.Lo != null) {
                this.Lo.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.Ls = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Ls == 0) {
            this.Ls = System.currentTimeMillis();
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
                while (!this.Iv.my().Mn && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Lr = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.Iv.my().Mn) {
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
        this.Lr = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.LM = -1;
        try {
            String url = this.Iv.mx().getUrl();
            dVar.url = url;
            URL a2 = a(url, dVar);
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            dVar.LM = -2;
            this.Lo = c(a2);
            dVar.LM = -3;
            System.currentTimeMillis();
            if (this.Lo == null) {
                throw new SocketException("network not available.");
            }
            this.Lo.setRequestMethod("POST");
            this.Lo.setDoOutput(true);
            this.Lo.setDoInput(true);
            this.Lo.setConnectTimeout(i2);
            this.Lo.setReadTimeout(i);
            this.Lo.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            this.Iv.mx().f(this.Lo);
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.LM = -4;
            this.Lo.connect();
            if (this.Lp <= 0) {
                this.Lp = System.currentTimeMillis();
            }
            this.Lq = System.currentTimeMillis();
            dVar.LM = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.Ly, 45000L);
            }
            dVar.LM = -6;
            this.Iv.mx().a(this.Lo, boundary, dVar);
            dVar.LM = -7;
            String contentType = this.Lo.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bT(contentType)) {
                this.Lo.disconnect();
                this.Lo.connect();
                if (this.Iv.my().Mn) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            dVar.LM = -8;
            this.Iv.my().g(this.Lo);
            dVar.LK = this.Iv.my().responseCode;
            dVar.downloadSize = this.Lo.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Lo);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.Iv.my().downSize = e.length;
                this.Iv.my().retBytes = c(this.Iv.my().contentEncoding, e);
            }
            dVar.LI = new Date().getTime() - time;
            dVar.LM = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Lo);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=8, 810=6, 811=6, 812=6] */
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
            String url2 = this.Iv.mx().getUrl();
            dVar2.url = url2;
            URL a2 = a(url2, dVar2);
            this.Lo = a(a2, i2, i);
            if (this.Iv.my().Mn) {
                this.Lr = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Lo);
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
                this.Iv.mx().f(this.Lo);
                this.Lo.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Lo.connect();
                if (this.Lp <= 0) {
                    this.Lp = System.currentTimeMillis();
                }
                this.Lq = System.currentTimeMillis();
                int responseCode = this.Lo.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.Lo.getURL();
                    if (url3 != null) {
                        dVar2.redirectUrl = url3.toString();
                    }
                    if (url3 == null || TextUtils.equals(url3.getProtocol(), a2.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.Lo);
                        this.Lo = a(new URL(url3.toString()), i2, i);
                        this.Iv.mx().f(this.Lo);
                        this.Lo.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Lo.connect();
                        i3 = this.Lo.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.Iv.my().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.Lo.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.Iv.my().responseCode == 200 && (headerField = this.Lo.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.Iv.my().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a2 + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.Lr = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.Lo);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.Lo.getContentType() != null && this.Lo.getContentType().contains("text/vnd.wap.wml")) {
                    this.Lo.disconnect();
                    this.Iv.my().responseCode = 0;
                    boolean a3 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.Lr = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.Lo);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a3;
                } else {
                    dVar2.LH = url2.getBytes().length;
                    dVar2.downloadSize = this.Lo.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.Lr = System.currentTimeMillis();
                        this.Lr = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Lo);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.Lo.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.onProgress((int) length, i5);
                        }
                        while (!this.Iv.my().Mn) {
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
                            dVar2.LY = i6;
                            dVar2.LZ = length;
                            dVar2.Ma = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.Lr = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.Lo);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.Lr = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.Lo);
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
        return this.Iv.my().responseCode == 200 || this.Iv.my().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.LM = -1;
        try {
            String url = this.Iv.mx().getUrl();
            dVar.url = url;
            URL a2 = a(url, dVar);
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            dVar.LM = -2;
            this.Lo = c(a2);
            dVar.LM = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Lo == null) {
                throw new SocketException("network not available.");
            }
            this.Lo.setRequestMethod("POST");
            this.Lo.setDoOutput(true);
            this.Lo.setDoInput(true);
            this.Lo.setConnectTimeout(i2);
            this.Lo.setReadTimeout(i);
            this.Lo.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            this.Iv.mx().f(this.Lo);
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.LM = -4;
            this.Lo.connect();
            if (this.Lp <= 0) {
                this.Lp = System.currentTimeMillis();
            }
            this.Lq = System.currentTimeMillis();
            dVar.LM = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            dVar.LM = -6;
            this.Iv.mx().a(this.Lo, dVar);
            dVar.LM = -7;
            if (this.Iv.my().Mn) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Lo.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bT(contentType)) {
                this.Lo.disconnect();
                this.Lo.connect();
                if (this.Iv.my().Mn) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.LM = -8;
            this.Iv.my().g(this.Lo);
            dVar.LK = this.Iv.my().responseCode;
            dVar.downloadSize = this.Lo.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Lo);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.Iv.my().downSize = e.length;
                this.Iv.my().retBytes = c(this.Iv.my().contentEncoding, e);
            }
            dVar.LI = new Date().getTime() - currentTimeMillis;
            dVar.LM = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Lo);
        }
    }

    public void ao(int i) {
        this.Lx = i;
    }

    public void ai(boolean z) {
        this.Lw = z;
    }
}
