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
    private e oj;
    private HttpURLConnection uK;
    private long uL = 0;
    private long uM = 0;
    private long uN = 0;
    private TimerTask uO = new b(this);
    private Timer uP = new Timer();
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long gI() {
        return this.uN;
    }

    public long gJ() {
        return this.uM;
    }

    public long gK() {
        return this.uL;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.oj = eVar;
    }

    public void gL() {
        this.oj.gT().vl = true;
        com.baidu.adp.lib.h.a.e(this.uK);
    }

    private HttpURLConnection c(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String ja;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.iQ()) {
                if (i.iS() && (ja = i.ja()) != null && ja.length() > 0) {
                    if (i.aQ(ja) && i.jc()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(ja);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.oj.gS().p("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ja, i.jb())));
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
        dVar.vb = -1;
        if (this.oj.gT().vl) {
            throw new BdHttpCancelException();
        }
        String c = this.oj.gS().c(dVar);
        dVar.url = c;
        URL url = new URL(c);
        if (this.oj.gT().vl) {
            throw new BdHttpCancelException();
        }
        dVar.vb = -2;
        this.uK = c(url);
        dVar.vb = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uK == null) {
                throw new SocketException("network not available.");
            }
            this.uK.setRequestMethod("GET");
            this.uK.setConnectTimeout(i2);
            this.uK.setReadTimeout(i);
            this.oj.gS().c(this.uK);
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uY = new Date().getTime() - currentTimeMillis;
            dVar.vb = -4;
            this.uK.connect();
            this.uL = System.currentTimeMillis();
            dVar.vb = -5;
            dVar.uU = (new Date().getTime() - currentTimeMillis) - dVar.uY;
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.am(this.uK.getContentType())) {
                this.uK.disconnect();
                this.uK.connect();
                if (this.oj.gT().vl) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.vb = -8;
            this.oj.gT().d(this.uK);
            dVar.va = this.oj.gT().responseCode;
            dVar.uT = this.uK.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.uK);
            if (b != null) {
                dVar.uT += b.length;
                this.oj.gT().vn = c(this.oj.gT().contentEncoding, b);
            }
            dVar.vb = -9;
            dVar.uV = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uK != null) {
                this.uK.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.uN = System.currentTimeMillis();
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
                while (!this.oj.gT().vl && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uM = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.e(inputStream);
                        throw th;
                    }
                }
                if (this.oj.gT().vl) {
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
        this.uM = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.h.a.e(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.vb = -1;
        try {
            String url = this.oj.gS().getUrl();
            dVar.url = url;
            URL url2 = new URL(url);
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            dVar.vb = -2;
            this.uK = c(url2);
            dVar.vb = -3;
            System.currentTimeMillis();
            if (this.uK == null) {
                throw new SocketException("network not available.");
            }
            this.uK.setRequestMethod("POST");
            this.uK.setDoOutput(true);
            this.uK.setDoInput(true);
            this.uK.setConnectTimeout(i2);
            this.uK.setReadTimeout(i);
            this.uK.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            this.oj.gS().c(this.uK);
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uY = new Date().getTime() - time;
            dVar.vb = -4;
            this.uK.connect();
            this.uL = System.currentTimeMillis();
            dVar.vb = -5;
            dVar.uU = (new Date().getTime() - time) - dVar.uY;
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            if (this.uP != null) {
                this.uP.schedule(this.uO, 45000L);
            }
            dVar.vb = -6;
            this.oj.gS().a(this.uK, boundary, dVar);
            dVar.vb = -7;
            if (com.baidu.adp.lib.network.a.b.am(this.uK.getContentType())) {
                this.uK.disconnect();
                this.uK.connect();
                if (this.oj.gT().vl) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            dVar.vb = -8;
            this.oj.gT().d(this.uK);
            dVar.va = this.oj.gT().responseCode;
            dVar.uT = this.uK.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.uK);
            if (b != null) {
                dVar.uT += b.length;
                this.oj.gT().vo = b.length;
                this.oj.gT().vn = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uV = new Date().getTime() - time;
            dVar.vb = -9;
        } finally {
            if (this.uP != null) {
                this.uP.cancel();
            }
            com.baidu.adp.lib.h.a.e(this.uK);
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
            String url = this.oj.gS().getUrl();
            dVar2.url = url;
            this.uK = c(new URL(url));
            if (this.uK == null) {
                throw new SocketException();
            }
            this.uK.setConnectTimeout(i2);
            this.uK.setReadTimeout(i);
            if (this.oj.gT().vl) {
                this.uM = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.e((InputStream) null);
                com.baidu.adp.lib.h.a.e(this.uK);
                com.baidu.adp.lib.h.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aK(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aI(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.uK.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.oj.gS().c(this.uK);
                this.uK.connect();
                this.uL = System.currentTimeMillis();
                this.oj.gT().responseCode = this.uK.getResponseCode();
                if (gM()) {
                    if (this.uK.getContentType().contains("text/vnd.wap.wml")) {
                        this.uK.disconnect();
                        this.oj.gT().responseCode = 0;
                        boolean a = a(str, hVar, i, i2, z, dVar2, z2);
                        this.uM = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uK);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.uK.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oj.gT().responseCode == 200 && (headerField = this.uK.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.oj.gT().contentLength = String.valueOf(g);
                    dVar2.uS = url.getBytes().length;
                    dVar2.uT = this.uK.getHeaderFields().toString().getBytes().length;
                    dVar2.uT += g;
                    if (this.oj.gT().responseCode == 416 || this.oj.gT().responseCode == 204) {
                        this.uM = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uK);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (length >= g) {
                        this.uM = System.currentTimeMillis();
                        this.uM = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uK);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uK.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.c((int) length, g);
                            }
                            while (!this.oj.gT().vl) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            hVar.c((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.uM = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.e(inputStream2);
                                com.baidu.adp.lib.h.a.e(this.uK);
                                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uM = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.e(inputStream);
                            com.baidu.adp.lib.h.a.e(this.uK);
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

    private boolean gM() {
        return this.oj.gT().responseCode == 200 || this.oj.gT().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) {
        dVar.vb = -1;
        try {
            String url = this.oj.gS().getUrl();
            dVar.url = url;
            URL url2 = new URL(url);
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            dVar.vb = -2;
            this.uK = c(url2);
            dVar.vb = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uK == null) {
                throw new SocketException("network not available.");
            }
            this.uK.setRequestMethod("POST");
            this.uK.setDoOutput(true);
            this.uK.setDoInput(true);
            this.uK.setConnectTimeout(i2);
            this.uK.setReadTimeout(i);
            this.uK.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            this.oj.gS().c(this.uK);
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uY = System.currentTimeMillis() - currentTimeMillis;
            dVar.vb = -4;
            this.uK.connect();
            this.uL = System.currentTimeMillis();
            dVar.vb = -5;
            dVar.uU = (System.currentTimeMillis() - currentTimeMillis) - dVar.uY;
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            dVar.vb = -6;
            this.oj.gS().a(this.uK, dVar);
            dVar.vb = -7;
            if (this.oj.gT().vl) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.am(this.uK.getContentType())) {
                this.uK.disconnect();
                this.uK.connect();
                if (this.oj.gT().vl) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.vb = -8;
            this.oj.gT().d(this.uK);
            dVar.va = this.oj.gT().responseCode;
            dVar.uT = this.uK.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.uK);
            if (b != null) {
                dVar.uT += b.length;
                this.oj.gT().vo = b.length;
                this.oj.gT().vn = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uV = new Date().getTime() - currentTimeMillis;
            dVar.vb = -9;
        } finally {
            com.baidu.adp.lib.h.a.e(this.uK);
        }
    }
}
