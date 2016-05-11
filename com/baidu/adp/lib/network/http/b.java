package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private f eh;
    private HttpURLConnection kU;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long kV = 0;
    private long kW = 0;
    private long eD = 0;
    private long kX = 0;
    private long kY = 0;
    private boolean kZ = false;
    private boolean la = true;
    private TimerTask lb = new c(this);
    private Timer lc = new Timer();

    public long df() {
        return this.kY;
    }

    public long dg() {
        return this.kX;
    }

    public long dh() {
        return this.kV;
    }

    public long di() {
        return this.kW;
    }

    public long dj() {
        return this.eD;
    }

    public boolean dk() {
        return this.kZ;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.eh = fVar;
    }

    public void dl() {
        this.eh.dv().lD = true;
        com.baidu.adp.lib.h.a.e(this.kU);
    }

    private URL a(String str, e eVar) {
        a de;
        URL url = new URL(str);
        if (this.la && (de = a.de()) != null) {
            String aa = de.aa(str);
            if (!TextUtils.isEmpty(aa)) {
                this.eh.du().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aa));
                this.kZ = true;
                eVar.lr = aa;
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
        String fA;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.fq()) {
                if (com.baidu.adp.lib.util.i.fs() && (fA = com.baidu.adp.lib.util.i.fA()) != null && fA.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aK(fA) && com.baidu.adp.lib.util.i.fC()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(fA);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.eh.du().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fA, com.baidu.adp.lib.util.i.fB())));
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
        eVar.lp = -1;
        if (this.eh.dv().lD) {
            throw new BdHttpCancelException();
        }
        String c = this.eh.du().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.eh.dv().lD) {
            throw new BdHttpCancelException();
        }
        eVar.lp = -2;
        this.kU = d(a);
        eVar.lp = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.kU == null) {
                throw new SocketException("network not available.");
            }
            this.kU.setRequestMethod("GET");
            this.kU.setConnectTimeout(i2);
            this.kU.setReadTimeout(i);
            this.eh.du().c(this.kU);
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lm = new Date().getTime() - currentTimeMillis;
            eVar.lp = -4;
            this.kU.connect();
            if (this.kV <= 0) {
                this.kV = System.currentTimeMillis();
            }
            this.kW = System.currentTimeMillis();
            eVar.lp = -5;
            eVar.li = (new Date().getTime() - currentTimeMillis) - eVar.lm;
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.kU.getContentType();
            this.eD = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ae(contentType)) {
                this.kU.disconnect();
                this.kU.connect();
                if (this.eh.dv().lD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.lp = -8;
            this.eh.dv().d(this.kU);
            eVar.lo = this.eh.dv().responseCode;
            eVar.lh = this.kU.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.kU);
            if (b != null) {
                eVar.lh += b.length;
                this.eh.dv().lG = b(this.eh.dv().contentEncoding, b);
            }
            eVar.lp = -9;
            eVar.lj = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.kU != null) {
                this.kU.disconnect();
            }
        }
    }

    protected final byte[] b(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
            this.kY = System.currentTimeMillis();
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
                while (!this.eh.dv().lD && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.kX = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.c(inputStream);
                        throw th;
                    }
                }
                if (this.eh.dv().lD) {
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
        this.kX = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.h.a.c(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) {
        eVar.lp = -1;
        try {
            String url = this.eh.du().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lp = -2;
            this.kU = d(a);
            eVar.lp = -3;
            System.currentTimeMillis();
            if (this.kU == null) {
                throw new SocketException("network not available.");
            }
            this.kU.setRequestMethod("POST");
            this.kU.setDoOutput(true);
            this.kU.setDoInput(true);
            this.kU.setConnectTimeout(i2);
            this.kU.setReadTimeout(i);
            this.kU.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            this.eh.du().c(this.kU);
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.lm = new Date().getTime() - time;
            eVar.lp = -4;
            this.kU.connect();
            if (this.kV <= 0) {
                this.kV = System.currentTimeMillis();
            }
            this.kW = System.currentTimeMillis();
            eVar.lp = -5;
            eVar.li = (new Date().getTime() - time) - eVar.lm;
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            if (this.lc != null) {
                this.lc.schedule(this.lb, 45000L);
            }
            eVar.lp = -6;
            this.eh.du().a(this.kU, boundary, eVar);
            eVar.lp = -7;
            String contentType = this.kU.getContentType();
            this.eD = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ae(contentType)) {
                this.kU.disconnect();
                this.kU.connect();
                if (this.eh.dv().lD) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lp = -8;
            this.eh.dv().d(this.kU);
            eVar.lo = this.eh.dv().responseCode;
            eVar.lh = this.kU.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.kU);
            if (b != null) {
                eVar.lh += b.length;
                this.eh.dv().lH = b.length;
                this.eh.dv().lG = b(this.eh.dv().contentEncoding, b);
            }
            eVar.lj = new Date().getTime() - time;
            eVar.lp = -9;
        } finally {
            if (this.lc != null) {
                this.lc.cancel();
            }
            com.baidu.adp.lib.h.a.e(this.kU);
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
            String url = this.eh.du().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.kU = a(a, i2, i);
            if (this.eh.dv().lD) {
                this.kX = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.c(null);
                com.baidu.adp.lib.h.a.e(this.kU);
                com.baidu.adp.lib.h.a.a((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aE(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aC(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.eh.du().c(this.kU);
                this.kU.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.kU.connect();
                if (this.kV <= 0) {
                    this.kV = System.currentTimeMillis();
                }
                this.kW = System.currentTimeMillis();
                int responseCode = this.kU.getResponseCode();
                this.eD = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.kU.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.h.a.e(this.kU);
                        this.kU = a(new URL(url2.toString()), i2, i);
                        this.eh.du().c(this.kU);
                        this.kU.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.kU.connect();
                        responseCode = this.kU.getResponseCode();
                    }
                }
                this.eh.dv().responseCode = responseCode;
                if (dm()) {
                    if (this.kU.getContentType() != null && this.kU.getContentType().contains("text/vnd.wap.wml")) {
                        this.kU.disconnect();
                        this.eh.dv().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.kX = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.kU);
                        com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.kU.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.eh.dv().responseCode == 200 && (headerField = this.kU.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.eh.dv().contentLength = String.valueOf(g);
                    eVar2.lg = url.getBytes().length;
                    eVar2.lh = this.kU.getHeaderFields().toString().getBytes().length;
                    eVar2.lh += g;
                    if (this.eh.dv().responseCode == 416 || this.eh.dv().responseCode == 204) {
                        this.kX = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.kU);
                        com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.kX = System.currentTimeMillis();
                        this.kX = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.kU);
                        com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.kU.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.d((int) length, g);
                            }
                            while (!this.eh.dv().lD) {
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
                                this.kX = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.c(inputStream2);
                                com.baidu.adp.lib.h.a.e(this.kU);
                                com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.kX = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.c(inputStream);
                            com.baidu.adp.lib.h.a.e(this.kU);
                            com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream);
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

    private boolean dm() {
        return this.eh.dv().responseCode == 200 || this.eh.dv().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) {
        eVar.lp = -1;
        try {
            String url = this.eh.du().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lp = -2;
            this.kU = d(a);
            eVar.lp = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.kU == null) {
                throw new SocketException("network not available.");
            }
            this.kU.setRequestMethod("POST");
            this.kU.setDoOutput(true);
            this.kU.setDoInput(true);
            this.kU.setConnectTimeout(i2);
            this.kU.setReadTimeout(i);
            this.kU.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            this.eh.du().c(this.kU);
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lm = System.currentTimeMillis() - currentTimeMillis;
            eVar.lp = -4;
            this.kU.connect();
            if (this.kV <= 0) {
                this.kV = System.currentTimeMillis();
            }
            this.kW = System.currentTimeMillis();
            eVar.lp = -5;
            eVar.li = (System.currentTimeMillis() - currentTimeMillis) - eVar.lm;
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lp = -6;
            this.eh.du().a(this.kU, eVar);
            eVar.lp = -7;
            if (this.eh.dv().lD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.kU.getContentType();
            this.eD = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ae(contentType)) {
                this.kU.disconnect();
                this.kU.connect();
                if (this.eh.dv().lD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.lp = -8;
            this.eh.dv().d(this.kU);
            eVar.lo = this.eh.dv().responseCode;
            eVar.lh = this.kU.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.kU);
            if (b != null) {
                eVar.lh += b.length;
                this.eh.dv().lH = b.length;
                this.eh.dv().lG = b(this.eh.dv().contentEncoding, b);
            }
            eVar.lj = new Date().getTime() - currentTimeMillis;
            eVar.lp = -9;
        } finally {
            com.baidu.adp.lib.h.a.e(this.kU);
        }
    }
}
