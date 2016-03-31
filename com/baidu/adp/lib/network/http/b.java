package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private f oo;
    private HttpURLConnection vd;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long ve = 0;
    private long vf = 0;
    private long oL = 0;
    private long vg = 0;
    private long vh = 0;
    private boolean vi = false;
    private boolean vj = true;
    private TimerTask vk = new c(this);
    private Timer vl = new Timer();

    public long gR() {
        return this.vh;
    }

    public long gS() {
        return this.vg;
    }

    public long gT() {
        return this.ve;
    }

    public long gU() {
        return this.vf;
    }

    public long gV() {
        return this.oL;
    }

    public boolean gW() {
        return this.vi;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.oo = fVar;
    }

    public void gX() {
        this.oo.hh().vK = true;
        com.baidu.adp.lib.h.a.e(this.vd);
    }

    private URL a(String str, e eVar) {
        a gQ;
        URL url = new URL(str);
        if (this.vj && (gQ = a.gQ()) != null) {
            String aj = gQ.aj(str);
            if (!TextUtils.isEmpty(aj)) {
                this.oo.hg().q("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aj));
                this.vi = true;
                eVar.vA = aj;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection a(URL url, int i, int i2) {
        HttpURLConnection d = d(url);
        if (d != null) {
            d.setConnectTimeout(i);
            d.setReadTimeout(i2);
            return d;
        }
        throw new SocketException();
    }

    private HttpURLConnection d(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String jp;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.jf()) {
                if (com.baidu.adp.lib.util.i.jh() && (jp = com.baidu.adp.lib.util.i.jp()) != null && jp.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aR(jp) && com.baidu.adp.lib.util.i.jr()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jp);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.oo.hg().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jp, com.baidu.adp.lib.util.i.jq())));
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

    public void a(int i, int i2, e eVar) {
        eVar.vy = -1;
        if (this.oo.hh().vK) {
            throw new BdHttpCancelException();
        }
        String c = this.oo.hg().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.oo.hh().vK) {
            throw new BdHttpCancelException();
        }
        eVar.vy = -2;
        this.vd = d(a);
        eVar.vy = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.vd == null) {
                throw new SocketException("network not available.");
            }
            this.vd.setRequestMethod("GET");
            this.vd.setConnectTimeout(i2);
            this.vd.setReadTimeout(i);
            this.oo.hg().c(this.vd);
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            eVar.vv = new Date().getTime() - currentTimeMillis;
            eVar.vy = -4;
            this.vd.connect();
            if (this.ve <= 0) {
                this.ve = System.currentTimeMillis();
            }
            this.vf = System.currentTimeMillis();
            eVar.vy = -5;
            eVar.vr = (new Date().getTime() - currentTimeMillis) - eVar.vv;
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vd.getContentType();
            this.oL = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.an(contentType)) {
                this.vd.disconnect();
                this.vd.connect();
                if (this.oo.hh().vK) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vy = -8;
            this.oo.hh().d(this.vd);
            eVar.vx = this.oo.hh().responseCode;
            eVar.vq = this.vd.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.vd);
            if (b != null) {
                eVar.vq += b.length;
                this.oo.hh().vN = b(this.oo.hh().contentEncoding, b);
            }
            eVar.vy = -9;
            eVar.vs = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.vd != null) {
                this.vd.disconnect();
            }
        }
    }

    protected final byte[] b(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.vh = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] b(HttpURLConnection httpURLConnection) {
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
                while (!this.oo.hh().vK && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.vg = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.c(inputStream);
                        throw th;
                    }
                }
                if (this.oo.hh().vK) {
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
        this.vg = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
        com.baidu.adp.lib.h.a.c(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) {
        eVar.vy = -1;
        try {
            String url = this.oo.hg().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            eVar.vy = -2;
            this.vd = d(a);
            eVar.vy = -3;
            System.currentTimeMillis();
            if (this.vd == null) {
                throw new SocketException("network not available.");
            }
            this.vd.setRequestMethod("POST");
            this.vd.setDoOutput(true);
            this.vd.setDoInput(true);
            this.vd.setConnectTimeout(i2);
            this.vd.setReadTimeout(i);
            this.vd.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            this.oo.hg().c(this.vd);
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.vv = new Date().getTime() - time;
            eVar.vy = -4;
            this.vd.connect();
            if (this.ve <= 0) {
                this.ve = System.currentTimeMillis();
            }
            this.vf = System.currentTimeMillis();
            eVar.vy = -5;
            eVar.vr = (new Date().getTime() - time) - eVar.vv;
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            if (this.vl != null) {
                this.vl.schedule(this.vk, 45000L);
            }
            eVar.vy = -6;
            this.oo.hg().a(this.vd, boundary, eVar);
            eVar.vy = -7;
            String contentType = this.vd.getContentType();
            this.oL = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.an(contentType)) {
                this.vd.disconnect();
                this.vd.connect();
                if (this.oo.hh().vK) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            eVar.vy = -8;
            this.oo.hh().d(this.vd);
            eVar.vx = this.oo.hh().responseCode;
            eVar.vq = this.vd.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.vd);
            if (b != null) {
                eVar.vq += b.length;
                this.oo.hh().vO = b.length;
                this.oo.hh().vN = b(this.oo.hh().contentEncoding, b);
            }
            eVar.vs = new Date().getTime() - time;
            eVar.vy = -9;
        } finally {
            if (this.vl != null) {
                this.vl.cancel();
            }
            com.baidu.adp.lib.h.a.e(this.vd);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [671=6, 672=6, 673=6, 674=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.oo.hg().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.vd = a(a, i2, i);
            if (this.oo.hh().vK) {
                this.vg = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.c(null);
                com.baidu.adp.lib.h.a.e(this.vd);
                com.baidu.adp.lib.h.a.b(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aL(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aJ(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.oo.hg().c(this.vd);
                this.vd.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.vd.connect();
                if (this.ve <= 0) {
                    this.ve = System.currentTimeMillis();
                }
                this.vf = System.currentTimeMillis();
                int responseCode = this.vd.getResponseCode();
                this.oL = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.vd.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.h.a.e(this.vd);
                        this.vd = a(new URL(url2.toString()), i2, i);
                        this.oo.hg().c(this.vd);
                        this.vd.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.vd.connect();
                        responseCode = this.vd.getResponseCode();
                    }
                }
                this.oo.hh().responseCode = responseCode;
                if (gY()) {
                    if (this.vd.getContentType() != null && this.vd.getContentType().contains("text/vnd.wap.wml")) {
                        this.vd.disconnect();
                        this.oo.hh().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.vg = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.vd);
                        com.baidu.adp.lib.h.a.b(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.vd.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oo.hh().responseCode == 200 && (headerField = this.vd.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.oo.hh().contentLength = String.valueOf(g);
                    eVar2.vp = url.getBytes().length;
                    eVar2.vq = this.vd.getHeaderFields().toString().getBytes().length;
                    eVar2.vq += g;
                    if (this.oo.hh().responseCode == 416 || this.oo.hh().responseCode == 204) {
                        this.vg = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.vd);
                        com.baidu.adp.lib.h.a.b(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.vg = System.currentTimeMillis();
                        this.vg = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.vd);
                        com.baidu.adp.lib.h.a.b(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.vd.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.d((int) length, g);
                            }
                            while (!this.oo.hh().vK) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (iVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            iVar.d((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.vg = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.c(inputStream2);
                                com.baidu.adp.lib.h.a.e(this.vd);
                                com.baidu.adp.lib.h.a.b(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.vg = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.c(inputStream);
                            com.baidu.adp.lib.h.a.e(this.vd);
                            com.baidu.adp.lib.h.a.b(fileOutputStream);
                            throw th;
                        }
                    }
                }
                throw new UnsupportedOperationException();
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

    private boolean gY() {
        return this.oo.hh().responseCode == 200 || this.oo.hh().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) {
        eVar.vy = -1;
        try {
            String url = this.oo.hg().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            eVar.vy = -2;
            this.vd = d(a);
            eVar.vy = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.vd == null) {
                throw new SocketException("network not available.");
            }
            this.vd.setRequestMethod("POST");
            this.vd.setDoOutput(true);
            this.vd.setDoInput(true);
            this.vd.setConnectTimeout(i2);
            this.vd.setReadTimeout(i);
            this.vd.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            this.oo.hg().c(this.vd);
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            eVar.vv = System.currentTimeMillis() - currentTimeMillis;
            eVar.vy = -4;
            this.vd.connect();
            if (this.ve <= 0) {
                this.ve = System.currentTimeMillis();
            }
            this.vf = System.currentTimeMillis();
            eVar.vy = -5;
            eVar.vr = (System.currentTimeMillis() - currentTimeMillis) - eVar.vv;
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            eVar.vy = -6;
            this.oo.hg().a(this.vd, eVar);
            eVar.vy = -7;
            if (this.oo.hh().vK) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vd.getContentType();
            this.oL = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.an(contentType)) {
                this.vd.disconnect();
                this.vd.connect();
                if (this.oo.hh().vK) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vy = -8;
            this.oo.hh().d(this.vd);
            eVar.vx = this.oo.hh().responseCode;
            eVar.vq = this.vd.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.vd);
            if (b != null) {
                eVar.vq += b.length;
                this.oo.hh().vO = b.length;
                this.oo.hh().vN = b(this.oo.hh().contentEncoding, b);
            }
            eVar.vs = new Date().getTime() - currentTimeMillis;
            eVar.vy = -9;
        } finally {
            com.baidu.adp.lib.h.a.e(this.vd);
        }
    }
}
