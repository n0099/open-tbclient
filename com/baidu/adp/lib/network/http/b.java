package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
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
    private f ol;
    private HttpURLConnection vh;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long vi = 0;
    private long vj = 0;
    private long oJ = 0;
    private long vk = 0;
    private long vl = 0;
    private boolean vm = false;
    private boolean vn = true;
    private TimerTask vo = new c(this);
    private Timer vp = new Timer();

    public long fl() {
        return this.vl;
    }

    public long fm() {
        return this.vk;
    }

    public long fn() {
        return this.vi;
    }

    public long fo() {
        return this.vj;
    }

    public long fp() {
        return this.oJ;
    }

    public boolean fq() {
        return this.vm;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.ol = fVar;
    }

    public void fr() {
        this.ol.fB().vP = true;
        com.baidu.adp.lib.g.a.g(this.vh);
    }

    private URL a(String str, e eVar) throws Exception {
        a fk;
        URL url = new URL(str);
        if (this.vn && (fk = a.fk()) != null) {
            String ae = fk.ae(str);
            if (!TextUtils.isEmpty(ae)) {
                this.ol.fA().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ae));
                this.vm = true;
                eVar.vD = ae;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection b(URL url, int i, int i2) throws SocketException {
        HttpURLConnection c = c(url);
        if (c != null) {
            c.setConnectTimeout(i);
            c.setReadTimeout(i2);
            return c;
        }
        throw new SocketException();
    }

    private HttpURLConnection c(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String ht;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.hj()) {
                if (com.baidu.adp.lib.util.i.hl() && (ht = com.baidu.adp.lib.util.i.ht()) != null && ht.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aF(ht) && com.baidu.adp.lib.util.i.hv()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(ht);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.ol.fA().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ht, com.baidu.adp.lib.util.i.hu())));
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
        eVar.vB = -1;
        if (this.ol.fB().vP) {
            throw new BdHttpCancelException();
        }
        String c = this.ol.fA().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.ol.fB().vP) {
            throw new BdHttpCancelException();
        }
        eVar.vB = -2;
        this.vh = c(a);
        eVar.vB = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.vh == null) {
                throw new SocketException("network not available.");
            }
            this.vh.setRequestMethod("GET");
            this.vh.setConnectTimeout(i2);
            this.vh.setReadTimeout(i);
            this.ol.fA().e(this.vh);
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            eVar.vy = new Date().getTime() - currentTimeMillis;
            eVar.vB = -4;
            this.vh.connect();
            if (this.vi <= 0) {
                this.vi = System.currentTimeMillis();
            }
            this.vj = System.currentTimeMillis();
            eVar.vB = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.vy;
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vh.getContentType();
            this.oJ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.vh.disconnect();
                this.vh.connect();
                if (this.ol.fB().vP) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vB = -8;
            this.ol.fB().f(this.vh);
            if (c.contains("c.tieba.baidu.com") && (map = this.ol.fB().vR) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.vE = list.get(0);
                eVar.vF = list.get(1);
            }
            eVar.vA = this.ol.fB().responseCode;
            eVar.vu = this.vh.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vh);
            if (d != null) {
                eVar.vu += d.length;
                this.ol.fB().vS = c(this.ol.fB().contentEncoding, d);
            }
            eVar.vB = -9;
            eVar.vv = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.vh != null) {
                this.vh.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.vl = System.currentTimeMillis();
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
                while (!this.ol.fB().vP && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.vk = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.ol.fB().vP) {
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
        this.vk = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.vB = -1;
        try {
            String url = this.ol.fA().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            eVar.vB = -2;
            this.vh = c(a);
            eVar.vB = -3;
            System.currentTimeMillis();
            if (this.vh == null) {
                throw new SocketException("network not available.");
            }
            this.vh.setRequestMethod("POST");
            this.vh.setDoOutput(true);
            this.vh.setDoInput(true);
            this.vh.setConnectTimeout(i2);
            this.vh.setReadTimeout(i);
            this.vh.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            this.ol.fA().e(this.vh);
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.vy = new Date().getTime() - time;
            eVar.vB = -4;
            this.vh.connect();
            if (this.vi <= 0) {
                this.vi = System.currentTimeMillis();
            }
            this.vj = System.currentTimeMillis();
            eVar.vB = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.vy;
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            if (this.vp != null) {
                this.vp.schedule(this.vo, 45000L);
            }
            eVar.vB = -6;
            this.ol.fA().a(this.vh, boundary, eVar);
            eVar.vB = -7;
            String contentType = this.vh.getContentType();
            this.oJ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.vh.disconnect();
                this.vh.connect();
                if (this.ol.fB().vP) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            eVar.vB = -8;
            this.ol.fB().f(this.vh);
            eVar.vA = this.ol.fB().responseCode;
            eVar.vu = this.vh.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vh);
            if (d != null) {
                eVar.vu += d.length;
                this.ol.fB().vT = d.length;
                this.ol.fB().vS = c(this.ol.fB().contentEncoding, d);
            }
            eVar.vv = new Date().getTime() - time;
            eVar.vB = -9;
        } finally {
            if (this.vp != null) {
                this.vp.cancel();
            }
            com.baidu.adp.lib.g.a.g(this.vh);
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
            String url = this.ol.fA().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.vh = b(a, i2, i);
            if (this.ol.fB().vP) {
                this.vk = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.g(this.vh);
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
                this.ol.fA().e(this.vh);
                this.vh.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.vh.connect();
                if (this.vi <= 0) {
                    this.vi = System.currentTimeMillis();
                }
                this.vj = System.currentTimeMillis();
                int responseCode = this.vh.getResponseCode();
                this.oJ = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.vh.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.g(this.vh);
                        this.vh = b(new URL(url2.toString()), i2, i);
                        this.ol.fA().e(this.vh);
                        this.vh.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.vh.connect();
                        responseCode = this.vh.getResponseCode();
                    }
                }
                this.ol.fB().responseCode = responseCode;
                if (fs()) {
                    if (this.vh.getContentType() != null && this.vh.getContentType().contains("text/vnd.wap.wml")) {
                        this.vh.disconnect();
                        this.ol.fB().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.vk = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vh);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.vh.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.ol.fB().responseCode == 200 && (headerField = this.vh.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.ol.fB().contentLength = String.valueOf(g);
                    eVar2.vt = url.getBytes().length;
                    eVar2.vu = this.vh.getHeaderFields().toString().getBytes().length;
                    eVar2.vu += g;
                    if (this.ol.fB().responseCode == 416 || this.ol.fB().responseCode == 204) {
                        this.vk = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vh);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.vk = System.currentTimeMillis();
                        this.vk = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vh);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.vh.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.m((int) length, g);
                            }
                            while (!this.ol.fB().vP) {
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
                                this.vk = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.j(inputStream2);
                                com.baidu.adp.lib.g.a.g(this.vh);
                                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.vk = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.j(inputStream);
                            com.baidu.adp.lib.g.a.g(this.vh);
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

    private boolean fs() {
        return this.ol.fB().responseCode == 200 || this.ol.fB().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.vB = -1;
        try {
            String url = this.ol.fA().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            eVar.vB = -2;
            this.vh = c(a);
            eVar.vB = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.vh == null) {
                throw new SocketException("network not available.");
            }
            this.vh.setRequestMethod("POST");
            this.vh.setDoOutput(true);
            this.vh.setDoInput(true);
            this.vh.setConnectTimeout(i2);
            this.vh.setReadTimeout(i);
            this.vh.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            this.ol.fA().e(this.vh);
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            eVar.vy = System.currentTimeMillis() - currentTimeMillis;
            eVar.vB = -4;
            this.vh.connect();
            if (this.vi <= 0) {
                this.vi = System.currentTimeMillis();
            }
            this.vj = System.currentTimeMillis();
            eVar.vB = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.vy;
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            eVar.vB = -6;
            this.ol.fA().a(this.vh, eVar);
            eVar.vB = -7;
            if (this.ol.fB().vP) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vh.getContentType();
            this.oJ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.vh.disconnect();
                this.vh.connect();
                if (this.ol.fB().vP) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vB = -8;
            this.ol.fB().f(this.vh);
            eVar.vA = this.ol.fB().responseCode;
            eVar.vu = this.vh.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vh);
            if (d != null) {
                eVar.vu += d.length;
                this.ol.fB().vT = d.length;
                this.ol.fB().vS = c(this.ol.fB().contentEncoding, d);
            }
            eVar.vv = new Date().getTime() - currentTimeMillis;
            eVar.vB = -9;
        } finally {
            com.baidu.adp.lib.g.a.g(this.vh);
        }
    }
}
