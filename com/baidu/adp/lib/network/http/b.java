package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
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
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private f eg;
    private HttpURLConnection kS;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long kT = 0;
    private long kU = 0;
    private long eC = 0;
    private long kV = 0;
    private long kW = 0;
    private boolean kX = false;
    private boolean kY = true;
    private TimerTask kZ = new c(this);
    private Timer la = new Timer();

    public long dg() {
        return this.kW;
    }

    public long dh() {
        return this.kV;
    }

    public long di() {
        return this.kT;
    }

    public long dj() {
        return this.kU;
    }

    public long dk() {
        return this.eC;
    }

    public boolean dl() {
        return this.kX;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.eg = fVar;
    }

    public void dm() {
        this.eg.dw().lD = true;
        com.baidu.adp.lib.h.a.e(this.kS);
    }

    private URL a(String str, e eVar) {
        a df;
        URL url = new URL(str);
        if (this.kY && (df = a.df()) != null) {
            String aa = df.aa(str);
            if (!TextUtils.isEmpty(aa)) {
                this.eg.dv().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aa));
                this.kX = true;
                eVar.lp = aa;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection a(URL url, int i, int i2) {
        HttpURLConnection d = d(url);
        if (d != null) {
            d.setConnectTimeout(i);
            d.setReadTimeout(i2);
            return d;
        }
        throw new SocketException();
    }

    private HttpURLConnection d(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String fB;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.fr()) {
                if (com.baidu.adp.lib.util.i.ft() && (fB = com.baidu.adp.lib.util.i.fB()) != null && fB.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aK(fB) && com.baidu.adp.lib.util.i.fD()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(fB);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.eg.dv().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fB, com.baidu.adp.lib.util.i.fC())));
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

    public void a(int i, int i2, e eVar) {
        Map<String, List<String>> map;
        List<String> list;
        eVar.ln = -1;
        if (this.eg.dw().lD) {
            throw new BdHttpCancelException();
        }
        String c = this.eg.dv().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.eg.dw().lD) {
            throw new BdHttpCancelException();
        }
        eVar.ln = -2;
        this.kS = d(a);
        eVar.ln = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.kS == null) {
                throw new SocketException("network not available.");
            }
            this.kS.setRequestMethod("GET");
            this.kS.setConnectTimeout(i2);
            this.kS.setReadTimeout(i);
            this.eg.dv().c(this.kS);
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lk = new Date().getTime() - currentTimeMillis;
            eVar.ln = -4;
            this.kS.connect();
            if (this.kT <= 0) {
                this.kT = System.currentTimeMillis();
            }
            this.kU = System.currentTimeMillis();
            eVar.ln = -5;
            eVar.lg = (new Date().getTime() - currentTimeMillis) - eVar.lk;
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.kS.getContentType();
            this.eC = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ae(contentType)) {
                this.kS.disconnect();
                this.kS.connect();
                if (this.eg.dw().lD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.ln = -8;
            this.eg.dw().d(this.kS);
            if (c.contains("c.tieba.baidu.com") && (map = this.eg.dw().lF) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null) {
                eVar.lq = list.get(0);
                eVar.lr = list.get(1);
            }
            eVar.lm = this.eg.dw().responseCode;
            eVar.lf = this.kS.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.kS);
            if (b != null) {
                eVar.lf += b.length;
                this.eg.dw().lG = c(this.eg.dw().contentEncoding, b);
            }
            eVar.ln = -9;
            eVar.lh = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.kS != null) {
                this.kS.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.kW = System.currentTimeMillis();
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
                while (!this.eg.dw().lD && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.kV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.c(inputStream);
                        throw th;
                    }
                }
                if (this.eg.dw().lD) {
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
        this.kV = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.h.a.c(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) {
        eVar.ln = -1;
        try {
            String url = this.eg.dv().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            eVar.ln = -2;
            this.kS = d(a);
            eVar.ln = -3;
            System.currentTimeMillis();
            if (this.kS == null) {
                throw new SocketException("network not available.");
            }
            this.kS.setRequestMethod("POST");
            this.kS.setDoOutput(true);
            this.kS.setDoInput(true);
            this.kS.setConnectTimeout(i2);
            this.kS.setReadTimeout(i);
            this.kS.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            this.eg.dv().c(this.kS);
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.lk = new Date().getTime() - time;
            eVar.ln = -4;
            this.kS.connect();
            if (this.kT <= 0) {
                this.kT = System.currentTimeMillis();
            }
            this.kU = System.currentTimeMillis();
            eVar.ln = -5;
            eVar.lg = (new Date().getTime() - time) - eVar.lk;
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            if (this.la != null) {
                this.la.schedule(this.kZ, 45000L);
            }
            eVar.ln = -6;
            this.eg.dv().a(this.kS, boundary, eVar);
            eVar.ln = -7;
            String contentType = this.kS.getContentType();
            this.eC = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ae(contentType)) {
                this.kS.disconnect();
                this.kS.connect();
                if (this.eg.dw().lD) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            eVar.ln = -8;
            this.eg.dw().d(this.kS);
            eVar.lm = this.eg.dw().responseCode;
            eVar.lf = this.kS.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.kS);
            if (b != null) {
                eVar.lf += b.length;
                this.eg.dw().lH = b.length;
                this.eg.dw().lG = c(this.eg.dw().contentEncoding, b);
            }
            eVar.lh = new Date().getTime() - time;
            eVar.ln = -9;
        } finally {
            if (this.la != null) {
                this.la.cancel();
            }
            com.baidu.adp.lib.h.a.e(this.kS);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [685=6, 686=6, 687=6, 688=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.eg.dv().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.kS = a(a, i2, i);
            if (this.eg.dw().lD) {
                this.kV = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.c(null);
                com.baidu.adp.lib.h.a.e(this.kS);
                com.baidu.adp.lib.h.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aE(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aC(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.eg.dv().c(this.kS);
                this.kS.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.kS.connect();
                if (this.kT <= 0) {
                    this.kT = System.currentTimeMillis();
                }
                this.kU = System.currentTimeMillis();
                int responseCode = this.kS.getResponseCode();
                this.eC = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.kS.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.h.a.e(this.kS);
                        this.kS = a(new URL(url2.toString()), i2, i);
                        this.eg.dv().c(this.kS);
                        this.kS.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.kS.connect();
                        responseCode = this.kS.getResponseCode();
                    }
                }
                this.eg.dw().responseCode = responseCode;
                if (dn()) {
                    if (this.kS.getContentType() != null && this.kS.getContentType().contains("text/vnd.wap.wml")) {
                        this.kS.disconnect();
                        this.eg.dw().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.kV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.kS);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.kS.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.eg.dw().responseCode == 200 && (headerField = this.kS.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.eg.dw().contentLength = String.valueOf(g);
                    eVar2.le = url.getBytes().length;
                    eVar2.lf = this.kS.getHeaderFields().toString().getBytes().length;
                    eVar2.lf += g;
                    if (this.eg.dw().responseCode == 416 || this.eg.dw().responseCode == 204) {
                        this.kV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.kS);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.kV = System.currentTimeMillis();
                        this.kV = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.c(null);
                        com.baidu.adp.lib.h.a.e(this.kS);
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.kS.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.d((int) length, g);
                            }
                            while (!this.eg.dw().lD) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (iVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            iVar.d((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.kV = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.c(inputStream2);
                                com.baidu.adp.lib.h.a.e(this.kS);
                                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.kV = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.c(inputStream);
                            com.baidu.adp.lib.h.a.e(this.kS);
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

    private boolean dn() {
        return this.eg.dw().responseCode == 200 || this.eg.dw().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) {
        eVar.ln = -1;
        try {
            String url = this.eg.dv().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            eVar.ln = -2;
            this.kS = d(a);
            eVar.ln = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.kS == null) {
                throw new SocketException("network not available.");
            }
            this.kS.setRequestMethod("POST");
            this.kS.setDoOutput(true);
            this.kS.setDoInput(true);
            this.kS.setConnectTimeout(i2);
            this.kS.setReadTimeout(i);
            this.kS.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            this.eg.dv().c(this.kS);
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            eVar.lk = System.currentTimeMillis() - currentTimeMillis;
            eVar.ln = -4;
            this.kS.connect();
            if (this.kT <= 0) {
                this.kT = System.currentTimeMillis();
            }
            this.kU = System.currentTimeMillis();
            eVar.ln = -5;
            eVar.lg = (System.currentTimeMillis() - currentTimeMillis) - eVar.lk;
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            eVar.ln = -6;
            this.eg.dv().a(this.kS, eVar);
            eVar.ln = -7;
            if (this.eg.dw().lD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.kS.getContentType();
            this.eC = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ae(contentType)) {
                this.kS.disconnect();
                this.kS.connect();
                if (this.eg.dw().lD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.ln = -8;
            this.eg.dw().d(this.kS);
            eVar.lm = this.eg.dw().responseCode;
            eVar.lf = this.kS.getHeaderFields().toString().getBytes().length;
            byte[] b = b(this.kS);
            if (b != null) {
                eVar.lf += b.length;
                this.eg.dw().lH = b.length;
                this.eg.dw().lG = c(this.eg.dw().contentEncoding, b);
            }
            eVar.lh = new Date().getTime() - currentTimeMillis;
            eVar.ln = -9;
        } finally {
            com.baidu.adp.lib.h.a.e(this.kS);
        }
    }
}
