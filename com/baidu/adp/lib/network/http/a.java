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
    private HttpURLConnection uC;
    private long uD = 0;
    private long uE = 0;
    private long uF = 0;
    private TimerTask uG = new b(this);
    private Timer uH = new Timer();
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long gG() {
        return this.uF;
    }

    public long gH() {
        return this.uE;
    }

    public long gI() {
        return this.uD;
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

    public void gJ() {
        this.oj.gQ().vd = true;
        com.baidu.adp.lib.g.a.e(this.uC);
    }

    private HttpURLConnection b(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String iW;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.iM()) {
                if (i.iO() && (iW = i.iW()) != null && iW.length() > 0) {
                    if (i.aO(iW) && i.iY()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(iW);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.oj.gP().p("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(iW, i.iX())));
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
        dVar.uT = -1;
        if (this.oj.gQ().vd) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.oj.gP().c(dVar));
        if (this.oj.gQ().vd) {
            throw new BdHttpCancelException();
        }
        dVar.uT = -2;
        this.uC = b(url);
        dVar.uT = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uC == null) {
                throw new SocketException("network not available.");
            }
            this.uC.setRequestMethod("GET");
            this.uC.setConnectTimeout(i2);
            this.uC.setReadTimeout(i);
            this.oj.gP().c(this.uC);
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            dVar.uQ = new Date().getTime() - currentTimeMillis;
            dVar.uT = -4;
            this.uC.connect();
            this.uD = System.currentTimeMillis();
            dVar.uT = -5;
            dVar.uM = (new Date().getTime() - currentTimeMillis) - dVar.uQ;
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.ak(this.uC.getContentType())) {
                this.uC.disconnect();
                this.uC.connect();
                if (this.oj.gQ().vd) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uT = -8;
            this.oj.gQ().d(this.uC);
            dVar.uS = this.oj.gQ().responseCode;
            byte[] b = b(this.uC);
            if (b != null) {
                dVar.uL = b.length;
                this.oj.gQ().vf = c(this.oj.gQ().contentEncoding, b);
            }
            dVar.uT = -9;
            dVar.uN = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uC != null) {
                this.uC.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
            this.uF = System.currentTimeMillis();
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
                while (!this.oj.gQ().vd && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uE = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.oj.gQ().vd) {
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
        this.uE = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.uT = -1;
        try {
            URL url = new URL(this.oj.gP().getUrl());
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            dVar.uT = -2;
            this.uC = b(url);
            dVar.uT = -3;
            System.currentTimeMillis();
            if (this.uC == null) {
                throw new SocketException("network not available.");
            }
            this.uC.setRequestMethod("POST");
            this.uC.setDoOutput(true);
            this.uC.setDoInput(true);
            this.uC.setConnectTimeout(i2);
            this.uC.setReadTimeout(i);
            this.uC.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            this.oj.gP().c(this.uC);
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uQ = new Date().getTime() - time;
            dVar.uT = -4;
            this.uC.connect();
            this.uD = System.currentTimeMillis();
            dVar.uT = -5;
            dVar.uM = (new Date().getTime() - time) - dVar.uQ;
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            if (this.uH != null) {
                this.uH.schedule(this.uG, 45000L);
            }
            dVar.uT = -6;
            this.oj.gP().a(this.uC, boundary, dVar);
            dVar.uT = -7;
            if (com.baidu.adp.lib.network.a.b.ak(this.uC.getContentType())) {
                this.uC.disconnect();
                this.uC.connect();
                if (this.oj.gQ().vd) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            dVar.uT = -8;
            this.oj.gQ().d(this.uC);
            dVar.uS = this.oj.gQ().responseCode;
            byte[] b = b(this.uC);
            if (b != null) {
                dVar.uL = b.length;
                this.oj.gQ().vg = b.length;
                this.oj.gQ().vf = c(this.oj.gQ().contentEncoding, b);
            }
            dVar.uN = new Date().getTime() - time;
            dVar.uT = -9;
        } finally {
            if (this.uH != null) {
                this.uH.cancel();
            }
            com.baidu.adp.lib.g.a.e(this.uC);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [561=6, 562=6, 563=6, 564=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        try {
            this.uC = b(new URL(this.oj.gP().getUrl()));
            if (this.uC == null) {
                throw new SocketException();
            }
            this.uC.setConnectTimeout(i2);
            this.uC.setReadTimeout(i);
            if (this.oj.gQ().vd) {
                this.uE = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.e(this.uC);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aI(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aG(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.uC.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.oj.gP().c(this.uC);
                this.uC.connect();
                this.uD = System.currentTimeMillis();
                this.oj.gQ().responseCode = this.uC.getResponseCode();
                if (gK()) {
                    if (this.uC.getContentType().contains("text/vnd.wap.wml")) {
                        this.uC.disconnect();
                        this.oj.gQ().responseCode = 0;
                        boolean a = a(str, hVar, i, i2, z, dVar, z2);
                        this.uE = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uC);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.uC.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oj.gQ().responseCode == 200 && (headerField = this.uC.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.oj.gQ().contentLength = String.valueOf(g);
                    if (dVar == null) {
                        dVar = new d();
                    }
                    if (this.uC.getHeaderFields() != null && this.uC.getHeaderFields().toString() != null && this.uC.getHeaderFields().toString().getBytes() != null) {
                        dVar.uK = this.uC.getHeaderFields().toString().getBytes().length;
                    }
                    dVar.uL = g;
                    if (this.oj.gQ().responseCode == 416 || this.oj.gQ().responseCode == 204) {
                        this.uE = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uC);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return true;
                    } else if (length >= g) {
                        this.uE = System.currentTimeMillis();
                        this.uE = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uC);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uC.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.c((int) length, g);
                            }
                            while (!this.oj.gQ().vd) {
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
                                this.uE = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.e(this.uC);
                                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uE = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.e(this.uC);
                            com.baidu.adp.lib.g.a.b(fileOutputStream);
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

    private boolean gK() {
        return this.oj.gQ().responseCode == 200 || this.oj.gQ().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) {
        dVar.uT = -1;
        try {
            URL url = new URL(this.oj.gP().getUrl());
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            dVar.uT = -2;
            this.uC = b(url);
            dVar.uT = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uC == null) {
                throw new SocketException("network not available.");
            }
            this.uC.setRequestMethod("POST");
            this.uC.setDoOutput(true);
            this.uC.setDoInput(true);
            this.uC.setConnectTimeout(i2);
            this.uC.setReadTimeout(i);
            this.uC.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            this.oj.gP().c(this.uC);
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            dVar.uQ = System.currentTimeMillis() - currentTimeMillis;
            dVar.uT = -4;
            this.uC.connect();
            this.uD = System.currentTimeMillis();
            dVar.uT = -5;
            dVar.uM = (System.currentTimeMillis() - currentTimeMillis) - dVar.uQ;
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            dVar.uT = -6;
            this.oj.gP().a(this.uC, dVar);
            dVar.uT = -7;
            if (this.oj.gQ().vd) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.ak(this.uC.getContentType())) {
                this.uC.disconnect();
                this.uC.connect();
                if (this.oj.gQ().vd) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uT = -8;
            this.oj.gQ().d(this.uC);
            dVar.uS = this.oj.gQ().responseCode;
            byte[] b = b(this.uC);
            if (b != null) {
                dVar.uL = b.length;
                this.oj.gQ().vg = b.length;
                this.oj.gQ().vf = c(this.oj.gQ().contentEncoding, b);
            }
            dVar.uN = new Date().getTime() - currentTimeMillis;
            dVar.uT = -9;
        } finally {
            com.baidu.adp.lib.g.a.e(this.uC);
        }
    }
}
