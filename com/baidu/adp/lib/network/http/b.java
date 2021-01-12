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
    private e IQ;
    private HttpURLConnection LI;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long LJ = 0;
    private long LK = 0;
    private long firstByteReachTime = 0;
    private long LM = 0;
    private long LN = 0;
    private boolean LO = false;
    private boolean LQ = true;
    private boolean LR = true;
    private boolean LS = true;
    private int LU = 0;
    private TimerTask timerTask = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.cancelNetConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private TimerTask LV = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.2
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                com.baidu.adp.lib.f.a.close(b.this.LI);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer timer = new Timer();

    public long lK() {
        return this.LN;
    }

    public long lL() {
        return this.LM;
    }

    public long lM() {
        return this.LJ;
    }

    public long lN() {
        return this.LK;
    }

    public long lO() {
        return this.firstByteReachTime;
    }

    public boolean lP() {
        return this.LO;
    }

    public void ae(boolean z) {
        this.LR = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.IQ = eVar;
    }

    public void cancelNetConnect() {
        this.IQ.lW().MF = true;
        com.baidu.adp.lib.f.a.close(this.LI);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a lJ;
        Exception exc;
        URL url2 = new URL(str);
        if (!TextUtils.isEmpty(str) && this.LR && this.LS) {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.Mi = j.so();
                        dVar.Mj = j.sp();
                        ArrayList<String> sq = j.sq();
                        if (sq != null && sq.size() > 0) {
                            dVar.Mk = sq.toString();
                            int size = this.LU % sq.size();
                            String str3 = sq.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.IQ.lV().u("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.LO = true;
                                    dVar.Ml = size;
                                    dVar.Mh = str3;
                                    dVar.LO = this.LO;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.LQ ? url : url;
                                }
                            }
                        }
                    }
                }
                url = url2;
            } catch (Exception e2) {
                exc = e2;
                url = url2;
            }
        } else {
            url = url2;
        }
        if (!this.LQ && this.LS && (lJ = a.lJ()) != null) {
            String bF = lJ.bF(str);
            if (!TextUtils.isEmpty(bF)) {
                this.IQ.lV().u("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bF));
                this.LO = true;
                dVar.Mh = bF;
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
        Exception e;
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
                            this.IQ.lV().u("X-Online-Host", url.getHost());
                            httpsURLConnection = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            httpsURLConnection = httpURLConnection;
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
                if (this.LO && url.getProtocol().equals("https")) {
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
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void a(int i, int i2, d dVar) throws Exception {
        URL url;
        Map<String, List<String>> map;
        List<String> list;
        dVar.Mf = -1;
        if (this.IQ.lW().MF) {
            throw new BdHttpCancelException();
        }
        String c = this.IQ.lV().c(dVar);
        dVar.url = c;
        URL a2 = a(c, dVar);
        if (this.IQ.lW().MF) {
            throw new BdHttpCancelException();
        }
        dVar.Mf = -2;
        this.LI = c(a2);
        dVar.Mf = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.LI == null) {
                throw new SocketException("network not available.");
            }
            this.LI.setRequestMethod("GET");
            this.LI.setConnectTimeout(i2);
            this.LI.setReadTimeout(i);
            this.IQ.lV().d(this.LI);
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.Mf = -4;
            this.LI.connect();
            if (this.LJ <= 0) {
                this.LJ = System.currentTimeMillis();
            }
            this.LK = System.currentTimeMillis();
            dVar.Mf = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            if (this.IQ.lV().md() && this.timer != null && this.LU >= 0 && this.LU < 3) {
                this.timer.schedule(this.LV, (this.LU + 1) * 3000);
            }
            String contentType = this.LI.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bQ(contentType)) {
                this.LI.disconnect();
                this.LI.connect();
                if (this.IQ.lW().MF) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Mf = -8;
            this.IQ.lW().e(this.LI);
            if (c.contains("c.tieba.baidu.com") && (map = this.IQ.lW().MG) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.Mm = list.get(0);
                dVar.Mn = list.get(1);
            }
            if (this.IQ.lW().responseCode == 302 && (url = this.LI.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.Me = this.IQ.lW().responseCode;
            dVar.downloadSize = this.LI.getHeaderFields().toString().getBytes().length;
            if (this.timer != null) {
                this.timer.cancel();
            }
            byte[] c2 = c(this.LI);
            if (c2 != null) {
                dVar.downloadSize += c2.length;
                this.IQ.lW().retBytes = e(this.IQ.lW().contentEncoding, c2);
            }
            dVar.Mf = -9;
            dVar.Mc = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            if (this.LI != null) {
                this.LI.disconnect();
            }
        }
    }

    protected final byte[] e(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.LN = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.LN == 0) {
            this.LN = System.currentTimeMillis();
            return bArr;
        } else {
            return bArr;
        }
    }

    private byte[] c(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream;
        byte[] bArr;
        Throwable th;
        InputStream inputStream2;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                inputStream = httpURLConnection.getInputStream();
                while (!this.IQ.lW().MF && (read = inputStream.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        this.LM = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream2);
                        throw th;
                    }
                }
                if (this.IQ.lW().MF) {
                    throw new BdHttpCancelException();
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = null;
            }
        } else {
            inputStream = null;
            bArr = null;
        }
        this.LM = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Mf = -1;
        try {
            String url = this.IQ.lV().getUrl();
            dVar.url = url;
            URL a2 = a(url, dVar);
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            dVar.Mf = -2;
            this.LI = c(a2);
            dVar.Mf = -3;
            System.currentTimeMillis();
            if (this.LI == null) {
                throw new SocketException("network not available.");
            }
            this.LI.setRequestMethod("POST");
            this.LI.setDoOutput(true);
            this.LI.setDoInput(true);
            this.LI.setConnectTimeout(i2);
            this.LI.setReadTimeout(i);
            this.LI.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            this.IQ.lV().d(this.LI);
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.Mf = -4;
            this.LI.connect();
            if (this.LJ <= 0) {
                this.LJ = System.currentTimeMillis();
            }
            this.LK = System.currentTimeMillis();
            dVar.Mf = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.timerTask, 45000L);
            }
            dVar.Mf = -6;
            this.IQ.lV().a(this.LI, boundary, dVar);
            dVar.Mf = -7;
            String contentType = this.LI.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bQ(contentType)) {
                this.LI.disconnect();
                this.LI.connect();
                if (this.IQ.lW().MF) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            dVar.Mf = -8;
            this.IQ.lW().e(this.LI);
            dVar.Me = this.IQ.lW().responseCode;
            dVar.downloadSize = this.LI.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.LI);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.IQ.lW().downSize = c.length;
                this.IQ.lW().retBytes = e(this.IQ.lW().contentEncoding, c);
            }
            dVar.Mc = new Date().getTime() - time;
            dVar.Mf = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.LI);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=8, 810=6, 811=6, 812=6] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x026d A[Catch: all -> 0x021f, TryCatch #4 {all -> 0x021f, blocks: (B:23:0x008d, B:25:0x00d6, B:26:0x00de, B:28:0x00fc, B:30:0x0106, B:32:0x010e, B:34:0x011c, B:35:0x0183, B:37:0x019b, B:39:0x01a8, B:41:0x01b5, B:43:0x01c3, B:45:0x01d0, B:46:0x01d6, B:52:0x01f6, B:53:0x0219, B:54:0x021e, B:65:0x024b, B:66:0x026d, B:68:0x0277, B:70:0x0289, B:72:0x02c4, B:74:0x02e8, B:76:0x02ed, B:78:0x030d), top: B:126:0x008d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        boolean z3;
        int i3;
        String headerField;
        String headerField2;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url = this.IQ.lV().getUrl();
            dVar2.url = url;
            URL a2 = a(url, dVar2);
            this.LI = a(a2, i2, i);
            if (this.IQ.lW().MF) {
                this.LM = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.LI);
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
                this.IQ.lV().d(this.LI);
                this.LI.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.LI.connect();
                if (this.LJ <= 0) {
                    this.LJ = System.currentTimeMillis();
                }
                this.LK = System.currentTimeMillis();
                int responseCode = this.LI.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                URL url2 = null;
                if (responseCode == 302) {
                    url2 = this.LI.getURL();
                    if (url2 != null) {
                        dVar2.redirectUrl = url2.toString();
                    }
                    if (url2 != null && !TextUtils.equals(url2.getProtocol(), a2.getProtocol())) {
                        com.baidu.adp.lib.f.a.close(this.LI);
                        this.LI = a(new URL(url2.toString()), i2, i);
                        this.IQ.lV().d(this.LI);
                        this.LI.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.LI.connect();
                        responseCode = this.LI.getResponseCode();
                        z3 = true;
                        this.IQ.lW().responseCode = responseCode;
                        i3 = 0;
                        headerField = this.LI.getHeaderField(Headers.CONTENT_RANGE);
                        if (headerField != null && (indexOf = headerField.indexOf("/")) != -1) {
                            i3 = com.baidu.adp.lib.f.b.toInt(headerField.substring(indexOf + 1), 0);
                        }
                        int i4 = (i3 == 0 || this.IQ.lW().responseCode != 200 || (headerField2 = this.LI.getHeaderField("Content-Length")) == null) ? i3 : com.baidu.adp.lib.f.b.toInt(headerField2, 0);
                        this.IQ.lW().contentLength = String.valueOf(i4);
                        if (isFileSegSuccess()) {
                            String str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + a2 + "-newUrl=" + url2;
                            } else if (responseCode == 416) {
                                if (i4 > 0 && i4 == length) {
                                    this.LM = System.currentTimeMillis();
                                    com.baidu.adp.lib.f.a.close((InputStream) null);
                                    com.baidu.adp.lib.f.a.close(this.LI);
                                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + i4;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.LI.getContentType() != null && this.LI.getContentType().contains("text/vnd.wap.wml")) {
                            this.LI.disconnect();
                            this.IQ.lW().responseCode = 0;
                            boolean a3 = a(str, hVar, i, i2, z, dVar2, z2);
                            this.LM = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.LI);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return a3;
                        } else {
                            dVar2.Mb = url.getBytes().length;
                            dVar2.downloadSize = this.LI.getHeaderFields().toString().getBytes().length;
                            dVar2.downloadSize += i4;
                            if (i4 != 0 && length >= i4) {
                                this.LM = System.currentTimeMillis();
                                this.LM = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close((InputStream) null);
                                com.baidu.adp.lib.f.a.close(this.LI);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return true;
                            }
                            inputStream = this.LI.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                int i5 = 0;
                                int i6 = i4 > 0 ? i4 / 50 : 0;
                                int i7 = 0;
                                if (hVar != null && length > 0) {
                                    hVar.onProgress((int) length, i4);
                                }
                                while (!this.IQ.lW().MF) {
                                    int read = inputStream.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream2.write(bArr, 0, read);
                                            i5 += read;
                                            i7 += read;
                                            if (hVar != null && (i7 > i6 || i5 == i4)) {
                                                i7 = 0;
                                                hVar.onProgress((int) (i5 + length), i4);
                                            }
                                        } catch (Exception e) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream2.flush();
                                    dVar2.Mp = i5;
                                    dVar2.Mq = length;
                                    dVar2.Mr = i4;
                                    boolean z4 = ((long) i5) + length >= ((long) i4);
                                    this.LM = System.currentTimeMillis();
                                    com.baidu.adp.lib.f.a.close(inputStream);
                                    com.baidu.adp.lib.f.a.close(this.LI);
                                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                    return z4;
                                } catch (Exception e2) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                this.LM = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream);
                                com.baidu.adp.lib.f.a.close(this.LI);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                                throw th;
                            }
                        }
                    }
                }
                z3 = false;
                this.IQ.lW().responseCode = responseCode;
                i3 = 0;
                headerField = this.LI.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField != null) {
                    i3 = com.baidu.adp.lib.f.b.toInt(headerField.substring(indexOf + 1), 0);
                }
                if (i3 == 0) {
                }
                this.IQ.lW().contentLength = String.valueOf(i4);
                if (isFileSegSuccess()) {
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
        return this.IQ.lW().responseCode == 200 || this.IQ.lW().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Mf = -1;
        try {
            String url = this.IQ.lV().getUrl();
            dVar.url = url;
            URL a2 = a(url, dVar);
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            dVar.Mf = -2;
            this.LI = c(a2);
            dVar.Mf = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.LI == null) {
                throw new SocketException("network not available.");
            }
            this.LI.setRequestMethod("POST");
            this.LI.setDoOutput(true);
            this.LI.setDoInput(true);
            this.LI.setConnectTimeout(i2);
            this.LI.setReadTimeout(i);
            this.LI.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            this.IQ.lV().d(this.LI);
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.Mf = -4;
            this.LI.connect();
            if (this.LJ <= 0) {
                this.LJ = System.currentTimeMillis();
            }
            this.LK = System.currentTimeMillis();
            dVar.Mf = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            dVar.Mf = -6;
            this.IQ.lV().a(this.LI, dVar);
            dVar.Mf = -7;
            if (this.IQ.lW().MF) {
                throw new BdHttpCancelException();
            }
            String contentType = this.LI.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bQ(contentType)) {
                this.LI.disconnect();
                this.LI.connect();
                if (this.IQ.lW().MF) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Mf = -8;
            this.IQ.lW().e(this.LI);
            dVar.Me = this.IQ.lW().responseCode;
            dVar.downloadSize = this.LI.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.LI);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.IQ.lW().downSize = c.length;
                this.IQ.lW().retBytes = e(this.IQ.lW().contentEncoding, c);
            }
            dVar.Mc = new Date().getTime() - currentTimeMillis;
            dVar.Mf = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.LI);
        }
    }

    public void ar(int i) {
        this.LU = i;
    }

    public void af(boolean z) {
        this.LS = z;
    }
}
