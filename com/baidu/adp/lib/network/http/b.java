package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    private f oO;
    private HttpURLConnection vz;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long vA = 0;
    private long vB = 0;
    private long po = 0;
    private long vC = 0;
    private long vD = 0;
    private boolean vE = false;
    private boolean vF = true;
    private TimerTask vG = new c(this);
    private Timer vH = new Timer();

    public long fg() {
        return this.vD;
    }

    public long fh() {
        return this.vC;
    }

    public long fi() {
        return this.vA;
    }

    public long fj() {
        return this.vB;
    }

    public long fk() {
        return this.po;
    }

    public boolean fl() {
        return this.vE;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.oO = fVar;
    }

    public void fm() {
        this.oO.fw().wi = true;
        com.baidu.adp.lib.g.a.g(this.vz);
    }

    private URL a(String str, e eVar) throws Exception {
        a ff;
        URL url = new URL(str);
        if (this.vF && (ff = a.ff()) != null) {
            String ac = ff.ac(str);
            if (!TextUtils.isEmpty(ac)) {
                this.oO.fv().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ac));
                this.vE = true;
                eVar.vW = ac;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection b(URL url, int i, int i2) throws SocketException {
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
        String ho;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.he()) {
                if (com.baidu.adp.lib.util.i.hg() && (ho = com.baidu.adp.lib.util.i.ho()) != null && ho.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aF(ho) && com.baidu.adp.lib.util.i.hq()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(ho);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.oO.fv().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ho, com.baidu.adp.lib.util.i.hp())));
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

    public void a(int i, int i2, e eVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        eVar.vU = -1;
        if (this.oO.fw().wi) {
            throw new BdHttpCancelException();
        }
        String c = this.oO.fv().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.oO.fw().wi) {
            throw new BdHttpCancelException();
        }
        eVar.vU = -2;
        this.vz = d(a);
        eVar.vU = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.vz == null) {
                throw new SocketException("network not available.");
            }
            this.vz.setRequestMethod("GET");
            this.vz.setConnectTimeout(i2);
            this.vz.setReadTimeout(i);
            this.oO.fv().e(this.vz);
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            eVar.vR = new Date().getTime() - currentTimeMillis;
            eVar.vU = -4;
            this.vz.connect();
            if (this.vA <= 0) {
                this.vA = System.currentTimeMillis();
            }
            this.vB = System.currentTimeMillis();
            eVar.vU = -5;
            eVar.vN = (new Date().getTime() - currentTimeMillis) - eVar.vR;
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vz.getContentType();
            this.po = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ag(contentType)) {
                this.vz.disconnect();
                this.vz.connect();
                if (this.oO.fw().wi) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vU = -8;
            this.oO.fw().f(this.vz);
            if (c.contains("c.tieba.baidu.com") && (map = this.oO.fw().wk) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.vX = list.get(0);
                eVar.vY = list.get(1);
            }
            eVar.vT = this.oO.fw().responseCode;
            eVar.vM = this.vz.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vz);
            if (d != null) {
                eVar.vM += d.length;
                this.oO.fw().wl = c(this.oO.fw().contentEncoding, d);
            }
            eVar.vU = -9;
            eVar.vO = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.vz != null) {
                this.vz.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.vD = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] d(HttpURLConnection httpURLConnection) throws Exception {
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
                while (!this.oO.fw().wi && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.vC = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.oO.fw().wi) {
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
        this.vC = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.vU = -1;
        try {
            String url = this.oO.fv().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            eVar.vU = -2;
            this.vz = d(a);
            eVar.vU = -3;
            System.currentTimeMillis();
            if (this.vz == null) {
                throw new SocketException("network not available.");
            }
            this.vz.setRequestMethod("POST");
            this.vz.setDoOutput(true);
            this.vz.setDoInput(true);
            this.vz.setConnectTimeout(i2);
            this.vz.setReadTimeout(i);
            this.vz.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            this.oO.fv().e(this.vz);
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.vR = new Date().getTime() - time;
            eVar.vU = -4;
            this.vz.connect();
            if (this.vA <= 0) {
                this.vA = System.currentTimeMillis();
            }
            this.vB = System.currentTimeMillis();
            eVar.vU = -5;
            eVar.vN = (new Date().getTime() - time) - eVar.vR;
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            if (this.vH != null) {
                this.vH.schedule(this.vG, 45000L);
            }
            eVar.vU = -6;
            this.oO.fv().a(this.vz, boundary, eVar);
            eVar.vU = -7;
            String contentType = this.vz.getContentType();
            this.po = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ag(contentType)) {
                this.vz.disconnect();
                this.vz.connect();
                if (this.oO.fw().wi) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            eVar.vU = -8;
            this.oO.fw().f(this.vz);
            eVar.vT = this.oO.fw().responseCode;
            eVar.vM = this.vz.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vz);
            if (d != null) {
                eVar.vM += d.length;
                this.oO.fw().wm = d.length;
                this.oO.fw().wl = c(this.oO.fw().contentEncoding, d);
            }
            eVar.vO = new Date().getTime() - time;
            eVar.vU = -9;
        } finally {
            if (this.vH != null) {
                this.vH.cancel();
            }
            com.baidu.adp.lib.g.a.g(this.vz);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [684=6, 685=6, 686=6, 687=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.oO.fv().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.vz = b(a, i2, i);
            if (this.oO.fw().wi) {
                this.vC = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.g(this.vz);
                com.baidu.adp.lib.g.a.d(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.ay(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.oO.fv().e(this.vz);
                this.vz.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.vz.connect();
                if (this.vA <= 0) {
                    this.vA = System.currentTimeMillis();
                }
                this.vB = System.currentTimeMillis();
                int responseCode = this.vz.getResponseCode();
                this.po = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.vz.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.g(this.vz);
                        this.vz = b(new URL(url2.toString()), i2, i);
                        this.oO.fv().e(this.vz);
                        this.vz.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.vz.connect();
                        responseCode = this.vz.getResponseCode();
                    }
                }
                this.oO.fw().responseCode = responseCode;
                if (fn()) {
                    if (this.vz.getContentType() != null && this.vz.getContentType().contains("text/vnd.wap.wml")) {
                        this.vz.disconnect();
                        this.oO.fw().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.vC = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vz);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.vz.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oO.fw().responseCode == 200 && (headerField = this.vz.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.oO.fw().contentLength = String.valueOf(g);
                    eVar2.vL = url.getBytes().length;
                    eVar2.vM = this.vz.getHeaderFields().toString().getBytes().length;
                    eVar2.vM += g;
                    if (this.oO.fw().responseCode == 416 || this.oO.fw().responseCode == 204) {
                        this.vC = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vz);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.vC = System.currentTimeMillis();
                        this.vC = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vz);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.vz.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.m((int) length, g);
                            }
                            while (!this.oO.fw().wi) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (iVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            iVar.m((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.vC = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.j(inputStream2);
                                com.baidu.adp.lib.g.a.g(this.vz);
                                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.vC = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.j(inputStream);
                            com.baidu.adp.lib.g.a.g(this.vz);
                            com.baidu.adp.lib.g.a.d(fileOutputStream);
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

    private boolean fn() {
        return this.oO.fw().responseCode == 200 || this.oO.fw().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.vU = -1;
        try {
            String url = this.oO.fv().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            eVar.vU = -2;
            this.vz = d(a);
            eVar.vU = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.vz == null) {
                throw new SocketException("network not available.");
            }
            this.vz.setRequestMethod("POST");
            this.vz.setDoOutput(true);
            this.vz.setDoInput(true);
            this.vz.setConnectTimeout(i2);
            this.vz.setReadTimeout(i);
            this.vz.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            this.oO.fv().e(this.vz);
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            eVar.vR = System.currentTimeMillis() - currentTimeMillis;
            eVar.vU = -4;
            this.vz.connect();
            if (this.vA <= 0) {
                this.vA = System.currentTimeMillis();
            }
            this.vB = System.currentTimeMillis();
            eVar.vU = -5;
            eVar.vN = (System.currentTimeMillis() - currentTimeMillis) - eVar.vR;
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            eVar.vU = -6;
            this.oO.fv().a(this.vz, eVar);
            eVar.vU = -7;
            if (this.oO.fw().wi) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vz.getContentType();
            this.po = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ag(contentType)) {
                this.vz.disconnect();
                this.vz.connect();
                if (this.oO.fw().wi) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vU = -8;
            this.oO.fw().f(this.vz);
            eVar.vT = this.oO.fw().responseCode;
            eVar.vM = this.vz.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vz);
            if (d != null) {
                eVar.vM += d.length;
                this.oO.fw().wm = d.length;
                this.oO.fw().wl = c(this.oO.fw().contentEncoding, d);
            }
            eVar.vO = new Date().getTime() - currentTimeMillis;
            eVar.vU = -9;
        } finally {
            com.baidu.adp.lib.g.a.g(this.vz);
        }
    }
}
