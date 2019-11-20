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
    private e lh;
    private HttpURLConnection oe;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long of = 0;
    private long og = 0;
    private long firstByteReachTime = 0;
    private long oh = 0;
    private long oi = 0;
    private boolean oj = false;
    private boolean ol = true;
    private boolean om = false;
    private TimerTask on = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
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
        return this.oi;
    }

    public long fz() {
        return this.oh;
    }

    public long fA() {
        return this.of;
    }

    public long fB() {
        return this.og;
    }

    public long fC() {
        return this.firstByteReachTime;
    }

    public boolean fD() {
        return this.oj;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.lh = eVar;
    }

    public void cancelNetConnect() {
        this.lh.fK().oT = true;
        com.baidu.adp.lib.g.a.close(this.oe);
    }

    private URL a(String str, d dVar) throws Exception {
        URL url;
        a fx;
        Exception exc;
        ArrayList<String> lA;
        URL url2 = new URL(str);
        if (TextUtils.isEmpty(str) || !this.lh.fJ().fQ()) {
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
                            this.lh.fJ().l(HTTP.TARGET_HOST, str2);
                            URL url3 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                            try {
                                this.oj = true;
                                dVar.oC = str3;
                                dVar.oD = e.ly();
                                dVar.oj = this.oj;
                                return url3;
                            } catch (Exception e2) {
                                exc = e2;
                                url = url3;
                                BdLog.e(exc);
                                return !this.ol ? url : url;
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
        if (!this.ol && (fx = a.fx()) != null) {
            String ag = fx.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.lh.fJ().l(HTTP.TARGET_HOST, url.getHost());
                URL url4 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.oj = true;
                dVar.oC = ag;
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
                            this.lh.fJ().l("X-Online-Host", url.getHost());
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
                if (this.oj && url.getProtocol().equals("https")) {
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
        dVar.oA = -1;
        if (this.lh.fK().oT) {
            throw new BdHttpCancelException();
        }
        String c = this.lh.fJ().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.lh.fK().oT) {
            throw new BdHttpCancelException();
        }
        dVar.oA = -2;
        this.oe = c(a);
        dVar.oA = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.oe == null) {
                throw new SocketException("network not available.");
            }
            this.oe.setRequestMethod("GET");
            this.oe.setConnectTimeout(i2);
            this.oe.setReadTimeout(i);
            this.lh.fJ().d(this.oe);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            dVar.oy = new Date().getTime() - currentTimeMillis;
            dVar.oA = -4;
            this.oe.connect();
            if (this.of <= 0) {
                this.of = System.currentTimeMillis();
            }
            this.og = System.currentTimeMillis();
            dVar.oA = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.oy;
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oe.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.al(contentType)) {
                this.oe.disconnect();
                this.oe.connect();
                if (this.lh.fK().oT) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.oA = -8;
            this.lh.fK().e(this.oe);
            if (c.contains("c.tieba.baidu.com") && (map = this.lh.fK().oU) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.oE = list.get(0);
                dVar.oF = list.get(1);
            }
            dVar.oz = this.lh.fK().responseCode;
            dVar.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.oe);
            if (c2 != null) {
                dVar.downloadSize += c2.length;
                this.lh.fK().retBytes = c(this.lh.fK().contentEncoding, c2);
            }
            dVar.oA = -9;
            dVar.ov = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.oe != null) {
                this.oe.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream);
            this.oi = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.oi == 0) {
            this.oi = System.currentTimeMillis();
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
                while (!this.lh.fK().oT && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.close(inputStream);
                        throw th;
                    }
                }
                if (this.lh.fK().oT) {
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
        this.oh = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.close(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.oA = -1;
        try {
            String url = this.lh.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            dVar.oA = -2;
            this.oe = c(a);
            dVar.oA = -3;
            System.currentTimeMillis();
            if (this.oe == null) {
                throw new SocketException("network not available.");
            }
            this.oe.setRequestMethod("POST");
            this.oe.setDoOutput(true);
            this.oe.setDoInput(true);
            this.oe.setConnectTimeout(i2);
            this.oe.setReadTimeout(i);
            this.oe.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            this.lh.fJ().d(this.oe);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.oy = new Date().getTime() - time;
            dVar.oA = -4;
            this.oe.connect();
            if (this.of <= 0) {
                this.of = System.currentTimeMillis();
            }
            this.og = System.currentTimeMillis();
            dVar.oA = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.oy;
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            if (this.timer != null) {
                this.timer.schedule(this.on, 45000L);
            }
            dVar.oA = -6;
            this.lh.fJ().a(this.oe, boundary, dVar);
            dVar.oA = -7;
            String contentType = this.oe.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.al(contentType)) {
                this.oe.disconnect();
                this.oe.connect();
                if (this.lh.fK().oT) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            dVar.oA = -8;
            this.lh.fK().e(this.oe);
            dVar.oz = this.lh.fK().responseCode;
            dVar.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oe);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.lh.fK().downSize = c.length;
                this.lh.fK().retBytes = c(this.lh.fK().contentEncoding, c);
            }
            dVar.ov = new Date().getTime() - time;
            dVar.oA = -9;
        } finally {
            if (this.timer != null) {
                this.timer.cancel();
            }
            com.baidu.adp.lib.g.a.close(this.oe);
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
            String url2 = this.lh.fJ().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.oe = a(a, i2, i);
            if (this.lh.fK().oT) {
                this.oh = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.close((InputStream) null);
                com.baidu.adp.lib.g.a.close(this.oe);
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
                this.lh.fJ().d(this.oe);
                this.oe.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.oe.connect();
                if (this.of <= 0) {
                    this.of = System.currentTimeMillis();
                }
                this.og = System.currentTimeMillis();
                int responseCode = this.oe.getResponseCode();
                this.firstByteReachTime = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.oe.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.g.a.close(this.oe);
                        this.oe = a(new URL(url3.toString()), i2, i);
                        this.lh.fJ().d(this.oe);
                        this.oe.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.oe.connect();
                        i3 = this.oe.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.lh.fK().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.oe.getHeaderField("Content-Range");
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.g.b.toInt(headerField2.substring(indexOf + 1), 0);
                }
                int i5 = (i4 == 0 && this.lh.fK().responseCode == 200 && (headerField = this.oe.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.toInt(headerField, 0) : i4;
                this.lh.fK().contentLength = String.valueOf(i5);
                if (!isFileSegSuccess()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        String str3 = "fileLen=" + length + "-contentLen=" + i5;
                        if (str != null && str.contains("plugin")) {
                            this.om = true;
                            com.baidu.adp.lib.util.f.delFile(str);
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err", "", 1, new Object[0]);
                        }
                        str2 = str3;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.oe.getContentType() != null && this.oe.getContentType().contains("text/vnd.wap.wml")) {
                    this.oe.disconnect();
                    this.lh.fK().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.oh = System.currentTimeMillis();
                    com.baidu.adp.lib.g.a.close((InputStream) null);
                    com.baidu.adp.lib.g.a.close(this.oe);
                    com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.ou = url2.getBytes().length;
                    dVar2.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
                    dVar2.downloadSize += i5;
                    if (i5 != 0 && length >= i5) {
                        this.oh = System.currentTimeMillis();
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close((InputStream) null);
                        com.baidu.adp.lib.g.a.close(this.oe);
                        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.oe.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = i5 > 0 ? i5 / 50 : 0;
                        if (hVar != null && length > 0) {
                            hVar.h((int) length, i5);
                        }
                        if (this.om) {
                            this.om = false;
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err_ok", "", 1, new Object[0]);
                        }
                        int i7 = 0;
                        int i8 = 0;
                        while (!this.lh.fK().oT) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i8 += read;
                                    i7 += read;
                                    if (hVar != null && (i7 > i6 || i8 == i5)) {
                                        i7 = 0;
                                        hVar.h((int) (i8 + length), i5);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            boolean z4 = ((long) i8) + length >= ((long) i5);
                            this.oh = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.close(inputStream2);
                            com.baidu.adp.lib.g.a.close(this.oe);
                            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        inputStream = inputStream2;
                        this.oh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.close(inputStream);
                        com.baidu.adp.lib.g.a.close(this.oe);
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
        return this.lh.fK().responseCode == 200 || this.lh.fK().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.oA = -1;
        try {
            String url = this.lh.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            dVar.oA = -2;
            this.oe = c(a);
            dVar.oA = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.oe == null) {
                throw new SocketException("network not available.");
            }
            this.oe.setRequestMethod("POST");
            this.oe.setDoOutput(true);
            this.oe.setDoInput(true);
            this.oe.setConnectTimeout(i2);
            this.oe.setReadTimeout(i);
            this.oe.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            this.lh.fJ().d(this.oe);
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            dVar.oy = System.currentTimeMillis() - currentTimeMillis;
            dVar.oA = -4;
            this.oe.connect();
            if (this.of <= 0) {
                this.of = System.currentTimeMillis();
            }
            this.og = System.currentTimeMillis();
            dVar.oA = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.oy;
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            dVar.oA = -6;
            this.lh.fJ().a(this.oe, dVar);
            dVar.oA = -7;
            if (this.lh.fK().oT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.oe.getContentType();
            this.firstByteReachTime = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.al(contentType)) {
                this.oe.disconnect();
                this.oe.connect();
                if (this.lh.fK().oT) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.oA = -8;
            this.lh.fK().e(this.oe);
            dVar.oz = this.lh.fK().responseCode;
            dVar.downloadSize = this.oe.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.oe);
            if (c != null) {
                dVar.downloadSize += c.length;
                this.lh.fK().downSize = c.length;
                this.lh.fK().retBytes = c(this.lh.fK().contentEncoding, c);
            }
            dVar.ov = new Date().getTime() - currentTimeMillis;
            dVar.oA = -9;
        } finally {
            com.baidu.adp.lib.g.a.close(this.oe);
        }
    }
}
