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
    private HttpURLConnection uE;
    private long uF = 0;
    private long uG = 0;
    private long uH = 0;
    private TimerTask uI = new b(this);
    private Timer uJ = new Timer();
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long gJ() {
        return this.uH;
    }

    public long gK() {
        return this.uG;
    }

    public long gL() {
        return this.uF;
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

    public void gM() {
        this.oj.gT().ve = true;
        com.baidu.adp.lib.g.a.e(this.uE);
    }

    private HttpURLConnection b(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String iY;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.iO()) {
                if (i.iQ() && (iY = i.iY()) != null && iY.length() > 0) {
                    if (i.aO(iY) && i.ja()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(iY);
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
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(iY, i.iZ())));
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
        dVar.uV = -1;
        if (this.oj.gT().ve) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.oj.gS().b(dVar));
        if (this.oj.gT().ve) {
            throw new BdHttpCancelException();
        }
        dVar.uV = -2;
        this.uE = b(url);
        dVar.uV = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uE == null) {
                throw new SocketException("network not available.");
            }
            this.uE.setRequestMethod("GET");
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            this.oj.gS().c(this.uE);
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            dVar.uS = new Date().getTime() - currentTimeMillis;
            dVar.uV = -4;
            this.uE.connect();
            this.uF = System.currentTimeMillis();
            dVar.uV = -5;
            dVar.uO = (new Date().getTime() - currentTimeMillis) - dVar.uS;
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.ak(this.uE.getContentType())) {
                this.uE.disconnect();
                this.uE.connect();
                if (this.oj.gT().ve) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uV = -8;
            this.oj.gT().d(this.uE);
            dVar.uU = this.oj.gT().responseCode;
            byte[] b = b(this.uE);
            if (b != null) {
                dVar.uN = b.length;
                this.oj.gT().vg = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uV = -9;
            dVar.uP = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uE != null) {
                this.uE.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream);
            this.uH = System.currentTimeMillis();
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
                while (!this.oj.gT().ve && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.oj.gT().ve) {
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
        this.uG = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.uV = -1;
        try {
            URL url = new URL(this.oj.gS().getUrl());
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            dVar.uV = -2;
            this.uE = b(url);
            dVar.uV = -3;
            System.currentTimeMillis();
            if (this.uE == null) {
                throw new SocketException("network not available.");
            }
            this.uE.setRequestMethod("POST");
            this.uE.setDoOutput(true);
            this.uE.setDoInput(true);
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            this.uE.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            this.oj.gS().c(this.uE);
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uS = new Date().getTime() - time;
            dVar.uV = -4;
            this.uE.connect();
            this.uF = System.currentTimeMillis();
            dVar.uV = -5;
            dVar.uO = (new Date().getTime() - time) - dVar.uS;
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            if (this.uJ != null) {
                this.uJ.schedule(this.uI, 45000L);
            }
            dVar.uV = -6;
            this.oj.gS().a(this.uE, boundary, dVar);
            dVar.uV = -7;
            if (com.baidu.adp.lib.network.a.b.ak(this.uE.getContentType())) {
                this.uE.disconnect();
                this.uE.connect();
                if (this.oj.gT().ve) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            dVar.uV = -8;
            this.oj.gT().d(this.uE);
            dVar.uU = this.oj.gT().responseCode;
            byte[] b = b(this.uE);
            if (b != null) {
                dVar.uN = b.length;
                this.oj.gT().vh = b.length;
                this.oj.gT().vg = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uP = new Date().getTime() - time;
            dVar.uV = -9;
        } finally {
            if (this.uJ != null) {
                this.uJ.cancel();
            }
            com.baidu.adp.lib.g.a.e(this.uE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [561=6, 562=6, 563=6, 564=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        try {
            this.uE = b(new URL(this.oj.gS().getUrl()));
            if (this.uE == null) {
                throw new SocketException();
            }
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            if (this.oj.gT().ve) {
                this.uG = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.e(this.uE);
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
                this.uE.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.oj.gS().c(this.uE);
                this.uE.connect();
                this.uF = System.currentTimeMillis();
                this.oj.gT().responseCode = this.uE.getResponseCode();
                if (gN()) {
                    if (this.uE.getContentType().contains("text/vnd.wap.wml")) {
                        this.uE.disconnect();
                        this.oj.gT().responseCode = 0;
                        boolean a = a(str, hVar, i, i2, z, dVar, z2);
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uE);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.uE.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oj.gT().responseCode == 200 && (headerField = this.uE.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.oj.gT().contentLength = String.valueOf(g);
                    if (dVar == null) {
                        dVar = new d();
                    }
                    if (this.uE.getHeaderFields() != null && this.uE.getHeaderFields().toString() != null && this.uE.getHeaderFields().toString().getBytes() != null) {
                        dVar.uM = this.uE.getHeaderFields().toString().getBytes().length;
                    }
                    dVar.uN = g;
                    if (this.oj.gT().responseCode == 416 || this.oj.gT().responseCode == 204) {
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uE);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (length >= g) {
                        this.uG = System.currentTimeMillis();
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uE);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uE.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.c((int) length, g);
                            }
                            while (!this.oj.gT().ve) {
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
                                this.uG = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.e(this.uE);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uG = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.e(this.uE);
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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

    private boolean gN() {
        return this.oj.gT().responseCode == 200 || this.oj.gT().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) {
        dVar.uV = -1;
        try {
            URL url = new URL(this.oj.gS().getUrl());
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            dVar.uV = -2;
            this.uE = b(url);
            dVar.uV = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uE == null) {
                throw new SocketException("network not available.");
            }
            this.uE.setRequestMethod("POST");
            this.uE.setDoOutput(true);
            this.uE.setDoInput(true);
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            this.uE.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            this.oj.gS().c(this.uE);
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            dVar.uS = System.currentTimeMillis() - currentTimeMillis;
            dVar.uV = -4;
            this.uE.connect();
            this.uF = System.currentTimeMillis();
            dVar.uV = -5;
            dVar.uO = (System.currentTimeMillis() - currentTimeMillis) - dVar.uS;
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            dVar.uV = -6;
            this.oj.gS().a(this.uE, dVar);
            dVar.uV = -7;
            if (this.oj.gT().ve) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.ak(this.uE.getContentType())) {
                this.uE.disconnect();
                this.uE.connect();
                if (this.oj.gT().ve) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uV = -8;
            this.oj.gT().d(this.uE);
            dVar.uU = this.oj.gT().responseCode;
            byte[] b = b(this.uE);
            if (b != null) {
                dVar.uN = b.length;
                this.oj.gT().vh = b.length;
                this.oj.gT().vg = c(this.oj.gT().contentEncoding, b);
            }
            dVar.uP = new Date().getTime() - currentTimeMillis;
            dVar.uV = -9;
        } finally {
            com.baidu.adp.lib.g.a.e(this.uE);
        }
    }
}
