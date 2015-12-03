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
    private HttpURLConnection uI;
    private long uJ = 0;
    private long uK = 0;
    private long uL = 0;
    private TimerTask uM = new b(this);
    private Timer uN = new Timer();
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long gI() {
        return this.uL;
    }

    public long gJ() {
        return this.uK;
    }

    public long gK() {
        return this.uJ;
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
        this.oj.gT().vj = true;
        com.baidu.adp.lib.h.a.e(this.uI);
    }

    private HttpURLConnection c(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String iZ;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.iP()) {
                if (i.iR() && (iZ = i.iZ()) != null && iZ.length() > 0) {
                    if (i.aQ(iZ) && i.jb()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(iZ);
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
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(iZ, i.ja())));
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
        dVar.uZ = -1;
        if (this.oj.gT().vj) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.oj.gS().c(dVar));
        if (this.oj.gT().vj) {
            throw new BdHttpCancelException();
        }
        dVar.uZ = -2;
        this.uI = c(url);
        dVar.uZ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uI == null) {
                throw new SocketException("network not available.");
            }
            this.uI.setRequestMethod("GET");
            this.uI.setConnectTimeout(i2);
            this.uI.setReadTimeout(i);
            this.oj.gS().c(this.uI);
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            dVar.uW = new Date().getTime() - currentTimeMillis;
            dVar.uZ = -4;
            this.uI.connect();
            this.uJ = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.uS = (new Date().getTime() - currentTimeMillis) - dVar.uW;
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.am(this.uI.getContentType())) {
                this.uI.disconnect();
                this.uI.connect();
                if (this.oj.gT().vj) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uZ = -8;
            this.oj.gT().d(this.uI);
            dVar.uY = this.oj.gT().responseCode;
            byte[] b = b(this.uI);
            if (b != null) {
                dVar.uR = b.length;
                this.oj.gT().vl = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uZ = -9;
            dVar.uT = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uI != null) {
                this.uI.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.uL = System.currentTimeMillis();
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
                while (!this.oj.gT().vj && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uK = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.e(inputStream);
                        throw th;
                    }
                }
                if (this.oj.gT().vj) {
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
        this.uK = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.h.a.e(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.uZ = -1;
        try {
            URL url = new URL(this.oj.gS().getUrl());
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -2;
            this.uI = c(url);
            dVar.uZ = -3;
            System.currentTimeMillis();
            if (this.uI == null) {
                throw new SocketException("network not available.");
            }
            this.uI.setRequestMethod("POST");
            this.uI.setDoOutput(true);
            this.uI.setDoInput(true);
            this.uI.setConnectTimeout(i2);
            this.uI.setReadTimeout(i);
            this.uI.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            this.oj.gS().c(this.uI);
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uW = new Date().getTime() - time;
            dVar.uZ = -4;
            this.uI.connect();
            this.uJ = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.uS = (new Date().getTime() - time) - dVar.uW;
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            if (this.uN != null) {
                this.uN.schedule(this.uM, 45000L);
            }
            dVar.uZ = -6;
            this.oj.gS().a(this.uI, boundary, dVar);
            dVar.uZ = -7;
            if (com.baidu.adp.lib.network.a.b.am(this.uI.getContentType())) {
                this.uI.disconnect();
                this.uI.connect();
                if (this.oj.gT().vj) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -8;
            this.oj.gT().d(this.uI);
            dVar.uY = this.oj.gT().responseCode;
            byte[] b = b(this.uI);
            if (b != null) {
                dVar.uR = b.length;
                this.oj.gT().vm = b.length;
                this.oj.gT().vl = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uT = new Date().getTime() - time;
            dVar.uZ = -9;
        } finally {
            if (this.uN != null) {
                this.uN.cancel();
            }
            com.baidu.adp.lib.h.a.e(this.uI);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [564=6, 565=6, 566=6, 567=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            this.uI = c(new URL(this.oj.gS().getUrl()));
            if (this.uI == null) {
                throw new SocketException();
            }
            this.uI.setConnectTimeout(i2);
            this.uI.setReadTimeout(i);
            if (this.oj.gT().vj) {
                this.uK = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.e((InputStream) null);
                com.baidu.adp.lib.h.a.e(this.uI);
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
                this.uI.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.oj.gS().c(this.uI);
                this.uI.connect();
                this.uJ = System.currentTimeMillis();
                this.oj.gT().responseCode = this.uI.getResponseCode();
                if (gM()) {
                    if (this.uI.getContentType().contains("text/vnd.wap.wml")) {
                        this.uI.disconnect();
                        this.oj.gT().responseCode = 0;
                        boolean a = a(str, hVar, i, i2, z, dVar2, z2);
                        this.uK = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uI);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.uI.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oj.gT().responseCode == 200 && (headerField = this.uI.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.oj.gT().contentLength = String.valueOf(g);
                    if (this.uI.getHeaderFields() != null && this.uI.getHeaderFields().toString() != null && this.uI.getHeaderFields().toString().getBytes() != null) {
                        dVar2.uQ = this.uI.getHeaderFields().toString().getBytes().length;
                    }
                    dVar2.uR = g;
                    if (this.oj.gT().responseCode == 416 || this.oj.gT().responseCode == 204) {
                        this.uK = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uI);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (length >= g) {
                        this.uK = System.currentTimeMillis();
                        this.uK = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.e((InputStream) null);
                        com.baidu.adp.lib.h.a.e(this.uI);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uI.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.c((int) length, g);
                            }
                            while (!this.oj.gT().vj) {
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
                                this.uK = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.e(inputStream2);
                                com.baidu.adp.lib.h.a.e(this.uI);
                                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uK = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.e(inputStream);
                            com.baidu.adp.lib.h.a.e(this.uI);
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
        dVar.uZ = -1;
        try {
            URL url = new URL(this.oj.gS().getUrl());
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -2;
            this.uI = c(url);
            dVar.uZ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uI == null) {
                throw new SocketException("network not available.");
            }
            this.uI.setRequestMethod("POST");
            this.uI.setDoOutput(true);
            this.uI.setDoInput(true);
            this.uI.setConnectTimeout(i2);
            this.uI.setReadTimeout(i);
            this.uI.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            this.oj.gS().c(this.uI);
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            dVar.uW = System.currentTimeMillis() - currentTimeMillis;
            dVar.uZ = -4;
            this.uI.connect();
            this.uJ = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.uS = (System.currentTimeMillis() - currentTimeMillis) - dVar.uW;
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -6;
            this.oj.gS().a(this.uI, dVar);
            dVar.uZ = -7;
            if (this.oj.gT().vj) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.am(this.uI.getContentType())) {
                this.uI.disconnect();
                this.uI.connect();
                if (this.oj.gT().vj) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uZ = -8;
            this.oj.gT().d(this.uI);
            dVar.uY = this.oj.gT().responseCode;
            byte[] b = b(this.uI);
            if (b != null) {
                dVar.uR = b.length;
                this.oj.gT().vm = b.length;
                this.oj.gT().vl = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uT = new Date().getTime() - currentTimeMillis;
            dVar.uZ = -9;
        } finally {
            com.baidu.adp.lib.h.a.e(this.uI);
        }
    }
}
