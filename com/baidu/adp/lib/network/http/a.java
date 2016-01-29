package com.baidu.adp.lib.network.http;

import com.baidu.adp.lib.util.i;
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
public class a {
    private e oo;
    private HttpURLConnection uT;
    private long uU = 0;
    private long uV = 0;
    private long uW = 0;
    private TimerTask uX = new b(this);
    private Timer uY = new Timer();
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long gQ() {
        return this.uW;
    }

    public long gR() {
        return this.uV;
    }

    public long gS() {
        return this.uU;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.oo = eVar;
    }

    public void gT() {
        this.oo.hb().vu = true;
        com.baidu.adp.lib.h.a.e(this.uT);
    }

    private HttpURLConnection d(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String jj;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.iZ()) {
                if (i.jb() && (jj = i.jj()) != null && jj.length() > 0) {
                    if (i.aP(jj) && i.jl()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jj);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.oo.ha().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jj, i.jk())));
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

    public void a(int i, int i2, d dVar) {
        dVar.vk = -1;
        if (this.oo.hb().vu) {
            throw new BdHttpCancelException();
        }
        String c = this.oo.ha().c(dVar);
        dVar.url = c;
        URL url = new URL(c);
        if (this.oo.hb().vu) {
            throw new BdHttpCancelException();
        }
        dVar.vk = -2;
        this.uT = d(url);
        dVar.vk = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uT == null) {
                throw new SocketException("network not available.");
            }
            this.uT.setRequestMethod("GET");
            this.uT.setConnectTimeout(i2);
            this.uT.setReadTimeout(i);
            this.oo.ha().c(this.uT);
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            dVar.vh = new Date().getTime() - currentTimeMillis;
            dVar.vk = -4;
            this.uT.connect();
            this.uU = System.currentTimeMillis();
            dVar.vk = -5;
            dVar.vd = (new Date().getTime() - currentTimeMillis) - dVar.vh;
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.al(this.uT.getContentType())) {
                this.uT.disconnect();
                this.uT.connect();
                if (this.oo.hb().vu) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.vk = -8;
            this.oo.hb().d(this.uT);
            dVar.vj = this.oo.hb().responseCode;
            dVar.vc = this.uT.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.uT);
            if (b != null) {
                dVar.vc += b.length;
                this.oo.hb().vx = c(this.oo.hb().contentEncoding, b);
            }
            dVar.vk = -9;
            dVar.ve = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uT != null) {
                this.uT.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.uW = System.currentTimeMillis();
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
                while (!this.oo.hb().vu && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.e(inputStream);
                        throw th;
                    }
                }
                if (this.oo.hb().vu) {
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
        this.uV = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.h.a.e(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.vk = -1;
        try {
            String url = this.oo.ha().getUrl();
            dVar.url = url;
            URL url2 = new URL(url);
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            dVar.vk = -2;
            this.uT = d(url2);
            dVar.vk = -3;
            System.currentTimeMillis();
            if (this.uT == null) {
                throw new SocketException("network not available.");
            }
            this.uT.setRequestMethod("POST");
            this.uT.setDoOutput(true);
            this.uT.setDoInput(true);
            this.uT.setConnectTimeout(i2);
            this.uT.setReadTimeout(i);
            this.uT.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            this.oo.ha().c(this.uT);
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.vh = new Date().getTime() - time;
            dVar.vk = -4;
            this.uT.connect();
            this.uU = System.currentTimeMillis();
            dVar.vk = -5;
            dVar.vd = (new Date().getTime() - time) - dVar.vh;
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            if (this.uY != null) {
                this.uY.schedule(this.uX, 45000L);
            }
            dVar.vk = -6;
            this.oo.ha().a(this.uT, boundary, dVar);
            dVar.vk = -7;
            if (com.baidu.adp.lib.network.a.b.al(this.uT.getContentType())) {
                this.uT.disconnect();
                this.uT.connect();
                if (this.oo.hb().vu) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            dVar.vk = -8;
            this.oo.hb().d(this.uT);
            dVar.vj = this.oo.hb().responseCode;
            dVar.vc = this.uT.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.uT);
            if (b != null) {
                dVar.vc += b.length;
                this.oo.hb().vy = b.length;
                this.oo.hb().vx = c(this.oo.hb().contentEncoding, b);
            }
            dVar.ve = new Date().getTime() - time;
            dVar.vk = -9;
        } finally {
            if (this.uY != null) {
                this.uY.cancel();
            }
            com.baidu.adp.lib.h.a.e(this.uT);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [569=6, 570=6, 571=6, 572=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url = this.oo.ha().getUrl();
            dVar2.url = url;
            this.uT = d(new URL(url));
            if (this.uT == null) {
                throw new SocketException();
            }
            this.uT.setConnectTimeout(i2);
            this.uT.setReadTimeout(i);
            if (this.oo.hb().vu) {
                this.uV = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.e((InputStream) null);
                com.baidu.adp.lib.h.a.e(this.uT);
                com.baidu.adp.lib.h.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aJ(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aH(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.uT.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.oo.ha().c(this.uT);
                this.uT.connect();
                this.uU = System.currentTimeMillis();
                this.oo.hb().responseCode = this.uT.getResponseCode();
                if (gU()) {
                    if (this.uT.getContentType() != null && this.uT.getContentType().contains("text/vnd.wap.wml")) {
                        this.uT.disconnect();
                        this.oo.hb().responseCode = 0;
                        boolean a = a(str, hVar, i, i2, z, dVar2, z2);
                        this.uV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uT);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.uT.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oo.hb().responseCode == 200 && (headerField = this.uT.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.oo.hb().contentLength = String.valueOf(g);
                    dVar2.vb = url.getBytes().length;
                    dVar2.vc = this.uT.getHeaderFields().toString().getBytes().length;
                    dVar2.vc += g;
                    if (this.oo.hb().responseCode == 416 || this.oo.hb().responseCode == 204) {
                        this.uV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uT);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (length >= g) {
                        this.uV = System.currentTimeMillis();
                        this.uV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uT);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uT.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.d((int) length, g);
                            }
                            while (!this.oo.hb().vu) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            hVar.d((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.uV = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.e(inputStream2);
                                com.baidu.adp.lib.h.a.e(this.uT);
                                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uV = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.e(inputStream);
                            com.baidu.adp.lib.h.a.e(this.uT);
                            com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
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

    private boolean gU() {
        return this.oo.hb().responseCode == 200 || this.oo.hb().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) {
        dVar.vk = -1;
        try {
            String url = this.oo.ha().getUrl();
            dVar.url = url;
            URL url2 = new URL(url);
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            dVar.vk = -2;
            this.uT = d(url2);
            dVar.vk = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uT == null) {
                throw new SocketException("network not available.");
            }
            this.uT.setRequestMethod("POST");
            this.uT.setDoOutput(true);
            this.uT.setDoInput(true);
            this.uT.setConnectTimeout(i2);
            this.uT.setReadTimeout(i);
            this.uT.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            this.oo.ha().c(this.uT);
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            dVar.vh = System.currentTimeMillis() - currentTimeMillis;
            dVar.vk = -4;
            this.uT.connect();
            this.uU = System.currentTimeMillis();
            dVar.vk = -5;
            dVar.vd = (System.currentTimeMillis() - currentTimeMillis) - dVar.vh;
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            dVar.vk = -6;
            this.oo.ha().a(this.uT, dVar);
            dVar.vk = -7;
            if (this.oo.hb().vu) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.al(this.uT.getContentType())) {
                this.uT.disconnect();
                this.uT.connect();
                if (this.oo.hb().vu) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.vk = -8;
            this.oo.hb().d(this.uT);
            dVar.vj = this.oo.hb().responseCode;
            dVar.vc = this.uT.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.uT);
            if (b != null) {
                dVar.vc += b.length;
                this.oo.hb().vy = b.length;
                this.oo.hb().vx = c(this.oo.hb().contentEncoding, b);
            }
            dVar.ve = new Date().getTime() - currentTimeMillis;
            dVar.vk = -9;
        } finally {
            com.baidu.adp.lib.h.a.e(this.uT);
        }
    }
}
