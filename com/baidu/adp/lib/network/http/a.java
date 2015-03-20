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
    private e oe;
    private HttpURLConnection vv;
    private static Pattern vz = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long vw = 0;
    private long vx = 0;
    private long vy = 0;
    private TimerTask vA = new b(this);
    private Timer vB = new Timer();

    public long he() {
        return this.vy;
    }

    public long hf() {
        return this.vx;
    }

    public long hg() {
        return this.vw;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.oe = eVar;
    }

    public void hh() {
        this.oe.hn().vW = true;
        com.baidu.adp.lib.g.a.f(this.vv);
    }

    private HttpURLConnection a(URL url) {
        String iQ;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!k.iH()) {
            return null;
        }
        if (k.iJ() && (iQ = k.iQ()) != null && iQ.length() > 0) {
            if (k.aJ(iQ) && k.iS()) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(iQ);
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                this.vv = (HttpURLConnection) new URL(sb.toString()).openConnection();
                this.oe.hm().p("X-Online-Host", url.getHost());
            } else {
                this.vv = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(iQ, k.iR())));
            }
        }
        if (this.vv == null) {
            this.vv = (HttpURLConnection) url.openConnection();
        }
        return this.vv;
    }

    public void a(int i, int i2, d dVar) {
        dVar.vN = -1;
        if (this.oe.hn().vW) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.oe.hm().b(dVar));
        if (this.oe.hn().vW) {
            throw new BdHttpCancelException();
        }
        dVar.vN = -2;
        HttpURLConnection a = a(url);
        dVar.vN = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.vv == null) {
                throw new SocketException("network not available.");
            }
            this.vv.setRequestMethod("GET");
            this.vv.setConnectTimeout(i2);
            this.vv.setReadTimeout(i);
            this.oe.hm().c(a);
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vK = new Date().getTime() - currentTimeMillis;
            dVar.vN = -4;
            a.connect();
            this.vw = System.currentTimeMillis();
            dVar.vN = -5;
            dVar.vG = (new Date().getTime() - currentTimeMillis) - dVar.vK;
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vN = -8;
            this.oe.hn().d(this.vv);
            dVar.vM = this.oe.hn().responseCode;
            byte[] b = b(this.vv);
            if (b != null) {
                dVar.vF = b.length;
                this.oe.hn().vY = c(this.oe.hn().contentEncoding, b);
            }
            dVar.vN = -9;
            dVar.vH = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.vv != null) {
                this.vv.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream);
            this.vy = System.currentTimeMillis();
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
                while (!this.oe.hn().vW && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.vx = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.oe.hn().vW) {
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
        this.vx = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.vN = -1;
        try {
            URL url = new URL(this.oe.hm().getUrl());
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vN = -2;
            HttpURLConnection a = a(url);
            dVar.vN = -3;
            System.currentTimeMillis();
            if (this.vv == null) {
                throw new SocketException("network not available.");
            }
            this.vv.setRequestMethod("POST");
            this.vv.setDoOutput(true);
            this.vv.setDoInput(true);
            this.vv.setConnectTimeout(i2);
            this.vv.setReadTimeout(i);
            this.vv.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            this.oe.hm().c(a);
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.vK = new Date().getTime() - time;
            dVar.vN = -4;
            a.connect();
            this.vw = System.currentTimeMillis();
            dVar.vN = -5;
            dVar.vG = (new Date().getTime() - time) - dVar.vK;
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            if (this.vB != null) {
                this.vB.schedule(this.vA, 45000L);
            }
            dVar.vN = -6;
            this.oe.hm().a(a, boundary, dVar);
            dVar.vN = -7;
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vN = -8;
            this.oe.hn().d(this.vv);
            dVar.vM = this.oe.hn().responseCode;
            byte[] b = b(this.vv);
            if (b != null) {
                dVar.vF = b.length;
                this.oe.hn().vZ = b.length;
                this.oe.hn().vY = c(this.oe.hn().contentEncoding, b);
            }
            dVar.vH = new Date().getTime() - time;
            dVar.vN = -9;
        } finally {
            if (this.vB != null) {
                this.vB.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.vv);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [477=6, 478=6, 479=6, 480=6] */
    public boolean a(String str, h hVar, int i, int i2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        try {
            this.vv = a(new URL(this.oe.hm().getUrl()));
            if (this.vv == null) {
                throw new SocketException();
            }
            this.vv.setConnectTimeout(i2);
            this.vv.setReadTimeout(i);
            this.vv.setInstanceFollowRedirects(false);
            if (this.oe.hn().vW) {
                this.vx = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.vv);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            File aD = com.baidu.adp.lib.util.f.aD(str);
            if (aD == null) {
                throw new FileNotFoundException();
            }
            long length = aD.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(aD, true);
            try {
                this.vv.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.vv.connect();
                this.vw = System.currentTimeMillis();
                this.oe.hn().responseCode = this.vv.getResponseCode();
                if (hi()) {
                    if (this.vv.getContentType().contains("text/vnd.wap.wml")) {
                        this.vv.disconnect();
                        this.oe.hn().responseCode = 0;
                        boolean a = a(str, hVar, i, i2);
                        this.vx = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.vv);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return a;
                    }
                    int i3 = 0;
                    String headerField2 = this.vv.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.c.toInt(headerField2.substring(indexOf + 1), 0);
                    }
                    int i4 = (i3 == 0 && this.oe.hn().responseCode == 200 && (headerField = this.vv.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.c.toInt(headerField, 0) : i3;
                    this.oe.hn().contentLength = String.valueOf(i4);
                    if (this.oe.hn().responseCode == 416 || this.oe.hn().responseCode == 204) {
                        this.vx = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.vv);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return true;
                    } else if (length >= i4) {
                        this.vx = System.currentTimeMillis();
                        this.vx = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.vv);
                        com.baidu.adp.lib.g.a.b(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.vv.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i5 = 0;
                            int i6 = i4 > 0 ? i4 / 50 : 0;
                            int i7 = 0;
                            if (hVar != null && length > 0) {
                                hVar.onProgress((int) length, i4);
                            }
                            while (!this.oe.hn().vW) {
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
                                boolean z = ((long) i5) + length >= ((long) i4);
                                this.vx = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.vv);
                                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                                return z;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.vx = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.vv);
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

    private boolean hi() {
        return this.oe.hn().responseCode == 200 || this.oe.hn().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) {
        dVar.vN = -1;
        try {
            URL url = new URL(this.oe.hm().getUrl());
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vN = -2;
            HttpURLConnection a = a(url);
            dVar.vN = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.vv == null) {
                throw new SocketException("network not available.");
            }
            this.vv.setRequestMethod("POST");
            this.vv.setDoOutput(true);
            this.vv.setDoInput(true);
            this.vv.setConnectTimeout(i2);
            this.vv.setReadTimeout(i);
            this.vv.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            this.oe.hm().c(a);
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vK = System.currentTimeMillis() - currentTimeMillis;
            dVar.vN = -4;
            a.connect();
            this.vw = System.currentTimeMillis();
            dVar.vN = -5;
            dVar.vG = (System.currentTimeMillis() - currentTimeMillis) - dVar.vK;
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vN = -6;
            this.oe.hm().a(a, dVar);
            dVar.vN = -7;
            if (this.oe.hn().vW) {
                throw new BdHttpCancelException();
            }
            dVar.vN = -8;
            this.oe.hn().d(this.vv);
            dVar.vM = this.oe.hn().responseCode;
            byte[] b = b(this.vv);
            if (b != null) {
                dVar.vF = b.length;
                this.oe.hn().vZ = b.length;
                this.oe.hn().vY = c(this.oe.hn().contentEncoding, b);
            }
            dVar.vH = new Date().getTime() - currentTimeMillis;
            dVar.vN = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.vv);
        }
    }
}
