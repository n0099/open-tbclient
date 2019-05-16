package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.j;
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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private HttpURLConnection Aa;
    private e tG;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Ab = 0;
    private long Ac = 0;
    private long ub = 0;
    private long Ae = 0;
    private long Af = 0;
    private boolean Ag = false;
    private boolean Ah = true;
    private boolean Ai = false;
    private TimerTask Aj = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ia();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Ak = new Timer();

    public long hU() {
        return this.Af;
    }

    public long hV() {
        return this.Ae;
    }

    public long hW() {
        return this.Ab;
    }

    public long hX() {
        return this.Ac;
    }

    public long hY() {
        return this.ub;
    }

    public boolean hZ() {
        return this.Ag;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.tG = eVar;
    }

    public void ia() {
        this.tG.il().AK = true;
        com.baidu.adp.lib.g.a.f(this.Aa);
    }

    private URL a(String str, d dVar) throws Exception {
        a hT;
        URL url = new URL(str);
        if (this.Ah && (hT = a.hT()) != null) {
            String az = hT.az(str);
            if (!TextUtils.isEmpty(az)) {
                this.tG.ik().q(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + az));
                this.Ag = true;
                dVar.Ay = az;
                return url2;
            }
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
        HttpURLConnection httpURLConnection;
        Exception e;
        String kb;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.jS()) {
                if (j.jU() && (kb = j.kb()) != null && kb.length() > 0) {
                    if (j.be(kb) && j.kd()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kb);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.tG.ik().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kb, j.kc())));
                    }
                }
                if (httpURLConnection2 == null) {
                    try {
                        return (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        httpURLConnection = httpURLConnection2;
                        e = e3;
                        e.printStackTrace();
                        return httpURLConnection;
                    }
                }
                return httpURLConnection2;
            }
            return null;
        } catch (Exception e4) {
            httpURLConnection = null;
            e = e4;
        }
    }

    public void a(int i, int i2, d dVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        dVar.Aw = -1;
        if (this.tG.il().AK) {
            throw new BdHttpCancelException();
        }
        String c = this.tG.ik().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.tG.il().AK) {
            throw new BdHttpCancelException();
        }
        dVar.Aw = -2;
        this.Aa = c(a);
        dVar.Aw = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Aa == null) {
                throw new SocketException("network not available.");
            }
            this.Aa.setRequestMethod("GET");
            this.Aa.setConnectTimeout(i2);
            this.Aa.setReadTimeout(i);
            this.tG.ik().d(this.Aa);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            dVar.At = new Date().getTime() - currentTimeMillis;
            dVar.Aw = -4;
            this.Aa.connect();
            if (this.Ab <= 0) {
                this.Ab = System.currentTimeMillis();
            }
            this.Ac = System.currentTimeMillis();
            dVar.Aw = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.At;
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Aa.getContentType();
            this.ub = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aF(contentType)) {
                this.Aa.disconnect();
                this.Aa.connect();
                if (this.tG.il().AK) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Aw = -8;
            this.tG.il().e(this.Aa);
            if (c.contains("c.tieba.baidu.com") && (map = this.tG.il().AN) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.Az = list.get(0);
                dVar.AA = list.get(1);
            }
            dVar.Av = this.tG.il().responseCode;
            dVar.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.Aa);
            if (c2 != null) {
                dVar.Ap += c2.length;
                this.tG.il().AO = c(this.tG.il().contentEncoding, c2);
            }
            dVar.Aw = -9;
            dVar.Aq = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Aa != null) {
                this.Aa.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Af = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Af == 0) {
            this.Af = System.currentTimeMillis();
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
                while (!this.tG.il().AK && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                }
                if (this.tG.il().AK) {
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
        this.Ae = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.g(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Aw = -1;
        try {
            String url = this.tG.ik().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            dVar.Aw = -2;
            this.Aa = c(a);
            dVar.Aw = -3;
            System.currentTimeMillis();
            if (this.Aa == null) {
                throw new SocketException("network not available.");
            }
            this.Aa.setRequestMethod("POST");
            this.Aa.setDoOutput(true);
            this.Aa.setDoInput(true);
            this.Aa.setConnectTimeout(i2);
            this.Aa.setReadTimeout(i);
            this.Aa.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            this.tG.ik().d(this.Aa);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.At = new Date().getTime() - time;
            dVar.Aw = -4;
            this.Aa.connect();
            if (this.Ab <= 0) {
                this.Ab = System.currentTimeMillis();
            }
            this.Ac = System.currentTimeMillis();
            dVar.Aw = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.At;
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            if (this.Ak != null) {
                this.Ak.schedule(this.Aj, 45000L);
            }
            dVar.Aw = -6;
            this.tG.ik().a(this.Aa, boundary, dVar);
            dVar.Aw = -7;
            String contentType = this.Aa.getContentType();
            this.ub = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aF(contentType)) {
                this.Aa.disconnect();
                this.Aa.connect();
                if (this.tG.il().AK) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            dVar.Aw = -8;
            this.tG.il().e(this.Aa);
            dVar.Av = this.tG.il().responseCode;
            dVar.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Aa);
            if (c != null) {
                dVar.Ap += c.length;
                this.tG.il().AP = c.length;
                this.tG.il().AO = c(this.tG.il().contentEncoding, c);
            }
            dVar.Aq = new Date().getTime() - time;
            dVar.Aw = -9;
        } finally {
            if (this.Ak != null) {
                this.Ak.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.Aa);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [708=7, 709=5, 710=5, 711=5] */
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
            String url2 = this.tG.ik().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.Aa = a(a, i2, i);
            if (this.tG.il().AK) {
                this.Ae = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.g(null);
                com.baidu.adp.lib.g.a.f(this.Aa);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aY(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aX(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.tG.ik().d(this.Aa);
                this.Aa.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Aa.connect();
                if (this.Ab <= 0) {
                    this.Ab = System.currentTimeMillis();
                }
                this.Ac = System.currentTimeMillis();
                int responseCode = this.Aa.getResponseCode();
                this.ub = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.Aa.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.g.a.f(this.Aa);
                        this.Aa = a(new URL(url3.toString()), i2, i);
                        this.tG.ik().d(this.Aa);
                        this.Aa.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Aa.connect();
                        i3 = this.Aa.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.tG.il().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.Aa.getHeaderField("Content-Range");
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.g.b.f(headerField2.substring(indexOf + 1), 0);
                }
                int f = (i4 == 0 && this.tG.il().responseCode == 200 && (headerField = this.Aa.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.f(headerField, 0) : i4;
                this.tG.il().contentLength = String.valueOf(f);
                if (!ib()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        String str3 = "fileLen=" + length + "-contentLen=" + f;
                        if (str != null && str.contains("plugin")) {
                            this.Ai = true;
                            com.baidu.adp.lib.util.f.aY(str);
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err", "", 1, new Object[0]);
                        }
                        str2 = str3;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.Aa.getContentType() != null && this.Aa.getContentType().contains("text/vnd.wap.wml")) {
                    this.Aa.disconnect();
                    this.tG.il().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.Ae = System.currentTimeMillis();
                    com.baidu.adp.lib.g.a.g(null);
                    com.baidu.adp.lib.g.a.f(this.Aa);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.Ao = url2.getBytes().length;
                    dVar2.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
                    dVar2.Ap += f;
                    if (f != 0 && length >= f) {
                        this.Ae = System.currentTimeMillis();
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Aa);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.Aa.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i5 = f > 0 ? f / 50 : 0;
                        if (hVar != null && length > 0) {
                            hVar.m((int) length, f);
                        }
                        if (this.Ai) {
                            this.Ai = false;
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err_ok", "", 1, new Object[0]);
                        }
                        int i6 = 0;
                        int i7 = 0;
                        while (!this.tG.il().AK) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i7 += read;
                                    i6 += read;
                                    if (hVar != null && (i6 > i5 || i7 == f)) {
                                        i6 = 0;
                                        hVar.m((int) (i7 + length), f);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            boolean z4 = ((long) i7) + length >= ((long) f);
                            this.Ae = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.g(inputStream2);
                            com.baidu.adp.lib.g.a.f(this.Aa);
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        inputStream = inputStream2;
                        this.Ae = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(inputStream);
                        com.baidu.adp.lib.g.a.f(this.Aa);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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

    private boolean ib() {
        return this.tG.il().responseCode == 200 || this.tG.il().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Aw = -1;
        try {
            String url = this.tG.ik().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            dVar.Aw = -2;
            this.Aa = c(a);
            dVar.Aw = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Aa == null) {
                throw new SocketException("network not available.");
            }
            this.Aa.setRequestMethod("POST");
            this.Aa.setDoOutput(true);
            this.Aa.setDoInput(true);
            this.Aa.setConnectTimeout(i2);
            this.Aa.setReadTimeout(i);
            this.Aa.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            this.tG.ik().d(this.Aa);
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            dVar.At = System.currentTimeMillis() - currentTimeMillis;
            dVar.Aw = -4;
            this.Aa.connect();
            if (this.Ab <= 0) {
                this.Ab = System.currentTimeMillis();
            }
            this.Ac = System.currentTimeMillis();
            dVar.Aw = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.At;
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            dVar.Aw = -6;
            this.tG.ik().a(this.Aa, dVar);
            dVar.Aw = -7;
            if (this.tG.il().AK) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Aa.getContentType();
            this.ub = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aF(contentType)) {
                this.Aa.disconnect();
                this.Aa.connect();
                if (this.tG.il().AK) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Aw = -8;
            this.tG.il().e(this.Aa);
            dVar.Av = this.tG.il().responseCode;
            dVar.Ap = this.Aa.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Aa);
            if (c != null) {
                dVar.Ap += c.length;
                this.tG.il().AP = c.length;
                this.tG.il().AO = c(this.tG.il().contentEncoding, c);
            }
            dVar.Aq = new Date().getTime() - currentTimeMillis;
            dVar.Aw = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.Aa);
        }
    }
}
