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
    private e Ki;
    private HttpURLConnection Ne;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Nf = 0;
    private long Ng = 0;
    private long firstByteReachTime = 0;
    private long Nh = 0;
    private long Ni = 0;
    private boolean Nj = false;
    private boolean Nk = true;
    private boolean Nl = true;
    private boolean Nm = true;
    private int Nn = 0;
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
    private TimerTask No = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.2
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                com.baidu.adp.lib.f.a.close(b.this.Ne);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer timer = new Timer();

    public long lJ() {
        return this.Ni;
    }

    public long lK() {
        return this.Nh;
    }

    public long lL() {
        return this.Nf;
    }

    public long lM() {
        return this.Ng;
    }

    public long lN() {
        return this.firstByteReachTime;
    }

    public boolean lO() {
        return this.Nj;
    }

    public void ae(boolean z) {
        this.Nl = z;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.Ki = eVar;
    }

    public void cancelNetConnect() {
        this.Ki.lV().Od = true;
        com.baidu.adp.lib.f.a.close(this.Ne);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a lI;
        Exception exc;
        URL url2 = new URL(str);
        if (!TextUtils.isEmpty(str) && this.Nl && this.Nm) {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult j = BDHttpDns.O(BdBaseApplication.getInst().getApplicationContext()).j(str2, true);
                    if (j != null) {
                        dVar.ND = j.sl();
                        dVar.NF = j.sm();
                        ArrayList<String> sn = j.sn();
                        if (sn != null && sn.size() > 0) {
                            dVar.NG = sn.toString();
                            int size = this.Nn % sn.size();
                            String str3 = sn.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                                this.Ki.lU().s("Host", str2);
                                URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.Nj = true;
                                    dVar.NH = size;
                                    dVar.NC = str3;
                                    dVar.Nj = this.Nj;
                                    return url3;
                                } catch (Exception e) {
                                    exc = e;
                                    url = url3;
                                    BdLog.e(exc);
                                    return !this.Nk ? url : url;
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
        if (!this.Nk && this.Nm && (lI = a.lI()) != null) {
            String bJ = lI.bJ(str);
            if (!TextUtils.isEmpty(bJ)) {
                this.Ki.lU().s("Host", url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + bJ));
                this.Nj = true;
                dVar.NC = bJ;
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
                            this.Ki.lU().s("X-Online-Host", url.getHost());
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
                if (this.Nj && url.getProtocol().equals("https")) {
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
        dVar.Ny = -1;
        if (this.Ki.lV().Od) {
            throw new BdHttpCancelException();
        }
        String c = this.Ki.lU().c(dVar);
        dVar.url = c;
        URL a2 = a(c, dVar);
        if (this.Ki.lV().Od) {
            throw new BdHttpCancelException();
        }
        dVar.Ny = -2;
        this.Ne = c(a2);
        dVar.Ny = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Ne == null) {
                throw new SocketException("network not available.");
            }
            this.Ne.setRequestMethod("GET");
            this.Ne.setConnectTimeout(i2);
            this.Ne.setReadTimeout(i);
            this.Ki.lU().d(this.Ne);
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = new Date().getTime() - currentTimeMillis;
            dVar.Ny = -4;
            this.Ne.connect();
            if (this.Nf <= 0) {
                this.Nf = System.currentTimeMillis();
            }
            this.Ng = System.currentTimeMillis();
            dVar.Ny = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.dnsTime;
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            if (this.Ki.lU().mc() && this.timer != null && this.Nn >= 0 && this.Nn < 3) {
                this.timer.schedule(this.No, (this.Nn + 1) * 3000);
            }
            String contentType = this.Ne.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bU(contentType)) {
                this.Ne.disconnect();
                this.Ne.connect();
                if (this.Ki.lV().Od) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Ny = -8;
            this.Ki.lV().e(this.Ne);
            if (c.contains("c.tieba.baidu.com") && (map = this.Ki.lV().Oe) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.NI = list.get(0);
                dVar.NJ = list.get(1);
            }
            if (this.Ki.lV().responseCode == 302 && (url = this.Ne.getURL()) != null) {
                dVar.redirectUrl = url.toString();
            }
            dVar.Nx = this.Ki.lV().responseCode;
            dVar.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
            if (this.timer != null) {
                this.timer.cancel();
            }
            byte[] c2 = c(this.Ne);
            if (c2 != null) {
                dVar.downloadSize += c2.length;
                this.Ki.lV().retBytes = d(this.Ki.lV().contentEncoding, c2);
            }
            dVar.Ny = -9;
            dVar.Nv = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            if (this.Ne != null) {
                this.Ne.disconnect();
            }
        }
    }

    protected final byte[] d(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.Ni = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Ni == 0) {
            this.Ni = System.currentTimeMillis();
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
                while (!this.Ki.lV().Od && (read = inputStream.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        this.Nh = System.currentTimeMillis();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.close(inputStream2);
                        throw th;
                    }
                }
                if (this.Ki.lV().Od) {
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
        this.Nh = System.currentTimeMillis();
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.close(inputStream);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Ny = -1;
        try {
            String url = this.Ki.lU().getUrl();
            dVar.url = url;
            URL a2 = a(url, dVar);
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            dVar.Ny = -2;
            this.Ne = c(a2);
            dVar.Ny = -3;
            System.currentTimeMillis();
            if (this.Ne == null) {
                throw new SocketException("network not available.");
            }
            this.Ne.setRequestMethod("POST");
            this.Ne.setDoOutput(true);
            this.Ne.setDoInput(true);
            this.Ne.setConnectTimeout(i2);
            this.Ne.setReadTimeout(i);
            this.Ne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            this.Ki.lU().d(this.Ne);
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.dnsTime = new Date().getTime() - time;
            dVar.Ny = -4;
            this.Ne.connect();
            if (this.Nf <= 0) {
                this.Nf = System.currentTimeMillis();
            }
            this.Ng = System.currentTimeMillis();
            dVar.Ny = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.dnsTime;
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.timerTask, 45000L);
            }
            dVar.Ny = -6;
            this.Ki.lU().a(this.Ne, boundary, dVar);
            dVar.Ny = -7;
            String contentType = this.Ne.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bU(contentType)) {
                this.Ne.disconnect();
                this.Ne.connect();
                if (this.Ki.lV().Od) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            dVar.Ny = -8;
            this.Ki.lV().e(this.Ne);
            dVar.Nx = this.Ki.lV().responseCode;
            dVar.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ne);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.Ki.lV().downSize = c.length;
                this.Ki.lV().retBytes = d(this.Ki.lV().contentEncoding, c);
            }
            dVar.Nv = new Date().getTime() - time;
            dVar.Ny = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.f.a.close(this.Ne);
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
            String url = this.Ki.lU().getUrl();
            dVar2.url = url;
            URL a2 = a(url, dVar2);
            this.Ne = a(a2, i2, i);
            if (this.Ki.lV().Od) {
                this.Nh = System.currentTimeMillis();
                com.baidu.adp.lib.f.a.close((InputStream) null);
                com.baidu.adp.lib.f.a.close(this.Ne);
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
                this.Ki.lU().d(this.Ne);
                this.Ne.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Ne.connect();
                if (this.Nf <= 0) {
                    this.Nf = System.currentTimeMillis();
                }
                this.Ng = System.currentTimeMillis();
                int responseCode = this.Ne.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                URL url2 = null;
                if (responseCode == 302) {
                    url2 = this.Ne.getURL();
                    if (url2 != null) {
                        dVar2.redirectUrl = url2.toString();
                    }
                    if (url2 != null && !TextUtils.equals(url2.getProtocol(), a2.getProtocol())) {
                        com.baidu.adp.lib.f.a.close(this.Ne);
                        this.Ne = a(new URL(url2.toString()), i2, i);
                        this.Ki.lU().d(this.Ne);
                        this.Ne.addRequestProperty(Headers.RANGE, "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Ne.connect();
                        responseCode = this.Ne.getResponseCode();
                        z3 = true;
                        this.Ki.lV().responseCode = responseCode;
                        i3 = 0;
                        headerField = this.Ne.getHeaderField(Headers.CONTENT_RANGE);
                        if (headerField != null && (indexOf = headerField.indexOf("/")) != -1) {
                            i3 = com.baidu.adp.lib.f.b.toInt(headerField.substring(indexOf + 1), 0);
                        }
                        int i4 = (i3 == 0 || this.Ki.lV().responseCode != 200 || (headerField2 = this.Ne.getHeaderField("Content-Length")) == null) ? i3 : com.baidu.adp.lib.f.b.toInt(headerField2, 0);
                        this.Ki.lV().contentLength = String.valueOf(i4);
                        if (isFileSegSuccess()) {
                            String str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + a2 + "-newUrl=" + url2;
                            } else if (responseCode == 416) {
                                if (i4 > 0 && i4 == length) {
                                    this.Nh = System.currentTimeMillis();
                                    com.baidu.adp.lib.f.a.close((InputStream) null);
                                    com.baidu.adp.lib.f.a.close(this.Ne);
                                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + i4;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.Ne.getContentType() != null && this.Ne.getContentType().contains("text/vnd.wap.wml")) {
                            this.Ne.disconnect();
                            this.Ki.lV().responseCode = 0;
                            boolean a3 = a(str, hVar, i, i2, z, dVar2, z2);
                            this.Nh = System.currentTimeMillis();
                            com.baidu.adp.lib.f.a.close((InputStream) null);
                            com.baidu.adp.lib.f.a.close(this.Ne);
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            return a3;
                        } else {
                            dVar2.Nu = url.getBytes().length;
                            dVar2.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
                            dVar2.downloadSize += i4;
                            if (i4 != 0 && length >= i4) {
                                this.Nh = System.currentTimeMillis();
                                this.Nh = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close((InputStream) null);
                                com.baidu.adp.lib.f.a.close(this.Ne);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                return true;
                            }
                            inputStream = this.Ne.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                int i5 = 0;
                                int i6 = i4 > 0 ? i4 / 50 : 0;
                                int i7 = 0;
                                if (hVar != null && length > 0) {
                                    hVar.onProgress((int) length, i4);
                                }
                                while (!this.Ki.lV().Od) {
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
                                    dVar2.NM = i5;
                                    dVar2.NN = length;
                                    dVar2.NP = i4;
                                    boolean z4 = ((long) i5) + length >= ((long) i4);
                                    this.Nh = System.currentTimeMillis();
                                    com.baidu.adp.lib.f.a.close(inputStream);
                                    com.baidu.adp.lib.f.a.close(this.Ne);
                                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                                    return z4;
                                } catch (Exception e2) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                this.Nh = System.currentTimeMillis();
                                com.baidu.adp.lib.f.a.close(inputStream);
                                com.baidu.adp.lib.f.a.close(this.Ne);
                                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                                throw th;
                            }
                        }
                    }
                }
                z3 = false;
                this.Ki.lV().responseCode = responseCode;
                i3 = 0;
                headerField = this.Ne.getHeaderField(Headers.CONTENT_RANGE);
                if (headerField != null) {
                    i3 = com.baidu.adp.lib.f.b.toInt(headerField.substring(indexOf + 1), 0);
                }
                if (i3 == 0) {
                }
                this.Ki.lV().contentLength = String.valueOf(i4);
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
        return this.Ki.lV().responseCode == 200 || this.Ki.lV().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Ny = -1;
        try {
            String url = this.Ki.lU().getUrl();
            dVar.url = url;
            URL a2 = a(url, dVar);
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            dVar.Ny = -2;
            this.Ne = c(a2);
            dVar.Ny = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Ne == null) {
                throw new SocketException("network not available.");
            }
            this.Ne.setRequestMethod("POST");
            this.Ne.setDoOutput(true);
            this.Ne.setDoInput(true);
            this.Ne.setConnectTimeout(i2);
            this.Ne.setReadTimeout(i);
            this.Ne.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            this.Ki.lU().d(this.Ne);
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            dVar.dnsTime = System.currentTimeMillis() - currentTimeMillis;
            dVar.Ny = -4;
            this.Ne.connect();
            if (this.Nf <= 0) {
                this.Nf = System.currentTimeMillis();
            }
            this.Ng = System.currentTimeMillis();
            dVar.Ny = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.dnsTime;
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            dVar.Ny = -6;
            this.Ki.lU().a(this.Ne, dVar);
            dVar.Ny = -7;
            if (this.Ki.lV().Od) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ne.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.bU(contentType)) {
                this.Ne.disconnect();
                this.Ne.connect();
                if (this.Ki.lV().Od) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Ny = -8;
            this.Ki.lV().e(this.Ne);
            dVar.Nx = this.Ki.lV().responseCode;
            dVar.downloadSize = this.Ne.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ne);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.Ki.lV().downSize = c.length;
                this.Ki.lV().retBytes = d(this.Ki.lV().contentEncoding, c);
            }
            dVar.Nv = new Date().getTime() - currentTimeMillis;
            dVar.Ny = -9;
        } finally {
            com.baidu.adp.lib.f.a.close(this.Ne);
        }
    }

    public void ar(int i) {
        this.Nn = i;
    }

    public void af(boolean z) {
        this.Nm = z;
    }
}
