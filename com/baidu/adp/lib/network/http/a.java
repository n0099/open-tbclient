package com.baidu.adp.lib.network.http;

import com.baidu.adp.lib.util.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
    private static Pattern ke = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String kf = "--------7da3d81520810*";
    private e aN;
    private HttpURLConnection jZ;
    private long kb = 0;
    private long kc = 0;
    private long kd = 0;
    private TimerTask kg = new b(this);
    private Timer kh;

    public long dJ() {
        return this.kd;
    }

    public long dK() {
        return this.kc;
    }

    public long dL() {
        return this.kb;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.aN = eVar;
    }

    public void dM() {
        this.aN.dR().kE = true;
        com.baidu.adp.lib.g.a.e(this.jZ);
    }

    private HttpURLConnection a(URL url) {
        String fq;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!j.fh()) {
            return null;
        }
        if (j.fj() && (fq = j.fq()) != null && fq.length() > 0) {
            if (j.ay(fq)) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(fq);
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                this.jZ = (HttpURLConnection) new URL(sb.toString()).openConnection();
                this.aN.dQ().l("X-Online-Host", url.getHost());
            } else {
                this.jZ = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fq, j.fr())));
            }
        }
        if (this.jZ == null) {
            this.jZ = (HttpURLConnection) url.openConnection();
        }
        return this.jZ;
    }

    public void a(int i, int i2, d dVar) {
        dVar.kt = -1;
        if (this.aN.dR().kE) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.aN.dQ().b(dVar));
        if (this.aN.dR().kE) {
            throw new BdHttpCancelException();
        }
        dVar.kt = -2;
        HttpURLConnection a = a(url);
        dVar.kt = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.jZ == null) {
                throw new SocketException("network not available.");
            }
            this.jZ.setRequestMethod("GET");
            this.jZ.setConnectTimeout(i2);
            this.jZ.setReadTimeout(i);
            this.aN.dQ().b(a);
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kq = new Date().getTime() - currentTimeMillis;
            dVar.kt = -4;
            a.connect();
            this.kb = System.currentTimeMillis();
            dVar.kt = -5;
            dVar.km = (new Date().getTime() - currentTimeMillis) - dVar.kq;
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kt = -8;
            this.aN.dR().c(this.jZ);
            dVar.ks = this.aN.dR().responseCode;
            byte[] a2 = a(this.jZ);
            if (a2 != null) {
                dVar.kl = a2.length;
                this.aN.dR().kG = b(this.aN.dR().contentEncoding, a2);
            }
            dVar.kt = -9;
            dVar.ko = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.jZ != null) {
                this.jZ.disconnect();
            }
        }
    }

    protected final byte[] b(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.a(byteArrayInputStream, byteArrayOutputStream);
            this.kd = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] a(HttpURLConnection httpURLConnection) {
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
                while (!this.aN.dR().kE && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.kc = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.a(inputStream);
                        throw th;
                    }
                }
                if (this.aN.dR().kE) {
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
        this.kc = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.a(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.kt = -1;
        try {
            URL url = new URL(this.aN.dQ().getUrl());
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kt = -2;
            HttpURLConnection a = a(url);
            dVar.kt = -3;
            System.currentTimeMillis();
            if (this.jZ == null) {
                throw new SocketException("network not available.");
            }
            this.jZ.setRequestMethod("POST");
            this.jZ.setDoOutput(true);
            this.jZ.setDoInput(true);
            this.jZ.setConnectTimeout(i2);
            this.jZ.setReadTimeout(i);
            this.jZ.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + kf);
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            this.aN.dQ().b(a);
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.kq = new Date().getTime() - time;
            dVar.kt = -4;
            a.connect();
            this.kb = System.currentTimeMillis();
            dVar.kt = -5;
            dVar.km = (new Date().getTime() - time) - dVar.kq;
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            if (this.kh != null) {
                this.kh.schedule(this.kg, 45000L);
            }
            dVar.kt = -6;
            this.aN.dQ().a(a, kf, dVar);
            dVar.kt = -7;
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kt = -8;
            this.aN.dR().c(this.jZ);
            dVar.ks = this.aN.dR().responseCode;
            byte[] a2 = a(this.jZ);
            if (a2 != null) {
                dVar.kl = a2.length;
                this.aN.dR().kH = a2.length;
                this.aN.dR().kG = b(this.aN.dR().contentEncoding, a2);
            }
            dVar.ko = new Date().getTime() - time;
            dVar.kt = -9;
        } finally {
            if (this.kh != null) {
                this.kh.cancel();
            }
            com.baidu.adp.lib.g.a.e(this.jZ);
        }
    }

    public void c(int i, int i2, d dVar) {
        dVar.kt = -1;
        try {
            URL url = new URL(this.aN.dQ().getUrl());
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kt = -2;
            HttpURLConnection a = a(url);
            dVar.kt = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.jZ == null) {
                throw new SocketException("network not available.");
            }
            this.jZ.setRequestMethod("POST");
            this.jZ.setDoOutput(true);
            this.jZ.setDoInput(true);
            this.jZ.setConnectTimeout(i2);
            this.jZ.setReadTimeout(i);
            this.jZ.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            this.aN.dQ().b(a);
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kq = System.currentTimeMillis() - currentTimeMillis;
            dVar.kt = -4;
            a.connect();
            this.kb = System.currentTimeMillis();
            dVar.kt = -5;
            dVar.km = (System.currentTimeMillis() - currentTimeMillis) - dVar.kq;
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kt = -6;
            this.aN.dQ().a(a, dVar);
            dVar.kt = -7;
            if (this.aN.dR().kE) {
                throw new BdHttpCancelException();
            }
            dVar.kt = -8;
            this.aN.dR().c(this.jZ);
            dVar.ks = this.aN.dR().responseCode;
            byte[] a2 = a(this.jZ);
            if (a2 != null) {
                dVar.kl = a2.length;
                this.aN.dR().kH = a2.length;
                this.aN.dR().kG = b(this.aN.dR().contentEncoding, a2);
            }
            dVar.ko = new Date().getTime() - currentTimeMillis;
            dVar.kt = -9;
        } finally {
            com.baidu.adp.lib.g.a.e(this.jZ);
        }
    }
}
