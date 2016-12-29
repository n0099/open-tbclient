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
    private f gW;
    private HttpURLConnection nR;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long nS = 0;
    private long nT = 0;
    private long hs = 0;
    private long nU = 0;
    private long nV = 0;
    private boolean nW = false;
    private boolean nX = true;
    private TimerTask nY = new c(this);
    private Timer nZ = new Timer();

    public long ea() {
        return this.nV;
    }

    public long eb() {
        return this.nU;
    }

    public long ec() {
        return this.nS;
    }

    public long ed() {
        return this.nT;
    }

    public long ee() {
        return this.hs;
    }

    public boolean ef() {
        return this.nW;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gW = fVar;
    }

    public void eg() {
        this.gW.eq().oE = true;
        com.baidu.adp.lib.h.a.f(this.nR);
    }

    private URL a(String str, e eVar) throws Exception {
        a dZ;
        URL url = new URL(str);
        if (this.nX && (dZ = a.dZ()) != null) {
            String ad = dZ.ad(str);
            if (!TextUtils.isEmpty(ad)) {
                this.gW.ep().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ad));
                this.nW = true;
                eVar.or = ad;
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
        String gw;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.gm()) {
                if (com.baidu.adp.lib.util.i.go() && (gw = com.baidu.adp.lib.util.i.gw()) != null && gw.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aM(gw) && com.baidu.adp.lib.util.i.gy()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(gw);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gW.ep().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(gw, com.baidu.adp.lib.util.i.gx())));
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
        eVar.oo = -1;
        if (this.gW.eq().oE) {
            throw new BdHttpCancelException();
        }
        String c = this.gW.ep().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gW.eq().oE) {
            throw new BdHttpCancelException();
        }
        eVar.oo = -2;
        this.nR = d(a);
        eVar.oo = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.nR == null) {
                throw new SocketException("network not available.");
            }
            this.nR.setRequestMethod("GET");
            this.nR.setConnectTimeout(i2);
            this.nR.setReadTimeout(i);
            this.gW.ep().d(this.nR);
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            eVar.oj = new Date().getTime() - currentTimeMillis;
            eVar.oo = -4;
            this.nR.connect();
            if (this.nS <= 0) {
                this.nS = System.currentTimeMillis();
            }
            this.nT = System.currentTimeMillis();
            eVar.oo = -5;
            eVar.of = (new Date().getTime() - currentTimeMillis) - eVar.oj;
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            String contentType = this.nR.getContentType();
            this.hs = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nR.disconnect();
                this.nR.connect();
                if (this.gW.eq().oE) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.oo = -8;
            this.gW.eq().e(this.nR);
            if (c.contains("c.tieba.baidu.com") && (map = this.gW.eq().oG) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.ot = list.get(0);
                eVar.ou = list.get(1);
            }
            eVar.om = this.gW.eq().responseCode;
            eVar.oe = this.nR.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.nR);
            if (c2 != null) {
                eVar.oe += c2.length;
                this.gW.eq().oH = c(this.gW.eq().contentEncoding, c2);
            }
            eVar.oo = -9;
            eVar.og = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.nR != null) {
                this.nR.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.nV = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] c(HttpURLConnection httpURLConnection) throws Exception {
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
                while (!this.gW.eq().oE && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.nU = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.gW.eq().oE) {
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
        this.nU = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.h.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.oo = -1;
        try {
            String url = this.gW.ep().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            eVar.oo = -2;
            this.nR = d(a);
            eVar.oo = -3;
            System.currentTimeMillis();
            if (this.nR == null) {
                throw new SocketException("network not available.");
            }
            this.nR.setRequestMethod("POST");
            this.nR.setDoOutput(true);
            this.nR.setDoInput(true);
            this.nR.setConnectTimeout(i2);
            this.nR.setReadTimeout(i);
            this.nR.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            this.gW.ep().d(this.nR);
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.oj = new Date().getTime() - time;
            eVar.oo = -4;
            this.nR.connect();
            if (this.nS <= 0) {
                this.nS = System.currentTimeMillis();
            }
            this.nT = System.currentTimeMillis();
            eVar.oo = -5;
            eVar.of = (new Date().getTime() - time) - eVar.oj;
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            if (this.nZ != null) {
                this.nZ.schedule(this.nY, 45000L);
            }
            eVar.oo = -6;
            this.gW.ep().a(this.nR, boundary, eVar);
            eVar.oo = -7;
            String contentType = this.nR.getContentType();
            this.hs = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nR.disconnect();
                this.nR.connect();
                if (this.gW.eq().oE) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            eVar.oo = -8;
            this.gW.eq().e(this.nR);
            eVar.om = this.gW.eq().responseCode;
            eVar.oe = this.nR.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.nR);
            if (c != null) {
                eVar.oe += c.length;
                this.gW.eq().oI = c.length;
                this.gW.eq().oH = c(this.gW.eq().contentEncoding, c);
            }
            eVar.og = new Date().getTime() - time;
            eVar.oo = -9;
        } finally {
            if (this.nZ != null) {
                this.nZ.cancel();
            }
            com.baidu.adp.lib.h.a.f(this.nR);
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
            String url = this.gW.ep().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.nR = b(a, i2, i);
            if (this.gW.eq().oE) {
                this.nU = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.j(null);
                com.baidu.adp.lib.h.a.f(this.nR);
                com.baidu.adp.lib.h.a.d(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aF(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gW.ep().d(this.nR);
                this.nR.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.nR.connect();
                if (this.nS <= 0) {
                    this.nS = System.currentTimeMillis();
                }
                this.nT = System.currentTimeMillis();
                int responseCode = this.nR.getResponseCode();
                this.hs = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.nR.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.h.a.f(this.nR);
                        this.nR = b(new URL(url2.toString()), i2, i);
                        this.gW.ep().d(this.nR);
                        this.nR.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.nR.connect();
                        responseCode = this.nR.getResponseCode();
                    }
                }
                this.gW.eq().responseCode = responseCode;
                if (eh()) {
                    if (this.nR.getContentType() != null && this.nR.getContentType().contains("text/vnd.wap.wml")) {
                        this.nR.disconnect();
                        this.gW.eq().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.nU = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.nR);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.nR.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gW.eq().responseCode == 200 && (headerField = this.nR.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.gW.eq().contentLength = String.valueOf(g);
                    eVar2.od = url.getBytes().length;
                    eVar2.oe = this.nR.getHeaderFields().toString().getBytes().length;
                    eVar2.oe += g;
                    if (this.gW.eq().responseCode == 416 || this.gW.eq().responseCode == 204) {
                        this.nU = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.nR);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.nU = System.currentTimeMillis();
                        this.nU = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.nR);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.nR.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.f((int) length, g);
                            }
                            while (!this.gW.eq().oE) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (iVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            iVar.f((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.nU = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.j(inputStream2);
                                com.baidu.adp.lib.h.a.f(this.nR);
                                com.baidu.adp.lib.h.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.nU = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.j(inputStream);
                            com.baidu.adp.lib.h.a.f(this.nR);
                            com.baidu.adp.lib.h.a.d(fileOutputStream);
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

    private boolean eh() {
        return this.gW.eq().responseCode == 200 || this.gW.eq().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.oo = -1;
        try {
            String url = this.gW.ep().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            eVar.oo = -2;
            this.nR = d(a);
            eVar.oo = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.nR == null) {
                throw new SocketException("network not available.");
            }
            this.nR.setRequestMethod("POST");
            this.nR.setDoOutput(true);
            this.nR.setDoInput(true);
            this.nR.setConnectTimeout(i2);
            this.nR.setReadTimeout(i);
            this.nR.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            this.gW.ep().d(this.nR);
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            eVar.oj = System.currentTimeMillis() - currentTimeMillis;
            eVar.oo = -4;
            this.nR.connect();
            if (this.nS <= 0) {
                this.nS = System.currentTimeMillis();
            }
            this.nT = System.currentTimeMillis();
            eVar.oo = -5;
            eVar.of = (System.currentTimeMillis() - currentTimeMillis) - eVar.oj;
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            eVar.oo = -6;
            this.gW.ep().a(this.nR, eVar);
            eVar.oo = -7;
            if (this.gW.eq().oE) {
                throw new BdHttpCancelException();
            }
            String contentType = this.nR.getContentType();
            this.hs = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nR.disconnect();
                this.nR.connect();
                if (this.gW.eq().oE) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.oo = -8;
            this.gW.eq().e(this.nR);
            eVar.om = this.gW.eq().responseCode;
            eVar.oe = this.nR.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.nR);
            if (c != null) {
                eVar.oe += c.length;
                this.gW.eq().oI = c.length;
                this.gW.eq().oH = c(this.gW.eq().contentEncoding, c);
            }
            eVar.og = new Date().getTime() - currentTimeMillis;
            eVar.oo = -9;
        } finally {
            com.baidu.adp.lib.h.a.f(this.nR);
        }
    }
}
