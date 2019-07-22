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
    private HttpURLConnection Ag;
    private e tI;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Ah = 0;
    private long Ai = 0;
    private long ud = 0;
    private long Aj = 0;
    private long Ak = 0;
    private boolean Al = false;
    private boolean Am = true;
    private boolean An = false;
    private TimerTask Ao = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ik();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Ap = new Timer();

    public long ie() {
        return this.Ak;
    }

    /* renamed from: if  reason: not valid java name */
    public long m9if() {
        return this.Aj;
    }

    public long ig() {
        return this.Ah;
    }

    public long ih() {
        return this.Ai;
    }

    public long ii() {
        return this.ud;
    }

    public boolean ij() {
        return this.Al;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.tI = eVar;
    }

    public void ik() {
        this.tI.iv().AQ = true;
        com.baidu.adp.lib.g.a.f(this.Ag);
    }

    private URL a(String str, d dVar) throws Exception {
        a id;
        URL url = new URL(str);
        if (this.Am && (id = a.id()) != null) {
            String aA = id.aA(str);
            if (!TextUtils.isEmpty(aA)) {
                this.tI.iu().q(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aA));
                this.Al = true;
                dVar.AD = aA;
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
        String kl;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.kc()) {
                if (j.ke() && (kl = j.kl()) != null && kl.length() > 0) {
                    if (j.bf(kl) && j.kn()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kl);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.tI.iu().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kl, j.km())));
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
        dVar.AB = -1;
        if (this.tI.iv().AQ) {
            throw new BdHttpCancelException();
        }
        String c = this.tI.iu().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.tI.iv().AQ) {
            throw new BdHttpCancelException();
        }
        dVar.AB = -2;
        this.Ag = c(a);
        dVar.AB = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Ag == null) {
                throw new SocketException("network not available.");
            }
            this.Ag.setRequestMethod("GET");
            this.Ag.setConnectTimeout(i2);
            this.Ag.setReadTimeout(i);
            this.tI.iu().d(this.Ag);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            dVar.Ay = new Date().getTime() - currentTimeMillis;
            dVar.AB = -4;
            this.Ag.connect();
            if (this.Ah <= 0) {
                this.Ah = System.currentTimeMillis();
            }
            this.Ai = System.currentTimeMillis();
            dVar.AB = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.Ay;
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ag.getContentType();
            this.ud = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aG(contentType)) {
                this.Ag.disconnect();
                this.Ag.connect();
                if (this.tI.iv().AQ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.AB = -8;
            this.tI.iv().e(this.Ag);
            if (c.contains("c.tieba.baidu.com") && (map = this.tI.iv().AT) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.AE = list.get(0);
                dVar.AF = list.get(1);
            }
            dVar.AA = this.tI.iv().responseCode;
            dVar.Au = this.Ag.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.Ag);
            if (c2 != null) {
                dVar.Au += c2.length;
                this.tI.iv().AU = c(this.tI.iv().contentEncoding, c2);
            }
            dVar.AB = -9;
            dVar.Av = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Ag != null) {
                this.Ag.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Ak = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Ak == 0) {
            this.Ak = System.currentTimeMillis();
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
                while (!this.tI.iv().AQ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                }
                if (this.tI.iv().AQ) {
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
        this.Aj = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.g(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.AB = -1;
        try {
            String url = this.tI.iu().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            dVar.AB = -2;
            this.Ag = c(a);
            dVar.AB = -3;
            System.currentTimeMillis();
            if (this.Ag == null) {
                throw new SocketException("network not available.");
            }
            this.Ag.setRequestMethod("POST");
            this.Ag.setDoOutput(true);
            this.Ag.setDoInput(true);
            this.Ag.setConnectTimeout(i2);
            this.Ag.setReadTimeout(i);
            this.Ag.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            this.tI.iu().d(this.Ag);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.Ay = new Date().getTime() - time;
            dVar.AB = -4;
            this.Ag.connect();
            if (this.Ah <= 0) {
                this.Ah = System.currentTimeMillis();
            }
            this.Ai = System.currentTimeMillis();
            dVar.AB = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.Ay;
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            if (this.Ap != null) {
                this.Ap.schedule(this.Ao, 45000L);
            }
            dVar.AB = -6;
            this.tI.iu().a(this.Ag, boundary, dVar);
            dVar.AB = -7;
            String contentType = this.Ag.getContentType();
            this.ud = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aG(contentType)) {
                this.Ag.disconnect();
                this.Ag.connect();
                if (this.tI.iv().AQ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            dVar.AB = -8;
            this.tI.iv().e(this.Ag);
            dVar.AA = this.tI.iv().responseCode;
            dVar.Au = this.Ag.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ag);
            if (c != null) {
                dVar.Au += c.length;
                this.tI.iv().AV = c.length;
                this.tI.iv().AU = c(this.tI.iv().contentEncoding, c);
            }
            dVar.Av = new Date().getTime() - time;
            dVar.AB = -9;
        } finally {
            if (this.Ap != null) {
                this.Ap.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.Ag);
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
            String url2 = this.tI.iu().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.Ag = a(a, i2, i);
            if (this.tI.iv().AQ) {
                this.Aj = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.g(null);
                com.baidu.adp.lib.g.a.f(this.Ag);
                com.baidu.adp.lib.g.a.c(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aZ(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aY(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.tI.iu().d(this.Ag);
                this.Ag.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Ag.connect();
                if (this.Ah <= 0) {
                    this.Ah = System.currentTimeMillis();
                }
                this.Ai = System.currentTimeMillis();
                int responseCode = this.Ag.getResponseCode();
                this.ud = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.Ag.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.g.a.f(this.Ag);
                        this.Ag = a(new URL(url3.toString()), i2, i);
                        this.tI.iu().d(this.Ag);
                        this.Ag.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Ag.connect();
                        i3 = this.Ag.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.tI.iv().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.Ag.getHeaderField("Content-Range");
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.g.b.f(headerField2.substring(indexOf + 1), 0);
                }
                int f = (i4 == 0 && this.tI.iv().responseCode == 200 && (headerField = this.Ag.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.f(headerField, 0) : i4;
                this.tI.iv().contentLength = String.valueOf(f);
                if (!il()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        String str3 = "fileLen=" + length + "-contentLen=" + f;
                        if (str != null && str.contains("plugin")) {
                            this.An = true;
                            com.baidu.adp.lib.util.f.aZ(str);
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err", "", 1, new Object[0]);
                        }
                        str2 = str3;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.Ag.getContentType() != null && this.Ag.getContentType().contains("text/vnd.wap.wml")) {
                    this.Ag.disconnect();
                    this.tI.iv().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.Aj = System.currentTimeMillis();
                    com.baidu.adp.lib.g.a.g(null);
                    com.baidu.adp.lib.g.a.f(this.Ag);
                    com.baidu.adp.lib.g.a.c(fileOutputStream2);
                    return a2;
                } else {
                    dVar2.At = url2.getBytes().length;
                    dVar2.Au = this.Ag.getHeaderFields().toString().getBytes().length;
                    dVar2.Au += f;
                    if (f != 0 && length >= f) {
                        this.Aj = System.currentTimeMillis();
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.Ag);
                        com.baidu.adp.lib.g.a.c(fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.Ag.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i5 = f > 0 ? f / 50 : 0;
                        if (hVar != null && length > 0) {
                            hVar.o((int) length, f);
                        }
                        if (this.An) {
                            this.An = false;
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err_ok", "", 1, new Object[0]);
                        }
                        int i6 = 0;
                        int i7 = 0;
                        while (!this.tI.iv().AQ) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i7 += read;
                                    i6 += read;
                                    if (hVar != null && (i6 > i5 || i7 == f)) {
                                        i6 = 0;
                                        hVar.o((int) (i7 + length), f);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            boolean z4 = ((long) i7) + length >= ((long) f);
                            this.Aj = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.g(inputStream2);
                            com.baidu.adp.lib.g.a.f(this.Ag);
                            com.baidu.adp.lib.g.a.c(fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        inputStream = inputStream2;
                        this.Aj = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(inputStream);
                        com.baidu.adp.lib.g.a.f(this.Ag);
                        com.baidu.adp.lib.g.a.c(fileOutputStream);
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

    private boolean il() {
        return this.tI.iv().responseCode == 200 || this.tI.iv().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.AB = -1;
        try {
            String url = this.tI.iu().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            dVar.AB = -2;
            this.Ag = c(a);
            dVar.AB = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Ag == null) {
                throw new SocketException("network not available.");
            }
            this.Ag.setRequestMethod("POST");
            this.Ag.setDoOutput(true);
            this.Ag.setDoInput(true);
            this.Ag.setConnectTimeout(i2);
            this.Ag.setReadTimeout(i);
            this.Ag.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            this.tI.iu().d(this.Ag);
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            dVar.Ay = System.currentTimeMillis() - currentTimeMillis;
            dVar.AB = -4;
            this.Ag.connect();
            if (this.Ah <= 0) {
                this.Ah = System.currentTimeMillis();
            }
            this.Ai = System.currentTimeMillis();
            dVar.AB = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.Ay;
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            dVar.AB = -6;
            this.tI.iu().a(this.Ag, dVar);
            dVar.AB = -7;
            if (this.tI.iv().AQ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Ag.getContentType();
            this.ud = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aG(contentType)) {
                this.Ag.disconnect();
                this.Ag.connect();
                if (this.tI.iv().AQ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.AB = -8;
            this.tI.iv().e(this.Ag);
            dVar.AA = this.tI.iv().responseCode;
            dVar.Au = this.Ag.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.Ag);
            if (c != null) {
                dVar.Au += c.length;
                this.tI.iv().AV = c.length;
                this.tI.iv().AU = c(this.tI.iv().contentEncoding, c);
            }
            dVar.Av = new Date().getTime() - currentTimeMillis;
            dVar.AB = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.Ag);
        }
    }
}
