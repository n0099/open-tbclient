package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.xiaomi.mipush.sdk.Constants;
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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e sM;
    private HttpURLConnection zl;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long zm = 0;
    private long zn = 0;
    private long th = 0;
    private long zo = 0;
    private long zp = 0;
    private boolean zq = false;
    private boolean zr = true;
    private TimerTask zs = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zt = new Timer();

    public long hH() {
        return this.zp;
    }

    public long hI() {
        return this.zo;
    }

    public long hJ() {
        return this.zm;
    }

    public long hK() {
        return this.zn;
    }

    public long hL() {
        return this.th;
    }

    public boolean hM() {
        return this.zq;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.sM = eVar;
    }

    public void hN() {
        this.sM.hX().zT = true;
        com.baidu.adp.lib.g.a.f(this.zl);
    }

    private URL a(String str, d dVar) throws Exception {
        a hG;
        URL url = new URL(str);
        if (this.zr && (hG = a.hG()) != null) {
            String ay = hG.ay(str);
            if (!TextUtils.isEmpty(ay)) {
                this.sM.hW().p("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ay));
                this.zq = true;
                dVar.zH = ay;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection a(URL url, int i, int i2) throws SocketException {
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
        String jO;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.jE()) {
                if (j.jG() && (jO = j.jO()) != null && jO.length() > 0) {
                    if (j.be(jO) && j.jQ()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jO);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.sM.hW().p("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jO, j.jP())));
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

    public void a(int i, int i2, d dVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        dVar.zF = -1;
        if (this.sM.hX().zT) {
            throw new BdHttpCancelException();
        }
        String c = this.sM.hW().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.sM.hX().zT) {
            throw new BdHttpCancelException();
        }
        dVar.zF = -2;
        this.zl = c(a);
        dVar.zF = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zl == null) {
                throw new SocketException("network not available.");
            }
            this.zl.setRequestMethod("GET");
            this.zl.setConnectTimeout(i2);
            this.zl.setReadTimeout(i);
            this.sM.hW().d(this.zl);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            dVar.zC = new Date().getTime() - currentTimeMillis;
            dVar.zF = -4;
            this.zl.connect();
            if (this.zm <= 0) {
                this.zm = System.currentTimeMillis();
            }
            this.zn = System.currentTimeMillis();
            dVar.zF = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.zC;
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zl.getContentType();
            this.th = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aE(contentType)) {
                this.zl.disconnect();
                this.zl.connect();
                if (this.sM.hX().zT) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zF = -8;
            this.sM.hX().e(this.zl);
            if (c.contains("c.tieba.baidu.com") && (map = this.sM.hX().zV) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.zI = list.get(0);
                dVar.zJ = list.get(1);
            }
            dVar.zE = this.sM.hX().responseCode;
            dVar.zy = this.zl.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zl);
            if (c2 != null) {
                dVar.zy += c2.length;
                this.sM.hX().zW = c(this.sM.hX().contentEncoding, c2);
            }
            dVar.zF = -9;
            dVar.zz = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zl != null) {
                this.zl.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zp = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.zp == 0) {
            this.zp = System.currentTimeMillis();
            return bArr;
        } else {
            return bArr;
        }
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
                while (!this.sM.hX().zT && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.sM.hX().zT) {
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
        this.zo = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.zF = -1;
        try {
            String url = this.sM.hW().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            dVar.zF = -2;
            this.zl = c(a);
            dVar.zF = -3;
            System.currentTimeMillis();
            if (this.zl == null) {
                throw new SocketException("network not available.");
            }
            this.zl.setRequestMethod("POST");
            this.zl.setDoOutput(true);
            this.zl.setDoInput(true);
            this.zl.setConnectTimeout(i2);
            this.zl.setReadTimeout(i);
            this.zl.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            this.sM.hW().d(this.zl);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.zC = new Date().getTime() - time;
            dVar.zF = -4;
            this.zl.connect();
            if (this.zm <= 0) {
                this.zm = System.currentTimeMillis();
            }
            this.zn = System.currentTimeMillis();
            dVar.zF = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.zC;
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            if (this.zt != null) {
                this.zt.schedule(this.zs, 45000L);
            }
            dVar.zF = -6;
            this.sM.hW().a(this.zl, boundary, dVar);
            dVar.zF = -7;
            String contentType = this.zl.getContentType();
            this.th = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aE(contentType)) {
                this.zl.disconnect();
                this.zl.connect();
                if (this.sM.hX().zT) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            dVar.zF = -8;
            this.sM.hX().e(this.zl);
            dVar.zE = this.sM.hX().responseCode;
            dVar.zy = this.zl.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zl);
            if (c != null) {
                dVar.zy += c.length;
                this.sM.hX().zX = c.length;
                this.sM.hX().zW = c(this.sM.hX().contentEncoding, c);
            }
            dVar.zz = new Date().getTime() - time;
            dVar.zF = -9;
        } finally {
            if (this.zt != null) {
                this.zt.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zl);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [687=8, 688=6, 689=6, 690=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url = this.sM.hW().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.zl = a(a, i2, i);
            if (this.sM.hX().zT) {
                this.zo = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zl);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aY(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aW(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.sM.hW().d(this.zl);
                this.zl.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zl.connect();
                if (this.zm <= 0) {
                    this.zm = System.currentTimeMillis();
                }
                this.zn = System.currentTimeMillis();
                int responseCode = this.zl.getResponseCode();
                this.th = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.zl.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.zl);
                        this.zl = a(new URL(url2.toString()), i2, i);
                        this.sM.hW().d(this.zl);
                        this.zl.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.zl.connect();
                        responseCode = this.zl.getResponseCode();
                    }
                }
                this.sM.hX().responseCode = responseCode;
                if (hO()) {
                    if (this.zl.getContentType() != null && this.zl.getContentType().contains("text/vnd.wap.wml")) {
                        this.zl.disconnect();
                        this.sM.hX().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zl);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.zl.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.sM.hX().responseCode == 200 && (headerField = this.zl.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.sM.hX().contentLength = String.valueOf(g);
                    dVar2.zx = url.getBytes().length;
                    dVar2.zy = this.zl.getHeaderFields().toString().getBytes().length;
                    dVar2.zy += g;
                    if (this.sM.hX().responseCode == 416 || this.sM.hX().responseCode == 204) {
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zl);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zo = System.currentTimeMillis();
                        this.zo = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zl);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zl.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.sM.hX().zT) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            hVar.m((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.zo = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zl);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zo = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zl);
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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

    private boolean hO() {
        return this.sM.hX().responseCode == 200 || this.sM.hX().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.zF = -1;
        try {
            String url = this.sM.hW().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            dVar.zF = -2;
            this.zl = c(a);
            dVar.zF = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zl == null) {
                throw new SocketException("network not available.");
            }
            this.zl.setRequestMethod("POST");
            this.zl.setDoOutput(true);
            this.zl.setDoInput(true);
            this.zl.setConnectTimeout(i2);
            this.zl.setReadTimeout(i);
            this.zl.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            this.sM.hW().d(this.zl);
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            dVar.zC = System.currentTimeMillis() - currentTimeMillis;
            dVar.zF = -4;
            this.zl.connect();
            if (this.zm <= 0) {
                this.zm = System.currentTimeMillis();
            }
            this.zn = System.currentTimeMillis();
            dVar.zF = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.zC;
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            dVar.zF = -6;
            this.sM.hW().a(this.zl, dVar);
            dVar.zF = -7;
            if (this.sM.hX().zT) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zl.getContentType();
            this.th = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aE(contentType)) {
                this.zl.disconnect();
                this.zl.connect();
                if (this.sM.hX().zT) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zF = -8;
            this.sM.hX().e(this.zl);
            dVar.zE = this.sM.hX().responseCode;
            dVar.zy = this.zl.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zl);
            if (c != null) {
                dVar.zy += c.length;
                this.sM.hX().zX = c.length;
                this.sM.hX().zW = c(this.sM.hX().contentEncoding, c);
            }
            dVar.zz = new Date().getTime() - currentTimeMillis;
            dVar.zF = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zl);
        }
    }
}
