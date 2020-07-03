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
    private e Hs;
    private HttpURLConnection Kl;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Km = 0;
    private long Kn = 0;
    private long firstByteReachTime = 0;
    private long Ko = 0;
    private long Kp = 0;
    private boolean Kq = false;
    private boolean Kr = true;
    private boolean Ks = true;
    private boolean Kt = true;
    private int Ku = 0;
    private TimerTask Kv = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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

    public long kI() {
        return this.Kp;
    }

    public long kJ() {
        return this.Ko;
    }

    public long kK() {
        return this.Km;
    }

    public long kL() {
        return this.Kn;
    }

    public long kM() {
        return this.firstByteReachTime;
    }

    public boolean kN() {
        return this.Kq;
    }

    public void ah(boolean z) {
        this.Ks = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.Hs = eVar;
    }

    public void cancelNetConnect() {
        this.Hs.kU().Le = true;
        com.baidu.adp.lib.f.a.close(this.Kl);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a kH;
        Exception exc;
        URL url2 = new URL(str);
        if (!TextUtils.isEmpty(str) && this.Ks && this.Kt) {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.L(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.KJ = j.rd();
                        dVar.KK = j.re();
                        ArrayList<String> rf = j.rf();
                        if (rf != null && rf.size() > 0) {
                            dVar.KL = rf.toString();
                            int size = this.Ku % rf.size();
                            String str3 = rf.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.Hs.kT().s("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.Kq = true;
                                    dVar.KM = size;
                                    dVar.KI = str3;
                                    dVar.Kq = this.Kq;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.Kr ? url : url;
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
        if (!this.Kr && this.Kt && (kH = a.kH()) != null) {
            String bB = kH.bB(str);
            if (!TextUtils.isEmpty(bB)) {
                this.Hs.kT().s("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bB));
                this.Kq = true;
                dVar.KI = bB;
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
                            this.Hs.kT().s("X-Online-Host", url.getHost());
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
                if (this.Kq && url.getProtocol().equals("https")) {
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
        dVar.KG = -1;
        if (this.Hs.kU().Le) {
            throw new BdHttpCancelException();
        }
        String c = this.Hs.kT().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.Hs.kU().Le) {
            throw new BdHttpCancelException();
        }
        dVar.KG = -2;
        this.Kl = c(a);
        dVar.KG = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Kl == null) {
                throw new SocketException("network not available.");
            }
            this.Kl.setRequestMethod("GET");
            this.Kl.setConnectTimeout(i2);
            this.Kl.setReadTimeout(i);
            this.Hs.kT().f(this.Kl);
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.KG = -4;
            this.Kl.connect();
            if (this.Km <= 0) {
                this.Km = System.currentTimeMillis();
            }
            this.Kn = System.currentTimeMillis();
            dVar.KG = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Kl.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bO(contentType)) {
                this.Kl.disconnect();
                this.Kl.connect();
                if (this.Hs.kU().Le) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.KG = -8;
            this.Hs.kU().g(this.Kl);
            if (c.contains("c.tieba.baidu.com") && (map = this.Hs.kU().Lf) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.KN = list.get(0);
                dVar.KO = list.get(1);
            }
            if (this.Hs.kU().responseCode == 302 && (url = this.Kl.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.KF = this.Hs.kU().responseCode;
            dVar.downloadSize = this.Kl.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Kl);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.Hs.kU().retBytes = c(this.Hs.kU().contentEncoding, e);
            }
            dVar.KG = -9;
            dVar.KD = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Kl != null) {
                this.Kl.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.Kp = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Kp == 0) {
            this.Kp = System.currentTimeMillis();
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
                while (!this.Hs.kU().Le && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Ko = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.Hs.kU().Le) {
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
        this.Ko = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.KG = -1;
        try {
            String url = this.Hs.kT().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            dVar.KG = -2;
            this.Kl = c(a);
            dVar.KG = -3;
            System.currentTimeMillis();
            if (this.Kl == null) {
                throw new SocketException("network not available.");
            }
            this.Kl.setRequestMethod("POST");
            this.Kl.setDoOutput(true);
            this.Kl.setDoInput(true);
            this.Kl.setConnectTimeout(i2);
            this.Kl.setReadTimeout(i);
            this.Kl.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            this.Hs.kT().f(this.Kl);
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.KG = -4;
            this.Kl.connect();
            if (this.Km <= 0) {
                this.Km = System.currentTimeMillis();
            }
            this.Kn = System.currentTimeMillis();
            dVar.KG = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.Kv, 45000L);
            }
            dVar.KG = -6;
            this.Hs.kT().a(this.Kl, boundary, dVar);
            dVar.KG = -7;
            String contentType = this.Kl.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bO(contentType)) {
                this.Kl.disconnect();
                this.Kl.connect();
                if (this.Hs.kU().Le) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            dVar.KG = -8;
            this.Hs.kU().g(this.Kl);
            dVar.KF = this.Hs.kU().responseCode;
            dVar.downloadSize = this.Kl.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Kl);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.Hs.kU().downSize = e.length;
                this.Hs.kU().retBytes = c(this.Hs.kU().contentEncoding, e);
            }
            dVar.KD = new Date().getTime() - time;
            dVar.KG = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Kl);
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
            String url2 = this.Hs.kT().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.Kl = a(a, i2, i);
            if (this.Hs.kU().Le) {
                this.Ko = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Kl);
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
                this.Hs.kT().f(this.Kl);
                this.Kl.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Kl.connect();
                if (this.Km <= 0) {
                    this.Km = System.currentTimeMillis();
                }
                this.Kn = System.currentTimeMillis();
                int responseCode = this.Kl.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.Kl.getURL();
                    if (url3 != null) {
                        dVar2.redirectUrl = url3.toString();
                    }
                    if (url3 == null || TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.Kl);
                        this.Kl = a(new URL(url3.toString()), i2, i);
                        this.Hs.kT().f(this.Kl);
                        this.Kl.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Kl.connect();
                        i3 = this.Kl.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.Hs.kU().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.Kl.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.Hs.kU().responseCode == 200 && (headerField = this.Kl.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.Hs.kU().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.Ko = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.Kl);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.Kl.getContentType() != null && this.Kl.getContentType().contains("text/vnd.wap.wml")) {
                    this.Kl.disconnect();
                    this.Hs.kU().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.Ko = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.Kl);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.KC = url2.getBytes().length;
                    dVar2.downloadSize = this.Kl.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.Ko = System.currentTimeMillis();
                        this.Ko = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.Kl);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.Kl.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.onProgress((int) length, i5);
                        }
                        while (!this.Hs.kU().Le) {
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
                            dVar2.KQ = i6;
                            dVar2.KR = length;
                            dVar2.KS = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.Ko = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.Kl);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.Ko = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.Kl);
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
        return this.Hs.kU().responseCode == 200 || this.Hs.kU().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.KG = -1;
        try {
            String url = this.Hs.kT().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            dVar.KG = -2;
            this.Kl = c(a);
            dVar.KG = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Kl == null) {
                throw new SocketException("network not available.");
            }
            this.Kl.setRequestMethod("POST");
            this.Kl.setDoOutput(true);
            this.Kl.setDoInput(true);
            this.Kl.setConnectTimeout(i2);
            this.Kl.setReadTimeout(i);
            this.Kl.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            this.Hs.kT().f(this.Kl);
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.KG = -4;
            this.Kl.connect();
            if (this.Km <= 0) {
                this.Km = System.currentTimeMillis();
            }
            this.Kn = System.currentTimeMillis();
            dVar.KG = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            dVar.KG = -6;
            this.Hs.kT().a(this.Kl, dVar);
            dVar.KG = -7;
            if (this.Hs.kU().Le) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Kl.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bO(contentType)) {
                this.Kl.disconnect();
                this.Kl.connect();
                if (this.Hs.kU().Le) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.KG = -8;
            this.Hs.kU().g(this.Kl);
            dVar.KF = this.Hs.kU().responseCode;
            dVar.downloadSize = this.Kl.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Kl);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.Hs.kU().downSize = e.length;
                this.Hs.kU().retBytes = c(this.Hs.kU().contentEncoding, e);
            }
            dVar.KD = new Date().getTime() - currentTimeMillis;
            dVar.KG = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Kl);
        }
    }

    public void ah(int i) {
        this.Ku = i;
    }

    public void ai(boolean z) {
        this.Kt = z;
    }
}
