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
    private e cT;
    private HttpURLConnection kc;
    private long kd = 0;
    private long ke = 0;
    private long kf = 0;
    private TimerTask kh = new b(this);
    private Timer ki;
    private static Pattern kg = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";

    public long dI() {
        return this.kf;
    }

    public long dJ() {
        return this.ke;
    }

    public long dK() {
        return this.kd;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.cT = eVar;
    }

    public void dL() {
        this.cT.dQ().kF = true;
        com.baidu.adp.lib.g.a.f(this.kc);
    }

    private HttpURLConnection a(URL url) {
        String fp;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!i.fg()) {
            return null;
        }
        if (i.fi() && (fp = i.fp()) != null && fp.length() > 0) {
            if (i.aB(fp)) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(fp);
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                this.kc = (HttpURLConnection) new URL(sb.toString()).openConnection();
                this.cT.dP().p("X-Online-Host", url.getHost());
            } else {
                this.kc = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fp, i.fq())));
            }
        }
        if (this.kc == null) {
            this.kc = (HttpURLConnection) url.openConnection();
        }
        return this.kc;
    }

    public void a(int i, int i2, d dVar) {
        dVar.ku = -1;
        if (this.cT.dQ().kF) {
            throw new BdHttpCancelException();
        }
        URL url = new URL(this.cT.dP().b(dVar));
        if (this.cT.dQ().kF) {
            throw new BdHttpCancelException();
        }
        dVar.ku = -2;
        HttpURLConnection a = a(url);
        dVar.ku = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.kc == null) {
                throw new SocketException("network not available.");
            }
            this.kc.setRequestMethod("GET");
            this.kc.setConnectTimeout(i2);
            this.kc.setReadTimeout(i);
            this.cT.dP().c(a);
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.kr = new Date().getTime() - currentTimeMillis;
            dVar.ku = -4;
            a.connect();
            this.kd = System.currentTimeMillis();
            dVar.ku = -5;
            dVar.ko = (new Date().getTime() - currentTimeMillis) - dVar.kr;
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.ku = -8;
            this.cT.dQ().d(this.kc);
            dVar.kt = this.cT.dQ().responseCode;
            byte[] b = b(this.kc);
            if (b != null) {
                dVar.km = b.length;
                this.cT.dQ().kH = c(this.cT.dQ().contentEncoding, b);
            }
            dVar.ku = -9;
            dVar.kp = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.kc != null) {
                this.kc.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.b(byteArrayInputStream, byteArrayOutputStream);
            this.kf = System.currentTimeMillis();
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
                while (!this.cT.dQ().kF && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.ke = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.cT.dQ().kF) {
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
        this.ke = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) {
        dVar.ku = -1;
        try {
            URL url = new URL(this.cT.dP().getUrl());
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.ku = -2;
            HttpURLConnection a = a(url);
            dVar.ku = -3;
            System.currentTimeMillis();
            if (this.kc == null) {
                throw new SocketException("network not available.");
            }
            this.kc.setRequestMethod("POST");
            this.kc.setDoOutput(true);
            this.kc.setDoInput(true);
            this.kc.setConnectTimeout(i2);
            this.kc.setReadTimeout(i);
            this.kc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            this.cT.dP().c(a);
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.kr = new Date().getTime() - time;
            dVar.ku = -4;
            a.connect();
            this.kd = System.currentTimeMillis();
            dVar.ku = -5;
            dVar.ko = (new Date().getTime() - time) - dVar.kr;
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            if (this.ki != null) {
                this.ki.schedule(this.kh, 45000L);
            }
            dVar.ku = -6;
            this.cT.dP().a(a, boundary, dVar);
            dVar.ku = -7;
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.ku = -8;
            this.cT.dQ().d(this.kc);
            dVar.kt = this.cT.dQ().responseCode;
            byte[] b = b(this.kc);
            if (b != null) {
                dVar.km = b.length;
                this.cT.dQ().kI = b.length;
                this.cT.dQ().kH = c(this.cT.dQ().contentEncoding, b);
            }
            dVar.kp = new Date().getTime() - time;
            dVar.ku = -9;
        } finally {
            if (this.ki != null) {
                this.ki.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.kc);
        }
    }

    public void c(int i, int i2, d dVar) {
        dVar.ku = -1;
        try {
            URL url = new URL(this.cT.dP().getUrl());
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.ku = -2;
            HttpURLConnection a = a(url);
            dVar.ku = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.kc == null) {
                throw new SocketException("network not available.");
            }
            this.kc.setRequestMethod("POST");
            this.kc.setDoOutput(true);
            this.kc.setDoInput(true);
            this.kc.setConnectTimeout(i2);
            this.kc.setReadTimeout(i);
            this.kc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            this.cT.dP().c(a);
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.kr = System.currentTimeMillis() - currentTimeMillis;
            dVar.ku = -4;
            a.connect();
            this.kd = System.currentTimeMillis();
            dVar.ku = -5;
            dVar.ko = (System.currentTimeMillis() - currentTimeMillis) - dVar.kr;
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.ku = -6;
            this.cT.dP().a(a, dVar);
            dVar.ku = -7;
            if (this.cT.dQ().kF) {
                throw new BdHttpCancelException();
            }
            dVar.ku = -8;
            this.cT.dQ().d(this.kc);
            dVar.kt = this.cT.dQ().responseCode;
            byte[] b = b(this.kc);
            if (b != null) {
                dVar.km = b.length;
                this.cT.dQ().kI = b.length;
                this.cT.dQ().kH = c(this.cT.dQ().contentEncoding, b);
            }
            dVar.kp = new Date().getTime() - currentTimeMillis;
            dVar.ku = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.kc);
        }
    }
}
