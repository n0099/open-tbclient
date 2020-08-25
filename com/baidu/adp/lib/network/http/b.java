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
    private e HX;
    private HttpURLConnection KP;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long KQ = 0;
    private long KR = 0;
    private long firstByteReachTime = 0;
    private long KS = 0;
    private long KT = 0;
    private boolean KU = false;
    private boolean KV = true;
    private boolean KW = true;
    private boolean KX = true;
    private int KY = 0;
    private TimerTask KZ = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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

    public long mh() {
        return this.KT;
    }

    public long mi() {
        return this.KS;
    }

    public long mj() {
        return this.KQ;
    }

    public long mk() {
        return this.KR;
    }

    public long ml() {
        return this.firstByteReachTime;
    }

    public boolean mm() {
        return this.KU;
    }

    public void ai(boolean z) {
        this.KW = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.HX = eVar;
    }

    public void cancelNetConnect() {
        this.HX.mt().LJ = true;
        com.baidu.adp.lib.f.a.close(this.KP);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a mg;
        Exception exc;
        URL url2 = new URL(str);
        if (!TextUtils.isEmpty(str) && this.KW && this.KX) {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.Lm = j.sR();
                        dVar.Ln = j.sS();
                        ArrayList<String> sT = j.sT();
                        if (sT != null && sT.size() > 0) {
                            dVar.Lo = sT.toString();
                            int size = this.KY % sT.size();
                            String str3 = sT.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.HX.ms().u("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.KU = true;
                                    dVar.Lp = size;
                                    dVar.Ll = str3;
                                    dVar.KU = this.KU;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.KV ? url : url;
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
        if (!this.KV && this.KX && (mg = a.mg()) != null) {
            String bG = mg.bG(str);
            if (!TextUtils.isEmpty(bG)) {
                this.HX.ms().u("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bG));
                this.KU = true;
                dVar.Ll = bG;
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
                            this.HX.ms().u("X-Online-Host", url.getHost());
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
                if (this.KU && url.getProtocol().equals("https")) {
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
        dVar.Lj = -1;
        if (this.HX.mt().LJ) {
            throw new BdHttpCancelException();
        }
        String c = this.HX.ms().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.HX.mt().LJ) {
            throw new BdHttpCancelException();
        }
        dVar.Lj = -2;
        this.KP = c(a);
        dVar.Lj = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.KP == null) {
                throw new SocketException("network not available.");
            }
            this.KP.setRequestMethod("GET");
            this.KP.setConnectTimeout(i2);
            this.KP.setReadTimeout(i);
            this.HX.ms().f(this.KP);
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.Lj = -4;
            this.KP.connect();
            if (this.KQ <= 0) {
                this.KQ = System.currentTimeMillis();
            }
            this.KR = System.currentTimeMillis();
            dVar.Lj = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.KP.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bR(contentType)) {
                this.KP.disconnect();
                this.KP.connect();
                if (this.HX.mt().LJ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Lj = -8;
            this.HX.mt().g(this.KP);
            if (c.contains("c.tieba.baidu.com") && (map = this.HX.mt().LK) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.Lq = list.get(0);
                dVar.Lr = list.get(1);
            }
            if (this.HX.mt().responseCode == 302 && (url = this.KP.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.Li = this.HX.mt().responseCode;
            dVar.downloadSize = this.KP.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.KP);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.HX.mt().retBytes = c(this.HX.mt().contentEncoding, e);
            }
            dVar.Lj = -9;
            dVar.Lg = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.KP != null) {
                this.KP.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.KT = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.KT == 0) {
            this.KT = System.currentTimeMillis();
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
                while (!this.HX.mt().LJ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.KS = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.HX.mt().LJ) {
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
        this.KS = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Lj = -1;
        try {
            String url = this.HX.ms().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            dVar.Lj = -2;
            this.KP = c(a);
            dVar.Lj = -3;
            System.currentTimeMillis();
            if (this.KP == null) {
                throw new SocketException("network not available.");
            }
            this.KP.setRequestMethod("POST");
            this.KP.setDoOutput(true);
            this.KP.setDoInput(true);
            this.KP.setConnectTimeout(i2);
            this.KP.setReadTimeout(i);
            this.KP.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            this.HX.ms().f(this.KP);
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.Lj = -4;
            this.KP.connect();
            if (this.KQ <= 0) {
                this.KQ = System.currentTimeMillis();
            }
            this.KR = System.currentTimeMillis();
            dVar.Lj = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.KZ, 45000L);
            }
            dVar.Lj = -6;
            this.HX.ms().a(this.KP, boundary, dVar);
            dVar.Lj = -7;
            String contentType = this.KP.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bR(contentType)) {
                this.KP.disconnect();
                this.KP.connect();
                if (this.HX.mt().LJ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            dVar.Lj = -8;
            this.HX.mt().g(this.KP);
            dVar.Li = this.HX.mt().responseCode;
            dVar.downloadSize = this.KP.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.KP);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.HX.mt().downSize = e.length;
                this.HX.mt().retBytes = c(this.HX.mt().contentEncoding, e);
            }
            dVar.Lg = new Date().getTime() - time;
            dVar.Lj = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.KP);
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
            String url2 = this.HX.ms().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.KP = a(a, i2, i);
            if (this.HX.mt().LJ) {
                this.KS = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.KP);
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
                this.HX.ms().f(this.KP);
                this.KP.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.KP.connect();
                if (this.KQ <= 0) {
                    this.KQ = System.currentTimeMillis();
                }
                this.KR = System.currentTimeMillis();
                int responseCode = this.KP.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.KP.getURL();
                    if (url3 != null) {
                        dVar2.redirectUrl = url3.toString();
                    }
                    if (url3 == null || TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.f.a.close(this.KP);
                        this.KP = a(new URL(url3.toString()), i2, i);
                        this.HX.ms().f(this.KP);
                        this.KP.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.KP.connect();
                        i3 = this.KP.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.HX.mt().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.KP.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.f.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.HX.mt().responseCode == 200 && (headerField = this.KP.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : i4;
                this.HX.mt().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        if (i5 > 0 && i5 == length) {
                            this.KS = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.KP);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return false;
                        }
                        str2 = "fileLen=" + length + "-contentLen=" + i5;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.KP.getContentType() != null && this.KP.getContentType().contains("text/vnd.wap.wml")) {
                    this.KP.disconnect();
                    this.HX.mt().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.KS = System.currentTimeMillis();
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close(this.KP);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.Lf = url2.getBytes().length;
                    dVar2.downloadSize = this.KP.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.KS = System.currentTimeMillis();
                        this.KS = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((InputStream) null);
                        com.baidu.adp.lib.f.a.close(this.KP);
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.KP.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = 0;
                        int i7 = i5 > 0 ? i5 / 50 : 0;
                        int i8 = 0;
                        if (hVar != null && length > 0) {
                            hVar.onProgress((int) length, i5);
                        }
                        while (!this.HX.mt().LJ) {
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
                            dVar2.Lt = i6;
                            dVar2.Lu = length;
                            dVar2.Lv = i5;
                            boolean z4 = ((long) i6) + length >= ((long) i5);
                            this.KS = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close(inputStream2);
                            com.baidu.adp.lib.f.a.close(this.KP);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        this.KS = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close(this.KP);
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
        return this.HX.mt().responseCode == 200 || this.HX.mt().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Lj = -1;
        try {
            String url = this.HX.ms().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            dVar.Lj = -2;
            this.KP = c(a);
            dVar.Lj = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.KP == null) {
                throw new SocketException("network not available.");
            }
            this.KP.setRequestMethod("POST");
            this.KP.setDoOutput(true);
            this.KP.setDoInput(true);
            this.KP.setConnectTimeout(i2);
            this.KP.setReadTimeout(i);
            this.KP.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            this.HX.ms().f(this.KP);
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.Lj = -4;
            this.KP.connect();
            if (this.KQ <= 0) {
                this.KQ = System.currentTimeMillis();
            }
            this.KR = System.currentTimeMillis();
            dVar.Lj = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            dVar.Lj = -6;
            this.HX.ms().a(this.KP, dVar);
            dVar.Lj = -7;
            if (this.HX.mt().LJ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.KP.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bR(contentType)) {
                this.KP.disconnect();
                this.KP.connect();
                if (this.HX.mt().LJ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Lj = -8;
            this.HX.mt().g(this.KP);
            dVar.Li = this.HX.mt().responseCode;
            dVar.downloadSize = this.KP.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.KP);
            if (e != null) {
                dVar.downloadSize += e.length;
                this.HX.mt().downSize = e.length;
                this.HX.mt().retBytes = c(this.HX.mt().contentEncoding, e);
            }
            dVar.Lg = new Date().getTime() - currentTimeMillis;
            dVar.Lj = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.KP);
        }
    }

    public void al(int i) {
        this.KY = i;
    }

    public void aj(boolean z) {
        this.KX = z;
    }
}
