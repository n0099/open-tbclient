package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e lJ;
    private HttpURLConnection oG;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long oH = 0;
    private long oI = 0;
    private long firstByteReachTime = 0;
    private long oJ = 0;
    private long oK = 0;
    private boolean oL = false;
    private boolean oM = true;
    private boolean oN = false;
    private TimerTask oO = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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

    public long fy() {
        return this.oK;
    }

    public long fz() {
        return this.oJ;
    }

    public long fA() {
        return this.oH;
    }

    public long fB() {
        return this.oI;
    }

    public long fC() {
        return this.firstByteReachTime;
    }

    public boolean fD() {
        return this.oL;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.lJ = eVar;
    }

    public void cancelNetConnect() {
        this.lJ.fK().pz = true;
        com.baidu.adp.lib.g.a.close(this.oG);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a fx;
        Exception exc;
        ArrayList<String> lA;
        URL url2 = new URL(str);
        if (TextUtils.isEmpty(str) || !this.lJ.fJ().fQ()) {
            url = url2;
        } else {
            try {
                String host = url2.getHost();
                if (!TextUtils.isEmpty(host)) {
                    String str2 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                    BDHttpDnsResult e = BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).e(str2, true);
                    if (e != null && (lA = e.lA()) != null && !lA.isEmpty()) {
                        String str3 = lA.get(0);
                        if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url2.getProtocol().equals("https"))) {
                            this.lJ.fJ().l(HTTP.TARGET_HOST, str2);
                            URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                            try {
                                this.oL = true;
                                dVar.pd = str3;
                                dVar.pe = e.ly();
                                dVar.oL = this.oL;
                                return url3;
                            } catch (Exception e2) {
                                exc = e2;
                                url = url3;
                                BdLog.e(exc);
                                return !this.oM ? url : url;
                            }
                        }
                    }
                }
                url = url2;
            } catch (Exception e3) {
                url = url2;
                exc = e3;
            }
        }
        if (!this.oM && (fx = a.fx()) != null) {
            String ag = fx.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.lJ.fJ().l(HTTP.TARGET_HOST, url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.oL = true;
                dVar.pd = ag;
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
                            this.lJ.fJ().l("X-Online-Host", url.getHost());
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
                if (this.oL && url.getProtocol().equals("https")) {
                    final HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new i(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.adp.lib.network.http.b.2
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str, SSLSession sSLSession) {
                            String requestProperty = httpsURLConnection2.getRequestProperty(HTTP.TARGET_HOST);
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
        dVar.oZ = -1;
        if (this.lJ.fK().pz) {
            throw new BdHttpCancelException();
        }
        String c = this.lJ.fJ().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.lJ.fK().pz) {
            throw new BdHttpCancelException();
        }
        dVar.oZ = -2;
        this.oG = c(a);
        dVar.oZ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.oG == null) {
                throw new SocketException("network not available.");
            }
            this.oG.setRequestMethod("GET");
            this.oG.setConnectTimeout(i2);
            this.oG.setReadTimeout(i);
            this.lJ.fJ().d(this.oG);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            dVar.oX = new Date().getTime() - currentTimeMillis;
            dVar.oZ = -4;
            this.oG.connect();
            if (this.oH <= 0) {
                this.oH = System.currentTimeMillis();
            }
            this.oI = System.currentTimeMillis();
            dVar.oZ = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.oX;
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oG.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.al(contentType)) {
                this.oG.disconnect();
                this.oG.connect();
                if (this.lJ.fK().pz) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.oZ = -8;
            this.lJ.fK().e(this.oG);
            if (c.contains("c.tieba.baidu.com") && (map = this.lJ.fK().pA) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.pf = list.get(0);
                dVar.pg = list.get(1);
            }
            dVar.oY = this.lJ.fK().responseCode;
            dVar.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.oG);
            if (c2 != null) {
                dVar.downloadSize += c2.length;
                this.lJ.fK().retBytes = c(this.lJ.fK().contentEncoding, c2);
            }
            dVar.oZ = -9;
            dVar.oU = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.oG != null) {
                this.oG.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.oK = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.oK == 0) {
            this.oK = System.currentTimeMillis();
            return bArr;
        } else {
            return bArr;
        }
    }

    private byte[] c(HttpURLConnection httpURLConnection) throws Exception {
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
                while (!this.lJ.fK().pz && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.lJ.fK().pz) {
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
        this.oJ = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.oZ = -1;
        try {
            String url = this.lJ.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            dVar.oZ = -2;
            this.oG = c(a);
            dVar.oZ = -3;
            System.currentTimeMillis();
            if (this.oG == null) {
                throw new SocketException("network not available.");
            }
            this.oG.setRequestMethod("POST");
            this.oG.setDoOutput(true);
            this.oG.setDoInput(true);
            this.oG.setConnectTimeout(i2);
            this.oG.setReadTimeout(i);
            this.oG.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            this.lJ.fJ().d(this.oG);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.oX = new Date().getTime() - time;
            dVar.oZ = -4;
            this.oG.connect();
            if (this.oH <= 0) {
                this.oH = System.currentTimeMillis();
            }
            this.oI = System.currentTimeMillis();
            dVar.oZ = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.oX;
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.oO, 45000L);
            }
            dVar.oZ = -6;
            this.lJ.fJ().a(this.oG, boundary, dVar);
            dVar.oZ = -7;
            String contentType = this.oG.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.al(contentType)) {
                this.oG.disconnect();
                this.oG.connect();
                if (this.lJ.fK().pz) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            dVar.oZ = -8;
            this.lJ.fK().e(this.oG);
            dVar.oY = this.lJ.fK().responseCode;
            dVar.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oG);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.lJ.fK().downSize = c.length;
                this.lJ.fK().retBytes = c(this.lJ.fK().contentEncoding, c);
            }
            dVar.oU = new Date().getTime() - time;
            dVar.oZ = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.g.a.close(this.oG);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [768=7, 769=5, 770=5, 771=5] */
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
            String url2 = this.lJ.fJ().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.oG = a(a, i2, i);
            if (this.lJ.fK().pz) {
                this.oJ = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.close((InputStream) null);
                com.baidu.adp.lib.g.a.close(this.oG);
                com.baidu.adp.lib.g.a.close((OutputStream) null);
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
                this.lJ.fJ().d(this.oG);
                this.oG.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.oG.connect();
                if (this.oH <= 0) {
                    this.oH = System.currentTimeMillis();
                }
                this.oI = System.currentTimeMillis();
                int responseCode = this.oG.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.oG.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.g.a.close(this.oG);
                        this.oG = a(new URL(url3.toString()), i2, i);
                        this.lJ.fJ().d(this.oG);
                        this.oG.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.oG.connect();
                        i3 = this.oG.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.lJ.fK().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.oG.getHeaderField("Content-Range");
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.g.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.lJ.fK().responseCode == 200 && (headerField = this.oG.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.toInt(headerField, 0) : i4;
                this.lJ.fK().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        String str3 = "fileLen=" + length + "-contentLen=" + i5;
                        if (str != null && str.contains("plugin")) {
                            this.oN = true;
                            com.baidu.adp.lib.util.f.delFile(str);
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err", "", 1, new Object[0]);
                        }
                        str2 = str3;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.oG.getContentType() != null && this.oG.getContentType().contains("text/vnd.wap.wml")) {
                    this.oG.disconnect();
                    this.lJ.fK().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.oJ = System.currentTimeMillis();
                    com.baidu.adp.lib.g.a.close((InputStream) null);
                    com.baidu.adp.lib.g.a.close(this.oG);
                    com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.oT = url2.getBytes().length;
                    dVar2.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.oJ = System.currentTimeMillis();
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oG);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.oG.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = i5 > 0 ? i5 / 50 : 0;
                        if (hVar != null && length > 0) {
                            hVar.j((int) length, i5);
                        }
                        if (this.oN) {
                            this.oN = false;
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err_ok", "", 1, new Object[0]);
                        }
                        int i7 = 0;
                        int i8 = 0;
                        while (!this.lJ.fK().pz) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i8 += read;
                                    i7 += read;
                                    if (hVar != null && (i7 > i6 || i8 == i5)) {
                                        i7 = 0;
                                        hVar.j((int) (i8 + length), i5);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            boolean z4 = ((long) i8) + length >= ((long) i5);
                            this.oJ = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.close(inputStream2);
                            com.baidu.adp.lib.g.a.close(this.oG);
                            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        inputStream = inputStream2;
                        this.oJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close(inputStream);
                        com.baidu.adp.lib.g.a.close(this.oG);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream);
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
        return this.lJ.fK().responseCode == 200 || this.lJ.fK().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.oZ = -1;
        try {
            String url = this.lJ.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            dVar.oZ = -2;
            this.oG = c(a);
            dVar.oZ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.oG == null) {
                throw new SocketException("network not available.");
            }
            this.oG.setRequestMethod("POST");
            this.oG.setDoOutput(true);
            this.oG.setDoInput(true);
            this.oG.setConnectTimeout(i2);
            this.oG.setReadTimeout(i);
            this.oG.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            this.lJ.fJ().d(this.oG);
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            dVar.oX = System.currentTimeMillis() - currentTimeMillis;
            dVar.oZ = -4;
            this.oG.connect();
            if (this.oH <= 0) {
                this.oH = System.currentTimeMillis();
            }
            this.oI = System.currentTimeMillis();
            dVar.oZ = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.oX;
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            dVar.oZ = -6;
            this.lJ.fJ().a(this.oG, dVar);
            dVar.oZ = -7;
            if (this.lJ.fK().pz) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oG.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.al(contentType)) {
                this.oG.disconnect();
                this.oG.connect();
                if (this.lJ.fK().pz) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.oZ = -8;
            this.lJ.fK().e(this.oG);
            dVar.oY = this.lJ.fK().responseCode;
            dVar.downloadSize = this.oG.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oG);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.lJ.fK().downSize = c.length;
                this.lJ.fK().retBytes = c(this.lJ.fK().contentEncoding, c);
            }
            dVar.oU = new Date().getTime() - currentTimeMillis;
            dVar.oZ = -9;
        } finally {
            com.baidu.adp.lib.g.a.close(this.oG);
        }
    }
}
