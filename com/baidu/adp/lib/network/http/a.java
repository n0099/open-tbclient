package com.baidu.adp.lib.network.http;

import android.net.Proxy;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetUtil;
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
    private static Pattern c = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String d = "--------7da3d81520810*";
    private e a;
    private HttpURLConnection b;
    private TimerTask e = new b(this);
    private Timer f;

    static {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.a = eVar;
    }

    public void a() {
        this.a.b().a = true;
        com.baidu.adp.lib.f.a.a(this.b);
    }

    private HttpURLConnection a(URL url) {
        String defaultHost;
        BdNetUtil.NetTpyeEnmu b = BdNetUtil.b();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (b == BdNetUtil.NetTpyeEnmu.UNAVAIL) {
            return null;
        }
        if ((b == BdNetUtil.NetTpyeEnmu.NET || b == BdNetUtil.NetTpyeEnmu.WAP) && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
            if (a(defaultHost)) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(Proxy.getDefaultHost());
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                this.b = (HttpURLConnection) new URL(sb.toString()).openConnection();
                this.a.a().b("X-Online-Host", url.getHost());
            } else {
                this.b = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
            }
        }
        if (this.b == null) {
            this.b = (HttpURLConnection) url.openConnection();
        }
        return this.b;
    }

    public void a(int i, int i2, d dVar) {
        dVar.j = -1;
        if (this.a.b().a) {
            throw new BdHttpCancelException();
        }
        String a = this.a.a().a(dVar);
        URL url = new URL(a);
        if (this.a.b().a) {
            throw new BdHttpCancelException();
        }
        dVar.j = -2;
        HttpURLConnection a2 = a(url);
        dVar.j = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.b == null) {
                throw new SocketException("network not available.");
            }
            this.b.setRequestMethod("GET");
            this.b.setConnectTimeout(i2);
            this.b.setReadTimeout(i);
            this.a.a().a(a2);
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.g = new Date().getTime() - currentTimeMillis;
            BdLog.i("GET:" + a);
            dVar.j = -4;
            a2.connect();
            dVar.j = -5;
            dVar.c = (new Date().getTime() - currentTimeMillis) - dVar.g;
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.j = -8;
            this.a.b().a(this.b);
            dVar.i = this.a.b().b;
            byte[] a3 = a(this.b);
            if (a3 != null) {
                dVar.b = a3.length;
                this.a.b().g = a(this.a.b().c, a3);
            }
            dVar.j = -9;
            dVar.d = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.b != null) {
                this.b.disconnect();
            }
        }
    }

    protected final byte[] a(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.e.a(byteArrayInputStream, byteArrayOutputStream);
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
                while (!this.a.b().a && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.f.a.a(inputStream);
                        throw th;
                    }
                }
                if (this.a.b().a) {
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
        com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.f.a.a(inputStream2);
        return bArr;
    }

    private boolean a(String str) {
        if (c.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public void b(int i, int i2, d dVar) {
        dVar.j = -1;
        try {
            URL url = new URL(this.a.a().b());
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.j = -2;
            HttpURLConnection a = a(url);
            dVar.j = -3;
            System.currentTimeMillis();
            if (this.b == null) {
                throw new SocketException("network not available.");
            }
            this.b.setRequestMethod("POST");
            this.b.setDoOutput(true);
            this.b.setDoInput(true);
            this.b.setConnectTimeout(i2);
            this.b.setReadTimeout(i);
            this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + d);
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            this.a.a().a(a);
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.g = new Date().getTime() - time;
            dVar.j = -4;
            a.connect();
            dVar.j = -5;
            dVar.c = (new Date().getTime() - time) - dVar.g;
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            if (this.f != null) {
                this.f.schedule(this.e, 45000L);
            }
            dVar.j = -6;
            this.a.a().a(a, d, dVar);
            dVar.j = -7;
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.j = -8;
            this.a.b().a(this.b);
            dVar.i = this.a.b().b;
            byte[] a2 = a(this.b);
            if (a2 != null) {
                dVar.b = a2.length;
                this.a.b().g = a(this.a.b().c, a2);
            }
            if (this.a.b().g != null) {
                dVar.b = this.a.b().g.length;
            }
            dVar.d = new Date().getTime() - time;
            dVar.j = -9;
        } finally {
            if (this.f != null) {
                this.f.cancel();
            }
            com.baidu.adp.lib.f.a.a(this.b);
        }
    }

    public void c(int i, int i2, d dVar) {
        dVar.j = -1;
        try {
            URL url = new URL(this.a.a().b());
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.j = -2;
            HttpURLConnection a = a(url);
            dVar.j = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.b == null) {
                throw new SocketException("network not available.");
            }
            this.b.setRequestMethod("POST");
            this.b.setDoOutput(true);
            this.b.setDoInput(true);
            this.b.setConnectTimeout(i2);
            this.b.setReadTimeout(i);
            this.b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            this.a.a().a(a);
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.g = System.currentTimeMillis() - currentTimeMillis;
            dVar.j = -4;
            a.connect();
            dVar.j = -5;
            dVar.c = (System.currentTimeMillis() - currentTimeMillis) - dVar.g;
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.j = -6;
            this.a.a().a(a, dVar);
            dVar.j = -7;
            if (this.a.b().a) {
                throw new BdHttpCancelException();
            }
            dVar.j = -8;
            this.a.b().a(this.b);
            dVar.i = this.a.b().b;
            byte[] a2 = a(this.b);
            if (a2 != null) {
                dVar.b = a2.length;
                this.a.b().h = a2.length;
                this.a.b().g = a(this.a.b().c, a2);
            }
            dVar.d = new Date().getTime() - currentTimeMillis;
            dVar.j = -9;
        } finally {
            com.baidu.adp.lib.f.a.a(this.b);
        }
    }
}
