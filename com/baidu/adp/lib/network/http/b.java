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
    private f oj;
    private HttpURLConnection vc;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long vd = 0;
    private long ve = 0;
    private long oI = 0;
    private long vf = 0;
    private long vg = 0;
    private boolean vh = false;
    private boolean vi = true;
    private TimerTask vj = new c(this);
    private Timer vk = new Timer();

    public long fl() {
        return this.vg;
    }

    public long fm() {
        return this.vf;
    }

    public long fn() {
        return this.vd;
    }

    public long fo() {
        return this.ve;
    }

    public long fp() {
        return this.oI;
    }

    public boolean fq() {
        return this.vh;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.oj = fVar;
    }

    public void fr() {
        this.oj.fB().vL = true;
        com.baidu.adp.lib.g.a.g(this.vc);
    }

    private URL a(String str, e eVar) throws Exception {
        a fk;
        URL url = new URL(str);
        if (this.vi && (fk = a.fk()) != null) {
            String Z = fk.Z(str);
            if (!TextUtils.isEmpty(Z)) {
                this.oj.fA().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + Z));
                this.vh = true;
                eVar.vz = Z;
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
                    if (com.baidu.adp.lib.util.i.aA(ht) && com.baidu.adp.lib.util.i.hv()) {
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
                            this.oj.fA().o("X-Online-Host", url.getHost());
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
        eVar.vx = -1;
        if (this.oj.fB().vL) {
            throw new BdHttpCancelException();
        }
        String c = this.oj.fA().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.oj.fB().vL) {
            throw new BdHttpCancelException();
        }
        eVar.vx = -2;
        this.vc = c(a);
        eVar.vx = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.vc == null) {
                throw new SocketException("network not available.");
            }
            this.vc.setRequestMethod("GET");
            this.vc.setConnectTimeout(i2);
            this.vc.setReadTimeout(i);
            this.oj.fA().e(this.vc);
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            eVar.vu = new Date().getTime() - currentTimeMillis;
            eVar.vx = -4;
            this.vc.connect();
            if (this.vd <= 0) {
                this.vd = System.currentTimeMillis();
            }
            this.ve = System.currentTimeMillis();
            eVar.vx = -5;
            eVar.vq = (new Date().getTime() - currentTimeMillis) - eVar.vu;
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vc.getContentType();
            this.oI = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ac(contentType)) {
                this.vc.disconnect();
                this.vc.connect();
                if (this.oj.fB().vL) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vx = -8;
            this.oj.fB().f(this.vc);
            if (c.contains("c.tieba.baidu.com") && (map = this.oj.fB().vN) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.vA = list.get(0);
                eVar.vB = list.get(1);
            }
            eVar.vw = this.oj.fB().responseCode;
            eVar.vp = this.vc.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vc);
            if (d != null) {
                eVar.vp += d.length;
                this.oj.fB().vO = c(this.oj.fB().contentEncoding, d);
            }
            eVar.vx = -9;
            eVar.vr = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.vc != null) {
                this.vc.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.vg = System.currentTimeMillis();
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
                while (!this.oj.fB().vL && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.vf = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.oj.fB().vL) {
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
        this.vf = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.vx = -1;
        try {
            String url = this.oj.fA().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            eVar.vx = -2;
            this.vc = c(a);
            eVar.vx = -3;
            System.currentTimeMillis();
            if (this.vc == null) {
                throw new SocketException("network not available.");
            }
            this.vc.setRequestMethod("POST");
            this.vc.setDoOutput(true);
            this.vc.setDoInput(true);
            this.vc.setConnectTimeout(i2);
            this.vc.setReadTimeout(i);
            this.vc.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            this.oj.fA().e(this.vc);
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.vu = new Date().getTime() - time;
            eVar.vx = -4;
            this.vc.connect();
            if (this.vd <= 0) {
                this.vd = System.currentTimeMillis();
            }
            this.ve = System.currentTimeMillis();
            eVar.vx = -5;
            eVar.vq = (new Date().getTime() - time) - eVar.vu;
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            if (this.vk != null) {
                this.vk.schedule(this.vj, 45000L);
            }
            eVar.vx = -6;
            this.oj.fA().a(this.vc, boundary, eVar);
            eVar.vx = -7;
            String contentType = this.vc.getContentType();
            this.oI = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ac(contentType)) {
                this.vc.disconnect();
                this.vc.connect();
                if (this.oj.fB().vL) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            eVar.vx = -8;
            this.oj.fB().f(this.vc);
            eVar.vw = this.oj.fB().responseCode;
            eVar.vp = this.vc.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vc);
            if (d != null) {
                eVar.vp += d.length;
                this.oj.fB().vP = d.length;
                this.oj.fB().vO = c(this.oj.fB().contentEncoding, d);
            }
            eVar.vr = new Date().getTime() - time;
            eVar.vx = -9;
        } finally {
            if (this.vk != null) {
                this.vk.cancel();
            }
            com.baidu.adp.lib.g.a.g(this.vc);
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
            String url = this.oj.fA().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.vc = b(a, i2, i);
            if (this.oj.fB().vL) {
                this.vf = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.g(this.vc);
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
                this.oj.fA().e(this.vc);
                this.vc.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.vc.connect();
                if (this.vd <= 0) {
                    this.vd = System.currentTimeMillis();
                }
                this.ve = System.currentTimeMillis();
                int responseCode = this.vc.getResponseCode();
                this.oI = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.vc.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.g(this.vc);
                        this.vc = b(new URL(url2.toString()), i2, i);
                        this.oj.fA().e(this.vc);
                        this.vc.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.vc.connect();
                        responseCode = this.vc.getResponseCode();
                    }
                }
                this.oj.fB().responseCode = responseCode;
                if (fs()) {
                    if (this.vc.getContentType() != null && this.vc.getContentType().contains("text/vnd.wap.wml")) {
                        this.vc.disconnect();
                        this.oj.fB().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.vf = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vc);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.vc.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.oj.fB().responseCode == 200 && (headerField = this.vc.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.oj.fB().contentLength = String.valueOf(g);
                    eVar2.vo = url.getBytes().length;
                    eVar2.vp = this.vc.getHeaderFields().toString().getBytes().length;
                    eVar2.vp += g;
                    if (this.oj.fB().responseCode == 416 || this.oj.fB().responseCode == 204) {
                        this.vf = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vc);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.vf = System.currentTimeMillis();
                        this.vf = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.g(this.vc);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.vc.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.m((int) length, g);
                            }
                            while (!this.oj.fB().vL) {
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
                                this.vf = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.j(inputStream2);
                                com.baidu.adp.lib.g.a.g(this.vc);
                                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.vf = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.j(inputStream);
                            com.baidu.adp.lib.g.a.g(this.vc);
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
        return this.oj.fB().responseCode == 200 || this.oj.fB().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.vx = -1;
        try {
            String url = this.oj.fA().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            eVar.vx = -2;
            this.vc = c(a);
            eVar.vx = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.vc == null) {
                throw new SocketException("network not available.");
            }
            this.vc.setRequestMethod("POST");
            this.vc.setDoOutput(true);
            this.vc.setDoInput(true);
            this.vc.setConnectTimeout(i2);
            this.vc.setReadTimeout(i);
            this.vc.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            this.oj.fA().e(this.vc);
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            eVar.vu = System.currentTimeMillis() - currentTimeMillis;
            eVar.vx = -4;
            this.vc.connect();
            if (this.vd <= 0) {
                this.vd = System.currentTimeMillis();
            }
            this.ve = System.currentTimeMillis();
            eVar.vx = -5;
            eVar.vq = (System.currentTimeMillis() - currentTimeMillis) - eVar.vu;
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            eVar.vx = -6;
            this.oj.fA().a(this.vc, eVar);
            eVar.vx = -7;
            if (this.oj.fB().vL) {
                throw new BdHttpCancelException();
            }
            String contentType = this.vc.getContentType();
            this.oI = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ac(contentType)) {
                this.vc.disconnect();
                this.vc.connect();
                if (this.oj.fB().vL) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.vx = -8;
            this.oj.fB().f(this.vc);
            eVar.vw = this.oj.fB().responseCode;
            eVar.vp = this.vc.getHeaderFields().toString().getBytes().length;
            byte[] d = d(this.vc);
            if (d != null) {
                eVar.vp += d.length;
                this.oj.fB().vP = d.length;
                this.oj.fB().vO = c(this.oj.fB().contentEncoding, d);
            }
            eVar.vr = new Date().getTime() - currentTimeMillis;
            eVar.vx = -9;
        } finally {
            com.baidu.adp.lib.g.a.g(this.vc);
        }
    }
}
