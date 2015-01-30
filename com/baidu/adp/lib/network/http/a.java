package com.baidu.adp.lib.network.http;

import com.baidu.adp.lib.util.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    private e cU;
    private HttpURLConnection kf;
    private long kg = 0;
    private long kh = 0;
    private long ki = 0;
    private TimerTask kk = new b(this);
    private Timer kl;
    private static Pattern kj = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long dG() {
        return this.ki;
    }

    public long dH() {
        return this.kh;
    }

    public long dI() {
        return this.kg;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.cU = eVar;
    }

    public void dJ() {
        this.cU.dO().kI = true;
        com.baidu.adp.lib.g.a.f(this.kf);
    }

    private HttpURLConnection a(URL url) {
        String fo;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!i.ff()) {
            return null;
        }
        if (i.fh() && (fo = i.fo()) != null && fo.length() > 0) {
            if (i.aB(fo)) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(fo);
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                this.kf = (HttpURLConnection) new URL(sb.toString()).openConnection();
                this.cU.dN().p("X-Online-Host", url.getHost());
            } else {
                this.kf = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fo, i.fp())));
            }
        }
        if (this.kf == null) {
            this.kf = (HttpURLConnection) url.openConnection();
        }
        return this.kf;
    }

    public void a(int i, int i2, d dVar) {
        dVar.ky = -1;
        if (this.cU.dO().kI) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.cU.dN().b(dVar));
        if (this.cU.dO().kI) {
            throw new BdHttpCancelException();
        }
        dVar.ky = -2;
        HttpURLConnection a = a(url);
        dVar.ky = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.kf == null) {
                throw new SocketException("network not available.");
            }
            this.kf.setRequestMethod("GET");
            this.kf.setConnectTimeout(i2);
            this.kf.setReadTimeout(i);
            this.cU.dN().c(a);
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ku = new Date().getTime() - currentTimeMillis;
            dVar.ky = -4;
            a.connect();
            this.kg = System.currentTimeMillis();
            dVar.ky = -5;
            dVar.kr = (new Date().getTime() - currentTimeMillis) - dVar.ku;
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ky = -8;
            this.cU.dO().d(this.kf);
            dVar.kx = this.cU.dO().responseCode;
            byte[] b = b(this.kf);
            if (b != null) {
                dVar.kq = b.length;
                this.cU.dO().kK = c(this.cU.dO().contentEncoding, b);
            }
            dVar.ky = -9;
            dVar.ks = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.kf != null) {
                this.kf.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.b(byteArrayInputStream, byteArrayOutputStream);
            this.ki = System.currentTimeMillis();
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
                while (!this.cU.dO().kI && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.kh = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.cU.dO().kI) {
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
        this.kh = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.ky = -1;
        try {
            URL url = new URL(this.cU.dN().getUrl());
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ky = -2;
            HttpURLConnection a = a(url);
            dVar.ky = -3;
            System.currentTimeMillis();
            if (this.kf == null) {
                throw new SocketException("network not available.");
            }
            this.kf.setRequestMethod("POST");
            this.kf.setDoOutput(true);
            this.kf.setDoInput(true);
            this.kf.setConnectTimeout(i2);
            this.kf.setReadTimeout(i);
            this.kf.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            this.cU.dN().c(a);
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.ku = new Date().getTime() - time;
            dVar.ky = -4;
            a.connect();
            this.kg = System.currentTimeMillis();
            dVar.ky = -5;
            dVar.kr = (new Date().getTime() - time) - dVar.ku;
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            if (this.kl != null) {
                this.kl.schedule(this.kk, 45000L);
            }
            dVar.ky = -6;
            this.cU.dN().a(a, boundary, dVar);
            dVar.ky = -7;
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ky = -8;
            this.cU.dO().d(this.kf);
            dVar.kx = this.cU.dO().responseCode;
            byte[] b = b(this.kf);
            if (b != null) {
                dVar.kq = b.length;
                this.cU.dO().kL = b.length;
                this.cU.dO().kK = c(this.cU.dO().contentEncoding, b);
            }
            dVar.ks = new Date().getTime() - time;
            dVar.ky = -9;
        } finally {
            if (this.kl != null) {
                this.kl.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.kf);
        }
    }

    public void c(int i, int i2, d dVar) {
        dVar.ky = -1;
        try {
            URL url = new URL(this.cU.dN().getUrl());
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ky = -2;
            HttpURLConnection a = a(url);
            dVar.ky = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.kf == null) {
                throw new SocketException("network not available.");
            }
            this.kf.setRequestMethod("POST");
            this.kf.setDoOutput(true);
            this.kf.setDoInput(true);
            this.kf.setConnectTimeout(i2);
            this.kf.setReadTimeout(i);
            this.kf.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            this.cU.dN().c(a);
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ku = System.currentTimeMillis() - currentTimeMillis;
            dVar.ky = -4;
            a.connect();
            this.kg = System.currentTimeMillis();
            dVar.ky = -5;
            dVar.kr = (System.currentTimeMillis() - currentTimeMillis) - dVar.ku;
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ky = -6;
            this.cU.dN().a(a, dVar);
            dVar.ky = -7;
            if (this.cU.dO().kI) {
                throw new BdHttpCancelException();
            }
            dVar.ky = -8;
            this.cU.dO().d(this.kf);
            dVar.kx = this.cU.dO().responseCode;
            byte[] b = b(this.kf);
            if (b != null) {
                dVar.kq = b.length;
                this.cU.dO().kL = b.length;
                this.cU.dO().kK = c(this.cU.dO().contentEncoding, b);
            }
            dVar.ks = new Date().getTime() - currentTimeMillis;
            dVar.ky = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.kf);
        }
    }
}
