package com.baidu.adp.lib.network.http;

import com.baidu.adp.lib.util.k;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    private e oj;
    private HttpURLConnection uH;
    private long uI = 0;
    private long uJ = 0;
    private long uK = 0;
    private TimerTask uM = new b(this);
    private Timer uN = new Timer();
    private static Pattern uL = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long gP() {
        return this.uK;
    }

    public long gQ() {
        return this.uJ;
    }

    public long gR() {
        return this.uI;
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

    public void gS() {
        this.oj.gZ().vi = true;
        com.baidu.adp.lib.g.a.e(this.uH);
    }

    private HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String jg;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (k.iX()) {
                if (k.iZ() && (jg = k.jg()) != null && jg.length() > 0) {
                    if (k.aS(jg) && k.ji()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jg);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.oj.gY().p("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jg, k.jh())));
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
        if (this.oj.gZ().vi) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.oj.gY().b(dVar));
        if (this.oj.gZ().vi) {
            throw new BdHttpCancelException();
        }
        dVar.uZ = -2;
        this.uH = a(url);
        dVar.uZ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uH == null) {
                throw new SocketException("network not available.");
            }
            this.uH.setRequestMethod("GET");
            this.uH.setConnectTimeout(i2);
            this.uH.setReadTimeout(i);
            this.oj.gY().c(this.uH);
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            dVar.uW = new Date().getTime() - currentTimeMillis;
            dVar.uZ = -4;
            this.uH.connect();
            this.uI = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.uS = (new Date().getTime() - currentTimeMillis) - dVar.uW;
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.al(this.uH.getContentType())) {
                this.uH.disconnect();
                this.uH.connect();
                if (this.oj.gZ().vi) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uZ = -8;
            this.oj.gZ().d(this.uH);
            dVar.uY = this.oj.gZ().responseCode;
            byte[] b = b(this.uH);
            if (b != null) {
                dVar.uR = b.length;
                this.oj.gZ().vk = c(this.oj.gZ().contentEncoding, b);
            }
            dVar.uZ = -9;
            dVar.uT = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uH != null) {
                this.uH.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream);
            this.uK = System.currentTimeMillis();
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
                while (!this.oj.gZ().vi && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.oj.gZ().vi) {
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
        this.uJ = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.uZ = -1;
        try {
            URL url = new URL(this.oj.gY().getUrl());
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -2;
            this.uH = a(url);
            dVar.uZ = -3;
            System.currentTimeMillis();
            if (this.uH == null) {
                throw new SocketException("network not available.");
            }
            this.uH.setRequestMethod("POST");
            this.uH.setDoOutput(true);
            this.uH.setDoInput(true);
            this.uH.setConnectTimeout(i2);
            this.uH.setReadTimeout(i);
            this.uH.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            this.oj.gY().c(this.uH);
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uW = new Date().getTime() - time;
            dVar.uZ = -4;
            this.uH.connect();
            this.uI = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.uS = (new Date().getTime() - time) - dVar.uW;
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            if (this.uN != null) {
                this.uN.schedule(this.uM, 45000L);
            }
            dVar.uZ = -6;
            this.oj.gY().a(this.uH, boundary, dVar);
            dVar.uZ = -7;
            if (com.baidu.adp.lib.network.a.b.al(this.uH.getContentType())) {
                this.uH.disconnect();
                this.uH.connect();
                if (this.oj.gZ().vi) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -8;
            this.oj.gZ().d(this.uH);
            dVar.uY = this.oj.gZ().responseCode;
            byte[] b = b(this.uH);
            if (b != null) {
                dVar.uR = b.length;
                this.oj.gZ().vl = b.length;
                this.oj.gZ().vk = c(this.oj.gZ().contentEncoding, b);
            }
            dVar.uT = new Date().getTime() - time;
            dVar.uZ = -9;
        } finally {
            if (this.uN != null) {
                this.uN.cancel();
            }
            com.baidu.adp.lib.g.a.e(this.uH);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [561=6, 562=6, 563=6, 564=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        try {
            this.uH = a(new URL(this.oj.gY().getUrl()));
            if (this.uH == null) {
                throw new SocketException();
            }
            this.uH.setConnectTimeout(i2);
            this.uH.setReadTimeout(i);
            if (this.oj.gZ().vi) {
                this.uJ = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.e(this.uH);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aO(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aM(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.uH.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.oj.gY().c(this.uH);
                this.uH.connect();
                this.uI = System.currentTimeMillis();
                this.oj.gZ().responseCode = this.uH.getResponseCode();
                if (gT()) {
                    if (this.uH.getContentType().contains("text/vnd.wap.wml")) {
                        this.uH.disconnect();
                        this.oj.gZ().responseCode = 0;
                        boolean a = a(str, hVar, i, i2, z, dVar, z2);
                        this.uJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uH);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.uH.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.c.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.oj.gZ().responseCode == 200 && (headerField = this.uH.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.c.toInt(headerField, 0) : i3;
                    this.oj.gZ().contentLength = String.valueOf(i4);
                    if (dVar == null) {
                        dVar = new d();
                    }
                    if (this.uH.getHeaderFields() != null && this.uH.getHeaderFields().toString() != null && this.uH.getHeaderFields().toString().getBytes() != null) {
                        dVar.uQ = this.uH.getHeaderFields().toString().getBytes().length;
                    }
                    dVar.uR = i4;
                    if (this.oj.gZ().responseCode == 416 || this.oj.gZ().responseCode == 204) {
                        this.uJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uH);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return true;
                    } else if (length >= i4) {
                        this.uJ = System.currentTimeMillis();
                        this.uJ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.e(this.uH);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uH.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (hVar != null && length > 0) {
                                hVar.onProgress((int) length, i4);
                            }
                            while (!this.oj.gZ().vi) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i5 += read;
                                        i7 += read;
                                        if (hVar != null && (i7 > i6 || i5 == i4)) {
                                            i7 = 0;
                                            hVar.onProgress((int) (i5 + length), i4);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i5) + length >= ((long) i4);
                                this.uJ = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.e(this.uH);
                                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uJ = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.e(this.uH);
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

    private boolean gT() {
        return this.oj.gZ().responseCode == 200 || this.oj.gZ().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) {
        dVar.uZ = -1;
        try {
            URL url = new URL(this.oj.gY().getUrl());
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -2;
            this.uH = a(url);
            dVar.uZ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uH == null) {
                throw new SocketException("network not available.");
            }
            this.uH.setRequestMethod("POST");
            this.uH.setDoOutput(true);
            this.uH.setDoInput(true);
            this.uH.setConnectTimeout(i2);
            this.uH.setReadTimeout(i);
            this.uH.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            this.oj.gY().c(this.uH);
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            dVar.uW = System.currentTimeMillis() - currentTimeMillis;
            dVar.uZ = -4;
            this.uH.connect();
            this.uI = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.uS = (System.currentTimeMillis() - currentTimeMillis) - dVar.uW;
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -6;
            this.oj.gY().a(this.uH, dVar);
            dVar.uZ = -7;
            if (this.oj.gZ().vi) {
                throw new BdHttpCancelException();
            }
            if (com.baidu.adp.lib.network.a.b.al(this.uH.getContentType())) {
                this.uH.disconnect();
                this.uH.connect();
                if (this.oj.gZ().vi) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uZ = -8;
            this.oj.gZ().d(this.uH);
            dVar.uY = this.oj.gZ().responseCode;
            byte[] b = b(this.uH);
            if (b != null) {
                dVar.uR = b.length;
                this.oj.gZ().vl = b.length;
                this.oj.gZ().vk = c(this.oj.gZ().contentEncoding, b);
            }
            dVar.uT = new Date().getTime() - currentTimeMillis;
            dVar.uZ = -9;
        } finally {
            com.baidu.adp.lib.g.a.e(this.uH);
        }
    }
}
