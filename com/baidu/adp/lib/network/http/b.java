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
    private f ol;
    private HttpURLConnection vi;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long vj = 0;
    private long vk = 0;
    private long oJ = 0;
    private long vl = 0;
    private long vm = 0;
    private boolean vn = false;
    private boolean vo = true;
    private TimerTask vp = new c(this);
    private Timer vq = new Timer();

    public long fm() {
        return this.vm;
    }

    public long fn() {
        return this.vl;
    }

    public long fo() {
        return this.vj;
    }

    public long fp() {
        return this.vk;
    }

    public long fq() {
        return this.oJ;
    }

    public boolean fr() {
        return this.vn;
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

    public void fs() {
        this.ol.fC().vQ = true;
        com.baidu.adp.lib.g.a.g(this.vi);
    }

    private URL a(String str, e eVar) throws Exception {
        a fl;
        URL url = new URL(str);
        if (this.vo && (fl = a.fl()) != null) {
            String Z = fl.Z(str);
            if (!TextUtils.isEmpty(Z)) {
                this.ol.fB().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + Z));
                this.vn = true;
                eVar.vE = Z;
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
        String hu;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.hk()) {
                if (com.baidu.adp.lib.util.i.hm() && (hu = com.baidu.adp.lib.util.i.hu()) != null && hu.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aA(hu) && com.baidu.adp.lib.util.i.hw()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(hu);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.ol.fB().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hu, com.baidu.adp.lib.util.i.hv())));
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
        eVar.vC = -1;
        if (this.ol.fC().vQ) {
            throw new BdHttpCancelException();
        }
        String c = this.ol.fB().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.ol.fC().vQ) {
            throw new BdHttpCancelException();
        }
        eVar.vC = -2;
        this.vi = c(a);
        eVar.vC = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.vi == null) {
                throw new SocketException("network not available.");
            }
            this.vi.setRequestMethod("GET");
            this.vi.setConnectTimeout(i2);
            this.vi.setReadTimeout(i);
            this.ol.fB().e(this.vi);
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            eVar.vz = new Date().getTime() - currentTimeMillis;
            eVar.vC = -4;
            this.vi.connect();
            if (this.vj <= 0) {
                this.vj = System.currentTimeMillis();
            }
            this.vk = System.currentTimeMillis();
            eVar.vC = -5;
            eVar.connectTime = (new Date().getTime() - currentTimeMillis) - eVar.vz;
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vi.getContentType();
            this.oJ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ac(contentType)) {
                this.vi.disconnect();
                this.vi.connect();
                if (this.ol.fC().vQ) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vC = -8;
            this.ol.fC().f(this.vi);
            if (c.contains("c.tieba.baidu.com") && (map = this.ol.fC().vS) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.vF = list.get(0);
                eVar.vG = list.get(1);
            }
            eVar.vB = this.ol.fC().responseCode;
            eVar.vv = this.vi.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vi);
            if (d != null) {
                eVar.vv += d.length;
                this.ol.fC().vT = c(this.ol.fC().contentEncoding, d);
            }
            eVar.vC = -9;
            eVar.vw = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.vi != null) {
                this.vi.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.vm = System.currentTimeMillis();
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
                while (!this.ol.fC().vQ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.vl = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.ol.fC().vQ) {
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
        this.vl = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.vC = -1;
        try {
            String url = this.ol.fB().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            eVar.vC = -2;
            this.vi = c(a);
            eVar.vC = -3;
            System.currentTimeMillis();
            if (this.vi == null) {
                throw new SocketException("network not available.");
            }
            this.vi.setRequestMethod("POST");
            this.vi.setDoOutput(true);
            this.vi.setDoInput(true);
            this.vi.setConnectTimeout(i2);
            this.vi.setReadTimeout(i);
            this.vi.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            this.ol.fB().e(this.vi);
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.vz = new Date().getTime() - time;
            eVar.vC = -4;
            this.vi.connect();
            if (this.vj <= 0) {
                this.vj = System.currentTimeMillis();
            }
            this.vk = System.currentTimeMillis();
            eVar.vC = -5;
            eVar.connectTime = (new Date().getTime() - time) - eVar.vz;
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            if (this.vq != null) {
                this.vq.schedule(this.vp, 45000L);
            }
            eVar.vC = -6;
            this.ol.fB().a(this.vi, boundary, eVar);
            eVar.vC = -7;
            String contentType = this.vi.getContentType();
            this.oJ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ac(contentType)) {
                this.vi.disconnect();
                this.vi.connect();
                if (this.ol.fC().vQ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            eVar.vC = -8;
            this.ol.fC().f(this.vi);
            eVar.vB = this.ol.fC().responseCode;
            eVar.vv = this.vi.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vi);
            if (d != null) {
                eVar.vv += d.length;
                this.ol.fC().vU = d.length;
                this.ol.fC().vT = c(this.ol.fC().contentEncoding, d);
            }
            eVar.vw = new Date().getTime() - time;
            eVar.vC = -9;
        } finally {
            if (this.vq != null) {
                this.vq.cancel();
            }
            com.baidu.adp.lib.g.a.g(this.vi);
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
            String url = this.ol.fB().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.vi = b(a, i2, i);
            if (this.ol.fC().vQ) {
                this.vl = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.g(this.vi);
                com.baidu.adp.lib.g.a.d(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.at(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.ol.fB().e(this.vi);
                this.vi.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.vi.connect();
                if (this.vj <= 0) {
                    this.vj = System.currentTimeMillis();
                }
                this.vk = System.currentTimeMillis();
                int responseCode = this.vi.getResponseCode();
                this.oJ = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.vi.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.g(this.vi);
                        this.vi = b(new URL(url2.toString()), i2, i);
                        this.ol.fB().e(this.vi);
                        this.vi.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.vi.connect();
                        responseCode = this.vi.getResponseCode();
                    }
                }
                this.ol.fC().responseCode = responseCode;
                if (ft()) {
                    if (this.vi.getContentType() != null && this.vi.getContentType().contains("text/vnd.wap.wml")) {
                        this.vi.disconnect();
                        this.ol.fC().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.vl = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vi);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.vi.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.ol.fC().responseCode == 200 && (headerField = this.vi.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.ol.fC().contentLength = String.valueOf(g);
                    eVar2.vu = url.getBytes().length;
                    eVar2.vv = this.vi.getHeaderFields().toString().getBytes().length;
                    eVar2.vv += g;
                    if (this.ol.fC().responseCode == 416 || this.ol.fC().responseCode == 204) {
                        this.vl = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vi);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.vl = System.currentTimeMillis();
                        this.vl = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vi);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.vi.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.m((int) length, g);
                            }
                            while (!this.ol.fC().vQ) {
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
                                this.vl = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.j(inputStream2);
                                com.baidu.adp.lib.g.a.g(this.vi);
                                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.vl = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.j(inputStream);
                            com.baidu.adp.lib.g.a.g(this.vi);
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

    private boolean ft() {
        return this.ol.fC().responseCode == 200 || this.ol.fC().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.vC = -1;
        try {
            String url = this.ol.fB().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            eVar.vC = -2;
            this.vi = c(a);
            eVar.vC = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.vi == null) {
                throw new SocketException("network not available.");
            }
            this.vi.setRequestMethod("POST");
            this.vi.setDoOutput(true);
            this.vi.setDoInput(true);
            this.vi.setConnectTimeout(i2);
            this.vi.setReadTimeout(i);
            this.vi.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            this.ol.fB().e(this.vi);
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            eVar.vz = System.currentTimeMillis() - currentTimeMillis;
            eVar.vC = -4;
            this.vi.connect();
            if (this.vj <= 0) {
                this.vj = System.currentTimeMillis();
            }
            this.vk = System.currentTimeMillis();
            eVar.vC = -5;
            eVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - eVar.vz;
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            eVar.vC = -6;
            this.ol.fB().a(this.vi, eVar);
            eVar.vC = -7;
            if (this.ol.fC().vQ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vi.getContentType();
            this.oJ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ac(contentType)) {
                this.vi.disconnect();
                this.vi.connect();
                if (this.ol.fC().vQ) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vC = -8;
            this.ol.fC().f(this.vi);
            eVar.vB = this.ol.fC().responseCode;
            eVar.vv = this.vi.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vi);
            if (d != null) {
                eVar.vv += d.length;
                this.ol.fC().vU = d.length;
                this.ol.fC().vT = c(this.ol.fC().contentEncoding, d);
            }
            eVar.vw = new Date().getTime() - currentTimeMillis;
            eVar.vC = -9;
        } finally {
            com.baidu.adp.lib.g.a.g(this.vi);
        }
    }
}
