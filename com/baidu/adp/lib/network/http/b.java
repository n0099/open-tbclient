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
    private f gV;
    private HttpURLConnection nQ;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long nR = 0;
    private long nS = 0;
    private long hr = 0;
    private long nT = 0;
    private long nU = 0;
    private boolean nV = false;
    private boolean nW = true;
    private TimerTask nX = new c(this);
    private Timer nY = new Timer();

    public long ea() {
        return this.nU;
    }

    public long eb() {
        return this.nT;
    }

    public long ec() {
        return this.nR;
    }

    public long ed() {
        return this.nS;
    }

    public long ee() {
        return this.hr;
    }

    public boolean ef() {
        return this.nV;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gV = fVar;
    }

    public void eg() {
        this.gV.eq().oD = true;
        com.baidu.adp.lib.h.a.f(this.nQ);
    }

    private URL a(String str, e eVar) throws Exception {
        a dZ;
        URL url = new URL(str);
        if (this.nW && (dZ = a.dZ()) != null) {
            String ad = dZ.ad(str);
            if (!TextUtils.isEmpty(ad)) {
                this.gV.ep().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ad));
                this.nV = true;
                eVar.oq = ad;
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
                            this.gV.ep().o("X-Online-Host", url.getHost());
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
        eVar.om = -1;
        if (this.gV.eq().oD) {
            throw new BdHttpCancelException();
        }
        String c = this.gV.ep().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gV.eq().oD) {
            throw new BdHttpCancelException();
        }
        eVar.om = -2;
        this.nQ = d(a);
        eVar.om = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.nQ == null) {
                throw new SocketException("network not available.");
            }
            this.nQ.setRequestMethod("GET");
            this.nQ.setConnectTimeout(i2);
            this.nQ.setReadTimeout(i);
            this.gV.ep().d(this.nQ);
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            eVar.oi = new Date().getTime() - currentTimeMillis;
            eVar.om = -4;
            this.nQ.connect();
            if (this.nR <= 0) {
                this.nR = System.currentTimeMillis();
            }
            this.nS = System.currentTimeMillis();
            eVar.om = -5;
            eVar.oe = (new Date().getTime() - currentTimeMillis) - eVar.oi;
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.nQ.getContentType();
            this.hr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nQ.disconnect();
                this.nQ.connect();
                if (this.gV.eq().oD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.om = -8;
            this.gV.eq().e(this.nQ);
            if (c.contains("c.tieba.baidu.com") && (map = this.gV.eq().oF) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null) {
                eVar.or = list.get(0);
                eVar.ot = list.get(1);
            }
            eVar.ol = this.gV.eq().responseCode;
            eVar.od = this.nQ.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.nQ);
            if (c2 != null) {
                eVar.od += c2.length;
                this.gV.eq().oG = c(this.gV.eq().contentEncoding, c2);
            }
            eVar.om = -9;
            eVar.of = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.nQ != null) {
                this.nQ.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.nU = System.currentTimeMillis();
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
                while (!this.gV.eq().oD && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.nT = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.gV.eq().oD) {
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
        this.nT = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.h.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.om = -1;
        try {
            String url = this.gV.ep().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            eVar.om = -2;
            this.nQ = d(a);
            eVar.om = -3;
            System.currentTimeMillis();
            if (this.nQ == null) {
                throw new SocketException("network not available.");
            }
            this.nQ.setRequestMethod("POST");
            this.nQ.setDoOutput(true);
            this.nQ.setDoInput(true);
            this.nQ.setConnectTimeout(i2);
            this.nQ.setReadTimeout(i);
            this.nQ.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            this.gV.ep().d(this.nQ);
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.oi = new Date().getTime() - time;
            eVar.om = -4;
            this.nQ.connect();
            if (this.nR <= 0) {
                this.nR = System.currentTimeMillis();
            }
            this.nS = System.currentTimeMillis();
            eVar.om = -5;
            eVar.oe = (new Date().getTime() - time) - eVar.oi;
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            if (this.nY != null) {
                this.nY.schedule(this.nX, 45000L);
            }
            eVar.om = -6;
            this.gV.ep().a(this.nQ, boundary, eVar);
            eVar.om = -7;
            String contentType = this.nQ.getContentType();
            this.hr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nQ.disconnect();
                this.nQ.connect();
                if (this.gV.eq().oD) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            eVar.om = -8;
            this.gV.eq().e(this.nQ);
            eVar.ol = this.gV.eq().responseCode;
            eVar.od = this.nQ.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.nQ);
            if (c != null) {
                eVar.od += c.length;
                this.gV.eq().oH = c.length;
                this.gV.eq().oG = c(this.gV.eq().contentEncoding, c);
            }
            eVar.of = new Date().getTime() - time;
            eVar.om = -9;
        } finally {
            if (this.nY != null) {
                this.nY.cancel();
            }
            com.baidu.adp.lib.h.a.f(this.nQ);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [685=6, 686=6, 687=6, 688=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gV.ep().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.nQ = b(a, i2, i);
            if (this.gV.eq().oD) {
                this.nT = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.j(null);
                com.baidu.adp.lib.h.a.f(this.nQ);
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
                this.gV.ep().d(this.nQ);
                this.nQ.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.nQ.connect();
                if (this.nR <= 0) {
                    this.nR = System.currentTimeMillis();
                }
                this.nS = System.currentTimeMillis();
                int responseCode = this.nQ.getResponseCode();
                this.hr = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.nQ.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.h.a.f(this.nQ);
                        this.nQ = b(new URL(url2.toString()), i2, i);
                        this.gV.ep().d(this.nQ);
                        this.nQ.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.nQ.connect();
                        responseCode = this.nQ.getResponseCode();
                    }
                }
                this.gV.eq().responseCode = responseCode;
                if (eh()) {
                    if (this.nQ.getContentType() != null && this.nQ.getContentType().contains("text/vnd.wap.wml")) {
                        this.nQ.disconnect();
                        this.gV.eq().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.nT = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.nQ);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.nQ.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gV.eq().responseCode == 200 && (headerField = this.nQ.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.gV.eq().contentLength = String.valueOf(g);
                    eVar2.oc = url.getBytes().length;
                    eVar2.od = this.nQ.getHeaderFields().toString().getBytes().length;
                    eVar2.od += g;
                    if (this.gV.eq().responseCode == 416 || this.gV.eq().responseCode == 204) {
                        this.nT = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.nQ);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.nT = System.currentTimeMillis();
                        this.nT = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.nQ);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.nQ.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.f((int) length, g);
                            }
                            while (!this.gV.eq().oD) {
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
                                this.nT = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.j(inputStream2);
                                com.baidu.adp.lib.h.a.f(this.nQ);
                                com.baidu.adp.lib.h.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.nT = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.j(inputStream);
                            com.baidu.adp.lib.h.a.f(this.nQ);
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
        return this.gV.eq().responseCode == 200 || this.gV.eq().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.om = -1;
        try {
            String url = this.gV.ep().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            eVar.om = -2;
            this.nQ = d(a);
            eVar.om = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.nQ == null) {
                throw new SocketException("network not available.");
            }
            this.nQ.setRequestMethod("POST");
            this.nQ.setDoOutput(true);
            this.nQ.setDoInput(true);
            this.nQ.setConnectTimeout(i2);
            this.nQ.setReadTimeout(i);
            this.nQ.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            this.gV.ep().d(this.nQ);
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            eVar.oi = System.currentTimeMillis() - currentTimeMillis;
            eVar.om = -4;
            this.nQ.connect();
            if (this.nR <= 0) {
                this.nR = System.currentTimeMillis();
            }
            this.nS = System.currentTimeMillis();
            eVar.om = -5;
            eVar.oe = (System.currentTimeMillis() - currentTimeMillis) - eVar.oi;
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            eVar.om = -6;
            this.gV.ep().a(this.nQ, eVar);
            eVar.om = -7;
            if (this.gV.eq().oD) {
                throw new BdHttpCancelException();
            }
            String contentType = this.nQ.getContentType();
            this.hr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nQ.disconnect();
                this.nQ.connect();
                if (this.gV.eq().oD) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.om = -8;
            this.gV.eq().e(this.nQ);
            eVar.ol = this.gV.eq().responseCode;
            eVar.od = this.nQ.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.nQ);
            if (c != null) {
                eVar.od += c.length;
                this.gV.eq().oH = c.length;
                this.gV.eq().oG = c(this.gV.eq().contentEncoding, c);
            }
            eVar.of = new Date().getTime() - currentTimeMillis;
            eVar.om = -9;
        } finally {
            com.baidu.adp.lib.h.a.f(this.nQ);
        }
    }
}
